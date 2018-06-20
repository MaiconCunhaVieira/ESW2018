package Controller.GerenciaTabelasBD;

import Controller.DB.Database;
import View.JanelaAlerta;
import Model.TabelasBD.CompraIngrediente;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaCompraIngrediente {

    private static String selectCompraIngred = "SELECT * FROM CompraIngred";
    private static String insertCompraIngred = "INSERT INTO CompraIngred (CNPJFornec, codIngred, data, hora, qtdeIngred, preco) VALUES ";

    // Faz a pesquisa de todas as compras de ingredientes, retornando uma lista de compras de ingredientes
    public static List<CompraIngrediente> SelectComprasIngredientes(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectCompraIngred);
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

    // Insere uma nova compra de ingrediente no BD
    public static void InsertCompraIngrediente(String CNPJFornec, int codIngred, LocalDate data, LocalTime hora, int qtde, float preco){
        try{
            // insere nova compra no BD
            Database.ExecuteInsertUpdateORDelete(insertCompraIngred + "('" + CNPJFornec + "', " + codIngred + ", '" + data + "', '" + hora + "', " + qtde + ", " + preco + ");");

            // atualiza quantidade do ingrediente comprado
            GerenciaIngredientes.UpdateIngredienteAumentarQtdeAtual(codIngred, qtde);

            // mostra mensagem de sucesso
            JanelaAlerta.Display("", "Cadastro de Compra de Ingrediente bem sucedido");

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
