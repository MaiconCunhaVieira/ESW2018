package Scenes.DadosEstatisticos;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaIngredienteReceitaProducao;
import Scenes.Pesquisa.WindowPesquisa;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class DadosEstatIngredientes extends WindowPesquisa {

    private TableView table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o código do ingrediente
        TableColumn columnCodIngred = new TableColumn("Código do Ingrediente");
        columnCodIngred = CriaTableColumn(columnCodIngred, "codIngred", 150);

        // cria e inicializa coluna com o nome do ingrediente
        TableColumn columnNomeIngrediente = new TableColumn("Nome do Ingrediente");
        columnNomeIngrediente = CriaTableColumn(columnNomeIngrediente, "nome", 150);

        // cria e inicializa coluna com a quantidade total consumida do ingrediente
        TableColumn columnQtdeConsumida = new TableColumn("Quantidade consumida");
        columnQtdeConsumida = CriaTableColumn(columnQtdeConsumida, "qtdeConsumida", 150);

        // inicializa tabela
        table = new TableView();

        // insere tuplas na tabela
        table.setItems(GerenciaIngredienteReceitaProducao.SelectIngredienteReceitaProducao());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnCodIngred, columnNomeIngrediente, columnQtdeConsumida);

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
