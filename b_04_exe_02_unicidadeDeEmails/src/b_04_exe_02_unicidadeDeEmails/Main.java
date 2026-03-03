package b_04_exe_02_unicidadeDeEmails;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set <String> listaEmails = new HashSet<>();
		
		listaEmails.add("user@email.com");
		listaEmails.add("maria@email.com");
		listaEmails.add("joao@email.com");
		listaEmails.add("user@email.com");
		
		listaEmails.forEach(email-> System.out.println(email));

		
	}

}
