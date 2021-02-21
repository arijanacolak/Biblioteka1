package ba.unsa.etf.icr;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class historijaKorisnika {

    public Label lblIme;
    public Label lblPrezime;
    public Label lblEmail;
    public Label lblAdresa;
    public Label lblDatumZaduzenja;
    public Label lblDatumVracanja;
    public Label lblPrethodnoZaduzena1;
    public Label lblPrethodnoZaduzena2;
    public Label lblTrenutnoZaduzenaKnjiga;


    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) lblIme.getScene().getWindow()).close();
    }
}
