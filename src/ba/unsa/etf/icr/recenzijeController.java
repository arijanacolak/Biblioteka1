package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class recenzijeController {

    public Button nazad;
    public Button dodajKomentarBtn;
    public Label nazivLabela;
    public Label autorLabela;

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) nazad.getScene().getWindow()).close();
    }

    public void dodajKomentarAction(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodajKomentar.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Detalji o knjizi");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }
}
