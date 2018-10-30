package com.paulinemaxime.rpg.entities.living;


import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.living.Perso;

public class Hero extends Perso {

	public Hero(String name, int pv, int pa, ClasseRpg classe) {
		super(name, pv, pa, classe);
	}

	public String getName(){
		return name;
	}
	public int getPv(){
		return pv;
	}
	public int getPa(){
		return pa;
	}
	
	
	
}
