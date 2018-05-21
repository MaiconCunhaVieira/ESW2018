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

        // Table added to scene
        TableColumn<ProdutoFinal, Integer> columnCodProd = new TableColumn<>("Código do produto");
        columnCodProd = CriaTableColumn(columnCodProd, "cod", 150);

        TableColumn<ProdutoFinal, String> columnNomeProd = new TableColumn<>("Nome do produto");
        columnNomeProd = CriaTableColumn(columnNomeProd, "nome", 150);

        TableColumn<ProdutoFinal, Integer> columnQtdeProntaProd = new TableColumn<>("Quantidade no estoque");
        columnQtdeProntaProd = CriaTableColumn(columnQtdeProntaProd, "qtdePronta", 200);

        TableColumn<ProdutoFinal, Float> columnPrecoProd = new TableColumn<>("Preço (em reais)");
        columnPrecoProd = CriaTableColumn(columnPrecoProd, "preco", 100);

        TableColumn<ProdutoFinal, Integer> columnPesoProd = new TableColumn<>("Peso (em mg)");
        columnPesoProd = CriaTableColumn(columnPesoProd, "peso", 100);

        table = new TableView<>();
        table.setItems(GerenciaProdutoFinal.SelectProdutosFinaisForTable());
        table.getColumns().addAll(columnCodProd, columnNomeProd, columnQtdeProntaProd, columnPrecoProd, columnPesoProd);
        layout.add(table, 0, 0);

        // Button added to scene
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(e -> {
            Main.window.setScene(Main.scene);
        });

        scene = new javafx.scene.Scene(layout, 500, 500);
        Main.window.setScene(scene);
    }
}
