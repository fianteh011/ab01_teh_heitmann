package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Ware;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

//Klasse gibt ein leeres Array zurueck, da Implementierung
// des Algorithmuses zu aufwendig war.


public class SemanticMatching implements WarenSuche{
    @Override
    public List<Ware> sucheWare(String suchbegriff, Connection connection) {
        return new ArrayList<>();
    }
}
