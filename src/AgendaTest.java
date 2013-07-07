import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

/**
 * 
 * @author Adriano Melo
 * 
 */
public class AgendaTest {

	private FachadaAgenda fachadaAgenda;

	@Before
	public void novaAgenda() {
		fachadaAgenda = criarAgenda();
		Assert.assertEquals(0, fachadaAgenda.getContatos().size());
	}

	public FachadaAgenda criarAgenda() {
		return new FachadaAgenda();
	}

	@Test
	public void adicionarContato() {
		Contato contato = criarContato("Adriano", "3331-3734");
		fachadaAgenda.adicionarContato(contato);
		Assert.assertEquals(1, fachadaAgenda.getContatos().size());
	}

	@Test(expected = AgendaException.class)
	public void adicionarContatoDuplicado() {
		// verificar os contatos que tem o mesmo nome e o mesmo telefone, nao
		// pode permitir
		Contato contato1 = criarContato("Adriano", "3331-3734");
		Contato contato2 = criarContato("Adriano", "3331-3734");
		fachadaAgenda.adicionarContato(contato1);
		fachadaAgenda.adicionarContato(contato2); // expect exception here
	}

	@Test
	public void removerContatoExistente() {
		Contato contato = criarContato("Adriano", "3331-3734");
		fachadaAgenda.adicionarContato(contato);
		fachadaAgenda.removerContato(contato);
		Assert.assertEquals(0, fachadaAgenda.getContatos().size());
	}

	private Contato criarContato(String nome, String telefone) {
		Set telefones = new HashSet();
		boolean tel1 = telefones.add(telefone);
		Contato contato = new Contato(nome, telefones);
		return contato;
	}

	@Test(expected = AgendaException.class)
	public void removerContatoNaoExistente() {
		fachadaAgenda = criarAgenda();
		fachadaAgenda.removerContato(criarContato("Adriano", "3331-3734"));
	}

	@Test
	public void listarDetalhesDoContato() {
		//TODO só fazer um getContato na agenda e na fachada
		Assert.assertTrue(false);
	}

	@Test
	public void contatoIncompleto() {
		//TODO verificar se o nome é vazio OU telefone é vazio (um dos dois)
		Assert.assertTrue(false);
	}

	@Test
	public void listarAgendaVazia() {
		System.out.println(fachadaAgenda.getContatos());
	}

	@Test
	public void agendaCheia() {
		//limite da agenda é de 999 contatos
		for (int i=0; i<999; i++) {
			fachadaAgenda.adicionarContato(criarContato("Contato " + i, Integer.toString(i)));
		}
		Assert.assertTrue(fachadaAgenda.isFull());
	}
	
	@Test(expected = AgendaException.class)
	public void adicionarContatoComAgendaCheia() {
		//tenta adicionar 1000 contatos na agenda
		for (int i=0; i<1000; i++) {
			fachadaAgenda.adicionarContato(criarContato("Contato " + i, Integer.toString(i)));
		}
	}
	
	@Test
	public void listarAgenda() {
		// adicionar pelo menos um contato para listar
		Set<String> telefones = new HashSet<String>();
		boolean tel1 = telefones.add("3331-3534");
		boolean tel2 = telefones.add("3337-3434");
		Contato contato = new Contato("Adriano", telefones);
		fachadaAgenda.adicionarContato(contato);
		System.out.println(fachadaAgenda.getContatos());
	}

}