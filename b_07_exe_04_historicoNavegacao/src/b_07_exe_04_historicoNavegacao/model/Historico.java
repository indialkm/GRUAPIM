package b_07_exe_04_historicoNavegacao.model;

import java.util.LinkedList;
import java.util.List;

public class Historico {
	
	private List<String> url = new LinkedList<>();
	private int ponteiro = -1;
	private int start = 0;
	

	public Historico() {
	}
	
	public void visitar(String url) {
		
		this.url.add(url);
		System.out.println("você está acessando a página da url " + url);
		
	};
	
	

	public void voltar() {
		
		
		//System.out.println("Tamanho da lista atual " + (this.url.size() - 1)) ;
		
		
		if(ponteiro == -1) {
			
			ponteiro = this.url.size() - 1;	
			//System.out.println("Indice do ponteiro " + ponteiro);
			System.out.println("Voltamos para a pagina: " + url.get(ponteiro - 1));
			
			ponteiro = ponteiro - 2;
		
		}else if(ponteiro >= 0) {
		
			
			//System.out.println("Ponteiro atual: " + ponteiro);
	        System.out.println("Voltamos para a pagina: " + url.get(ponteiro));
			ponteiro--;
			
			
		}else {
			System.out.println("Sem mais URLs no histórico");
			
			
		}
	
		//System.out.println("Indice do ponteiro " + ponteiro);
	
		}

	public void avancar() {
		
		
		if(ponteiro < this.url.size()) {
			
			ponteiro = ponteiro + 1;
			
			System.out.println("Avançamos para a pagina: " + url.get(ponteiro));
	
			System.out.println("Indice do ponteiro " + ponteiro);
			
			
			}else {
			System.out.println("Sem mais URLs no histórico");
			
			
		}
	
	
		
	}
	
	
	

}
