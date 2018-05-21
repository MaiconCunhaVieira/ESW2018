package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaFornecIngredCompra;
import Scenes.Scene;
import Scenes.Window;
import TabelasBDCombinadas.FornecIngredCompra;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PesquisaCompraIngrediente extends Window implements Scene {

    private TableView<FornecIngredCompra> table;

    public void ChangeScene(){

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Table added to scene
        TableColumn<FornecIngredCompra, String> columnNomeFornec = new TableColumn<>("Fornecedor");
        columnNomeFornec = CriaTableColumn(columnNomeFornec, "nomeFornec", 100);

        TableColumn<FornecIngredCompra, String> columnNomeIngred = new TableColumn<>("Ingrediente");
        columnNomeIngred = CriaTableColumn(columnNomeIngred, "nomeIngred", 100);

        TableColumn<FornecIngredCompra, LocalDate> columnDataCompra = new TableColumn<>("Data da compra");
        columnDataCompra = CriaTableColumn(columnDataCompra, "dataCompra", 100);

        TableColumn<FornecIngredCompra, LocalTime> columnHoraCompra = new TableColumn<>("Hora da compra");
        columnHoraCompra = CriaTableColumn(columnHoraCompra, "horaCompra", 100);

        TableColumn<FornecIngredCompra, Integer> columnQtdeCompradaIngred = new TableColumn<>("Quantidade comprada");
        columnQtdeCompradaIngred = CriaTableColumn(columnQtdeCompradaIngred, "qtdeCompradaIngred", 100);

        TableColumn<FornecIngredCompra, Float> columnPrecoCompra = new TableColumn<>("Valor pago");
        columnPrecoCompra = CriaTableColumn(columnPrecoCompra, "precoCompra", 100);

        table = new TableView<>();
        table.setItems(GerenciaFornecIngredCompra.SelectCompraIngred());
        table.getColumns().addAll(columnNomeFornec, columnNomeIngred, columnDataCompra, columnHoraCompra, columnQtdeCompradaIngred, columnPrecoCompra);
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
