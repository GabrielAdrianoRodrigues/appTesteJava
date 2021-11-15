package teste;

public class Aluguel{
	private double aluguel;
	private double condominio;
	private int qtdPessoas;
			
	public Aluguel(double aluguel, double condominio, int qtdPessoas) {
		setAluguel(aluguel);
		setCondominio(condominio);
		setQtdPessoas(qtdPessoas);
	}
	
	public void setAluguel(double aluguel) {
		if (aluguel < 0) {
			throw new IllegalArgumentException("O valor nao pode ser negativo");
		}
		this.aluguel = aluguel;
	}

	public double getAluguel() {
		return this.aluguel;
	}

	public void setCondominio(double condominio) {
		if (condominio < 0) {
			throw new IllegalArgumentException("O valor nao pode ser negativo");
		}
		this.condominio = condominio;
	}

	public double getCondominio() {
		return this.condominio;
	}

	public void setQtdPessoas(int qtdPessoas) {
		if (qtdPessoas < 0) {
			throw new IllegalArgumentException("Impossível ter um numero negativo de pessoas");
		} else if (qtdPessoas < 1) {
			throw new IllegalArgumentException("Deve haver ao menos você");
		}
		this.qtdPessoas = qtdPessoas;
	}

	public int getQtdPessoas() {
		return this.qtdPessoas;
	}

	public double calculoAluguel() {
		return (getAluguel() + getCondominio()) / getQtdPessoas();
	}

}
