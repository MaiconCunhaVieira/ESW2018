package TabelasBD;

public class Ingrediente {

    private int cod;
    private String nome;
    private int qtdeAtual;

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

    public Ingrediente(int cod, String nome, int qtdeAtual){
        this.cod = cod;
        this.nome = nome;
        this.qtdeAtual = qtdeAtual;
    }
}
