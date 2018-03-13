package no.hib.dat102.datafirma;

public class DatakontaktKlient {

	public static void main(String[] args) {

		Datakontakt dk = new Datakontakt(4);
		Meny meny = new Meny(dk);
		meny.start();

	}
}
