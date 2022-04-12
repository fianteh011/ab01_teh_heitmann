package de.hsos.swa.ssa.ui.view;

import java.util.Scanner;

public class MenueView implements GeneralView {

    private GeneralController my_controller;

    public MenueView(GeneralController my_controller) {
        this.my_controller = my_controller;
    }

    private enum options {
        WARENSUCHE, WARENKORB, BEZAHLEN, KATALOGVERWALTUNG
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Waehle eine Option aus: ");
        System.out.println("1. " + options.WARENSUCHE);
        System.out.println("2. " + options.WARENKORB);
        System.out.println("3. " + options.BEZAHLEN);
        System.out.println("4. " + options.KATALOGVERWALTUNG);

        int inp = 1;
        do {
            if (scn.hasNextInt()) {
                inp = scn.nextInt();
            }
        } while (inp < 1 || inp > 4);

        System.out.println("Forward to: " + options.values()[inp - 1] + "...");
        this.my_controller.sendInput(Integer.toString(inp));
    }

}
