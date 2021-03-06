package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.classes.Magicien;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultMagicien implements ClasseRpg, Magicien {

	@Override
	public String getArmorRestriction() {
		return "magique";
	}

	@Override
	public String getWeaponRestriction() {
		return "magique";
	}

	@Override
	public void fight(Perso perso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		boolean canEquip = false;
		if (arme.getType().equals("magique")) canEquip = true;
		return canEquip;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean canEquip = false;
		if (armure.getType().equals("magique")) canEquip = true;
		return canEquip;
	}
}
