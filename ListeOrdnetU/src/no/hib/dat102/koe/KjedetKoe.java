package no.hib.dat102.koe;

import no.hib.dat102.adt.KoeADT;
import no.hib.dat102.kjedet.LinearNode;

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;

	public KjedetKoe() {
		antall = 0;
		front = bak = null;
	}

	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()) {
			front = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		bak = nyNode;
		antall++;
	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		T resultat = null;
		if (!erTom()) {
			resultat = front.getElement();
			front = front.getNeste();
			antall--;
			if (erTom()) {
				bak = null;
			}
		}
		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		T resultat = null;
		if (!erTom()) {
			resultat = front.getElement();
		}
		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

}
