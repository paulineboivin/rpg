package com.paulinemaxime.rpg.entities.classes;

import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.living.Perso;

public interface ClasseRpg {

    String getArmorRestriction();
    String getWeaponRestriction();
    void fight(Perso perso);
    boolean isEquipable(Armes arme);
    boolean isEquipable(Armure armure);

}
