package model;


public class ClientePJ extends Cliente {
	
	public ClientePJ(String nome, String email, String cnpj) {
		super(nome, email, cnpj);
		// TODO Auto-generated constructor stub
		this.cnpj = cnpj.replaceAll("[^0-9]", "");
	}


	private final String cnpj;

	

	@Override
	public double getTaxaServico() {
		// TODO Auto-generated method stub
		return 0.0015;
	}

	public String getCnpj() {
		return cnpj;
	}


}
