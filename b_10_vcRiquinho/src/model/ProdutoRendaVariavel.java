package model;

public class ProdutoRendaVariavel extends Produto {
	
	private double rendimentoMensalEsperado;

	public ProdutoRendaVariavel(String nome, String descricao, double rendimentoMensalEsperado) {
		super(nome, descricao);
		this.rendimentoMensalEsperado = rendimentoMensalEsperado;
	}

	public double getRendimentoMensalEsperado() {
		return rendimentoMensalEsperado;
	}

	public void setRendimentoMensalEsperado(double rendimentoMensalEsperado) {
		this.rendimentoMensalEsperado = rendimentoMensalEsperado;
	}

	

}
