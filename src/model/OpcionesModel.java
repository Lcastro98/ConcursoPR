/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class OpcionesModel {
    private int opID;
    private int opPreID;
    private String opText;
    private boolean opCorrect;

    /**
     * 
     * @param opID
     * @param opPreID
     * @param opText
     * @param opCorrect 
     */
    public OpcionesModel(int opID, int opPreID, String opText, boolean opCorrect) {
        this.opID = opID;
        this.opPreID = opPreID;
        this.opText = opText;
        this.opCorrect = opCorrect;
    }

    
    public int getOpID() {
        return opID;
    }

    public void setOpID(int opID) {
        this.opID = opID;
    }

    public int getOpPreID() {
        return opPreID;
    }

    public void setOpPreID(int opPreID) {
        this.opPreID = opPreID;
    }

    public String getOpText() {
        return opText;
    }

    public void setOpText(String opText) {
        this.opText = opText;
    }

    public boolean isOpCorrect() {
        return opCorrect;
    }

    public void setOpCorrect(boolean opCorrect) {
        this.opCorrect = opCorrect;
    }
    
    
    
    
    
    
}
