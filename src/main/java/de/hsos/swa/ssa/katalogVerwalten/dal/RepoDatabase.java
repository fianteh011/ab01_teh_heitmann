package de.hsos.swa.ssa.katalogVerwalten.dal;

import de.hsos.swa.ssa.katalogVerwalten.bl.KatalogIntf;
import de.hsos.swa.ssa.katalogVerwalten.bl.Ware;

import java.sql.*;

public class RepoDatabase implements KatalogIntf {

    private Connection conn;

    static final String DB_URL = "jdbc:mysql://localhost:3306/swashop";
    static final String USER = "root";
    static final String PASS = "sheiSef8cken909";

    public RepoDatabase() {

        try{
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //Aufgabe 1.4  auf Ebene der JDBC Datenbank-Connection
            //AutoCommit auf false gesetzt werden soll (connection.setAutoCommit(false)).
            this.conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Erfolgreicher Verbindungsaufbau");
            } else {
                System.out.println("Failed to connect to DB!");
            }

        } catch (
                SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void hinzufuegen(long warennummer) {
        Statement stmt;
        String query = "INSERT INTO katalog (Warennummer) VALUES  ("+ warennummer +")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loeschen(long warennummer) {
        Statement stmt = null;
        String query = "DELETE FROM katalog WHERE warennummer ="+ warennummer;
        Ware w = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Ware sucheWare(long warennummer) {
        Statement stmt = null;
        String query = "SELECT ware.warennummer, ware.name, ware.preis, ware.beschreibung " +
                "FROM katalog INNER JOIN ware " +
                "ON katalog.warennummer = ware.warennummer " +
                "WHERE katalog.warennummer = "+warennummer;
        Ware tmp = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                tmp = new Ware(rs.getInt("warennummer"), rs.getString("name"),  rs.getInt("preis"), rs.getString("beschreibung"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    @Override
    public void hinzufuegen(Ware ware) {
        Statement stmt = null;
        String query = "INSERT INTO ware(Name, Preis, Bescheribung) " +
                "VALUES ( \" " + ware.getName() + "\" ," +
                ware.getBeschreibung()
                + ware.getPreis() + ")";

        try {
            stmt = conn.createStatement();
            stmt.executeQuery(query);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateWare(Ware ware) {
        Statement stmt = null;
        String query = "UPDATE ware SET Name = \""
                + ware.getName() + "\", Beschreibung = \""+ ware.getBeschreibung() +"\", Preis = "+ ware.getPreis()+ "WHERE warennummer="+ ware.getWarennummer();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery(query);
            rs.close();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
