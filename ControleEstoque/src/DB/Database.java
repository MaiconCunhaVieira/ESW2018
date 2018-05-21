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
            Connection connec = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement stmnt = connec.prepareStatement(selectString);
            ResultSet rs = stmnt.executeQuery();
            return rs;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    public static int ExecuteInsertUpdateORDelete(String insUpdDelString) {
        try {
            Connection connec = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement stmnt = connec.prepareStatement(insUpdDelString);
            int result = stmnt.executeUpdate();
            return result;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
