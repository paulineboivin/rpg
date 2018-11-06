package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.Barbare;
import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultBarbare implements ClasseRpg, Barbare {

	@Override
	public String getArmorRestriction() {
		return "physique";
	}

	@Override
	public String getWeaponRestriction() {
		return "physique";
	}

	@Override
	public void fight(Perso perso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		boolean canEquip = false;
		if (arme.getType().equals("physique")) canEquip = true;
		return canEquip;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean canEquip = false;
		if (armure.getType().equals("physique")) canEquip = true;
		return canEquip;
	}
}
