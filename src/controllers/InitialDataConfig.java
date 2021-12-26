/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import access.CategoriaDAO;
import java.util.ArrayList;
import model.CategoriaModel;

/**
 *
 * @author lcast
 */
public class InitialDataConfig {
    private ArrayList<CategoriaModel> categorias = null;

    public InitialDataConfig() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        this.categorias = categoriaDAO.obtenerCategorias();
        this.categorias.add(0, new CategoriaModel(-1, "Todas las Categorias"));
    }

    public ArrayList<CategoriaModel> getCategorias() {
        return categorias;
    }
    
}
