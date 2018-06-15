package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

    static String jdbcURL = "jdbc:postgresql://localhost:5432/TestDB";
    static String username = "postgres";
    static String password = "admin";

    public static ResultSet ExecuteSelect(String selectString) {
        try {
            // conecta com o BD usando sua url, usuário e senha
            Connection connec = DriverManager.getConnection(jdbcURL, username, password);

            // prepara a execucão de uma pesquisa no BD (select)
            PreparedStatement stmnt = connec.prepareStatement(selectString);

            // executa o select, resultado da pesquisa salvo na variável
            ResultSet rs = stmnt.executeQuery();

            return rs;

        } catch (Exception e){
            // se conexão mal sucedida, mostra mensagem de exceção
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public static int ExecuteInsertUpdateORDelete(String insUpdDelString) {
        try {
            // conecta com o BD usando sua url, usuário e senha
            Connection connec = DriverManager.getConnection(jdbcURL, username, password);

            // prepara a execucão de uma atualização no BD (update, insert ou delete)
            PreparedStatement stmnt = connec.prepareStatement(insUpdDelString);

            // executa, variável será o status da exexução
            int result = stmnt.executeUpdate();

            return result;

        } catch (Exception e){
            // se conexão mal sucedida, mostra mensagem de exceção
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
