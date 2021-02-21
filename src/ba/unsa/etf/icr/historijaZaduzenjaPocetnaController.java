package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    public void provjeriAction(ActionEvent actionEvent) {
    }

}
