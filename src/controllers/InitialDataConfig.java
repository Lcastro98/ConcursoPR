/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import access.CategoriaDAO;
import access.PreguntaDAO;
import java.util.ArrayList;
import model.CategoriaModel;
import model.PreguntaModel;

/**
 *
 * @author lcast
 */
public class InitialDataConfig {
    private ArrayList<CategoriaModel> categorias = null;
    private ArrayList<PreguntaModel> preguntas = null;

    public InitialDataConfig() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        this.categorias = categoriaDAO.obtenerCategorias();
        this.categorias.add(0, new CategoriaModel(-1, "Todas las Categorias"));

        PreguntaDAO preguntaDAO = new PreguntaDAO();
        this.preguntas = preguntaDAO.obtenerPreguntas();
        
    }

    public ArrayList<CategoriaModel> getCategorias() {
        return categorias;
    }

    public ArrayList<PreguntaModel> getPreguntas() {
        return preguntas;
    }

}
