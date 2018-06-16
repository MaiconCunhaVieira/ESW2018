package Scenes.Cadastro;

import Main.Main;
import ManageDBTables.GerenciaFornecedor;
import Scenes.JanelaAlerta;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastraFornecedor extends WindowCadastro {

    private TextField textFieldCNPJFornec;
    private TextField textFieldNomeFornec;
    private TextField textFieldEnderecoFornec;
    private TextField textFieldTeledoneFornec;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // criação de todas as labels da cena
        CriaLabel("Informações:", 0, 0);
        CriaLabel("CNPJ do Fornecedor:", 0, 1);
        CriaLabel("Nome do Fornecedor:", 0, 2);
        CriaLabel("Endereço:", 0, 3);
        CriaLabel("Telefone", 0, 4);

        // inicialização das variáveis de campo de texto
        textFieldCNPJFornec = CriaTextField("CNPJ", 1, 1);
        textFieldNomeFornec = CriaTextField("Nome", 1, 2);
        textFieldEnderecoFornec = CriaTextField("Endereço", 1, 3);
        textFieldTeledoneFornec = CriaTextField("Telefone", 1, 4);

        // inicialização do botão que adiciona novo fornecedor
        button_ok = CriaButton("OK", 0, 5);
        button_ok.setOnAction(event -> {
            // salva dados de entrada
            String CNPJFornec = textFieldCNPJFornec.getText();
            String nomeFornec = textFieldNomeFornec.getText();
            String enderecoFornec = textFieldEnderecoFornec.getText();
            String telefoneFornec = textFieldTeledoneFornec.getText();

            if(!CNPJFornec.isEmpty() & !nomeFornec.isEmpty() & !enderecoFornec.isEmpty() & !telefoneFornec.isEmpty()){
                GerenciaFornecedor.InsertNovoFornecedor(CNPJFornec, nomeFornec, enderecoFornec, telefoneFornec);
                JanelaAlerta.Display("Sucesso", "Novo fornecedor adicionado.");
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
