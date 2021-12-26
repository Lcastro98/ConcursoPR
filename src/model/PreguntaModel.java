/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class PreguntaModel {
    private int preID;
    private int preCatID;
    private String preEnun;
    
    /**
     * Constructor para el manejo interno de la tabla
     * @param preID
     * @param preCatID
     * @param preEnun
     */
       public PreguntaModel(int preID, int preCatID, String preEnun) {
        this.preID = preID;
        this.preCatID = preCatID;
        this.preEnun = preEnun;
    }

    public int getPreID() {
        return preID;
    }

    public void setPreID(int preID) {
        this.preID = preID;
    }

    public int getPreCatID() {
        return preCatID;
    }

    public void setPreCatID(int preCatID) {
        this.preCatID = preCatID;
    }

    public String getPreEnun() {
        return preEnun;
    }

    public void setPreEnun(String preEnun) {
        this.preEnun = preEnun;
    }
   
    public Object[] toArray(){
        Object[] data = {preID, preEnun, "", ""};
        return data;
    }
    
}
