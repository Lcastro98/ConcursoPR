/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author lcast
 */
public class HistorialModel {
    private int hisID;
    private String hisJugador;
    private Date hisFecha;
    private int hisAcum;
    
    /**
     * Constructos para manejo interno de la tabla
     * @param hisID
     * @param hisJugador
     * @param hisFecha
     * @param hisAcum 
     */
    public HistorialModel(int hisID, String hisJugador, Date hisFecha, int hisAcum) {
        this.hisID = hisID;
        this.hisJugador = hisJugador;
        this.hisFecha = hisFecha;
        this.hisAcum = hisAcum;
    }

    public int getHisID() {
        return hisID;
    }

    public void setHisID(int hisID) {
        this.hisID = hisID;
    }

    public String getHisJugador() {
        return hisJugador;
    }

    public void setHisJugador(String hisJugador) {
        this.hisJugador = hisJugador;
    }

    public Date getHisFecha() {
        return hisFecha;
    }

    public void setHisFecha(Date hisFecha) {
        this.hisFecha = hisFecha;
    }

    public int getHisAcum() {
        return hisAcum;
    }

    public void setHisAcum(int hisAcum) {
        this.hisAcum = hisAcum;
    }
    
    
    
}
