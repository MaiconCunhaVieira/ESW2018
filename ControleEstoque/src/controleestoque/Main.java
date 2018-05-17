// Criado por Octavio Arruda 10 05 18
package controleestoque;

// Para a GUI(JavaFX)
import Scenes.CadastraCompraIngrediente;
import TabelasBD.Ingrediente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;


public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
    public static Stage window;
    //Scene scene_cad_fornec;
    Button button_cad_compra_ingred, button_ok;

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
        ovo.setCod(123);
        ovo.setNome("ovo");
        ovo.setQtdeAtual(100);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Option 1",
                        ovo.getNome(), // lmao getNome pra listar o nome do objeto ovo criado
                        "Option 3"
                );

        final ComboBox comboBox = new ComboBox(options);


        window = primaryStage;
        window.setTitle("Controle de Estoque");
        button_cad_compra_ingred = new Button();
        button_cad_compra_ingred.setText("Cadastrar nova compra de ingrediente.");
        button_cad_compra_ingred.setOnAction(e -> {

            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            //window.setScene(scene_cad_fornec);
            CadastraCompraIngrediente.ChangeScene();

        });

        GridPane layout = new GridPane();
        layout.add(button_cad_compra_ingred, 0, 0);
        layout.setMinSize(400, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));
        comboBox.getItems().addAll("Option 4", "Option 5", "Option 6");
        layout.add(comboBox, 1,0);
        //layout.getChildren().add(button_fornec);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
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
