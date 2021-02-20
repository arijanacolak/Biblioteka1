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
       korisnici.add(new Korisnik(1,"Ime1", "Prezime1","email1@etf.unsa.ba", "ImeRoditelja1", "adresa bb 1","Sarajevo", "Sarajevo", 123456789, 71000, LocalDate.now()));
        korisnici.add(new Korisnik(2,"Ime2", "Prezime2", "email2@etf.unsa.ba","ImeRoditelja2", "adresa bb 2","Mostar", "Sarajevo", 123654789, 71000, LocalDate.now()));
        korisnici.add(new Korisnik(3,"Ime3", "Prezime3", "email3@etf.unsa.ba","ImeRoditelja3", "adresa bb 3","Bihać", "Sarajevo", 213131254, 71000, LocalDate.now()));
        korisnici.add(new Korisnik(4,"Ime4", "Prezime4", "email4@etf.unsa.ba","ImeRoditelja4", "adresa bb 4","Sarajevo", "Sarajevo", 123687456, 71000, LocalDate.now()));
        korisnici.add(new Korisnik(5,"Ime5", "Prezime5", "email5@etf.unsa.ba","ImeRoditelja5", "adresa bb 5","Sarajevo", "Sarajevo", 256987456, 71000, LocalDate.now()));


        trenutniKorisnik.set(null);

    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
}
