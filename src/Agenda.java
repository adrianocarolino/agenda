import java.util.ArrayList;


public class Agenda {

	private ArrayList<Contato> contatos;
	
	public Agenda() {	
		this.contatos = new ArrayList<Contato>();
	}
	
	public boolean isVazia() {
		return this.contatos.size() == 0;
	}
	
	public void adicionarContato(Contato contato) {
		this.contatos.add(contato);
	}
	
	public void removerContato(Contato contato) {
		this.removerContato(contato);
	}

	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}
	
	public boolean existe(Contato contato) {
		//se o nome E telefone existem entao o contato já existe na agenda
		//if (contato.nome)
		return false;
	}
}
