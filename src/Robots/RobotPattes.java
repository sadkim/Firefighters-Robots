package Robots;
import gui.ImageElement;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotPattes extends Robot {

	public RobotPattes(Case position, int quantiteEau) {
		super(position, quantiteEau, 30);
		int taille =40;
		String fileName=NatureTerrain.ROCHE.getFilePath();
		graphic = new ImageElement(0,0,fileName,50,50,obs);
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
