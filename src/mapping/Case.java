package mapping;

import java.awt.image.ImageObserver;

import gui.GraphicalElement;
import gui.ImageElement;


public class Case {
	private int ligne;
	private int colonne;
	private NatureTerrain nature;
	private GraphicalElement  graphic;
	private ImageObserver obs;
	
	public ImageObserver getObs() {
		return obs;
	}


	public Case(int ligne, int colonne, NatureTerrain nature) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.nature = nature;
		String fileName=nature.getFilePath();
		int taille =50;
		graphic = new ImageElement(this.colonne*taille,this.ligne*taille,fileName,taille,taille,obs);
	}
	
	
	public int getLigne() {
		return ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public NatureTerrain getNature() {
		return nature;
	}


	public GraphicalElement getGraphic() {
		return graphic;
	}
	
	
}
