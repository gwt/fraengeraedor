package fraengerador.test;

import junit.framework.TestCase;
import fraengerador.client.Translator;

public class TranslatorTest extends TestCase {
	private Translator translator = new Translator();
	
	public void testTranslation() {
		assertEquals("Weg", translator.translate("Brötchen"));
		assertEquals("Die Weg", translator.translate("Die Brötchen"));
	}
		
	public void testTranslationWithCommas() {
		assertEquals("Die Weg, die ma am Mandi gassa ham", translator.translate("Die Brötchen, die wir am Montag gegessen haben"));
	}
	
	public void testGetFullDictionary() {
		System.out.println(translator.getDictionary());
	}
}
