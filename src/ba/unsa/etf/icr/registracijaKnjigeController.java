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
        if(!knjigaField.getText().equals("") && knjigaField.getText() != null &&
                !autorField.getText().equals("") && autorField.getText() != null &&
                !ISBNField.getText().equals("") && ISBNField.getText() != null &&
                !izdavacField.getText().equals("") && izdavacField.getText() != null &&
                !izdanjeField.getText().equals("") && izdanjeField.getText() != null &&
        kategorijaComboBox.getValue() != null && jezikComboBox.getValue() != null &&
                fontComboBox.getValue() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrdi");
            alert.setHeaderText("Potvrda o dodavanju nove knjige.");
            alert.setContentText("Jeste li sigurni da želite dodati novu knjigu?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                knjigaField.setStyle("-fx-background-color: lightgreen");
                autorField.setStyle("-fx-background-color: lightgreen");
                ISBNField.setStyle("-fx-background-color: lightgreen");
                izdavacField.setStyle("-fx-background-color: lightgreen");
                izdanjeField.setStyle("-fx-background-color: lightgreen");
                kategorijaComboBox.setStyle("-fx-background-color: lightgreen");
                jezikComboBox.setStyle("-fx-background-color: lightgreen");
                fontComboBox.setStyle("-fx-background-color: lightgreen");

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
        } else{
            if(knjigaField.getText().equals("") || knjigaField.getText() == null) knjigaField.setStyle("-fx-background-color: lightpink");
            else knjigaField.setStyle("-fx-background-color: lightgreen");

            if(autorField.getText().equals("") || autorField.getText() == null) autorField.setStyle("-fx-background-color: lightpink");
            else autorField.setStyle("-fx-background-color: lightgreen");

            if(ISBNField.getText().equals("") || ISBNField.getText() == null) ISBNField.setStyle("-fx-background-color: lightpink");
            else ISBNField.setStyle("-fx-background-color: lightgreen");

            if(izdavacField.getText().equals("") || izdavacField.getText() == null) izdavacField.setStyle("-fx-background-color: lightpink");
            else izdavacField.setStyle("-fx-background-color: lightgreen");

            if(izdanjeField.getText().equals("") || izdanjeField.getText() == null) izdanjeField.setStyle("-fx-background-color: lightpink");
            else izdanjeField.setStyle("-fx-background-color: lightgreen");

            if(!kategorijaComboBox.isPressed() || kategorijaComboBox.getValue() == null) kategorijaComboBox.setStyle("-fx-background-color: lightpink");
            else kategorijaComboBox.setStyle("-fx-background-color: lightgreen");

            if(!jezikComboBox.isPressed() || jezikComboBox.getValue() == null) jezikComboBox.setStyle("-fx-background-color: lightpink");
            else jezikComboBox.setStyle("-fx-background-color: lightgreen");

            if(!fontComboBox.isPressed() || fontComboBox.getValue() == null) fontComboBox.setStyle("-fx-background-color: lightpink");
            else fontComboBox.setStyle("-fx-background-color: lightgreen");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nije moguće dodati knjigu!");
            alert.setContentText("Niste popunili sva input polja!");

            alert.showAndWait();
        }
    }

    public void actionCacelButton(ActionEvent actionEvent) {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
