package Scenes;

import controleestoque.Main;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class CadastraCompraIngrediente extends Cadastro {

    private ComboBox<String> comboBoxFornec;
    private ComboBox<String> comboBoxIngred;
    private TextField TextFieldQtdeIngred;

    public void ChangeScene(){

        // Layout cad_fornec
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 5);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Fornecedor:", 0, 1);
        CriaLabel("Ingrediente:", 0, 2);
        CriaLabel("Quantidade:", 0, 3);

        // TextFields added to scene
        //CriaTextField("Fornecedor", 1, 1);
        //CriaTextField("Ingrediente", 1, 2);
        TextFieldQtdeIngred = CriaNumericTextField("Quantidade", 1, 3);

        // ComboBoxes added to scene
        List<String> fornecsNome = new ArrayList<>(); // quando BD for integrado, será lido do método SelectFornecedoresNome() da classe GerenciaFornecedores
        fornecsNome.add("Fornec 1");
        fornecsNome.add("Fornec 2");
        comboBoxFornec = CriaComboBox(fornecsNome, 1, 1);

        List<String> ingredsNome = new ArrayList<>(); // quando BD for integrado, será lido do método SelectIngredientesNome() da classe GerenciaIngredientes
        ingredsNome.add("Prod 1");
        ingredsNome.add("Prod 2");
        comboBoxIngred = CriaComboBox(ingredsNome, 1, 2);

        // Posição do layout
        layout.setAlignment(Pos.CENTER);

        // Scene initialized
        scene = new Scene(layout, 300, 250);
        button_ok.setOnAction(e -> {
            System.out.println(comboBoxFornec.getSelectionModel().getSelectedItem() + " " + comboBoxIngred.getSelectionModel().getSelectedItem() + " " + TextFieldQtdeIngred.getText());
        });

        // Change window from Main to this scene
        Main.window.setScene(scene);
    }
}