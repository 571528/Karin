package no.hib.dat102;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.adt.OrdnetListeADT;

public abstract class OrdnetTest {

	/**
	 * En abstrakt testklasse som tester begge implementasjonene.
	 * 
	 * @author Karin og Helene
	 */
	private OrdnetListeADT<Integer> liste;

	// Test data
	private final Integer e0 = 1;
	private final Integer e1 = 2;
	private final Integer e2 = 3;
	private final Integer e3 = 4;
	private final Integer e4 = 5;
	private final Integer e5 = 6;

	public abstract OrdnetListeADT<Integer> reset();
	
	/**
	 * Opprett en tom liste for hver test.
	 * 
	 * @throws Exception
	 *             exception
	 */
	@Before
	public final void setup() {
		liste = reset();
	}

	/**
	 * Tester om en ny liste er tom.
	 */
	@Test
	public final void nyListeErTom() {
		assertTrue(liste.erTom());
	}

	/**
	 * Tester leggTil og fjern.
	 */
	@Test
	public final void leggTilOgFjern() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));
	}

	/**
	 * Tester ordning ikke-avtagende
	 * 
	 */
	@Test
	public final void viseOrdnetIkkeAvtagende() {
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e5);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);
		assertEquals(e0, liste.fjernFoerste());
		assertEquals(e1, liste.fjernFoerste());
		assertEquals(e2, liste.fjernFoerste());
		assertEquals(e3, liste.fjernFoerste());
		assertEquals(e4, liste.fjernFoerste());
		assertEquals(e5, liste.fjernFoerste());
	}

	@Test
	public final void viseOrdnetIkke�kende() {
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e5);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);
		assertEquals(e5, liste.fjernSiste());
		assertEquals(e4, liste.fjernSiste());
		assertEquals(e3, liste.fjernSiste());
		assertEquals(e2, liste.fjernSiste());
		assertEquals(e1, liste.fjernSiste());
		assertEquals(e0, liste.fjernSiste());
	}

	/**
	 * Tester leggTil og fjern med like verdier.
	 */
	@Test
	public final void leggTilOgfjernMedDuplikater() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
    	liste.leggTil(e3);
		liste.leggTil(e1);
		assertEquals(e0, liste.fjern(e0));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e3, liste.fjern(e3));

	}

	/**
	 * Tester leggTil og inneholder
	 */
	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);

		assertTrue(liste.inneholder(e0));
		assertTrue(liste.inneholder(e1));
		assertTrue(liste.inneholder(e2));
		assertTrue(liste.inneholder(e3));
		assertTrue(liste.inneholder(e4));
		assertFalse(liste.inneholder(e5));

	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());
	}

	/**
	 * Tester om leggTil-fjern p� en tom liste gir en tom liste.
	 */
	@Test
	public final void leggTilFjernErTom() {
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());
	}

	/**
	 * Pr�ver � ta ut et element fra en tom liste.
	 */
	@Test
	public final void fjernFraTomListe() {
		assertNull("Fjerne fra tom liste", liste.fjern(e4));
	}

}
