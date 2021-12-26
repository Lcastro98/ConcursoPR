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
import model.RondaModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class RondaDAO {
       private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<RondaModel> obtenerRondas(){
        ArrayList<RondaModel> rondas = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT ronda_id, ronda_cat_id, ronda_nom FROM ronda;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                RondaModel ronda = new RondaModel(result.getInt(1), result.getInt(2), result.getString(3));
                rondas.add( ronda );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return rondas;
    }
    
    /**
     * 
     * @param categoria
     * @return 
     */
    public ArrayList<RondaModel> obtenerRondasxCat(int categoria){
        ArrayList<RondaModel> rondas = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT ronda_id, ronda_cat_id, ronda_nom FROM ronda WHERE ronda.ronda_cat_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoria);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                RondaModel ronda = new RondaModel(result.getInt(1), result.getInt(2), result.getString(3));
                rondas.add( ronda );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return rondas;
    }
    /**
     * 
     * @param rondaID
     * @return 
     */
    public RondaModel obtenerRonda(int rondaID){
        RondaModel ronda = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT ronda_cat_id, ronda_nom FROM ronda WHERE ronda_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rondaID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ronda = new RondaModel(rondaID, result.getInt(1), result.getString(2));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return ronda;
    }
    
    /**
     * 
     * @param ronda 
     */
    public void agregarRonda(RondaModel ronda){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO ronda(ronda_id, ronda_cat_id, ronda_nom) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ronda.getRondaID());
            statement.setInt(2, ronda.getRondaCatID());
            statement.setString(3, ronda.getRondaNom());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "La ronda fue agregada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param ronda 
     */
    public void actualizarRonda(RondaModel ronda){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE ronda SET ronda_nom =? WHERE ronda_id =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ronda.getRondaNom());
            statement.setInt(2, ronda.getRondaID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "La ronda fue actualizada exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarRonda(int rondaID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM ronda WHERE ronda_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, rondaID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La ronda fue borrada exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
    
}
