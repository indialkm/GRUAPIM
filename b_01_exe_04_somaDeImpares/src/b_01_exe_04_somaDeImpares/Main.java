package b_01_exe_04_somaDeImpares;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6,7,8,9,10}; 
		
		int soma = 0;
		for(int num:array) {
	
			soma += (num % 2 != 0) ? num : 0;
		}
		
		System.out.println("A soma dos impares é " + soma);
	}
		

}
