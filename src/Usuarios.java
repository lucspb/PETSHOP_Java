import java.util.ArrayList;
import java.util.List;

public final class Usuarios {
	private static Usuarios instance;
	private List<Usuario> users; 
	
	public Usuarios() {
		this.users = new ArrayList<>();
		Usuario user1 = new Usuario("Lucas", "luc123", "123", "Gerente");
		users.add(user1);
	}
	
	public Usuario adicionaUsuario(String nome, String matricula, String senha, String tipo) {
		Usuario usuario;
		if(tipo.equals("Gerente")) {
			usuario = new Gerente(nome, matricula, senha);
			System.out.println("Gerente cadastrado com sucesso!");
		}else {
			usuario = new Vendedor(nome, matricula, senha);
			System.out.println("Vendedor cadastrado com sucesso!");
		}
		users.add(usuario);
		return usuario;
	}
	
	public int indexOf(String matricula) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1;
	}
	
	public void removeUsuario(String matricula) {
		int index = this.indexOf(matricula);
		if(index != -1) {
			users.remove(index);
			System.out.println("Usuário removido com sucesso!");
		}else {
			System.out.println("Nenhum usuário encontrado");
		}
	}
	
	public List<Usuario> listarusers(){
		return this.users;
	}
	
	public static Usuarios getInstance() {
		if(instance == null) {
			instance = new Usuarios();
		}
		return instance;
	}
	
	public Usuario checkCredentials(String matricula, String senha) {
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getMatricula().equals(matricula)) {
				if(users.get(i).getSenha().equals(senha)) {
					return users.get(i);
				}
			}
		}
		return null;
	}
}
