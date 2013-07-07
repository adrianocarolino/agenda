import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Adriano Melo
 *
 */ 
public class Agenda {

	private ArrayList<Contato> contatos;
	
	private int limiteMaximoContatos = 999;
	
	public Agenda() {	
		this.contatos = new ArrayList<Contato>();
	}
	
	public boolean isVazia() {
		return this.getContatos().size() == 0;
	}
	
	public boolean isFull() {
		return this.getContatos().size() == this.limiteMaximoContatos;
	}
	
	public void adicionarContato(Contato contato) {
		if (!this.existe(contato) && !this.isFull())
			this.getContatos().add(contato);
		else throw new AgendaException("Contato j� existe na agenda ou agenda est� cheia.");
	}
	
	public void removerContato(Contato contato) {
		if (this.existe(contato))
			this.getContatos().remove(contato);
		else throw new AgendaException("Contato n�o existe na agenda.");
	}

	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}
	
	public boolean existe(Contato contato) {
		//se o nome j� existe, ent�o o contato j� existe na agenda. N�o precisa comparar os telefones, pois 
		//pode ocorrer o caso de ter dois contatos com o mesmo n�mero de telefone e nomes diferentes
		Iterator it = getContatos().iterator();
		
		while (it.hasNext()) {
			Contato contatoTemporario = (Contato) it.next();
			//TODO comparar os telefones?
			if (contatoTemporario.getNome().equalsIgnoreCase(contato.getNome())) {
				return true;
			}
				
		}
		return false;
	}
	
	public boolean editarContato(Contato antigoContato, Contato novoContato) {
		//TODO procurar o contato na lista e atualizar
		//retornar TRUE se o contato for editado com sucesso
		return false;
	}
	
}
