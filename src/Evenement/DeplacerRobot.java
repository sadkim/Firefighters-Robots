package Evenement;

import mapping.*;
import Exceptions.InvalidCase;
import Robots.*;
import gui.*;

public class DeplacerRobot extends Evenement{
	private Robot monRobot;
	private Direction dir;
	private Carte maCarte;
	
	public DeplacerRobot(long date, Robot monRobot, Direction dir, Carte maCarte) {
		super(date);
	
		this.monRobot = monRobot;
		this.dir = dir;
		this.maCarte = maCarte;
	}

	@Override
	public void execute() throws InvalidCase{
		Case newCase = this.maCarte.getVoisin(this.monRobot.getPosition(), dir);
		monRobot.setPosition(newCase);
        ImageElement image = (ImageElement)monRobot.getGraphic();
        int x =0;
        int y =0;
        switch(dir){
            case NORD:
                y = -1;
                break;
            case EST:
                x = 1;
                break;
            case OUEST:
                x = -1;
                break;
            case SUD:
                y = 1;


        }
        image.translate(x*50,y*50);
	}
	
	// il faut tenir compte de la vitesse de deplacement et la distance, qui vont nous donner le temps necessaire pour la terminaison d'execution
	
}
