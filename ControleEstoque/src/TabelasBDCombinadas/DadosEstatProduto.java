package TabelasBDCombinadas;

public class DadosEstatProduto {

    private String nomeProduto;
    private int qtdeProduzida;
    private int qtdeVendida;

    // setters
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setQtdeProduzida(int qtdeProduzida) { this.qtdeProduzida = qtdeProduzida; }
    public void setQtdeVendida(int qtdeVendida) { this.qtdeVendida = qtdeVendida; }

    // getters
    public String getNomeProduto() { return nomeProduto; }
    public int getQtdeProduzida() { return qtdeProduzida; }
    public int getQtdeVendida() { return qtdeVendida; }

    public DadosEstatProduto(String nomeProduto, int qtdeProduzida, int qtdeVendida) {
        this.nomeProduto = nomeProduto;
        this.qtdeProduzida = qtdeProduzida;
        this.qtdeVendida = qtdeVendida;
    }
}
