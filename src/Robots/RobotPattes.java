package Robots;
import Exception.incompatibleVolume;
import Exception.insuficcientQuantity;
import mapping.Case;
import mapping.NatureTerrain;

public class RobotPattes extends Robot {

	public RobotPattes(Case position, int quantiteEau) {
		super(position, quantiteEau, 30);
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
	public void deverserEau(int vol) throws incompatibleVolume, insuficcientQuantity {
		return;
	}

}
