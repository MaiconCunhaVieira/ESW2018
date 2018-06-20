package Model.TabelasBD;

import java.time.LocalDate;
import java.time.LocalTime;

// classe contém dados databela de produções
public class Producao {

    private int codProd;
    private LocalDate data;
    private LocalTime hora;
    private int qtde;

    // setters
    public void setCodProd(int codProd) { this.codProd = codProd; }
    public void setData(LocalDate data) { this.data = data; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setQtde(int qtde) { this.qtde = qtde; }

    // getters
    public int getCodProd() { return codProd; }
    public LocalDate getData() { return data; }
    public LocalTime getHora() { return hora; }
    public int getQtde() { return qtde; }

    public Producao(int codProd, LocalDate data, LocalTime hora, int qtde){
        this.codProd = codProd;
        this.data = data;
        this.hora = hora;
        this.qtde = qtde;
    }
}
