// Criado por Octavio Arruda 10 05 18

// Para a GUI(JavaFX)
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;


public class Main extends Application/* implements EventHandler<ActionEvent> */{ // Sem event handler: lambda expressions

    Stage window;
    Scene scene_cad_fornec;
    Button button_fornec, button_ok;

    public static void main(String[] args) {

        System.out.println("Debug");
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Controle de Estoque");
        button_fornec = new Button();
        button_fornec.setText("Novo Fornecedor");
        button_fornec.setOnAction(e -> {

            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            window.setScene(scene_cad_fornec);

        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button_fornec);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

        // Layout cad_fornec
        GridPane layout_fornec = new GridPane();

        // botton for cad_fornec
        button_ok = new Button();
        button_ok.setText("Ok");

        // Text label for cad_fornec scene
        Label Label_cad = new Label("Digite as informações do fornecedor");
        Label_cad.setTextAlignment(TextAlignment.JUSTIFY);
        
        layout_fornec.setPadding(new Insets(20, 20, 20, 20));
        layout_fornec.getChildren().addAll(Label_cad, button_ok);
        scene_cad_fornec = new Scene(layout_fornec, 500, 450);
        button_ok.setOnAction(e -> {
            // Ok button code for new fornec data
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
