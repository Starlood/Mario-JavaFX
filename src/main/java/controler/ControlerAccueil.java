package controler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Joueur;

import java.io.*;
import java.util.Scanner;

/**
 * Gère la page d'accueil
 */
public class ControlerAccueil {
    @FXML
    private TextField champPseudo;
    @FXML
    private Label erreur;
    @FXML
    private javafx.scene.control.Button playBtn;


    /**
     * Fonction permettant d'afficher le pseudo enregistré
     */
    @FXML
    public void initialize(){
        try {
            File file = new File("src/resources/css/pseudo.txt");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    champPseudo.setText(scanner.next());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } finally {

        }
    }

    /**
     * Page permettant de gérer le choix des niveaux
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void ChoisirNiveaux(ActionEvent actionEvent) throws IOException {
        if (champPseudo.getText().equals("")){
            erreur.setText("Veuillez remplir votre pseudo");
        }
        else {
            try {
                PrintWriter pseudo = new PrintWriter("src/resources/css/pseudo.txt","UTF-8");
                pseudo.println(champPseudo.getText());
                pseudo.flush();
                pseudo.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            FXMLLoader loadder = new FXMLLoader(getClass().getResource("/fxml/vuechoixniveau.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            ControlerNiveau newCon = new ControlerNiveau(champPseudo.getText());
            loadder.setController(newCon);
            Scene scene = new Scene(loadder.load());
            scene.getStylesheets().add(getClass().getResource("/Accueil.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Mario " + champPseudo.getText());
            stage.show();
        }
    }


}