
public class RobotChenille extends Robot {

	public RobotChenille(Case position, int quantiteEau, int vitesse) {
		super(position, quantiteEau, vitesse);
	}
	public RobotChenille(Case position, int quantiteEau) {
		this(position, quantiteEau, 60);
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
	public void remplirReservoir() {
		// TODO Auto-generated method stub

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
