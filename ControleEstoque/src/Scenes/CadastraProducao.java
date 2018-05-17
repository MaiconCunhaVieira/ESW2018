package Scenes;

import controleestoque.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CadastraProducao extends Cadastro{

//    static Scene scene;
//    static Button button_ok;
//    static GridPane layout;

    public static void ChangeScene(){

        // Layout cad_fornec
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 5);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Nome do Produto:(será combobox)", 0, 1);
        CriaLabel("Data:(opção para 'hoje')", 0, 2);
        CriaLabel("Hora:(opção para 'agora')", 0, 3);
        CriaLabel("Quantidade a ser produzida:(será campo numerico)", 0, 4);

        // TextFields added to scene
        CriaTextField("Produto", 1, 1);
        CriaTextField("Data", 1, 2);
        CriaTextField("Hora", 1, 3);
        CriaTextField("Quantidade", 1, 4);

        layout.setAlignment(Pos.CENTER);
        //layout.add(button_ok, 0,5);

        // Scene initialized
        scene = new Scene(layout, 300, 250);
        button_ok.setOnAction(e -> {

        });

        // change window from Main to this scene
        Main.window.setScene(scene);
    }
}