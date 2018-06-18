package Scenes.DadosEstatisticos;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaDadosEstatProduto;
import Scenes.Pesquisa.WindowPesquisa;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class SceneDadosEstatProdutos extends WindowPesquisa {
    private TableView table;

    public void ChangeScene() {
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do produto
        TableColumn columnNomeProduto = new TableColumn("Nome do produto");
        columnNomeProduto = CriaTableColumn(columnNomeProduto, "nomeProduto", 150);

        // cria e inicializa coluna com a quantidade produzida do produto
        TableColumn columnQtdeProduzida = new TableColumn("Quantidade produzida");
        columnQtdeProduzida = CriaTableColumn(columnQtdeProduzida, "qtdeProduzida", 150);

        // cria e inicializa coluna com a quantidade vendida do produto
        TableColumn columnQtdeVendida = new TableColumn("Quantidade vendida");
        columnQtdeVendida = CriaTableColumn(columnQtdeVendida, "qtdeVendida", 150);

        // inicializa tabela
        table = new TableView();

        // insere tuplas na tabela
        table.setItems(GerenciaDadosEstatProduto.SelectDadosEstatProdutos());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnNomeProduto, columnQtdeProduzida, columnQtdeVendida);

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
