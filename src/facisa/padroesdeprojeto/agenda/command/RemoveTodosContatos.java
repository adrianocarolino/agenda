package facisa.padroesdeprojeto.agenda.command;

import facisa.padroesdeprojeto.agenda.facade.FachadaAgenda;

/**
 * Data: 24/07/2013
 * 
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
 */
public class RemoveTodosContatos implements Comando {

	private FachadaAgenda agenda;
	
	/**
	 * Construtor
	 * @param agenda a fachada
	 */
	public RemoveTodosContatos(FachadaAgenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public void execute() {
		//apaga todos os contatos da agenda
		agenda.clear();
	}

}
