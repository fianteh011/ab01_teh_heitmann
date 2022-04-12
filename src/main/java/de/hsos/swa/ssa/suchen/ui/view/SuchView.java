package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.SucheWare;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.ui.view.GeneralView;

import java.util.List;
import java.util.Scanner;

public class SuchView implements GeneralView {
    private SuchControl suchControl;
    Scanner scn;

    public SuchView(SucheWare sucheWare){
        this.suchControl = new SuchControl(sucheWare);
        this.scn = new Scanner(System.in);

    }

    private enum options {
        WORTSUCHE, SEMANTIKSUCHE
    }

    @Override
    public void showOutput() {

        System.out.println("***********SUCHVIEW*************");
        System.out.println("Moechten Sie dem Artikel nach Wort oder Semantik suchen?\n");
        System.out.println("1 - " + options.WORTSUCHE + "\n");
        System.out.println("2 - " + options.SEMANTIKSUCHE + "\n");

        int inp = 1;
        do {
            if (this.scn.hasNextInt()){
                inp = this.scn.nextInt();
            }
            //Erweitbarkeit falls neue Suchalgorithmus implmentiert ist
        } while (inp < 1 || inp > options.values().length);

        System.out.println("Suchverfahren: " + options.values()[inp - 1] + "...\n");

        this.scn.nextLine();

        String buffer = "";
        int warennummer = 1;

        if (options.values()[inp - 1] == options.WORTSUCHE) {
            if (this.scn.hasNextLine()) {
                buffer = this.scn.nextLine();
                List<Ware> ware = this.searchWareByName(buffer);
                if(ware.isEmpty()){
                    System.out.println("Ware mit Name\" " + buffer  +"\" nicht gefunden");
                    return;
                }
                ware.stream().forEach(ware1 -> printWareInformation(ware1));
            }
        } else {
            if (this.scn.hasNextInt()) {
                warennummer = this.scn.nextInt();
                Ware ware = this.searchWareById(warennummer);
                if (ware == null){
                    System.out.println("Ware mit der Nummer: "+warennummer + "  nicht gefunden");
                    return;
                }
                this.printWareInformation(ware);
            }
        }
    }

    public Ware searchWareById(int warennummer) {
        return this.suchControl.searchWareById(warennummer);
    }

    public List<Ware> searchWareByName(String wordSearch) {
        return this.suchControl.searchWareByName(wordSearch);
    }

    private void printWareInformation(Ware ware) {
        System.out.println("Warennummer: " + ware.getWarennummer());
        System.out.println("Name: " + ware.getName());
        System.out.println("Preis: " + ware.getPreis());
        System.out.println("-------------------------\n");
        System.out.println("Beschreibung: " + ware.getBeschreibung());
        System.out.println("-----------------------------\n");
    }

}

