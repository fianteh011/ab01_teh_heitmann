package de.hsos.swa.ssa.suchen.bl;

import java.util.ArrayList;
import java.util.List;

public class Ware {

    private long warennummer;
    private String name;
    private int preis;
    private String beschreibung;
    private List<ProduktInformation> p;

    public Ware(long warennummer, String name, int preis, String beschreibung) {
        this.warennummer = warennummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.p = new ArrayList<ProduktInformation>();
    }

    public long getWarennummer() {
        return warennummer;
    }

    public String getName() {
        return name;
    }

    public int getPreis() {
        return preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void addProduktinformation(ProduktInformation pro) {
        p.add(pro);
    }
}
