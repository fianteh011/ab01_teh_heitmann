package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.al.EinkauferIn;
import de.hsos.swa.ssa.ui.view.GeneralController;
import de.hsos.swa.ssa.ui.view.GeneralView;

public class SuchenMenueControl implements GeneralController {

    private GeneralView navigationView;
    private GeneralController generalController;
    private WarenkorbFuerSuche warenkorbFuerSuche;
    private EinkauferIn einkaufer;

    public SuchenMenueControl(){
        this.einkaufer = new EinkauferIn();
        this.generalController = new SuchenStartControl(einkaufer);
        this.warenkorbFuerSuche = this.einkaufer.holeWarenkorb();
    }
    public void waehleView(int selection){
        switch (selection) {
            case 1:
                this.navigationView = new SuchView(einkaufer);
                break;
            case 2:
                this.navigationView = new PruefView(einkaufer, new SuchView(einkaufer));
                break;
            case 3:
                this.navigationView = new AuswahlView(einkaufer, new SuchView(einkaufer));
                break;
            case 4:
                return;
            default:
                System.err.println("Error: case not found");
                return;
        }
        this.navigationView.showOutput();
    }

    @Override
    public void sendInput(String message) {

    }
}
