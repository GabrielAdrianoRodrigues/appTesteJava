package teste;

public class Curso {
	private String nome;
	private double valor;
	private int desconto;
	
	public Curso(String nome, double valor, int desconto) {
		setNome(nome);
		setValor(valor);
		setDesconto(desconto);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor não pode ser negativo");
		}
		this.valor = valor;
	}
	
	public int getDesconto() {
		return desconto;
	}
	
	public void setDesconto(int desconto) {
		if(desconto < 0) {
			throw new IllegalArgumentException("O desconto não pode ser negativo");
		}
		this.desconto = desconto;
	}
	
	public double valorAPagar() {
		if (desconto == 0) {
			return getValor();
		}
		return (getValor() * getDesconto())/ 100;
	}
	

	
}
