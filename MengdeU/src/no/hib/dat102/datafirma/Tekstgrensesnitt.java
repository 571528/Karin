package no.hib.dat102.datafirma;

import java.util.Scanner;

public class Tekstgrensesnitt {

	public static final Scanner sc = new Scanner(System.in);

	public static Medlem lesMedlem() {

		System.out.println("Navn til medlem du vil legge til: ");
		String navn = sc.nextLine();
		return new Medlem(navn);
	}

	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Hobbyer til " + medlem.getNavn() + ": ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		int antallPar = 0;
		System.out.println("PARNAVN\t\t\tHOBBYER");
		for (int medlemsIndex = 0; medlemsIndex < arkiv.getAntallMedlemmer(); medlemsIndex++) {
			int partnerIndex = arkiv.getMedlemsTabell()[medlemsIndex].getStatusIndeks();
			if (partnerIndex != -1 && partnerIndex > medlemsIndex) {
				antallPar++;
				System.out.print(arkiv.getMedlemsTabell()[partnerIndex].getNavn() + " og "
						+ arkiv.getMedlemsTabell()[medlemsIndex].getNavn() + "\t\t"
						+ arkiv.getMedlemsTabell()[partnerIndex].getHobbyer());
				int hobbyAntall = arkiv.getMedlemsTabell()[partnerIndex].getHobbyer().antall();
				System.out.println("\tAntall hobbyer er: " + hobbyAntall);

			}
		}
		System.out.println("Antall par funnet er: " + antallPar);

	}
}