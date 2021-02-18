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
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Controller {
    public Button nazad1Btn;
    public Button potvrdiBtn;
    public TextField usernameFld;
    public PasswordField passwFld;
    public Label labelaPoruka;
    public TextField fldPretragaPoNazivu;
    public TextField fldPretragaPoAutoru;
    public TextField fldPretragaPoJeziku;
    public Button btnPregledRecenzija;
    public Button btnPregledDetaljaOKnjigama;
    public Button btnZaduziKnjigu;
    public Button btnProvjeraDostupostiKnjige;
    public TableView<Knjiga> tblKnjige;
    public TableColumn columnNaziv;
    public TableColumn columnAutor;
    public TableColumn columnJezik;
    public Button btnNazad;

    /* private KnjigeModel model;
     public odabirKnjigeController(KnjigeModel model) {
         this.model = model;
     }
 */
    public Controller() {
    }

    public void initialize() {
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
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/zaduzenje_knjige.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Zaduzenje knjige");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();

    }

    public void provjeraDostupnostiKnjige(ActionEvent actionEvent) {

    }

    public void openPrevious(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void pregledDetaljaOKnjigama(ActionEvent actionEvent) {
    }

    public void pregledRecenzija(ActionEvent actionEvent) {
    }

    public void pretragaPoNazivu(ActionEvent actionEvent) {
    }

    public void pretragaPoAutoru(ActionEvent actionEvent) {
    }

    public void pretragaPoJeziku(ActionEvent actionEvent) {
    }
}

