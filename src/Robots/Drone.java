package Robots;


import Exceptions.VitesseUnpermited;
import gui.ImageElement;
import mapping.Carte;
import mapping.Case;
import mapping.NatureTerrain;

public class Drone extends Robot {
	

	public Drone(Case position, int quantiteEau, int vitesse, Carte maCarte) throws VitesseUnpermited {
		super(position, quantiteEau, vitesse);
		this.maCarte = maCarte;
		if(vitesse>150) {
			throw new VitesseUnpermited("vitesse maximal ne doit pas depasser 150 km/h"
					+ " vitesse trouvé"+ vitesse +" km/h");
		}else if(vitesse<0) {
			throw new VitesseUnpermited("vitesse negative :" + vitesse + " km/h");
		}

		int taille =50;
		String fileName= "img/drone.png";
		graphic = new ImageElement(position.getColonne()*taille,position.getLigne()*taille,fileName,taille,taille,obs);
	}
	public Drone(Case position, int quantiteEau, Carte maCarte) throws VitesseUnpermited {
		this(position,quantiteEau,150,maCarte);
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
	@Override
	public boolean caseAccessible(Case maCase) {
		return true;
	}
	
	
	

}
