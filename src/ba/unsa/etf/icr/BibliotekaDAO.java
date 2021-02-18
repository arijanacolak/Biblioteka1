package ba.unsa.etf.icr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class BibliotekaDAO {

    private static BibliotekaDAO instance = null;
    private Connection connection;
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private PreparedStatement getAllBooks;

    public BibliotekaDAO() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            getAllBooks = connection.prepareStatement("select * from Knjige");
            getAllBooks.executeQuery();
        } catch (SQLException throwables) {
            resetDatabase();
        }

    }

    public void resetDatabase() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("library.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if (sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement stmt = connection.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ne postoji SQL datoteka… nastavljam sa praznom bazom");
        }

    }
    public static BibliotekaDAO getInstance() {
        if (instance == null) instance = new BibliotekaDAO();
        return instance;
    }


}