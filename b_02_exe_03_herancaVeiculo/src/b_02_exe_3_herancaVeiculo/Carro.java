package b_02_exe_3_herancaVeiculo;

public class Carro extends Veiculo {
	
	private int numeroDePortas;
	public Carro(String modelo, String marca, int numeroDePortas) {
		super(modelo, marca);
		// TODO Auto-generated constructor stub
		this.numeroDePortas = numeroDePortas;
	}
	
	@Override
	public String toString() {
		return "Carro "
				+ "\nMarca: " + this.marca 
				+ "\nModelo " + this.modelo 
				+ "\nNúmero de portas: " + this.numeroDePortas;
	}

}
