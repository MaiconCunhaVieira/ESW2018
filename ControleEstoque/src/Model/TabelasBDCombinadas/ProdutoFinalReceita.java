package Model.TabelasBDCombinadas;

// classe contém dados da tabela de produtos e da tabela de receitas
public class ProdutoFinalReceita {

    private String nomeProduto;
    private String nomeIngrediente;
    private int qtdeIngrediente;

    // setters
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setNomeIngrediente(String nomeIngrediente) { this.nomeIngrediente = nomeIngrediente; }
    public void setQtdeIngrediente(int qtdeIngrediente) { this.qtdeIngrediente = qtdeIngrediente; }

    // getters
    public String getNomeProduto() { return nomeProduto; }
    public String getNomeIngrediente() { return nomeIngrediente; }
    public int getQtdeIngrediente() { return qtdeIngrediente; }

    public ProdutoFinalReceita(String nomeProduto, String nomeIngrediente, int qtdeIngrediente) {
        this.nomeProduto = nomeProduto;
        this.nomeIngrediente = nomeIngrediente;
        this.qtdeIngrediente = qtdeIngrediente;
    }
}
