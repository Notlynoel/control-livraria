package br.com.notlinoel.modelo;

public enum TipoLivro {
	
	CIENCIAS("Ciências"),
	GEOGRAFIA("Geográfia"),
	HISTORIA("História"),
	INFORMATICA("Informática"),
	INGLES("Inglês"),
	LITERATURA("Literatura"),
	MATEMATICA("Matemática"),
	PORTUGUES("Português"),
	ROMANCE("Românce");
	
	private String label;
	
	private TipoLivro(String label){
		this.label = label;		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	
}
