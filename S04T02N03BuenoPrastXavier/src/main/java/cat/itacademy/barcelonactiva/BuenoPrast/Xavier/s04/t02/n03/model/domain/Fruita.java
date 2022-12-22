package cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value="fruites")



public class Fruita {
	
	@Id
	private int id;
	private String nom;
	private int quantitatQuilos;
	
	public Fruita() {
	}
	
	public Fruita(int id,String nom, int quantitatQuilos ) {
		
		this.id=id;
		this.nom=nom;
		this.quantitatQuilos=quantitatQuilos;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		
		return nom;
	}

	public int getQuantitatQuilos() {
		
		return quantitatQuilos;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setNom(String nom) {
		
		this.nom=nom;
	}
	
	public void setQuantitatQuilos(int quantitatQuilos) {
		
		this.quantitatQuilos=quantitatQuilos;
	}
}
