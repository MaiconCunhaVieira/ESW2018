package View.Cadastro;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaProducao;
import Controller.GerenciaTabelasBD.GerenciaProdutoFinal;
import Model.TabelasBD.ProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.util.List;

public class CadastraProducao extends WindowCadastro {

    private ComboBox<String> comboBoxProdutoFinal;
    private DatePicker datePickerData;
    private TextField textFieldHora;
    private TextField textFieldQtdeProd;

    public void ChangeScene(){

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Nome do Produto:", 0, 1);
        CriaLabel("Data:", 0, 2);
        CriaLabel("Hora:", 0, 3);
        CriaLabel("Quantidade:", 0, 4);
        CriaLabel("", 0, 7);

        // inicialização das variáveis de combobox
        comboBoxProdutoFinal = CriaComboBox(GerenciaProdutoFinal.SelectProdutosFinaisNome(), 1, 1);

        // inicialização da variável de datePicker
        datePickerData = CriaDatePicker(1, 2);

        // inicialização das variáveis de campo de texto
        textFieldHora = CriaTextField("Hora", 1, 3);
        textFieldQtdeProd = CriaNumericTextField("Quantidade", 1, 4);

        // inicialização do botão que adiciona nova produção
        button_ok = CriaButton("OK", 0, 5);
        // ação ao clicar no botão que adiciona nova compra
        button_ok.setOnAction(e -> {

            // seleciona todos os produtos
            List<ProdutoFinal> prodsFinais = GerenciaProdutoFinal.SelectProdutosFinais();
            int codPF = 0;

            // para cada produto da lista
            for(ProdutoFinal pf : prodsFinais){
                // se o nome do produto da lista for igual ao nome selecionado na combobox do produto
                if(pf.getNome().equals(comboBoxProdutoFinal.getSelectionModel().getSelectedItem()))
                    // salva o código do produto (chave primária da tabela de produtos)
                    codPF = pf.getCod();
            }

            // insere nova produção passando os dados de entrada da cena
            GerenciaProducao.InsertProducao(codPF, datePickerData.getValue(), LocalTime.now(), Integer.parseInt(textFieldQtdeProd.getText()));
        });

        // inicialização do botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 1, 5);
        // ação ao clicar no botão que volta para a tela principal
        button_voltar.setOnAction(e -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}