import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		boolean senhaValida = validaSenha(senha);
		if(senhaValida) {
			if(tipo.equals("Gerente")) {
				usuario = new Gerente(nome, matricula, senha);
				System.out.println("Gerente cadastrado com sucesso!");
			}else {
				usuario = new Vendedor(nome, matricula, senha);
				System.out.println("Vendedor cadastrado com sucesso!");
			}
			users.add(usuario);
			return usuario;
		} else {
			System.out.println("Tente novamente");
			return null;
		}
		
		
	}
	
	public boolean validaSenha(String senha) {
		Pattern senhaPattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$");
		Matcher matcher = senhaPattern.matcher(senha);
		
		if(matcher.find()) {
			return true;
		}
		return false;
		
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
