package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(int cfu) {
		this.cfu=cfu;
		this.borsa= new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setCfu(int cfu) {
		this.cfu=cfu;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
	
	public boolean aggiungiAttrezzo(Attrezzo attrezzoDaPrendere) {
	    this.borsa.addAttrezzo(attrezzoDaPrendere);
	    return true;
	}

	
	public boolean posaAttrezzo(String attrezzoDaPosare) {
		this.borsa.removeAttrezzo(attrezzoDaPosare);
		return true;
	}


}
