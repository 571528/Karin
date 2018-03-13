package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.tabell.TabellStabel;

public class Balansering {
	// Oppgaven ble kjørt med TabellStabel
	TabellStabel<Parentesinfo> stabel = new TabellStabel<Parentesinfo>();

	private boolean passer(char åpent, char lukket) {
		switch (åpent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();
		char c, d;

		for (int i = 0; i < lengde; i++) {
			d = innDataStreng.charAt(i);
			if (d == '(' || d == '[' || d == '{') {
				Parentesinfo parentes = new Parentesinfo();
				parentes.settLinjenr(linjenr);
				parentes.settPosisjon(i);
				parentes.settVenstreparentes(d);
				stabel.push(parentes);
			} else if (d == ')' || d == ']' || d == '}') {
				if (stabel.erTom()) {
					System.out.println("Lukkesymbol " + d + " på linje " + linjenr + " mangler åpnesymbol!");
					System.out.println("Tegn nr " + i + " mangler åpnesymbol!");
				} else {
					Parentesinfo parentes = stabel.pop();
					c = parentes.hentVenstreparentes();
					if (!passer(c, d)) { // Feilmelding 1
						System.out.println("Lukkesymbol " + d + " på linje " + linjenr + ",");
						System.out.println("Tegn nr " + i + " har feil åpnesymbol!");
					}
				}
			}
		}
	}

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try { //Sjekker om hvis filen finnes
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 1;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr);
				linjenr++;
				linje = tekstLeser.readLine();
			}
			if (!stabel.erTom()) {
				Parentesinfo pInfo = stabel.pop();
				char c = pInfo.hentVenstreparentes();
				System.out.println("Stabel har tegn nr " + pInfo.hentPosisjon() + " (" + c + ") " + " på linje " + pInfo.hentLinjenr() + " til overs!" + "");
			}
		} catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}

		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}
	}
}
