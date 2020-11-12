package br.com.notlinoel.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.notlinoel.modelo.Usuario;
import br.com.notlinoel.servico.UsuarioServico;

@Service("usuarioServico")
@Transactional
public class UsuarioServicoImpl implements UsuarioServico {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Usuario obterUsuarioPeloLogin(String login) {
		List<Usuario> usuarios = entityManager.createQuery(
				"From Usuario Where login = :login")
				.setParameter("login", login)
				.getResultList();
		
		if(usuarios.isEmpty()){
			return null;
		}
		
		return usuarios.get(0);
	}

}
