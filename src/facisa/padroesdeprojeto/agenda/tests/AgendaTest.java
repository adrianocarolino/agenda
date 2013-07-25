package facisa.padroesdeprojeto.agenda.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import facisa.padroesdeprojeto.agenda.Contato;
import facisa.padroesdeprojeto.agenda.Grupo;
import facisa.padroesdeprojeto.agenda.command.RemovePrimeiroContato;
import facisa.padroesdeprojeto.agenda.command.RemoveTodosContatos;
import facisa.padroesdeprojeto.agenda.command.Telefone;
import facisa.padroesdeprojeto.agenda.exceptions.AgendaException;
import facisa.padroesdeprojeto.agenda.facade.FachadaAgenda;

/**
 * Data: 24/07/2013
 * 
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

	private FachadaAgenda criarAgenda() {
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
		// verificar os contatos que tem o mesmo nome e o mesmo telefone, não
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

	@Test(expected = AgendaException.class)
	public void removerContatoAgendaVazia() {
		// tenta remover um contato da agenda quando ela está vazia
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

	@Test(expected = AgendaException.class)
	public void adicionarContatoComAgendaCheia() {
		// tenta adicionar 1000 contatos na agenda, o que não é permitido
		for (int i = 0; i < 1000; i++) {
			fachadaAgenda.adicionarContato(criarContato("Contato " + i,
					Integer.toString(i)));
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
		Assert.assertTrue(fachadaAgenda.editarContato(contatoAntigo,
				novoContato));
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

	@Test
	public void adicionaAosFavoritos() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setFavorite(true);
		fachadaAgenda.adicionarContato(meuContato);
		Assert.assertEquals(1, fachadaAgenda.getContatosFavoritos().size());
	}

	@Test
	public void removeDosFavoritos() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setFavorite(true);
		fachadaAgenda.adicionarContato(meuContato);
		meuContato.setFavorite(false);
		Assert.assertEquals(0, fachadaAgenda.getContatosFavoritos().size());
	}

	@Test(expected = AgendaException.class)
	public void adicionaAosFavoritosSemQueContatoExistaNaAgenda() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		fachadaAgenda.adicionarContatoAosFavoritos(meuContato);
	}

	@Test(expected = AgendaException.class)
	public void removeDosFavoritosSemQueContatoExistaNaAgenda() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		fachadaAgenda.removeContatoDosFavoritos(meuContato);
	}

	@Test
	public void retornaContatosDoGrupoFamilia() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.FAMILIA);
		fachadaAgenda.adicionarContato(meuContato);
		Assert.assertEquals(1, fachadaAgenda.getFamiliares().size());
	}

	@Test
	public void retornaContatosDoGrupoAmigos() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.AMIGOS);
		fachadaAgenda.adicionarContato(meuContato);
		Assert.assertEquals(1, fachadaAgenda.getAmigos().size());
	}

	@Test
	public void retornaContatosDoGrupoTrabalho() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.TRABALHO);
		fachadaAgenda.adicionarContato(meuContato);
		Assert.assertEquals(1, fachadaAgenda.getColegasDeTrabalho().size());
	}

	@Test
	public void contatosSemGrupo() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.AMIGOS);
		fachadaAgenda.adicionarContato(meuContato);
		for (int i = 0; i < 10; i++) {
			fachadaAgenda.adicionarContato(criarContato("Contato " + i,
					Integer.toString(i)));
		}
		Assert.assertEquals(10, fachadaAgenda.getContatosSemGrupo().size());
	}

	@Test
	public void alteraGrupoDeUmContato() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.FAMILIA);
		fachadaAgenda.adicionarContato(meuContato);
		meuContato.setGrupo(Grupo.AMIGOS);
		Assert.assertEquals(1, fachadaAgenda.getAmigos().size());
		Assert.assertEquals(0, fachadaAgenda.getFamiliares().size());
	}

	@Test
	public void removeGrupoDeUmContato() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(Grupo.AMIGOS);
		fachadaAgenda.adicionarContato(meuContato);
		meuContato.setGrupo(Grupo.SEM_GRUPO);
		Assert.assertEquals(0, fachadaAgenda.getAmigos().size());
		Assert.assertEquals(1, fachadaAgenda.getContatosSemGrupo().size());
	}

	@Test(expected = AgendaException.class)
	public void grupoInvalido() {
		Contato meuContato = criarContato("Fábio", "3337-2764");
		meuContato.setGrupo(-3);
	}
	
	@Test
	public void retornaContatosPorOrdemAlfabética() {
		Contato meuContato1 = criarContato("Fábio", "3337-2774");
		Contato meuContato2 = criarContato("Adriano", "3331-5764");
		Contato meuContato3 = criarContato("Vamberto", "3335-2764");
		Contato meuContato4 = criarContato("Sabrina", "3331-4794");
		Contato meuContato5 = criarContato("João Paulo", "8871-4994");
		Contato meuContato6 = criarContato("Alexandre", "8890-4794");
		fachadaAgenda.adicionarContato(meuContato1);
		fachadaAgenda.adicionarContato(meuContato2);
		fachadaAgenda.adicionarContato(meuContato3);
		fachadaAgenda.adicionarContato(meuContato4);
		fachadaAgenda.adicionarContato(meuContato5);
		fachadaAgenda.adicionarContato(meuContato6);
		List<Contato> contatosOrdenados = fachadaAgenda.getContatosPorOrdemAlfabetica();
		Assert.assertEquals(meuContato2, contatosOrdenados.get(0));
		Assert.assertEquals(meuContato6, contatosOrdenados.get(1));
		Assert.assertEquals(meuContato1, contatosOrdenados.get(2));
		Assert.assertEquals(meuContato5, contatosOrdenados.get(3));
		Assert.assertEquals(meuContato4, contatosOrdenados.get(4));
		Assert.assertEquals(meuContato3, contatosOrdenados.get(5));
	}
	
	
	@Test
	public void testComandoRemoveTodosContatos() {
		Telefone telefone = new Telefone();		
		Contato meuContato1 = criarContato("Fábio", "3337-2774");
		Contato meuContato2 = criarContato("Adriano", "3331-5764");
		Contato meuContato3 = criarContato("Vamberto", "3335-2764");		
		fachadaAgenda.adicionarContato(meuContato1);
		fachadaAgenda.adicionarContato(meuContato2);
		fachadaAgenda.adicionarContato(meuContato3);		
		telefone.armazenarEExecutar(new RemoveTodosContatos(fachadaAgenda));		
		Assert.assertEquals(0, fachadaAgenda.getCount());
	}
	
	@Test
	public void testComandoRemovePrimeiroContato() {
		Telefone telefone = new Telefone();
		Contato meuContato1 = criarContato("Fábio", "3337-2774");
		Contato meuContato2 = criarContato("Adriano", "3331-5764");
		Contato meuContato3 = criarContato("Vamberto", "3335-2764");
		fachadaAgenda.adicionarContato(meuContato1);
		fachadaAgenda.adicionarContato(meuContato2);
		fachadaAgenda.adicionarContato(meuContato3);		
		telefone.armazenarEExecutar(new RemovePrimeiroContato(fachadaAgenda));
		Assert.assertEquals(2, fachadaAgenda.getCount());		
	}
	
}