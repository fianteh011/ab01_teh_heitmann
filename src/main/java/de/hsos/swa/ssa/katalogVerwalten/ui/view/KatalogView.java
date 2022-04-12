package de.hsos.swa.ssa.katalogVerwalten.ui.view;

import de.hsos.swa.ssa.katalogVerwalten.bl.KatalogIntf;
import de.hsos.swa.ssa.ui.view.GeneralView;

import java.util.Scanner;

public class KatalogView implements GeneralView {

    private KatalogCtrl katalogCtrl;

    public KatalogView(KatalogIntf katalogEdit) {
        katalogCtrl = new KatalogCtrl(katalogEdit);
    }


    private enum options {
        HINZUFUEGEN, LOESCHEN
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("*******************KATAlOG BEARBEITEN************\n");
        System.out.println("***************************************************");
        System.out.println("1 - " + options.HINZUFUEGEN);
        System.out.println("2 - " + options.LOESCHEN + "\n");

        int inpt = 1;
        do {
            if (scn.hasNextInt()) {
                inpt = scn.nextInt();
            }

        } while (inpt < 1 || inpt > options.values().length);

        System.out.println("Welche Ware mochtest Du " + options.values()[inpt - 1] + "...\n");
        System.out.println("Warenummer eingeben:");
        //zaehle von 0ten Element dann ziehe eins ab
        int warennummer = -1;

        if (scn.hasNextInt()) {
            warennummer = scn.nextInt();
        }

        if (options.values()[inpt - 1].equals(options.HINZUFUEGEN)) {
            this.katalogCtrl.hizufuegen_Katalog(warennummer);
        }
        if (options.values()[inpt - 1].equals(options.LOESCHEN)) {
            this.katalogCtrl.loesche_Katalog(warennummer);
        }
    }
}
