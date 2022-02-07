import java.util.Arrays;
import java.util.List;

public class CamelCaseToString {
	private static final String HAVE_SPACE = ".*([ \\t]).*";
	private static final String HAVE_SPECIAL_CHAR = "(\\w)*";
	private static final String START_WITH_NUMBER = "(^[0-9]).*";
	private static final String SEPARATE_WORDS = "(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])";


	public static List<String> converterCamelCase(String original){
		if(original.matches(HAVE_SPACE)) {
			throw new HaveSpaceExcepetion("A palavra informada não pode conter espaço");
		}
		if(!original.matches(HAVE_SPECIAL_CHAR)) {
			throw new HaveSpecialCharExcepetion("A palavra não pode conter caracter especial.");
		}
		if(original.matches(START_WITH_NUMBER)) {
			throw new StartWithNumberExcepetion("A palavra não pode ser iniciada com número");
		}
		
		List<String> wordsList = splitWords(original);
		return makeAllWordsLowerCase(wordsList);
	}	
	
	private static List<String> splitWords(String original) {
		String words[] = original.split(SEPARATE_WORDS);
		return Arrays.asList(words);
	}

	private static List<String> makeAllWordsLowerCase(List<String> words) {
		words.replaceAll(word -> isUpperWord(word) ? word : word.toLowerCase());
		return words;
	}

	private static boolean isLowerWord(String original) {
		return original.toLowerCase() == original;
	}

	private static boolean isUpperWord(String original) {
		return original.toUpperCase() == original;
	}
}
