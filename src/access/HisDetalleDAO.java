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
import model.HisDetalleModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class HisDetalleDAO {
     private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<HisDetalleModel> obtenerHisDetalles(){
        ArrayList<HisDetalleModel> hisDetalles = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT his_id, his_premio_id FROM hisDetalle;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                HisDetalleModel hisDetalle = new HisDetalleModel(result.getInt(1), result.getInt(2));
                hisDetalles.add( hisDetalle );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return hisDetalles;
    }
    
    /**
     * 
     * @param hisID
     * @return 
     */
    public HisDetalleModel obtenerHisDetalle(int hisID, int hisPremioID){
        HisDetalleModel hisDetalle = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT his_premio_id FROM hisDetalles WHERE his_id=? AND his_premio_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisID);
            statement.setInt(1, hisPremioID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                hisDetalle = new HisDetalleModel(hisID, result.getInt(1));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return hisDetalle;
    }
        /**
     * 
     * @param hisID
     * @return 
     */
    public ArrayList<HisDetalleModel> obtenerDetallexHis(int hisID){
        ArrayList<HisDetalleModel> hisDetalles = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT his_id, his_premio_id FROM his_detalle WHERE his_detalle.his_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisID);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                HisDetalleModel hisDetalle = new HisDetalleModel(result.getInt(1), result.getInt(2));
                hisDetalles.add( hisDetalle );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return hisDetalles;
    }

    /**
     * 
     * @param hisDetalle 
     */
    public void agregarHisDetalle(HisDetalleModel hisDetalle){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO hisDetalle(his_id, his_premio_id) VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisDetalle.getHisID());
            statement.setInt(2, hisDetalle.getHisPremioID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarHisDetalle(int hisID, int hisPremioID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM hisDetalle WHERE his_id=? AND his_premio_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisID);
            statement.setInt(2, hisPremioID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
