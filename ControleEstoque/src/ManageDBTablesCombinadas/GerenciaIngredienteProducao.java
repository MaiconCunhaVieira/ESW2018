package ManageDBTablesCombinadas;

import DB.Database;
import ManageDBTables.GerenciaIngredientes;
import TabelasBD.Ingrediente;
import TabelasBDCombinadas.IngredienteProducao;
import TabelasBDCombinadas.IngredienteQtdeConsumida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaIngredienteProducao {

    private static String pesquisaIngredProducao =
            "SELECT Ingrediente.nome, Receita.qtdeIngred, Producao.qtde " +
                    "FROM Ingrediente, Receita, Producao " +
                    "WHERE Ingrediente.cod = Receita.codIngred AND Receita.codProd = Producao.codProd;";

    public static ObservableList<IngredienteQtdeConsumida> SelectIngredienteProducao(){
        try {
            // cada membro de ingredProdução conterá o nome do ingrediente, a quantidade utilizada na receita e a quantidade produzida do produto
            List<IngredienteProducao> ingredProducao = new ArrayList<>();

            // cada membro de ingredienteQtdeConsumida contéra o código do ingrediente, o nome do ingrediente e a quantidade total consumida daquele ingrediente
            ObservableList<IngredienteQtdeConsumida> ingredienteQtdeConsumida = FXCollections.observableArrayList();

            // lista com todos os ingredientes do BD
            List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes();

            // pesquisa todas as produções, concatenando a quantidade produzida do produto, a quantidade do ingrediente que o produto utiliza na receita e o ingrediente utilizado
            ResultSet rs = Database.ExecuteSelect(pesquisaIngredProducao);
            while(rs.next()){
                ingredProducao.add(new IngredienteProducao(rs.getString(1), rs.getInt(2), rs.getInt(3)));
            }

            // salva alguns dados de todos os ingredientes do BD
            for(Ingrediente ingred : ingredientes)
                ingredienteQtdeConsumida.add(new IngredienteQtdeConsumida(ingred.getCod(), ingred.getNome(), 0));

            // calcula quanto foi consumido de cada ingrediente
            int qtdeConsumida = 0;
            // para cada ingrediente do BD
            for(IngredienteQtdeConsumida ingredQtdeConsum : ingredienteQtdeConsumida){
                // para cada produção
                for(IngredienteProducao ingredProd : ingredProducao){
                    // se a produção utilizou o ingrediente, soma a quantidade consumida
                    if(ingredQtdeConsum.getNome().equals(ingredProd.getNomeIngrediente())){
                        qtdeConsumida += ingredProd.getQtdeReceita() * ingredProd.getQtdeProduzida();
                    }
                }
                // terminou de calcular a quantidade consumida de um ingrediente, então salva a quantidade calculada
                // e zera o contador
                ingredQtdeConsum.setQtdeConsumida(qtdeConsumida);
                qtdeConsumida = 0;
            }
            return ingredienteQtdeConsumida;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
