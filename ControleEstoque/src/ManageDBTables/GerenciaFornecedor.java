package ManageDBTables;

import DB.Database;
import TabelasBD.Fornecedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaFornecedor {

    private static String selectFornec = "SELECT * FROM Fornecedor";
    private static String selectFornecNome = "SELECT nome FROM Fornecedor";

    // Faz a pesquisa de todos os fornecedores, retornando uma lista de fornecedores
    public static List<Fornecedor> SelectFornecedores(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectFornec);
            List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
            while(rs.next()){
                fornecedores.add(new Fornecedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return fornecedores;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa de todos os fornecedores, retornando uma lista de fornecedores que será inserida em uma tabela
    public static ObservableList<Fornecedor> SelectFornecedoresForTable(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectFornec);
            ObservableList<Fornecedor> fornecedores = FXCollections.observableArrayList();
            while(rs.next()){
                fornecedores.add(new Fornecedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return fornecedores;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa do nome de todos os fornecedores, retornando uma lista de nomes (string)
    public static List<String> SelectFornecedoresNome(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectFornecNome);
            List<String> fornecNomes = new ArrayList<String>();
            while(rs.next()){
                fornecNomes.add(rs.getString(1));
            }
            return fornecNomes;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void InsertNovoFornecedor(String cnpj, String nome, String endereco, String telefone){
        try{
            // insere novo fornecedor
            Database.ExecuteInsertUpdateORDelete("INSERT INTO Fornecedor (CNPJ, nome, endereco, telefone) VALUES ('" + cnpj + "', '" + nome + "', '" + endereco + "', '" + telefone + "');");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
