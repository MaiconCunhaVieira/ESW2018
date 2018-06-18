package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaIngredientes;
import ManageDBTables.GerenciaProdutoFinal;
import ManageDBTables.GerenciaReceita;
import Scenes.JanelaAlerta;
import TabelasBD.Ingrediente;
import TabelasBD.ProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;

public class CadastraReceita extends WindowCadastro {

    private ComboBox<String> comboBoxProduto;
    private ComboBox<String> comboBoxIngrediente;
    private TextField textFieldQtdeIngrediente;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria todas as labels da cena
        CriaLabel("Informações:", 0,0);
        CriaLabel("Produto:", 0, 1);
        CriaLabel("Ingrediente:", 0, 2);
        CriaLabel("Quantidade do ingrediente:", 0, 3);

        // inicializa as variáveis de combobox
        comboBoxProduto = CriaComboBox(GerenciaProdutoFinal.SelectProdutosFinaisNome(), 1, 1);
        comboBoxIngrediente = CriaComboBox(GerenciaIngredientes.SelectIngredientesNome(), 1, 2);

        // inicializa a variável de campo de texto
        textFieldQtdeIngrediente = CriaNumericTextField("Quantidade do ingrediente", 1, 3);

        // inicializa botão que adiciona ingrediente na receita
        button_ok = CriaButton("Adicionar", 0,4);
        button_ok.setOnAction(event -> {
            // salva dados de entrada
            String produto_selecionado = comboBoxProduto.getSelectionModel().getSelectedItem();
            String ingrediente_selecionado = comboBoxIngrediente.getSelectionModel().getSelectedItem();
            String stringQtdeIngrediente = textFieldQtdeIngrediente.getText();

            // se nenhum dado de entrada estiver vazio
            if(produto_selecionado != null & ingrediente_selecionado != null & stringQtdeIngrediente != null){
                int qtdeIngrediente = Integer.parseInt(stringQtdeIngrediente);

                // seleciona todos os produtos
                List<ProdutoFinal> produtos = GerenciaProdutoFinal.SelectProdutosFinais();
                int codProduto = 0;

                // para todos os produtos, se o nome do produto é igual ao produto selecionado, salva seu código
                for(ProdutoFinal pf : produtos)
                    if(pf.getNome().equals(produto_selecionado))
                        codProduto = pf.getCod();

                // seleciona todos os ingredientes
                List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes();
                int codIngrediente = 0;

                // para todos os ingredientes, se o nome do ingrediente é igual ao ingrediente selecionado, salva seu código
                for(Ingrediente ingred : ingredientes)
                    if(ingred.getNome().equals(ingrediente_selecionado))
                        codIngrediente = ingred.getCod();

                // com o código do produto e o código do ingrediente, insere a receita no BD
                GerenciaReceita.InsertReceita(codProduto, codIngrediente, qtdeIngrediente);

                // mostra janela de sucesso
                JanelaAlerta.Display("Sucesso", ingrediente_selecionado + " adicionado na receita de " + produto_selecionado + ".");
            }
            else {
                // se algum dado de entrada estiver vazio, mostra janela de erro
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos.");
            }
        });

        // inicialização do botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 1, 4);
        // ação ao clicar no botão que volta para a tela principal
        button_voltar.setOnAction(event -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
