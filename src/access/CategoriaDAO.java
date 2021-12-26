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
import model.CategoriaModel;
import utils.ConnectionDB;

/**
 *
 * @author lcast
 */
public class CategoriaDAO {
    private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    public ArrayList<CategoriaModel> obtenerCategorias(){
        ArrayList<CategoriaModel> categorias = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql          = "SELECT cat_id, cat_nom FROM categoria;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                CategoriaModel categoria = new CategoriaModel(result.getInt(1), result.getString(2));
                categorias.add( categoria );
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return categorias;
    }
    
    /**
     * 
     * @param catID
     * @return 
     */
    public CategoriaModel obtenerCategoria(int catID){
        CategoriaModel categoria = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cat_nom FROM categorias WHERE cat_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, catID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                categoria = new CategoriaModel(catID, result.getString(1));
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return categoria;
    }
    
    /**
     * 
     * @param categoria 
     */
    public void agregarCategoria(CategoriaModel categoria){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO categoria(cat_id, cat_nom) VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoria.getCatID());
            statement.setString(2, categoria.getCatNom());
            
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
     * @param categoria 
     */
    public void actualizarCategoria(CategoriaModel categoria){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE categoria SET cat_nom =? WHERE cat_id =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoria.getCatNom());
            statement.setInt(2, categoria.getCatID());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void eliminarCategoria(int catID){
            try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM categoria WHERE cat_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, catID);
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
