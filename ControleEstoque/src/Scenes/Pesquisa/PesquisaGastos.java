package Scenes.Pesquisa;

import Main.Main;
import ManageDBTables.GerenciaGastos;
import TabelasBD.Gastos;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class PesquisaGastos extends WindowPesquisa {

    private TableView<Gastos> table;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com a data do gasto
        TableColumn<Gastos, LocalDate> columnData = new TableColumn<>("Data");
        columnData = CriaTableColumn(columnData, "data", 150);

        // cria e inicializa coluna com o gastos de luz
        TableColumn<Gastos, Integer> columnLuz = new TableColumn<>("Gastos com Luz");
        columnLuz = CriaTableColumn(columnLuz, "luz", 150);

        // cria e inicializa coluna com o gastos de agua
        TableColumn<Gastos, Integer> columnAgua = new TableColumn<>("Gastos com Água");
        columnAgua = CriaTableColumn(columnAgua, "agua", 150);

        // cria e inicializa coluna com o gastos de funcionarios
        TableColumn<Gastos, Integer> columnFunc = new TableColumn<>("Gastos com Funcionários");
        columnFunc = CriaTableColumn(columnFunc, "funcionarios", 150);

        // cria e inicializa coluna com o gastos de outros
        TableColumn<Gastos, Integer> columnOutros = new TableColumn<>("Outros gastos");
        columnOutros = CriaTableColumn(columnOutros, "outros", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de gastos na tabela (tuplas lidas do BD)
        table.setItems(GerenciaGastos.SelectGastosForTable());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnData, columnLuz, columnAgua, columnFunc, columnOutros);

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
