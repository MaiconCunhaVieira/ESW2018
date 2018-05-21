package ManageDBTables;

import DB.Database;
import TabelasBD.Ingrediente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaIngredientes {

    private static String selectIngred = "SELECT * FROM Ingrediente";
    private static String selectIngredNome = "SELECT nome FROM Ingrediente";

    public static List<Ingrediente> SelectIngredientes(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectIngred);
            List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
            while(rs.next()){
                ingredientes.add(new Ingrediente(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            return ingredientes;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ObservableList<Ingrediente> SelectIngredientesForTable(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectIngred);
            ObservableList<Ingrediente> ingredientes = FXCollections.observableArrayList();
            while(rs.next()){
                ingredientes.add(new Ingrediente(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            return ingredientes;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> SelectIngredientesNome(){
        try{
            ResultSet rs = Database.ExecuteSelect(selectIngredNome);
            List<String> ingredNomes = new ArrayList<>();
            while(rs.next()){
                ingredNomes.add(rs.getString(1));
            }
            return ingredNomes;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void UpdateIngredienteAumentarQtdeAtual(int cod, int qtdeComprada){
        try{
            Database.ExecuteInsertUpdateORDelete("UPDATE Ingrediente SET qtdeAtual = qtdeAtual + " + qtdeComprada + " WHERE cod = " + cod + ";");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateIngredienteDiminuirQtdeAtual(int cod, int qtdeUsada){
        try{
            Database.ExecuteInsertUpdateORDelete("UPDATE Ingrediente SET qtdeAtual = qtdeAtual - " + qtdeUsada + " WHERE cod = " + cod + ";");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
