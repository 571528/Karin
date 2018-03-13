package no.hib.dat102.koe;

import no.hib.dat102.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T> {
		private final static int STDK = 100;
		private int front, bak, antall; 
		private T[] koe;
		
		public SirkulaerKoe() {
			this(STDK);		
		}

		@SuppressWarnings("unchecked")
		public SirkulaerKoe(int startKapasitet) {
			koe = (T[])(new Object[startKapasitet]);
			front = bak = 0;
			antall = 0;
		}

		public void innKoe(T element) {
			if (antall() == koe.length) {
				utvid();
			}
			koe[bak] = element;
			bak = (bak+1)%koe.length;
			antall++;
		}

		public T utKoe(){
			T resultat = null;
			if(!erTom()) {
				resultat = koe[front];
				front = (front+1)%koe.length;
				antall--;
			}else {
				throw new EmptyCollectionException("sirkulaerkoe");
			}
			return resultat;
		}

		@SuppressWarnings("unchecked")
		private void utvid() {
			T[] hjelpeTabell = (T[]) (new Object[koe.length * 2]);
			
			for (int soek = 0; soek < antall; soek++){
				hjelpeTabell[soek] = koe[front];
				front = (front+1)%koe.length;
			}
			front = 0;
			bak = antall;
			koe = hjelpeTabell;
		}

		public T foerste() throws EmptyCollectionException {
			// TODO Auto-generated method stub
			return koe[front];
		}

		public boolean erTom() {
			// TODO Auto-generated method stub
			return antall == 0;
		}

		public int antall() {
			// TODO Auto-generated method stub
			return antall;
		}
}
