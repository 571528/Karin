package no.hib.dat102;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class KjedetTest extends MengdeTest {

	@Override
	public MengdeADT<Integer> reset() {
		return new KjedetMengde<Integer>();
	}
}
