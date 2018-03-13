package no.hib.dat102.Person;

import java.util.Scanner;
import no.hib.dat102.koe.KjedetKoe;
import no.hib.dat102.koe.SirkulaerKoe;

public class KlientKoe {

	private KlientKoe() {
	}

	public static void main(String[] args) {
		SirkulaerKoe<Person> personListe1 = new SirkulaerKoe<Person>();
		KjedetKoe<Person> personListe2 = new KjedetKoe<Person>();

		Person p1;
		Scanner scan = new Scanner(System.in);
		String navn, etternavn, svar;
		int aar;

		do {
			System.out.println("Oppgi Fornavn:");
			navn = scan.nextLine();
			System.out.println("Oppgi Etternavn:");
			etternavn = scan.nextLine();
			System.out.println("Oppgi Fødselsår:");
			aar = scan.nextInt();
			scan.nextLine();

			personListe1.innKoe(p1 = new Person(navn, etternavn, aar));
			personListe2.innKoe(p1 = new Person(navn, etternavn, aar));

			System.out.print("Oppgi flere navn [J/N]?:");
			svar = scan.nextLine();

		} while (svar.equals("j") || svar.equals("J"));

		System.out.println("\n\nPersoner (Sirkulær Kø): ");
		while (personListe1.antall() > 0) {
			System.out.println(personListe1.utKoe().toString());
		}
		System.out.println("\n\nPersoner (Kjedet Kø): ");
		while (personListe2.antall() > 0) {
			System.out.println(personListe2.utKoe().toString());
		}
		scan.close();
	}
}
