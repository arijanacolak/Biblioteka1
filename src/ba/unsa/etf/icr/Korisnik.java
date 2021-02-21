package ba.unsa.etf.icr;

import java.time.LocalDate;

public class Korisnik {
    private String ime, prezime, email, imeRoditelja, adresaPrebivalista, mjestoRodjenja, mjestoPrebivalista, prethodnoZaduzenaKnjige1,prethodnoZaduzenaKnjige2, trenutnoZaduzeneKnjige;
    private String datumZaduzenja, datumVracanja;
    private Integer jmbg, postanskiBroj, id;
    private LocalDate datumRodjenja;

    public Korisnik() {}

    public Korisnik(String ime, String prezime, String email, String adresaPrebivalista, String prethodnoZaduzenaKnjige1, String prethodnoZaduzenaKnjige2, String trenutnoZaduzeneKnjige, String datumZaduzenja, String datumVracanja) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresaPrebivalista = adresaPrebivalista;
        this.prethodnoZaduzenaKnjige1 = prethodnoZaduzenaKnjige1;
        this.prethodnoZaduzenaKnjige2 = prethodnoZaduzenaKnjige2;
        this.trenutnoZaduzeneKnjige = trenutnoZaduzeneKnjige;
        this.datumZaduzenja = datumZaduzenja;
        this.datumVracanja = datumVracanja;
    }

    public Korisnik(Integer id, String ime, String prezime, String email, String imeRoditelja, String adresaPrebivalista, String mjestoRodjenja, String mjestoPrebivalista, Integer jmbg, Integer postanskiBroj, LocalDate datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.imeRoditelja = imeRoditelja;
        this.adresaPrebivalista = adresaPrebivalista;
        this.mjestoRodjenja = mjestoRodjenja;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.jmbg = jmbg;
        this.postanskiBroj = postanskiBroj;
        this.datumRodjenja = datumRodjenja;
    }
    public Korisnik(Integer id, String ime, String prezime, String imeRoditelja, String adresaPrebivalista, String mjestoRodjenja, String mjestoPrebivalista, Integer jmbg, Integer postanskiBroj, LocalDate datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = "";
        this.imeRoditelja = imeRoditelja;
        this.adresaPrebivalista = adresaPrebivalista;
        this.mjestoRodjenja = mjestoRodjenja;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.jmbg = jmbg;
        this.postanskiBroj = postanskiBroj;
        this.datumRodjenja = datumRodjenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public String getAdresaPrebivalista() {
        return adresaPrebivalista;
    }

    public void setAdresaPrebivalista(String adresaPrebivalista) {
        this.adresaPrebivalista = adresaPrebivalista;
    }

    public String getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    public String getMjestoPrebivalista() {
        return mjestoPrebivalista;
    }

    public void setMjestoPrebivalista(String mjestoPrebivalista) {
        this.mjestoPrebivalista = mjestoPrebivalista;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Integer postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrethodnoZaduzenaKnjige1() {
        return prethodnoZaduzenaKnjige1;
    }

    public void setPrethodnoZaduzenaKnjige1(String prethodnoZaduzenaKnjige1) {
        this.prethodnoZaduzenaKnjige1 = prethodnoZaduzenaKnjige1;
    }

    public String getPrethodnoZaduzenaKnjige2() {
        return prethodnoZaduzenaKnjige2;
    }

    public void setPrethodnoZaduzenaKnjige2(String prethodnoZaduzenaKnjige2) {
        this.prethodnoZaduzenaKnjige2 = prethodnoZaduzenaKnjige2;
    }

    public String getTrenutnoZaduzeneKnjige() {
        return trenutnoZaduzeneKnjige;
    }

    public void setTrenutnoZaduzeneKnjige(String trenutnoZaduzeneKnjige) {
        this.trenutnoZaduzeneKnjige = trenutnoZaduzeneKnjige;
    }

    public String getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(String datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public String getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(String datumVracanja) {
        this.datumVracanja = datumVracanja;
    }
}
