package b_02_exe_4_excecaoPersonalizada;

import b_02_exe_4_excecaoPersonalizada.excecoes.SaqueInsuficienteException;
import b_02_exe_4_excecaoPersonalizada.model.ContaBancaria;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ContaBancaria conta = new ContaBancaria("12345678910","Joao das Neves", 10.00 );
		
		try {
		
			conta.sacar(20.00);
		
		}catch(SaqueInsuficienteException e) {
			
			System.out.println(e);
		}
		
		
	}

}
