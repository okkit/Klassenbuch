package objekte;

public class Methodik extends MutterObjekt {
	
	private String name;
	private String beschreibung;
	
	
	@Override
	public String toString() {
		return "Methodik [name=" + name + ", beschreibung=" + beschreibung + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	
}
