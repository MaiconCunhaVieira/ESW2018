package Model.TabelasBDCombinadas;

public class DadosEstatIngrediente {

    private int codIngred;
    private String nome;
    private int qtdeConsumida;

    // setters
    public void setCodIngred(int codIngred) { this.codIngred = codIngred; }
    public void setNome(String nome) { this.nome = nome; }
    public void setQtdeConsumida(int qtdeConsumida) { this.qtdeConsumida = qtdeConsumida; }

    // getters
    public int getCodIngred() { return codIngred; }
    public String getNome() { return nome; }
    public int getQtdeConsumida() { return qtdeConsumida; }

    public DadosEstatIngrediente(int codIngred, String nome, int qtdeConsumida) {
        this.codIngred = codIngred;
        this.nome = nome;
        this.qtdeConsumida = qtdeConsumida;
    }
}
