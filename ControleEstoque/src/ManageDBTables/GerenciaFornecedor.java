package ManageDBTables;

import DB.Database;
import TabelasBD.Fornecedor;

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
}
