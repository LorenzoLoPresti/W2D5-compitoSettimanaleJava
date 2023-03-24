package CatalogoBibliotecario;

import java.time.LocalDate;

public class SupportoCartaceo {
	public String CodiceISBN;
	public String titolo;
	public LocalDate annoPubblicazione;
	public int numeroPagine;
	
	public SupportoCartaceo(String id, String title, LocalDate scrittoIl, int pag) {
		this.CodiceISBN = id;
		this.titolo = title;
		this.annoPubblicazione = scrittoIl;
		this.numeroPagine = pag;
	}
	
	public void getElemento() {
		System.out.println("ISBN: " + this.CodiceISBN);
		System.out.println("Titolo: " + this.titolo);
		System.out.println("Numero pagine: " +this.numeroPagine);
		System.out.println("Data Pubblicazione: " + this.annoPubblicazione);
		System.out.println();
	}
}
