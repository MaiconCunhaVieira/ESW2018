package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaClienteProdutoVenda;
import Scenes.Scene;
import Scenes.Window;
import TabelasBDCombinadas.ClienteProdutoVenda;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaVendaProduto extends Window implements Scene {

    private TableView<ClienteProdutoVenda> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // Table added to scene
        TableColumn<ClienteProdutoVenda, String> columnNomeCliente = new TableColumn<>("Nome do cliente");
        columnNomeCliente = CriaTableColumn(columnNomeCliente, "nomeCliente", 150);

        TableColumn<ClienteProdutoVenda, String> columnNomeProduto = new TableColumn<>("Nome do produto");
        columnNomeProduto = CriaTableColumn(columnNomeProduto, "nomeProduto", 150);

        TableColumn<ClienteProdutoVenda, String> columnDataVenda = new TableColumn<>("Data da venda");
        columnDataVenda = CriaTableColumn(columnDataVenda, "dataVenda", 150);

        TableColumn<ClienteProdutoVenda, String> columnHoraVenda = new TableColumn<>("Hora da venda");
        columnHoraVenda = CriaTableColumn(columnHoraVenda, "horaVenda", 150);

        TableColumn<ClienteProdutoVenda, String> columnQtdeVendida = new TableColumn<>("Quantidade vendida");
        columnQtdeVendida = CriaTableColumn(columnQtdeVendida, "qtdeVendida", 150);

        TableColumn<ClienteProdutoVenda, String> columnPrecoTotal = new TableColumn<>("Preço total");
        columnPrecoTotal = CriaTableColumn(columnPrecoTotal, "precoTotal", 150);

        table = new TableView<>();
        table.setItems(GerenciaClienteProdutoVenda.SelectClienteProdutoVenda());
        table.getColumns().addAll(columnNomeCliente, columnNomeProduto, columnDataVenda, columnHoraVenda, columnQtdeVendida, columnPrecoTotal);
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
