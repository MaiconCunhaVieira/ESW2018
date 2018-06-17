package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaClienteProdutoVenda;
import TabelasBDCombinadas.VendaProdClienteProduto;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaVendaProduto extends WindowPesquisa {

    private TableView<VendaProdClienteProduto> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do cliente que comprou
        TableColumn<VendaProdClienteProduto, String> columnNomeCliente = new TableColumn<>("Nome do cliente");
        columnNomeCliente = CriaTableColumn(columnNomeCliente, "nomeCliente", 150);

        // cria e inicializa coluna com o nome do produto vendido
        TableColumn<VendaProdClienteProduto, String> columnNomeProduto = new TableColumn<>("Nome do produto");
        columnNomeProduto = CriaTableColumn(columnNomeProduto, "nomeProduto", 150);

        // cria e inicializa coluna com a data da venda
        TableColumn<VendaProdClienteProduto, String> columnDataVenda = new TableColumn<>("Data da venda");
        columnDataVenda = CriaTableColumn(columnDataVenda, "dataVenda", 150);

        // cria e inicializa coluna com a hora da venda
        TableColumn<VendaProdClienteProduto, String> columnHoraVenda = new TableColumn<>("Hora da venda");
        columnHoraVenda = CriaTableColumn(columnHoraVenda, "horaVenda", 150);

        // cria e inicializa coluna com a quantidade vendida do produto
        TableColumn<VendaProdClienteProduto, String> columnQtdeVendida = new TableColumn<>("Quantidade vendida");
        columnQtdeVendida = CriaTableColumn(columnQtdeVendida, "qtdeVendida", 150);

        // cria e inicializa coluna com o valor da venda
        TableColumn<VendaProdClienteProduto, String> columnPrecoTotal = new TableColumn<>("Preço total");
        columnPrecoTotal = CriaTableColumn(columnPrecoTotal, "precoTotal", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de vendas na tabela (tuplas lidas do BD)
        table.setItems(GerenciaClienteProdutoVenda.SelectClienteProdutoVenda());

        // adiciona na tabela as coluna criadas
        table.getColumns().addAll(columnNomeCliente, columnNomeProduto, columnDataVenda, columnHoraVenda, columnQtdeVendida, columnPrecoTotal);

        // adiciona a tabela no layout
        layout.add(table, 0, 0);

        // inicializa botão que volta para a tela principal
        button_voltar = CriaButton("Voltar", 0, 1);
        button_voltar.setOnAction(e -> {
            // muda cena atual para a cena da tela principal
            Main.window.setScene(Main.scene);
        });

        // inicializa cena
        scene = new javafx.scene.Scene(layout, 500, 500);

        // muda cena atual para essa cena criada
        Main.window.setScene(scene);
    }
}
