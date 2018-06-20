package TabelasBD;

import java.time.LocalDate;

public class Gastos {

    private int cod;
    private int luz;
    private int agua;
    private int funcionarios;
    private int outros;
    private LocalDate data;

    // setters
    public void setCod(int cod) { this.cod = cod; }
    public void setLuz(int luz) { this.luz = luz; }
    public void setAgua(int agua) { this.agua = agua; }
    public void setFuncionarios(int funcionarios) { this.funcionarios = funcionarios; }
    public void setOutros(int outros) { this.outros = outros; }
    public void setData(LocalDate data) { this.data = data; }

    // getters
    public int getCod() { return cod; }
    public int getLuz() { return luz; }
    public int getAgua() { return agua; }
    public int getFuncionarios() { return funcionarios; }
    public int getOutros() { return outros; }
    public LocalDate getData() { return data; }

    public Gastos(int cod, int luz, int agua, int funcionarios, int outros, LocalDate data) {
        this.cod = cod;
        this.luz = luz;
        this.agua = agua;
        this.funcionarios = funcionarios;
        this.outros = outros;
        this.data = data;
    }
}
