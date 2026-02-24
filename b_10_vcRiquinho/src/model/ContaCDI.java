package model;

public class ContaCDI extends Conta {

	public double cdi;
	public ContaCDI(String numero, double saldo, double cdi) {
		super(numero, saldo);
		this.cdi = cdi;
	}
	

	public double getCdi() {
		return cdi;
	}


	public void setCdi(double cdi) {
		this.cdi = cdi;
	}
	
}
