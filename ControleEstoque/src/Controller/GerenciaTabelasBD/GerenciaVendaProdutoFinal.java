package Controller.GerenciaTabelasBD;

import Controller.DB.Database;
import View.JanelaAlerta;
import Model.TabelasBD.ProdutoFinal;
import Model.TabelasBD.VendaProdutoFinal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaVendaProdutoFinal {

    private static String selectVendaProdFinal = "SELECT * FROM VendaProd";
    private static String insertVendaProdFinal = "INSERT INTO VendaProd (CNPJCliente, codProd, data, hora, qtdeProd) VALUES ";

    // Faz a pesquisa de venda de produtos, retornando uma lista de vendas
    public static List<VendaProdutoFinal> SelectVendasProdutoFinal(){
        try {
            ResultSet rs = Database.ExecuteSelect(selectVendaProdFinal);
            List<VendaProdutoFinal> vendaProdFinal = new ArrayList<>();
            while(rs.next()){
                vendaProdFinal.add(new VendaProdutoFinal(rs.getString(1), rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getTime(4).toLocalTime(), rs.getInt(5)));
            }
            return vendaProdFinal;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Insere uma nova venda de produto no BD
    public static void InsertVendaProdutoFinal(String CNPJCliente, int codProd, LocalDate data, LocalTime hora, int qtdeVendida){
        try{
            List<ProdutoFinal> prodsFinais = GerenciaProdutoFinal.SelectProdutosFinais(); // lista de produtos contém todos os produtos do BD
            boolean qtdeEmEstoqueInsuficiente = false; // flag que dirá se a venda falhou
            String ingredInsuficienteMessage = null; // mensagem de erro caso venda falhe

            // para cada produto
            for(ProdutoFinal pf : prodsFinais){
                // se produto da lista é o mesmo produto a ser vendido
                if(pf.getCod() == codProd){
                    // se quantidade atual desse produto é menor do que a quantidade a ser vendida, venda deve FALHAR
                    if(pf.getQtdePronta() < qtdeVendida){
                        // cria mensagem de erro e muda flag de erro para TRUE
                        ingredInsuficienteMessage = "Impossível vender " + qtdeVendida + " unidades do produto " + pf.getNome() + ", estoque possui apenas " + pf.getQtdePronta() + " unidades.";
                        qtdeEmEstoqueInsuficiente = true;
                    }
                }
            }

            // se houver mensagem de erro, mostra mensagem em uma nova janela
            if(ingredInsuficienteMessage != null)
                JanelaAlerta.Display("Produto insuficiente no estoque", ingredInsuficienteMessage);

            // se tem quantidade suficiente do produto em estoque para vender
            if(!qtdeEmEstoqueInsuficiente){
                // insere venda no BD
                Database.ExecuteInsertUpdateORDelete(insertVendaProdFinal + "('" + CNPJCliente + "', " + codProd + ", '" + data + "', '" + hora + "', " + qtdeVendida + ");");

                // atualiza quantidade atual do produto
                GerenciaProdutoFinal.UpdateProdutoFinalDiminuirQtdePronta(codProd, qtdeVendida);

                // mostra mensagem de sucesso
                JanelaAlerta.Display("", "Cadastro de Venda de Produto bem sucedido");
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
