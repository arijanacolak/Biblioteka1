package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class zaduzenjeKnjigeController {
    public TextField unesiId;
    public TextArea podaciFld;
    public Button nazadBtn;
    public Button potvrdaBtn;
    public Label labela;

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