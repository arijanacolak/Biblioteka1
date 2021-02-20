package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class urediKnjiguController {
    public Button btnNazad;
    public Button btnObrisiKnjigu;
    public Button btnSpasiPromjene;
    public TextField fldNazivKnjige;
    public TextField fldAutorKnjige;
    public TextField fldISBN;
    public TextField fldKategorija;
    public TextField fldIzdavac;
    public TextField fldIzdanje;
    public TextField fldJezik;
    public TextField fldFont;

    public void nazad(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void obrisiKnjiguAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda");
        alert.setHeaderText("Potvrda o brisanju selektovane knjige.");
        alert.setContentText("Jeste li sigurni da želite obrisati selektovanu knjigu?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Potvrda");
            alert1.setHeaderText("Knjiga uspješno obrisana.");
            Optional<ButtonType> result1 = alert1.showAndWait();
            if (result.get() == ButtonType.OK) {
                alert.close();
            }
            alert.close();
        } else {
            alert.close();
        }
    }

    public void spasiPromjeneAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrda");
        alert.setHeaderText("Potvrda o spašavanju promjena selektovanje knjiige.");
        alert.setContentText("Jeste li sigurni da želite promjeniti podatke o selektovanoj knjizi?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Potvrda");
            alert1.setHeaderText("Podaci o knjizi su uspješno ažurirani.");
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
