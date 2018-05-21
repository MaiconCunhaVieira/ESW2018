package ManageDBTables;

import DB.Database;
import Scenes.JanelaAlerta;
import TabelasBD.ProdutoFinal;
import TabelasBD.VendaProdutoFinal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciaVendaProdutoFinal {

    private static String selectVendaProdFinal = "SELECT * FROM VendaProd";
    private static String insertVendaProdFinal = "INSERT INTO VendaProd (CNPJCliente, codProd, data, hora, qtdeProd) VALUES ";

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

    public static void InsertVendaProdutoFinal(String CNPJCliente, int codProd, LocalDate data, LocalTime hora, int qtdeVendida){
        try{
            List<ProdutoFinal> prodsFinais = GerenciaProdutoFinal.SelectProdutosFinais();
            boolean qtdeEmEstoqueInsuficiente = false;
            String ingredInsuficienteMessage = null;

            for(ProdutoFinal pf : prodsFinais){
                if(pf.getCod() == codProd){
                    if(pf.getQtdePronta() < qtdeVendida){
                        ingredInsuficienteMessage = "Impossível vender " + qtdeVendida + " unidades do produto " + pf.getNome() + ", estoque possui apenas " + pf.getQtdePronta() + ".";
                        //System.out.println("Impossível vender " + qtdeVendida + " unidades do produto " + pf.getNome() + ", estoque possui apenas " + pf.getQtdePronta() + ".");
                        qtdeEmEstoqueInsuficiente = true;
                    }
                }
            }

            if(ingredInsuficienteMessage != null)
                JanelaAlerta.Display("Produto insuficiente no estoque", ingredInsuficienteMessage);

            // se tem quantidade suficiente do produto em estoque
            if(!qtdeEmEstoqueInsuficiente){
                // insere venda no BD
                Database.ExecuteInsertUpdateORDelete(insertVendaProdFinal + "('" + CNPJCliente + "', " + codProd + ", '" + data + "', '" + LocalTime.now() + "', " + qtdeVendida + ");");

                // atualiza quantidade to produto em estoque
                GerenciaProdutoFinal.UpdateProdutoFinalDiminuirQtdePronta(codProd, qtdeVendida);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
