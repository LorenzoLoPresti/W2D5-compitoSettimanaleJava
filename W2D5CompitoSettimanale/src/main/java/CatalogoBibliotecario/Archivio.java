package CatalogoBibliotecario;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Archivio {

	public static List<SupportoCartaceo> catalogo = new ArrayList<SupportoCartaceo>();
	
	public static void main(String[] args) {
		
		// LIbri
		Libro libro1 = new Libro("ID3080277", "L'arte della Guerra", LocalDate.of(2012, 3, 14), 90, "Sun Tsu", Genere.SAGGISTICA);
		Libro libro2 = new Libro("ID8660409", "Harry Potter e il prigioniero di Azkaban", LocalDate.of(2013, 12, 18), 330, "JK Rowling", Genere.SAGGISTICA);
		Libro libro3 = new Libro("ID8660409", "Lord of Light", LocalDate.of(2000, 5, 5),200, "Roger Zelazny", Genere.FANTASY);
		Libro libro4 = new Libro("ID8660409", "Wool", LocalDate.of(2009, 11, 28), 709, "Hugh Howley", Genere.STORICO);
		Libro libro5 = new Libro("ID5011446", "Artemis Fowl", LocalDate.of(2013, 12, 18), 302, "Eoin Colfer", Genere.SCI_FI);
		Libro libro6 = new Libro("ID2292007", "I Never Promised You a Rose Garden", LocalDate.of(2020, 01, 04), 432, "Joanne Greenberg", Genere.HORROR);
		Libro libro7 = new Libro("ID2629038", "L'orrore di Dunwitch", LocalDate.of(1929, 04, 11), 432, "H.P. Lovecraft", Genere.HORROR);
		Libro libro8 = new Libro("ID2629038", "Dunwitch", LocalDate.of(1929, 04, 11), 432, "H.P. Lovecraft", Genere.HORROR);
			
		// Riviste
		Rivista rivista1 = new Rivista("ID2625473", "Storic Mag", LocalDate.of(2020, 07, 12), 140, Periodicità.MENSILE);
		Rivista rivista2 = new Rivista("ID2416365", "Car Mag", LocalDate.of(2023, 11, 28), 130, Periodicità.MENSILE);
		Rivista rivista3 = new Rivista("ID2416365", "Topolino", LocalDate.of(2023, 10, 8), 150, Periodicità.SETTIMANALE);
		Rivista rivista4 = new Rivista("ID2416365", "ArtiMarziali for the win", LocalDate.of(2021, 3, 14), 190, Periodicità.TRIMESTRALE);
		
		SupportoCartaceo[] arr = {libro1, libro2, libro3, libro4, libro5, libro6, libro7, rivista1, rivista2, rivista3, rivista4};
		
		riempiArchivio(arr);
		
		aggiungiElemento(libro1);
		
	
		
		rimuoviElemento("ID3080277");

		System.out.println(catalogo.size());
		
		ricercaPerAnno(2023);
		
		ricercaPerAutore("");
		

	}
	
	// SETTORE PIGRIZIA
	private static String creaId() {
		String numero = "ID";
		for(int i = 0; i < 7; i++) {
			numero += (int)Math.floor(Math.random()*10);
		}
		
		System.out.println(numero);
		return  numero;
	}
	
	private static LocalDate dataRandomizer() {
		int anno = (int) Math.floor(Math.random() * 23) + 2000;
		int mese = (int) Math.floor(Math.random() * 12) + 1;
		int giorno;
		
		if(mese == 2) {
			giorno = (int) Math.floor(Math.random() * 28) + 1;
		} else {
			 giorno = (int) Math.floor(Math.random() * 31) + 1;
		}		
		
		LocalDate data = LocalDate.of(anno, mese, giorno);
		
		return data;
		
	}
	
	// RIEMPIE L'ARCHIVIO
	public static void riempiArchivio(SupportoCartaceo[] arr) {
		for(int i = 0; i < arr.length ;i++) {
			catalogo.add(arr[i]);
			System.out.print(i + ": ");
			catalogo.get(i).getElemento();
		}
	}
	
	// AGGIUNGE UN ELEMENTO
	public static void aggiungiElemento(SupportoCartaceo elem) {

		Stream.Builder<SupportoCartaceo> builder = Stream.builder();
		Stream<SupportoCartaceo> arrStream = catalogo.stream();
		arrStream.forEach(e -> {
			builder.add(e);
		});
		builder.add(elem);
		catalogo = builder.build().collect(Collectors.toList());
		System.out.println("Nuovo elemento aggiunto: ");
		catalogo.get(catalogo.size()-1).getElemento();
		System.out.println();
	}
	
	// RIMUOVE UN ELEMENTO PER ISBN
	public static void rimuoviElemento(String id) {
		Stream.Builder<SupportoCartaceo> builder = Stream.builder();
		Stream<SupportoCartaceo> arrStream = catalogo.stream();
		
		arrStream.filter(e -> !e.CodiceISBN.equals(id))
		.forEach(e -> builder.add(e));;
		
		catalogo = builder.build().collect(Collectors.toList());
		
		// PER VERIFICARE GLI ELEMENTI
//		System.out.println("Esercizio 2: Rimuove per ISBN");
//		for(int i = 0; i < catalogo.size(); i++) {
//			System.out.print(i + ": ");
//			catalogo.get(i).getElemento();
//		}
		
		// TENTATIVO CON ALTRO METODO
//		Stream<SupportoCartaceo>  nuovoArr = catalogo.stream()
//		.filter(e -> !e.CodiceISBN.equals(id))
//		.forEach(e -> e.getElemento());
//		
	}
	
	// RICERCA PER ANNO DI PUBBLICAZIONE
	public static void ricercaPerAnno(int anno) {
		Stream<SupportoCartaceo> arrStream = catalogo.stream();
		Stream.Builder<SupportoCartaceo> builder = Stream.builder();
		
		System.out.println("ESERCIZIO 3");
		arrStream
		.filter(e -> e.annoPubblicazione.getYear() == anno)
		.forEach(e -> {
			e.getElemento();
			builder.add(e);
		});
		
		List<SupportoCartaceo> arr = builder.build().collect(Collectors.toList());
		if(arr.size() == 0) {
			System.out.println("Non ci sono libri o riviste che corrispondono al criterio di ricerca ");
			System.out.println();
		}

	}
	
	public static void ricercaPerAutore(String author) {
		Stream<SupportoCartaceo> arrStream = catalogo.stream();
		Stream.Builder<SupportoCartaceo> builder = Stream.builder();
		
		System.out.println("ESERCIZIO 4");
		arrStream
		.filter(e -> e instanceof Libro && ((Libro) e).autore.equals(author))
		.forEach(e -> {
			e.getElemento();
			builder.add(e);
		});
		
		// MESSAGGIO DI ERRORE NEL CASO IN CUI NON CI SIANO LIBRI CON L?AUTORE INSERITO
		List<SupportoCartaceo> arr = builder.build().collect(Collectors.toList());
		if(arr.size() == 0) {
			System.out.println("Non ci sono libri che corrispondono al criterio di ricerca");
			System.out.println();
		}
		
	}

}
