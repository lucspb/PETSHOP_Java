
public class Gerente extends Usuario{
	
	public static Vendas vendas = Vendas.getInstance();
	Usuarios users;
	
	
	public Gerente(String nome, String matricula, String senha) {
		super(nome, matricula, senha, "Gerente");
		this.users = Usuarios.getInstance();
	}
	
	public void cadastraVendedor(String nome, String matricula, String senha) {
		users.adicionaUsuario(nome, matricula, senha, "Vendedor");
	}
	
	public void removeUsuario(String matricula) {
		users.removeUsuario(matricula);
	}
	
	public void gerarRelatorioIndividual(String matricula) {
		vendas.gerarRelatorioIndividual(matricula);
	}
}
