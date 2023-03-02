import java.security.InvalidAlgorithmParameterException;

public class CamelCaseStrings {
	
	public CamelCaseStrings(String string) {
		this.string = string;
	}

	private String string;
	
	private String[] strings = {};

	public String[] getStrings() throws InvalidAlgorithmParameterException {
		extractWords();
		
		treatUppercaseLetters();
		
		return this.strings;
	}
	
	private void extractWords() throws InvalidAlgorithmParameterException {
		boolean isFirstCharacterANumber = this.isFirstCharacterANumber();
		boolean hasSpecialCharacters = this.hasSpecialCharacters();
		boolean isOnlyUppercase = this.isOnlyUppercase(this.string);
		
		if (hasSpecialCharacters) throw new InvalidAlgorithmParameterException("Strings should not have a special character");
		else if (isFirstCharacterANumber) throw new InvalidAlgorithmParameterException("Strings should not start with a number");
		else if (isOnlyUppercase) {
			String[] words = {string};
			this.strings = words;
		}
		else {
			String[] wordsArray = this.string.split("(?<!(^|[0-9A-Z]))(?=[0-9A-Z])|(?<!^)(?=[0-9A-Z][0-9a-z])");
			this.strings = wordsArray;
		}
	}

	public void treatUppercaseLetters() {	
		for (int i = 0; i < this.strings.length; i++) {
			String word = strings[i];
			
			boolean isOnlyUppercase = this.isOnlyUppercase(word);
			
			if (isOnlyUppercase) this.strings[i] = word;
			else this.strings[i] = word.toLowerCase();
		}
	}
	
	private boolean isFirstCharacterANumber() {
		return Character.isDigit(this.string.charAt(0));
	}
	
	private boolean hasSpecialCharacters() {
		for (char letter : this.string.toCharArray()) {
			if (!Character.isDigit(letter) && !Character.isLetter(letter)) return true;
		}
		
		return false;
	}
	
	private boolean isOnlyUppercase(String word) {
		for (char letter : word.toCharArray()) {
			if (Character.isLowerCase(letter)) return false;
		}
		
		return true;
	}
}
