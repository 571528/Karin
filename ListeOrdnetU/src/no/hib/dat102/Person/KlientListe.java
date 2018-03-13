package no.hib.dat102.Person;

import java.util.Scanner;
import no.hib.dat102.kjedet.KjedetOrdnetListe;
import no.hib.dat102.tabell.TabellOrdnetListe;

public final class KlientListe {

	private KlientListe() {
	}

	public static void main(String[] args) {
		KjedetOrdnetListe<Person> personListe1 = new KjedetOrdnetListe<Person>();
		TabellOrdnetListe<Person> personListe2 = new TabellOrdnetListe<Person>();

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

			personListe1.leggTil(p1 = new Person(navn, etternavn, aar));
			personListe2.leggTil(p1 = new Person(navn, etternavn, aar));

			System.out.print("Oppgi flere navn [J/N]?:");
			svar = scan.nextLine();
		} while (svar.equals("j") || svar.equals("J"));

		System.out.println("\n\nPersoner i stigende alder (Kjedet): ");
		while (personListe1.antall() > 0) {
			System.out.println(personListe1.fjernFoerste().toString());
		}

		System.out.println("\n\nPersoner i stigende alder (Tabell): ");
		while (personListe2.antall() > 0) {
			System.out.println(personListe2.fjernFoerste().toString());
		}
		scan.close();
	}
}
