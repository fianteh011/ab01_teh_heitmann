package de.hsos.swa.ssa.suchen.bl;

import java.util.List;

public interface Katalog {
    void legeSuchalgorithmusFest(SuchAlgorithmus algo);
    List<Ware> suche (String warenName);
    Ware suche(long warenNummer);
    List<ProduktInformation> gebeProduktinformation(Ware ware);

}
