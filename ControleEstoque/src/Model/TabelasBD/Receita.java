package Model.TabelasBD;

// classe contém dados da tabela de receitas
public class Receita {

    private int codProd;
    private int codIngred;
    private int qtdeIngred;

    // setters
    public void setCodProd(int codProd) { this.codProd = codProd; }
    public void setCodIngred(int codIngred) { this.codIngred = codIngred; }
    public void setQtdeIngred(int qtdeIngred) { this.qtdeIngred = qtdeIngred; }

    // getters
    public int getCodProd() { return codProd; }
    public int getCodIngred() { return codIngred; }
    public int getQtdeIngred() { return qtdeIngred; }

    public Receita(int codProd, int codIngred, int qtdeIngred){
        this.codProd = codProd;
        this.codIngred = codIngred;
        this.qtdeIngred = qtdeIngred;
    }
}
