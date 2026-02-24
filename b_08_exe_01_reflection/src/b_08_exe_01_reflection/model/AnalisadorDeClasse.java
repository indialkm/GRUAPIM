package b_08_exe_01_reflection.model;

public class AnalisadorDeClasse {
	
	public static void inspecionar(Object obj){
		
		System.out.println("Nome da classe: " + obj.getClass().getName() + 
						"\nNome dos atributos: " + obj.getClass().getDeclaredFields() +
						 "\nNome dos métodos: " + obj.getClass().getDeclaredMethods());
		
		
		
	}
	

}
