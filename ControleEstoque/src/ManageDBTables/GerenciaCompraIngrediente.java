package ManageDBTables;

import DB.Database;
import Scenes.JanelaAlerta;
import TabelasBD.CompraIngrediente;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaCompraIngrediente {

    private static String selectCompraIngred = "SELECT * FROM CompraIngred";
    private static String insertCompraIngred = "INSERT INTO CompraIngred (CNPJFornec, codIngred, data, hora, qtdeIngred, preco) VALUES ";

    public static List<CompraIngrediente> SelectComprasIngredientes(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectCompraIngred); // ResultSet tem os dados lidos do BD
            List<CompraIngrediente> compraIngreds = new ArrayList<>();
            while(rs.next()){
                compraIngreds.add(new CompraIngrediente(rs.getString(1), rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getTime(4).toLocalTime(), rs.getInt(5), rs.getFloat(6)));
            }
            return compraIngreds;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void InsertCompraIngrediente(String CNPJFornec, int codIngred, LocalDate data, LocalTime hora, int qtde, float preco){
        try{
            // inserir compra na tabela CompraIngred
            Database.ExecuteInsertUpdateORDelete(insertCompraIngred + "('" + CNPJFornec + "', " + codIngred + ", '" + data + "', '" + hora + "', " + qtde + ", " + preco + ");");

            // atualizar qtdeAtual do ingrediente comprado
            GerenciaIngredientes.UpdateIngredienteAumentarQtdeAtual(codIngred, qtde);

            JanelaAlerta.Display("", "Cadastro de Compra de Ingrediente bem sucedido");

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
