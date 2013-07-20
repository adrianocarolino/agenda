package facisa.padroesdeprojeto.agenda.command;

import facisa.padroesdeprojeto.agenda.facade.FachadaAgenda;

public class RemoveTodosContatos implements Comando {

	private FachadaAgenda agenda;
	
	public RemoveTodosContatos(FachadaAgenda agenda) {
		this.agenda = agenda;
	}

	@Override
	public void execute() {
		//apaga todos os contatos da agenda
		agenda.clear();
	}

}
