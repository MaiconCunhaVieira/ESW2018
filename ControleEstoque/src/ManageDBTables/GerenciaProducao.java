package ManageDBTables;

import DB.Database;
import Scenes.JanelaAlerta;
import TabelasBD.Ingrediente;
import TabelasBD.Producao;
import TabelasBD.ProdutoFinal;
import TabelasBD.Receita;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaProducao {

    private static String selectProducao = "SELECT * FROM Producao";
    private static String insertProducao = "INSERT INTO Producao (codProd, data, hora, qtde) VALUES ";

    public static List<Producao> SelectProducoes(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectProducao);
            List<Producao> producoes = new ArrayList<Producao>();
            while(rs.next()){
                producoes.add(new Producao(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getTime(3).toLocalTime(), rs.getInt(4)));
            }
            return producoes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void InsertProducao(int codProd, LocalDate data, LocalTime hora, int qtde){
        try {
            List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes();
            List<Receita> receitaProd = GerenciaReceita.SelectReceitas(codProd);
            List<ProdutoFinal> prodFinais = GerenciaProdutoFinal.SelectProdutosFinais();
            String nomeProdFinal = null;
            List<String> ingredInsuficMessages = new ArrayList<>();
            boolean peloMenosUmIngredienteSemQuantidadeSuficiente = false;

            for(Receita rec : receitaProd){
                for(Ingrediente ingred : ingredientes){
                    if(rec.getCodIngred() == ingred.getCod()){
                        if(ingred.getQtdeAtual() < qtde * rec.getQtdeIngred()) {
                            for(ProdutoFinal pf : prodFinais)
                                if(pf.getCod() == codProd)
                                    nomeProdFinal = pf.getNome();
                            ingredInsuficMessages.add("Impossível produzir " + qtde + " unidades do produto " + nomeProdFinal + ", necessário " + qtde * rec.getQtdeIngred() + " do ingrediente " + ingred.getNome() + ", estoque possui " + ingred.getQtdeAtual() + ".");
                            //System.out.println("Impossível produzir " + qtde + " unidades do produto " + nomeProdFinal + ", necessário " + qtde * rec.getQtdeIngred() + " do ingrediente " + ingred.getNome() + ", estoque possui " + ingred.getQtdeAtual() + ".");
                            peloMenosUmIngredienteSemQuantidadeSuficiente = true;
                        }
                    }
                }
            }

            if(ingredInsuficMessages != null)
                JanelaAlerta.Display("Ingredientes insuficientes", ingredInsuficMessages);

            // se tem quantidade suficiente de ingrediente para cada ingrediente da receita do produto
            if(!peloMenosUmIngredienteSemQuantidadeSuficiente) {
                // insere produção no BD
                Database.ExecuteInsertUpdateORDelete(insertProducao + "(" + codProd + ", '" + data + "', '" + hora + "', " + qtde + ");");

                // atualiza quantidade dos ingredientes da receita do produto
                for(Receita rec : receitaProd){
                    for(Ingrediente ingred : ingredientes){
                        if(ingred.getCod() == rec.getCodIngred()){
                            GerenciaIngredientes.UpdateIngredienteDiminuirQtdeAtual(ingred.getCod(), qtde * rec.getQtdeIngred());
                        }
                    }
                }

                // atualiza quantidade do produto
                GerenciaProdutoFinal.UpdateProdutoFinalAumentarQtdePronta(codProd, qtde);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
