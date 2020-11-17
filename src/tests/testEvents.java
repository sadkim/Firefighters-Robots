package tests;
import Evenement.*;
import io.LecteurDonnees;
import mapping.Case;
import mapping.Direction;
import Exceptions.VitesseUnpermited;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;
import LectureDonnees.*;
public class testEvents {

	public static void main(String[] args)  throws DataFormatException, VitesseUnpermited, FileNotFoundException{
		
		DonneesSimulation donnees = LecteurDonnees.creeDonnees(args[0]);
		Simulateur simulateur = new Simulateur(donnees.getGui(), 0);
		
		 List<Evenement> listOfEvents = donnees.robots[1].EventGen(donnees.carte.getCase(6, 1));
		
		 
		for (int i = 0; i < listOfEvents.size(); i++) {
			simulateur.ajouteEvenement(listOfEvents.get(i));
		}
		// premier test : DRONE DOIT SORTIR DE LA CARTE --> EXEPTION invalideCase
		/*simulateur.ajouteEvenement(new DeplacerRobot(1, donnees.robots[0], Direction.NORD, donnees.carte));
		simulateur.ajouteEvenement(new DeplacerRobot(1, donnees.robots[0], Direction.NORD, donnees.carte));
		simulateur.ajouteEvenement(new DeplacerRobot(1, donnees.robots[0], Direction.NORD, donnees.carte));
		simulateur.ajouteEvenement(new DeplacerRobot(1, donnees.robots[0], Direction.NORD, donnees.carte));
		// deuxieme test : Le feu de la case en question doit s'eteindre
		simulateur.ajouteEvenement(new DeplacerRobot(1, donnees.robots[1], Direction.NORD, donnees.carte));
		simulateur.ajouteEvenement(new InterventionRobot(donnees.robots[1], 2, donnees.incendies));
		simulateur.ajouteEvenement(new DeplacerRobot(3, donnees.robots[1], Direction.OUEST, donnees.carte));
		simulateur.ajouteEvenement(new DeplacerRobot(3, donnees.robots[1], Direction.OUEST, donnees.carte));
		simulateur.ajouteEvenement(new remplirReservoir(4, donnees.robots[1]));
		simulateur.ajouteEvenement(new DeplacerRobot(5, donnees.robots[1], Direction.EST, donnees.carte));
		simulateur.ajouteEvenement(new DeplacerRobot(5, donnees.robots[1], Direction.EST, donnees.carte));
		simulateur.ajouteEvenement(new InterventionRobot(donnees.robots[1], 6, donnees.incendies));*/
	}

}
