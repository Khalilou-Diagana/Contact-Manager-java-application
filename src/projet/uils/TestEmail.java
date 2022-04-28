package projet.uils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// cette classe permet de verifier si le format d'un email est valable 
public class TestEmail {
	
	private static Pattern pattern;
	private static Matcher matcher;
	 private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 


		public static  boolean validate(String hex) {

			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(hex);
			return matcher.matches();

		}
}
