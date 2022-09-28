package teste;

import java.util.Scanner;

import modelo.Conta;
import modelo.DataAbertura;

public class TesteConta {

    public static void main(String args[]){

        Scanner lerTeclado = new Scanner(System.in);
        
        int valor = 0;

        Conta c1 = new Conta();
        c1.titular = "Jose";
        c1.numero = 271294;
        c1.agencia = "0369";
        c1.saldo = 100;

        DataAbertura openDate = new DataAbertura();
        openDate.dia = 28;
        openDate.mes = 9;
        openDate.ano = 2022;

        c1.dataAbertura = openDate;

        //saquei 50R$ antes de pedir extrato
        System.out.println("Quer sacar um valor? \n 0 - Nao | 1 - Sim");
        int op = lerTeclado.nextInt();

        switch (op) {
            case 0:
                    System.out.println(c1.extrato());
                break;
            case 1:
                    System.out.println("Qual valor? ");
                    valor = lerTeclado.nextInt();
                    c1.saca(valor);
                    System.out.println(c1.extrato());
                break;
            default:
                System.out.println("Valor invalido");
                break;
        } 

        

    }



}
