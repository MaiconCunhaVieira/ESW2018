package TabelasBDCombinadas;

public class ProdutoPrecoVendaQtde {

    private float precoProd;
    private int qtdeVendida;

    public void setPrecoProd(float precoProd) { this.precoProd = precoProd; }
    public void setQtdeVendida(int qtdeVendida) { this.qtdeVendida = qtdeVendida; }

    public float getPrecoProd() { return precoProd; }
    public int getQtdeVendida() { return qtdeVendida; }

    public ProdutoPrecoVendaQtde(float precoProd, int qtdeVendida) {
        this.precoProd = precoProd;
        this.qtdeVendida = qtdeVendida;
    }
}
