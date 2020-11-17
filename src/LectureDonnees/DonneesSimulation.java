package LectureDonnees;

import mapping.*;

import java.awt.Color;

import Gui.Simulateur;
import Robots.*;
import gui.GUISimulator;
import java.util.ArrayList;
import java.util.List;

public class DonneesSimulation {
		public Carte carte;
		public Robot[] robots;
		public List<Incendie> incendies = new ArrayList<Incendie>(); 
		private GUISimulator gui;		
		
		
		public DonneesSimulation(Carte carte,  List<Incendie> incendies, Robot[] robots) {
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
			for(int i=0; i < incendies.size();i++) {
					gui.addGraphicalElement(incendies.get(i).getGraphic());
			}
		
	}
    public GUISimulator getGui(){
        return this.gui;
    }
		
}
