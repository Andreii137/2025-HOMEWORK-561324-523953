package it.uniromatre.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita partita;
	private Stanza perdente;
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws Exception{
		this.labirinto= new Labirinto();
		this.partita = new Partita();
		this.perdente = new Stanza ("Aula N10");
		
	}
	
	//TEST isFinita
	
	@Test //giusto
	void testNuovaPartitaNON_FINITA() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test //giusto
	void testNuovaPartitaFINITA() {
		partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test //giusto
	void testNuovaPartitaFINITA_QuandoFinitiCFU() {
		partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	//TEST vinta
	
	@Test
	void testNuovaPartitaVINTA() {
		partita.setStanzaCorrente(partita.getStanzaFinale());
		assertTrue(this.partita.vinta());
	}
	
	@Test //giusto
	void testNuovaPartitaPERSA() {
		partita.setStanzaCorrente(perdente);
		assertFalse(this.partita.vinta());
	}
	
	@Test //giusto
	void testNuovaPartitaNON_FINITA_E_POI_VINTA() {
		assertFalse(this.partita.isFinita());
		partita.setStanzaCorrente(partita.getStanzaFinale());
		assertTrue(this.partita.vinta());
	}


}
