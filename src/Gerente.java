
public class Gerente extends Usuario implements IUsuario{
	
	public static Vendas vendas = Vendas.getInstance();
	Usuarios users;
	
	
	public Gerente(String nome, String matricula, String senha) {
		super(nome, matricula, senha, "Gerente");
	}
	
	public void cadastraVendedor(String nome, String matricula, String senha) {
		users.adicionaUsuario(nome, matricula, senha, "Gerente");
	}
	
	public void removeUsuario(String matricula) {
		users.removeUsuario(matricula);
	}
	
	@Override
	public void gerarRelatorio() {
		vendas.gerarRelatorio();
	}
	
	public void gerarRelatorioIndividual(String matricula) {
		vendas.gerarRelatorioIndividual(matricula);
	}
}
