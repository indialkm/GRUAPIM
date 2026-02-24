package model;

public class ProdutoRendaFixa extends Produto {

	private double redimentomensalFixo;
	private int periodoCarencia;
	
	public ProdutoRendaFixa(String nome, String descricao, double redimentomensalFixo, int periodoCarencia) {
		super(nome, descricao);
		this.redimentomensalFixo = redimentomensalFixo;
		this.periodoCarencia = periodoCarencia;
	}

	public double getRedimentomensalFixo() {
		return redimentomensalFixo;
	}

	public void setRedimentomensalFixo(double redimentomensalFixo) {
		this.redimentomensalFixo = redimentomensalFixo;
	}

	public int getPeriodoCarencia() {
		return periodoCarencia;
	}

	public void setPeriodoCarencia(int periodoCarencia) {
		this.periodoCarencia = periodoCarencia;
	}
	

}
