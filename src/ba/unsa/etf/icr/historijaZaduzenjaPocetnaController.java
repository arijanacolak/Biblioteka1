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
    public TableView tblKorisnici;
    public TableColumn columnNaziv;
    public TableColumn columnJezik;
    public TableColumn columnAutor;
    public Button btnNazad;
    public Button btnNazad1;
    private KorisnikModel model;
    public historijaZaduzenjaPocetnaController(KorisnikModel model) {
        this.model = model;
    }
    public historijaZaduzenjaPocetnaController(){}

    public void initialize() {
        tblKorisnici.setItems(model.getKorisnici());
        columnNaziv.setCellValueFactory(new PropertyValueFactory<>("ime"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        columnJezik.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Korisnik> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(tblKorisnici.getItems());
    }
  /*  public void openPrevious(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }*/

    /*public void zatvori(ActionEvent actionEvent) {
        ((Stage) btnNazad1.getScene().getWindow()).close();
    }*/
}
