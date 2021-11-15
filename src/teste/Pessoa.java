package teste;

class Pessoa {
	private String nome;
	private double salario;
	private Aluguel aluguel;
	private Curso curso;

	public Pessoa(String nome, double salario) {
		setSalario(salario);
		setNome(nome);
	}
	
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	
	public Aluguel getAluguel() {
		return this.aluguel;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return this.curso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setSalario(double salario) {
		if (salario < 0) {
			throw new IllegalArgumentException("O Sálario não pode ser negativo");
		} 
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}

	public double restanteDoSalario() {
		double salario = getSalario();
		salario -= calculoIRPF();
		salario -= calculoINSS();
		if(this.curso != null) {
			if (this.curso.getDesconto() == 0) {
				salario -= this.curso.getValor();
			} else {
				salario -= (this.curso.getValor()-((this.curso.getValor() * (double)this.curso.getDesconto())/100));
			}
		}
		if (this.aluguel != null) {
			salario -= ((this.aluguel.getAluguel() + this.aluguel.getCondominio())/ (double)this.aluguel.getQtdPessoas());
		}	
		return salario;
	}

	
	public double calculoINSS() {
		double salario = getSalario();
		if (salario <= 1100) {
			salario = (salario * 7.5) /100;
		} else if (salario <= 2203.48) {
			salario = ((((salario - 1100) * 9)) / 100) + 82.50; 
		} else if (salario <= 3305.22) {
			salario = ((((salario - 2203.48) * 12)) / 100) + 82.50 + 99.31; 
		} else if (salario < 6433.57) {
			salario = ((((salario - 3305.22) * 14)) / 100) + 82.50 + 99.31 + 132.20; 
		} else {
			salario = 751.97;
		}
		return salario;
	}
	
	public double calculoIRPF() {
		return (((getSalario() - calculoINSS()) * getPercentualImposto()) / 100) - getParcelaDedutivel();
	}

	public double getPercentualImposto() {
		double salario = getSalario();
		double percentualImposto = 0;
		if (salario > 4664.68) {
			percentualImposto = 27.50;
		} else if (salario > 3751.06) {
			percentualImposto = 22.50;
		} else if (salario > 2826.66) {
			percentualImposto = 15.00;
		} else if (salario > 1903.99) {
			percentualImposto = 7.50;
		}

		return percentualImposto;
	}
	
	public double getParcelaDedutivel() {
		double salario = getSalario();
		double parcelaDedutivel = 0;
		if (salario > 4664.68) {
			parcelaDedutivel = 869.36;
		} else if (salario > 3751.06) {
			parcelaDedutivel = 636.13;
		} else if (salario > 2826.66) {
			parcelaDedutivel = 354.80;
		} else if (salario > 1903.99) {
			parcelaDedutivel = 142.80;
		}

		return parcelaDedutivel;
	}
	
	public String toString() {
		return getNome();
	}

}