package com.paulinemaxime.rpg;

import com.paulinemaxime.rpg.database.contract.ArmeContract;
import com.paulinemaxime.rpg.database.contract.ArmureContract;
import com.paulinemaxime.rpg.database.dao.DAOManager;
import com.paulinemaxime.rpg.database.dto.ArmeDTO;
import com.paulinemaxime.rpg.database.dto.ArmureDTO;
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

        // Init SQL BDD
        DAOManager dao = new DAOManager();

        ArmeContract armeContract = new ArmeContract();
        ArmeDTO armeDTO = new ArmeDTO();
        ArmureContract armureContract = new ArmureContract();
        ArmureDTO armureDTO = new ArmureDTO();

        dao.dropTable(armeContract);
        dao.createTable(armeContract);
        dao.insert(armeContract, armeDTO, "'Baton du sourcier', 5, 3, 'magique'");
        dao.insert(armeContract, armeDTO, "'Lance sortillège', 8, 5, 'magique'");
        dao.insert(armeContract, armeDTO, "'Epée à deux mains', 8, 3, 'physique'");
        dao.insert(armeContract, armeDTO, "'Hache du bourreau', 12, 5, 'physique'");
        dao.insert(armeContract, armeDTO, "'Dague ensorcellé', 7, 3, 'mixte'");
        dao.insert(armeContract, armeDTO, "'Fouet démoniaque', 10, 5, 'mixte'");
        dao.insert(armeContract, armeDTO, "'Poings', 5, 2, 'aucun'");
        armes.addAll(dao.selectAll(armeContract, armeDTO));

        dao.dropTable(armureContract);
        dao.createTable(armureContract);
        dao.insert(armureContract, armureDTO, "'Cape en chantier', 3, 'magique'");
        dao.insert(armureContract, armureDTO, "'Bouclier sacré', 6, 'magique'");
        dao.insert(armureContract, armureDTO, "'Bouclier du captain', 4, 'physique'");
        dao.insert(armureContract, armureDTO, "'Iron armor', 7, 'physique'");
        dao.insert(armureContract, armureDTO, "'Culotte magique', 2, 'mixte'");
        dao.insert(armureContract, armureDTO, "'Armure simple', 10, 'mixte'");
        dao.insert(armureContract, armureDTO, "'Slip de bain', 1, 'aucun'");
        armures.addAll(dao.selectAll(armureContract, armureDTO));

        //Start Game
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
        menuSelectWeapon(team.get(team.size()-1), "Hero");
        menuSelectArmor(team.get(team.size()-1), "Hero");
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
        menuSelectArmor(monstre, "Monstre");
        cmd.print("Votre monstre a bien été créé !");

        return monstre;
    }

    public void menuSelectWeapon(Perso perso, String name) {

        Menu menu = cmd.createMenu("Selection arme "+name, "Sélectionner une arme pour votre "+name+" :");
        for (Armes arme : armes) {
            if (perso.getClasse().isEquipable(arme)) {
                menu.addChoice(arme.getName()+" [Degat : "+arme.getDegat()+" | Pa : "+arme.getPa()+"]", ()-> { perso.setArme(arme); return null; });
            }
        }
        menu.print();
    }
    
    public void menuSelectArmor(Perso perso, String name) {

        Menu menu = cmd.createMenu("Selection armure "+name, "Sélectionner une armure pour votre "+name+" :");
        for (Armure armure : armures) {
            if (perso.getClasse().isEquipable(armure)) {
                menu.addChoice(armure.getName()+" [Defense : "+armure.getpArmure()+"]", ()-> { perso.setArmure(armure); return null; });
            }
        }
        menu.print();
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

                    if (!calculAttaque(monstre, hero)) {
                        team.remove(hero);
                    }
                    pa -= monstre.getArme().getPa();

                } else { //defense
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
        } else if (att.getArme().getType().equals("mixte") && (def.getArmure().getType().equals("physique") || def.getArmure().getType().equals("magique"))) {
            degat = def.getTotalDefense() - (att.getArme().getDegat() / 2);
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
