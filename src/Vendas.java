import java.util.ArrayList;
import java.util.List;

public final class Vendas {
	
	private static Vendas instance;
	List<Venda> vendas;
	
	public Vendas() {
		this.vendas = new ArrayList<>();
	}
	
	
	public void executaVenda(double valor, String formaPagamento, String matricula) {
		Venda venda1 = new Venda(valor, formaPagamento, matricula);
		vendas.add(venda1);
	}
	
	public void gerarRelatorio() {
		for(int i = 0; i < vendas.size(); i++) {
			Venda venda = vendas.get(i);
			System.out.println((i+1) + "- Matrícula: " + venda.getMatricula() + ". Valor: " + venda.getValor() + ". Forma de Pagamento: " + venda.getFormaPagamento());
		}
	}
	
	public void gerarRelatorioIndividual(String matricula) {
		for(int i = 0; i < vendas.size(); i++) {
			Venda venda = vendas.get(i);
			if(vendas.get(i).getMatricula().equals(matricula)){				
				System.out.println((i+1) + "- Matrícula: " + venda.getMatricula() + ". Valor: " + venda.getValor() + ". Forma de Pagamento: " + venda.getFormaPagamento());
			}
		}
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public static Vendas getInstance() {
		if(instance == null) {
			instance = new Vendas();
		}
		return instance;
	}
}
