public final class Login {
	
	private static Login instance;
	private static Menus menus = new Menus();
	private static Usuarios usuarios = Usuarios.getInstance();
	private Usuario usuarioLogado;
		
	public void exibeLogin() {
		while(true) {
			menus.exibeBoasVindas();
			String matricula = menus.getDadoMenu("Matricula");
			String senha = menus.getDadoMenu("Senha");
			boolean retornoLogin = this.executaLogin(matricula, senha);
			if(retornoLogin) {
				if(this.usuarioLogado.getTipo().equals("Gerente")) {
					menus.menuGerente();
				}else if(this.usuarioLogado.getTipo().equals("Vendedor")) {
					menus.menuVendedor();
				}
			}
		}
	}
	
	public boolean executaLogin(String matricula, String senha) {
		
		Usuario usuario = usuarios.checkCredentials(matricula, senha);
		
		if(usuario != null) {
			this.usuarioLogado = usuario;
			System.out.println("Login realizado com sucesso!!!");
			return true;
		}
		System.out.println("Credenciais inválidas");
		return false;
		
	}

	public Usuario getUserLogado() {
		return usuarioLogado;
	}

	public void setUserLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public static Login getInstance() {
        if (instance == null) {
        	instance = new Login();
        }
        return instance;
    }
	
	
}
