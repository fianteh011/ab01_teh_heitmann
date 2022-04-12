package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WareDTO;
import de.hsos.swa.ssa.suchen.acl.Warenkorb;
import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.acl.WarenkorbStaender;
import de.hsos.swa.ssa.suchen.bl.Ware;

/**
 * “nutzt”-Beziehung zwischen WarenkobVerwalten und Schnitstellen
 * WarenkorbStaender, WarenkorbFuerSuche
 * (Klasse kommt im Code
 * vor, gibt aber keine
 * Objektvariable)*/
public class WarenkorbVerwalten implements WaehleWare, WarenkorbStaender, WarenkorbFuerSuche {

    private WarenKoverter konverter;


    public WarenkorbVerwalten() {
        this.konverter = new WarenKoverter();
    }

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        return true;
    }

    @Override
    public boolean wareHinzufuegen(WareDTO ware) {
        return true;
    }

    @Override
    public long gebeWarenkorbnummer() {
        return 1;
    }

    @Override
    public Warenkorb holeWarenkorb() {
        return new Warenkorb();
    }

    @Override
    public Warenkorb holeWarenkorb(long warenkorbnummer) {
        return new Warenkorb();
    }
}
