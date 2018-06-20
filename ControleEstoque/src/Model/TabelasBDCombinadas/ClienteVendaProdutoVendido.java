package Model.TabelasBDCombinadas;

public class ClienteVendaProdutoVendido {

    private String nomeCliente;
    private String nomeProduto;
    private int qtdeVendidaProd;

    // setters
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setQtdeVendidaProd(int qtdeVendidaProd) { this.qtdeVendidaProd = qtdeVendidaProd; }

    // getters
    public String getNomeCliente() { return nomeCliente; }
    public String getNomeProduto() { return nomeProduto; }
    public int getQtdeVendidaProd() { return qtdeVendidaProd; }

    public ClienteVendaProdutoVendido(String nomeCliente, String nomeProduto, int qtdeVendidaProd) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.qtdeVendidaProd = qtdeVendidaProd;
    }
}
