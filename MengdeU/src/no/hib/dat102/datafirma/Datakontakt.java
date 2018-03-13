package no.hib.dat102.datafirma;

import java.util.Iterator;
import no.hib.dat102.mengde.tabell.TabellIterator;

public class Datakontakt {
	private Medlem[] medlemsTabell;
	private int antallMedlemmer;

	public Datakontakt(int str) {
		medlemsTabell = new Medlem[str];
		antallMedlemmer = 0;
	}

	public Medlem[] getMedlemsTabell() {
		return medlemsTabell;
	}

	public void setMedlemsTabell(Medlem[] medlemsTabell) {
		this.medlemsTabell = medlemsTabell;
	}

	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void setAntallMedlemmer(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}

	public void leggTilMedlem(Medlem person) {
		if (antallMedlemmer == medlemsTabell.length) {
			utvidKapasitet();
		}
		medlemsTabell[antallMedlemmer] = person;
		antallMedlemmer++;
	}

	public void utvidKapasitet() {
		Medlem[] hjelpetabell = (Medlem[]) (new Object[2 * medlemsTabell.length]);
		for (int i = 0; i < medlemsTabell.length; i++) {
			hjelpetabell[i] = medlemsTabell[i];
		}
		medlemsTabell = hjelpetabell;
	}

	public int finnMedlemsIndeks(Medlem medlemsnavn)  {
		int pos = -1;
		boolean funnet = false;
		int i = 0;
		while(!funnet && i<antallMedlemmer) {
			if(medlemsTabell[i].getNavn().equals(medlemsnavn.getNavn())) {
				pos = i;
				funnet = true;
			}
			i++;
		}
		return pos;
	}

	public int finnPartnerFor(Medlem medlemsnavn) {
		int pos = -1;
		int medlemsIndeks, partnerIndeks;
		medlemsIndeks = finnMedlemsIndeks(medlemsnavn);
		if (medlemsIndeks != -1) {
			for (partnerIndeks = 0; partnerIndeks < antallMedlemmer; partnerIndeks ++) {
				if(medlemsIndeks != partnerIndeks && medlemsTabell[partnerIndeks].getStatusIndeks() == -1 && medlemsTabell[partnerIndeks].passerTil(medlemsnavn)) {
					medlemsTabell[medlemsIndeks].setStatusIndeks(partnerIndeks);
					medlemsTabell[partnerIndeks].setStatusIndeks(medlemsIndeks);
					pos = partnerIndeks;
				}
			}
		}
		return pos;
	}

	public void tilbakestillStausIndeks(Medlem medlemsnavn) {
		boolean funnet = false;
		int i = 0;
		while (!funnet && i<antallMedlemmer) {
			if(medlemsnavn.getStatusIndeks() == medlemsTabell[i].getStatusIndeks() && medlemsTabell[i].getStatusIndeks() != -1){
				medlemsnavn.setStatusIndeks(-1);
				medlemsTabell[i].setStatusIndeks(-1);
				funnet = true;
			} else {
				i++;
			}
		}
	}

	public void finnPar() {
		for(int i = 0; i<antallMedlemmer; i++) {
			finnPartnerFor(medlemsTabell[i]);
		}
	}

	public Iterator<Medlem> oppramser() {
		return new TabellIterator<Medlem>(medlemsTabell, antallMedlemmer);
	}

}
