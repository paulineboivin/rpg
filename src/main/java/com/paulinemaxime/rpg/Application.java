package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.database.DBOpenHelper;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DBOpenHelper bdd = DBOpenHelper.getInstance();
		bdd.getConn();
		//new Game();

	}

}
