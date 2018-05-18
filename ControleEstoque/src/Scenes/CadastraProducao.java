package Scenes;

import controleestoque.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
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

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 5);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Nome do Produto:", 0, 1);
        CriaLabel("Data:", 0, 2);
        CriaLabel("Hora:", 0, 3);
        CriaLabel("Quantidade:", 0, 4);

        // TextFields added to scene
        //CriaTextField("Produto", 1, 1);
        //CriaTextField("Data", 1, 2);
        textFieldHora = CriaTextField("Hora", 1, 3);
        textFieldQtdeProd = CriaTextField("Quantidade", 1, 4);

        // ComboBoxes addded to scene
        List<String> prodsNome = new ArrayList<>(); // quando BD for integrado, será lido do método SelectProdutosFinaisNome() da classe GerenciaProdutosFinais
        prodsNome.add("Fornec 1");
        prodsNome.add("Fornec 2");
        comboBoxProdutoFinal = CriaComboBox(prodsNome, 1, 1);

        // DatePicker added to scene
        datePickerData = new DatePicker();
        datePickerData.setOnAction(event -> {
            LocalDate data = datePickerData.getValue();
        });
        layout.add(datePickerData, 1, 2);

        layout.setAlignment(Pos.CENTER);

        // Scene initialized
        scene = new Scene(layout, 300, 250);
        button_ok.setOnAction(e -> {
            // select produto final que tenha mesmo nome que o produto selecionado na comboBox
            // insert nova produção com esse produto
        });

        // change window from Main to this scene
        Main.window.setScene(scene);
    }
}