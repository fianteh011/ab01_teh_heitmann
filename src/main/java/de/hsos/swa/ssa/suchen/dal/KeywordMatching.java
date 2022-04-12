package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Ware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// SQL Statement Src: https://www.w3schools.com/sql/sql_like.asp
public class KeywordMatching implements WarenSuche{

    @Override
    public List<Ware> sucheWare(String suchbegriff, Connection connection) {
        Statement stmt = null;
        //LIKE dient zur Suche eines spezifischen Musters innerhalb einer Spalte
        String query = "SELECT ware.warennummer, ware.name, ware.preis, ware.beschreibung " +
                "FROM katalog " +
                "INNER JOIN ware " +
                "ON katalog.warennummer = ware.warennummer " +
                "WHERE ware.name LIKE '%" +  suchbegriff + "%'";
        // The percent sign (%) represents zero, one, or multiple characters
        List<Ware> itemList = new ArrayList<>();

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                itemList.add(new Ware(
                        rs.getLong("warennummer"),
                        rs.getString("name"),
                        rs.getInt("preis"),
                        rs.getString("beschreibung")
                ));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return itemList;

    }
}
