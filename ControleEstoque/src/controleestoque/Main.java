// Criado por Octavio Arruda 10 05 18
package controleestoque;

// Para a GUI(JavaFX)
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;


public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
    Stage window;
    Scene scene_cad_fornec;
    Button button_ingred, button_ok;

    public static void main(String[] args) {

        System.out.println("Debug");

        /*Ingrediente ovo = new Ingrediente(); classe Ingrediente, Fornecedor, CompraIngrediente
        ovo.setCod("123");                      funcionando só dentro da main (?)
        */
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Ingrediente ovo = new Ingrediente();
        ovo.setCod("123");
        ovo.setNome("ovo");
        ovo.setQuantAtual("100");

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Option 1",
                        ovo.getNome(), // lmao getNome pra listar o nome do objeto ovo criado
                        "Option 3"
                );

        final ComboBox comboBox = new ComboBox(options);


        window = primaryStage;
        window.setTitle("Controle de Estoque");
        button_ingred = new Button();
        button_ingred.setText("Novo Ingrediente");
        button_ingred.setOnAction(e -> {

            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            window.setScene(scene_cad_fornec);

        });

        GridPane layout = new GridPane();
        layout.add(button_ingred, 0, 0);
        layout.setMinSize(400, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));
        comboBox.getItems().addAll(
                "Option 4",
                "Option 5",
                "Option 6"
        );
        layout.add(comboBox, 1,0);
        //layout.getChildren().add(button_fornec);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

        // Layout cad_fornec
        GridPane layout_ingred = new GridPane();
        layout_ingred.setVgap(5);
        layout_ingred.setHgap(5);

        // botton for cad_fornec
        button_ok = new Button();
        button_ok.setText("Ok");

        // Text label for cad_ingred scene
        Label Label_cod = new Label("Código:");
        Label_cod.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_CNPJ = new Label("Nome:");
        Label_CNPJ.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_name = new Label("Quantidade:");

        // Text field inputs for the new ingredient scene
        TextField TFcod = new TextField();
        TFcod.setPromptText("Código");
        TextField TFName = new TextField();
        TFName.setPromptText("Nome do Ingrediente");
        TextField TFqnt = new TextField();
        TFqnt.setPromptText("Quantidade");


        // Putting the labels and buttons on the cad_fornec Stage Scene
        layout_ingred.setAlignment(Pos.CENTER);
        layout_ingred.add(Label_cod, 0, 0);
        layout_ingred.add(Label_CNPJ, 0, 1);
        layout_ingred.add(Label_name, 0, 2);
        layout_ingred.add(button_ok, 0,3);


        // Putting the text fields on the cad_fornec Stage Scene
        layout_ingred.add(TFcod,1,0);
        layout_ingred.add(TFName, 1,1);
        layout_ingred.add(TFqnt, 1, 2);

        scene_cad_fornec = new Scene(layout_ingred, 300, 250);
        button_ok.setOnAction(e -> {
            // Code for action here
            // gather data to put on BD
        });
    }

    /*
    @Override
    public void handle(ActionEvent event) { // Quando o usuário clica no botão
        // Código aqui
        if(event.getSource() == button){ // Qual botão causou o evento
            System.out.println("Don' touch me");
        }
    }
    */
}
