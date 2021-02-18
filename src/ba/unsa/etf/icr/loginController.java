package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class loginController {
    public Button nazad1Btn;
    public TextField usernameFld;
    public PasswordField passwFld;
    public Label labelaPoruka;

    public void izadjiAction(ActionEvent actionEvent) {
        ((Stage) nazad1Btn.getScene().getWindow()).close();
    }

    public void idiNaPocetnuAction(ActionEvent actionEvent) throws IOException {
       /* usernameFld.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!usernameFld.getText().equals("niko1")){*/
        //when it not matches the pattern (1.0 - 6.0)
                  /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Greška");
                    alert.setHeaderText("Korisnik sa unesenim korisničkim podacima ne postoji u bazi.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        alert.close();
                    }
                    alert.close();


                    usernameFld.setText("");
                }
            }

        });*/
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/odabirPocetna.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Početna");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }
}
