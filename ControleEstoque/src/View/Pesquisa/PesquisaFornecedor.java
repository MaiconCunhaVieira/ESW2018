package View.Pesquisa;

import View.Main.Main;
import Controller.GerenciaTabelasBD.GerenciaFornecedor;
import Model.TabelasBD.Fornecedor;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaFornecedor extends WindowPesquisa {

    private TableView<Fornecedor> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o cnpj do fornecedor
        TableColumn<Fornecedor, String> columnCNPJFornec = new TableColumn<>("CNPJ do fornecedor");
        columnCNPJFornec = CriaTableColumn(columnCNPJFornec, "CNPJ", 150);

        // cria e inicializa coluna com o nome do fornecedor
        TableColumn<Fornecedor, String> columnNomeFornec = new TableColumn<>("Nome do fornecedor");
        columnNomeFornec = CriaTableColumn(columnNomeFornec, "nome", 150);

        // cria e inicializa coluna com o endereço do fornecedor
        TableColumn<Fornecedor, String> columnEnderecoFornec = new TableColumn<>("Endereço");
        columnEnderecoFornec = CriaTableColumn(columnEnderecoFornec, "endereco", 150);

        // cria e inicializa coluna com o telefone do fornecedor
        TableColumn<Fornecedor, String> columnTelefoneFornec = new TableColumn<>("Telefone");
        columnTelefoneFornec = CriaTableColumn(columnTelefoneFornec, "telefone", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de fornecedores na tabela (tuplas lidas do BD)
        table.setItems(GerenciaFornecedor.SelectFornecedoresForTable());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnCNPJFornec, columnNomeFornec, columnEnderecoFornec, columnTelefoneFornec);

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
