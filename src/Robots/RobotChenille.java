package Robots;
import Exception.VitesseUnpermited;
import gui.ImageElement;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotChenille extends Robot {
	
	public RobotChenille(Case position, int quantiteEau, int vitesse) throws VitesseUnpermited {
		super(position, quantiteEau, vitesse);
		if(vitesse>150) {
			throw new VitesseUnpermited("vitesse maximal ne doit pas depasser 150 km/h"
					+ " vitesse trouvé"+ vitesse +" km/h");
		}else if(vitesse<0) {
			throw new VitesseUnpermited("vitesse negative :" + vitesse + " km/h");
		}

		int taille =50;
		String fileName= "img/robotchenille.png";
		graphic = new ImageElement(position.getColonne()*taille,position.getLigne()*taille,fileName,taille,taille,obs);	}
	public RobotChenille(Case position, int quantiteEau) throws VitesseUnpermited {
		this(position, quantiteEau, 60);
	}

	@Override
	public double getVitesse(NatureTerrain nature) {
		switch(nature) {
		case FORET:
			return vitesse/2;
		case TERRAIN_LIBRE:
		case HABITAT:
			return vitesse;
		default:
			return 0;
		}
	}

	@Override
	public int getInterventionVolume() {
		return 100;
	}

	@Override
	public int getInterventionTime() {
		return 8;
	}

	@Override
	public int getRemplisagetime() {
		return 600;
	}

	@Override
	public int getMaxQuantite() {
		return 2000;
	}

}
