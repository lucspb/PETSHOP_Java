import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AulaCpf {
	
	private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{3}.\\d{3}.\\d{3}\\-\\d{2}$");

	public static boolean isValid(String cpf) {
		Matcher matcherCpf = CPF_PATTERN.matcher(cpf);
		return matcherCpf.matches();
	}
	
	public static void main(String[] args) {
		  String[] cpfs = {"123.456.789-10", "142357676", "222.333.444-59", "142.357.67623"};
		  for(String cpf : cpfs) {
			  System.out.println(cpf + " é valido? " + isValid(cpf));
		  }
	}

}
