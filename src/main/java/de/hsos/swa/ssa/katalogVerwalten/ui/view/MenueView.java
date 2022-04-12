package de.hsos.swa.ssa.katalogVerwalten.ui.view;

import de.hsos.swa.ssa.ui.view.GeneralController;
import de.hsos.swa.ssa.ui.view.GeneralView;
import de.hsos.swa.ssa.ui.view.MenueControl;

import java.util.Scanner;

public class MenueView implements GeneralView {
    private GeneralController generalController;

    public MenueView(){
        this.generalController = new MenueControl();
    }

    private enum options {
        EDITKATALOG, SUCHEN, INSERT, DELETE, EXIT
    }

    @Override
    public void showOutput() {
        Scanner scn = new Scanner(System.in);
        int inpt;
        do{
            System.out.println("1 - " + options.EDITKATALOG);
            System.out.println("2 - " + options.SUCHEN);
            System.out.println("3 - " + options.INSERT );
            System.out.println("4 - " + options.DELETE);
            System.out.println("5 - " + options.EXIT);

            inpt = 1;
            do{
                if (scn.hasNextInt()) {
                    inpt = scn.nextInt();
                }
            } while (inpt < 1 || inpt > options.values().length);

            System.out.println("Forwarding to " + options.values()[inpt -1] + "...\n");

            this.generalController.sendInput(Integer.toString(inpt));
        }while (inpt != 1);
    }
}
