package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.entities.classes.defauts.DefaultBarbare;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultFighter;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultMagicien;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultPaladin;
import com.paulinemaxime.rpg.entities.items.Donjon;
import com.paulinemaxime.rpg.entities.items.Etage;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;
import com.paulinemaxime.rpg.entities.living.Hero;
import com.paulinemaxime.rpg.entities.living.Monstre;
import com.paulinemaxime.rpg.utils.ScannerProvider;
import com.paulinemaxime.rpg.utils.console.AdvancedConsole;
import com.paulinemaxime.rpg.utils.console.Menu;

import java.util.ArrayList;

public class Game {

    private AdvancedConsole cmd;
    private ScannerProvider scanner;
    private ArrayList<Hero> team = new ArrayList<>();

    public Game() {
        init();
    }

    public void init() {
        cmd = AdvancedConsole.getInstance();
        scanner = ScannerProvider.getInstance();
        createDonjon();
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
        menu.addChoice("Humain basic", ()-> { team.add(new Hero(name, pv, pa, new DefaultFighter())); return null;} );
        menu.addChoice("Barbare", ()-> { team.add(new Hero(name, pv, pa, new DefaultBarbare())); return null;} );
        menu.addChoice("Magicien", ()-> { team.add(new Hero(name, pv, pa, new DefaultMagicien())); return null;} );
        menu.addChoice("Paladin", ()-> { team.add(new Hero(name, pv, pa, new DefaultPaladin())); return null;} );

        menu.print();
        cmd.print("Votre hero à bien été créé !");

    }

    public Monstre defineMonster() {

        Monstre monstre = null;
    	
    	cmd.print("Choisissez un nom pour votre Monstre :");
        String name = scanner.getScanner().nextLine();
        cmd.print("Donnez lui un nombre de point de vie :");
        int pv = scanner.getScanner().nextInt();
        cmd.print("Donnez lui un nombre de point d'attaque :");
        int pa = scanner.getScanner().nextInt();

        Menu menu = cmd.createMenu();
        menu.addDescription("Choisissez la classe de votre Monstre :");
        int choice = 1;
        menu.addChoice("Monstre basic", ()-> { monstre = new Monstre(name, pv, pa, new DefaultFighter()); return null;} );
        menu.addChoice("Barbare", ()-> { monstre = new Monstre(name, pv, pa, new DefaultBarbare()); return null;} );
        menu.addChoice("Magicien", ()-> { monstre = new Monstre(name, pv, pa, new DefaultMagicien()); return null;} );
        menu.addChoice("Paladin", ()-> { monstre = new Monstre(name, pv, pa, new DefaultPaladin()); return null;} );

        menu.print();
        cmd.print("Votre monstre a bien �t� cr�� !");

        return monstre;
    }

    public void menuSelectWeapon(Hero hero) {

        Menu menu = cmd.createMenu("Selection arme Hero", "S�lectionner une arme pour votre Hero :");
    }
    
    public void menuSelectWeapon(Monstre monstre) {

        Menu menu = cmd.createMenu("Selection arme Monstre", "S�lectionner une arme pour votre Monstre :");
    }

    public void menuSelectArmor(Hero hero) {
    	Menu exemple = cmd.createMenu();
    	exemple.addName("Nom du menu");
    	exemple.addDescription("Choisissez le choix qui vous convient :");
    	exemple.addChoice("choix 1", ()-> {System.out.println(" "); return null;} );
    }
    
    public void menuSelectArmor(Monstre monstre) {}

    public void createTeam() {
        cmd.print("Combien de héro voulez-vous créer ? (maximum 10) :");
        int nbr;
        do {
            nbr = scanner.getScanner().nextInt();
        } while (nbr > 10 || nbr <= 0);
        for (int i=0; i < nbr; i++) {
            defineHero();
        }
    }

    public void createDonjon() {
        cmd.print("Combien voulez-vous d'étages à votre donjon ? (maximum 5) :");
        int nbr;
        do {
            nbr = scanner.getScanner().nextInt();
        } while (nbr <= 0 || nbr > 5);
        cmd.print("Combien de monstre voulez-vous par étage ? (maximum 10) :");
        int monstres;
        do {
            monstres = scanner.getScanner().nextInt();
        } while (monstres <= 0 || monstres > 10);
        Donjon dj = new Donjon();
        for (int i=0; i < nbr; i++) {
            Etage etage = new Etage();
            for (int j=0; j < monstres; j++) {
                etage.addMonstre(defineMonster());
            }
            dj.addEtage(etage);
        }
    }

}
