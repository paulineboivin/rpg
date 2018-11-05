package com.paulinemaxime.rpg.entities.living;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;

public abstract class Perso {

	protected ClasseRpg classe;
	protected Armure armure;
	protected Armes arme;

	protected String name;
	protected int current_pv;
	protected int max_pv;
	protected int pa;
	protected int def_temp = 0;
	
	public Perso(String name, int pv, int pa, ClasseRpg classe) {
	    this.classe = classe;
	    this.name = name;
	    this.current_pv = pv;
	    this.max_pv = pv;
	    this.pa = pa;
    }

    public int getTotalDefense() {
		return def_temp + armure.getpArmure();
	}

	public void setTotalDefense(int amount) {
		def_temp = amount;
	}

	public void doubleDefense() {
		def_temp += armure.getpArmure();
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

    public Armes getArme() {
	    return arme;
    }

    public void setArme(Armes arme) {
		this.arme = arme;
	}

    public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

    public void setCurrent_pv(int current_pv) {
	    this.current_pv = current_pv;
    }

    public int getMax_pv() {
	    return max_pv;
    }

    public ClasseRpg getClasse() {
		return classe;
	}
}
