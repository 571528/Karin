package no.hib.dat102;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TabellTest extends MengdeTest{

	@Override
	public MengdeADT<Integer> reset() {
		return new TabellMengde<Integer>();
	
	}
}
