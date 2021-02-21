package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class detaljniPrikazPodataka {
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldImeRoditelja;
    public TextField fldAdresaPrebivalista;
    public TextField fldJmbg;
    public DatePicker dateDatumRodjenja;
    public ComboBox comboMjestoRodjenja;
    public ComboBox comboMjestoPrebivalista;
    public TextField fldPostanskiBroj;
    public Button btnNazad;
    public TextField fldEmail;

    public detaljniPrikazPodataka(){

    }

    public void initialize(){
        ObservableList<String> listaGradova = FXCollections.observableArrayList();
        listaGradova.addAll("Sarajevo", "Mostar", "Bihać", "Banja Luka");

        comboMjestoPrebivalista.setItems(listaGradova);
        comboMjestoRodjenja.setItems(listaGradova);
    }
    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }
}
