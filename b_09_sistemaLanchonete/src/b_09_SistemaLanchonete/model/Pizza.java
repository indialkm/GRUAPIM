package b_09_SistemaLanchonete.model;

import java.time.LocalDateTime;

public class Pizza extends Prato {
	
	private String molho;
    private String recheio;
    private String borda;


	public Pizza(double precoVenda, LocalDateTime dataValidade, double peso, StatusPrato staus, String molho,
			String recheio, String borda) {
		super(precoVenda, dataValidade, peso, staus);
		this.molho = molho;
		this.recheio = recheio;
		this.borda = borda;
	}

	public String getMolho() {
		return molho;
	}

	public void setMolho(String molho) {
		this.molho = molho;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getBorda() {
		return borda;
	}

	public void setBorda(String borda) {
		this.borda = borda;
	}
	
	@Override
	public double calcularPreco() {
		return ( precoVenda * 0.6 ) + precoVenda;
	};
	
	@Override
	public String toString() {
	    return super.toString() + 
	           " | Recheio: " + recheio + 
	           " | Borda: " + borda + 
	           " | Molho: " + molho;
	}

}
