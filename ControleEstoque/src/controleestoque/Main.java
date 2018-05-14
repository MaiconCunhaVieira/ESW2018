// Criado por Octavio Arruda 10 05 18
package controleestoque;
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
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
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

        GridPane layout = new GridPane();
        layout.add(button_fornec, 0, 0);
        layout.setMinSize(400, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));
        //layout.getChildren().add(button_fornec);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

        // Layout cad_fornec
        GridPane layout_fornec = new GridPane();
        layout_fornec.setVgap(5);
        layout_fornec.setHgap(5);

        // botton for cad_fornec
        button_ok = new Button();
        button_ok.setText("Ok");

        // Text label for cad_fornec scene
        Label Label_cad = new Label("Informações:");
        Label_cad.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_CNPJ = new Label("CNPJ:");
        Label_CNPJ.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_name = new Label("Nome:");
        Label_name.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_adr = new Label("Endereço:");
        Label_adr.setTextAlignment(TextAlignment.JUSTIFY);
        Label Label_phone = new Label("Telefone:");
        Label_phone.setTextAlignment(TextAlignment.JUSTIFY);

        // Text field inputs for the cad_fornec scene
        TextField TFCNPJ = new TextField();
        TFCNPJ.setPromptText("CNPJ");
        TextField TFName = new TextField();
        TFName.setPromptText("Nome do fornecedor");
        TextField TFAdr = new TextField();
        TFAdr.setPromptText("Endereço");
        TextField TFPhone = new TextField();
        TFPhone.setPromptText("Telefone");


        // Putting the labels and buttons on the cad_fornec Stage Scene
        layout_fornec.setAlignment(Pos.CENTER);
        layout_fornec.add(Label_cad, 0, 0);
        layout_fornec.add(Label_CNPJ, 0, 1);
        layout_fornec.add(Label_name, 0, 2);
        layout_fornec.add(Label_adr, 0, 3);
        layout_fornec.add(Label_phone, 0, 4);
        layout_fornec.add(button_ok, 0,5);


        // Putting the text fields on the cad_fornec Stage Scene
        layout_fornec.add(TFCNPJ,1,1);
        layout_fornec.add(TFName, 1,2);
        layout_fornec.add(TFAdr, 1, 3);
        layout_fornec.add(TFPhone,1,4);

        scene_cad_fornec = new Scene(layout_fornec, 300, 250);
        button_ok.setOnAction(e -> {
            // Code for action here
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
