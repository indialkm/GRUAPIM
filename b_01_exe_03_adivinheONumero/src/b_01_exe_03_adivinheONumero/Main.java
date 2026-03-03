package b_01_exe_03_adivinheONumero;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
	
		int num = rand.nextInt(100);
		//System.out.println(num);
		
		boolean j = false;
		int ten = 0;
		while(j == false)
		{
			
			System.out.println("Digite um número");
			int numUser = scan.nextInt();
			j = (numUser == num) ? true : false ;
		
			if(num <= numUser - 10 || num >= numUser + 10)
			{
				System.out.println("Muito baixo");
			}else if(numUser == num) {
					System.out.println("Venceu o número é " + num + " e acertou em " + ten + " tentativas.");
			}else {
					System.out.println("Muito alto");
			}
			ten++;
			//System.out.println(j);
			
		}
		
		scan.close();
		
	}

}
