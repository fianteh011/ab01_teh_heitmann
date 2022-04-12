package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Ware;

import java.util.List;

public interface SucheWare {
    List<Ware> sucheWare(String warenname);
    Ware sucheWare(long warennummer);
}
