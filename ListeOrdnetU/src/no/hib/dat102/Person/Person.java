package no.hib.dat102.Person;

public class Person implements Comparable<Person> {
	private String fornavn;
	private String etternavn;
	private int fodselsaar;

	public Person(String fornavn, String etternavn, int aar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		fodselsaar = aar;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	public void setFodselsaar(int aar) {
		this.fodselsaar = aar;
	}

	public String toString() {
		return fodselsaar + "\t" + etternavn + ", " + fornavn;
	}

	@Override
	public int compareTo(Person denAndre) {
		int resultat = 0;
		if (fodselsaar < denAndre.getFodselsaar()) {
			resultat = -1;
		} else if (fodselsaar == denAndre.getFodselsaar()) {
			if (etternavn.compareTo(denAndre.getEtternavn()) < 0) {
				resultat = -1;
			} else if (etternavn.compareTo(denAndre.getEtternavn()) > 0) {
				resultat = 1;
			} else {
				if (fornavn.compareTo(denAndre.getFornavn()) < 0) {
					resultat = -1;
				} else if (fornavn.compareTo(denAndre.getFornavn()) > 0) {
					resultat = 1;
				}
			}
		} else {
			resultat = 1;
		}
		return resultat;
	}
}
