package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultFighter implements ClasseRpg {

	@Override
	public String getArmorRestriction() {
		return "aucun";
	}

	@Override
	public String getWeaponRestriction() {
		return "aucun";
	}

	@Override
	public void fight(Perso perso) {
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		boolean canEquip = false;
		if (arme.getType().equals("aucun")) canEquip = true;
		return canEquip;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean canEquip = false;
		if (armure.getType().equals("aucun")) canEquip = true;
		return canEquip;
	}
}
