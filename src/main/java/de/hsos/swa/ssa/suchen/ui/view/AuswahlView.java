package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.WaehleWare;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.ui.view.GeneralView;

import java.util.Scanner;

public class AuswahlView implements GeneralView {

    private WaehleWare waehleWare;
    private SuchView suchView;

    public AuswahlView(WaehleWare waehleWare, SuchView suchView) {
        this.waehleWare = waehleWare;
        this.suchView = suchView;
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("****************AUSWAHL**************");
        System.out.println("Gebe die Warennummer ein, um eine Ware zum Warenkorb hinzuzufuegen.\n");

        int warennummer_tmp = 1;
        do {
            if (scn.hasNextInt()){
                warennummer_tmp = scn.nextInt();
            }
        } while (warennummer_tmp != 0);

        Ware ware_tmp = this.suchView.searchWareById(warennummer_tmp);
        if (ware_tmp == null){
            System.out.println("Ware mit der ID: " + warennummer_tmp + "nicht gefunden");

        }

        if (this.waehleWare.wareZuWarenkorbHinzufuegen(ware_tmp)){
            String result = "Ware " + ware_tmp.getName() + "mit Warennummer " + ware_tmp.getWarennummer() +
                    "wurde im Warenkorb hinzugefuegt";
            System.out.println(result);
        } else {
            System.out.println("Error: Code unkown");
        }

    }
}
