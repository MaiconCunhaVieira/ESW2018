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

        // Table added to scene
        TableColumn<Ingrediente, Integer> columnCodIngred = new TableColumn<>("Código do ingrediente");
        columnCodIngred = CriaTableColumn(columnCodIngred, "cod", 150);

        TableColumn<Ingrediente, String> columnNomeIngred = new TableColumn<>("Nome do ingrediente");
        columnNomeIngred = CriaTableColumn(columnNomeIngred, "nome", 150);

        TableColumn<Ingrediente, Integer> columnQtdeAtualIngred = new TableColumn<>("Quantidade em estoque (mg/ml/unidades)");
        columnQtdeAtualIngred = CriaTableColumn(columnQtdeAtualIngred, "qtdeAtual", 250);

        table = new TableView<>();
        table.setItems(GerenciaIngredientes.SelectIngredientesForTable());
        table.getColumns().addAll(columnCodIngred, columnNomeIngred, columnQtdeAtualIngred);
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
