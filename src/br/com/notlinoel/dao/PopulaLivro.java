package br.com.notlinoel.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.notlinoel.modelo.Livro;
import br.com.notlinoel.modelo.TipoLivro;

public class PopulaLivro {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Livro seresvivos = geraLivro("Os Seres Vivos",    "Hernir Souza",    "345d",   45,  40, "01/01/2014",  4,TipoLivro.CIENCIAS);
		Livro hibernate =  geraLivro("Hibernate",         "Normandes",       "58968", 150,  49, "10/01/2014",  8,TipoLivro.INFORMATICA);
		Livro spring =     geraLivro("Spring MVC",        "Thomas Dias",     "2536",  120, 120, "10/01/2015",  12,TipoLivro.INFORMATICA);
		Livro ossertoes =  geraLivro("Os Sertões",        "M. Andrade",      "4586",  155,  79, "10/01/2000",  21,TipoLivro.LITERATURA);
		Livro java2 =      geraLivro("Java 2",            "William P",       "4576",  185,  74, "10/01/2010",  22,TipoLivro.INFORMATICA);
		Livro raizes =     geraLivro("Raizes do Brasil",  "Sérgio Buarque",  "4586",  155,  85, "10/01/2009",  21,TipoLivro.HISTORIA);
		Livro nabuco =     geraLivro("O Abolicionismo",   "Joaquim Nabuco",  "4587",  255,  55, "10/01/1990",  21,TipoLivro.HISTORIA);
		Livro escravo =    geraLivro("Ser Escravo",       "Kátia Queiroz",   "4588",  156,  63, "10/01/2011",  11,TipoLivro.HISTORIA);
		Livro senzala =    geraLivro("Senzala",           "Gilberto Freyre", "4589",  188,  85, "10/01/2005",  21,TipoLivro.HISTORIA);
		Livro regiao =     geraLivro("Região e Geografia","Sandra Lencioni", "4590",  178,  75, "10/01/2008",  41,TipoLivro.GEOGRAFIA);
		Livro agraria =    geraLivro("Geografia Agrária","Bernardo Mançano", "4591",  148,  55, "10/01/2009",  21,TipoLivro.GEOGRAFIA);
		Livro introducao = geraLivro("Introdução Geografia","Roberto Lobato","4592",  248,  31, "10/01/2011",  22,TipoLivro.GEOGRAFIA);
		Livro educacao =   geraLivro("Inglês na Prática","Tunwell, Chris"   ,"4593",  248,  41, "10/01/2012", 121,TipoLivro.INGLES);
		Livro clima =      geraLivro("Climatologia",   " Francisco Mendonça","4594",  258,  81, "10/01/2013", 121,TipoLivro.GEOGRAFIA);
		Livro pratica =    geraLivro("Português Prática",    "Sandra Helena","4595",  228,  91, "10/01/2014", 41,TipoLivro.PORTUGUES);
		Livro trabalho =   geraLivro("Trab E Linguagem",    "Fernando Dias", "4596",  238,  87, "10/01/2015", 31,TipoLivro.PORTUGUES);
		Livro matematica = geraLivro("Matemática      ",    "Bruno Villar" , "4597",  338, 107, "10/01/2015", 31,TipoLivro.MATEMATICA);
		Livro matBasica =  geraLivro("Matemática Básica",    "Bruno Villar", "4598",  138,  87, "10/01/2012", 31,TipoLivro.MATEMATICA);
		Livro madalena =   geraLivro("Maria Madalena",      "Margaret Dias", "4599",  128,  57, "10/01/2011",  3,TipoLivro.ROMANCE);
		Livro simbolo =   geraLivro("Símbolo Perdido",      "Brown, Dan",    "4500",  258,  97, "10/01/2010",  8,TipoLivro.ROMANCE);
		
		 
		
		
		em.persist(seresvivos);
		em.persist(hibernate);
		em.persist(spring);
		em.persist(ossertoes);
		em.persist(java2);
		em.persist(raizes);
		em.persist(nabuco);
		em.persist(escravo);
		em.persist(senzala);
		em.persist(regiao);
		em.persist(agraria);
		em.persist(introducao);
		em.persist(educacao);
		em.persist(clima);
		em.persist(pratica);
		em.persist(trabalho);
		em.persist(matematica);
		em.persist(matBasica);
		em.persist(madalena);
		em.persist(simbolo);
		
		em.getTransaction().commit();
		em.close();
	}
	
	

	public static Livro geraLivro(String titulo, String autor, String isbn, int paginas, double valor,String data, int quantidade, TipoLivro tipo){
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setIsbn(isbn);
		livro.setQtdPagina(paginas);
		livro.setValor(valor);
		livro.setDataPublicacao(parseData(data));
		livro.setQuantidade(quantidade);
		livro.setTipo(tipo);
		return livro;
	}
	
	private static Date parseData(String data){
		try{
			Date date = new SimpleDateFormat("dd/MM/yyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.getTime();
		}catch(ParseException e){
			throw new IllegalArgumentException(e);
		}
	}
}
