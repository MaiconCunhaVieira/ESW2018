package ManageDBTables;

import DB.Database;
import TabelasBD.Receita;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaReceita {

    private static String selectReceita = "SELECT codIngred, qtdeIngred FROM Receita WHERE codProd = ";

    // Faz a pesquisa da receita de um único ingrediente, retornando uma lista de receitas
    public static List<Receita> SelectReceitas(int codProd){
        try {
            ResultSet rs = Database.ExecuteSelect(selectReceita + codProd + ";");
            List<Receita> receita = new ArrayList<Receita>();
            while(rs.next()){
                receita.add(new Receita(codProd, rs.getInt(1), rs.getInt(2)));
            }
            return receita;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
