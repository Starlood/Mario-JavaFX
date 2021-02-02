package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import niveau.Niveau;
import niveau.Niveau1;
import niveau.Niveau2;
import niveau.Niveau3;

import java.io.IOException;

/**
 * Permet au joueur de choisir le niveau
 */
public class ControlerNiveau {
    @FXML
    private Label pseudo;
    private String lePseudo;

    public ControlerNiveau(String text) {
        lePseudo=text;
    }

    /**
     * Initialisation du niveau
     */
    @FXML
    private void initialize(){

        pseudo.setText(lePseudo);
        pseudo.setFont(Font.font(30));
        pseudo.setTextFill(Color.web("#2196f3"));
    }

    @FXML
    public void choixniveau1 (ActionEvent actionEvent) throws IOException {
        Niveau niveau = new Niveau1();
        niveau.creerNiveau();
    }

    @FXML
    public void choixniveau2(ActionEvent actionEvent) throws IOException {
        Niveau niveau = new Niveau2();
        niveau.creerNiveau();
    }

    @FXML
    public void choixniveau3(ActionEvent actionEvent) throws IOException {
        Niveau niveau = new Niveau3();
        niveau.creerNiveau();
    }
}
