import java.util.ArrayList;
import java.util.List;

public final class Usuarios {
	private static Usuarios instance;
	private List<Usuario> usuarios; 
	
	public Usuarios() {
		this.usuarios = new ArrayList<>();
		Usuario user1 = new Usuario("Lucas", "123", "senha1", "Gerente");
		usuarios.add(user1);
	}
	
	public Usuario adicionaUsuario(String nome, String matricula, String senha, String tipo) {
		Usuario user = new Usuario(nome, matricula, senha, tipo);
		usuarios.add(user);
		System.out.println("Usuário cadastrado com sucesso!");
		return user;
	}
	
	public int indexOf(String matricula) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1;
	}
	
	public void removeUsuario(String matricula) {
		int index = this.indexOf(matricula);
		if(index != -1) {
			usuarios.remove(index);
			System.out.println("Usuário removido com sucesso!");
		}else {
			System.out.println("Nenhum usuário encontrado");
		}
	}
	
	public List<Usuario> listarUsuarios(){
		return this.usuarios;
	}
	
	public static Usuarios getInstance() {
		if(instance == null) {
			instance = new Usuarios();
		}
		return instance;
	}
	
	public Usuario checkCredentials(String matricula, String senha) {
		for(int i = 0; i < usuarios.size(); i++){
			if(usuarios.get(i).getMatricula().equals(matricula)) {
				if(usuarios.get(i).getSenha().equals(senha)) {
					return usuarios.get(i);
				}
			}
		}
		return null;
	}
}
