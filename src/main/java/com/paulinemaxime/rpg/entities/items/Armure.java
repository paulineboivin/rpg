package com.paulinemaxime.rpg.entities.items;

import com.paulinemaxime.rpg.database.DBItem;

public abstract class Armure extends DBItem {
	protected int pArmure;
	protected String name;
	protected String type;

	
	public Armure(String name, int pArmure, String type) {
		this.pArmure = pArmure;
		this.name = name;
		this.type = type;
	}


	public int getpArmure() {
		return pArmure;
	}


	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
}
	
