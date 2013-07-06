import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import org.junit.Test;

public class AgendaTest {

	private Agenda agenda; 
	
	@Test
	public void novaAgenda() {
		agenda = criarAgenda();
		Assert.assertTrue("Agenda está vazia", agenda.isVazia());
	}
	
	public Agenda criarAgenda() {
		return new Agenda();
	}
	
	@Test
	public void adicionarContato() {
		agenda = criarAgenda();
		Set<String> telefones = new HashSet<String>();
		boolean b = telefones.add("3331-3534");
		Contato contato = new Contato("Adriano", telefones);
		agenda.adicionarContato(contato);
		Assert.assertEquals(1, agenda.getContatos().size());
	}
	
	@Test (expected=AgendaException.class)
	public void adicionarContatoDuplicado() {
		//verificar os contatos que tem o mesmo nome e o mesmo telefone, nao pode permitir
		agenda = criarAgenda();
		Set telefones1 = new HashSet();
		boolean tel1 = telefones1.add("3331-3534");
		Contato contato1 = new Contato("Adriano", telefones1);
		
		Set telefones2 = new HashSet();
		boolean tel2 = telefones2.add("3331-3534");
		Contato contato2 = new Contato("Adriano", telefones2);
		
		agenda.adicionarContato(contato1);
		agenda.adicionarContato(contato2); // expect exception here
		
	}
	
	@Test 
	public void removerContatoExistente() {
		agenda = criarAgenda();
	}
	
	@Test 
	public void removerContatoNaoExistente() {
		agenda = criarAgenda();
	}
	
	@Test
	public void listarDetalhesDoContato() {
		agenda = criarAgenda();
	}
	
	@Test
	public void contatoIncompleto() {
		//verificar se o nome é vazio OU telefone é vazio (um dos dois)
		agenda = criarAgenda();
	}
	
	@Test
	public void listarAgendaVazia() {
		agenda = criarAgenda();
		System.out.println(agenda.getContatos());
	}

	@Test
	public void listarAgenda() {
		agenda = criarAgenda();
		//adicionar pelo menos um contato para listar
		Set<String> telefones = new HashSet<String>();
		boolean tel1 = telefones.add("3331-3534");
		boolean tel2 = telefones.add("3337-3434");
		Contato contato = new Contato("Adriano", telefones);
		agenda.adicionarContato(contato);
		System.out.println(agenda.getContatos());
	}

}
