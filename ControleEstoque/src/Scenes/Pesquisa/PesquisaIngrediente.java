package Scenes.Pesquisa;

import Main.Main;
import ManageDBTables.GerenciaIngredientes;
import Scenes.Scene;
import Scenes.Window;
import TabelasBD.Ingrediente;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaIngrediente extends Window implements Scene {

    private TableView<Ingrediente> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o código do ingrediente
        TableColumn<Ingrediente, Integer> columnCodIngred = new TableColumn<>("Código do ingrediente");
        columnCodIngred = CriaTableColumn(columnCodIngred, "cod", 150);

        // cria e inicializa coluna com o nome do ingrediente
        TableColumn<Ingrediente, String> columnNomeIngred = new TableColumn<>("Nome do ingrediente");
        columnNomeIngred = CriaTableColumn(columnNomeIngred, "nome", 150);

        // cria e inicializa coluna com a quantidade atual do ingrediente
        TableColumn<Ingrediente, Integer> columnQtdeAtualIngred = new TableColumn<>("Quantidade em estoque (mg/ml/unidades)");
        columnQtdeAtualIngred = CriaTableColumn(columnQtdeAtualIngred, "qtdeAtual", 250);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de ingredientes na tabela (tuplas lidas do BD)
        table.setItems(GerenciaIngredientes.SelectIngredientesForTable());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnCodIngred, columnNomeIngred, columnQtdeAtualIngred);

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
