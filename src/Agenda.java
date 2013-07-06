import java.util.ArrayList;
import java.util.Iterator;


public class Agenda {

	private ArrayList<Contato> contatos;
	
	public Agenda() {	
		this.contatos = new ArrayList<Contato>();
	}
	
	public boolean isVazia() {
		return this.contatos.size() == 0;
	}
	
	public void adicionarContato(Contato contato) {
		if (!existe(contato))
			this.contatos.add(contato);
		else throw new AgendaException("Contato já existe") ;		
	}
	
	public void removerContato(Contato contato) {
		this.removerContato(contato);
	}

	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}
	
	public boolean existe(Contato contato) {
		//se o nome E telefone existem entao o contato já existe na agenda
		Iterator it = getContatos().iterator();
		
		while (it.hasNext()) {
			Contato contatoTemporario = (Contato) it.next();
			if (contatoTemporario.getNome().equalsIgnoreCase(contato.getNome())) {
				return true;
			}
				
		}		
		return false;
	}
}
