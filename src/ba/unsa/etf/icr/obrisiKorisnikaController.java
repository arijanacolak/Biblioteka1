package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class obrisiKorisnikaController {
    public Button btnNazad;
    public Button btnDetaljniPrikazPodatakaOKorisniku;

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void detaljniPrikazPodatakaAction(ActionEvent actionEvent) {
    }

    //potrebno dodati uslov da je selektovan korisnik iz tabele
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
}
