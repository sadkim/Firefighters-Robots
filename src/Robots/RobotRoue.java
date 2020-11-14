package Robots;
import Exception.VitesseUnpermited;
import gui.ImageElement;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotRoue extends Robot {
	

	public RobotRoue(Case position, int quantiteEau, int vitesse) throws VitesseUnpermited {
		super(position, quantiteEau, vitesse);
		if(vitesse<0) {
			throw new VitesseUnpermited("vitesse negative :" + vitesse + " km/h");
		}
		int taille =50;
		String fileName = "img/robotroue.png";
		graphic = new ImageElement(position.getColonne()*taille,position.getLigne()*taille,fileName,taille,taille,obs);	}

	public RobotRoue(Case position, int quantiteEau) throws VitesseUnpermited {
		this(position, quantiteEau, 80);
	}
	@Override
	public double getVitesse(NatureTerrain nature) {
		switch(nature) {
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
		return 5;
	}

	@Override
	public int getRemplisagetime() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getMaxQuantite() {
		return 10000;
	}

}
