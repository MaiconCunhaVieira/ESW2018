package TabelasBD;

// classe contém dados da tabela de ingredientes
public class Ingrediente {

    private int cod;
    private String nome;
    private int qtdeAtual;
    private String unidade;

    // setters
    public void setCod(int cod){
        this.cod = cod;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setQtdeAtual(int qtdeAtual){
        this.qtdeAtual = qtdeAtual;
    }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    // getters
    public int getCod(){
        return cod;
    }
    public String getNome(){
        return nome;
    }
    public int getQtdeAtual(){
        return qtdeAtual;
    }
    public String getUnidade() { return unidade; }

    public Ingrediente(int cod, String nome, int qtdeAtual, String unidade){
        this.cod = cod;
        this.nome = nome;
        this.qtdeAtual = qtdeAtual;
        this.unidade = unidade;
    }
}
