package controleestoque;

public class Fornecedor {
    private String CNPJ, name, adr, phone;

    // setters fornec > Fornecedores poderão ser alterados depois de cadastrados? Se não, setters não são necessários <

    public void setCNPJ(String newCNPJ){
        this.CNPJ = newCNPJ;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAdr(String newAdr){
        this.adr = newAdr;
    }

    public void setPhone(String newPhone){
        this.phone = newPhone;
    }

    // getters fornec

    public String getCNPJ(){
        return CNPJ;
    }

    public String getName(){
        return name;
    }

    public String getAdr(){
        return adr;
    }

    public String getPhone(){
        return phone;
    }
}
