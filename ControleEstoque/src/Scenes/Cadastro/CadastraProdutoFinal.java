package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaProdutoFinal;
import Scenes.JanelaAlerta;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraProdutoFinal extends WindowCadastro {

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


        // inicialização do botão que adiciona novo produto
        button_ok = CriaButton("OK", 0, 5);
        // ação ao clicar no botão que adiciona novo produto
        button_ok.setOnAction(e -> {

            /* Pegando os dados dos textfields */
            String nomeProdFinal = NomeProd.getText();
            String precoProdFinal = textFieldPreco.getText();
            String pesoProdFinal = textFieldPeso.getText();

            if(!nomeProdFinal.isEmpty() & !precoProdFinal.isEmpty() & !pesoProdFinal.isEmpty()){
                /* Convertendo o peso e preco pra int e float */
                int pesoProdF = Integer.valueOf(pesoProdFinal).intValue();
                float precoProdF = Float.valueOf(precoProdFinal).floatValue();

                /* Chamando o método da classe GerenciaProdutoFinal que coloca o item no banco de dados. */
                GerenciaProdutoFinal.InsertProdutoFinal(nomeProdFinal, precoProdF, pesoProdF);
                JanelaAlerta.Display("Sucesso", "Novo produto adicionado.");
            }
            else {
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos;");
            }
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
