package br.com.notlinoel.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.notlinoel.dao.LivroDAO;
import br.com.notlinoel.modelo.Livro;
import br.com.notlinoel.modelo.TipoLivro;

@ManagedBean
@SessionScoped
//@ViewScoped
public class LivroBean implements Serializable {
	
	private static final long serialVersionUID = -1962119363408852334L;
	
	//private Livro livro = new Livro(); USADO PARA SALVAR EM MEMÓRIA
	private Livro livro;
	private List<TipoLivro> tipos; 
	//OS CURSOS FICARAM SALVOS AQUI POR ENQUANTO
	private List<Livro> livros = new ArrayList<Livro>();
	private Livro livroParaExclusao;
	
	/**
	 * Este Método Carrega os livros Cadastrado Antes de exibir a página
	 * @return Lista de livros cadastrados
	 */
	public void iniciarBean(){
		livros = new LivroDAO().listarTodos();
		tipos = Arrays.asList(TipoLivro.values());
		livro = new Livro();
	}
	
	public void novoLivro(){
		livro = new Livro();
	}
	
	/**
	 * Este Método Cadastra um livro
	 * @return Lista de livros cadastrados
	 * @throws InterruptedException 
	 */
	public void cadastrar() throws InterruptedException{
		Thread.sleep(2000); // Este código vai bloqueia a tela ao salvar um livro
		new LivroDAO().salvar(livro);
		//livros.add(livro); Foi utilizado para salvar os dados em memória
		livros = new LivroDAO().listarTodos();
		livro = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro Cadastrado com sucesso."));
		//livro = new Livro();
		
		//return "livro_lista?faces-redirect=true";
	}
	/**
	 * Este Método Altera um objeto Livro
	 * @return O objeto/livro atualizado
	 */
	public void editar(Livro livro){
		this.livro = livro;		
		//return "livro_formulario?faces-redirect=true";
	}
	public void voltar(){
		livro = null;
	}
	/**
	 * Prepara um objeto livro para a exclusão
	 * @param livro
	 */
	public void prepararExclusao(Livro livro){
		this.livroParaExclusao = livro;
		
	}
	/**
	 * Esté método é de exclusão de um livros
	 * @return A lista de livros atualizada
	 */
	public void excluir(){
		new LivroDAO().excluir(livroParaExclusao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro excluido com sucesso"));
		livros = new LivroDAO().listarTodos();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<TipoLivro> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoLivro> tipos) {
		this.tipos = tipos;
	}

	// FOI CRIADO SEM INSTRUÇÃO DO INSTRUTOR
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivroParaExclusao() {
		return livroParaExclusao;
	}

	public void setLivroParaExclusao(Livro livroParaExclusao) {
		this.livroParaExclusao = livroParaExclusao;
	}
	
}
