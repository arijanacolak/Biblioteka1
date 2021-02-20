package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Optional;

public class obrisiKorisnikaController {
    public Button btnNazad;
    public Button btnDetaljniPrikazPodatakaOKorisniku;
    public TableView<Korisnik> tableKorisnici;
    public TableColumn columnId;
    public TableColumn columnIme;
    public TableColumn columMail;
    private KorisnikModel model;
    public obrisiKorisnikaController(KorisnikModel model) {
        this.model = model;
    }

    public void initialize(){
        tableKorisnici.setItems(model.getKorisnici());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        columMail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Korisnik> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(tableKorisnici.getItems());
    }

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void detaljniPrikazPodatakaAction(ActionEvent actionEvent) {
    }

    //potrebno dodati uslov da je selektovan korisnik iz tabele
    public void obrisiKorisnikaAction(ActionEvent actionEvent) {
        if (tableKorisnici.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrda");
            alert.setHeaderText("Potvrda o brisanju selektovanog korisnika.");
            alert.setContentText("Jeste li sigurni da želite obrisati selektovanog korisnika?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Korisnik korisnik =  new Korisnik();
                for (Korisnik x: model.getKorisnici()) {
                    if(tableKorisnici.getSelectionModel().getSelectedItem().equals(x)) korisnik = x;
                }

                model.getKorisnici().remove(korisnik);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Potvrda");
                alert1.setHeaderText("Korisnik uspješno obrisan.");
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    alert.close();
                }
                alert.close();
            } else {
                alert.close();
            }
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
