package objekte;

public abstract class MutterObjekt {
	
	private int id; // entspicht dem primary key in der relationalen datenbank

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
