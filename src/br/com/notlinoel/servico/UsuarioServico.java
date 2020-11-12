package br.com.notlinoel.servico;

import br.com.notlinoel.modelo.Usuario;

public interface UsuarioServico {
	
	public Usuario obterUsuarioPeloLogin(String login);

}
