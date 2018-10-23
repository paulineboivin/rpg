package com.paulinemaxime.rpg.entities.items;

public abstract class Armes {
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

