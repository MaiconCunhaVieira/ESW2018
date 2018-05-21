package TabelasBDCombinadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class FornecIngredCompra {

    private String nomeFornec;
    private String nomeIngred;
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private int qtdeCompradaIngred;
    private float precoCompra;

    // setters
    public void setNomeFornec(String nomeFornec) { this.nomeFornec = nomeFornec; }
    public void setNomeIngred(String nomeIngred) { this.nomeIngred = nomeIngred; }
    public void setDataCompra(LocalDate dataCompra) { this.dataCompra = dataCompra; }
    public void setHoraCompra(LocalTime horaCompra) { this.horaCompra = horaCompra; }
    public void setQtdeCompradaIngred(int qtdeCompradaIngred) { this.qtdeCompradaIngred = qtdeCompradaIngred; }
    public void setPrecoCompra(float precoCompra) { this.precoCompra = precoCompra; }

    // getters
    public String getNomeFornec() { return nomeFornec; }
    public String getNomeIngred() { return nomeIngred; }
    public LocalDate getDataCompra() { return dataCompra; }
    public LocalTime getHoraCompra() { return horaCompra; }
    public int getQtdeCompradaIngred() { return qtdeCompradaIngred; }
    public float getPrecoCompra() { return precoCompra; }

    public FornecIngredCompra(String nomeFornec, String nomeIngred, LocalDate dataCompra, LocalTime horaCompra, int qtdeCompradaIngred, float precoCompra) {
        this.nomeFornec = nomeFornec;
        this.nomeIngred = nomeIngred;
        this.dataCompra = dataCompra;
        this.horaCompra = horaCompra;
        this.qtdeCompradaIngred = qtdeCompradaIngred;
        this.precoCompra = precoCompra;
    }
}
