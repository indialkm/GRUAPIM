package b_02_exe_3_herancaVeiculo;

public class Moto extends Veiculo {
	
	private String cilindradas;

	public Moto(String modelo, String marca, String cilindradas) {
		super(modelo, marca);
		this.cilindradas = cilindradas;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Moto "
				+ "\nMarca: " + this.marca 
				+ "\nModelo " + this.modelo 
				+ "\nCilindradas: " + this.cilindradas;
	}

	
	
}
