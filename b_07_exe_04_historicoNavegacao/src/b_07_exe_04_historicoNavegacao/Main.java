package b_07_exe_04_historicoNavegacao;

import java.util.Scanner;

import b_07_exe_04_historicoNavegacao.model.Historico;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Historico navegacao = new Historico();
		Scanner scan = new Scanner(System.in);
		
		
		
		navegacao.visitar("www.google.com");
		navegacao.visitar("www.youtube.com");
		navegacao.visitar("www.gmail.com");
		navegacao.visitar("www.stardoll.com");
		System.out.println("");
		
		navegacao.voltar();
		navegacao.voltar();
		navegacao.voltar();
		
		System.out.println();
		navegacao.avancar();
		navegacao.avancar();
		navegacao.avancar();
		navegacao.avancar();

	}

}
