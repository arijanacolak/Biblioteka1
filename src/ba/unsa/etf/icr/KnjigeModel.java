package ba.unsa.etf.icr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KnjigeModel {
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private SimpleObjectProperty<Knjiga> trenutnaKnjiga = new SimpleObjectProperty<>();

    public KnjigeModel() {
    }

    public void napuni() {
        knjige.add(new Knjiga(1, "Derviš i smrt", "Meša Selimović", "drama", "Svjetlost", "1970", "bs", 12346, 12));
        knjige.add(new Knjiga(2, "Hamlet", "William Shakespeare", "drama", "Svjetlost", "2005", "bs", 12345, 12));
        knjige.add(new Knjiga(3, "Legenda o Ali-paši", "Enver Čolaković", "roman", "Svjetlost", "2005", "bs", 12348, 12));
        knjige.add(new Knjiga(4, "Madame Bovary", "Gustav Flaubert", "roman", "Svjetlost", "2005", "bs", 12345, 12));
        knjige.add(new Knjiga(5, "Roman o Ajvazu", "Mirsad Sinanović", "roman", "Svjetlost", "2005", "bs", 12349, 12));
        knjige.add(new Knjiga(6, "Stepski vuk", "Hermann Hesse", "roman", "Svjetlost", "2005", "bs", 12347, 12));
        knjige.add(new Knjiga(7, "Tvrđava", "Meša Selimović", "drama", "Svjetlost", "2007", "bs", 12345, 12));

        trenutnaKnjiga.set(null);

        trenutnaKnjiga.set(null);
    }

    public ObservableList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ObservableList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Knjiga getTrenutnaKnjiga() {
        return trenutnaKnjiga.get();
    }

    public SimpleObjectProperty<Knjiga> trenutnaKnjigaProperty() {
        return trenutnaKnjiga;
    }

    public void setTrenutnaKnjiga(Knjiga trenutnaKnjiga) {
        this.trenutnaKnjiga.set(trenutnaKnjiga);
    }
}
