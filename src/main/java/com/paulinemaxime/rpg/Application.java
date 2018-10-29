package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Armes a = new Armemagique(3, 4, "test");
		if ( a.getClass() == Armemagique.class) {
			System.out.println("Helloo");
		}
	}

}
