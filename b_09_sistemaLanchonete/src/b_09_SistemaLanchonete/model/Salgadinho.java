package b_09_SistemaLanchonete.model;

import java.time.LocalDateTime;

public class Salgadinho extends Prato {
	
	private String tipoSalgadinho; // assado ou frito
	private String massa;
	private String recheio;

	
	

	
	


	public Salgadinho(double precoVenda, LocalDateTime dataValidade, double peso, StatusPrato staus,
			String tipoSalgadinho, String massa, String recheio) {
		super(precoVenda, dataValidade, peso, staus);
		this.tipoSalgadinho = tipoSalgadinho;
		this.massa = massa;
		this.recheio = recheio;
	}





	public String getTipoSalgadinho() {
		return tipoSalgadinho;
	}





	public void setTipoSalgadinho(String tipoSalgadinho) {
		this.tipoSalgadinho = tipoSalgadinho;
	}





	public String getMassa() {
		return massa;
	}





	public void setMassa(String massa) {
		this.massa = massa;
	}





	public String getRecheio() {
		return recheio;
	}





	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}





	@Override
	public double calcularPreco() {
		return ( precoVenda * 0.2 ) + precoVenda;
	};
	
	@Override
	public String toString() {
	    return super.toString() + 
	           " | Tipo: " + tipoSalgadinho + 
	           " | Massa: " + massa + 
	           " | Recheio: " + recheio;
	}

}
