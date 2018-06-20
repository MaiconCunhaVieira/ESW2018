package Controller.GerenciaTabelasBDCombinadas;

import Controller.DB.Database;
import Model.TabelasBDCombinadas.ProdutoFinalReceita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public abstract class GerenciaProdutoFinalReceita {

    private static String pesquisaReceita =
            "SELECT ProdutoFinal.nome, Ingrediente.nome, Receita.qtdeIngred " +
                    "FROM ProdutoFinal, Ingrediente, Receita " +
                    "WHERE Receita.codProd = ProdutoFinal.cod AND Receita.codIngred = Ingrediente.cod AND Receita.codProd = ";

    // Faz a pesquisa da receita de um único produto, retornando não só os dados da receita como também o nome do produto e o nome do ingrediente da receita
    public static ObservableList<ProdutoFinalReceita> SelectReceita(int codProd){
        try{
            ObservableList<ProdutoFinalReceita> receita = FXCollections.observableArrayList();
            ResultSet rs = Database.ExecuteSelect(pesquisaReceita + codProd + ";");
            while (rs.next()){
                receita.addAll(new ProdutoFinalReceita(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return receita;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
