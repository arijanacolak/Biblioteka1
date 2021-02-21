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

public class odabirKnjigeController {
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

    private KnjigeModel model;
    public odabirKnjigeController(KnjigeModel model) {
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
            noviprozor.podaciFld.setText("Ime i prezime: Neko Nekić\nAdresa stanovanja: Nepoznata bb\nE-mail: neko.nekic@gmail.com\nTrenutno selektovana knjiga: " + tblKnjige.getSelectionModel().getSelectedItem().getNazivKnjige() + "\nImate pravo zadužiti još jednu knjigu!\n\nPrethodno zaduženu knjigu je potrebno vratiti za 5 dana!");
            myStage.setTitle("Zaduzenje knjige");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu!");
            alert.setContentText("Potrebno je da selektujete željenu knjigu za ovu vrstu akcije!");
            alert.showAndWait();
        }

    }

    public void provjeraDostupnostiKnjige(ActionEvent actionEvent) throws IOException {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregledDostupnosti.fxml"));
            Parent root = loader.load();
            pregledDostupnostiController noviprozor = loader.getController();
            noviprozor.lokacijaKnjigeTxtArea.setText(" Knjiga koju ste odabrali \n (" + tblKnjige.getSelectionModel().getSelectedItem().getNazivKnjige() + ") nalazi se\n na drugom spratu, polica B2.\n Ugodno čitanje!");
            myStage.setTitle("Pregled dostupnosti");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu!");
            alert.setContentText("Potrebno je da selektujete željenu knjigu za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

    public void openPrevious(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }

    public void pregledDetaljaOKnjigama(ActionEvent actionEvent) throws IOException {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null) {
            Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/detaljiOKnjizi.fxml"));
        Parent root = loader.load();
        detaljiOKnjiziController noviprozor = loader.getController();
        noviprozor.nazivKnjigeLabela.setText(" Naziv knjige: " + tblKnjige.getSelectionModel().getSelectedItem().getNazivKnjige());
        noviprozor.autorLabela.setText(" Autor: " + tblKnjige.getSelectionModel().getSelectedItem().getAutor());
        myStage.setTitle("Pregled detalja");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu!");
            alert.setContentText("Potrebno je da selektujete željenu knjigu za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

    public void pregledRecenzija(ActionEvent actionEvent) throws IOException {
        if(tblKnjige.getSelectionModel().getSelectedItem() != null) {

            Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregledRecenzija.fxml"));
        Parent root = loader.load();
        recenzijeController noviprozor = loader.getController();
        noviprozor.nazivLabela.setText(" Naziv knjige: " + tblKnjige.getSelectionModel().getSelectedItem().getNazivKnjige());
        noviprozor.autorLabela.setText(" Autor: " + tblKnjige.getSelectionModel().getSelectedItem().getAutor());
        myStage.setTitle("Pregled recenzija");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Niste selektovali knjigu!");
            alert.setContentText("Potrebno je da selektujete željenu knjigu za ovu vrstu akcije!");
            alert.showAndWait();
        }
    }

    public void pretragaPoNazivu(ActionEvent actionEvent) {
    }

    public void pretragaPoAutoru(ActionEvent actionEvent) {
    }

    public void pretragaPoJeziku(ActionEvent actionEvent) {
    }
}
