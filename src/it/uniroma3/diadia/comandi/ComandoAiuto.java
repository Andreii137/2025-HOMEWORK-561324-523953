package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final public String[] ELENCO_COMANDI= {"vai", "aiuto", "fine", "posa", "prendi","guarda"};
	private final static String NOME="aiuto";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		io.mostraMessaggio(" ");
	}
	
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
