package Scenes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

import java.time.LocalDate;
import java.util.List;

public abstract class Window {

    protected static Scene scene;
    protected static Button button_voltar;
    protected static GridPane layout;

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

    protected static TextField CriaTextField(String text, int columnIndex, int rowIndex){
        TextField textField = new TextField();
        textField.setPromptText(text);
        layout.add(textField,columnIndex, rowIndex);
        return textField;
    }

    protected static TextField CriaNumericTextField(String text, int columnIndex, int rowIndex){
        TextField textField = new TextField();
        textField.setPromptText(text);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        layout.add(textField,columnIndex, rowIndex);
        return textField;
    }

    protected static ComboBox<String> CriaComboBox(List<String> options, int columnIndex, int rowIndex){
        ComboBox<String> comboBox = new ComboBox();
        for (String op : options) {
            comboBox.getItems().add(op);
        }
        layout.add(comboBox, columnIndex, rowIndex);
        return comboBox;
    }

    protected static DatePicker CriaDatePicker(int columnIndex, int rowIndex){
        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
        });
        layout.add(datePicker, columnIndex, rowIndex);
        return datePicker;
    }

    protected static TableColumn CriaTableColumn(TableColumn tableColumn, String classAttributeName, int minWidth){
        tableColumn.setMinWidth(minWidth);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(classAttributeName));
        return tableColumn;
    }
}
