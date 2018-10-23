package com.paulinemaxime.rpg.entities.classes.defauts;

import com.paulinemaxime.rpg.entities.classes.Barbare;
import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public class DefaultBarbare implements ClasseRpg, Barbare {

	@Override
	public String getArmorRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWeaponRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fight(Perso perso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEquipable(Armes arme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return false;
	}
}
