package b_02_exe_02_circulo;

public class Circulo {
	private double raio;
	

	public Circulo(double raio) {
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		
		try {
			
		this.raio = raio;
		
		}catch(IllegalArgumentException e) {
			System.out.println("Erro: O aio precisa ser maior que 0 e diferente de 0.");
		}
	}
	
	public double calcularArea() {
		 double circulo = Math.PI * Math.pow(raio, 2);
		 return circulo;
	}
	

}
