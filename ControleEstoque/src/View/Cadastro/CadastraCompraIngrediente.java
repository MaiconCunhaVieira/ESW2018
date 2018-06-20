package View.Cadastro;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaCompraIngrediente;
import Controller.GerenciaTabelasBD.GerenciaFornecedor;
import Controller.GerenciaTabelasBD.GerenciaIngredientes;
import Model.TabelasBD.Fornecedor;
import Model.TabelasBD.Ingrediente;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import jfxtras.scene.control.LocalTimePicker;

import java.time.LocalTime;
import java.util.List;

public class CadastraCompraIngrediente extends WindowCadastro {

    private ComboBox<String> comboBoxFornec;
    private ComboBox<String> comboBoxIngred;
    private DatePicker datePickerData;
    private LocalTimePicker timePicker;
    private TextField textFieldQtdeIngred;
    private TextField textFieldPreco;

    public void ChangeScene() {

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Fornecedor:", 0, 1);
        CriaLabel("Ingrediente:", 0, 2);
        CriaLabel("Data:", 0, 3);
        CriaLabel("Hora:", 0, 4);
        CriaLabel("Quantidade:", 0, 5);
        CriaLabel("Preço:", 0, 6);

        // inicialização das variáveis de comboBox
        comboBoxFornec = CriaComboBox(GerenciaFornecedor.SelectFornecedoresNome(), 1, 1);
        comboBoxIngred = CriaComboBox(GerenciaIngredientes.SelectIngredientesNome(), 1, 2);

        // inicialização da variável de datePicker
        datePickerData = CriaDatePicker(1, 3);

        // inicializa timePicker
        timePicker = CriaTimePicker(1, 4);

        // inicialização das variáveis de campo de texto
        textFieldQtdeIngred = CriaNumericTextField("Quantidade", 1, 5);
        textFieldPreco = CriaNumericTextField("Preço", 1, 6);

        // inicialização do botão que adiciona nova compra
        button_ok = CriaButton("OK", 0, 8);
        // ação ao clicar no botão que adiciona nova compra
        button_ok.setOnAction(e -> {

            // seleciona todos os fornecedores
            List<Fornecedor> fornecs = GerenciaFornecedor.SelectFornecedores();
            String cnpj = "";

            // para cada fornecedor da lista
            for(Fornecedor fornec : fornecs){
                // se o nome do fornecedor da lista for igual ao nome selecionado na comboBox de fornecedores
                if(fornec.getNome().equals(comboBoxFornec.getSelectionModel().getSelectedItem())){
                    // salva o cnpj do fornecedor (chave primária da tabela de fornecedores)
                    cnpj = fornec.getCNPJ();
                }
            }

            // seleciona todos os ingredientes
            List<Ingrediente> ingreds = GerenciaIngredientes.SelectIngredientes();
            int codIngred = 0;

            // para cada ingrediente da lista
            for(Ingrediente ingred : ingreds){
                // se o nome do ingrediente da lista for igual ao nome selecionado na comboBox de ingredientes
                if(ingred.getNome().equals(comboBoxIngred.getSelectionModel().getSelectedItem())){
                    // salva o código do ingrediente (chave primária da tabela de ingredientes)
                    codIngred = ingred.getCod();
                }
            }

            // salva a hora atual do sistema
            LocalTime hora = timePicker.getLocalTime();

            // insere uma nova compra de ingredientes, passando os dados de entrada da cena
            GerenciaCompraIngrediente.InsertCompraIngrediente(cnpj, codIngred, datePickerData.getValue(), hora, Integer.parseInt(textFieldQtdeIngred.getText()), Float.parseFloat(textFieldPreco.getText()));
        });

        // inicialização do botão que volta para tela principal
        button_voltar = CriaButton("Voltar", 1, 8);
        // ação a clicar no botão que voltar para tela principal
        button_voltar.setOnAction(e -> {
            // muda cena atual para a cena da janela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}