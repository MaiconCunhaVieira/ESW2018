package Scenes.Pesquisa;

import Main.Main;
import ManageDBTables.GerenciaProdutoFinal;
import Scenes.Scene;
import Scenes.Window;
import TabelasBD.ProdutoFinal;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaProdutoFinal extends Window implements Scene {

    private TableView<ProdutoFinal> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o código do produto
        TableColumn<ProdutoFinal, Integer> columnCodProd = new TableColumn<>("Código do produto");
        columnCodProd = CriaTableColumn(columnCodProd, "cod", 150);

        // cria e inicializa coluna com o nome do produto
        TableColumn<ProdutoFinal, String> columnNomeProd = new TableColumn<>("Nome do produto");
        columnNomeProd = CriaTableColumn(columnNomeProd, "nome", 150);

        // cria e inicializa coluna com a quantidade atual do produto
        TableColumn<ProdutoFinal, Integer> columnQtdeProntaProd = new TableColumn<>("Quantidade no estoque");
        columnQtdeProntaProd = CriaTableColumn(columnQtdeProntaProd, "qtdePronta", 200);

        // cria e inicializa coluna com o preço do produto
        TableColumn<ProdutoFinal, Float> columnPrecoProd = new TableColumn<>("Preço (em reais)");
        columnPrecoProd = CriaTableColumn(columnPrecoProd, "preco", 100);

        // cria e inicializa coluna com o peso do produto
        TableColumn<ProdutoFinal, Integer> columnPesoProd = new TableColumn<>("Peso (em mg)");
        columnPesoProd = CriaTableColumn(columnPesoProd, "peso", 100);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de produtos na tabela (tuplas lidas do BD)
        table.setItems(GerenciaProdutoFinal.SelectProdutosFinaisForTable());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnCodProd, columnNomeProd, columnQtdeProntaProd, columnPrecoProd, columnPesoProd);

        // adiciona tabela no layout da cena
        layout.add(table, 0, 0);

        // inicializa botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(e -> {
            // muda cena atual para cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa cena
        scene = new javafx.scene.Scene(layout, 500, 500);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
