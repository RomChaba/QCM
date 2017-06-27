package fr.eni.QCM.BO;

public class Section {
	
	//ATTRIBUTS
	public int id;
	public String libelle;
	public Formateur formateur;
	
	// CONSTRUCTEURS
	public Section() {

	}
	
	public Section(int id, String libelle, Formateur formateur) {
		this.id = id;
		this.libelle = libelle;
		this.formateur = formateur;
	}

	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}

	// FORMATEUR
	public Formateur getFormateur() {return formateur;}
	public void setFormateur(Formateur formateur) {this.formateur = formateur;}
	
	
	
}
