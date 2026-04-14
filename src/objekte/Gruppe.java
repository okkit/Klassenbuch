package objekte;

import java.util.ArrayList;
import java.util.List;

public class Gruppe extends MutterObjekt {

	private String name; // Z.B. U29
	private String bildungsgang; // Z.B. AE

	// Gruppe besteht aus Studenten
	// List ist keine Klasse sondern ein Interface
	private List<String> studenten;

	// Frage: Welche(n) Konstruktor(en) soll die Klasse anbieten?

	public Gruppe(String name, String bildungsgang) {
		super();
		this.name = name;
		this.bildungsgang = bildungsgang;
		// Von einem Interface kann man keine Instanz bilden,
		// deshalb new ArrayList und NICHT new List. Das geht, weil
		// die Klasse ArrayList implementiert das Interface List.
		studenten = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "Gruppe [name=" + name + ", bildungsgang=" + bildungsgang + ", studenten=" + studenten + "]";
	}

	public void addStudent(String student) {
		if (student == null)
			return;
		studenten.add(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBildungsgang() {
		return bildungsgang;
	}

	public void setBildungsgang(String bildungsgang) {
		this.bildungsgang = bildungsgang;
	}

	public List<String> getStudenten() {
		return studenten;
	}

	public void setStudenten(List<String> studenten) {
		this.studenten = studenten;
	}

}
