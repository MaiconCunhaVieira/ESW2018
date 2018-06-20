package Model.TabelasBDCombinadas;

import java.time.LocalDate;
import java.time.LocalTime;

// classe contém dados da tabela de produtos e de produções
public class ProdutoFinalProducao {

    private String nomeProdutoFinal;
    private LocalDate dataProducao;
    private LocalTime horaProducao;
    private int qtdeProducao;

    // setters
    public void setNomeProdutoFinal(String nomeProdutoFinal) { this.nomeProdutoFinal = nomeProdutoFinal; }
    public void setDataProducao(LocalDate dataProducao) { this.dataProducao = dataProducao; }
    public void setHoraProducao(LocalTime horaProducao) { this.horaProducao = horaProducao; }
    public void setQtdeProducao(int qtdeProducao) { this.qtdeProducao = qtdeProducao; }

    // getters
    public String getNomeProdutoFinal() { return nomeProdutoFinal; }
    public LocalDate getDataProducao() { return dataProducao; }
    public LocalTime getHoraProducao() { return horaProducao; }
    public int getQtdeProducao() { return qtdeProducao; }

    public ProdutoFinalProducao(String nomeProdutoFinal, LocalDate dataProducao, LocalTime horaProducao, int qtdeProducao) {
        this.nomeProdutoFinal = nomeProdutoFinal;
        this.dataProducao = dataProducao;
        this.horaProducao = horaProducao;
        this.qtdeProducao = qtdeProducao;
    }
}
