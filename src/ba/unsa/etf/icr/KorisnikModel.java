package ba.unsa.etf.icr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KorisnikModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private ObservableList<Korisnik> korisniciHistorija = FXCollections.observableArrayList();
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

    public void napuniZaHistoriju(){
        korisniciHistorija.add(new Korisnik("Ime1", "Prezime1", "ime1@etf.unsa.ba", "Adresa1 bb", "Stepski Vuk", "Tvrđava", "Derviš i smrt", "19/02/2021", "05/03/2021"));
        korisniciHistorija.add(new Korisnik("Ime2", "Prezime2", "ime2@etf.unsa.ba", "Adresa2 bb", "Stepski Vuk", "Legenda o Ali-paši", "Hamlet", "16/02/2021", "02/03/2021"));
        korisniciHistorija.add(new Korisnik("Ime3", "Prezime3", "ime3@etf.unsa.ba", "Adresa3 bb", "Roman o Ajvazu", "", "Madame Bovary", "10/02/2021", "25/02/2021"));
        trenutniKorisnik.set(null);
    }

    public ObservableList<Korisnik> getKorisniciHistorija() {
        return korisniciHistorija;
    }

    public void setKorisniciHistorija(ObservableList<Korisnik> korisniciHistorija) {
        this.korisniciHistorija = korisniciHistorija;
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
