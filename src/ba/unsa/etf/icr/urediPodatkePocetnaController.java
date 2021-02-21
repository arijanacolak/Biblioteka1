package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class urediPodatkePocetnaController {

    public Button btnNazad;
/*
    public void urediPodatkeOKorisniku(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediKorisnika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Uredite podatke o korisniku");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }
*/
    public void urediPodatkeOKnjizi(ActionEvent actionEvent) throws IOException {
        KnjigeModel model = new KnjigeModel();
        model.napuni();
        knjigeZaBrisanjeUredjivanjeController ctrl = new knjigeZaBrisanjeUredjivanjeController(model);
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/knjigeZaUredjivanjeBrisanje.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        myStage.setTitle("Spisak knjiga");
        //myStage.initOwner(tbAddOwner.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void obrisiKorisnika(ActionEvent actionEvent) throws IOException {
        KorisnikModel model = new KorisnikModel();
        model.napuni();
        obrisiKorisnikaController ctrl = new obrisiKorisnikaController(model);
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/obrisiKorisnika.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        myStage.setTitle("Spisak korisnika");
        //myStage.initOwner(tbAddOwner.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }
/*
    public void obrisiKnjigu(ActionEvent actionEvent) throws IOException {
        KnjigeModel model = new KnjigeModel();
        model.napuni();
        knjigeZaBrisanjeUredjivanjeController ctrl = new knjigeZaBrisanjeUredjivanjeController(model);
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/knjigeZaUredjivanjeBrisanje.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        myStage.setTitle("Spisak knjiga");
        //myStage.initOwner(tbAddOwner.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }*/

    public void nazad(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }
}
