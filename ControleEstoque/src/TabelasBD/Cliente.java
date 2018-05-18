package TabelasBD;

public class Cliente {

    private String CNPJ;
    private String nome;
    private String endereco;
    private String telefone;

    // setters
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

    // getters
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

    public Cliente(String CNPJ, String nome, String endereco, String telefone){
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
