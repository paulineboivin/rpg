package com.paulinemaxime.rpg.entities.items;

import com.paulinemaxime.rpg.database.DBItem;

public abstract class Armes extends DBItem{
	protected int degat;
	protected int pa;
	protected String name;
	protected String type;
	
	public Armes(String name, int degat, int pa, String type) {
		this.degat = degat;
		this.pa = pa;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}
	
}


