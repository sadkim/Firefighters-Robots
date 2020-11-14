package Robots;

import Exception.VitesseUnpermited;
import gui.ImageElement;
import mapping.Case;
import mapping.NatureTerrain;

public class Drone extends Robot {
	

	public Drone(Case position, int quantiteEau, int vitesse) throws VitesseUnpermited {
		super(position, quantiteEau, vitesse);
		if(vitesse>150) {
			throw new VitesseUnpermited("vitesse maximal ne doit pas depasser 150 km/h"
					+ " vitesse trouvé"+ vitesse +" km/h");
		}else if(vitesse<0) {
			throw new VitesseUnpermited("vitesse negative :" + vitesse + " km/h");
		}
		int taille =40;
		String fileName=NatureTerrain.ROCHE.getFilePath();
		graphic = new ImageElement(0,0,fileName,50,50,obs);
	}
	public Drone(Case position, int quantiteEau) throws VitesseUnpermited {
		this(position,quantiteEau,150);
	}

	@Override
	public double getVitesse(NatureTerrain nature) {
		// TODO Auto-generated method stub
		return vitesse;
	}

	@Override
	public int getInterventionVolume() {
		return 10000;
	}

	@Override
	public int getInterventionTime() {
		return 30;
	}

	@Override
	public int getMaxQuantite() {
		return 10000;
	}

	@Override
	public int getRemplisagetime() {
		return 30*60;
	}
	

}
