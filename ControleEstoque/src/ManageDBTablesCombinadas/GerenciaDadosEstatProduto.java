package ManageDBTablesCombinadas;

import DB.Database;
import ManageDBTables.GerenciaProdutoFinal;
import TabelasBDCombinadas.DadosEstatProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.List;

public class GerenciaDadosEstatProduto {

    public static ObservableList<DadosEstatProduto> SelectDadosEstatProdutos(){
        try {
            // lista de tuplas que irá para a tabela da cena
            ObservableList<DadosEstatProduto> dadosEstatProdutos = FXCollections.observableArrayList();

            // lista com o nome de todos os produtos
            List<String> produtos = GerenciaProdutoFinal.SelectProdutosFinaisNome();

            ResultSet rs;
            for(String produto : produtos){
                rs = Database.ExecuteSelect("SELECT SUM(Producao.qtde) FROM ProdutoFinal, Producao WHERE ProdutoFinal.cod = Producao.codProd AND ProdutoFinal.nome = '" + produto + "';");
                while(rs.next()){
                    dadosEstatProdutos.add(new DadosEstatProduto(produto, rs.getInt(1), 0));
                }
            }

            for(DadosEstatProduto dadosEstatProduto : dadosEstatProdutos){
                rs = Database.ExecuteSelect("SELECT SUM(VendaProd.qtdeProd) FROM ProdutoFinal, VendaProd WHERE ProdutoFinal.cod = VendaProd.codProd AND ProdutoFinal.nome = '" + dadosEstatProduto.getNomeProduto() + "';");
                while (rs.next()){
                    dadosEstatProduto.setQtdeVendida(rs.getInt(1));
                }
            }

            return dadosEstatProdutos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
