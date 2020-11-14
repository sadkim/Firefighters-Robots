package Robots;
import java.awt.image.ImageObserver;

import Exception.incompatibleVolume;
import Exception.insuficcientQuantity;
import gui.GraphicalElement;
import mapping.*;

abstract public class Robot {
	
	
	protected Case position;
	protected int quantiteEau = 0;
	protected int vitesse;
	
	abstract public GraphicalElement getGraphic() ;


	abstract public ImageObserver getObs() ;


	public Robot(Case position, int quantiteEau, int vitesse) {
		this.position 		= position		;
		this.quantiteEau 	= quantiteEau	;
		this.vitesse 		= vitesse		;
	}
	
	
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		// si case hors map ?
		this.position = position;
	}
	
	
	public int getQuantiteEau() {
		return quantiteEau;
	}
	
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public void deverserEau(int vol, Incendie incendie) throws incompatibleVolume, insuficcientQuantity {
		//TODO Réduire quantité d'eau nécessaire au cas d'incendie
		if((vol % getInterventionVolume())!=0) {
			throw new incompatibleVolume("should be a multiple of " +
				getInterventionVolume() + " L found" + vol+ " L");
		}
		if(quantiteEau < vol ) {
			throw new insuficcientQuantity("quntity in resevoire is insuficient found" +
				getQuantiteEau() + " L tied to use" + vol + " L resevoire max quantity is "
					+ getMaxQuantite() );
		}
		int val_init = incendie.getVolPourEteindre();
		incendie.setVol(vol);
		int val_end = incendie.getVolPourEteindre();
		this.quantiteEau -= (val_init - val_end);
		
	}
	
	public void remplirReservoir() {
		this.quantiteEau=getMaxQuantite();
	};
	
	abstract public double 	getVitesse(NatureTerrain nature);	
	abstract public int 	getInterventionVolume();
	abstract public int 	getInterventionTime();
	abstract public int 	getRemplisagetime();
	abstract public int 	getMaxQuantite();
	
}
