package TabelasBDCombinadas;

public class DadosEstatCliente {

    private String nomeCliente;
    private int numVendasCliente;
    private String produtoMaisVendido;
    private int numVendProdMaisVend;

    // setters
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setNumVendasCliente(int numVendasCliente) { this.numVendasCliente = numVendasCliente; }
    public void setProdutoMaisVendido(String produtoMaisVendido) { this.produtoMaisVendido = produtoMaisVendido; }
    public void setNumVendProdMaisVend(int numVendProdMaisVend) { this.numVendProdMaisVend = numVendProdMaisVend; }

    // setters
    public String getNomeCliente() { return nomeCliente; }
    public int getNumVendasCliente() { return numVendasCliente; }
    public String getProdutoMaisVendido() { return produtoMaisVendido; }
    public int getNumVendProdMaisVend() { return numVendProdMaisVend; }

    public DadosEstatCliente(String nomeCliente, int numVendasCliente, String produtoMaisVendido, int numVendProdMaisVend) {
        this.nomeCliente = nomeCliente;
        this.numVendasCliente = numVendasCliente;
        this.produtoMaisVendido = produtoMaisVendido;
        this.numVendProdMaisVend = numVendProdMaisVend;
    }
}
