// Criado por Octavio Arruda 10 05 18
package controleestoque;

// Para a GUI(JavaFX)
import Scenes.CadastraCompraIngrediente;
import Scenes.CadastraProducao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;


public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
    public static Stage window;
    Button button_cad_compra_ingred, button_cad_producao;

    public static void main(String[] args) {

        System.out.println("Debug");
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Controle de Estoque");
        button_cad_compra_ingred = new Button();
        button_cad_compra_ingred.setText("Cadastrar nova compra de ingrediente");
        button_cad_compra_ingred.setOnAction(e -> {

            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            CadastraCompraIngrediente cadastraCompraIngrediente = new CadastraCompraIngrediente();
            cadastraCompraIngrediente.ChangeScene();

        });

        button_cad_producao = new Button();
        button_cad_producao.setText("Cadastrar nova produção");
        button_cad_producao.setOnAction(e -> {

            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            CadastraProducao cadastraProducao = new CadastraProducao();
            cadastraProducao.ChangeScene();

        });

        GridPane layout = new GridPane();
        layout.add(button_cad_compra_ingred, 0, 0);
        layout.add(button_cad_producao, 0, 1);
        layout.setMinSize(400, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));
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
