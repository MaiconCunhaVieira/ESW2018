package Controller.GerenciaTabelasBDCombinadas;

import Controller.DB.Database;
import Controller.GerenciaTabelasBD.GerenciaGastos;
import Model.TabelasBD.Gastos;
import Model.TabelasBDCombinadas.DadosEstatGastos;
import Model.TabelasBDCombinadas.ProdutoPrecoVendaQtde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaDadosEstatGastos {

    private static String pesquisaProdPrecoVendaQtde =
            "SELECT ProdutoFinal.preco, VendaProd.qtdeProd " +
                    "FROM ProdutoFinal, VendaProd " +
                    "WHERE ProdutoFinal.cod = VendaProd.codProd AND VendaProd.data::date >= ";

    private static String restoPesquisaProdPrecoVendaQtde = " AND VendaProd.data::date < ";

    private static String pesquisaComprasPreco =
            "SELECT CompraIngred.preco " +
                    "FROM CompraIngred " +
                    "WHERE CompraIngred.data::date >= ";

    private static String restoPesquisaComprasPreco = " AND CompraIngred.data::date < ";

    public static ObservableList<DadosEstatGastos> SelectDadosEstatGastos(){
        try {
            // todos as tuplas de gastos
            List<Gastos> gastos = GerenciaGastos.SelectGastos();

            // lista que será retornada
            ObservableList<DadosEstatGastos> dadosEstatGastos = FXCollections.observableArrayList();

            // para cada tupla Gasto no BD
            for(int i = 0; i < gastos.size(); i++){
                // cada elemento é o preço do produto e a quantidade vendida do produto, sendo a venda ocorrida entre o gasto do laço e o gasto seguinte
                List<ProdutoPrecoVendaQtde> prodPrecoVendaQtde = new ArrayList<>();

                // cada elemento é o preço de uma compra ocorrida entre o gasto do laço e o gasto seguinte
                List<Float> compraPreco = new ArrayList<>();

                ResultSet rsVendas, rsCompras;

                // se não é o último gasto inserido
                if(i < gastos.size() - 1){
                    // tuplas de preço de produto/qtde de venda para vendas que ocorreram depois do gasto do laço e antes do gasto seguinte
                    rsVendas = Database.ExecuteSelect(pesquisaProdPrecoVendaQtde + "'" + gastos.get(i).getData() + "'" + restoPesquisaProdPrecoVendaQtde + "'" + gastos.get(i+1).getData() + "';");
                    // tuplas de preço de compras que ocorreram depois do gasto do laço e antes do gasto seguinte
                    rsCompras = Database.ExecuteSelect(pesquisaComprasPreco + "'" + gastos.get(i).getData() + "'" + restoPesquisaComprasPreco + "'" + gastos.get(i+1).getData() + "';");
                }
                else {
                    // tuplas de preço de produto/qtde de venda para vendas que ocorreram depois do gasto do laço
                    rsVendas = Database.ExecuteSelect(pesquisaProdPrecoVendaQtde + "'" + gastos.get(i).getData() + "';");
                    // tuplas de preço de compras que ocorreram depois do gasto do laço
                    rsCompras = Database.ExecuteSelect(pesquisaComprasPreco + "'" + gastos.get(i).getData() + "';");
                }

                // adiciona cada preço de produto/qtde de venda lida do BD na lista
                while(rsVendas.next()){
                    prodPrecoVendaQtde.add(new ProdutoPrecoVendaQtde(rsVendas.getFloat(1), rsVendas.getInt(2)));
                }

                // adiciona cada preço de compra lido do BD na lista
                while (rsCompras.next()){
                    compraPreco.add(rsCompras.getFloat(1));
                }

                // calcula total de lucro vindo das vendas de produtos
                float totalGanhoVendas = 0;
                for(ProdutoPrecoVendaQtde precoQtde: prodPrecoVendaQtde){
                    totalGanhoVendas += precoQtde.getPrecoProd() * precoQtde.getQtdeVendida();
                }

                // calcula total de gastos vindo das compras de ingredientes
                float totalGastosCompras = 0;
                for(Float cP : compraPreco){
                    totalGastosCompras += cP;
                }

                // calcula total de gastos vindo dos gastos gerais
                int totalGastosGasto = gastos.get(i).getLuz() + gastos.get(i).getAgua() + gastos.get(i).getFuncionarios() + gastos.get(i).getOutros();

                // calcula total de lucro (se positivo, fábrica lucrou naquele período, se negativo, fábrica teve prejuízo naquele período)
                float totalLucro = totalGanhoVendas - (totalGastosCompras + totalGastosGasto);

                // insere valores calculados na lista que irá para a tabela
                dadosEstatGastos.add(new DadosEstatGastos(gastos.get(i).getData(), totalGastosGasto, (int)totalGastosCompras, (int)totalGanhoVendas, (int)totalLucro));
            }

            return dadosEstatGastos;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
