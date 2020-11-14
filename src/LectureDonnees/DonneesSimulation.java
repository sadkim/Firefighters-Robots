package LectureDonnees;

import mapping.*;

import java.awt.Color;

import Gui.Simulateur;
import Robots.*;
import gui.GUISimulator;


public class DonneesSimulation {
		public Carte carte;
		public Robot[] robots;
		public Incendie [] incendies;
		public GUISimulator gui= new GUISimulator(1200,1200,Color.red,new Simulateur());
		
		
		
		public DonneesSimulation(Carte carte,  Incendie[] incendies, Robot[] robots) {
			this.carte = carte;
			this.robots = robots;
			this.incendies = incendies;
			for(int i=0; i<carte.getNbLignes();i++) {
				for(int j = 0; j<carte.getNbColonnes();j++) {
					gui.addGraphicalElement(carte.getCase(i, j).getGraphic());
				}
			}
		}
		
}
