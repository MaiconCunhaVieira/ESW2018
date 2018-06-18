package ManageDBTablesCombinadas;

import DB.Database;
import ManageDBTables.GerenciaCliente;
import ManageDBTables.GerenciaProdutoFinal;
import TabelasBDCombinadas.ClienteVendaProdutoVendido;
import TabelasBDCombinadas.DadosEstatCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaDadosEstatCliente {

    private static String pesquisaDadosEstatCliente =
            "SELECT Cliente.nome, ProdutoFinal.nome, VendaProd.qtdeProd " +
                    "FROM Cliente, VendaProd, ProdutoFinal " +
                    "WHERE Cliente.CNPJ = VendaProd.CNPJCliente AND ProdutoFinal.cod = VendaProd.codProd;";

    public static ObservableList<DadosEstatCliente> SelectDadosEstatCliente(){
        try {
            // INÍCIO DA LÓGICA PARA CALCULAR TOTAL DE VENDAS DE CADA CLIENTE

            // lista de tuplas que irá para a tabela da cena
            ObservableList<DadosEstatCliente> dadosEstatClientes = FXCollections.observableArrayList();

            // tuplas lidas do BD a partir da String de pesquisa
            List<ClienteVendaProdutoVendido> clienteVendaProdutoVendidos = new ArrayList<>();

            // todos os clientes
            List<String> clientesNome = GerenciaCliente.SelectClientesNome();

            // pesquisa os dados
            ResultSet rs = Database.ExecuteSelect(pesquisaDadosEstatCliente);
            while(rs.next()){
                clienteVendaProdutoVendidos.add(new ClienteVendaProdutoVendido(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

            // para cada cliente, salva nome do cliente na lista de clientes
            for(String clienteNome : clientesNome){
                dadosEstatClientes.add(new DadosEstatCliente(clienteNome, 0, "oi", 0));
            }

            int qtdeTotalVendas = 0;
            // para cada cliente
            for(DadosEstatCliente dadosEstatCliente : dadosEstatClientes){
                // para cada venda feita
                for(ClienteVendaProdutoVendido clienteVendaProdVend : clienteVendaProdutoVendidos){
                    // se venda foi feita por cliente
                    if(dadosEstatCliente.getNomeCliente().equals(clienteVendaProdVend.getNomeCliente())){
                        qtdeTotalVendas += clienteVendaProdVend.getQtdeVendidaProd();
                    }
                }
                // terminou de calcular total de vendas do cliente, então salva total
                // e zera contador
                dadosEstatCliente.setNumVendasCliente(qtdeTotalVendas);
                qtdeTotalVendas = 0;
            }
            // FIM DA LÓGICA PARA CALCULAR TOTAL DE VENDAS DE CADA CLIENTE


            // INÍCIO DA LÓGICA PARA CALCULAR PRODUTO MAIS VENDIDO PARA CADA CLIENTE

            // nome de todos os produtos
            List<String> produtosFinaisNome = GerenciaProdutoFinal.SelectProdutosFinaisNome();

            List<ClienteVendaProdutoVendido> totalVendidoCadaProdutoCadaCliente = new ArrayList<>();
            int qtdeTotalVendProdCadaCliente = 0;

            // calcula o total de vendas de cada produto para cada cliente
            // para cada cliente
            for(String clienteNome : clientesNome) {
                // para cada produto
                for(String produtoNome : produtosFinaisNome) {
                    // para cada venda
                    for(ClienteVendaProdutoVendido clienteVendaProdVend : clienteVendaProdutoVendidos) {
                        // se venda feita para cliente e se venda contém o produto
                        if(clienteNome.equals(clienteVendaProdVend.getNomeCliente()) & produtoNome.equals(clienteVendaProdVend.getNomeProduto())) {
                            // soma quantidade do produto na quantidade total
                            qtdeTotalVendProdCadaCliente += clienteVendaProdVend.getQtdeVendidaProd();
                        }
                    }
                    // encontrou total de vendas de um produto para cliente atual, então salva total de vendas do produto e reseta variável
                    totalVendidoCadaProdutoCadaCliente.add(new ClienteVendaProdutoVendido(clienteNome, produtoNome, qtdeTotalVendProdCadaCliente));
                    qtdeTotalVendProdCadaCliente = 0;
                }
            }

            int qtdeProdutoMaisVendeu = 0;
            String nomeProdutoMaisVendeu = "";

            // calcula qual produto mais vendeu para cada cliente
            // para cada cliente
            for(String clienteNome : clientesNome){
                // para cada total de venda de produto
                for(ClienteVendaProdutoVendido cliVendaProdVend : totalVendidoCadaProdutoCadaCliente){
                    // se venda feita com o cliente atual
                    if(clienteNome.equals(cliVendaProdVend.getNomeCliente())){
                        // e se total de venda do produto é maior do que o total de venda do produto atual
                        if(cliVendaProdVend.getQtdeVendidaProd() > qtdeProdutoMaisVendeu){
                            // salva o novo produto que mais vendeu
                            qtdeProdutoMaisVendeu = cliVendaProdVend.getQtdeVendidaProd();
                            nomeProdutoMaisVendeu = cliVendaProdVend.getNomeProduto();
                        }
                    }
                }
                // encontrado o produto que mais vendeu para o cliente atual
                // para cada cliente, salva o produto que mais vendeu e a quantidade vendida desse produto
                for(DadosEstatCliente dadEstCli : dadosEstatClientes){
                    if(dadEstCli.getNomeCliente().equals(clienteNome)){
                        dadEstCli.setProdutoMaisVendido(nomeProdutoMaisVendeu);
                        dadEstCli.setNumVendProdMaisVend(qtdeProdutoMaisVendeu);
                    }
                }

                // reseta variáveis
                qtdeProdutoMaisVendeu = 0;
                nomeProdutoMaisVendeu = "";
            }

            return dadosEstatClientes;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
