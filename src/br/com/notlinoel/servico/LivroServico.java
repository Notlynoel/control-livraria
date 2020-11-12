package br.com.notlinoel.servico;

import java.util.List;

import br.com.notlinoel.modelo.Livro;

public interface LivroServico {
	
	public void salvar(Livro livro);
	public List<Livro> listarTodos();
	public void excluir(Livro livro);
	public List<Livro> listarCursosAccordion();

}
