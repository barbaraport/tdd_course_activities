import java.util.HashMap;
import java.util.Map;

public class Translator {
	
	private Map<String, String> translations = new HashMap<String, String>();

	public boolean isEmpty() {
		return this.translations.isEmpty();
	}

	public void addTranslation(String word, String translation) {
		if (this.translations.containsKey(word)) {
			translation = this.translate(word) + ", " + translation;
		}
		
		this.translations.put(word, translation);
	}

	public String translate(String word) {
		return this.translations.get(word);
	}

	public String translatePhrase(String phrase) {
		String[] words = phrase.split(" ");
		String translatedPhrase = "";
		
		for (String word : words) {
			String translated = firstTranslation(word);
			
			translatedPhrase += " " + translated;
		}
		
		return translatedPhrase.trim();
	}

	private String firstTranslation(String word) {
		String translated = this.translate(word);
		
		if(translated.contains(",")) {
			translated = translated.substring(0, translated.indexOf(","));
		}
		
		return translated;
	}

}
