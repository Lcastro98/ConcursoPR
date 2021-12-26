/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PreguntaModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class PreguntaDAO {
       private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<PreguntaModel> obtenerPreguntas(){
        ArrayList<PreguntaModel> preguntas = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT pre_id, pre_cat_id, pre_enun FROM pregunta;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                PreguntaModel pregunta = new PreguntaModel(result.getInt(1), result.getInt(2), result.getString(3));
                preguntas.add( pregunta );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return preguntas;
    }
    
    /**
     * 
     * @param categoria
     * @return 
     */
    public ArrayList<PreguntaModel> obtenerPreguntasxCat(int categoria){
        ArrayList<PreguntaModel> preguntas = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT pre_id, pre_cat_id, pre_enun FROM pregunta WHERE categoria.cat_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoria);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                PreguntaModel pregunta = new PreguntaModel(result.getInt(1), result.getInt(2), result.getString(3));
                preguntas.add( pregunta );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return preguntas;
    }
    /**
     * 
     * @param preID
     * @return 
     */
    public PreguntaModel obtenerPregunta(int preID){
        PreguntaModel pregunta = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT pre_cat_id, pre_nom FROM pregunta WHERE pre_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, preID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                pregunta = new PreguntaModel(preID, result.getInt(1), result.getString(2));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return pregunta;
    }
    
    /**
     * 
     * @param pregunta 
     */
    public void agregarPregunta(PreguntaModel pregunta){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO pregunta(pre_id, pre_cat_id, pre_enun) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pregunta.getPreID());
            statement.setInt(2, pregunta.getPreCatID());
            statement.setString(3, pregunta.getPreEnun());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "La pregunta fue agregada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param pregunta 
     */
    public void actualizarPregunta(PreguntaModel pregunta){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE pregunta SET pre_enun =? WHERE pre_id =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pregunta.getPreEnun());
            statement.setInt(2, pregunta.getPreID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "La pregunta fue actualizada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarPregunta(int preID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM pregunta WHERE pre_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, preID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La prefunta fue borrada exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
