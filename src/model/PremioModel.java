/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class PremioModel {
    private int premioID;
    private int premioRondaID;
    private int premiopunt;

    
    /**
     * Constructor para manejo interno de la tabla
     * @param premioID
     * @param premioRondaID
     * @param premiopunt 
     */
    public PremioModel(int premioID, int premioRondaID, int premiopunt) {
        this.premioID = premioID;
        this.premioRondaID = premioRondaID;
        this.premiopunt = premiopunt;
    }

    public int getPremioID() {
        return premioID;
    }

    public void setPremioID(int premioID) {
        this.premioID = premioID;
    }

    public int getPremioRondaID() {
        return premioRondaID;
    }

    public void setPremioRondaID(int premioRondaID) {
        this.premioRondaID = premioRondaID;
    }

    public int getPremiopunt() {
        return premiopunt;
    }

    public void setPremiopunt(int premiopunt) {
        this.premiopunt = premiopunt;
    }

}
