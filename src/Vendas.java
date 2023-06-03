import java.util.ArrayList;
import java.util.List;

public final class Vendas {
	
	private static Vendas instance;
	List<Venda> vendas;
	
	public Vendas() {
		this.vendas = new ArrayList<>();
	}
	
	
	public void executaVendas(double valor, String formaPagamento, String matricula) {
		Venda venda1 = new Venda(valor, formaPagamento, matricula);
		vendas.add(venda1);
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
