package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arrive extends ImageView {
    private static final Image imageMur = new Image("drapeaufin.png", 100, 600, false, false);

    /**
     * Création de l'objet arrive qui permet définir la fin d'un niveau
     * @param x Position x de l'arrivée
     * @param y Position y de l'arrivée
     */
    public Arrive(int x, int y){
        super(imageMur);
        this.setX(x);
        this.setY(y);
    }
}
