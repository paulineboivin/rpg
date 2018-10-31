package com.paulinemaxime.rpg.entities.items;

import java.util.ArrayList;

import com.paulinemaxime.rpg.entities.living.Monstre;

public class Etage {

	
	private ArrayList<Monstre> monstre = new ArrayList<>();
	private int nombreMonstres;
	
	public ArrayList<Monstre> getMonstres() {
		return monstre;
	}
	
	public int getNombreMonstres() {
		return nombreMonstres;
	}
	
	public void setNombreMonstres( int nbrMonstres) {
		this.nombreMonstres = nbrMonstres;
	}

	public void addMonstre(Monstre monstre) {
		this.monstre.add(monstre);
	}

}
