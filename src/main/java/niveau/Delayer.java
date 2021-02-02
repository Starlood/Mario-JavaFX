package niveau;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import model.Ennemi;
import model.Joueur;
import model.Mur;

import java.util.ArrayList;

/**
 * Classe Delayer
 */
public class Delayer {
    /**
     * Permet de ne pas sauter à l'infini
     * @param timeToSleep
     * @param joueur
     * @param listeMur
     */
    public static void waitToJump(long timeToSleep, Joueur joueur, ArrayList<Mur> listeMur){
        if(!Niveau.isJumping) {
            new Thread(() -> {
                try {
                    Thread.sleep(timeToSleep);
                    Platform.runLater(() -> onTombe(joueur, listeMur));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            joueur.sauter();
            Niveau.setJump(true);
        }
    }

    /**
     * Methode permetant de gerer quand le joueur tombe
     * @param joueur joueur
     * @param listeMur Liste des murs de la carte
     */
    public static void onTombe(Joueur joueur, ArrayList<Mur> listeMur){
        joueur.tomber();
        if (Niveau.isInteraction(joueur, listeMur)){
            joueur.sauter();
        }
        while(Niveau.canFallABit(joueur, listeMur)){
            joueur.tombeUnPeu();
        }
        Niveau.setJump(false);
    }

    /**
     * Temporisation
     * @param timeToSleep durée de la temporisation
     */
    public static void tempo(long timeToSleep) {
            new Thread(() -> {
                try {
                    Thread.sleep(timeToSleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
    }
}
