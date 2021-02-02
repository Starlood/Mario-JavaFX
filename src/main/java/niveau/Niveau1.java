package niveau;

import model.Arrive;
import model.Ennemi;
import model.Mur;

import java.util.ArrayList;

public class Niveau1 extends Niveau{
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
        Mur mur4 = new Mur(380, 780);
        listeMur.add(mur4);
        Mur mur5 = new Mur(880, 780);
        listeMur.add(mur5);
        Mur mur6 = new Mur(970, 780);
        listeMur.add(mur6);
        Mur mur7 = new Mur(1500, 780);
        listeMur.add(mur7);
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
        Ennemi ennemi2 = new Ennemi(stage, joueur, listeEnnemi, listeMur, 1200, 780);
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
