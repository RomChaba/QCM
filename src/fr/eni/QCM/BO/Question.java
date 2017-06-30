package fr.eni.QCM.BO;

public class Question {
	
	// ATTRIBUTS
	private int id;
	private String libelle;
	private String image;
	private Section section;
	private TypeQuestion type;
	
	// CONSTRUCTEURS
	public Question() {
		
	}
	
	public Question(int id, String libelle, String image, Section section, TypeQuestion type) {
		this.id = id;
		this.libelle = libelle;
		this.image = image;
		this.section = section;
		this.type = type;
	}

	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}

	// IMAGE
	public String getImage() {return image;}
	public void setImage(String image) {this.image = image;}

	// SECTION
	public Section getSection() {return section;}
	public void setSection(Section section) {this.section = section;}

	// TYPE_QUESTION
	public TypeQuestion getType() {return type;}
	public void setType(TypeQuestion type) {this.type = type;}
	
	
	
	
}
