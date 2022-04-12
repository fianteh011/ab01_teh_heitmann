package de.hsos.swa.ssa.suchen.acl;

public interface WarenkorbFuerSuche {
    boolean wareHinzufuegen(WareDTO ware);
    long gebeWarenkorbnummer();
}
