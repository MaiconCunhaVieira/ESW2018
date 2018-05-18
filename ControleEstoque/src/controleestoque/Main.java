// Criado por Octavio Arruda 10 05 18
package controleestoque;

// Para a GUI(JavaFX)
import Scenes.CadastraCompraIngrediente;
import Scenes.CadastraProducao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;

import java.util.List;


public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
    public static Stage window;
    private GridPane layout;
    private MenuBar menuBar;

    public static void main(String[] args) {

        System.out.println("Debug");
        launch(args); //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Controle de Estoque");
        layout = new GridPane();
        layout.setMinSize(400, 200);
        //layout.setPadding(new Insets(10, 10, 10, 10));
        //layout.getChildren().add(button_fornec);

        InitializeMenuBar();

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void InitializeMenuBar(){
        menuBar = new MenuBar();

        Menu menuCadastrar = new Menu("Cadastrar");
        Menu menuPesquisar = new Menu("Pesquisar");
        MenuItem itemCadCompraIngred = new MenuItem("Compra de Ingrediente");
        MenuItem itemCadProducao = new MenuItem("Produção");

        menuBar.getMenus().addAll(menuCadastrar, menuPesquisar);
        menuCadastrar.getItems().addAll(itemCadCompraIngred, itemCadProducao);

        itemCadCompraIngred.setOnAction(event -> {
            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            CadastraCompraIngrediente cadastraCompraIngrediente = new CadastraCompraIngrediente();
            cadastraCompraIngrediente.ChangeScene();
        });

        itemCadProducao.setOnAction(event -> {
            System.out.println("Lambda expression button");
            System.out.println("Equivale ao void handle...");
            CadastraProducao cadastraProducao = new CadastraProducao();
            cadastraProducao.ChangeScene();
        });

        layout.add(menuBar, 0, 0);
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
