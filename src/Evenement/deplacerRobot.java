package Evenement;
import mapping.*;
import Exception.InvalidCase;
import Robots.*;

public class deplacerRobot extends Evenement{
	private Robot monRobot;
	private Direction dir;
	private Carte maCarte;
	
	public deplacerRobot(long date, Robot monRobot, Direction dir, Carte maCarte) {
		super(date);
		this.monRobot = monRobot;
		this.dir = dir;
		this.maCarte = maCarte;
	}

	@Override
	public void execute() throws InvalidCase {
		Case newCase = this.maCarte.getVoisin(this.monRobot.getPosition(), dir);
		monRobot.setPosition(newCase);
	}
	
	// il faut tenir compte de la vitesse de deplacement et la distance, qui vont nous donner le temps necessaire pour la terminaison d'execution
	
}
