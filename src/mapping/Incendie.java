package mapping;
import gui.GraphicalElement;
import gui.ImageElement;

public class Incendie {
	private Case position;
	private int volPourEteindre;
	private GraphicalElement  graphic;

	public Incendie(Case position, int volPourEteindre) {
		this.position = position;
		this.volPourEteindre = volPourEteindre;
		String fileName="img/fire.png";
		int taille =50;
		graphic = new ImageElement(position.getColonne()*taille,position.getLigne()*taille,fileName,taille,taille,null);
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
    public GraphicalElement getGraphic(){
        return graphic;
    }
}
