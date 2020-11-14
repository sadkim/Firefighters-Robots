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
		
		private GUISimulator gui;		
		
		
		public DonneesSimulation(Carte carte,  Incendie[] incendies, Robot[] robots) {
			this.carte = carte;
			this.robots = robots;
			this.incendies = incendies;
			int height = carte.getNbColonnes() * 55;
			int width = carte.getNbLignes() * 55;
			gui= new GUISimulator(height,width,Color.white,new Simulateur());
			for(int i=0; i<carte.getNbLignes();i++) {
				for(int j = 0; j<carte.getNbColonnes();j++) {
					gui.addGraphicalElement(carte.getCase(i, j).getGraphic());
				
				}
			}
			for(int i=0; i < robots.length;i++) {
					gui.addGraphicalElement(robots[i].getGraphic());
			}
		}
		
}
