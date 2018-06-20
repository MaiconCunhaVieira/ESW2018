package View.Cadastro;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaCliente;
import View.JanelaAlerta;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraCliente extends WindowCadastro {

    private TextField textFieldCNPJCliente;
    private TextField textFieldNomeCliente;
    private TextField textFieldEnderecoCliente;
    private TextField textFieldTeledoneCliente;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("CNPJ do Cliente:", 0, 1);
        CriaLabel("Nome do Cliente:", 0, 2);
        CriaLabel("Endereço:", 0, 3);
        CriaLabel("Telefone", 0, 4);

        // inicialização das variáveis de campo de texto
        textFieldCNPJCliente = CriaTextField("CNPJ", 1, 1);
        textFieldNomeCliente = CriaTextField("Nome", 1, 2);
        textFieldEnderecoCliente = CriaTextField("Endereço", 1, 3);
        textFieldTeledoneCliente = CriaTextField("Telefone", 1, 4);

        // inicialização do botão que adiciona novo cliente
        button_ok = CriaButton("OK", 0, 5);
        button_ok.setOnAction(event -> {
            // salva dados de entrada
            String CNPJCliente = textFieldCNPJCliente.getText();
            String nomeCliente = textFieldNomeCliente.getText();
            String enderecoCliente = textFieldEnderecoCliente.getText();
            String telefoneCliente = textFieldTeledoneCliente.getText();

            if(!CNPJCliente.isEmpty() & !nomeCliente.isEmpty() & !enderecoCliente.isEmpty() & !telefoneCliente.isEmpty()){
                GerenciaCliente.InsertNovoCliente(CNPJCliente, nomeCliente, enderecoCliente, telefoneCliente);
                JanelaAlerta.Display("Sucesso", "Novo cliente adicionado.");
            }
            else {
                JanelaAlerta.Display("Erro", "Dados de entrada devem ser preenchidos.");
            }
        });

        // inicializa botão que volta para a tela principal
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
