import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

public class AgendaTest {

	private Agenda agenda; 
	
	@Before
	public void novaAgenda() {
		agenda = criarAgenda();
		Assert.assertTrue("Agenda está vazia", agenda.isVazia());
	}
	
	public Agenda criarAgenda() {
		return new Agenda();
	}
	
	@Test
	public void adicionarContato() {		
		Set<String> telefones = new HashSet<String>();
		boolean b = telefones.add("3331-3534");
		Contato contato = new Contato("Adriano", telefones);
		agenda.adicionarContato(contato);
		Assert.assertEquals(1, agenda.getContatos().size());
	}
	
	@Test (expected=AgendaException.class)
	public void adicionarContatoDuplicado() {
		//verificar os contatos que tem o mesmo nome e o mesmo telefone, nao pode permitir
		Contato contato1 = criarContato("Adriano", "3331-3734");		
		Contato contato2 = criarContato("Adriano", "3331-3734");
		
		agenda.adicionarContato(contato1);
		agenda.adicionarContato(contato2); // expect exception here
		
	}
	
	@Test 
	public void removerContatoExistente() {		
		Contato contato = criarContato("Adriano", "3331-3734");
		agenda.adicionarContato(contato);		
		agenda.removerContato(contato);
		Assert.assertTrue(agenda.isVazia());
	}

	private Contato criarContato(String nome, String telefone) {
		Set telefones1 = new HashSet();
		boolean tel1 = telefones1.add(telefone);
		Contato contato = new Contato("Adriano", telefones1);
		return contato;
	}
	
	@Test(expected=AgendaException.class) 
	public void removerContatoNaoExistente() {
		agenda = criarAgenda();		
		agenda.removerContato(criarContato("Adriano", "3331-3734"));		
	}
	
	@Test
	public void listarDetalhesDoContato() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void contatoIncompleto() {
		//verificar se o nome é vazio OU telefone é vazio (um dos dois)
		Assert.assertTrue(false);
	}
	
	@Test
	public void listarAgendaVazia() {
		System.out.println(agenda.getContatos());
	}

	@Test
	public void listarAgenda() {
		//adicionar pelo menos um contato para listar
		Set<String> telefones = new HashSet<String>();
		boolean tel1 = telefones.add("3331-3534");
		boolean tel2 = telefones.add("3337-3434");
		Contato contato = new Contato("Adriano", telefones);
		agenda.adicionarContato(contato);
		System.out.println(agenda.getContatos());
	}

}
