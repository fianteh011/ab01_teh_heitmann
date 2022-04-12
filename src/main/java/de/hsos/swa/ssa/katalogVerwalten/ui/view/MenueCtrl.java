package de.hsos.swa.ssa.katalogVerwalten.ui.view;

import de.hsos.swa.ssa.katalogVerwalten.dal.RepoDatabase;
import de.hsos.swa.ssa.ui.view.GeneralController;
import de.hsos.swa.ssa.ui.view.GeneralView;

public class MenueCtrl implements GeneralController {
    private RepoDatabase db;
    private GeneralView navView;

    public MenueCtrl(){
        db = new RepoDatabase();
    }


    @Override
    public void sendInput(String message) {
        int auswahl = Integer.parseInt(message);
        switch (auswahl) {
            case 1:
                return;
            case 2:
                this.navView = new KatalogView(this.db);
            default:
                System.err.println("Abort");
        }
        this.navView.showOutput();
    }
}
