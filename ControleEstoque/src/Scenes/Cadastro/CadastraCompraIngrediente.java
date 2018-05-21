package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaCompraIngrediente;
import ManageDBTables.GerenciaFornecedor;
import ManageDBTables.GerenciaIngredientes;
import TabelasBD.Fornecedor;
import TabelasBD.Ingrediente;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CadastraCompraIngrediente extends WindowCadastro {

    private ComboBox<String> comboBoxFornec;
    private ComboBox<String> comboBoxIngred;
    private DatePicker datePickerData;
    private TextField textFieldHora;
    private TextField textFieldQtdeIngred;
    private TextField textFieldPreco;

    public void ChangeScene() {

        // Layout
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
        comboBoxFornec = CriaComboBox(GerenciaFornecedor.SelectFornecedoresNome(), 1, 1);
        comboBoxIngred = CriaComboBox(GerenciaIngredientes.SelectIngredientesNome(), 1, 2);

        // DatePicker added to scene
        datePickerData = CriaDatePicker(1, 3);

        // TextFields added to scene
        textFieldHora = CriaTextField("Hora", 1, 4);
        textFieldQtdeIngred = CriaNumericTextField("Quantidade", 1, 5);
        textFieldPreco = CriaNumericTextField("Preço", 1, 6);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 8);
        button_ok.setOnAction(e -> {
            List<Fornecedor> fornecs = GerenciaFornecedor.SelectFornecedores();
            String cnpj = "";
            for(Fornecedor fornec : fornecs){
                if(fornec.getNome().equals(comboBoxFornec.getSelectionModel().getSelectedItem())){
                    cnpj = fornec.getCNPJ();
                }
            }

            List<Ingrediente> ingreds = GerenciaIngredientes.SelectIngredientes();
            int codIngred = 0;
            for(Ingrediente ingred : ingreds){
                if(ingred.getNome().equals(comboBoxIngred.getSelectionModel().getSelectedItem())){
                    codIngred = ingred.getCod();
                }
            }
            LocalTime hora = LocalTime.now();
            GerenciaCompraIngrediente.InsertCompraIngrediente(cnpj, codIngred, datePickerData.getValue(), hora, Integer.parseInt(textFieldQtdeIngred.getText()), Float.parseFloat(textFieldPreco.getText()));
        });

        button_voltar = CriaButton("Voltar", 1, 8);
        button_voltar.setOnAction(e -> {
            Main.window.setScene(Main.scene);
        });

        // Scene initialized
        scene = new Scene(layout, 300, 250);

        // change window from Main to this scene
        Main.window.setScene(scene);
    }
}