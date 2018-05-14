
public class Fornecedor {
    private string CNPJ, name, adr, phone;

    // setters fornec > Fornecedores poderão ser alterados depois de cadastrados? Se não, setters não são necessários <

    public void setCNPJ(string CNPJ){
        this.CNPJ = CNPJ;
    }

    public void setName(string name){
        this.name = name;
    }

    public void setAdr(string adr){
        this.adr = adr;
    }

    public void setPhone(string phone){
        this.phone = phone;
    }

    // getters fornec

    public string getCNPJ(){
        return CNPJ;
    }

    public string getName(){
        return name;
    }

    public string getAdr(){
        return adr;
    }

    public string getPhone(){
        return phone;
    }
}
