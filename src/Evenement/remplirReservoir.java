package Evenement;

import Exceptions.InvalidCase;
import Robots.*;
import mapping.Carte;
import mapping.NatureTerrain;

public class remplirReservoir extends Evenement{
	private Robot monRobot;
	private Carte maCarte;

	public remplirReservoir(long date, Robot monRobot) {
		super(date);
		this.monRobot = monRobot;
	}

	
	@Override
	public void execute() throws InvalidCase {
		if (this.monRobot instanceof Drone) {
			if (this.monRobot.getPosition().getNature().equals(NatureTerrain.valueOf("EAU"))) {
				this.monRobot.remplirReservoir();
			}
			else {
				throw new IllegalArgumentException("Le Drone se remplit sur une case contenant de l'eau");
			}
		}
		else if (this.monRobot instanceof RobotChenille) {
			throw new IllegalArgumentException("RobotPattes ne se remplit jamais !");
		}
		else {
			if (this.maCarte.voisinEau(this.monRobot.getPosition())) {
				this.monRobot.remplirReservoir();
			}
			else {
				throw new IllegalArgumentException("Ces Robots se remplissent a cote d'une case contenant de l'eau !");
			}
			}
		}
	
	
	
}

