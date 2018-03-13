package no.hib.dat102.tabell;

import no.hib.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[bak - 1];
			liste[bak - 1] = null;
			bak--;
		}
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[0];
			bak--;
			for (int i = 0; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		return resultat;
	}

	@Override
	public T foerste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[bak - 1];
		}
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (bak == liste.length) {
				utvid();
			}
		}
		int i = 0;
		while (i < bak && element.compareTo(liste[i]) > 0) {
			i++;
		}
		for (int j = bak; j > i; j--) {
			liste[j] = liste[j - 1];
		}
		liste[i] = element;
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int index = finn(element);
		T svar = null;
		if (index >= 0 && index < bak) {
			svar = liste[index];
			for (int i = index; i < bak - 1; i++) {
				liste[i] = liste[i + 1];
			}
			bak--;
		}
		return svar;
	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		boolean funnet = false;
			while (!funnet && i < bak) {
				if (el == liste[i]) {
					resultat = i;
					funnet = true;
				} else {
					i++;
				}
			}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
