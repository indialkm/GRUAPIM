package b_09_SistemaLanchonete.model;

import java.time.LocalDateTime;

public class Lanche extends Prato {
	
	private String tipoPao;
	private String molho;
	private String recheios;

	
	public Lanche(double precoVenda, LocalDateTime dataValidade, double peso, StatusPrato staus, String tipoPao,
			String molho, String recheios) {
		super(precoVenda, dataValidade, peso, staus);
		this.tipoPao = tipoPao;
		this.molho = molho;
		this.recheios = recheios;
	}


	public String getTipoPao() {
		return tipoPao;
	}


	public void setTipoPao(String tipoPao) {
		this.tipoPao = tipoPao;
	}


	public String getMolho() {
		return molho;
	}


	public void setMolho(String molho) {
		this.molho = molho;
	}


	public String getRecheios() {
		return recheios;
	}


	public void setRecheios(String recheios) {
		this.recheios = recheios;
	}
	
	@Override
	public double calcularPreco() {
		return ( precoVenda * 0.5 ) + precoVenda ;
	};

	@Override
	public String toString() {
	    return super.toString() + 
	           " | Pão: " + tipoPao + 
	           " | Recheio: " + recheios + 
	           " | Molho: " + molho;
	}
}
