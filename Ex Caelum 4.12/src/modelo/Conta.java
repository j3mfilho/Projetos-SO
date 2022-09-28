package modelo;

public class Conta {


    public double saldo;
    public String titular;
    public int numero;
    public String agencia;
    public DataAbertura dataAbertura;

    public void saca(double valor){
        this.saldo = this.saldo - valor;
    }

    public void deposita(double valor){
        if(valor >=0){
            this.saldo = valor + this.saldo;
        }else{
            System.out.println("Não é possível depositar valores negativos ...");
        }
    }

    public double calculaRendimento(){
        return this.saldo*0.01;
    }

    public String	extrato() {
        String	dados	=	"Titular:	"	+ this.titular;
        dados	+=	"\nNúmero:	"	+ this.numero;
        dados	+=	"\nAgência:	"	+ this.agencia;
        dados	+=	"\nData de Abertura:	"	+	this.dataAbertura.dataAberturaFormatada();
        dados	+=	"\nSaldo atual:	"	+	this.saldo + "R$";
        dados	+=	"\nRendimento Mensal:	"	+	this.calculaRendimento();

        return	dados;
    }


}
