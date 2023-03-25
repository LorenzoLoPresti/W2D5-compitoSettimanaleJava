package CatalogoBibliotecario;

import java.time.LocalDate;

public class Rivista extends SupportoCartaceo {

	Periodicità periodicità;
	
	public Rivista(String id, String title, int scrittoIl, int pag, Periodicità period) {
		super(id, title, scrittoIl, pag);
		this.periodicità = period;
	}
	
	public void getElemento() {	
		System.out.println("Uscita: " + this.periodicità);
		super.getElemento();
		
	}
}
