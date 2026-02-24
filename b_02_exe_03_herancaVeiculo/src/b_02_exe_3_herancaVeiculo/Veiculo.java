package b_02_exe_3_herancaVeiculo;

public class Veiculo {
	
	protected String modelo;
	protected String marca;
	
	public Veiculo(String modelo, String marca) {
		this.modelo = modelo;
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Veiculo [modelo=" + modelo + ", marca=" + marca + "]";
	}
	
	
}
