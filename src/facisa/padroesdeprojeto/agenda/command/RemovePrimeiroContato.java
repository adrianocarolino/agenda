package facisa.padroesdeprojeto.agenda.command;

import facisa.padroesdeprojeto.agenda.facade.FachadaAgenda;
/**
 * Data: 24/07/2013
 * 
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
 */
public class RemovePrimeiroContato implements Comando {

	private FachadaAgenda agenda;
	
	/**
	 * Construtor
	 * @param agenda a fachada
	 */
	public RemovePrimeiroContato(FachadaAgenda agenda) {
		this.agenda = agenda;
	}
	
	@Override
	public void execute() {
		// apaga apenas o primeiro contato da agenda
		agenda.getContatos().remove(0);
	}

}
