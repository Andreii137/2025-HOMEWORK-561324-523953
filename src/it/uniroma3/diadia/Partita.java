package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 5;

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private boolean finita;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente=labirinto.getStanzaInizale();
		this.giocatore= new Giocatore(CFU_INIZIALI);
		this.finita = false;
	}

	public Stanza getStanzaFinale() {
		return labirinto.getStanzaFinale();
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public String toString() {
		return this.getStanzaCorrente()+"\nCfu="+this.giocatore.getCfu();
	}
}
