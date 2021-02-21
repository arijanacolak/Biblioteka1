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
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class knjigeZaBrisanjeUredjivanjeController {
    public TextField fldPretragaPoNazivu;
    public TextField fldPretragaPoAutoru;
    public TextField fldPretragaPoJeziku;
    public Button btnUrediKnjigu;
    public Button btnObrisiKnjigu;
    public Button btnNazad;
    public TableView<Knjiga> tblKnjige;
    public TableColumn columnNaziv;
    public TableColumn columnAutor;
    public TableColumn columnJezik;

    private KnjigeModel model;

    public knjigeZaBrisanjeUredjivanjeController(KnjigeModel model) {
        this.model = model;
    }
    public void initialize(){
        tblKnjige.setItems(model.getKnjige());
        columnNaziv.setCellValueFactory(new PropertyValueFactory<>("nazivKnjige"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        columnJezik.setCellValueFactory(new PropertyValueFactory<>("jezik"));
        filtriranjePodataka();
    }

    public void filtriranjePodataka(){
        ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(model.getKnjige());

        // ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();

        // listaKnjiga.addAll(tblKnjige.getItems());
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

    public void urediKnjiguAction(ActionEvent actionEvent) throws IOException {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediKnjigu.fxml"));
            Parent root = loader.load();
            urediKnjiguController podaci = loader.getController();

            podaci.fldNazivKnjige.setText(tblKnjige.getSelectionModel().getSelectedItem().getNazivKnjige());
            podaci.fldAutorKnjige.setText(tblKnjige.getSelectionModel().getSelectedItem().getAutor());
            podaci.fldKategorija.setText(tblKnjige.getSelectionModel().getSelectedItem().getKategorija());
            podaci.fldFont.setText(tblKnjige.getSelectionModel().getSelectedItem().getFont().toString());
            podaci.fldISBN.setText(tblKnjige.getSelectionModel().getSelectedItem().getIsbn().toString());
            podaci.fldIzdavac.setText(tblKnjige.getSelectionModel().getSelectedItem().getIzdavac());
            podaci.fldIzdanje.setText(tblKnjige.getSelectionModel().getSelectedItem().getIzdavanje());
            podaci.fldJezik.setText(tblKnjige.getSelectionModel().getSelectedItem().getJezik());

            myStage.setTitle("Uredite podatke o knjizi");
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

    public void obrisiKnjiguAction(ActionEvent actionEvent) {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potvrda");
            alert.setHeaderText("Da li ste sigurni da želite obrisati knjigu?");
            alert.setContentText("Pritisnite OK ako jeste!");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                ObservableList<Knjiga> primjer = model.getKnjige();
                Knjiga knjigaZaRemove = new Knjiga();
                for (Knjiga knjiga: primjer) {
                    if(knjiga.equals(tblKnjige.getSelectionModel().getSelectedItem())) knjigaZaRemove = knjiga;
                }
               model.getKnjige().remove(knjigaZaRemove);
                filtriranjePodataka();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Potvrda");
                alert1.setHeaderText(null);
                alert1.setContentText("Uspješno ste obrisali selektovanu knjigu!");

                alert1.showAndWait();
            } else {
                alert.showAndWait();
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu.");
            alert.setContentText("Da biste otvorili ovaj prozor, potrebno je da selektujete željenu knjigu!");
            alert.showAndWait();
        }

    }

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }
}
