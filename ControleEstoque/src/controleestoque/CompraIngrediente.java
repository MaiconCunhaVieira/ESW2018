package controleestoque;

public class CompraIngrediente {
    private String data, hora, quantidade, preco;

    // setters
    public void setData(String newData){
        this.data = newData;
    }

    public void setHora(String newHora){
        this.hora = newHora;
    }

    public void setQuantidade(String newQuantidade){
        this.quantidade = newQuantidade;
    }

    public void setPreco(String newPreco){
        this.preco = newPreco;
    }

    // getters
    public String getData(){
        return data;
    }

    public String getHora(){
        return hora;
    }

    public String getQuantidade(){
        return quantidade;
    }

    public String getPreco(){
        return preco;
    }
}
