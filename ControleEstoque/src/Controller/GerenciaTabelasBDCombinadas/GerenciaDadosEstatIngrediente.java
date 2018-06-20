package Controller.GerenciaTabelasBDCombinadas;

import Controller.DB.Database;
import Controller.GerenciaTabelasBD.GerenciaIngredientes;
import Model.TabelasBD.Ingrediente;
import Model.TabelasBDCombinadas.DadosEstatIngrediente;
import Model.TabelasBDCombinadas.IngredienteReceitaProducao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaDadosEstatIngrediente {

    private static String pesquisaDadosEstatIngred =
            "SELECT Ingrediente.nome, Receita.qtdeIngred, Producao.qtde " +
                    "FROM Ingrediente, Receita, Producao " +
                    "WHERE Ingrediente.cod = Receita.codIngred AND Receita.codProd = Producao.codProd;";

    public static ObservableList<DadosEstatIngrediente> SelectDadosEstatIngrediente(){
        try {
            // cada membro de ingredReceitaProdução conterá o nome do ingrediente, a quantidade utilizada na receita e a quantidade produzida do produto
            List<IngredienteReceitaProducao> ingredReceitaProducao = new ArrayList<>();

            // cada membro de dadosEstatIngrediente contéra o código do ingrediente, o nome do ingrediente e a quantidade total consumida daquele ingrediente
            ObservableList<DadosEstatIngrediente> dadosEstatIngrediente = FXCollections.observableArrayList();

            // lista com todos os ingredientes do BD
            List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes();

            // pesquisa todas as produções, concatenando a quantidade produzida do produto, a quantidade do ingrediente que o produto utiliza na receita e o ingrediente utilizado
            ResultSet rs = Database.ExecuteSelect(pesquisaDadosEstatIngred);
            while(rs.next()){
                ingredReceitaProducao.add(new IngredienteReceitaProducao(rs.getString(1), rs.getInt(2), rs.getInt(3)));
            }

            // salva alguns dados de todos os ingredientes do BD
            for(Ingrediente ingred : ingredientes)
                dadosEstatIngrediente.add(new DadosEstatIngrediente(ingred.getCod(), ingred.getNome(), 0));

            // calcula quanto foi consumido de cada ingrediente
            int qtdeConsumida = 0;
            // para cada ingrediente do BD
            for(DadosEstatIngrediente dadosEstatIngred : dadosEstatIngrediente){
                // para cada produção
                for(IngredienteReceitaProducao ingredRecProd : ingredReceitaProducao){
                    // se a produção utilizou o ingrediente, soma a quantidade consumida
                    if(dadosEstatIngred.getNome().equals(ingredRecProd.getNomeIngrediente())){
                        qtdeConsumida += ingredRecProd.getQtdeReceita() * ingredRecProd.getQtdeProduzida();
                    }
                }
                // terminou de calcular a quantidade consumida de um ingrediente, então salva a quantidade calculada
                // e zera o contador
                dadosEstatIngred.setQtdeConsumida(qtdeConsumida);
                qtdeConsumida = 0;
            }
            return dadosEstatIngrediente;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
