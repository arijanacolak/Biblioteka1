package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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

        ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();

        listaKnjiga.addAll(tblKnjige.getItems());
    }

    public void urediKnjiguAction(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/urediKnjigu.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Uredite podatke o knjizi");
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void obrisiKnjiguAction(ActionEvent actionEvent) {
    }

    public void nazadAction(ActionEvent actionEvent) {
        ((Stage) btnNazad.getScene().getWindow()).close();
    }
}
