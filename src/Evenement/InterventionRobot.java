package Evenement;
import  mapping.*;
import  Robots.*;
import  java.util.List;
import gui.ImageElement;

import Exceptions.*;


public class InterventionRobot extends Evenement{
	private Robot monRobot;
    List<Incendie>   incendies ;


    public InterventionRobot(Robot monRobot,long date,List<Incendie> incendies ){
        super(date);
        this.monRobot = monRobot;
        this.incendies  = incendies;
    }

	@Override
	public void execute(){
		
		try {
			monRobot.deverserEau(monRobot.getInterventionVolume());
		} catch (incompatibleVolume e) {
			e.printStackTrace();
		} catch (insuficcientQuantity e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(int i = 0; i< this.incendies.size(); i++){
            if(monRobot.getPosition().equals(this.incendies.get(i).getPosition())){
		this.incendies.get(i).setVol(this.incendies.get(i).getVolPourEteindre()-monRobot.getInterventionVolume());
        if(this.incendies.get(i).getVolPourEteindre()==0){
            ImageElement img = (ImageElement)this.incendies.get(i).getGraphic();
            img.translate((-this.incendies.get(i).getPosition().getColonne()-1)*50,(-this.incendies.get(i).getPosition().getLigne()-1)*50 );
            this.incendies.remove(i);
        }
        break;
            }
        }
	}
}
