import java.util.Scanner;

public final class Login {
	
	private static Login instance;
	private Usuario userLogado;
	public Usuarios usuarios = Usuarios.getInstance();
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
			executaLogin(matricula, senha);
		}
	}
	
	public boolean executaLogin(String matricula, String senha) {
		Usuario usuario = usuarios.checkCredentials(matricula, senha);
		if(usuario != null) {
			this.userLogado = usuario;
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
