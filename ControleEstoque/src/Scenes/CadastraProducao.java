package Scenes;

import controleestoque.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class CadastraProducao extends Cadastro {

    private ComboBox<String> comboBoxProdutoFinal;
    private DatePicker datePickerData;
    private TextField textFieldHora;
    private TextField textFieldQtdeProd;

    public void ChangeScene(){

        // Layout cad_fornec
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Nome do Produto:", 0, 1);
        CriaLabel("Data:", 0, 2);
        CriaLabel("Hora:", 0, 3);
        CriaLabel("Quantidade:", 0, 4);

        // ComboBoxes addded to scene
        List<String> prodsNome = new ArrayList<>();
        prodsNome.add("Fornec 1");
        prodsNome.add("Fornec 2");
        comboBoxProdutoFinal = CriaComboBox(prodsNome, 1, 1);

        // DatePicker added to scene
        datePickerData = CriaDatePicker(1, 2);

        // TextFields added to scene
        textFieldHora = CriaTextField("Hora", 1, 3);
        textFieldQtdeProd = CriaTextField("Quantidade", 1, 4);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 5);
        button_ok.setOnAction(e -> {
            System.out.println(comboBoxProdutoFinal.getSelectionModel().getSelectedItem() + ", " + datePickerData.getValue() + ", " + textFieldQtdeProd.getText());
        });

        button_voltar = CriaButton("Voltar", 1, 5);
        button_voltar.setOnAction(e -> {
            Main.window.setScene(Main.scene);
        });

        // Scene initialized
        scene = new Scene(layout, 300, 250);

        // change window from Main to this scene
        Main.window.setScene(scene);
    }
}