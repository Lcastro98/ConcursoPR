/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import access.CategoriaDAO;
import access.OpcionesDAO;
import access.PreguntaDAO;
import java.util.ArrayList;
import model.CategoriaModel;
import model.OpcionesModel;
import model.PreguntaModel;

/**
 *
 * @author lcast
 */
public class InitialDataConfig {
    private ArrayList<CategoriaModel> categorias = null;
    private ArrayList<PreguntaModel> preguntas = null;
    private ArrayList<OpcionesModel> opciones = null;

    public InitialDataConfig() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        this.categorias = categoriaDAO.obtenerCategorias();

        PreguntaDAO preguntaDAO = new PreguntaDAO();
        this.preguntas = preguntaDAO.obtenerPreguntasxCat(this.categorias.get(0).getCatID());
        
        OpcionesDAO opcionesDAO = new OpcionesDAO();
        if (this.preguntas.size() > 0) {
            this.opciones = opcionesDAO.obtenerOpcionesxPre(this.preguntas.get(0).getPreID());
        }
       
    }

    public ArrayList<CategoriaModel> getCategorias() {
        return categorias;
    }

    public ArrayList<PreguntaModel> getPreguntas() {
        return preguntas;
    }

    public ArrayList<OpcionesModel> getOpciones() {
        return opciones;
    }

}
