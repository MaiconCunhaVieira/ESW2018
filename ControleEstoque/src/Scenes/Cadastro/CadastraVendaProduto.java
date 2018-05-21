package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaCliente;
import ManageDBTables.GerenciaProdutoFinal;
import ManageDBTables.GerenciaVendaProdutoFinal;
import TabelasBD.Cliente;
import TabelasBD.ProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.util.List;

public class CadastraVendaProduto extends WindowCadastro {

    private ComboBox<String> comboBoxCliente;
    private ComboBox<String> comboBoxProdFinal;
    private DatePicker datePickerData;
    private TextField textFieldHora;
    private TextField textFieldQtde;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Cliente:", 0, 1);
        CriaLabel("Produto:", 0, 2);
        CriaLabel("Data:", 0, 3);
        CriaLabel("Hora:", 0, 4);
        CriaLabel("Quantidade:", 0, 5);

        // ComboBoxes added to scene
        comboBoxCliente = CriaComboBox(GerenciaCliente.SelectClientesNome(), 1, 1);
        comboBoxProdFinal = CriaComboBox(GerenciaProdutoFinal.SelectProdutosFinaisNome(), 1, 2);

        // DatePicker added to scene
        datePickerData = CriaDatePicker(1, 3);

        // TextFields added to scene
        textFieldHora = CriaTextField("Hora", 1, 4);
        textFieldQtde = CriaNumericTextField("Quantidade", 1, 5);

        button_ok = CriaButton("OK", 0, 7);
        button_ok.setOnAction(event -> {
            List<Cliente> clientes = GerenciaCliente.SelectClientes();
            List<ProdutoFinal> prodFinais = GerenciaProdutoFinal.SelectProdutosFinais();
            String cnpjCliente = "";
            for(Cliente c : clientes){
                if(c.getNome().equals(comboBoxCliente.getSelectionModel().getSelectedItem()))
                    cnpjCliente = c.getCNPJ();
            }

            int codPF = 0;
            for(ProdutoFinal pf : prodFinais){
                if(pf.getNome().equals(comboBoxProdFinal.getSelectionModel().getSelectedItem()))
                    codPF = pf.getCod();
            }

            GerenciaVendaProdutoFinal.InsertVendaProdutoFinal(cnpjCliente, codPF, datePickerData.getValue(), LocalTime.now(), Integer.parseInt(textFieldQtde.getText()));
        });
        button_voltar = CriaButton("Voltar", 1, 7);
        button_voltar.setOnAction(event -> {
            Main.window.setScene(Main.scene);
        });

        // Scene initialized
        scene = new Scene(layout, 300, 250);

        // change window from Main to this scene
        Main.window.setScene(scene);
    }
}
