package fr.eni.QCM.BO;


public class Proposition {
	
	// ATTRIBUTS
	public int id;
	public String libelle;
	public boolean reponse;
	public Question question;
	
	// CONSTRUCTEURS
	public Proposition() {
		
	}
	
	public Proposition(int id, String libelle, boolean reponse,	Question question) {
		this.id = id;
		this.libelle = libelle;
		this.reponse = reponse;
		this.question = question;
	}

	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}

	// REPONSE
	public boolean isReponse() {return reponse;}
	public void setReponse(boolean reponse) {this.reponse = reponse;}

	// QUESTION
	public Question getQuestion() {return question;}
	public void setQuestion(Question question) {this.question = question;}
	
	
	
	
}
