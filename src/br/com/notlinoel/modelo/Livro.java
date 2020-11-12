package br.com.notlinoel.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Livros")
public class Livro implements Serializable {
		
	private static final long serialVersionUID = -348588185706650178L;
	
	private Integer id;
	private String titulo;
	private String autor;
	private String isbn;
	private int qtdPagina;
	private double valor;
	private Date dataPublicacao;
	private int quantidade;
	private TipoLivro tipo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Por favor, preencha o campo título")
	@Length(min = 4, max = 30, message = "Título deve ter no minimo 4 caraceter e no máximo 30!")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@NotEmpty(message = "Por favor, preencha o campo autor")
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@NotEmpty(message = "Por favor, preencha o campo ISBN")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@NotNull(message = "Por favor, preencha o campo Qtd Páginas")
	public int getQtdPagina() {
		return qtdPagina;
	}

	public void setQtdPagina(int qtdPagina) {
		this.qtdPagina = qtdPagina;
	}
	
	//@NotEmpty(message = "Por favor, preencha o campo valor")
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@NotNull(message = "Por favor, informar uma data")
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	//@NotEmpty(message = "Por favor, preencha o campo quantidade")
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//@NotEmpty(message = "Por favor, selecione um tipo de livro")
	public TipoLivro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLivro tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
