package Scenes.Pesquisa;

import Main.Main;
import ManageDBTablesCombinadas.GerenciaProdutoFinalProducao;
import Scenes.Scene;
import Scenes.Window;
import TabelasBDCombinadas.ProdutoFinalProducao;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PesquisaProducao extends Window implements Scene {

    private TableView<ProdutoFinalProducao> table;

    public void ChangeScene(){

        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o nome do produto produzido
        TableColumn<ProdutoFinalProducao, String> columnNomeProdutoFinal = new TableColumn<>("Nome do produto");
        columnNomeProdutoFinal = CriaTableColumn(columnNomeProdutoFinal, "nomeProdutoFinal", 150);

        // cria e inicializa coluna com a data da produção
        TableColumn<ProdutoFinalProducao, LocalDate> columnDataProducao = new TableColumn<>("Data da produção");
        columnDataProducao = CriaTableColumn(columnDataProducao, "dataProducao", 150);

        // cria e inicializa coluna com a hora da produção
        TableColumn<ProdutoFinalProducao, LocalTime> columnHoraProducao = new TableColumn<>("Hora da produção");
        columnHoraProducao = CriaTableColumn(columnHoraProducao, "horaProducao", 150);

        // cria e inicializa coluna com a quantidade produzida
        TableColumn<ProdutoFinalProducao, Integer> columnQtdeProducao = new TableColumn<>("Quantidade produzida");
        columnQtdeProducao = CriaTableColumn(columnQtdeProducao, "qtdeProducao", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de produção na tabela (tuplas lidas do BD)
        table.setItems(GerenciaProdutoFinalProducao.SelectProducao());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnNomeProdutoFinal, columnDataProducao, columnHoraProducao, columnQtdeProducao);

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
