package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class urediKorisnikaController {

    public Button btnNazad;
    public Button btnObrisiKorisnika;
    public Button btnSpasiPromjene;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldImeRoditelja;
    public TextField fldAdresaPrebivalista;
    public TextField fldEmail;
    public TextField fldJMBG;
    public DatePicker dateDatumRodjenja;
    public ComboBox comboMjestoRodjenja;
    public ComboBox comboMjestoPrebivalista;
    public TextField fldPostanskiBroj;



    public void initialize(){
        ObservableList<String> listaGradova = FXCollections.observableArrayList();
        listaGradova.addAll("Sarajevo", "Mostar", "Bihać", "Banja Luka");

        comboMjestoPrebivalista.setItems(listaGradova);
        comboMjestoRodjenja.setItems(listaGradova);
    }

    public void nazad(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void obrisiKorisnikaAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda");
        alert.setHeaderText("Potvrda o brisanju selektovanog korisnika.");
        alert.setContentText("Jeste li sigurni da želite obrisati selektovanog korisnika?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
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

    public void spasiPromjeneAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda");
        alert.setHeaderText("Potvrda o spašavanju promjena podataka o korisniku.");
        alert.setContentText("Jeste li sigurni da želite spasiti promjene?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Potvrda");
            alert1.setHeaderText("Promjene su uspješno ažurirane.");
            Optional<ButtonType> result1 = alert1.showAndWait();
            if (result.get() == ButtonType.OK) {
                alert.close();
            }
            alert.close();
        } else {
            alert.close();
        }
    }
}
