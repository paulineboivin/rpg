package com.paulinemaxime.rpg.entities.living;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;

public abstract class Perso {

	protected ClasseRpg classe;
	protected Armure armure;
	protected Armes arme;

	protected String name;
	protected int pv;
	protected int pa;
	protected int def_temp = 0;
	
	public Perso(String name, int pv, int pa, ClasseRpg classe) {
	    this.classe = classe;
	    this.name = name;
	    this.pv = pv;
	    this.pa = pa;
    }

    public int getTotalDefense() {
		return def_temp + armure.getpArmure();
	}

	public void doubleDefense() {
		def_temp += armure.getpArmure();
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

    public Armes getArme() {
	    return arme;
    }

    public void setPv(int pv) {
	    this.pv = pv;
    }
}
