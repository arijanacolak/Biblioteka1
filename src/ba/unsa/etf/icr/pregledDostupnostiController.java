package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class pregledDostupnostiController {
    public Button btnPrviSprat;
    public Button btnDrugiSprat;
    public Button nazadBtn;
    public ImageView slikaView;
    public Button nazad1Btn;
    public TextArea lokacijaKnjigeTxtArea;
    public Button btnZatvoriPrviSprat;
    public Button btnZatvoriDrugiSprat;

    public void actionCacelButton(ActionEvent actionEvent) {
        ((Stage) nazadBtn.getScene().getWindow()).close();
    }

    public void prikaziPrviSpratAction(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/prviSprat.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Prvi sprat");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void prikaziDrugiSpratAction(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/prviSprat.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Prvi sprat");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void zatvoriPrviSpratAction(ActionEvent actionEvent) {
        ((Stage) btnZatvoriPrviSprat.getScene().getWindow()).close();
    }

    public void zatvoriDrugiSpratAction(ActionEvent actionEvent) {
        ((Stage) btnZatvoriDrugiSprat.getScene().getWindow()).close();
    }

  /* public void nazadAction(ActionEvent actionEvent) {
        ((Stage) nazadBtn.getScene().getWindow()).close();
    }*/
}
