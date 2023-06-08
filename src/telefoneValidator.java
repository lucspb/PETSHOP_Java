import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class telefoneValidator {

	private static final String REGEX_TELEFONE = "^\\(\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$";
	
	public static boolean validarTelefone(String telefone) {
		Pattern patternTel = Pattern.compile(REGEX_TELEFONE);
		Matcher matcherTel = patternTel.matcher(telefone);
		return matcherTel.matches();
	}
	
	public static void main(String[] args) {
		String tel1 = "(83) 11111-1111";
		String tel2 = "11222222222";
		String tel3 = "(21)555555555";
		String tel4 = "(82)3333-3333";
		
		System.out.println(tel1 + " é válido? " + validarTelefone(tel1));
		System.out.println(tel2 + " é válido? " + validarTelefone(tel2));
		System.out.println(tel3 + " é válido? " + validarTelefone(tel3));
		System.out.println(tel4 + " é válido? " + validarTelefone(tel4));
	}

}
