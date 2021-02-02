package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe Mur
 */
public class Mur extends ImageView {
    private static final Image imageMur = new Image("mur.png", 100, 100, false, false);

    /**
     * Création d'un mur
     * @param x Position selon x du mur
     * @param y Position selon y du mur
     */
    public Mur(int x, int y){
        super(imageMur);
        this.setX(x);
        this.setY(y);
    }
}
