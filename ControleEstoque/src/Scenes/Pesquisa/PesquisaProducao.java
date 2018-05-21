package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaProdutoFinalProducao;
import Scenes.Scene;
import Scenes.Window;
import TabelasBDCombinadas.ProdutoFinalProducao;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PesquisaProducao extends Window implements Scene {

    private TableView<ProdutoFinalProducao> table;

    public void ChangeScene(){

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Table added to scene
        TableColumn<ProdutoFinalProducao, String> columnNomeProdutoFinal = new TableColumn<>("Nome do produto");
        columnNomeProdutoFinal = CriaTableColumn(columnNomeProdutoFinal, "nomeProdutoFinal", 150);

        TableColumn<ProdutoFinalProducao, LocalDate> columnDataProducao = new TableColumn<>("Data da produção");
        columnDataProducao = CriaTableColumn(columnDataProducao, "dataProducao", 150);

        TableColumn<ProdutoFinalProducao, LocalTime> columnHoraProducao = new TableColumn<>("Hora da produção");
        columnHoraProducao = CriaTableColumn(columnHoraProducao, "horaProducao", 150);

        TableColumn<ProdutoFinalProducao, Integer> columnQtdeProducao = new TableColumn<>("Quantidade produzida");
        columnQtdeProducao = CriaTableColumn(columnQtdeProducao, "qtdeProducao", 150);

        table = new TableView<>();
        table.setItems(GerenciaProdutoFinalProducao.SelectProducao());
        table.getColumns().addAll(columnNomeProdutoFinal, columnDataProducao, columnHoraProducao, columnQtdeProducao);
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
