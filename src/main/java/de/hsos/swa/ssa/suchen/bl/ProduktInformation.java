package de.hsos.swa.ssa.suchen.bl;

public class ProduktInformation {
    private String bezeichnung;
    private Object information;

    public ProduktInformation(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
}
