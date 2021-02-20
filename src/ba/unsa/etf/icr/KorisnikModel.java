package ba.unsa.etf.icr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KorisnikModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisnikModel() {
    }

    public void napuni() {
       korisnici.add(new Korisnik("Ime1", "Prezime1", "ImeRoditelja1", "adresa bb 1","Sarajevo", "Sarajevo", 123456789, 71000, LocalDate.now()));
        trenutniKorisnik.set(null);

    }

}
