package de.hsos.swa.ssa.ui.view;

import de.hsos.swa.ssa.bezahlen.ui.view.BezahlenStartView;
import de.hsos.swa.ssa.suchen.ui.view.SuchenStartView;
import de.hsos.swa.ssa.warenkorb.ui.view.WarenkorbStartView;

public class MenueControl implements GeneralController {

    private GeneralView menueView;
    private GeneralView begruesView;
    private GeneralView navView;

    public MenueControl() {
       this.initView();
    }

    private void initView(){
        this.begruesView = new BegruessungView();
        this.begruesView.showOutput();
        this.menueView = new MenueView(this);
        this.menueView.showOutput();
    }

    @Override
    public void sendInput(String message) {

        int auswahl = Integer.parseInt(message);
        switch (auswahl){
            case 1:
                this.navView = new SuchenStartView();
                break;
            case 2:
                this.navView = new WarenkorbStartView();
                break;
            case 3:
                this.navView = new BezahlenStartView();
            case 4:
                this.navView = new de.hsos.swa.ssa.katalogVerwalten.ui.view.MenueView();
                break;
            default:
                System.err.println("Error: case not found");
                break;
        }
        this.navView.showOutput();
    }
}
