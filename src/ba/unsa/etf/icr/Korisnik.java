package ba.unsa.etf.icr;

import java.time.LocalDate;

public class Korisnik {
    private String ime, prezime, imeRoditelja, adresaPrebivalista, mjestoRodjenja, mjestoPrebivalista;
    private Integer jmbg, postanskiBroj;
    private LocalDate datumRodjenja;

    public Korisnik() {}

    public Korisnik(String ime, String prezime, String imeRoditelja, String adresaPrebivalista, String mjestoRodjenja, String mjestoPrebivalista, Integer jmbg, Integer postanskiBroj, LocalDate datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
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
}
