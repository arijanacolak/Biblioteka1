package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class obrisiKorisnikaController {
    public Button btnNazad;
    public Button btnUrediPodatke;
    public Button btnDetaljniPrikazPodatakaOKorisniku;
    public TableView<Korisnik> tableKorisnici;
    public TableColumn columnId;
    public TableColumn columnIme;
    public TableColumn columMail;
    private KorisnikModel model;
    public obrisiKorisnikaController(KorisnikModel model) {
        this.model = model;
    }

    public void initialize(){
        tableKorisnici.setItems(model.getKorisnici());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        columMail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Korisnik> listaKnjiga = FXCollections.observableArrayList();



        listaKnjiga.addAll(tableKorisnici.getItems());

    }

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void detaljniPrikazPodatakaAction(ActionEvent actionEvent) throws IOException {
        if(tableKorisnici.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/detaljniPrikazPodataka.fxml"));
            Parent root = loader.load();
            detaljniPrikazPodataka podaci = loader.getController();

            podaci.fldIme.setText(tableKorisnici.getSelectionModel().getSelectedItem().getIme());
            podaci.fldPrezime.setText(tableKorisnici.getSelectionModel().getSelectedItem().getPrezime());
            podaci.fldImeRoditelja.setText(tableKorisnici.getSelectionModel().getSelectedItem().getImeRoditelja());
            podaci.fldAdresaPrebivalista.setText(tableKorisnici.getSelectionModel().getSelectedItem().getAdresaPrebivalista());
            podaci.fldJmbg.setText(tableKorisnici.getSelectionModel().getSelectedItem().getJmbg().toString());
            podaci.fldPostanskiBroj.setText(tableKorisnici.getSelectionModel().getSelectedItem().getPostanskiBroj().toString());
            podaci.dateDatumRodjenja.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getDatumRodjenja());
            podaci.comboMjestoRodjenja.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getMjestoRodjenja());
            podaci.comboMjestoPrebivalista.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getMjestoPrebivalista());

            myStage.setTitle("Podaci o korisniku");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu.");
            alert.setContentText("Da biste otvorili ovaj prozor, potrebno je da selektujete željenu knjigu!");
            alert.showAndWait();
        }

    }

    //potrebno dodati uslov da je selektovan korisnik iz tabele
    public void obrisiKorisnikaAction(ActionEvent actionEvent) {
        if (tableKorisnici.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrda");
            alert.setHeaderText("Potvrda o brisanju selektovanog korisnika.");
            alert.setContentText("Jeste li sigurni da želite obrisati selektovanog korisnika?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Korisnik korisnik =  new Korisnik();
                for (Korisnik x: model.getKorisnici()) {
                    if(tableKorisnici.getSelectionModel().getSelectedItem().equals(x)) korisnik = x;
                }

                model.getKorisnici().remove(korisnik);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Potvrda");
                alert1.setHeaderText("Korisnik uspješno obrisan.");
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    alert.close();
                }
                alert.close();
            } else {
                alert.close();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali korisnika!");
            alert.setContentText("Potrebno je da selektujete željenog korisnika za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

    public void urediPodatkeAction(ActionEvent event) throws IOException {
        if (tableKorisnici.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediKorisnika.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Uredite podatke o korisniku");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali korisnika!");
            alert.setContentText("Potrebno je da selektujete željenog korisnika za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }
}
