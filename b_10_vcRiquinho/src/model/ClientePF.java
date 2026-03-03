package model;


public class ClientePF extends Cliente {

	private final String cpf;

	public ClientePF(String nome, String email, String cpf) {
		super(nome, email, cpf);
		this.cpf = cpf.replaceAll("[^0-9]", "");
	}

	@Override
	public double getTaxaServico() {
		
		return 0.001;
	}

	public String getCpf() {
		return cpf;
	}

}
