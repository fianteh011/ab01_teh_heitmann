package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.Warenkorb;
import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.ProduktInformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

import java.util.ArrayList;
import java.util.List;

public class EinkauferIn implements HoleWarenkorb, SucheWare, PruefeWare, WaehleWare{

    private WarenkorbVerwalten wrkorbVW;
    private WarenSuchenUndPruefen wrSuP;

    public EinkauferIn() {
        this.wrkorbVW = new WarenkorbVerwalten();
        this.wrSuP = new WarenSuchenUndPruefen();
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb() {
        return this.wrkorbVW;
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb(long warenkorbnummer) {
        return this.wrkorbVW;
    }

    @Override
    public List<ProduktInformation> holeDetailonformation(Ware ware) {
        return this.wrSuP.produktInformationList(ware);
    }

    @Override
    public List<Ware> sucheWare(String warenname) {
        List<Ware> wareList= new ArrayList<>();
        wareList.add(new Ware(1,"Maus", 20,"tolle Maus"));
        return this.wrSuP.suche(warenname);
    }

    @Override
    public Ware sucheWare(long warennummer) {
        Ware tmp = new Ware(1, "Maus", 20, "tolle Maus");
        tmp.addProduktinformation(new ProduktInformation("tolle Maus!"));
        return this.wrSuP.pruefen(warennummer);

    }

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        return true;
    }
}
