package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sorteio {
	
	private List<String> jogadores = new ArrayList<>();
	private String primeiro = null;
	private String segundo = null;
	private String terceiro = null;
	private List<String> jogadoresSemRepeticao = new ArrayList<>();
	
	
	public Sorteio(List<String> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void gerandoSorteio() {
		this.jogadoresSemRepeticao.addAll(retirarDuplicados(jogadores));
		this.sortear();
		this.anunciar();
		
	}
	
	public void setJogadores(List<String> jogador) {
		this.jogadores.addAll(jogador);
	}
	
	public String getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(String primeiro) {
		this.primeiro = primeiro;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getTerceiro() {
		return terceiro;
	}

	public void setTerceiro(String terceiro) {
		this.terceiro = terceiro;
	}

	private List<String> retirarDuplicados(List<String> listaDuplicados){
		
		Set<String> jogadoresSet = new HashSet<>(jogadores);		
		return new ArrayList<>(jogadoresSet);
		
	}
	
	private void sortear() {	
			
		Collections.shuffle(this.jogadoresSemRepeticao);
			
		this.primeiro = jogadoresSemRepeticao.get(0);
		this.segundo = jogadoresSemRepeticao.get(1);
		this.terceiro = jogadoresSemRepeticao.get(2);
		
		
	}
	
	public void anunciar() {
		
		System.out.printf("****Sorteio****\n"
						+ "1ª Lugar : %s\n"
						+ "2ª Lugar : %s\n"
						+ "3ª Lugar : %s\n", this.primeiro, this.segundo, this.terceiro);
	
	}
	
	

}
