package controleestoque;

public class Ingrediente {
    private String cod, nome, quantAtual;

    // setters
    public void setCod(String newCod){
        this.cod = newCod;
    }

    public void setNome(String newNome){
        this.nome = newNome;
    }

    public void setQuantAtual(String newQuantAtual){
        this.quantAtual = newQuantAtual;
    }

    //getters
    public String getCod(){
        return cod;
    }

    public String getNome(){
        return nome;
    }

    public String getQuantAtual(){
        return quantAtual;
    }
}
