// Criado por Octavio Arruda 10 05 18

// Para a GUI(JavaFX)
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application/* implements EventHandler<ActionEvent> */{ // Sem event handler: lambda expressions

    Button button;

    public static void main(String[] args) {

        System.out.println("Debug");
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controle de Estoque");
        button = new Button();
        button.setText("Adicionar");
        button.setOnAction(e -> {
            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
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
