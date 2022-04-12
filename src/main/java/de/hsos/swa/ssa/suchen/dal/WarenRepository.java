package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.ProduktInformation;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarenRepository implements Katalog {

    private WarenSuche suchAlgorithmus;
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3306/swashop";
    static final String USER = "root";
    static final String PW = "sheiSef8cken909";

    public WarenRepository() {
        //default Suchalgorithmus festlegen
        this.suchAlgorithmus = SuchAlgorithmus.KEYWORD.whichAlgo();

        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PW);

            if (connection != null){
                System.out.println("Erfolgreicher Verbindungsaufbau!");
            } else {
                System.out.println("Failed to connect to DB!");
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }

    @Override
    public void legeSuchalgorithmusFest(SuchAlgorithmus algo) {
        this.suchAlgorithmus = algo.whichAlgo();
    }

    @Override
    public List<Ware> suche(String warenName) {
        return this.suchAlgorithmus.sucheWare(warenName, this.connection);
    }

    @Override
    public Ware suche(long warenNummer) {
        Statement stmt = null;
        Ware tmp = null;
        //QUery dient zur Suche einer Ware mit jeweiligen Attributen
        String query = "SELECT ware.warennummer, ware.name, ware.preis, ware.beschreibung " +
                "FROM katalog " +
                "INNER JOIN ware " +
                "ON katalog.warennummer = ware.warennummer " +
                "WHERE katalog.warennummer = " + warenNummer;


        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tmp = (new Ware(
                        rs.getLong("warennummer"),
                        rs.getString("name"),
                        rs.getInt("preis"),
                        rs.getString("beschreibung")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tmp;


    }

    @Override
    public List<ProduktInformation> gebeProduktinformation(Ware ware) {
        Statement stmt = null;
        String QUERY = "SELECT * "
                + "FROM produktdetails " +
                "WHERE warennummer="
                +ware.getWarennummer();
        List<ProduktInformation> produktInformations = new ArrayList<>();
        try {
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                produktInformations.add(new ProduktInformation(rs.getString("bezeichnung")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produktInformations;
    }
}
