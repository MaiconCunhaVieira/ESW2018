package View.Main;

import View.Cadastro.*;
import View.DadosEstatisticos.SceneDadosEstatClientes;
import View.DadosEstatisticos.SceneDadosEstatGastos;
import View.DadosEstatisticos.SceneDadosEstatIngredientes;
import View.DadosEstatisticos.SceneDadosEstatProdutos;
import View.Modificar.ModificarReceitaChooseProduto;
import View.Pesquisa.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window; // janela principal do sistema
    public static Scene scene; // cena da janela
    private GridPane layout; // layout da cena
    private MenuBar menuBar; // barra de menu no topo da janela

    public static void main(String[] args) {

        launch(args); // chama método 'start'
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Controle de Estoque");
        layout = new GridPane();
        layout.setMinSize(400, 200);

        InitializeMenuBar();

        scene = new Scene(layout, 350, 250);
        window.setScene(scene);
        window.show();
    }

    // Método faz toda a inicialização da barra de menu da janela principal
    private void InitializeMenuBar(){
        menuBar = new MenuBar(); // inicializa a barra de menu

        // cria o menu de cadastros e seus itens de menu (submenus)
        Menu menuCadastrar = new Menu("Cadastrar");
        MenuItem itemCadCompraIngred = new MenuItem("Compra de Ingrediente");
        MenuItem itemCadProducao = new MenuItem("Produção");
        MenuItem itemCadVendaProd = new MenuItem("Venda de Produto");
        MenuItem itemCadIngred = new MenuItem("Ingrediente");
        MenuItem itemCadFornec = new MenuItem("Fornecedor");
        MenuItem itemCadCliente = new MenuItem("Cliente");
        MenuItem itemCadNovoProd = new MenuItem("Produto");
        MenuItem itemCadReceita = new MenuItem("Receita");
        MenuItem itemCadGastos = new MenuItem("Gastos");

        // cria o menu de pesquisas e seus itens de menu (submenus)
        Menu menuPesquisar = new Menu("Pesquisar");
        MenuItem itemPesqCompraIngred = new MenuItem("Compra de Ingrediente");
        MenuItem itemPesqProducao = new MenuItem("Produção");
        MenuItem itemPesqProdutoFinal = new MenuItem("Produto");
        MenuItem itemPesqIngrediente = new MenuItem("Ingrediente");
        MenuItem itemPesqVendaProdFinal = new MenuItem("Venda de Produto");
        MenuItem itemPesqFornecedor = new MenuItem("Fornecedor");
        MenuItem itemPesqCliente = new MenuItem("Cliente");
        MenuItem itemPesqReceita = new MenuItem("Receita");
        MenuItem itemPesqGastos = new MenuItem("Gastos");

        // cria o menu de dados estatísticos e seus itens de menu (submenus)
        Menu menuDadosEstatisticos = new Menu("Dados Estatísticos");
        MenuItem itemDadosEstatIngred = new MenuItem("Ingredientes");
        MenuItem itemDadosEstatCliente = new MenuItem("Clientes");
        MenuItem itemDadosEstatProduto = new MenuItem("Produtos");
        MenuItem itemDadosEstatGastos = new MenuItem("Gastos");

        // cria o menu de modificação e seus itens de menu (submenus)
        Menu menuModificar = new Menu("Modificar");
        MenuItem itemModificarReceita = new MenuItem("Receita");

        // adiciona os menus na barra de menu
        menuBar.getMenus().addAll(menuCadastrar, menuPesquisar, menuDadosEstatisticos, menuModificar);

        // adiciona no menu de cadastro os itens de menu (submenus)
        menuCadastrar.getItems().addAll( itemCadCliente, itemCadCompraIngred, itemCadFornec, itemCadGastos, itemCadIngred, itemCadProducao, itemCadNovoProd, itemCadReceita, itemCadVendaProd);

        // adiciona no menu de pesquisa os itens de menu (submenus)
        menuPesquisar.getItems().addAll(itemPesqCliente, itemPesqCompraIngred, itemPesqFornecedor, itemPesqGastos, itemPesqIngrediente, itemPesqProducao, itemPesqProdutoFinal, itemPesqReceita, itemPesqVendaProdFinal);

        // adiciona no menu de dados estatisticos os itens de menu (submenus)
        menuDadosEstatisticos.getItems().addAll(itemDadosEstatCliente, itemDadosEstatGastos, itemDadosEstatIngred, itemDadosEstatProduto);

        // adiciona no menu de modificar os itens de menu (submenus)
        menuModificar.getItems().addAll(itemModificarReceita);

        // abaixo está a ação (o que acontece quando o usuário clica com o mouse) para cada item de menu (submenu)
        // resumindo, cria-se a instância de cena adequada e chama o método que muda a cena atual

        // Ações dos itens de menu do tipo CADASTRO
        itemCadCompraIngred.setOnAction(event -> {
            CadastraCompraIngrediente cadCompraIngred = new CadastraCompraIngrediente();
            cadCompraIngred.ChangeScene();
        });

        itemCadProducao.setOnAction(event -> {
            CadastraProducao cadProducao = new CadastraProducao();
            cadProducao.ChangeScene();
        });

        itemCadVendaProd.setOnAction(event -> {
            CadastraVendaProduto cadVendaProd = new CadastraVendaProduto();
            cadVendaProd.ChangeScene();
        });

        itemCadIngred.setOnAction(event -> {
            CadastraIngrediente cadIngred = new CadastraIngrediente();
            cadIngred.ChangeScene();
        });

        itemCadFornec.setOnAction(event -> {
            CadastraFornecedor cadFornec = new CadastraFornecedor();
            cadFornec.ChangeScene();
        });

        itemCadCliente.setOnAction(event -> {
            CadastraCliente cadCliente = new CadastraCliente();
            cadCliente.ChangeScene();
        });

        itemCadNovoProd.setOnAction(event -> {
            CadastraProdutoFinal cadNovoProd = new CadastraProdutoFinal();
            cadNovoProd.ChangeScene();
        });

        itemCadReceita.setOnAction(event -> {
            CadastraReceita cadastraReceita = new CadastraReceita();
            cadastraReceita.ChangeScene();
        });

        itemCadGastos.setOnAction(event -> {
            CadastraGastos cadastraGastos = new CadastraGastos();
            cadastraGastos.ChangeScene();
        });

        // Ações dos itens de menu do tipo PESQUISA
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

        itemPesqFornecedor.setOnAction(event -> {
            PesquisaFornecedor pesqFornec = new PesquisaFornecedor();
            pesqFornec.ChangeScene();
        });

        itemPesqCliente.setOnAction(event -> {
            PesquisaCliente pesqCliente = new PesquisaCliente();
            pesqCliente.ChangeScene();
        });

        itemPesqReceita.setOnAction(event -> {
            PesquisaReceitaChooseProduto pesqReceita = new PesquisaReceitaChooseProduto();
            pesqReceita.ChangeScene();
        });

        itemPesqGastos.setOnAction(event -> {
            PesquisaGastos pesquisaGastos = new PesquisaGastos();
            pesquisaGastos.ChangeScene();
        });

        // Ações dos itens de menu do tipo DADOS ESTATISTICOS
        itemDadosEstatIngred.setOnAction(event -> {
            SceneDadosEstatIngredientes sceneDadosEstatIngredientes = new SceneDadosEstatIngredientes();
            sceneDadosEstatIngredientes.ChangeScene();
        });

        itemDadosEstatCliente.setOnAction(event -> {
            SceneDadosEstatClientes sceneDadosEstatClientes = new SceneDadosEstatClientes();
            sceneDadosEstatClientes.ChangeScene();
        });

        itemDadosEstatProduto.setOnAction(event -> {
            SceneDadosEstatProdutos sceneDadosEstatProdutos = new SceneDadosEstatProdutos();
            sceneDadosEstatProdutos.ChangeScene();
        });

        itemDadosEstatGastos.setOnAction(event -> {
            SceneDadosEstatGastos sceneDadosEstatGastos = new SceneDadosEstatGastos();
            sceneDadosEstatGastos.ChangeScene();
        });

        // Ações dos itens de menu do tipo MODIFICAR
        itemModificarReceita.setOnAction(event -> {
            ModificarReceitaChooseProduto modificarReceitaChooseProduto = new ModificarReceitaChooseProduto();
            modificarReceitaChooseProduto.ChangeScene();
        });

        // adiciona a barra de menu no layout da janela
        layout.add(menuBar, 0, 0);
    }
}
