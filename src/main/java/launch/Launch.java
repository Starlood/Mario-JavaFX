package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import model.Joueur;
import model.JoueurView;

/**
 * Gere le lancement de l'application
 */
public class Launch extends Application {
    /**
     * Methode permettant le lancement de l'application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        try{
            final URL url = getClass().getResource("/vueaccueil.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = fxmlLoader.load();
            final Scene Scene = new Scene(root);
            Scene.getStylesheets().add(getClass().getResource("/Accueil.css").toExternalForm());
            primaryStage.setScene(Scene);
        }
        catch (IOException ex){
            System.err.println("Erreur lors du chargement " + ex);
        }

         primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/super-mario-icon.png")));
        primaryStage.setTitle("Menu Mario");
        primaryStage.show();



    }
}
