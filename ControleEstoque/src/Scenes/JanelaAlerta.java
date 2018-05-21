package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class JanelaAlerta extends Window {

    public static void Display(String title, String message){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        CriaLabel(message, 0, 0);
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(event -> {
            window.close();
        });

        scene = new javafx.scene.Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void Display(String title, List<String> messages){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        String message = "";
        for(String str : messages)
            message = message + str + "\n";

        CriaLabel(message, 0, 0);
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(event -> {
            window.close();
        });

        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
