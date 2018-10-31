package com.paulinemaxime.rpg.entities.items;

import java.util.ArrayList;
	
public class Donjon {
	
	private ArrayList<Etage> etage;
	private int nombreEtages; 
	
	public ArrayList<Etage> getEtages() {
		return etage;
	}
	
	public int getNombreEtages() {
		return nombreEtages;
	}
	
	public void setNombreEtages(int nbrEtages) {
		this.nombreEtages = nbrEtages;
	}
	
	public void addEtage(Etage etage) {
		this.etage.add(etage);
	}
}


