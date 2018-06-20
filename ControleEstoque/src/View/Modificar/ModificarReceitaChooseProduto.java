package View.Modificar;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaProdutoFinal;
import View.Cadastro.WindowCadastro;
import View.JanelaAlerta;
import Model.TabelasBD.ProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.util.List;

public class ModificarReceitaChooseProduto extends WindowCadastro {

    private ComboBox<String> comboBoxProdutoFinal;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação da label
        CriaLabel("Nome do Produto:", 0, 0);

        // inicialização das variáveis de combobox
        comboBoxProdutoFinal = CriaComboBox(GerenciaProdutoFinal.SelectProdutosFinaisNome(), 1, 0);

        // inicialização do botão que mostra a tabela
        button_ok = CriaButton("OK", 0, 1);
        button_ok.setOnAction(e -> {
            int codProd = 0;

            // salva produto selecionado na combobox
            String nomeProduto = comboBoxProdutoFinal.getSelectionModel().getSelectedItem();

            // se algum produto foi selecionado
            if(nomeProduto != null) {
                // pesquisa todos os produtos
                List<ProdutoFinal> produtos = GerenciaProdutoFinal.SelectProdutosFinais();

                // para cada produto na lista de produtos
                for(ProdutoFinal prod : produtos)
                    // se produto selecionado na combobox for igual ao produto da lista, salva seu código
                    if(prod.getNome().equals(nomeProduto))
                        codProd = prod.getCod();

                // com o código do produto, inicializa objeto da cena que mostra tabela com a receita
                ModificarReceitaChooseIngrediente modificarReceitaChooseIngrediente = new ModificarReceitaChooseIngrediente(codProd);
                modificarReceitaChooseIngrediente.ChangeScene();
            }
            else {
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos.");
            }
        });

        // inicialização do botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 1, 1);
        button_voltar.setOnAction(e -> {
            // muda cena atual para cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
