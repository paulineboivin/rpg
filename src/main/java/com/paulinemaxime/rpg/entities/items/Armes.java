package com.paulinemaxime.rpg.entities.items;

import com.paulinemaxime.rpg.database.DBItem;

public abstract class Armes extends DBItem{
	protected int degat;
	protected int pa;
	protected String name;
	
	public Armes(int degat, int pa, String name) {
		this.degat = degat;
		this.pa = pa;
		this.name = name;
	}

	public int getDegat() {
		return degat;
	}

	public int getPa() {
		return pa;
	}

	public String getName() {
		return name;
	}
	
}


