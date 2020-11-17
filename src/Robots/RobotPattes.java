package Robots;
import gui.ImageElement;
import mapping.Carte;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotPattes extends Robot {

	public RobotPattes(Case position, int quantiteEau, Carte maCarte) {
		super(position, quantiteEau, 30);
		this.maCarte = maCarte;
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
	
	@Override
	public boolean caseAccessible(Case maCase) {
		if (maCase.getNature().equals(NatureTerrain.valueOf("EAU"))) {
			return false;
		}
		return true;
	}
	
}
