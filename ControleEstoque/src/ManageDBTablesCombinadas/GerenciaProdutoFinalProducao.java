package ManageDBTablesCombinadas;

import DB.Database;
import TabelasBDCombinadas.ProdutoFinalProducao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public abstract class GerenciaProdutoFinalProducao {

    private static String pesquisaProducao =
            "SELECT ProdutoFinal.nome, Producao.data, Producao.hora, Producao.qtde " +
                    "FROM ProdutoFinal, Producao " +
                    "WHERE ProdutoFinal.cod = Producao.codProd;";

    public static ObservableList<ProdutoFinalProducao> SelectProducao(){
        try{
            ObservableList<ProdutoFinalProducao> producoes = FXCollections.observableArrayList();
            ResultSet rs = Database.ExecuteSelect(pesquisaProducao);
            while(rs.next()){
                producoes.add(new ProdutoFinalProducao(rs.getString(1), rs.getDate(2).toLocalDate(), rs.getTime(3).toLocalTime(), rs.getInt(4)));
            }
            return producoes;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
