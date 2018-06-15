package TabelasBD;

// classe contém dados da tabela de produtos
public class ProdutoFinal {

    private int cod;
    private String nome;
    private int qtdePronta;
    private float preco;
    private int peso; // em miligramas

    // setters
    public void setCod(int cod) { this.cod = cod; }
    public void setSNome(String nome) { this.nome = nome; }
    public void setQtdePronta(int qtdePronta) { this.qtdePronta = qtdePronta; }
    public void setPreco(float preco) { this.preco = preco; }
    public void setPeso(int peso) { this.peso = peso; }

    // getters
    public int getCod() { return cod; }
    public String getNome() { return nome; }
    public int getQtdePronta() { return qtdePronta; }
    public float getPreco() { return preco; }
    public int getPeso() { return peso; }

    public ProdutoFinal(int cod, String nome, int qtdePronta, float preco, int peso){
        this.cod = cod;
        this.nome = nome;
        this.qtdePronta = qtdePronta;
        this.preco = preco;
        this.peso = peso;
    }
}
