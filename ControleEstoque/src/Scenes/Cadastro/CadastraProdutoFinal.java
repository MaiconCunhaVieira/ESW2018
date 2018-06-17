package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraProdutoFinal extends WindowCadastro {
    private ComboBox<String> comboBoxProdutoFinal;
    private DatePicker datePickerData;
    private TextField NomeProd;
    private TextField textFieldPreco;
    private TextField textFieldPeso;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Nome:", 0, 0);
        CriaLabel("Preço:", 0, 1);
        CriaLabel("Peso:", 0, 2);

        // inicialização das variáveis de campo de texto
        NomeProd = CriaTextField("Nome do Produto", 1, 0);
        textFieldPreco = CriaTextField("Preço", 1, 1);
        textFieldPeso = CriaTextField("Em miligramas", 1, 2);


        // inicialização do botão que adiciona nova produção
        button_ok = CriaButton("OK", 0, 5);
        // ação ao clicar no botão que adiciona nova compra
        button_ok.setOnAction(e -> {
            /* action do botão de ok para cadastrar novo prod. final
                AQUI VAI CÓDIGO QUE COLOCA NO BANCO DE DADOS O NOVO INGREDIENTE
                        *********************
             */

            /* Pegando os dados dos textfields */
            String nomeProdFinal = NomeProd.getText();
            String precoProdFinal = textFieldPreco.getText();
            String pesoProdFinal = textFieldPeso.getText();

            /* Convertendo o peso e preco pra int e float */
            int pesoProdF = Integer.valueOf(pesoProdFinal).intValue();
            float precoProdF = Float.valueOf(precoProdFinal).floatValue();

            /* Chamando o método da classe GerenciaProdutoFinal que coloca o item no banco de dados. */
            GerenciaProdutoFinal.InsertProdutoFinal(nomeProdFinal, precoProdF, pesoProdF);
        });

        button_voltar = CriaButton("Voltar", 1, 5);
        button_voltar.setOnAction(event -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa a cena
        scene = new Scene(layout, 300, 250);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
