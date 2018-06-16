package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaIngredientes;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraIngrediente extends WindowCadastro {

    private TextField textFieldNomeIngrediente;
    private TextField textFieldUnidadeIngrediente;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Nome do Ingrediente:", 0, 1);
        CriaLabel("Unidade do Ingrediente:", 0, 2);

        // inicialização das variáveis de campo de texto
        textFieldNomeIngrediente = CriaTextField("Nome do ingrediente", 1, 1);
        textFieldUnidadeIngrediente = CriaTextField("Unidade", 1, 2);

        // inicializa botão que adiciona novo ingrediente
        button_ok = CriaButton("OK", 0, 3);
        button_ok.setOnAction(event -> {
            // salva dados de entrada em variáveis
            String nomeIngrediente = textFieldNomeIngrediente.getText();
            String unidadeIngrediente = textFieldUnidadeIngrediente.getText();

            GerenciaIngredientes.InsertNovoIngrediente(nomeIngrediente, unidadeIngrediente);
        });

        // inicializa botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 1, 3);
        button_voltar.setOnAction(event -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
