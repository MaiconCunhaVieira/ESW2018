package View.DadosEstatisticos;

import View.Main.Main;
import Controller.GerenciaTabelasBDCombinadas.GerenciaDadosEstatCliente;
import View.Pesquisa.WindowPesquisa;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class SceneDadosEstatClientes extends WindowPesquisa {

    private TableView table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do cliente
        TableColumn columnNomeCliente = new TableColumn("Nome do Cliente");
        columnNomeCliente = CriaTableColumn(columnNomeCliente, "nomeCliente", 150);

        // cria e inicializa coluna com número de vendas feitas para o cliente
        TableColumn columnVendasCliente = new TableColumn("Número de Vendas para o Cliente");
        columnVendasCliente = CriaTableColumn(columnVendasCliente, "numVendasCliente", 150);

        // cria e inicializa coluna com o produto que o cliente mais comprou
        TableColumn columnProdutoMaisVendido = new TableColumn("Produto mais vendido");
        columnProdutoMaisVendido = CriaTableColumn(columnProdutoMaisVendido, "produtoMaisVendido", 150);

        // cria e inicializa coluna com o número de vendas do produto mais vendido
        TableColumn columnNumVendasProdMaisVend = new TableColumn("Número de Vendas do Produto mais Vendido");
        columnNumVendasProdMaisVend = CriaTableColumn(columnNumVendasProdMaisVend, "numVendProdMaisVend", 150);

        // inicializa tabela
        table = new TableView();

        // insere tuplas na tabela
        table.setItems(GerenciaDadosEstatCliente.SelectDadosEstatCliente());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnNomeCliente, columnVendasCliente, columnProdutoMaisVendido, columnNumVendasProdMaisVend);

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
