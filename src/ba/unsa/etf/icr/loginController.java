package ba.unsa.etf.icr;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class loginController {
    public Button nazad1Btn;
    public TextField usernameFld;
    public PasswordField passwFld;
    public Label labelaPoruka;
    public Button potvrdiBtn;

    public void initialize() {
       // usernameFld.getStyleClass().add("poljeNijeIspravno");
        /*usernameFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.isEmpty()==true || !n.equals("niko1")) {
                   // usernameFld.getStyleClass().add("poljeNijeIspravno");
                    labelaPoruka.setText("Neispravan username");
                    potvrdiBtn.setDisable(true);
                } else {
                    //usernameFld.getStyleClass().removeAll("poljeNijeIspravno");
                    labelaPoruka.setText("");
                    potvrdiBtn.setDisable(false);
                }
            }
        });
        passwFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.isEmpty()==true || !n.equals("1234")) {
                    // usernameFld.getStyleClass().add("poljeNijeIspravno");
                    labelaPoruka.setText("Neispravni korisnički podaci");
                } else {
                    //usernameFld.getStyleClass().removeAll("poljeNijeIspravno");
                    labelaPoruka.setText("");
                }
            }
        });*/
    }


    public void izadjiAction(ActionEvent actionEvent) {
        ((Stage) nazad1Btn.getScene().getWindow()).close();
    }
    public boolean validacija() {
        if(usernameFld.getText().isEmpty() || !usernameFld.getText().equals("niko1") || !passwFld.getText().equals("1234")) return false;
        else return true;
    }

    public void idiNaPocetnuAction(ActionEvent actionEvent) throws IOException {
        if(validacija() == true) {
            labelaPoruka.setText("");
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/odabirPocetna.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Početna");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else {
            labelaPoruka.setText("Neispravni korisnički podaci.");
        }
    }

    public void otvoriAction(ActionEvent actionEvent) throws IOException {
        if(validacija() == true) {
            labelaPoruka.setText("");
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/odabirPocetna.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Početna");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else {
            labelaPoruka.setText("Neispravni korisnički podaci.");
        }
    }
}
