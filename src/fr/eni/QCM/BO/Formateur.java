package fr.eni.QCM.BO;

public class Formateur extends Utilisateur {

	// CONSTRUCTEURS
	public Formateur(int id, String nom, String prenom, String mail, String login, String password) {
		super(id, nom, prenom, mail, login, password);
	}

	public Formateur() {

	}

	// FONCTIONS
	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", mail=" + mail + ", login=" + login + ", password="
				+ password + "]";
	}
}
