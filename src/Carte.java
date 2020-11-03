public class Carte {
	private int tailleCase;
	private int nbLignes, nbColonnes;
	private Case[][] matriceCase = new Case[nbLignes][];
	for (int i=0 ; i<matriceCase.lengh; i++) 
	    matriceCase[i] = new Case[nbColonnes];
	
 
	public Carte(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}


	public int getTailleCase() {
		return tailleCase;
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
				break;
			case SUD:
				return src.getLigne() < nbLignes;
				break;
			case OUEST:
				return src.getColonne() > 0;
				break;
			case EST:
				return src.getColonne() < nbColonnes;
				break; 
		}
	}
	
	public Case getVoisin(Case src, Direction dir) {
		if (voisinExiste(src, dir)) {
			switch (dir) {
			case NORD:
				return getCase(src.getLigne()-1, src.getColonne());
				break;
			case SUD:
				return getCase(src.getLigne()+1, src.getColonne());
				break;
			case EST:
				return getCase(src.getLigne(), src.getColonne()+1);
				break;
			case OUEST:
				return getCase(src.getLigne(), src.getColonne()-1);
				break; 
		}
		}
	}
}