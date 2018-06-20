package Model.TabelasBDCombinadas;

public class NomeProdutoQtdeVendida {

    private String nomeprod;
    private int qtdeVendida;

    // setters
    public void setNomeprod(String nomeprod) { this.nomeprod = nomeprod; }
    public void setQtdeVendida(int qtdeVendida) { this.qtdeVendida = qtdeVendida; }

    // getters
    public String getNomeprod() { return nomeprod; }
    public int getQtdeVendida() { return qtdeVendida; }

    public NomeProdutoQtdeVendida(String nomeprod, int qtdeVendida) {
        this.nomeprod = nomeprod;
        this.qtdeVendida = qtdeVendida;
    }
}
