package fr.eni.QCM.BO;

public class TypeCandidat {
	// ATTRIBUTS
	private int id;
	private String libelle;
	
	// CONSTRUCTEUR
	public TypeCandidat(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}

	// FONCTIONS
	@Override
	public String toString() {
		return "TypeCandidat [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
}
