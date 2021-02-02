package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Joueur;

/**
 * Vue de l'entité joueur
 */
public class JoueurView extends Parent {

    Rectangle leJoueur;
    public IntegerProperty Xproperty;
    public IntegerProperty Yproperty;

    /**
     * Création de la vue d'un joueur
     * @param joueur
     */
    public JoueurView(Joueur joueur){
        Xproperty= new SimpleIntegerProperty();
        Yproperty= new SimpleIntegerProperty();
        Xproperty.bind(joueur.Xproperty);
        Yproperty.bind(joueur.Yproperty);
        leJoueur = new Rectangle();
        leJoueur.setHeight(10l);
        leJoueur.setWidth(5l);
        leJoueur.setFill(Color.RED);
        this.getChildren().add(leJoueur);
    }
}
