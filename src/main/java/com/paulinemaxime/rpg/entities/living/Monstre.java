package com.paulinemaxime.rpg.entities.living;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;

public class Monstre extends Perso {


    public Monstre(String name, int pv, int pa, ClasseRpg classe) {
        super(name, pv, pa, classe);
    }

    public String getName(){
		return name;
	}
	public int getCurrent_pv(){
		return current_pv;
	}
	public int getPa(){
		return pa;
	}
}
