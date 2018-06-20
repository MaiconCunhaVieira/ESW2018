package View.Pesquisa;

import View.Main.Main;
import Controller.GerenciaTabelasBDCombinadas.GerenciaProdutoFinalReceita;
import Model.TabelasBDCombinadas.ProdutoFinalReceita;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaReceitaShowTable extends WindowPesquisa {

    private int codProduto;
    private TableView<ProdutoFinalReceita> table;

    public PesquisaReceitaShowTable(int codProduto) {
        this.codProduto = codProduto;
    }

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do produto
        TableColumn<ProdutoFinalReceita, String> columnNomeProduto = new TableColumn<>("Nome do produto");
        columnNomeProduto = CriaTableColumn(columnNomeProduto, "nomeProduto", 150);

        // cria e inicializa coluna com o nome do ingrediente
        TableColumn columnNomeIngrediente = new TableColumn("Nome do ingrediente");
        columnNomeIngrediente = CriaTableColumn(columnNomeIngrediente, "nomeIngrediente", 150);

        // cria e inicializa coluna com a quantidade do ingrediente
        TableColumn columnQtdeIngrediente = new TableColumn("Quantidade necessária");
        columnQtdeIngrediente = CriaTableColumn(columnQtdeIngrediente, "qtdeIngrediente", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de receitas na tabela (tuplas lidas do BD)
        table.setItems(GerenciaProdutoFinalReceita.SelectReceita(codProduto));

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnNomeProduto, columnNomeIngrediente, columnQtdeIngrediente);

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
