package Model.TabelasBDCombinadas;

import java.time.LocalDate;
import java.time.LocalTime;

// classe contém dados da tabelas de clientes, de produtos e de vendas
public class VendaProdClienteProduto {

    private String nomeCliente;
    private String nomeProduto;
    private LocalDate dataVenda;
    private LocalTime horaVenda;
    private int qtdeVendida;
    private float precoTotal;

    // setters
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
    public void setHoraVenda(LocalTime horaVenda) { this.horaVenda = horaVenda; }
    public void setQtdeVendida(int qtdeVendida) { this.qtdeVendida = qtdeVendida; }
    public void setPrecoTotal(float precoTotal) { this.precoTotal = precoTotal; }

    // getters
    public String getNomeCliente() { return nomeCliente; }
    public String getNomeProduto() { return nomeProduto; }
    public LocalDate getDataVenda() { return dataVenda; }
    public LocalTime getHoraVenda() { return horaVenda; }
    public int getQtdeVendida() { return qtdeVendida; }
    public float getPrecoTotal() { return precoTotal; }

    public VendaProdClienteProduto(String nomeCliente, String nomeProduto, LocalDate dataVenda, LocalTime horaVenda, int qtdeVendida, float precoTotal) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.qtdeVendida = qtdeVendida;
        this.precoTotal = precoTotal;
    }
}
