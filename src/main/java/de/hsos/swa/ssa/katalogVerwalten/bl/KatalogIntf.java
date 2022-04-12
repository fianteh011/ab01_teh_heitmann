package de.hsos.swa.ssa.katalogVerwalten.bl;

public interface KatalogIntf {
    void hinzufuegen(long warennummer);
    void loeschen(long warennummer);
    public Ware sucheWare(long warennummer);
    void hinzufuegen(Ware ware); // von Package katalogVW
    void updateWare(Ware ware);

}
