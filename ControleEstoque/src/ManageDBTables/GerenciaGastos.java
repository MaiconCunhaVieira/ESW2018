package ManageDBTables;

import DB.Database;
import TabelasBD.Gastos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaGastos {

    public static List<Gastos> SelectGastos(){
        try {
            List<Gastos> gastos = new ArrayList<>();
            ResultSet rs = Database.ExecuteSelect("SELECT * FROM Gastos;");
            while(rs.next()){
                gastos.add(new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6).toLocalDate()));
            }
            return gastos;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ObservableList<Gastos> SelectGastosForTable(){
        try {
            ObservableList<Gastos> gastos = FXCollections.observableArrayList();
            ResultSet rs = Database.ExecuteSelect("SELECT * FROM Gastos;");
            while(rs.next()){
                gastos.add(new Gastos(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6).toLocalDate()));
            }
            return gastos;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void InsertGastos(int luz, int agua, int funcionarios, int outros, LocalDate data){
        try {
            Database.ExecuteInsertUpdateORDelete("INSERT INTO Gastos (luz, agua, funcionarios, outros, data) VALUES (" + luz + ", " + agua + ", " + funcionarios + ", " + outros + ", '" + data + "');");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
