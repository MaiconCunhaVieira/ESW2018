package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaFornecIngredCompra;
import TabelasBDCombinadas.FornecIngredCompra;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PesquisaCompraIngrediente extends WindowPesquisa {

    private TableView<FornecIngredCompra> table;

    public void ChangeScene(){

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do fornecedor do ingrediente
        TableColumn<FornecIngredCompra, String> columnNomeFornec = new TableColumn<>("Fornecedor");
        columnNomeFornec = CriaTableColumn(columnNomeFornec, "nomeFornec", 100);

        // cria e inicializa coluna com o nome do ingrediente comprado
        TableColumn<FornecIngredCompra, String> columnNomeIngred = new TableColumn<>("Ingrediente");
        columnNomeIngred = CriaTableColumn(columnNomeIngred, "nomeIngred", 100);

        // cria e inicializa coluna com a data da compra
        TableColumn<FornecIngredCompra, LocalDate> columnDataCompra = new TableColumn<>("Data da compra");
        columnDataCompra = CriaTableColumn(columnDataCompra, "dataCompra", 100);

        // cria e inicializa coluna com a hora da compra
        TableColumn<FornecIngredCompra, LocalTime> columnHoraCompra = new TableColumn<>("Hora da compra");
        columnHoraCompra = CriaTableColumn(columnHoraCompra, "horaCompra", 100);

        // cria e inicializa coluna com a quantidade comprada do ingrediente
        TableColumn<FornecIngredCompra, Integer> columnQtdeCompradaIngred = new TableColumn<>("Quantidade comprada");
        columnQtdeCompradaIngred = CriaTableColumn(columnQtdeCompradaIngred, "qtdeCompradaIngred", 100);

        // cria e inicializa coluna com o preço da compra
        TableColumn<FornecIngredCompra, Float> columnPrecoCompra = new TableColumn<>("Valor pago");
        columnPrecoCompra = CriaTableColumn(columnPrecoCompra, "precoCompra", 100);

        // inicializa tabela
        table = new TableView<>();

        // insere as tuplas de compras na tabela (tuplas lidas do BD)
        table.setItems(GerenciaFornecIngredCompra.SelectCompraIngred());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnNomeFornec, columnNomeIngred, columnDataCompra, columnHoraCompra, columnQtdeCompradaIngred, columnPrecoCompra);

        // adiciona tabela no layout da cena
        layout.add(table, 0, 0);

        // inicializa botão que volta para tela principal
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
