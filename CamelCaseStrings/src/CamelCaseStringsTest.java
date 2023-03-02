import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidAlgorithmParameterException;

import org.junit.jupiter.api.Test;

class CamelCaseStringsTest {

	@Test
	void simpleString() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("nome");

		String value = ccs.getStrings()[0];
		assertEquals("nome", value);
	}

	@Test
	void firstLetterUppercaseString() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("Nome");
				
		String value = ccs.getStrings()[0];
		assertEquals("nome", value);
	}
	
	@Test
	void separateWords() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("nomeComposto");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"nome", "composto"}, values);
	}
	
	@Test
	void separateWordsCapitalCamelCase() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("NomeComposto");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"nome", "composto"}, values);
	}
	
	@Test
	void separateWordCPF() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("CPF");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"CPF"}, values);
	}
	
	@Test
	void separateWordWithCPF() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("numeroCPF");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"numero", "CPF"}, values);
	}
	
	@Test
	void separateWordCamelCaseWithCPF() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("numeroCPFContribuinte");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"numero", "CPF", "contribuinte"}, values);
	}
	
	@Test
	void separateWordWithNumbers() throws InvalidAlgorithmParameterException {
		CamelCaseStrings ccs = new CamelCaseStrings("recupera10Primeiros");
				
		String[] values = ccs.getStrings();
		assertArrayEquals(new String[]{"recupera", "10", "primeiros"}, values);
	}
	
	@Test
	void expectExceptionFromInitialNumber() throws InvalidAlgorithmParameterException {
	    Exception exception = assertThrows(InvalidAlgorithmParameterException.class, () -> {
			CamelCaseStrings ccs = new CamelCaseStrings("10Primeiros");
						
			ccs.getStrings();
	    });
	    
	    String expectedMessage = "Strings should not start with a number";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void expectExceptionFromSpecialCharacter() throws InvalidAlgorithmParameterException {
	    Exception exception = assertThrows(InvalidAlgorithmParameterException.class, () -> {
			CamelCaseStrings ccs = new CamelCaseStrings("nome#Composto");
						
			ccs.getStrings();
	    });
	    
	    String expectedMessage = "Strings should not have a special character";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
}