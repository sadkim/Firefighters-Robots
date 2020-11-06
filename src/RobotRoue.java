import Exception.VitesseUnpermited;

public class RobotRoue extends Robot {

	public RobotRoue(Case position, int quantiteEau, int vitesse) throws VitesseUnpermited {
		super(position, quantiteEau, vitesse);
		if(vitesse<0) {
			throw new VitesseUnpermited("vitesse negative :" + vitesse + " km/h");
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getVitesse(NatureTerrain nature) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInterventionVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInterventionTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemplisagetime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxQuantite() {
		// TODO Auto-generated method stub
		return 0;
	}

}
