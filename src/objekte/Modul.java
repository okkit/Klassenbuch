package objekte;

public class Modul extends MutterObjekt {

	private String name;
	private int nummer;

	public Modul(String name, int nummer) {
		super();
		this.name = name;
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return "Modul [name=" + name + ", nummer=" + nummer + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}
