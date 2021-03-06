package Controller.GerenciaTabelasBDCombinadas;

import Controller.DB.Database;
import Model.TabelasBDCombinadas.FornecIngredCompra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public abstract class GerenciaFornecIngredCompra {

    private static String pesquisaCompraIngred =
            "SELECT Fornecedor.nome, Ingrediente.nome, CompraIngred.data, CompraIngred.hora, CompraIngred.qtdeIngred, CompraIngred.preco " +
                    "FROM CompraIngred, Fornecedor, Ingrediente " +
                    "WHERE CompraIngred.codIngred = Ingrediente.cod AND CompraIngred.CNPJFornec = Fornecedor.CNPJ;";

    // Faz a pesquisa de todas as compras de ingredientes, retornando não só os dados da compra como também o nome do ingrediente comprado e o nome do fornecedor que vendeu
    public static ObservableList<FornecIngredCompra> SelectCompraIngred(){
        try{
            ObservableList<FornecIngredCompra> comprasIngred = FXCollections.observableArrayList();
            ResultSet rs = Database.ExecuteSelect(pesquisaCompraIngred);
            while(rs.next()){
                comprasIngred.add(new FornecIngredCompra(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getTime(4).toLocalTime(), rs.getInt(5), rs.getFloat(6)));
            }
            return comprasIngred;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
