package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.SucheWare;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.ui.view.GeneralController;

import java.util.List;

public class SuchControl implements GeneralController  {

    private List<Ware> wareList;
    private Ware singleItem;
    private SucheWare sucheWare;

    public SuchControl(SucheWare sucheWare){
        this.sucheWare = sucheWare;
    }


    @Override
    public void sendInput(String message) {

    }

    public List<Ware> searchWareByName(String name){
        this.wareList = sucheWare.sucheWare(name);
        return this.wareList;
    }

    public Ware searchWareById(int id){
        this.singleItem = sucheWare.sucheWare(id);
        return this.singleItem;
    }


}
