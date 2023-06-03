import java.util.Scanner;

public final class Login {
	
	private static Login instance;
	private Usuario userLogado;
	public Usuarios users = Usuarios.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void exibeLogin() {
		while(true) {
			System.out.println("============================");
			System.out.println("+   BEM VINDO AO PETSHOP   +");
			System.out.println("============================");
			System.out.println("+ Matrícula ================");
			String matricula = scan.next();
			System.out.println("+ Senha ====================");
			String senha = scan.next();
			boolean isLogged = executaLogin(matricula, senha);
			if(isLogged) {
				if(this.userLogado.getTipo().equals("Gerente")) {
					Gerente gerente = (Gerente) getUserLogado();
					while(true) {
						System.out.println("=============================");
						System.out.println("+++   Escolha uma opção   +++");
						System.out.println("=============================");
						System.out.println("+ 1 - Cadastra vemdedor ====+");
						System.out.println("+ 2 - Remove vendedor ======+");
						System.out.println("+ 3 - Logout ===============+");
						System.out.println("=============================");
						String opcao = scan.next();
						if(opcao.equals("1")) {
							System.out.println("+ Nome -----------------------+");
							String nomeCadastro = scan.next();
							System.out.println("+ Matricula ------------------+");
							String matriculaCadastro = scan.next();
							System.out.println("+ Senha ------------------+");
							String senhaCadastro = scan.next();
							gerente.cadastraVendedor(nomeCadastro, matriculaCadastro, senhaCadastro);
						}else if(opcao.equals("2")) {
							System.out.println("+ Matricula ------------------+");
							matricula = scan.next();
							gerente.removeUsuario(matricula);
						} else if(opcao.equals("3")) {
							setUserLogado(null);
							break;
						} else {
							System.out.println("Opção inválida. Digite uma nova opção");
						}
					}
				} else if(this.userLogado.getTipo().equals("Vendedor")) {
					while(true) {
						System.out.println("=========================");
						System.out.println("+== Escolha uma opção ==+");
						System.out.println("=========================");
						System.out.println("+ 1 - Logout ===========+");
						System.out.println("=========================");
						String opcao = scan.next();
						if(opcao.equals("1")) {
							setUserLogado(null);
							break;
						}else {
							System.out.println("Opção inválida. Digite uma nova opção");
						}
					}
				}
			}
		}
	}
	
	public boolean executaLogin(String matricula, String senha) {
		Usuario user = users.checkCredentials(matricula, senha);
		if(user != null) {
			this.userLogado = user;
			System.out.println("Login efetuado com sucesso!");
			return true;
		}
		System.out.println("Matrícula/Senha incorretas");
		return false;
	}
	
	public Usuario getUserLogado() {
		return userLogado;
	}

	public void setUserLogado(Usuario userLogado) {
		this.userLogado = userLogado;
	}

	public static Login getInstance() {
		if(instance == null) {
			instance = new Login();
		}
		return instance;
	}
}
