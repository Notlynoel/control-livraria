package br.com.notlinoel.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.notlinoel.modelo.Livro;
import br.com.notlinoel.servico.LivroServico;

@Service(value = "livroServico") // Informa que ele pode ser injetado em outro lugar da aplicação
@Transactional // Informa que todos os métodos da classe pode ser Transactional
public class LivroServicoImpl implements LivroServico {
	
	@PersistenceContext // Cria uma instância de EntityManager
	private EntityManager entityManager;	

	@Override
	public void salvar(Livro livro) {
		entityManager.merge(livro);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> listarTodos() {
		return entityManager.createQuery("From Livro").getResultList();
	}

	@Override
	public void excluir(Livro livro) {
		livro = entityManager.merge(livro);
		entityManager.remove(livro);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> listarCursosAccordion() {
		
		return entityManager.createQuery("from Curso where nome in ('Matemática', " +
				"'Administraçao', 'Arquitetura', 'Banco', 'Contabilidade', 'Desenvolvimento', 'Design') order by nome").getResultList();
	}

}
