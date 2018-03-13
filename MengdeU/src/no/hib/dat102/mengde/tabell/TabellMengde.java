package no.hib.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hib.dat102.mengde.adt.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) { // Søker etter og fjerner element.Retur med null ved ikke-funn
		boolean funnet = false;
		T svar = null;
		int i = 0;
		while (!funnet && i<antall) {
			if (tab[i].equals(element)) {
				antall--;
				svar = tab[i];
				tab[i] = tab[antall];
				tab[antall] = null;
				funnet = true;
			} 
			i++;
		}
		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();  
		Iterator<T> teller2 = this.oppramser();
		T element;

		while(teller2.hasNext()) {
			((TabellMengde<T>)begge).settInn(teller2.next());
		}
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			element = teller.next();
			if(!inneholder(element)){
				((TabellMengde<T>)begge).settInn(element);
			}
		}
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element= null;
		Iterator<T> teller = m2.oppramser();

		if(m2.equals(this)) {
			((TabellMengde<T>)snittM).leggTilAlle(this); 
		} else {
			while(teller.hasNext()) {
				element = teller.next();
				if (this.inneholder(element)) {
					((TabellMengde<T>)snittM).settInn(element); 
				}
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element = null;
		Iterator<T> teller = this.oppramser();

		while(teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>)differensM).settInn(element); 
			}
		}
		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element = null;
		if (this.antall() == m2.antall()) {
			Iterator<T> teller = m2.oppramser(); 
			while (likeMengder && teller.hasNext()) {
				element = teller.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	public String toString() {
		String resultat = "";
		for (int i = 0; i<antall; i++) {
			resultat += tab[i].toString() + "\t";     
		}
		return resultat;
	}	
}// class
