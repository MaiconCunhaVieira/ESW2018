package View.DadosEstatisticos;

import View.Main.Main;
import Controller.GerenciaTabelasBDCombinadas.GerenciaDadosEstatGastos;
import View.Pesquisa.WindowPesquisa;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class SceneDadosEstatGastos extends WindowPesquisa {

    private TableView table;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa colunas;
        TableColumn columnData = new TableColumn("Data");
        columnData = CriaTableColumn(columnData, "data", 100);

        TableColumn columnGastosGerais = new TableColumn("Gastos gerais");
        columnGastosGerais = CriaTableColumn(columnGastosGerais, "totalGastosGerais", 100);

        TableColumn columnGastosCompras = new TableColumn("Gastos com Ingredientes");
        columnGastosCompras = CriaTableColumn(columnGastosCompras, "totalGastosCompras", 150);

        TableColumn columnGanhoVendas = new TableColumn("Lucro das Vendas");
        columnGanhoVendas = CriaTableColumn(columnGanhoVendas, "totalGanhoVendas", 120);

        TableColumn columnLucroTotal = new TableColumn("Lucro total");
        columnLucroTotal = CriaTableColumn(columnLucroTotal, "totalLucro", 100);

        // inicializa tabela
        table = new TableView();
        table.setMinWidth(500);

        // insere tuplas
        table.setItems(GerenciaDadosEstatGastos.SelectDadosEstatGastos());

        // adiciona colunas criadas
        table.getColumns().addAll(columnData, columnGastosGerais, columnGastosCompras, columnGanhoVendas, columnLucroTotal);

        layout.add(table, 0, 0);

        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(event -> {
            Main.window.setScene(Main.scene);
        });

        // inicializa cena
        scene = new javafx.scene.Scene(layout, 500, 500);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
