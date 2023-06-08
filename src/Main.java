import java.util.Arrays;

public class Main {

	static Login login = Login.getInstance();
	static Usuarios users = Usuarios.getInstance();
	
	public static void main(String[] args) {
		users.adicionaUsuario("Lucas", "luc123", "123", "Gerente");
		login.exibeLogin();
	}

}
