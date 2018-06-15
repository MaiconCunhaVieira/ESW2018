package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class JanelaAlerta extends Window {

    // mostra a janela de alerta contendo uma única mensagem
    public static void Display(String title, String message){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER); // coloca janela no centro da tela

        // cria nova janela
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        // cria label com a mensagem de alerta
        CriaLabel(message, 0, 0);

        // inicializa botão para voltar
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(event -> {
            // ação do botão é fechar a janela
            window.close();
        });

        // inicializa cena
        scene = new javafx.scene.Scene(layout);
        window.setScene(scene);

        window.showAndWait(); // mostra janela, impedindo usuário de ignorá-la
    }

    // mostra a janela de alerta contendo uma lista de mensagens
    public static void Display(String title, List<String> messages){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER); // coloca janela no centro da tela

        // cria nova janela
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        // cria uma string que conterá todas as mensagens passadas na lista
        String message = "";
        for(String str : messages)
            message = message + str + "\n";

        // cria label com a mensagem de alerta
        CriaLabel(message, 0, 0);

        // inicializa botão para voltar
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(event -> {
            // ação do botão é fechar a janela
            window.close();
        });

        // inicializa cena
        scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait(); // mostra janela, impedindo usuário de ignorá-la
    }
}
