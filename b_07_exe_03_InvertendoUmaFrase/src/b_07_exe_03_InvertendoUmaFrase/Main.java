package b_07_exe_03_InvertendoUmaFrase;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Digite uma frase");
		String frase = scan.nextLine();
		
		//String frase = "O rato roeu a roupa do rei de roma";
		String[] palavras = frase.split(" ");
		
		
		Deque<String> pilha = new ArrayDeque<>(Arrays.asList(palavras));
		System.out.println("\nContrário");
		pilha.descendingIterator().forEachRemaining(item -> System.out.println(item));

		scan.close();
	}

}
