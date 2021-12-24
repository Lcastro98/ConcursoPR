/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class HisDetalleModel {
    private int hisID;
    private int hisPremioID;

    /**
     * Constructor para manejo interno de la tabla
     * @param hisID
     * @param hisPremioID 
     */
    public HisDetalleModel(int hisID, int hisPremioID) {
        this.hisID = hisID;
        this.hisPremioID = hisPremioID;
    }

    public int getHisID() {
        return hisID;
    }

    public void setHisID(int hisID) {
        this.hisID = hisID;
    }

    public int getHisPremioID() {
        return hisPremioID;
    }

    public void setHisPremioID(int hisPremioID) {
        this.hisPremioID = hisPremioID;
    }

}
