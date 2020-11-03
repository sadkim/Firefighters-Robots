

abstract public class Robot {
	protected Case position;
	protected int quantité_eau;
	public Case getPosition() {
		return position;
	}
	public void setPosition(Case position) {
		this.position = position;
	}
	abstract double getVitesse(NatureTerrain nature);
}
