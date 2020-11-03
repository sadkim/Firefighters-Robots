

abstract public class Robot {
	protected Case position;
	protected int quantiteEau;
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}
	abstract public double getVitesse(NatureTerrain nature);
	abstract public void remplirReservoir();
	abstract public int getInterventionVolume();
	abstract public int getInterventionTime();
	abstract public int getMaxQuantite();
	public int getQuantiteEau() {
		return quantiteEau;
	}
	protected void setQuantiteEau(int quantiteEau) {
		this.quantiteEau = quantiteEau;
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
		setQuantiteEau(quantiteEau-vol);
		
	}
	
}
