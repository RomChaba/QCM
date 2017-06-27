package fr.eni.QCM.BO;

import java.util.ArrayList;

public class Test {
	
	// ATTRIBUTS
	public int id;
	public String libelle;
	public int timer;
	public Formateur formateur;
	public TypeTest typeTest;
	public ArrayList<Section> sections;
	
	// CONSTRUCTEURS
	public Test() {

	}
	
	public Test(int id, String libelle, int timer, Formateur formateur,	TypeTest typeTest) {
		this.id = id;
		this.libelle = libelle;
		this.timer = timer;
		this.formateur = formateur;
		this.typeTest = typeTest;
		this.sections = new ArrayList<Section>();
	}

	// ID
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	// LIBELLE
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}

	// TIMER
	public int getTimer() {return timer;}
	public void setTimer(int timer) {this.timer = timer;}

	// FORMATEUR
	public Formateur getFormateur() {return formateur;}
	public void setFormateur(Formateur formateur) {this.formateur = formateur;}

	// TYPE_TEST
	public TypeTest getTypeTest() {return typeTest;}
	public void setTypeTest(TypeTest typeTest) {this.typeTest = typeTest;}

	// SECTIONS
	public ArrayList<Section> getSections() {return sections;}
	public void addSection(Section section){this.sections.add(section);}
	
	
	
	
}
