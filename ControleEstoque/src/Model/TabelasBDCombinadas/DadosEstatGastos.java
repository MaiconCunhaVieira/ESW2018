package Model.TabelasBDCombinadas;

import java.time.LocalDate;

public class DadosEstatGastos {

    private LocalDate data;
    private int totalGastosGerais;
    private int totalGastosCompras;
    private int totalGanhoVendas;
    private int totalLucro;

    public void setData(LocalDate data) { this.data = data; }
    public void setTotalGastosGerais(int totalGastosGerais) { this.totalGastosGerais = totalGastosGerais; }
    public void setTotalGastosCompras(int totalGastosCompras) { this.totalGastosCompras = totalGastosCompras; }
    public void setTotalGanhoVendas(int totalGanhoVendas) { this.totalGanhoVendas = totalGanhoVendas; }
    public void setTotalLucro(int totalLucro) { this.totalLucro = totalLucro; }

    public LocalDate getData() { return data; }
    public int getTotalGastosGerais() { return totalGastosGerais; }
    public int getTotalGastosCompras() { return totalGastosCompras; }
    public int getTotalGanhoVendas() { return totalGanhoVendas; }
    public int getTotalLucro() { return totalLucro; }

    public DadosEstatGastos(LocalDate data, int totalGastosGerais, int totalGastosCompras, int totalGanhoVendas, int totalLucro) {
        this.data = data;
        this.totalGastosGerais = totalGastosGerais;
        this.totalGastosCompras = totalGastosCompras;
        this.totalGanhoVendas = totalGanhoVendas;
        this.totalLucro = totalLucro;
    }
}
