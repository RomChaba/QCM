package fr.eni.QCM.BO;

public abstract class Utilisateur {

	// ATTRIBUTS
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String login;
	private String password;
	
	// CONSTRUCTEUR
	public Utilisateur(int id, String nom, String prenom, String mail, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur(){
		
	}
	
	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// NOM
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}

	// PRENOM
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}

	// MAIL
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	// LOGIN
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}

	// PASSWORD
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	// FONCTIONS
	@Override
	public String toString() {
		return "Utilisateur [id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom()
				+ ", mail=" + getMail() + ", login=" + getLogin() + ", password="
				+ getPassword() + "]";
	}
	
	
	
}
