package TabelasBD;

import java.sql.Date;
import java.sql.Time;

public class CompraIngrediente {

    private String CNPJFornec;
    private int codIngred;
    private Date data;
    private Time hora;
    private int qtdeIngred;
    private float preco;

    // setters
    public void setCNPJFornec(String CNPJFornec){
        this.CNPJFornec = CNPJFornec;
    }
    public void setCodIngred(int codIngred){
        this.codIngred = codIngred;
    }
    public void setData(Date data){
        this.data = data;
    }
    public void setHora(Time hora){
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
    public Date getData(){
        return data;
    }
    public Time getHora(){
        return hora;
    }
    public int getQtdeIngred(){
        return qtdeIngred;
    }
    public float getPreco(){
        return preco;
    }
}
