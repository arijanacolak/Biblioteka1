package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class zaduzenjeKnjigeController {
    public TextField unesiId;
    public TextArea podaciFld;
    public Button nazadBtn;
    public Button potvrdaBtn;

    public void zaduziKnjigu(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sretno");
        alert.setHeaderText("Uspješno ste zadužili knjigu.");
        alert.setContentText("Ugodno čitanje Vam želimo.");
        alert.showAndWait();
        ((Stage) potvrdaBtn.getScene().getWindow()).close();
    }

    public void otvoriPrethodni(ActionEvent actionEvent) {
        ((Stage) nazadBtn.getScene().getWindow()).close();
    }
}