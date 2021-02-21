package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Optional;

public class registracijaKorisnikaController {
    public Button cancelButton;
    public Button okButton;
    public TextField postalNumberField;
    public ComboBox addressPlace;
    public ComboBox placeOfBirth;
    public DatePicker dateField;
    public TextField addressField;
    public TextField jmbgField;
    public TextField parentNameField;
    public TextField surnameField;
    public TextField nameField;

    public void initialize(){
        ObservableList<String> gradovi = FXCollections.observableArrayList();
        gradovi.addAll("Sarajevo", "Mostar", "Bihać", "Banja Luka", "Konjic");

        addressPlace.setItems(gradovi);
        placeOfBirth.setItems(gradovi);
    }
    public void actionOkButton(ActionEvent actionEvent) {
        if(nameField.getText() != null && !nameField.getText().equals("")&& surnameField.getText() != null && !surnameField.getText().equals("") && parentNameField.getText() != null && !parentNameField.getText().equals("") &&
           jmbgField.getText() != null && !jmbgField.getText().equals("") && addressField.getText() != null && !addressField.getText().equals("") && addressPlace.getValue() != null && dateField.getValue().isBefore(ChronoLocalDate.from(LocalDateTime.now())) &&
           placeOfBirth.getValue() != null && addressPlace.getValue() != null && postalNumberField.getText() != null && !postalNumberField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrdi");
            alert.setHeaderText("Potvrda o dodavanju novog korisnika.");
            alert.setContentText("Jeste li sigurni da želite dodati ovog korisnika?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                nameField.setStyle("-fx-background-color: lightgreen");
                surnameField.setStyle("-fx-background-color: lightgreen");
                parentNameField.setStyle("-fx-background-color: lightgreen");
                jmbgField.setStyle("-fx-background-color: lightgreen");
                addressField.setStyle("-fx-background-color: lightgreen");
                addressPlace.setStyle("-fx-background-color: lightgreen");
                dateField.setStyle("-fx-background-color: lightgreen");
                placeOfBirth.setStyle("-fx-background-color: lightgreen");
                postalNumberField.setStyle("-fx-background-color: lightgreen");

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
        else{
            if(nameField.getText().equals("") || nameField.getText() == null) nameField.setStyle("-fx-background-color: lightpink");
            else nameField.setStyle("-fx-background-color: lightgreen");

            if(surnameField.getText().equals("") || surnameField.getText() == null) surnameField.setStyle("-fx-background-color: lightpink");
            else surnameField.setStyle("-fx-background-color: lightgreen");

            if(parentNameField.getText().equals("") || parentNameField.getText() == null) parentNameField.setStyle("-fx-background-color: lightpink");
            else parentNameField.setStyle("-fx-background-color: lightgreen");

            if(jmbgField.getText().equals("") || jmbgField.getText() == null) jmbgField.setStyle("-fx-background-color: lightpink");
            else jmbgField.setStyle("-fx-background-color: lightgreen");

            if(addressField.getText().equals("") || addressField.getText() == null) addressField.setStyle("-fx-background-color: lightpink");
            else addressField.setStyle("-fx-background-color: lightgreen");

            if(addressPlace.getValue() == null) addressPlace.setStyle("-fx-background-color: lightpink");
            else addressPlace.setStyle("-fx-background-color: lightgreen");

            if(!dateField.isPressed() || dateField.getValue().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) dateField.setStyle("-fx-background-color: lightpink");
            else {
                dateField.getStyleClass().removeAll();
                dateField.setStyle("-fx-background-color: lightgreen");
            }

            if(placeOfBirth.getValue() == null) placeOfBirth.setStyle("-fx-background-color: lightpink");
            else placeOfBirth.setStyle("-fx-background-color: lightgreen");


            if(postalNumberField.getText().equals("") || postalNumberField.getText() == null) postalNumberField.setStyle("-fx-background-color: lightpink");
            else postalNumberField.setStyle("-fx-background-color: lightgreen");


            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nije moguće dodati korisnika!");
            alert.setContentText("Niste popunili sva input polja!");

            alert.showAndWait();
        }
    }

    public void actionCacelButton(ActionEvent actionEvent) {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
