

abstract public class Robot {
	
	protected Case position;
	protected int quantiteEau;
	protected int vitesse;
	
	public Robot(Case position, int quantiteEau, int vitesse) {
		this.position 		= position		;
		this.quantiteEau 	= quantiteEau	;
		this.vitesse 		= vitesse		;
	}
	
	
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}
	
	
	public int getQuantiteEau() {
		return quantiteEau;
	}
	
		
	
	
	public void deverserEau(int vol) throws incompatibleVolume, insuficcientQuantity {
		//TODO Réduir quantité d'eau nécessaire au cas d'incendie
		if((vol % getInterventionVolume())!=0) {
			throw new incompatibleVolume("should be a multiple of " +
				getInterventionVolume() + " L found" + vol+ " L");
		}
		if(quantiteEau < vol ) {
			throw new insuficcientQuantity("quntity in resevoire is insuficient found" +
				getQuantiteEau() + " L tied to use" + vol + " L resevoire max quantity is "
					+ getMaxQuantite() );
		}
		this.quantiteEau = quantiteEau-vol;
		
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
