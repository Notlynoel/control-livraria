package br.com.notlinoel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.notlinoel.modelo.Usuario;

public class UsuarioDAO {
	
	public void salvar(Usuario usuario){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	/**
	 * ESTE MÉTODO CARREGA E RETORNA A LISTA DE LIVROS
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		//NO SELECT É USADO O NOME DA CLASSE E NÃO DA TABELA
		Query query = entityManager.createQuery("FROM Usuario");
		
		return query.getResultList();
	}
	/**
	 * ESTE MÉTODO PARA EXCLUIR LIVROS
	 * @param livro
	 */
	public void excluir(Usuario usuario) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		usuario = entityManager.merge(usuario);
		
		entityManager.remove(usuario);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
	
}
