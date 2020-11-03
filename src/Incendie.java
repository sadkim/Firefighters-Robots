
public class Incendie {
	private Case position;
	private int volPourEteindre;
	
	public Incendie(Case position, int volPourEteindre) {
		super();
		this.position = position;
		this.volPourEteindre = volPourEteindre;
	}

	public Case getPosition() {
		return position;
	}

	public int getVolPourEteindre() {
		return volPourEteindre;
	}
	
}
