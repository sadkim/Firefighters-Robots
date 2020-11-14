package LectureDonnees;

import mapping.*;
import Robots.*;


public class DonneesSimulation {
		public Carte carte;
		public Robot[] robots;
		public Incendie [] incendies;
		
		
		public DonneesSimulation(Carte carte, Robot[] robots, Incendie[] incendies) {
			this.carte = carte;
			this.robots = robots;
			this.incendies = incendies;
		}
		
}
