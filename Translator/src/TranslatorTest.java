import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TranslatorTest {
	
	private Translator translator;
	
	@BeforeEach
	public void createTranslator() {
		translator = new Translator();
	}

	@Test
	public void translatorWithoutWords() {
		assertTrue(translator.isEmpty());
	}

	@Test
	public void oneTranslation() {
		translator.addTranslation("bom", "good");
		
		assertFalse(translator.isEmpty());
		assertEquals("good", translator.translate("bom"));
	}
	
	@Test
	public void twoTranslations() {
		translator.addTranslation("bom", "good");
		translator.addTranslation("mau", "bad");
		
		assertEquals("good", translator.translate("bom"));
		assertEquals("bad", translator.translate("mau"));		
	}
	
	@Test
	public void twoTranslationsSameWord() {
		translator.addTranslation("bom", "good");
		translator.addTranslation("bom", "nice");
		
		assertEquals("good, nice", translator.translate("bom"));
	}
	
	@Test
	public void translatePhrase() {
		translator.addTranslation("guerra", "war");
		translator.addTranslation("é", "is");
		translator.addTranslation("ruim", "bad");
		
		assertEquals("war is bad", translator.translatePhrase("guerra é ruim"));
	}
	
	@Test
	public void translatePhaseWithSameWords() {
		translator.addTranslation("paz", "peace");
		translator.addTranslation("é", "is");
		translator.addTranslation("bom", "good");
		translator.addTranslation("bom", "nice");
		
		assertEquals("peace is good", translator.translatePhrase("paz é bom"));
	}
}
