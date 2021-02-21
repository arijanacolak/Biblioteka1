package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class historijaZaduzenjaPocetnaController {

    public TableView<Korisnik> tblKorisnici;
    public TableColumn columnIme;
    public TableColumn columnPrezime;
    public TableColumn columEmail;
    public Button btnNazad;
    public Button btnProvjeri;

    KorisnikModel model;
    public historijaZaduzenjaPocetnaController(){}
    public historijaZaduzenjaPocetnaController(KorisnikModel model){
        this.model = model;
    }

    public void initialize() {
        tblKorisnici.setItems(model.getKorisniciHistorija());
        columnIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        columnPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Korisnik> listaKorisnika = FXCollections.observableArrayList();

        listaKorisnika.addAll(tblKorisnici.getItems());
    }

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void provjeriAction(ActionEvent actionEvent) throws IOException {
        if(tblKorisnici.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/historijaKorisnika.fxml"));
            Parent root = loader.load();
            historijaKorisnika podaci = loader.getController();

            podaci.lblIme.setText(tblKorisnici.getSelectionModel().getSelectedItem().getIme());
            podaci.lblPrezime.setText(tblKorisnici.getSelectionModel().getSelectedItem().getPrezime());
            podaci.lblAdresa.setText(tblKorisnici.getSelectionModel().getSelectedItem().getAdresaPrebivalista());
            podaci.lblEmail.setText(tblKorisnici.getSelectionModel().getSelectedItem().getEmail());
            podaci.lblPrethodnoZaduzena1.setText(tblKorisnici.getSelectionModel().getSelectedItem().getPrethodnoZaduzenaKnjige1());
            podaci.lblPrethodnoZaduzena2.setText(tblKorisnici.getSelectionModel().getSelectedItem().getPrethodnoZaduzenaKnjige2());
            podaci.lblTrenutnoZaduzenaKnjiga.setText(tblKorisnici.getSelectionModel().getSelectedItem().getTrenutnoZaduzeneKnjige());
            podaci.lblDatumVracanja.setText(tblKorisnici.getSelectionModel().getSelectedItem().getDatumVracanja());
            podaci.lblDatumZaduzenja.setText(tblKorisnici.getSelectionModel().getSelectedItem().getDatumZaduzenja());
            myStage.setTitle("Podaci o korisniku");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali korisnika!");
            alert.setContentText("Potrebno je da selektujete željenog korisnika za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

}
