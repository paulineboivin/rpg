package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultFighter implements ClasseRpg {

	@Override
	public String getArmorRestriction() {

		return null;
	}

	@Override
	public String getWeaponRestriction() {

		return null;
	}

	@Override
	public void fight(Perso perso) {
		
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		//arme.getDegat
		return false;
	}

	@Override
	public boolean isEquipable(Armure armure) {

		return false;
	}
}
