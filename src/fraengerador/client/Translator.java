package fraengerador.client;

import java.util.ArrayList;
import java.util.Collections;

public class Translator {
	private Dictionary dictionary = new Dictionary();

	public String translate(final String text) {
		final StringBuffer translation = new StringBuffer();
		// \b breaks in browser but works during testing with commas.
		// \s works in browser but commas/periods are not supported.
		final String[] words = text.split("\\s+");
		
		for (final String word : words) {
			if (word.isEmpty()) {
				continue;
			}

			if (dictionary.contains(word)) {
				translation.append(dictionary.translationFor(word));
			} else {
				translation.append(word);
			}
			
			translation.append(" ");
		}
		return translation.toString().trim();
	}
	
	public String getDictionary() {
		StringBuffer d = new StringBuffer();
		for (final String word: dictionary.asSortedList()) {
			d.append(word);
			d.append(" ");
		}
		
		return d.toString().trim();
	}

	class Dictionary {
		private final String[] words = new String[] {
				"Meerrettich", "Grier",
				"Kartoffeln", "Grumbarn",
				"Montag", "Mandi",
				"Rotkohl", "Blaugraud",
				"das", "des",
				"ist", "is",
				"Tuch", "Düchli",
				"Abend", "Obend",
				"Wetter", "Wedder",
				"Jacke", "Jäckle", 
				"Fleisch", "Flääsch",
				
				"Brötchen", "Weggli",
				"wir", "ma",
				"gegessen", "gassa",
				"haben", "ham",
				"sind", "sin",
				"schon", "scho",
				"auch", "a",
				"etwas", "e weng",
				"weich", "lätschert",
				"total", "dodal",
				"mal", "ma",
				"ist es", "isses",
				"schön", "schüa",
				"scheitern", "scheiter",
				"Zeuzleben", "Zeuzlum",
				
				"Alkoholiker","Lebaschrumbf",
				"ältere Dame","Schbinådwachdl",
				"Amerikaner","Dsubfa",
				"ärgern","ansdrädsn",
				"Belohnung","Guudsala",
				"Bier", "Sajdla",
				"Blumenkohl","Gheagheel",
				"bohren","bubbln",
				"Brillenetui","Brillnedwi",
				"quatschen","waafm",
				"reden", "waafm",
				"Ei","Gaggala",
				"Eier","Gaggala",
				"Eichhörnchen","Achala",
				"Einwohner von Fürth","Blousoasch",
				"Einwohner Nürnbergs","Bflasdaschajssa",
				"Einwohner Österreichs","Schluchdnschajssa",
				"Einwohner","Brajss",
				"Ersatzmann","Brundsghaddla",
				"fein zurechtgemacht","aufbredsld",
				"Filzlaus","Saggrads",
				"Flasche","Boddl",
				"Penner","Schnarchdsabfm",
				"flatulieren","an Schiis foan lassn",
				"furzen","an foan lassn",
				"Frau","Wajb",
				"Fürth","Fädd",
				"Gehsteig","Droddwaa",
				"Gerümpel","Graffl",
				"Glas","Gloos",
				"Griesgram","Mufflsoggng",
				"großer Mann","Laggl",
				"Hase","Hoos",
				"Hasen","Hoosn",
				"Hasenzüchter","Hoosngoogara",
				"Hose","Husn",
				"Idiot","Debb",
				"Vollidiot","Debbmhaufm",
				"Jauche","Odl", // (bitte nicht verwechseln mit „Ådl“ = Bezeichnung für Adlige)"
				"Kanalarbeiter","Dullnraama",
				"Kanaldeckel","Dulln",
				"Kartoffel","Bodaggng",
				"Kleinkind","Dswädschga", // (auf keinen Fall  mit „Dswädschgala“ zu verwechseln!) Waggala (auch als Kosewort)"
				"Kloß","Glees",
				"Klöße", "Glees",
				"Konserven","Biggsnfudda",
				"Krawall","Gwärch", // (findet auch Verwendung als Bezeichnung für übermäßige Unordnung)"
				"Unordnung", "Gwärch",
				"Krempel","Gruusch",
				"Mann","Moo",
				"Penis","Schniedala",// Reproduktionsorgan nicht in Betriebsbereitschaft","Schnärpfala",
				"Mund","Waffl",
				"Nabel","Gilch",
				"Nachschwärmer","Rummdsuuch",
				"kalte Mahlzeit","ghalde Druudschala",
				"warme Mahlzeit","Warme Naundschala", // un ghalde Druudschala",
				"Nürnberg","Nämmbärch",
				"Fußballverein","Gleebläddla",
				"Pilz","Bfiffä",
				"Pole","Bolagg",
				"putzig","butzig",
				"Ratte","Rads",
				"Ratten","Radsn",
				"Regenschirm","Barasoll",
				"Arschloch","Oaschluuch grummbuads",
				"Scherz","Gschbässla",
				"Schnaps","Schdhambala",
				"Schluckauf","Hädscha",
				"Schmutzfink","Dreegbambl",
				"Schubkarre","Robbän",
				"rennen","fedsn",
				"Spargeltarzan","Grischbhala",
				"Sputum","Ruuds",
				// "Substanz, schleimig-schmierige","Lebberi"
				"Suppositorium","Dsäbfla",
				"Tag","Dooch",
				"Tannenzapfen","Budselküh", // Dsiidsn (form- und größenabhängig)"
				"Teig","Daach",
				"Tippelbruder","Sandla",
				"Glas","Sajdla",
				"urinieren","brundsn",
				"Walderdbeere","Rouwala",
				"Wäscheklammern","Dswigga",
				"weibliches Reproduktionsorgan","Bumbl", // (ugs.; dient bisweilen auch zur Bezeichnung der Schelln-As) Dswädschgala (ugs.; nur das Organ)"
				"Herr","Masda", // (grundsätzlich kombiniert mit der 2. Person, Präsens, Indikativ)"
				"Wie bitte?","Was willsdh?", // oder Wås mächasd?"
				"Wurst","Woschd",
				"Zahnarzt","Dsohdogda",
				"Zugereister","Najgschmäggda",
				
				"Daheim", "Dahöm",
				"daheim", "dahöm",
				"gefreut", "gfrreud"
		};
		
		public ArrayList<String> asSortedList() {
			final ArrayList<String> list = new ArrayList<String>();
			for (int i=0; i<words.length; i+=2) {
				list.add(words[i]);
			}
			Collections.sort(list);
			return list;
		}
		
		public boolean contains(final String needle) {
			for (int i = 0; i < words.length; i += 2) {
				if (needle.equals(words[i])) {
					return true;
				}
			}
			return false;
		}

		public String translationFor(final String needle) {
			for (int i = 0; i < words.length; i += 2) {
				if (needle.equals(words[i])) {
					return words[i + 1];
				}
			}
			throw new RuntimeException("Word not found: " + needle);
		}
	}

}
