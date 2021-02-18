package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class dodajKOmentarController {
    public Button nazad;
    public Button potvrdi;

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) nazad.getScene().getWindow()).close();
    }

    public void potvrdiAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sretno");
        alert.setHeaderText("Uspješno ste dodali komentar.");
        alert.setContentText("");
        alert.showAndWait();
        ((Stage) potvrdi.getScene().getWindow()).close();
    }
}
