package TabelasBD;

import java.time.LocalDate;
import java.time.LocalTime;

public class VendaProdutoFinal {

    private int codProd;
    private String CNPJCliente;
    private LocalDate data;
    private LocalTime hora;
    private int qtde;

    // setters
    public void setCodProd(int codProd) { this.codProd = codProd; }
    public void setCNPJCliente(String CNPJCliente) { this.CNPJCliente = CNPJCliente; }
    public void setData(LocalDate data) { this.data = data; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setQtde(int qtde) { this.qtde = qtde; }

    // getters
    public int getCodProd() { return codProd; }
    public String getCNPJCliente() { return CNPJCliente; }
    public LocalDate getData() { return data; }
    public LocalTime getHora() { return hora; }
    public int getQtde() { return qtde; }

    public VendaProdutoFinal(int codProd, String CNPJCliente, LocalDate data, LocalTime hora, int qtde){
        this.codProd = codProd;
        this.CNPJCliente = CNPJCliente;
        this.data = data;
        this.hora = hora;
        this.qtde = qtde;
    }
}
