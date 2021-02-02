package model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import niveau.Delayer;
import niveau.Niveau;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe Ennemi
 */
public class Ennemi extends ImageView {
    private static final Image imageEnnemi= new Image("/ennemi.png", 100, 100, false, false);
    private static final String gauche="gauche";
    private static final String droite="droite";
    private String direction=gauche;
    private String directionOppose=droite;
    private Joueur joueur;
    private ArrayList<Ennemi> listeEnnemi = new ArrayList<>();
    private ArrayList<Mur> listeMur;
    protected Stage stage = new Stage();

    /**
     * Création d'un ennemi
     * @param stage Scène ou va apparaitre l'ennemi
     * @param joueur Joueur présent sur la map
     * @param listeEnnemi Liste des ennemis présent sur la map
     * @param listeMur Liste des mur présent sur la map
     * @param x Position x de l'ennemi
     * @param y Position y de l'ennemi
     */
    public Ennemi(Stage stage, Joueur joueur, ArrayList<Ennemi> listeEnnemi, ArrayList<Mur> listeMur, int x, int y){
        super(imageEnnemi);
        setX(x);
        setY(y);
        this.stage=stage;
        this.joueur=joueur;
        this.listeEnnemi=listeEnnemi;
        this.listeMur=listeMur;
    }

    /**
     * Permet de faire bouger le joueur dans la direction choisie
     * @param direction direction choisie
     */
    public void seDeplacer(String direction){
        if(direction=="droite"){
            this.setX(this.getX()+20);
        }
        if(direction=="gauche"){
            this.setX(this.getX()-20);
        }
    }

    /**
     * Permet à l'ennemi de se déplacer en continu et gerer les collision avec les murs
     */
     public void seDeplaceEnBoucle(){
         Timeline temporisater = new Timeline(
                 new KeyFrame(Duration.millis(500),
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(ActionEvent event){
                                 seDeplacer(direction);
                                 if (Niveau.isInteractionEnnemi(Ennemi.this, listeMur)){
                                     seDeplacer(directionOppose);
                                     String temp=direction;
                                     direction=directionOppose;
                                     directionOppose=temp;
                                 }
                                 if (Niveau.isInteractionE(joueur, listeEnnemi)){
                                     joueur.perdUneVie();
                                     joueur.setX(20);
                                     joueur.setY(750);
                                     if (joueur.getVie()==0){
                                         stage.close();
                                     }
                                 }
                             }
                 }));
         temporisater.setCycleCount(Timeline.INDEFINITE);
         temporisater.play();
    }
}
