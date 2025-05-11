package it.uniroma3.diadia; 

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia{

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(IO console) {
		this.partita = new Partita();
		this.io= console;
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

		System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	private void posa(String attrezzoDaPosare) {
		if(attrezzoDaPosare==null)
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
		else {
			//controllo se l'attrezzo sia presente nella borsa
			Attrezzo attrezzo= this.partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaPosare);

			if(attrezzo==null)
				io.mostraMessaggio("Non hai questo attrezzo nella borsa!");
			else {
				this.partita.getStanzaCorrente().addAttrezzo(attrezzo); //inserisce l'attrezzo nella stanza
				this.partita.getGiocatore().posaAttrezzo(attrezzoDaPosare); //rimuovo l'attrezzo dalla borsa
				io.mostraMessaggio("Hai posato "+ attrezzoDaPosare);
			}
		}
	}

	private void prendi(String attrezzoDaPrendere) {
		if(attrezzoDaPrendere==null)
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		else {
			//controllo che l'attrezzo sia dentro la stanza
			Attrezzo attrezzo= this.partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			if(attrezzo==null)
				io.mostraMessaggio("Non c'è questo attrezzo nella stanza!");
			else 
				if(this.partita.getGiocatore().aggiungiAttrezzo(attrezzo)) { //aggiungo l'attrezzo alla borsa
					this.partita.getStanzaCorrente().removeAttrezzo(attrezzo); //rimuovo l'attrezzo dalla stanza
					io.mostraMessaggio("Hai preso "+ attrezzoDaPrendere);
				}
				else io.mostraMessaggio("Non puoi prendere l'attrezzo!");
		}
	}

	/**
	 * Comando "Fine".
	 
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
*/
	public static void main(String[] argc) {
		IO io=new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}