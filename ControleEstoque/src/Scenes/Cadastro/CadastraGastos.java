package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaGastos;
import Scenes.JanelaAlerta;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraGastos extends WindowCadastro {

    private TextField textFieldLuz;
    private TextField textFieldAgua;
    private TextField textFieldFuncionarios;
    private TextField textFieldOutros;
    private DatePicker datePickerData;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // labeld
        CriaLabel("Gastos com:", 0, 0);
        CriaLabel("Luz:", 0, 1);
        CriaLabel("Água:", 0, 2);
        CriaLabel("Funcionários:",0, 3);
        CriaLabel("Outros:", 0, 4);
        CriaLabel("Data:", 0, 5);

        // campos de texto
        textFieldLuz = CriaNumericTextField("Luz", 1, 1);
        textFieldAgua = CriaNumericTextField("Água",1, 2);
        textFieldFuncionarios = CriaNumericTextField("Funcionários", 1, 3);
        textFieldOutros = CriaNumericTextField("Outros", 1, 4);

        // datePicker
        datePickerData = CriaDatePicker(1, 5);

        // botões
        button_ok = CriaButton("OK", 0, 6);
        button_ok.setOnAction(event -> {
            String stringLuz = textFieldLuz.getText();
            String stringAgua = textFieldAgua.getText();
            String stringFunc = textFieldFuncionarios.getText();
            String stringOutros = textFieldOutros.getText();

            if(!stringLuz.isEmpty() & !stringAgua.isEmpty() & !stringFunc.isEmpty() & !stringOutros.isEmpty()){
                int luz = Integer.parseInt(stringLuz);
                int agua = Integer.parseInt(stringAgua);
                int func = Integer.parseInt(stringFunc);
                int outros = Integer.parseInt(stringOutros);

                GerenciaGastos.InsertGastos(luz, agua, func, outros, datePickerData.getValue());
                JanelaAlerta.Display("Sucesso", "Gastos adicionados.");
            }
            else {
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos.");
            }
        });

        button_voltar = CriaButton("Voltar", 1, 6);
        button_voltar.setOnAction(event -> {
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
