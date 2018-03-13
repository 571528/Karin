package no.hib.dat102.datafirma;

import java.util.Iterator;
import java.util.Scanner;

public class Meny {
	private Datakontakt dk;

	public Meny(Datakontakt dk) {
		this.dk = dk;
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1: Legg til nytt medlem.\n" + "2: Skriv ut liste over medlemmenes hobbyer\n"
					+ "3: Skriv ut liste over par.\n" + "For å avslutte, skriv hva som helst annet...");
			String input = sc.nextLine();
			
			if (input.equals("1")) {
				Medlem m = Tekstgrensesnitt.lesMedlem();
				boolean ferdig = false;
				while (!ferdig) {
					System.out.println("4: For å legge til hobby for dette medlemmet\n"
							+ "For å avslutte, skriv hva som helst annet...");
					String input2 = sc.nextLine();
					if (input2.equals("4")) {
						System.out.println("Skriv inn en hobby");
						Hobby hobby = new Hobby(sc.nextLine());
						m.leggTilHobby(hobby);

					} else {
						ferdig = true;
					}
				}
				dk.leggTilMedlem(m);
			} else if (input.equals("2")) {
				Iterator<Medlem> i = dk.oppramser();
				while (i.hasNext()) {
					Tekstgrensesnitt.skrivHobbyListe(i.next());
				}
			} else if (input.equals("3")) {
				dk.finnPar();
				Tekstgrensesnitt.skrivParListe(dk);
			} else {
				run = false;
			}
		}
		sc.close();
	}
}
