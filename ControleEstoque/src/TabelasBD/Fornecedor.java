package TabelasBD;

public class Fornecedor {

    private String CNPJ;
    private String nome;
    private String endereco;
    private String telefone;

    // setters fornec > Fornecedores poderão ser alterados depois de cadastrados? Se não, setters não são necessários <

    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    public void setNome(String name){
        this.nome = name;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    // getters fornec

    public String getCNPJ(){
        return CNPJ;
    }
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTelefone(){
        return telefone;
    }
}
