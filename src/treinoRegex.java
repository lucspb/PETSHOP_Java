import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class treinoRegex {
	public static void main(String [] args) {
		
		// expressao d para 0-9 para corresponder o numero (99) 99999-9999;
		Pattern phoneNumber = Pattern.compile("\\(\\d{2}\\) 9\\d{4}-\\d{4}");
		
		Matcher matcherPhone = phoneNumber.matcher("Ligue para (83) 92343-3425 para falar com um atendente");
		
		if(matcherPhone.find()) {
			System.out.println("encontrando o numero do telefone " + matcherPhone.group());
		} else {
			System.out.println("Não foi possível encontrar o numero do telefone");
		}
		
		//expressao para cpf 
		Pattern cpfNumber = Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
		
		Matcher matcherCpf = cpfNumber.matcher("CPF é 111.222.333-44");
		
		if(matcherCpf.find()) {
			System.out.println("encontrando o cpf " + matcherCpf.group());
		} else {
			System.out.println("Não foi possível encontrar o numero do cpf");
		}
	}
}
