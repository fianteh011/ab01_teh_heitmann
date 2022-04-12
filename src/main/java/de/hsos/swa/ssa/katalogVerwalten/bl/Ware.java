package de.hsos.swa.ssa.katalogVerwalten.bl;

public class Ware {
    private long warennummer;
    private String name;
    private int preis;
    private String beschreibung;

    public Ware(long warennummer, String name, int preis, String beschreibung) {
        this.warennummer = warennummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
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
}
