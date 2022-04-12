package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.PruefeWare;
import de.hsos.swa.ssa.suchen.bl.ProduktInformation;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.ui.view.GeneralView;

import java.util.List;
import java.util.Scanner;

public class PruefView implements GeneralView {

    private PruefeWare pruefeWare;
    private SuchView suchView;

    public PruefView(PruefeWare pruefeWare, SuchView suchView) {
        this.pruefeWare = pruefeWare;
        this.suchView = suchView;
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("*************CHECKVIEW****************");
        System.out.println("Gebe die Warennummer ein, um Verfuegbarkeit einer Ware zu pruefen");

        int index = 1;
        do {
            if (scn.hasNextInt()){
                index = scn.nextInt();
            }
        }while (index < 1);

        Ware ware_tmp = this.suchView.searchWareById(index);
        List<ProduktInformation> details = pruefeWare.holeDetailonformation(ware_tmp);
        System.out.println("Details der Ware " + ware_tmp.getName() + "sind: ");
        if (details != null){
            details.stream()
                    .forEach(produktInformation ->
                            System.out.println(produktInformation.getBezeichnung() + "\n"));
        }

    }
}
