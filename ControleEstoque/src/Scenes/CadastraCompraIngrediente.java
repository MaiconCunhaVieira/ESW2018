package Scenes;

import controleestoque.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class CadastraCompraIngrediente extends Cadastro {

    private ComboBox<String> comboBoxFornec;
    private ComboBox<String> comboBoxIngred;
    private DatePicker datePickerData;
    private TextField textFieldHora;
    private TextField textFieldQtdeIngred;
    private TextField textFieldPreco;

    public void ChangeScene(){

        // Layout cad_fornec
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Fornecedor:", 0, 1);
        CriaLabel("Ingrediente:", 0, 2);
        CriaLabel("Data:", 0, 3);
        CriaLabel("Hora:", 0, 4);
        CriaLabel("Quantidade:", 0, 5);
        CriaLabel("Preço:", 0, 6);

        // ComboBoxes added to scene
        List<String> fornecsNome = new ArrayList<>();
        fornecsNome.add("Fornec 1");
        fornecsNome.add("Fornec 2");
        comboBoxFornec = CriaComboBox(fornecsNome, 1, 1);

        List<String> ingredsNome = new ArrayList<>();
        ingredsNome.add("Ingred 1");
        ingredsNome.add("Ingred 2");
        comboBoxIngred = CriaComboBox(ingredsNome, 1, 2);

        // DatePicker added to scene
        datePickerData = CriaDatePicker(1, 3);

        // TextFields added to scene
        textFieldHora = CriaTextField("Hora", 1, 4);
        textFieldQtdeIngred = CriaNumericTextField("Quantidade", 1, 5);
        textFieldPreco = CriaNumericTextField("Preço", 1, 6);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 8);
        button_ok.setOnAction(e -> {
            System.out.println(comboBoxFornec.getSelectionModel().getSelectedItem() + ", " + comboBoxIngred.getSelectionModel().getSelectedItem() + ", " + datePickerData.getValue() + ", " + textFieldQtdeIngred.getText() + ", " + textFieldPreco.getText());
        });

        button_voltar = CriaButton("Voltar", 1, 8);
        button_voltar.setOnAction(e -> {
            Main.window.setScene(Main.scene);
        });

        // Scene initialized
        scene = new Scene(layout, 300, 250);

        // Change window from Main to this scene
        Main.window.setScene(scene);
    }
}