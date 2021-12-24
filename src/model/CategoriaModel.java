/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcast
 */
public class CategoriaModel {
    private int catID;
    private String catNom;
    
    /**
     * Constructor para manejo interno de la tabla
     * @param catID
     * @param catNom
     */
    
    public CategoriaModel(int catID, String catNom){
        this.catID = catID;
        this.catNom = catNom;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatNom() {
        return catNom;
    }

    public void setCatNom(String catNom) {
        this.catNom = catNom;
    }
    
    
}
