package niveau;

import model.Arrive;
import model.Ennemi;
import model.Mur;

import java.util.ArrayList;

public class Niveau2 extends Niveau {
    /**
     * Creer les murs sur la map
     * @return
     */
    @Override
    public ArrayList<Mur> creerMur() {
        ArrayList<Mur> listeMur = new ArrayList<>();
        Mur mur1 = new Mur(200, 780);
        listeMur.add(mur1);
        Mur mur2 = new Mur(290, 780);
        listeMur.add(mur2);
        Mur mur3 = new Mur(290, 690);
        listeMur.add(mur3);
        Mur mur4 = new Mur(470, 590);
        listeMur.add(mur4);
        Mur mur5 = new Mur(880, 780);
        listeMur.add(mur5);
        Mur mur6 = new Mur(790, 590);
        listeMur.add(mur6);
        Mur mur7= new Mur(1500, 780);
        listeMur.add(mur7);
        Mur mur8= new Mur(1590, 780);
        listeMur.add(mur8);
        Mur mur9= new Mur(1500, 690);
        listeMur.add(mur9);
        Mur mur10 = new Mur(1200, 780);
        listeMur.add(mur10);
        Mur mur11 = new Mur(1200, 690);
        listeMur.add(mur11);




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
        Ennemi ennemi2 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 750, 780);
        listeEnnemi.add(ennemi2);
        Ennemi ennemi3 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 1100, 780);
        listeEnnemi.add(ennemi3);
        Ennemi ennemi4 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 1400, 780);
        listeEnnemi.add(ennemi4);

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
