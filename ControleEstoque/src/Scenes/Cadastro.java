package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public abstract class Cadastro {

    protected static Scene scene;
    protected static Button button_ok;
    protected static GridPane layout;

    //protected abstract void ChangeScene();

    protected static Button CriaButton(String text, int columnIndex, int rowIndex){
        Button button = new Button();
        button.setText(text);
        layout.add(button, columnIndex, rowIndex);
        return button;
    }

    protected static void CriaLabel(String text, int columnIndex, int rowIndex) {
        Label label = new Label(text);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        layout.add(label, columnIndex, rowIndex);
    }

    protected static void CriaTextField(String text, int columnIndex, int rowIndex){
        TextField textField = new TextField();
        textField.setPromptText(text);
        layout.add(textField,columnIndex, rowIndex);
    }
}
