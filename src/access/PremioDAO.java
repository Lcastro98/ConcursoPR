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
import model.PremioModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class PremioDAO {
       private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<PremioModel> obtenerPremios(){
        ArrayList<PremioModel> premios = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT premio_id, premio_ronda_id, pre_punt FROM premio;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                PremioModel premio = new PremioModel(result.getInt(1), result.getInt(2), result.getInt(3));
                premios.add( premio );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return premios;
    }
    
    /**
     * 
     * @param ronda
     * @return 
     */
    public ArrayList<PremioModel> obtenerPremiosxCat(int ronda){
        ArrayList<PremioModel> premios = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT premio_id, premio_ronda_id, premio_punt FROM premio WHERE premio.pre_ronda_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ronda);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                PremioModel premio = new PremioModel(result.getInt(1), result.getInt(2), result.getInt(3));
                premios.add( premio );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return premios;
    }
    /**
     * 
     * @param premioID
     * @return 
     */
    public PremioModel obtenerPremio(int premioID){
        PremioModel premio = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT premio_ronda_id, premio_punt FROM premio WHERE premio_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, premioID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                premio = new PremioModel(premioID, result.getInt(1), result.getInt(2));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return premio;
    }
    
    /**
     * 
     * @param premio 
     */
    public void agregarPremio(PremioModel premio){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO premio(premio_id, premio_ronda_id, premio_punt) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, premio.getPremioID());
            statement.setInt(2, premio.getPremioRondaID());
            statement.setInt(3, premio.getPremioPunt());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El premio fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param premio 
     */
    public void actualizarPremio(PremioModel premio){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE premio SET premio_punt =? WHERE premio_id =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, premio.getPremioPunt());
            statement.setInt(2, premio.getPremioID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El premio fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarPremio(int premioID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM premio WHERE premio_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, premioID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El premio fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
