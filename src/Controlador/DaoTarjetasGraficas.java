/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MODELO.*;
import BD.*;
import Modelo.Tarjetas_graficas;


/**
 *
 * @author Leo_b
 */
public class DaoTarjetasGraficas {
    private Connection conexion;
    
    //Constr:

    public DaoTarjetasGraficas() {
    }
    
    //MCustom:
        //C.R.U.D.:
    
        //C.:
    public boolean agregarTarjeta(Tarjetas_graficas t) throws SQLException{
        boolean centinela = false;
        try {
            this.conexion = new Conexion().getConn();
            String query = "INSERT INTO tarjeta_grafica values(?, ?, ?, ?, ?)"; //(int codigo, String nombre, int cantidad, char estado, String marca) 
            CallableStatement csmt = this.conexion.prepareCall(query);
            csmt.setInt(1, t.getCodigo());
            csmt.setString(2, t.getNombre());
            csmt.setInt(3, t.getCantidad());
            csmt.setString(4, String.valueOf(t.getEstado()));
            csmt.setString(5, t.getMarca());
            
            if (csmt.executeUpdate() > 0){
                centinela = true;
                System.out.println("Mensaje Consola: Se agregó tarjeta código: " + t.getCodigo() + " a exitósamente BD DUOCESEPE.");
            }
            
        } catch (Exception e) {
            System.out.println("Error al agregar tarjeta: "+e.getMessage());
        } finally {
            this.conexion.close();
        }
        
        return centinela;
    }
    
        //R.:
    
    
    
        //U.:
    
    
        //D.:
    
    
}
