package ba.unsa.etf.icr;

import javafx.beans.property.SimpleStringProperty;

public class Knjiga {
    private String nazivKnjige, autor, kategorija, izdavac, izdavanje, jezik;
    private Integer id, isbn, font;

        public Knjiga(){

        }
    public Knjiga(Integer id, String nazivKnjige, String autor, String kategorija, String izdavac, String izdavanje, String jezik, Integer isbn, Integer font) {
        this.nazivKnjige = nazivKnjige;
        this.autor = autor;
        this.kategorija = kategorija;
        this.izdavac = izdavac;
        this.izdavanje = izdavanje;
        this.jezik = jezik;
        this.id = id;
        this.isbn = isbn;
        this.font = font;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public String getIzdavanje() {
        return izdavanje;
    }

    public void setIzdavanje(String izdavanje) {
        this.izdavanje = izdavanje;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getFont() {
        return font;
    }

    public void setFont(Integer font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return nazivKnjige + ", " + autor;
    }
}
