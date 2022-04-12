package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.ProduktInformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

import java.util.List;

public interface PruefeWare {
    List<ProduktInformation> holeDetailonformation(Ware ware);
}
