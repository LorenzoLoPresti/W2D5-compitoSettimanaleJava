package CatalogoBibliotecario;

import java.time.LocalDate;

public class Libro extends SupportoCartaceo{
	
	public String autore;
	public Genere genere;
	
	public Libro(String id, String title, int scrittoIl, int pag, String autore, Genere genere) {
		super(id, title, scrittoIl, pag);
		this.autore = autore;
		this.genere = genere;
	}
		
	public void getElemento() {	
		System.out.println("Autore: " + this.autore);
		System.out.println("Genere: " + this.genere);
		super.getElemento();
	}
	
	
}
