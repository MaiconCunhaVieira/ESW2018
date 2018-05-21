package ManageDBTables;

import DB.Database;
import TabelasBD.Cliente;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaCliente {

    private static String selectClientes = "SELECT * FROM Cliente";
    private static String selectClientesNome = "SELECT nome FROM Cliente";

    public static List<Cliente> SelectClientes(){
        try{
            ResultSet rs = Database.ExecuteSelect(selectClientes);
            List<Cliente> clientes = new ArrayList<>();
            while(rs.next()){
                clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return clientes;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> SelectClientesNome(){
        try{
            ResultSet rs = Database.ExecuteSelect(selectClientesNome);
            List<String> clientesNome = new ArrayList<>();
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
