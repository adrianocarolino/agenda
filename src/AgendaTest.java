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
	
	@Test
	public void adicionarContatoDuplicado() {
		//verificar os contatos que tem o mesmo nome e o mesmo telefone, nao pode permitir
	}
	
	@Test 
	public void removerContatoExistente() {
		
	}
	
	@Test 
	public void removerContatoNaoExistente() {
		
	}
	
	@Test
	public void listarDetalhesDoContato() {
		
	}
	
	@Test
	public void contatoIncompleto() {
		//verificar se o nome é vazio OU telefone é vazio (um dos dois) 
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
		boolean tel2 = telefones.add("3337-3534");
		Contato contato = new Contato("Adriano", telefones);
		agenda.adicionarContato(contato);
		System.out.println(agenda.getContatos());
	}

}
