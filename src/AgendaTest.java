import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
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
		// verificar os contatos que tem o mesmo nome e o mesmo telefone, não pode permitir
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
	
	@Test(expected = AgendaException.class)
	public void removerContatoAgendaVazia() {
		//tenta remover um contato da agenda quando ela está vazia
		Contato contato = criarContato("Vamberto", "3335-3290");
		fachadaAgenda.removerContato(contato);		
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
		fachadaAgenda.adicionarContato(criarContato("Adriano", "3331-3734"));
		Contato contato = fachadaAgenda.getContato("Adriano"); 
		Assert.assertNotNull(contato);
	}

	@Test
	public void listarAgendaVazia() {
		System.out.println(fachadaAgenda.getContatos());
		Assert.assertEquals(0, fachadaAgenda.getContatos().size());
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
		//tenta adicionar 1000 contatos na agenda, o que não é permitido
		for (int i=0; i<1000; i++) {
			fachadaAgenda.adicionarContato(criarContato("Contato " + i, Integer.toString(i)));
		}
	}
	
	@Test
	public void retornaContatos() {
		fachadaAgenda.adicionarContato(criarContato("Adriano", "3331-3734"));
		System.out.println(fachadaAgenda.getContatos());
	}
	
	@Test
	public void editarContato() {
		Contato contatoAntigo = criarContato("Fábio", "3337-2764");
		fachadaAgenda.adicionarContato(contatoAntigo);
		Contato novoContato = criarContato("Fábio", "3335-2764");		
		Assert.assertTrue(fachadaAgenda.editarContato(contatoAntigo, novoContato));
	}
	
	@Test
	public void numeroDeContatosNaAgenda() {
		Contato contatoAntigo = criarContato("Fábio", "3337-2764");
		fachadaAgenda.adicionarContato(contatoAntigo);
		Assert.assertEquals(1, fachadaAgenda.getCount());
	}
	
	@Test
	public void removeTodosContatos() {
		fachadaAgenda.adicionarContato(criarContato("Fábio", "3337-2764"));
		fachadaAgenda.adicionarContato(criarContato("Adriano", "3331-3734"));
		fachadaAgenda.clear();
		Assert.assertEquals(0, fachadaAgenda.getCount());
	}

}