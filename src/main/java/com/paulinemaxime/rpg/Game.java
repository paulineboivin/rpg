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
    private Monstre monstre = null;

    public Game() {
        init();
    }

    public void init() {
        cmd = AdvancedConsole.getInstance();
        scanner = ScannerProvider.getInstance();
        createTeam();
        //createDonjon();
        attaqueDonjon();
    }

    public void defineHero() {

        cmd.print("Choisissez un nom pour votre Hero :");
        String name = scanner.getScanner().next();
        cmd.print("Donnez lui un nombre de point de vie ( min : 1 | max : 1000) :");
        int pv = cmd.verifInputInt(1,1000);
        cmd.print("Donnez lui un nombre de point d'attaque (min : 1 | max : 15) :");
        int pa = cmd.verifInputInt(1,15);

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

        monstre = null;

    	cmd.print("Choisissez un nom pour votre Monstre :");
        String name = scanner.getScanner().next();
        cmd.print("Donnez lui un nombre de point de vie (min : 1 | max : 5000) :");
        int pv = cmd.verifInputInt(1,5000);
        cmd.print("Donnez lui un nombre de point d'attaque (min : 1 | max : 15) :");
        int pa = cmd.verifInputInt(1,15);

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
        int nbr = cmd.verifInputInt(0,10);
        for (int i=0; i < nbr; i++) {
            cmd.print("Hero : "+(i+1)+"/"+nbr);
            defineHero();
        }
    }

    public void createDonjon() {
        cmd.print("Combien voulez-vous d'étages à votre donjon ? (maximum 5) :");
        int nbr = cmd.verifInputInt(0,5);
        cmd.print("Combien de monstre voulez-vous par étage ? (maximum 10) :");
        int nbr_monstre = cmd.verifInputInt(0,10);
        Donjon dj = new Donjon();
        for (int i=0; i < nbr; i++) {
            Etage etage = new Etage();
            for (int j=0; j < nbr_monstre; j++) {
                cmd.print("Etage : "+(i+1)+"/"+nbr+" | Monstre : "+(j+1)+"/"+nbr_monstre);
                etage.addMonstre(defineMonster());
            }
            dj.addEtage(etage);
        }
    }

    public void attaqueDonjon() {
        cmd.print("Vous attaquez le Donjon !");
        for (Hero hero: team) {
            choixAction(hero);
        }
    }

    private void choixAction(Hero hero) {
        Menu menu = cmd.createMenu();
        menu.addDescription("Choisissez l'action à effectuer pour le hero -> "+hero.getName()+" :");
        menu.addChoice("Attaquer", ()-> { cmd.print("Attaque !"); return  null; });
        menu.addChoice("Defendre", ()-> { cmd.print("Defense !"); return  null; });
        menu.print();
    }

}
