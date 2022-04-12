package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Ware;

import java.sql.Connection;
import java.util.List;

public interface WarenSuche {
    List<Ware> sucheWare(String suchbegriff, Connection connection);


}
