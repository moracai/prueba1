/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Prueba1 {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/prueba";
        String usuario = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection coneccion = null;
        Statement statement = null;
        ResultSet rs = null;
        
         try {
            Class.forName(driver);
            coneccion = DriverManager.getConnection(url, usuario, password);
            statement = coneccion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Prueba1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar los recursos en un bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (coneccion != null) {
                    coneccion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Prueba1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}        
        

