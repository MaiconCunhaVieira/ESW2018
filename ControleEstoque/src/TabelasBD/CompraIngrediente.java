package TabelasBD;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraIngrediente {

    private String CNPJFornec;
    private int codIngred;
    private LocalDate data;
    private LocalTime hora;
    private int qtdeIngred;
    private float preco;

    // setters
    public void setCNPJFornec(String CNPJFornec){
        this.CNPJFornec = CNPJFornec;
    }
    public void setCodIngred(int codIngred){
        this.codIngred = codIngred;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    public void setHora(LocalTime hora){
        this.hora = hora;
    }
    public void setQtdeIngred(int qtdeIngred){
        this.qtdeIngred = qtdeIngred;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }

    // getters
    public String getCNPJFornec(){
        return CNPJFornec;
    }
    public int getCodIngred(){
        return codIngred;
    }
    public LocalDate getData(){
        return data;
    }
    public LocalTime getHora(){
        return hora;
    }
    public int getQtdeIngred(){
        return qtdeIngred;
    }
    public float getPreco(){
        return preco;
    }

    public CompraIngrediente(String CNPJFornec, int codIngred, LocalDate data, LocalTime hora, int qtdeIngred, float preco){
        this.CNPJFornec = CNPJFornec;
        this.codIngred = codIngred;
        this.data = data;
        this.hora = hora;
        this.qtdeIngred = qtdeIngred;
        this.preco = preco;
    }
}
