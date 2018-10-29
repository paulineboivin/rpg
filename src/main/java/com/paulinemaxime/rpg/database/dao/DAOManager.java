package com.paulinemaxime.rpg.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.paulinemaxime.rpg.database.contract.Contract;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;
import com.paulinemaxime.rpg.entities.items.arme.Armemixte;
import com.paulinemaxime.rpg.entities.items.arme.Armephysique;
import com.paulinemaxime.rpg.entities.items.armure.Armuremagique;
import com.paulinemaxime.rpg.entities.items.armure.Armuremixte;
import com.paulinemaxime.rpg.entities.items.armure.Armurephysique;


public void insertArmes(Contract contract) {

	Armes armeMixte = new Armemixte("Couteau géant",2,3);
	Armes armeMixte2 = new Armemixte("Poing américain magique",4,3);
	Armes armeMixte3 = new Armemixte("Aiguille empoisonnée",3,2);
	Armes armeMixte4 = new Armemixte("Epée foudroyante",5,3);
	
	Armes armePhysique = new Armephysique("Epée",1,4,3);
	Armes armePhysique2 = new Armephysique("Fourchette",2,1,1);
	Armes armePhysique3 = new Armephysique("Arbalète",3,3,2);
	Armes armePhysique4 = new Armephysique("Sarbacane",4,3,3);
	
	Armes armeMagique = new Armemagique("Foudre",3,2);
	Armes armeMagique2 = new Armemagique("Lancer de sort",2,1);
	Armes armeMagique3 = new Armemagique("Pluie de feu",4,5);
	Armes armeMagique4 = new Armemagique("Etincelle",4,3);
}

public void insertArmures(Contract contract) {

	Armure armureMixte = new Armuremixte("Armure d'écaille",2);
	Armure armureMixte2 = new Armuremixte("Armure de cuir magique ",1);
	Armure armureMixte3 = new Armuremixte("Côte de mailles magiques",4);
	Armure armureMixte4 = new Armuremixte("Cuirasse magique",2);
	
	Armure armurePhysique = new Armurephysique("Plaque de métal",1);
	Armure armurePhysique2 = new Armurephysique("Armure en cuir",3);
	Armure armurePhysique3 = new Armurephysique("Armure d'écailles",4);
	Armure armurePhysique4 = new Armurephysique("Armure cloutée",2);

	Armure armureMagique = new Armuremagique("Lunettes de protection",3);
	Armure armureMagique2 = new Armuremagique("Cape magique",4);
	Armure armureMagique3 = new Armuremagique("Marteau magique",3);
	Armure armureMagique4 = new Armuremagique("Perceuse autonome",5);

}

public class DAOManager<T extends DBItem> {
}
public ArrayList<T> selectAll(Contract contract, DTO<T> dto) {
}

}

