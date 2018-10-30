package com.paulinemaxime.rpg.entities.items;

import com.paulinemaxime.rpg.database.DBItem;

public abstract class Armure extends DBItem {
	protected int pArmure;
	protected String name;

	
	public Armure(String name, int pArmure) {
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
	
