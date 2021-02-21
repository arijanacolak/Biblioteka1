package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;
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
    public TextField pretragaPoID;
    public TextField pretragaPoImenu;
    private KorisnikModel model;
    public obrisiKorisnikaController(KorisnikModel model) {
        this.model = model;
    }
    public obrisiKorisnikaController(){}

    public void initialize(){
        tableKorisnici.setItems(model.getKorisnici());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        columMail.setCellValueFactory(new PropertyValueFactory<>("email"));

        filtriranjePodataka();
    }
    public void filtriranjePodataka(){
        ObservableList<Korisnik> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(model.getKorisnici());

        //  ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();

        // listaKnjiga.addAll(tableKorisnici.getItems());
        FilteredList<Korisnik> filteredData = new FilteredList<>(listaKnjiga, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        pretragaPoID.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getId()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.
                }
                return false; // Does not match.
            });
        });

        pretragaPoImenu.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getIme()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Korisnik> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableKorisnici.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        tableKorisnici.setItems(sortedData);
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
            podaci.fldEmail.setText(tableKorisnici.getSelectionModel().getSelectedItem().getEmail());
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
            alert.setHeaderText("Niste selektovali korisnika!");
            alert.setContentText("Potrebno je da selektujete željenog korisnika za ovu vrstu akcije!");
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
                Korisnik korisnik = new Korisnik();
                for (Korisnik x: model.getKorisnici()) {
                    if(x.equals(tableKorisnici.getSelectionModel().getSelectedItem())) korisnik = x;
                }

                model.getKorisnici().remove(korisnik);
                filtriranjePodataka();
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
        if(tableKorisnici.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediKorisnika.fxml"));
            Parent root = loader.load();
            urediKorisnikaController podaci = loader.getController();

            podaci.fldIme.setText(tableKorisnici.getSelectionModel().getSelectedItem().getIme());
            podaci.fldPrezime.setText(tableKorisnici.getSelectionModel().getSelectedItem().getPrezime());
            podaci.fldImeRoditelja.setText(tableKorisnici.getSelectionModel().getSelectedItem().getImeRoditelja());
            podaci.fldEmail.setText(tableKorisnici.getSelectionModel().getSelectedItem().getEmail());
            podaci.fldAdresaPrebivalista.setText(tableKorisnici.getSelectionModel().getSelectedItem().getAdresaPrebivalista());
            podaci.fldJMBG.setText(tableKorisnici.getSelectionModel().getSelectedItem().getJmbg().toString());
            podaci.fldPostanskiBroj.setText(tableKorisnici.getSelectionModel().getSelectedItem().getPostanskiBroj().toString());
            podaci.dateDatumRodjenja.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getDatumRodjenja());
            podaci.comboMjestoRodjenja.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getMjestoRodjenja());
            podaci.comboMjestoPrebivalista.setValue(tableKorisnici.getSelectionModel().getSelectedItem().getMjestoPrebivalista());

            myStage.setTitle("Uredi podatke o korisniku");
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
