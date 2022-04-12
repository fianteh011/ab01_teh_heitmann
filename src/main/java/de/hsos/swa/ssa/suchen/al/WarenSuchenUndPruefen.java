package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.ProduktInformation;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.suchen.dal.WarenRepository;

import java.util.List;

public class WarenSuchenUndPruefen {

    private Katalog katalog;

    public WarenSuchenUndPruefen(){
        this.katalog = new WarenRepository();
    }

    public List<Ware> suche(String warenname){
        return this.katalog.suche(warenname);
    }

    public Ware pruefen(long warenNummer){
        return this.katalog.suche(warenNummer);
    }

    public List<ProduktInformation> produktInformationList(Ware ware){
        return this.katalog.gebeProduktinformation(ware);
    }
}
