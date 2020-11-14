package mapping;


import Exception.InvalidCase;

public class Carte {
	private int tailleCases;
	private int nbLignes, nbColonnes;
	private Case[][] matriceCase;
	

	public Carte(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}
	
	public Carte(int nbLignes, int nbColonnes, int tailleCases, Case[][] matrice) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.matriceCase = matrice;
		this.tailleCases = tailleCases;
	}

	public int getTailleCase() {
		return tailleCases;
	}
	public int getNbLignes() {
		return nbLignes;
	}
	public int getNbColonnes() {
		return nbColonnes;
	}
	public Case getCase(int lig, int col) {
		return matriceCase[lig][col];
	}
	
	public boolean voisinExiste(Case src, Direction dir) {
		switch (dir) {
			case NORD:
				return src.getLigne() > 0;
			case SUD:
				return src.getLigne() < nbLignes;
			case OUEST:
				return src.getColonne() > 0;
			default:
				return src.getColonne() < nbColonnes;
		}
	}
	
	public Case getVoisin(Case src, Direction dir) throws InvalidCase {
		if (voisinExiste(src, dir)) {
			switch (dir) {
			case NORD:
				return getCase(src.getLigne()-1, src.getColonne());
			case SUD:
				return getCase(src.getLigne()+1, src.getColonne());
			case EST:
				return getCase(src.getLigne(), src.getColonne()+1);
			default:
				return getCase(src.getLigne(), src.getColonne()-1);
		}
		}
		throw new InvalidCase("pas de voisin");
	}
	

}