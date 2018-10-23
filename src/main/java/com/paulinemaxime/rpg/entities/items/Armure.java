package com.paulinemaxime.rpg.entities.items;

public abstract class Armure {
	protected int pArmure;
	protected String name;

	
	public Armure(int pArmure, String name) {
		this.pArmure = pArmure;
		this.name = name;
	}


	public int getpArmure() {
		return pArmure;
	}


	public String getName() {
		return name;
	}
	
}
	
