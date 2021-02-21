package ba.unsa.etf.icr;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.Optional;

public class registracijaKnjigeController {


    public TextField knjigaField;
    public TextField autorField;
    public TextField ISBNField;
    public ComboBox kategorijaComboBox;
    public TextField izdavacField;
    public TextField izdanjeField;
    public ComboBox jezikComboBox;
    public ComboBox fontComboBox;
    public Button okButton;
    public Button cancelButton;

    public void initialize(){

        ObservableList<String> kategorija = FXCollections.observableArrayList();
        kategorija.addAll("roman", "drama", "triler", "horor");
        kategorijaComboBox.setItems(kategorija);

        ObservableList<String> jezik = FXCollections.observableArrayList();
        jezik.addAll("bs", "en");
        jezikComboBox.setItems(jezik);

        ObservableList<String> font = FXCollections.observableArrayList();
        font.addAll("12", "13", "15", "20");
        fontComboBox.setItems(font);


    }
    /*public Button okButton;
        public TextField postalNumberField;
        public ComboBox addressPlace;
        public ComboBox placeOfBirth;
        public DatePicker dateField;
        public TextField addressField;
        public TextField jmbgField;
        public TextField parentNameField;
        public TextField surnameField;
        public TextField nameField;

        public void actionOkButton(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrdi");
            alert.setHeaderText("Potvrda o dodavanju novog korisnika.");
            alert.setContentText("Jeste li sigurni da želite dodati ovog korisnika?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Potvrdi");
                alert1.setHeaderText("Korisnik uspješno dodan.");
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    alert.close();
                }
                alert.close();
            } else {
                alert.close();
            }
        }
    */
    /*ObservableList<String> options =
            FXCollections.observableArrayList(
                    "Option 1",
                    "Option 2",
                    "Option 3"
            );

    public void setKategorijaComboBox(ComboBox kategorijaComboBox) {
        this.kategorijaComboBox = kategorijaComboBox;
        kategorijaComboBox.setItems(options);
    }*/

    public void actionOkButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrdi");
        alert.setHeaderText("Potvrda o dodavanju nove knjige.");
        alert.setContentText("Jeste li sigurni da želite dodati novu knjigu?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Potvrdi");
            alert1.setHeaderText("Knjiga uspješno dodana.");
            Optional<ButtonType> result1 = alert1.showAndWait();
            if (result.get() == ButtonType.OK) {
                alert.close();
            }
            alert.close();
        } else {
            alert.close();
        }
        //((Stage) OkButton.getScene().getWindow()).close();

    }

    public void actionCacelButton(ActionEvent actionEvent) {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
