package Controller.GerenciaTabelasBD;

import Controller.DB.Database;
import Model.TabelasBD.Ingrediente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaIngredientes {

    private static String selectIngred = "SELECT * FROM Ingrediente";
    private static String selectIngredNome = "SELECT nome FROM Ingrediente";

    // Faz a pesquisa de todos os ingredientes, retornando uma lista de ingredientes
    public static List<Ingrediente> SelectIngredientes(){
        try {
            // salva o resultado da pesquisa de todos os ingredientes
            ResultSet rs = Database.ExecuteSelect(selectIngred);

            // cria uma lista de ingredientes
            List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

            // para cada tupla lida do BD, cria uma variável do tipo Ingrediente e a adiciona na lista de ingredientes
            while(rs.next()){
                // cada índice é a posição da coluna da tupla lida do BD
                ingredientes.add(new Ingrediente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return ingredientes;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa de todos os ingredientes, retornando uma lista de ingredientes que será inserida em uma tabela
    public static ObservableList<Ingrediente> SelectIngredientesForTable(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectIngred);
            ObservableList<Ingrediente> ingredientes = FXCollections.observableArrayList();
            while(rs.next()){
                ingredientes.add(new Ingrediente(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            return ingredientes;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa do nome de todos os ingredientes, retornando uma lista de nomes (string)
    public static List<String> SelectIngredientesNome(){
        try{
            // salva o resultado da pesquisa do nome de todos os ingredientes
            ResultSet rs = Database.ExecuteSelect(selectIngredNome);

            // cria uma lista de strings (nome do ingrediente)
            List<String> ingredNomes = new ArrayList<>();

            // para cada tupla lida do BD, adiciona o nome na lista de nomes
            while(rs.next()){
                ingredNomes.add(rs.getString(1));
            }
            return ingredNomes;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> SelectIngredientesFromReceita(int codProd){
        try {
            List<String> ingredientesReceita = new ArrayList<>();
            ResultSet rs = Database.ExecuteSelect("SELECT Ingrediente.nome FROM Ingrediente, Receita WHERE Receita.codProd = " + codProd + " AND Ingrediente.cod = Receita.codIngred;");
            while (rs.next()){
                ingredientesReceita.add(rs.getString(1));
            }
            return ingredientesReceita;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz uma atualização da quantidade atual de um ingrediente, aumentando a quantidade
    public static void UpdateIngredienteAumentarQtdeAtual(int cod, int qtdeComprada){
        try{
            // executa a atualização
            Database.ExecuteInsertUpdateORDelete("UPDATE Ingrediente SET qtdeAtual = qtdeAtual + " + qtdeComprada + " WHERE cod = " + cod + ";");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Faz uma atualização da quantidade atual de um ingrediente, diminuindo a quantidade
    public static void UpdateIngredienteDiminuirQtdeAtual(int cod, int qtdeUsada){
        try{
            // executa a atualização
            Database.ExecuteInsertUpdateORDelete("UPDATE Ingrediente SET qtdeAtual = qtdeAtual - " + qtdeUsada + " WHERE cod = " + cod + ";");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void InsertNovoIngrediente(String nome, String unidade){
        try{
            // insere novo ingrediente
            Database.ExecuteInsertUpdateORDelete("INSERT INTO Ingrediente (nome, unidade) VALUES ('" + nome + "', '" + unidade + "');");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
