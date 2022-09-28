package modelo;

public class DataAbertura {

    public int dia;
    public int mes;
    public int ano;

    public String dataAberturaFormatada(){
        return this.dia+"/"+this.mes+"/"+this.ano;
    }

}
