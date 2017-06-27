package fr.eni.QCM.BO;

public class SectionTest {
	
	// ATTRIBUTS
	public Test test;
	public Section section;
	
	// CONSTRUCTEURS
	public SectionTest() {

	}
	
	public SectionTest(Test test, Section section) {
		this.test = test;
		this.section = section;
	}

	// TEST
	public Test getTest() {return test;}
	public void setTest(Test test) {this.test = test;}

	// SECTION
	public Section getSection() {return section;}
	public void setSection(Section section) {this.section = section;}
	
	
	
	
}
