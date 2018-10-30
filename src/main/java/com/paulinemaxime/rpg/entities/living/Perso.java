package com.paulinemaxime.rpg.entities.living;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;

public abstract class Perso {

	protected ClasseRpg classe;

	protected String name;
	protected int pv;
	protected int pa;
	
	public Perso(String name, int pv, int pa, ClasseRpg classe) {
	    this.classe = classe;
	    this.name = name;
	    this.pv = pv;
	    this.pa = pa;
    }
	
}
