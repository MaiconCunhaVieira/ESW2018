package Model.TabelasBDCombinadas;

public class IngredienteReceitaProducao {

    private String nomeIngrediente;
    private int qtdeReceita;
    private int qtdeProduzida;

    // setters
    public void setNomeIngrediente(String nomeIngrediente) { this.nomeIngrediente = nomeIngrediente; }
    public void setQtdeReceita(int qtdeReceita) { this.qtdeReceita = qtdeReceita; }
    public void setQtdeProduzida(int qtdeProduzida) { this.qtdeProduzida = qtdeProduzida; }

    // getters
    public String getNomeIngrediente() { return nomeIngrediente; }
    public int getQtdeReceita() { return qtdeReceita; }
    public int getQtdeProduzida() { return qtdeProduzida; }

    public IngredienteReceitaProducao(String nomeIngrediente, int qtdeReceita, int qtdeProduzida) {
        this.nomeIngrediente = nomeIngrediente;
        this.qtdeReceita = qtdeReceita;
        this.qtdeProduzida = qtdeProduzida;
    }
}
