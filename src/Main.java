import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Login login = Login.getInstance();
		login.exibeLogin();
		
		/**
		Usuarios usuarios = Usuarios.getInstance();
		Usuario user1 = usuarios.adicionaUsuario("Lucas", "123", "123", "Gerente");
		Usuario user2 = usuarios.adicionaUsuario("Andreza", "321", "321", "Gerente");
		Usuario user3 = usuarios.adicionaUsuario("José", "456", "456", "Vendedor");
		
		System.out.println(user1.getNome());
		System.out.println(user1.getMatricula());
		System.out.println(user2.getMatricula());
		System.out.println(Arrays.toString(usuarios.listarUsuarios().toArray()));
		usuarios.removeUsuario("456");
		System.out.println(Arrays.toString(usuarios.listarUsuarios().toArray()));
		usuarios = Usuarios.getInstance();
		System.out.println(Arrays.toString(usuarios.listarUsuarios().toArray()));
		 * 
		 */
		
		

	}

}
