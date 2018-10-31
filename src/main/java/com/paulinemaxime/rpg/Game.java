package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.entities.classes.defauts.DefaultBarbare;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultFighter;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultMagicien;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultPaladin;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;
import com.paulinemaxime.rpg.entities.living.Hero;
import com.paulinemaxime.rpg.entities.living.Monstre;
import com.paulinemaxime.rpg.utils.ScannerProvider;
import com.paulinemaxime.rpg.utils.console.AdvancedConsole;
import com.paulinemaxime.rpg.utils.console.Menu;

public class Game {

    private AdvancedConsole cmd;
    private ScannerProvider scanner;

    public Game() {
        init();
    }

    public void init() {
        cmd = AdvancedConsole.getInstance();
        scanner = ScannerProvider.getInstance();
        defineHero();
    }

    public void defineHero() {

        cmd.print("Choisissez un nom pour votre Hero :");
        String name = scanner.getScanner().nextLine();
        cmd.print("Donnez lui un nombre de point de vie :");
        int pv = scanner.getScanner().nextInt();
        cmd.print("Donnez lui un nombre de point d'attaque :");
        int pa = scanner.getScanner().nextInt();

        Menu menu = cmd.createMenu();
        menu.addDescription("Choisissez la classe de votre hero :");
        int choice = 1;
        menu.addChoice("Humain basic", ()-> { new Hero(name, pv, pa, new DefaultFighter()); return null;} );
        menu.addChoice("Barbare", ()-> { new Hero(name, pv, pa, new DefaultBarbare()); return null;} );
        menu.addChoice("Magicien", ()-> { new Hero(name, pv, pa, new DefaultMagicien()); return null;} );
        menu.addChoice("Paladin", ()-> { new Hero(name, pv, pa, new DefaultPaladin()); return null;} );

        menu.print();
        cmd.print("Votre hero Ã  bien Ã©tÃ© crÃ©Ã© !");

    }

    public void defineMonster() {
    	
    	cmd.print("Choisissez un nom pour votre Monstre :");
        String name = scanner.getScanner().nextLine();
        cmd.print("Donnez lui un nombre de point de vie :");
        int pv = scanner.getScanner().nextInt();
        cmd.print("Donnez lui un nombre de point d'attaque :");
        int pa = scanner.getScanner().nextInt();

        Menu menu = cmd.createMenu();
        menu.addDescription("Choisissez la classe de votre Monstre :");
        int choice = 1;
        menu.addChoice("Monstre basic", ()-> { new Monstre(name, pv, pa, new DefaultFighter()); return null;} );
        menu.addChoice("Barbare", ()-> { new Monstre(name, pv, pa, new DefaultBarbare()); return null;} );
        menu.addChoice("Magicien", ()-> { new Monstre(name, pv, pa, new DefaultMagicien()); return null;} );
        menu.addChoice("Paladin", ()-> { new Monstre(name, pv, pa, new DefaultPaladin()); return null;} );

        menu.print();
        cmd.print("Votre monstre a bien été créé !");
    }

    public void menuSelectWeapon(Hero hero) {

        Menu menu = cmd.createMenu("Selection arme Hero", "Sélectionner une arme pour votre Hero :");
    }
    
    public void menuSelectWeapon(Monstre monstre) {

        Menu menu = cmd.createMenu("Selection arme Monstre", "Sélectionner une arme pour votre Monstre :");
    }

    public void menuSelectArmor(Hero hero) {
    	Menu exemple = cmd.createMenu();
    	exemple.addName("Nom du menu");
    	exemple.addDescription("Choisissez le choix qui vous convient :");
    	exemple.addChoice("choix 1", ()-> {System.out.println(" "); return null;} );
    }
    
    public void menuSelectArmor(Monstre monstre) {}

}
