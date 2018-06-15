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

        // cria todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Cliente:", 0, 1);
        CriaLabel("Produto:", 0, 2);
        CriaLabel("Data:", 0, 3);
        CriaLabel("Hora:", 0, 4);
        CriaLabel("Quantidade:", 0, 5);

        // inicialização das variáveis de combobox
        comboBoxCliente = CriaComboBox(GerenciaCliente.SelectClientesNome(), 1, 1);
        comboBoxProdFinal = CriaComboBox(GerenciaProdutoFinal.SelectProdutosFinaisNome(), 1, 2);

        // inicialização da variável de datepicker
        datePickerData = CriaDatePicker(1, 3);

        // inicialização das variáveis de campo de texto
        textFieldHora = CriaTextField("Hora", 1, 4);
        textFieldQtde = CriaNumericTextField("Quantidade", 1, 5);

        // inicialização do botão que adiciona nova venda
        button_ok = CriaButton("OK", 0, 7);
        // ação ao clicar no botão que adiciona nova venda
        button_ok.setOnAction(event -> {

            // seleciona todos os clientes
            List<Cliente> clientes = GerenciaCliente.SelectClientes();

            // seleciona todos os produtos
            List<ProdutoFinal> prodFinais = GerenciaProdutoFinal.SelectProdutosFinais();

            String cnpjCliente = "";

            // para cada cliente da lista
            for(Cliente c : clientes){
                // se o nome do cliente da lista for igual ao nome selecionado na combobox de clientes
                if(c.getNome().equals(comboBoxCliente.getSelectionModel().getSelectedItem()))
                    // salva cnpj do cliente (chave primária da tabela de clientes)
                    cnpjCliente = c.getCNPJ();
            }

            int codPF = 0;
            // para cada produto da lista
            for(ProdutoFinal pf : prodFinais){
                // se o nome do produto da lista for igual ao nome selecionado na combobox de produtos
                if(pf.getNome().equals(comboBoxProdFinal.getSelectionModel().getSelectedItem()))
                    // salva código do produto (chave primária da tabela de produtos)
                    codPF = pf.getCod();
            }

            // insere nova venda de produto, passando os dados de entrada da cena
            GerenciaVendaProdutoFinal.InsertVendaProdutoFinal(cnpjCliente, codPF, datePickerData.getValue(), LocalTime.now(), Integer.parseInt(textFieldQtde.getText()));
        });

        // inicialização do botçao que volta para a tela principal
        button_voltar = CriaButton("Voltar", 1, 7);
        // ação ao clicar no botão que volta para a tela principal
        button_voltar.setOnAction(event -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
