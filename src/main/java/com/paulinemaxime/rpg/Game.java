package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.entities.classes.ClasseRpg;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultBarbare;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultFighter;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultMagicien;
import com.paulinemaxime.rpg.entities.classes.defauts.DefaultPaladin;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.items.Donjon;
import com.paulinemaxime.rpg.entities.items.Etage;
import com.paulinemaxime.rpg.entities.living.Hero;
import com.paulinemaxime.rpg.entities.living.Monstre;
import com.paulinemaxime.rpg.entities.living.Perso;
import com.paulinemaxime.rpg.utils.ScannerProvider;
import com.paulinemaxime.rpg.utils.console.AdvancedConsole;
import com.paulinemaxime.rpg.utils.console.Menu;

import java.util.ArrayList;

public class Game {

    private AdvancedConsole cmd;
    private ScannerProvider scanner;
    private ArrayList<Hero> team = new ArrayList<>();
    private ArrayList<Armes> armes = new ArrayList<>();
    private ArrayList<Armure> armures = new ArrayList<>();
    private Donjon dj = new Donjon();
    private int butin = 0;
    private boolean end = false;

    private Monstre monstre = null;

    public Game() {
        init();
    }

    public void init() {
        cmd = AdvancedConsole.getInstance();
        scanner = ScannerProvider.getInstance();
        createTeam();
        createDonjon();
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
        menuSelectWeapon(monstre, "Monstre");
        cmd.print("Votre monstre a bien �t� cr�� !");

        return monstre;
    }

    public void menuSelectWeapon(Perso perso, String name) {

        Menu menu = cmd.createMenu("Selection arme "+name, "S�lectionner une arme pour votre "+name+" :");
        for (Armes arme : armes) {
            if (perso.getClasse().isEquipable(arme)) {
                menu.addChoice(arme.getName()+" [Degat : "+arme.getDegat()+" | Pa : "+arme.getPa()+"]", ()-> { perso.setArme(arme); return null; });
            }
        }

    }
    
    public void menuSelectArmor(Perso perso, String name) {

        Menu menu = cmd.createMenu("Selection armure "+name, "S�lectionner une armure pour votre "+name+" :");
        for (Armure armure : armures) {
            if (perso.getClasse().isEquipable(armure)) {
                menu.addChoice(armure.getName()+" [Defense : "+armure.getpArmure()+"]", ()-> { perso.setArmure(armure); return null; });
            }
        }
    }

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
        while (team.size() > 0 && dj.getEtages().size() > 0) {
            for (Hero hero : team) {
                if (!end) {
                    choixAction(hero);
                }
            }
            if (!dj.getEtages().isEmpty())
            for (Monstre monstre: dj.getEtages().get(0).getMonstres()) {
                if (!end) {
                    randAction(monstre);
                }
            }
        }
        resumeDonjon();
    }

    private void choixAction(Perso hero) {
        Menu menu = cmd.createMenu();
        menu.addDescription("Choisissez l'action à effectuer pour le hero -> "+hero.getName()+" :");
        menu.addChoice("Attaquer", ()-> { heroAttaque(hero); return  null; });
        menu.addChoice("Defendre", ()-> { hero.doubleDefense(); return  null; });
        menu.print();
    }

    private void randAction(Perso monstre) {
        Perso hero = null;
        if (!team.isEmpty()) {
            hero = team.get(0);
        }
        int pa = monstre.getPa();
        boolean flag = true;

        while (pa >= monstre.getArme().getPa() && flag) {

            if (hero != null) {

                int rand = (int) (Math.random()*2%2);
                if (rand == 1) { //Attaque
                    cmd.print("DEBUG : Attaque");

                    if (!calculAttaque(monstre, hero)) {
                        team.remove(hero);
                    }
                    pa -= monstre.getArme().getPa();

                } else { //defense
                    cmd.print("DEBUG : Defense");
                    monstre.doubleDefense();
                    flag = false;
                }

            } else {
                flag = false;
            }

        }
    }

    private void heroAttaque(Perso hero) {
        Perso monstre;
        Etage etage = dj.getEtages().get(0);
        int pa = hero.getPa();
        boolean flag = true;

        while (pa >= hero.getArme().getPa() && flag) {

            if (etage != null) {

                if (!etage.getMonstres().isEmpty()) {
                    monstre = etage.getMonstres().get(0);

                    if (!calculAttaque(hero, monstre)) {
                        etage.removeMonstre((Monstre) monstre);
                        butin += Math.random()*(11)%11;
                    }
                    pa -= hero.getArme().getPa();

                } else {
                    dj.removeEtage(etage);
                    if (!dj.getEtages().isEmpty()) {
                        etage = dj.getEtages().get(0);
                    } else {
                        flag = false;
                    }

                }

            } else {
                flag = false;
                resumeDonjon();
            }

        }

    }

    private boolean calculAttaque(Perso att, Perso def) {
        int degat = 0;
        boolean alive = true;
        if (att.getArme().getType().equals(def.getArmure().getType()) ) {
            degat = def.getTotalDefense() - att.getArme().getDegat();
            if (degat < 0) {
                def.setTotalDefense(0);
                def.setCurrent_pv(def.getCurrent_pv()+degat);
            } else {
                def.setTotalDefense(degat);
            }
        } else {
            degat = att.getArme().getDegat();
            def.setCurrent_pv(def.getCurrent_pv()-degat);
        }
        if (def.getCurrent_pv() < 1) {
            alive = false;
        }
        return alive;
    }

    public void resumeDonjon() {

        end = true;

        for (Perso hero: team) {
            cmd.print(hero.getName()+" : "+hero.getCurrent_pv()+"/"+hero.getMax_pv());
            cmd.loadingBar((double) hero.getCurrent_pv(), (double) hero.getMax_pv());
        }
        cmd.print("Vous avez gagné "+butin+" pièces d'or !");
    }

}
