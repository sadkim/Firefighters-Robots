package Evenement;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import Exceptions.InvalidCase;
import Exceptions.incompatibleVolume;
import Exceptions.insuficcientQuantity;
import gui.*;


public class Simulateur implements Simulable {
	private long dateCourante = 0;
	protected SortedMap<Long, List<Evenement>> eventsByDate = new TreeMap<>();
	private GUISimulator gui;
	
	public Simulateur(GUISimulator gui, long date) {
		this.gui = gui;
		gui.setSimulable(this);	
		this.dateCourante = date;
	}
	
	
	public Simulateur(GUISimulator gui) {
		this(gui, 0);
	}
	
	@Override
	public void next(){
		System.out.println("-----------------------");
		System.out.println("-----------------------");

		incrementeDate();
		if(!simulationTerminee()) {
			if (eventsByDate.containsKey(this.dateCourante)) {
				for (int i=0; i<eventsByDate.get(this.dateCourante).size(); i++) {
					try {
						eventsByDate.get(this.dateCourante).get(i).execute();
					} catch (InvalidCase e) {
						System.out.println("evenement non execute : case invalide " + i);
						e.printStackTrace();
                        System.exit(-1);
					} catch (incompatibleVolume e) {
						System.out.println("evenement non execute : incompatible volume " + i);
						e.printStackTrace();
                        System.exit(-1);
					} catch (insuficcientQuantity e) {
						System.out.println("evenement non execute : quantite insuffisante " + i);
						e.printStackTrace();
                        System.exit(-1);
					}
				}
			}
		}
		
	}
	
	private void incrementeDate() {
		this.dateCourante += 1;
	}
	
	public void ajouteEvenement(Evenement e) {
		if (eventsByDate.containsKey(e.getDate())) {
			eventsByDate.get(e.getDate()).add(e);
		}
		else {
			ArrayList<Evenement> listeEvents = new ArrayList<Evenement>();
			listeEvents.add(e);
			eventsByDate.put(e.getDate(), listeEvents);
		}
	}
	
	
	private boolean simulationTerminee() {
		return this.dateCourante>eventsByDate.lastKey();
	}
	
	@Override
	public void restart() {
		this.dateCourante = 0;
		this.gui.reset();
	}
	
}
