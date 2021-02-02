package niveau;

import model.Arrive;
import model.Ennemi;
import model.Mur;

import java.util.ArrayList;

/**
 * Niveau 3
 */
public class Niveau3 extends Niveau {
    /**
     * Creer les murs sur la map
     * @return
     */
    @Override
    public ArrayList<Mur> creerMur() {
        ArrayList<Mur> listeMur = new ArrayList<>();

        Mur mur4 = new Mur(200, 690);
        listeMur.add(mur4);
        Mur mur5 = new Mur(110, 780);
        listeMur.add(mur5);
        Mur mur1 = new Mur(200, 780);
        listeMur.add(mur1);
        Mur mur2 = new Mur(600, 780);
        listeMur.add(mur2);

        Mur mur3 = new Mur(600, 690);
        listeMur.add(mur3);

        Mur mur6 = new Mur(950, 690);
        listeMur.add(mur6);
        Mur mur7 = new Mur(950, 780);
        listeMur.add(mur7);

        Mur mur8 = new Mur(950, 600);
        listeMur.add(mur8);

        Mur mur9 = new Mur(950, 510);
        listeMur.add(mur9);

        Mur mur10 = new Mur(860, 600);
        listeMur.add(mur10);

        Mur mur11 = new Mur(690, 430);
        listeMur.add(mur11);

        Mur mur12 = new Mur(780, 690);
        listeMur.add(mur12);

        Mur mur13 = new Mur(600, 340);
        listeMur.add(mur13);
        Mur mur14 = new Mur(510, 250);
        listeMur.add(mur14);


        Mur mur15 = new Mur(860, 180);
        listeMur.add(mur15);
        Mur mur16 = new Mur(950, 180);
        listeMur.add(mur16);

        Mur mur17 = new Mur(1040, 180);
        listeMur.add(mur17);

        Mur mur18 = new Mur(1140, 270);
        listeMur.add(mur18);

        Mur mur19 = new Mur(1240, 360);
        listeMur.add(mur19);
        Mur mur20 = new Mur(1340, 450);
        listeMur.add(mur20);
        Mur mur21 = new Mur(1440, 540);
        listeMur.add(mur21);
        Mur mur22 = new Mur(1540, 630);
        listeMur.add(mur22);




        return listeMur;
    }

    /**
     * Sert à génerer la liste d'ennemi
     * @param listeMur
     * @return
     */
    @Override
    public ArrayList<Ennemi> creerEnnemi(ArrayList<Mur> listeMur) {
        ArrayList<Ennemi> listeEnnemi = new ArrayList<>();

        Ennemi ennemi1 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 480, 780);
        listeEnnemi.add(ennemi1);
        Ennemi ennemi2 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 300, 780);
        listeEnnemi.add(ennemi2);

        return listeEnnemi;
    }

    /**
     * Créer l'arrivée de la partie
     * @return
     */
    @Override
    protected Arrive creerArrive() {
        return arrive = new Arrive(1700, 270);
    }

}
