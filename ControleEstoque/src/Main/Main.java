// Criado por Octavio Arruda 10 05 18
package Main;

// Para a GUI(JavaFX)
import Scenes.Cadastro.CadastraCompraIngrediente;
import Scenes.Cadastro.CadastraProducao;
import Scenes.Cadastro.CadastraVendaProduto;
import Scenes.Pesquisa.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application/* implements EventHandler<ActionEvent> */{
    // Sem event handler: lambda expressions
    // lambda expressions = método de fazer as actions do botão de maneiras simples e eficaz.
    public static Stage window;
    public static Scene scene;
    private GridPane layout;
    private MenuBar menuBar;

    public static void main(String[] args) {

        //System.out.println("Debug");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Controle de Estoque");
        layout = new GridPane();
        layout.setMinSize(400, 200);
        //layout.setPadding(new Insets(0, 0, 0, 0));
        //layout.getChildren().add(button_fornec);

        InitializeMenuBar();

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void InitializeMenuBar(){
        menuBar = new MenuBar();

        Menu menuCadastrar = new Menu("Cadastrar");
        MenuItem itemCadCompraIngred = new MenuItem("Compra de Ingrediente");
        MenuItem itemCadProducao = new MenuItem("Produção");
        MenuItem itemCadVendaProd = new MenuItem("Venda de Produto");

        Menu menuPesquisar = new Menu("Pesquisar");
        MenuItem itemPesqCompraIngred = new MenuItem("Compra de Ingrediente");
        MenuItem itemPesqProducao = new MenuItem("Produção");
        MenuItem itemPesqProdutoFinal = new MenuItem("Produto");
        MenuItem itemPesqIngrediente = new MenuItem("Ingrediente");
        MenuItem itemPesqVendaProdFinal = new MenuItem("Venda de Produto");

        menuBar.getMenus().addAll(menuCadastrar, menuPesquisar);
        menuCadastrar.getItems().addAll(itemCadCompraIngred, itemCadProducao, itemCadVendaProd);
        menuPesquisar.getItems().addAll(itemPesqCompraIngred, itemPesqProducao, itemPesqProdutoFinal, itemPesqIngrediente, itemPesqVendaProdFinal);

        itemCadCompraIngred.setOnAction(event -> {
            //System.out.println("Lambda expression button");
            //System.out.println("Equivale ao void handle...");
            CadastraCompraIngrediente cadCompraIngred = new CadastraCompraIngrediente();
            cadCompraIngred.ChangeScene();
        });

        itemCadProducao.setOnAction(event -> {
            //System.out.println("Lambda expression button");
            //System.out.println("Equivale ao void handle...");
            CadastraProducao cadProducao = new CadastraProducao();
            cadProducao.ChangeScene();
        });

        itemCadVendaProd.setOnAction(event -> {
            CadastraVendaProduto cadVendaProd = new CadastraVendaProduto();
            cadVendaProd.ChangeScene();
        });

        itemPesqCompraIngred.setOnAction(event -> {
            PesquisaCompraIngrediente pesqCompraIngred = new PesquisaCompraIngrediente();
            pesqCompraIngred.ChangeScene();
        });

        itemPesqProducao.setOnAction(event -> {
            PesquisaProducao pesqProducao = new PesquisaProducao();
            pesqProducao.ChangeScene();
        });

        itemPesqProdutoFinal.setOnAction(event -> {
            PesquisaProdutoFinal pesqProdFinal = new PesquisaProdutoFinal();
            pesqProdFinal.ChangeScene();
        });

        itemPesqIngrediente.setOnAction(event -> {
            PesquisaIngrediente pesqIngrediente = new PesquisaIngrediente();
            pesqIngrediente.ChangeScene();
        });

        itemPesqVendaProdFinal.setOnAction(event -> {
            PesquisaVendaProduto pesqVendaProd = new PesquisaVendaProduto();
            pesqVendaProd.ChangeScene();
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
