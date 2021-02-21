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

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class pregledDostupnostiPocetnaController {
    public Button btnNazad;
    public TextField fldPretragaPoNazivu;
    public TextField fldPretragaPoAutoru;
    public TextField fldPretragaPoJeziku;
    public Button btnZaduziKnjigu;
    public TableView tblKnjige;
    public TableColumn columnNaziv;
    public TableColumn columnJezik;
    public TableColumn columnAutor;

    private KnjigeModel model;
    public pregledDostupnostiPocetnaController(KnjigeModel model) {
        this.model = model;
    }

    public void initialize(){
        tblKnjige.setItems(model.getKnjige());
        columnNaziv.setCellValueFactory(new PropertyValueFactory<>("nazivKnjige"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        columnJezik.setCellValueFactory(new PropertyValueFactory<>("jezik"));

        ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(tblKnjige.getItems());
        FilteredList<Knjiga> filteredData = new FilteredList<>(listaKnjiga, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        fldPretragaPoNazivu.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getNazivKnjige()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.
                }
                return false; // Does not match.
            });
        });

        fldPretragaPoAutoru.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getAutor()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.
                }
                return false; // Does not match.
            });
        });

        fldPretragaPoJeziku.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getJezik()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Knjiga> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tblKnjige.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        tblKnjige.setItems(sortedData);
    }

    public void zaduziKnjigu(ActionEvent actionEvent) throws IOException {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/zaduzenje_knjige.fxml"));
            Parent root = loader.load();
            zaduzenjeKnjigeController noviprozor = loader.getController();
            noviprozor.podaciFld.setText("Ime i prezime: Neko Nekić\nAdresa stanovanja: Nepoznata bb\nE-mail: neko.nekic@gmail.com\nTrenutno selektovana knjiga: " + tblKnjige.getSelectionModel().getSelectedItem().toString() + "\nImate pravo zadužiti još jednu knjigu!\n\nPrethodno zaduženu knjigu je potrebno vratiti za 5 dana!");
            myStage.setTitle("Zaduzenje knjige");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu!");
            alert.setContentText("Potrebno je da selektujete željenu knjigu za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

    public void pretragaPoJeziku(ActionEvent actionEvent) {
    }

    public void pretragaPoAutoru(ActionEvent actionEvent) {
    }

    public void pretragaPoNazivu(ActionEvent actionEvent) {
    }

    public void openPrevious(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }
}
