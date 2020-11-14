package Robots;
import java.awt.image.ImageObserver;

import gui.GraphicalElement;
import gui.ImageElement;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotPattes extends Robot {
	protected ImageObserver obs;
	@Override
	public GraphicalElement getGraphic() {
		return graphic;
	}

	@Override
	public ImageObserver getObs() {
		return obs;
	}
	public RobotPattes(Case position, int quantiteEau) {
		super(position, quantiteEau, 30);
		int taille =50;
		String fileName= "img/robotpattes.png";
		graphic = new ImageElement(position.getColonne()*taille,position.getLigne()*taille,fileName,taille,taille,obs);
	}

	@Override
	public double getVitesse(NatureTerrain nature) {
		switch(nature) {
		case EAU:
			return 0;
		case ROCHE:
			return 10;
		default:
			return vitesse;
		}
	}

	@Override
	public int getInterventionVolume() {
		return 10;
	}

	@Override
	public int getInterventionTime() {
		return 1;
	}

	@Override
	public int getRemplisagetime() {
		return 0;
	}

	@Override
	public int getMaxQuantite() {
		return 0;
	}
}
