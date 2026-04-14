package objekte;

public class Methodik extends MutterObjekt {
	
	private String name;
	private String beschreibung;
	
	public Methodik() {
		super();
	}
	
	public Methodik(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
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
