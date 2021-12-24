/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class RondaModel {
    private int rondaID;
    private int rondaCatID;
    private String rondaNom;

    /**
     * Constructor para manejo interno de la tabla
     * @param rondaID
     * @param rondaCatID
     * @param rondaNom 
     */
    public RondaModel(int rondaID, int rondaCatID, String rondaNom) {
        this.rondaID = rondaID;
        this.rondaCatID = rondaCatID;
        this.rondaNom = rondaNom;
    }

    public int getRondaID() {
        return rondaID;
    }

    public void setRondaID(int rondaID) {
        this.rondaID = rondaID;
    }

    public int getRondaCatID() {
        return rondaCatID;
    }

    public void setRondaCatID(int rondaCatID) {
        this.rondaCatID = rondaCatID;
    }

    public String getRondaNom() {
        return rondaNom;
    }

    public void setRondaNom(String rondaNom) {
        this.rondaNom = rondaNom;
    }
    
}
