package b_01_exe_02_tabuada;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um número para ver a tabuada: ");
        int numero = leitor.nextInt();

        System.out.println("\nTabuada do " + numero + ":");
        
      
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        leitor.close();
    }

}
