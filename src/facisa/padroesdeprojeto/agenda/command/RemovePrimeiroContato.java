package facisa.padroesdeprojeto.agenda.command;

import facisa.padroesdeprojeto.agenda.facade.FachadaAgenda;

public class RemovePrimeiroContato implements Comando {

	private FachadaAgenda agenda;
	
	public RemovePrimeiroContato(FachadaAgenda agenda) {
		this.agenda = agenda;
	}
	
	@Override
	public void execute() {
		// apaga apenas o primeiro contato da agenda
		agenda.getContatos().remove(0);
	}

}
