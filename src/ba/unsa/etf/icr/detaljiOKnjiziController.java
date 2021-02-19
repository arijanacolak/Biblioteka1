package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class detaljiOKnjiziController {
    public Button nazad;
    public Button zaduzi;
    public Label nazivKnjigeLabela;
    public Label autorLabela;

    public void zatvoriAction(ActionEvent actionEvent) {
        ((Stage) nazad.getScene().getWindow()).close();
    }

    public void zaduziAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sretno");
        alert.setHeaderText("Uspješno ste zadužili knjigu.");
        alert.setContentText("Ugodno čitanje Vam želimo.");
        alert.showAndWait();
        ((Stage) zaduzi.getScene().getWindow()).close();
    }
}
