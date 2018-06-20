package View.Modificar;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaIngredientes;
import Controller.GerenciaTabelasBD.GerenciaReceita;
import View.Cadastro.WindowCadastro;
import View.JanelaAlerta;
import Model.TabelasBD.Ingrediente;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;

public class ModificarReceitaChooseIngrediente extends WindowCadastro {

    private int codProd;
    private ComboBox<String> comboBoxIngrediente;
    private TextField textFieldQtdeIngrediente;

    public ModificarReceitaChooseIngrediente(int codProd) { this.codProd = codProd; }

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria labels
        CriaLabel("Ingrediente:", 0, 0);
        CriaLabel("Nova quantidade:", 0, 1);

        // inicializa combobox
        comboBoxIngrediente = CriaComboBox(GerenciaIngredientes.SelectIngredientesFromReceita(codProd), 1, 0);

        // inicializa campo de texto
        textFieldQtdeIngrediente = CriaNumericTextField("Nova quantidade", 1, 1);

        // inicializa botões
        button_ok = CriaButton("Modificar", 0,2);
        button_ok.setOnAction(event -> {
            String ingrediente_selecionado = comboBoxIngrediente.getSelectionModel().getSelectedItem();
            String qtdeIngrediente_escolhida = textFieldQtdeIngrediente.getText();

            if(ingrediente_selecionado != null & !qtdeIngrediente_escolhida.isEmpty()){
                int qtdeIngrediente = Integer.parseInt(qtdeIngrediente_escolhida);

                List<Ingrediente> ingredientes = GerenciaIngredientes.SelectIngredientes();

                int codIngred = 0;
                for(Ingrediente ingred : ingredientes){
                    if(ingred.getNome().equals(ingrediente_selecionado)){
                        codIngred = ingred.getCod();
                    }
                }

                GerenciaReceita.UpdateReceita(codProd, codIngred, qtdeIngrediente);
                JanelaAlerta.Display("Sucesso", "Quantidade do ingrediente " + ingrediente_selecionado + " modificada para " + qtdeIngrediente + ".");
            }
            else {
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos.");
            }
        });

        button_voltar = CriaButton("Voltar", 1, 2);
        button_voltar.setOnAction(event -> {
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
