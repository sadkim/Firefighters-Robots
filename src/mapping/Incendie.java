package mapping;

public class Incendie {
	private Case position;
	private int volPourEteindre;
	
	public Incendie(Case position, int volPourEteindre) {
		this.position = position;
		this.volPourEteindre = volPourEteindre;
	}

	public Case getPosition() {
		return position;
	}

	public int getVolPourEteindre() {
		return volPourEteindre;
	}
	public void setVol(int vol) {
		this.volPourEteindre = Math.max(0, this.volPourEteindre - vol);
	}
}
