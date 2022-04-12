package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.al.HoleWarenkorb;
import de.hsos.swa.ssa.ui.view.GeneralController;

public class SuchenStartControl implements GeneralController {

    private HoleWarenkorb holeWarenkorb;
    public SuchenStartControl(HoleWarenkorb hw) {
        this.holeWarenkorb = hw;
    }

    @Override
    public void sendInput(String message) {

    }

    public WarenkorbFuerSuche getWarenkorb(){
        return this.holeWarenkorb.holeWarenkorb();
    }
}
