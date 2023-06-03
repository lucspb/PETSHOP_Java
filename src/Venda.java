
public class Venda {
	
	private String formaPagamento;
	private double valor;
	private String matricula;
	
	public Venda(double valor, String formaPagamento, String matricula) {
		this.formaPagamento = formaPagamento;
		this.valor = valor;
		this.matricula = matricula;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
