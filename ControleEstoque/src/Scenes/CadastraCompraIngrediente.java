package Scenes;

import controleestoque.Main;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CadastraCompraIngrediente {//extends Application {

    static Scene scene;
    static Button button_ok;
    static GridPane layout;

//    public static void main(String[] args){
//        launch(args);
//    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        ChangeScene();
//    }

    public static void ChangeScene(){

        // Layout cad_fornec
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);

        // Buttons added to scene
        button_ok = CriaButton("OK", 0, 5);

        // Labels added to scene
        CriaLabel("Informações:", 0, 0);
        CriaLabel("Fornecedor:(será combobox)", 0, 1);
        CriaLabel("Ingrediente:(será combobox)", 0, 2);
        CriaLabel("Quantidade a ser comprada:(será campo numerico)", 0, 3);

        // TextFields added to scene
        CriaTextField("Fornecedor", 1, 1);
        CriaTextField("Ingrediente", 1, 2);
        CriaTextField("Quantidade", 1, 3);

        layout.setAlignment(Pos.CENTER);
        //layout.add(button_ok, 0,5);

        // Scene initialized
        scene = new Scene(layout, 300, 250);
        button_ok.setOnAction(e -> {

        });

        // change window from Main to this scene
        Main.window.setScene(scene);
    }

    private static Button CriaButton(String text, int columnIndex, int rowIndex){
        Button button = new Button();
        button.setText(text);
        layout.add(button, columnIndex, rowIndex);
        return button;
    }

    private static void CriaLabel(String text, int columnIndex, int rowIndex) {
        Label label = new Label(text);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        layout.add(label, columnIndex, rowIndex);
    }

    private static void CriaTextField(String text, int columnIndex, int rowIndex){
        TextField textField = new TextField();
        textField.setPromptText(text);
        layout.add(textField,columnIndex, rowIndex);
    }
}
