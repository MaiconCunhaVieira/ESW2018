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

    // Faz a pesquisa de todas as produções, retornando uma lista de produções
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

    // Insere uma nova produção no BD
    public static void InsertProducao(int codProd, LocalDate data, LocalTime hora, int qtde){
        try {
            List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes(); // lista de ingredientes contém todos os ingredientes do BD
            List<Receita> receitaProd = GerenciaReceita.SelectReceitas(codProd); // lista de receitas contém a receita de um único produto
            List<ProdutoFinal> prodFinais = GerenciaProdutoFinal.SelectProdutosFinais(); // lista de produtos contém todos os produtos do BD
            String nomeProdFinal = null; // variável que terá o nome do produto a ser produzido
            List<String> ingredInsuficMessages = new ArrayList<>(); // variável que terá a lista de mensagens de erro caso a produção falhe
            boolean peloMenosUmIngredienteSemQuantidadeSuficiente = false; // flag que dirá se a produção falhou

            // para cada ingrediente da receita do produto a ser produzido
            for(Receita rec : receitaProd){
                // e para cada ingrediente
                for(Ingrediente ingred : ingredientes){
                    // se o ingrediente da receita é o mesmo ingrediente na lista de ingredientes
                    if(rec.getCodIngred() == ingred.getCod()){
                        // e se a quantidade atual desse ingrediente for menor do que a quantidade necessária para fazer a produção, produção deve FALHAR
                        if(ingred.getQtdeAtual() < qtde * rec.getQtdeIngred()) {
                            // busca o produto a ser produzido
                            for(ProdutoFinal pf : prodFinais)
                                // se o produto na lista de produtos é o mesmo produto a ser produzido
                                if(pf.getCod() == codProd)
                                    // salva seu nome
                                    nomeProdFinal = pf.getNome();
                            // adiciona uma mensagem na lista de mensagens de erro e muda flag de erro para TRUE
                            ingredInsuficMessages.add("Impossível produzir " + qtde + " unidades do produto " + nomeProdFinal + ", necessário " + qtde * rec.getQtdeIngred() + " " + ingred.getUnidade() + " do ingrediente " + ingred.getNome() + ", estoque possui " + ingred.getQtdeAtual() + ".");
                            peloMenosUmIngredienteSemQuantidadeSuficiente = true;
                        }
                    }
                }
            }

            // se lista de mensagens de erro não estiver vazia, mostra uma janela de erro contendo as mensagens de erro
            if(!ingredInsuficMessages.isEmpty())
                JanelaAlerta.Display("Ingredientes insuficientes", ingredInsuficMessages);

            // se tem quantidade suficiente de ingrediente para cada ingrediente da receita do produto
            if(!peloMenosUmIngredienteSemQuantidadeSuficiente) {
                // insere produção no BD
                Database.ExecuteInsertUpdateORDelete(insertProducao + "(" + codProd + ", '" + data + "', '" + hora + "', " + qtde + ");");

                // atualiza quantidade atual dos ingredientes da receita do produto
                for(Receita rec : receitaProd){
                    for(Ingrediente ingred : ingredientes){
                        if(ingred.getCod() == rec.getCodIngred()){
                            GerenciaIngredientes.UpdateIngredienteDiminuirQtdeAtual(ingred.getCod(), qtde * rec.getQtdeIngred());
                        }
                    }
                }

                // atualiza quantidade atual do produto
                GerenciaProdutoFinal.UpdateProdutoFinalAumentarQtdePronta(codProd, qtde);

                // mostra janela com mensagem de sucesso
                JanelaAlerta.Display("", "Cadastro de Produção bem sucedido");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
