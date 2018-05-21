package ManageDBTables;

import DB.Database;
import TabelasBD.ProdutoFinal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaProdutoFinal {

    private static String selectProdutosFinais = "SELECT * FROM ProdutoFinal;";
    private static String selectProdutosFinaisNome = "SELECT nome FROM ProdutoFinal";
    private static String insertProdutoFinal = "INSERT INTO ProdutoFinal (nome, preco, peso ) VALUES ";

    public static List<ProdutoFinal> SelectProdutosFinais(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectProdutosFinais);
            List<ProdutoFinal> produtosFinais = new ArrayList<>();
            while(rs.next()){
                produtosFinais.add(new ProdutoFinal(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5)));
            }
            return produtosFinais;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ObservableList<ProdutoFinal> SelectProdutosFinaisForTable(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectProdutosFinais);
            ObservableList<ProdutoFinal> produtosFinais = FXCollections.observableArrayList();
            while(rs.next()){
                produtosFinais.add(new ProdutoFinal(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5)));
            }
            return produtosFinais;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> SelectProdutosFinaisNome(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectProdutosFinaisNome);
            List<String> prodFinalNomes = new ArrayList<>();
            while(rs.next()){
                prodFinalNomes.add(rs.getString(1));
            }
            return prodFinalNomes;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void InsertProdutoFinal(String nome, float preco, int peso){
        try {
            int inserted = Database.ExecuteInsertUpdateORDelete(insertProdutoFinal + "('" + nome + "', " + preco + ", " + peso + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateProdutoFinalAumentarQtdePronta(int cod, int qtdeProduzida){
        try{
            Database.ExecuteInsertUpdateORDelete("UPDATE ProdutoFinal SET qtdePronta = qtdePronta + " + qtdeProduzida + " WHERE cod = " + cod + ";");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateProdutoFinalDiminuirQtdePronta(int cod, int qtdeVendida){
        try{
            Database.ExecuteInsertUpdateORDelete("UPDATE ProdutoFinal SET qtdePronta = qtdePronta - " + qtdeVendida + " WHERE cod = " + cod + ";");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
