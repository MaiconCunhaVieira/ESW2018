package ManageDBTables;

import DB.Database;
import TabelasBD.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaCliente {

    private static String selectClientes = "SELECT * FROM Cliente";
    private static String selectClientesNome = "SELECT nome FROM Cliente";

    // Faz a pesquisa de todos os clientes, retornando uma lista de clientes
    public static List<Cliente> SelectClientes(){
        try{
            // salva o resultado da pesquisa de todos os clientes
            ResultSet rs = Database.ExecuteSelect(selectClientes);

            // cria uma lista de clientes
            List<Cliente> clientes = new ArrayList<>();

            // para cada tupla lida do BD, cria uma variável do tipo Cliente e a adiciona na lista de clientes
            while(rs.next()){
                // cada índice é a posição da coluna da tupla lida do BD
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return clientes;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa de todos os clientes, retornando uma lista de clientes que será inserida em uma tabela
    public static ObservableList<Cliente> SelectClientesForTable(){
        try{
            // salva o resultado da pesquisa de todos os clientes
            ResultSet rs = Database.ExecuteSelect(selectClientes);

            // cria uma lista de clientes
            ObservableList<Cliente> clientes = FXCollections.observableArrayList();

            // para cada tupla lida do BD, cria uma variável do tipo Cliente e a adiciona na lista de clientes
            while(rs.next()){
                // cada índice é a posição da coluna da tupla lida do BD
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return clientes;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Faz a pesquisa do nome de todos os clientes, retornando uma lista de nomes (string)
    public static List<String> SelectClientesNome(){
        try{
            // salva o resultado da pesquisa do nome de todos os clientes
            ResultSet rs = Database.ExecuteSelect(selectClientesNome);

            // cria uma lista de strings (nome do cliente)
            List<String> clientesNome = new ArrayList<>();

            // para cada tupla lida do BD, adiciona o nome na lista de nomes
            while(rs.next()){
                clientesNome.add(rs.getString(1));
            }
            return clientesNome;

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
