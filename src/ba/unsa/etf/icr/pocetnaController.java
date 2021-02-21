package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class pocetnaController {
    public Button registracijaKorisnikabtn;
    public Button registracijaKnjigeBtn;
    public Button odabirKnjigeBtn;
    public Button provjeraDostupnostiKnjigeBtn;
    public Button provjeraHistorijeZaduzenjaBtn;
    public Button urediPodatkeBtn;
    public Button nazadBtn;

    /*private KnjigeModel model;
    public odabirKnjigeController(KnjigeModel model) {
        this.model = model;
    }*/

    public void registracijaKorisnika(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registracijaKorisnika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Registracija korisnika");
        //myStage.initOwner(tbAddOwner.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void registracijaKnjige(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registracijaKnjige.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Registracija knjige");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void openBooks(ActionEvent actionEvent) throws IOException {
        KnjigeModel model = new KnjigeModel();
        model.napuni();
        odabirKnjigeController ctrl = new odabirKnjigeController(model);
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/odabirKnjige.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        myStage.setTitle("Pregled i odabir knjige");
        //myStage.initOwner(tbAddOwner.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void openPrevious(ActionEvent actionEvent) {
        ((Stage) nazadBtn.getScene().getWindow()).close();
    }

    public void urediPodatke(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediPodatkePocetna.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Uredite podatke");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void provjeraDostupnostiAction(ActionEvent actionEvent) throws IOException {
        KnjigeModel model = new KnjigeModel();
        model.napuni();
        pregledDostupnostiPocetnaController ctrl = new pregledDostupnostiPocetnaController(model);
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregledDostupnostiKnjiga.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        myStage.setTitle("Pregled dostupnosti knjiga");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }
}
