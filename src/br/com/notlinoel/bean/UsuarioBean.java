package br.com.notlinoel.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.notlinoel.dao.UsuarioDAO;
import br.com.notlinoel.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -4696786348325816261L;
	
	private Usuario usuario;
	//private List<TipoLivro> tipos; 
	//OS CURSOS FICARAM SALVOS AQUI POR ENQUANTO
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario usuarioParaExclusao;
	
	/**
	 * Este Método Carrega os livros Cadastrado Antes de exibir a página
	 * @return Lista de livros cadastrados
	 */
	public void iniciarBean(){
		usuarios = new UsuarioDAO().listarTodos();
		//tipos = Arrays.asList(TipoLivro.values());
		usuario = new Usuario();
	}
	
	public void novoUsuario(){
		usuario = new Usuario();
	}
	
	/**
	 * Este Método Cadastra um livro
	 * @return Lista de livros cadastrados
	 * @throws InterruptedException 
	 */
	public void cadastrar() throws InterruptedException{
		Thread.sleep(2000); // Este código vai bloqueia a tela ao salvar um livro
		new UsuarioDAO().salvar(usuario);
		//livros.add(livro); Foi utilizado para salvar os dados em memória
		usuarios = new UsuarioDAO().listarTodos();
		usuario = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Cadastrado com sucesso."));
		//livro = new Livro();
		
		//return "livro_lista?faces-redirect=true";
	}
	/**
	 * Este Método Altera um objeto Livro
	 * @return O objeto/livro atualizado
	 */
	public void editar(Usuario usuario){
		this.usuario = usuario;		
		//return "livro_formulario?faces-redirect=true";
	}
	public void voltar(){
		usuario = null;
	}
	/**
	 * Prepara um objeto livro para a exclusão
	 * @param livro
	 */
	public void prepararExclusao(Usuario usuario){
		this.usuarioParaExclusao = usuario;
		
	}
	/**
	 * Esté método é de exclusão de um livros
	 * @return A lista de livros atualizada
	 */
	public void excluir(){
		new UsuarioDAO().excluir(usuarioParaExclusao);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário excluido com sucesso"));
		usuarios = new UsuarioDAO().listarTodos();
	}
	
	public void autor(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Desenvolvido por Léo Hollanda"));
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioParaExclusao() {
		return usuarioParaExclusao;
	}

	public void setUsuarioParaExclusao(Usuario usuarioParaExclusao) {
		this.usuarioParaExclusao = usuarioParaExclusao;
	}
	
	

}
