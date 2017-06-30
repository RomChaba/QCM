package fr.eni.QCM.BO;

public class Candidat extends Utilisateur{
	
	// ATTIBUTS
	private TypeCandidat TypeCandidat;

	// CONSTRUCTEURS
	public Candidat(int id, String nom, String prenom, String mail,	String login, String password) {
		super(id, nom, prenom, mail, login, password);
	}

	public Candidat() {

	}

	// TYPE_CANDIDAT
	public TypeCandidat getTypeCandidat() {return TypeCandidat;}
	public void setTypeCandidat(TypeCandidat typeCandidat) {TypeCandidat = typeCandidat;}

	// FONCTIONS
	@Override
	public String toString() {
		return "Formateur [id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom()
				+ ", mail=" + getMail() + ", login=" + getLogin() + ", password="
				+ getPassword() + "type=" + getTypeCandidat().getLibelle() +"]";
	}
	
	

}
