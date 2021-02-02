package model;

import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import niveau.Delayer;
import niveau.Niveau;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe Joueur
 */
public class Joueur extends ImageView {

    private StringProperty pseudoJoueur;
    public SimpleDoubleProperty Xproperty;
    public SimpleDoubleProperty Yproperty;
    public int vie;

    protected static final Image imageJoueur= new Image("/joueur.png");



    /**
     * Création d'un joueur
     */
    public Joueur(){
        super(imageJoueur);
        pseudoJoueur= new SimpleStringProperty();
        Xproperty= new SimpleDoubleProperty(0);
        Yproperty= new SimpleDoubleProperty(0);
        this.setX(20);
        this.setY(750);
        this.vie=3;

    }
    public StringProperty getPseudoJoueur(){return this.pseudoJoueur;}
    /**
     * Fait tomber le joueur
     */
    public void tomber() {
        this.setY(this.getY()+100);
    }

    /**
     * Fait sauter le joueur
     */
    public void sauter(){
        this.setY(this.getY()-100);
    }

    /**
     * Fait sauter le joueur en prenant en compte les différents mur présents sur la map
     * @param listeMur Liste des mur à prendre en compte
     */
    public void faireSauter(ArrayList<Mur> listeMur){
        Delayer.waitToJump(1000, this, listeMur);
    }

    /**
     * Permet de faire bouger le joueur dans la direction choisie
     * @param direction direction choisie
     */
   public void seDeplacer(String direction){
        if(direction=="droite"){
            this.setX(this.getX()+50);
        }
        if(direction=="gauche"){
            this.setX(this.getX()-50);
        }
    }

    /**
     * Permet de faire bouger de manière minime le joueur dans la direction choisie
     * @param direction direction choisie
     */
    public void seDeplacerUnPeu(String direction){
        if(direction=="droite"){
            this.setX(this.getX()+15);
        }
        if(direction=="gauche"){
            this.setX(this.getX()-15);
        }
    }

    /**
     * Le joueur peut tomber un petit peu
     */
    public void tombeUnPeu() {
        this.setY(this.getY()+1);
    }

    /**
     * Permet au joueur de sauter un peu
     */
    public void sauterUnPeu() {
        this.setY(this.getY()-1);
    }

    /**
     * Enlève une vie au joueur
     */
    public void perdUneVie() {
        vie-=1;
        System.out.println(vie);
    }

    /**
     * Retourne la vie du joueur
     * @return vie du joueur
     */
    public int getVie() {
        return vie;
    }
}
