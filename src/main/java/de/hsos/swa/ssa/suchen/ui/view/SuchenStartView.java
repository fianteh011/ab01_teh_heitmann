package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.ui.view.GeneralView;

import java.util.Scanner;

public class SuchenStartView implements GeneralView {

    private SuchenMenueControl menueControl;

    public SuchenStartView() {
        this.menueControl = new SuchenMenueControl();
    }

    private enum options {
        WARENSUCHE, WARENPRUEFUNG, WARENAUSWAHL, EXIT
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);
        int inp;
        do {
            inp = 1;
            System.out.println("**********************SUCHENSTARTVIEW*****************");
            System.out.println("*******************************************************");
            System.out.println("1 - " + options.WARENSUCHE);
            System.out.println("2 - " + options.WARENPRUEFUNG);
            System.out.println("3 - " + options.WARENAUSWAHL);
            System.out.println("4 - " + options.EXIT + "\n");
            //sobald eine Eingabe gibt
            do {
                if (scn.hasNextInt()) {
                    inp = scn.nextInt();
                }
            } while (inp < 0 || inp > options.values().length);

            System.out.println("Forwarding ..." + options.values()[inp - 1] + "\n");
            this.menueControl.waehleView(inp);
        } while (inp != 4);
    }
}
