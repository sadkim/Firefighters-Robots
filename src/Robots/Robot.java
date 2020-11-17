package Robots;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Dijkstra.Dijkstra;
import Dijkstra.Graph;
import Dijkstra.Node;
import Evenement.DeplacerRobot;
import Evenement.Evenement;
import Exceptions.InvalidCase;
import Exceptions.incompatibleVolume;
import Exceptions.insuficcientQuantity;
import gui.GraphicalElement;
import mapping.*;

abstract public class Robot {
	
	
	protected Case position;
	protected int quantiteEau = 0;
	protected int vitesse;
	protected Graph graph = new Graph(new HashMap<>());
 	protected GraphicalElement  graphic;
	protected ImageObserver obs;
	protected Carte maCarte;
	public GraphicalElement getGraphic() {
		return graphic;
	} ;


	public ImageObserver getObs() {
		return obs;
	}


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
	
	/*public long tempsArrivee(Case dest) {
		if(this.vitesse != 0) {
			return 
		}
	}*/
	
	public void deverserEau(int vol) throws incompatibleVolume, insuficcientQuantity {

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
		
		
	}
	
	public void VerifyAndAdd(int i, int j) {
		if(!(this.graph.getNodes().containsKey(this.maCarte.getCase(i, j)))) {
			Node newNodeCase = new Node(this.maCarte.getCase(i, j));
			this.graph.addNode(newNodeCase);
		}
	}
	
	public void remplirReservoir() {
		this.quantiteEau=getMaxQuantite();
	};
	
	abstract public double 	getVitesse(NatureTerrain nature);	
	abstract public int 	getInterventionVolume();
	abstract public int 	getInterventionTime();
	abstract public int 	getRemplisagetime();
	abstract public int 	getMaxQuantite();
	abstract public boolean caseAccessible(Case maCase);
	
	
	public long coutEdge(Case maCase) {
		return (long) (this.maCarte.getTailleCase()*3600/(this.getVitesse(maCase.getNature())*1000));
	}
	
	public void createGraph() {
		ArrayList<Direction> listDirections = new ArrayList<Direction>(Arrays.asList(Direction.NORD,Direction.SUD,Direction.EST,Direction.OUEST));
		for (int i = 0; i < this.maCarte.getNbLignes(); i++) {
			for (int j = 0; j < this.maCarte.getNbColonnes(); j++) {
				VerifyAndAdd(i, j);
				for (int h = 0; h < listDirections.size(); h++) {
				
					try {
						Node src = this.graph.getNodes().get(this.maCarte.getCase(i, j));
						Case voisin = maCarte.getVoisin(this.maCarte.getCase(i, j), listDirections.get(h));
						if (caseAccessible(voisin)) {
							VerifyAndAdd(voisin.getLigne(), voisin.getColonne());
							Node dest = this.graph.getNodes().get(this.maCarte.getCase(voisin.getLigne(), voisin.getColonne()));
							src.addDestination(dest, coutEdge(voisin)); 
							this.graph.addNode(dest);
						}
					}
						catch (InvalidCase e) {
	
						}
				}
			}
		}
	}

	
	public Direction getDirectionFromDst(Case source, Case dst) {
		ArrayList<Direction> listDirections = new ArrayList<Direction>(Arrays.asList(Direction.OUEST,Direction.EST,Direction.SUD,Direction.NORD));
		int y= dst.getLigne() - source.getLigne();
		int x= dst.getColonne() - source.getColonne();
		int h = (int)(((x-y+1)/2)+2*Math.abs(y));
		return listDirections.get(h);
	}
	
	public List<Evenement> EventGen(Case dst) {
		List<Evenement> listOfEvents = new LinkedList<>();
		this.createGraph();
		this.graph = Dijkstra.executeDijkstra(this.graph, this.graph.getNodes().get(this.position));
		List<Node> shortestPath = this.graph.getNodes().get(dst).getShortestPath();
		Case source = this.getPosition();
		for(int i=0; i<shortestPath.size(); i++) {
			Case dest = shortestPath.get(i).getNodeCase();
			DeplacerRobot deplacement = new DeplacerRobot((long) i,this,getDirectionFromDst(source, dest),this.maCarte);
			source = dest;
			listOfEvents.add(i, deplacement);
		}
		DeplacerRobot deplacement = new DeplacerRobot((long) shortestPath.size(),this,getDirectionFromDst(source, dst),this.maCarte);
		listOfEvents.add(shortestPath.size(), deplacement);
		return listOfEvents;
	} 
}
