package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.classes.Paladin;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultPaladin implements ClasseRpg, Paladin {

	@Override
	public String getArmorRestriction() {
		return "mixte";
	}

	@Override
	public String getWeaponRestriction() {
		return "mixte";
	}

	@Override
	public void fight(Perso perso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		boolean canEquip = false;
		if (arme.getType().equals("mixte")) canEquip = true;
		return canEquip;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean canEquip = false;
		if (armure.getType().equals("mixte")) canEquip = true;
		return canEquip;
	}
}
