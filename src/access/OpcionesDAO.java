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
import model.OpcionesModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class OpcionesDAO {
      
    private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<OpcionesModel> obtenerOpciones(){
        ArrayList<OpcionesModel> opciones = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT op_id, op_pre_id, op_text, op_correct FROM opciones;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                OpcionesModel opcion = new OpcionesModel(result.getInt(1), result.getInt(2), result.getString(3), result.getBoolean(4));
                opciones.add( opcion );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return opciones;
    }
    
    /**
     * 
     * @param pregunta
     * @return 
     */
    public ArrayList<OpcionesModel> obtenerOpcionesxPre(int pregunta){
        ArrayList<OpcionesModel> opciones = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT op_id, op_pre_id, op_text, op_correct FROM opciones WHERE opciones.op_pre_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pregunta);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                OpcionesModel opcion = new OpcionesModel(result.getInt(1), result.getInt(2), result.getString(3), result.getBoolean(4));
                opciones.add( opcion );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return opciones;
    }
    /**
     * 
     * @param opID
     * @return 
     */
    public OpcionesModel obtenerOpcion(int opID){
        OpcionesModel opcion = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT op_id, op_pre_id, op_text, op_correct FROM opciones WHERE op_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, opID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                opcion = new OpcionesModel(opID, result.getInt(2), result.getString(3), result.getBoolean(4));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return opcion;
    }
    
    /**
     * 
     * @param opcion 
     */
    public void agregarOpcion(OpcionesModel opcion){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO opciones(op_id, op_pre_id, op_text, op_correct) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, opcion.getOpID());
            statement.setInt(2, opcion.getOpPreID());
            statement.setString(3, opcion.getOpText());
            statement.setBoolean(4, opcion.isOpCorrect());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                rowsInserted = rowsInserted;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param opcion 
     */
    public void actualizarOpcion(OpcionesModel opcion){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE opciones SET op_text=?, op_correct=? WHERE op_id =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, opcion.getOpText());
            statement.setBoolean(2, opcion.isOpCorrect());
            statement.setInt(3, opcion.getOpID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                rowsInserted = rowsInserted;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarOpcion(int opID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM opciones WHERE op_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, opID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                rowsDeleted = rowsDeleted;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
