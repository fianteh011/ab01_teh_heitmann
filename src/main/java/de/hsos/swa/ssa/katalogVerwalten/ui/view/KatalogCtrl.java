package de.hsos.swa.ssa.katalogVerwalten.ui.view;

import de.hsos.swa.ssa.katalogVerwalten.bl.KatalogIntf;

public class KatalogCtrl {

    private KatalogIntf katalogHinzufuegen;

    public KatalogCtrl(KatalogIntf katalogHinzufuegen) {

        this.katalogHinzufuegen = katalogHinzufuegen;
    }
    public void hizufuegen_Katalog(int warennummer){
        this.katalogHinzufuegen.hinzufuegen(warennummer);
    }

    public void loesche_Katalog(int warennummer){

        this.katalogHinzufuegen.loeschen(warennummer);
    }
}
