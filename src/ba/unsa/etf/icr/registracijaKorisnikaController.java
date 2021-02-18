package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    public void actionCacelButton(ActionEvent actionEvent) {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
