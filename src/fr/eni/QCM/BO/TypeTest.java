package fr.eni.QCM.BO;

public class TypeTest {
	
	// ATTRIBUTS
	public int id;
	public String libelle;
	
	// CONSTRUCTEURS
	public TypeTest(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
	
	
	
}