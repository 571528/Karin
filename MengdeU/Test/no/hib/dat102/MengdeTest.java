package no.hib.dat102;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.adt.MengdeADT;

public abstract class MengdeTest {

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> m3;

	private final Integer e1 = 1;
	private final Integer e2 = 2;
	private final Integer e3 = 3;
	private final Integer e4 = 4;
	private final Integer e5 = 5;
	private final Integer e6 = 6;
	
	public abstract MengdeADT<Integer> reset();
	
	@Before
	public void setup() {
		m1 = reset();
		m2 = reset();
		m3 = reset();
		assertTrue(m1.equals(m2));
	}
	
	@Test
	public void testUnion() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		
		m3.leggTil(e1);
		m3.leggTil(e2);
		m3.leggTil(e3);
		m3.leggTil(e4);
		m3.leggTil(e5);
		m3.leggTil(e6);
		
		assertTrue(m1.union(m2).equals(m3));
	}
	@Test
	public void testSnitt() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		
		m2.leggTil(e2);
		m2.leggTil(e4);
		m2.leggTil(e6);
		
		m3.leggTil(e2);
		
		assertTrue(m1.snitt(m2).equals(m3));
	}
	@Test
	public void testDifferens() {
		m1.leggTil(e1);
		m1.leggTil(e3);
		m1.leggTil(e5);
		
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		m3.leggTil(e1);
		m3.leggTil(e5);
		
		assertTrue(m1.differens(m2).equals(m3));
	}
}
