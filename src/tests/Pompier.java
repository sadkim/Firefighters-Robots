package tests;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

import Exception.VitesseUnpermited;
import LectureDonnees.DonneesSimulation;
import io.LecteurDonnees;

public class Pompier {

	public static void main(String[] args) throws FileNotFoundException, DataFormatException, VitesseUnpermited {
		// TODO Auto-generated method stub
		System.out.println(args[0]);
		DonneesSimulation sim = LecteurDonnees.creeDonnees(args[0]);

	}

}
