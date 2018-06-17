package ManageDBTablesCombinadas;

import DB.Database;
import TabelasBDCombinadas.VendaProdClienteProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public abstract class GerenciaClienteProdutoVenda {

    private static String pesquisaVendaProd =
            "SELECT Cliente.nome, ProdutoFinal.nome, VendaProd.data, VendaProd.hora, VendaProd.qtdeProd, ProdutoFinal.preco " +
                    "FROM Cliente, ProdutoFinal, VendaProd " +
                    "WHERE VendaProd.CNPJCLiente = Cliente.CNPJ AND VendaProd.codProd = ProdutoFinal.cod;";

    // Faz a pesquisa de todas as vendas feitas, retornando não só os dados da venda como também o nome do produto vendido e o nome do cliente que comprou
    public static ObservableList<VendaProdClienteProduto> SelectClienteProdutoVenda(){
        try{
            ObservableList<VendaProdClienteProduto> vendasProdFinal = FXCollections.observableArrayList();
            ResultSet rs = Database.ExecuteSelect(pesquisaVendaProd);
            while(rs.next()){
                vendasProdFinal.add(new VendaProdClienteProduto(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getTime(4).toLocalTime(), rs.getInt(5), rs.getFloat(6) * (float)rs.getInt(5)));
            }
            return vendasProdFinal;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
