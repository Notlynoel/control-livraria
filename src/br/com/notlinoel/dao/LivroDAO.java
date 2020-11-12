package br.com.notlinoel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.notlinoel.modelo.Livro;

public class LivroDAO {
	
	public void salvar(Livro livro){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(livro);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	/**
	 * ESTE MÉTODO CARREGA E RETORNA A LISTA DE LIVROS
	 */
	@SuppressWarnings("unchecked")
	public List<Livro> listarTodos(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		//NO SELECT É USADO O NOME DA CLASSE E NÃO DA TABELA
		Query query = entityManager.createQuery("FROM Livro");
		
		return query.getResultList();
	}
	/**
	 * ESTE MÉTODO PARA EXCLUIR LIVROS
	 * @param livro
	 */
	public void excluir(Livro livro) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		livro = entityManager.merge(livro);
		
		entityManager.remove(livro);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
	@SuppressWarnings("unchecked")
	public static List<Livro> listarCursosAccordion() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		return entityManager.createQuery("FROM Livro where nome in ('Violino', 'Bateria', 'Clarinete',"
				+ "'Flautam', 'Guitarra', 'Violão', 'Oboé') ORDER BY nome").getResultList();
		
	}

}
