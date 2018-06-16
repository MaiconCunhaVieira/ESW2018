package Scenes.Pesquisa;

import Main.Main;
import ManageDBTables.GerenciaCliente;
import ManageDBTables.GerenciaIngredientes;
import Scenes.Scene;
import Scenes.Window;
import TabelasBD.Cliente;
import TabelasBD.Ingrediente;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class PesquisaCliente extends Window implements Scene {

    private TableView<Cliente> table;

    public void ChangeScene(){
        // Layout
        layout = new GridPane();
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.CENTER);

        // cria e inicializa coluna com o cnpj do cliente
        TableColumn<Cliente, String> columnCNPJCliente = new TableColumn<>("CNPJ do cliente");
        columnCNPJCliente = CriaTableColumn(columnCNPJCliente, "CNPJ", 150);

        // cria e inicializa coluna com o nome do cliente
        TableColumn<Cliente, String> columnNomeCliente = new TableColumn<>("Nome do cliente");
        columnNomeCliente = CriaTableColumn(columnNomeCliente, "nome", 150);

        // cria e inicializa coluna com o endereço do cliente
        TableColumn<Cliente, String> columnEnderecoCliente = new TableColumn<>("Endereço");
        columnEnderecoCliente = CriaTableColumn(columnEnderecoCliente, "endereco", 150);

        // cria e inicializa coluna com o telefone do cliente
        TableColumn<Cliente, String> columnTelefoneCliente = new TableColumn<>("Telefone");
        columnTelefoneCliente = CriaTableColumn(columnTelefoneCliente, "telefone", 150);

        // inicializa tabela
        table = new TableView<>();

        // insere tuplas de clientes na tabela (tuplas lidas do BD)
        table.setItems(GerenciaCliente.SelectClientesForTable());

        // adiciona na tabela as colunas criadas
        table.getColumns().addAll(columnCNPJCliente, columnNomeCliente, columnEnderecoCliente, columnTelefoneCliente);

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
