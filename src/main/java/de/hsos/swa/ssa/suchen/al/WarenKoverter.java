package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WareDTO;
import de.hsos.swa.ssa.suchen.bl.Ware;

/**
 *
 * dient als Service in der AppLogik
 * hier wird die Ubiquitaere Sprache ausgedrueckt
 * Dienste ordnen keinem Entity zu
 */
public class WarenKoverter {

    public WareDTO wareToDto(Ware ware){
        //erstellt aus WareDataTransferObject
        //Datenkapselung und Daten-Aggregration

        return new WareDTO(ware.getWarennummer(), ware.getName(), ware.getPreis(), ware.getBeschreibung());
    }
}
