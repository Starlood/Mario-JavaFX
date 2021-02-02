package niveau;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Arrive;
import model.Ennemi;
import model.Joueur;
import model.Mur;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Classe abstraite Niveau
 */
public abstract class Niveau {
    protected Joueur joueur;
    protected static Boolean isJumping;
    protected ArrayList<Mur> listeMur = new ArrayList<>();
    protected ArrayList<Ennemi> listeEnnemi = new ArrayList<>();
    protected Stage stage = new Stage();
    protected Arrive arrive;
    @FXML
    private Label vie;
    Group root = new Group();



    public static void is(Joueur joueur){
        joueur.getVie();
    }

    /**
     * Methode permettant de gerer les colision entre un ennemi et les murs de la carte
     * @param ennemi
     * @param listeMur
     * @return
     */
    public static boolean isInteractionEnnemi(Ennemi ennemi, ArrayList<Mur> listeMur) {
        for (Mur mur : listeMur){
            if (ennemi.equals(mur)){
                continue;
            }
            if (ennemi.intersects(mur.getBoundsInLocal())){
                return true;
            }
        }
        return false;
    }

    public abstract ArrayList<Mur> creerMur();
    public abstract ArrayList<Ennemi> creerEnnemi(ArrayList<Mur> listeMur);



    public void deplacer (KeyEvent code){
        switch (code.getCode()){
            case LEFT:
                joueur.seDeplacer("gauche");
                if (isInteraction(joueur, listeMur)){
                    joueur.seDeplacer("droite");
                    joueur.seDeplacerUnPeu("gauche");
                    if (isInteraction(joueur, listeMur)){
                        joueur.seDeplacerUnPeu("droite");
                    }
                }
                break;
            case RIGHT:
                joueur.seDeplacer("droite");
                if (isInteraction(joueur, listeMur)){
                    joueur.seDeplacer("gauche");
                    joueur.seDeplacerUnPeu("droite");
                    if (isInteraction(joueur, listeMur)){
                        joueur.seDeplacerUnPeu("gauche");
                    }
                }
                if (isInteractionA(joueur, arrive)){
                    FXMLLoader loadder = new FXMLLoader(getClass().getResource("/fxml/niveaureussi.fxml"));
                    try {
                        stage.setScene(new Scene(loadder.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                }
                break;
            case SPACE:
                if (!isJumping) {
                    joueur.faireSauter(listeMur);
                }
                break;
        }
        if (!isJumping) {
            joueur.tomber();
            if (isInteraction(joueur, listeMur) || joueur.getY() > 750) {
                joueur.sauter();
                while(canFallABit(joueur, listeMur)){
                    joueur.tombeUnPeu();
                }
            }
        }
        if (isInteractionE(joueur, listeEnnemi)){
            joueur.perdUneVie();
            joueur.setX(20);
            joueur.setY(750);
            if (joueur.getVie()<1){
                FXMLLoader loadder = new FXMLLoader(getClass().getResource("/fxml/niveaufin.fxml"));
                try {
                    stage.setScene(new Scene(loadder.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.show();
            }
        }
    }

    /**
     * Peremet de savoir si le joueur est arrivé
     * @param joueur Joueur
     * @param arrive
     * @return
     */
    private boolean isInteractionA(Joueur joueur, Arrive arrive) {
        if (joueur.intersects(arrive.getBoundsInLocal())){
            return true;
        }
        return false;
    }

    /**
     * Gere les interaction entre le joueur et les ennemies présent sur la map
     * @param joueur Joueur
     * @param listeEnnemi Liste des ennemies de la map
     * @return
     */
    public static boolean isInteractionE(Joueur joueur, ArrayList<Ennemi> listeEnnemi) {
        for (Ennemi ennemi : listeEnnemi){
            if (joueur.equals(ennemi)){
                continue;
            }
            if (joueur.intersects(ennemi.getBoundsInLocal())){
                return true;
            }
        }
        return false;
    }

    /**
     * Gere les interaction entre le joueur et les murs présent sur la map
     * @param joueur Joueur
     * @param listeMur Liste des murs de la map
     * @return
     */
    public static boolean isInteraction(Joueur joueur, ArrayList<Mur> listeMur){
        for (Mur mur : listeMur){
            if (joueur.equals(mur)){
                continue;
            }
            if (joueur.intersects(mur.getBoundsInLocal())){
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode permetant de tester si le joueur peut tomber
     * @param joueur
     * @param listeMur
     * @return
     */
    public static boolean canFallABit(Joueur joueur, ArrayList<Mur> listeMur){
        joueur.tombeUnPeu();
        if (isInteraction(joueur, listeMur) || joueur.getY() > 750){
            joueur.sauterUnPeu();
            return false;
        }
        joueur.sauterUnPeu();
        return true;
    }

    public static void setJump(boolean bidule){
        isJumping = bidule;
    }

    /**
     * Méthode qui crée un niveau
     * @throws IOException
     */
    public void creerNiveau() throws IOException {
        isJumping=false;


        Image mapImage = new Image("pagedefond.jpg", 1800, 1000, false, false);
        ImageView mapImageView = new ImageView(mapImage);

        joueur= new Joueur();
        listeMur=creerMur();
        listeEnnemi=creerEnnemi(listeMur);
        arrive=creerArrive();


        root.getChildren().add(mapImageView);
        root = createChildren(root);
       // vie.textProperty().bind(new SimpleIntegerProperty(joueur.vie).asString());

        Scene scene = new Scene(root, 1800, 1000);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this::deplacer);
        stage.setMaximized(true);
        stage.setScene(scene);
        Task task = new Task<Void>() {
            @Override public Void call() {
                faireBougerLesEnnemis();
                return null;
            }
        };
        stage.show();
        new Thread(task).start();
    }

    /**
     * Créer l'arrivée d'un niveau
     * @return L'arrivée
     */
    protected abstract Arrive creerArrive();

    private void faireBougerLesEnnemis() {
        for (Ennemi ennemi : listeEnnemi){ ennemi.seDeplaceEnBoucle(); }
    }

    protected Group createChildren(Group root){
        for (Mur mur : listeMur) {
            root.getChildren().add(mur);
        }
        for (Ennemi ennemi : listeEnnemi) {
            root.getChildren().add(ennemi);
        }
        root.getChildren().add(arrive);
        root.getChildren().add(joueur);
        return root;
    }


    public void stop(Joueur joueur) throws Exception{
        PrintWriter pseudo = new PrintWriter("src/resources/css/pseudo.txt","UTF-8");
        pseudo.println(joueur.getPseudoJoueur());
        pseudo.flush();
        pseudo.close();
    }
}
