

public class Case {
	private int ligne;
	private int colonne;
	private NatureTerrain nature;
	public int getLigne() {
		return ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public NatureTerrain getNature() {
		return nature;
	}
	public Case(int ligne, int colonne, NatureTerrain nature) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
		this.nature = nature;
	}
	
}
