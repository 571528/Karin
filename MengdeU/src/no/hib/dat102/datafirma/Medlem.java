package no.hib.dat102.datafirma;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private String navn;     
	private MengdeADT<Hobby> hobbyer;     
	private int statusIndeks;

	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndeks = -1;
	}

	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}


	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	
	public boolean passerTil(Medlem medlem2) {
		return this.getHobbyer().equals(medlem2.getHobbyer());
	}

	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}

	public void fjernHobby(Hobby hobby) {
		hobbyer.fjern(hobby);
	}

	public String toString() {
		return "Navn: " + navn + ", Hobbyer: " + hobbyer + ", Statusindeks: " + statusIndeks + "\n";
	}
}
