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
import model.HistorialModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class HistorialDAO {
    private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<HistorialModel> obtenerHistoriales(){
        ArrayList<HistorialModel> historiales = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT his_id, his_jugador, his_fecha, his_acum FROM historial;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                HistorialModel historial = new HistorialModel(result.getInt(1), result.getString(2), result.getDate(3), result.getInt(4));
                historiales.add( historial );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return historiales;
    }
    
    /**
     * 
     * @param hisID
     * @return 
     */
    public HistorialModel obtenerHistorial(int hisID){
        HistorialModel historial = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT his_jugador, his_fecha, his_acum FROM historiales WHERE his_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                historial = new HistorialModel(hisID, result.getString(1), result.getDate(2), result.getInt(3));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return historial;
    }
    
    /**
     * 
     * @param historial 
     */
    public void agregarHistorial(HistorialModel historial){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO historial(his_id, his_jugaor, his_fecha, his_acum) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, historial.getHisID());
            statement.setString(2, historial.getHisJugador());
            statement.setDate(3, historial.getHisFecha());
            statement.setInt(4, historial.getHisAcum());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param historial 
     */
    public void actualizarHistorial(HistorialModel historial){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE historial SET his_jugador=?, his_fecha=?, his_acum=? WHERE his_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, historial.getHisJugador());
            statement.setDate(2, historial.getHisFecha());
            statement.setInt(3, historial.getHisAcum());
            statement.setInt(4, historial.getHisID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarHistorial(int hisID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM historial WHERE his_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, hisID);
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
