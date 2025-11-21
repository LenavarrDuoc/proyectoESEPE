/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BD.*;
import Modelo.Tarjeta_grafica;
import java.util.ArrayList;
import java.util.List;

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
    public boolean agregarTarjeta(Tarjeta_grafica t) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion().getConn();
            String query = "INSERT INTO tarjeta_grafica values(?, ?, ?, ?, ?)"; //(int codigo, String nombre, int cantidad, char estado, String marca) 
            CallableStatement csmnt = this.conexion.prepareCall(query);
            csmnt.setInt(1, t.getCodigo());
            csmnt.setString(2, t.getNombre());
            csmnt.setInt(3, t.getCantidad());
            csmnt.setString(4, String.valueOf(t.getEstado()));
            csmnt.setString(5, t.getMarca());

            if (csmnt.executeUpdate() > 0) {
                centinela = true;
                System.out.println("Ingreso exitoso de ítem código: " + t.getCodigo() + " a BD DUOCESEPE.");
            }

        } catch (Exception e) {
            System.out.println("Error al agregar ítem en BD DUOCESEPE: " + e.getMessage());
        } finally {
            this.conexion.close();
        }

        return centinela;
    }

    //R.:
    public List<Tarjeta_grafica> listarTarjetas() throws SQLException{
        List<Tarjeta_grafica> listado = new ArrayList<>();
        
        try {
            this.conexion = new Conexion().getConn();
            String query = "SELECT * FROM tarjeta_grafica ORDER BY codigo asc";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            
            ResultSet rs = csmnt.executeQuery();
            
            //(int codigo, String nombre, int cantidad, char estado, String marca) 
            while (rs.next()){
                Tarjeta_grafica t = new Tarjeta_grafica();
                t.setCodigo(rs.getInt("CODIGO"));
                t.setNombre(rs.getString("NOMBRE"));
                t.setCantidad(rs.getInt("CANTIDAD"));
                t.setEstado(rs.getString("ESTADO").charAt(0));
                t.setMarca(rs.getString("MARCA"));
                listado.add(t);
                
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar datos de ítem desde BD DUOCESEPE: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return listado;
    }
    //U.:
    public boolean modificarTarjeta(Tarjeta_grafica t) throws SQLException{
        boolean centinela = false;
        try {
            this.conexion = new Conexion().getConn();
            String query = "UPDATE tarjeta_grafica SET nombre = ?, cantidad = ?, estado = ?, marca = ? WHERE codigo = ?";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            csmnt.setString(1, t.getNombre());
            csmnt.setInt(2, t.getCantidad());
            csmnt.setString(3, String.valueOf(t.getEstado()));
            csmnt.setString(4, t.getMarca());
            csmnt.setInt(5, t.getCodigo());
            
            if (csmnt.executeUpdate() > 0){
                System.out.println("Actualización exitosa de datos de ítem con código " + t.getCodigo() + " en BD DUOCESEPE.");
                centinela = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar datos de ítem en BD DUOCESEPE: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
    }
    //D.:
    public boolean eliminarTarjeta(int codigo) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new Conexion().getConn();
            String query = "DELETE FROM TARJETA_GRAFICA WHERE CODIGO = " + codigo;
            CallableStatement csmnt = this.conexion.prepareCall(query);
            
            if (csmnt.executeUpdate() > 0){
                System.out.println("Eliminación exitósa de ítem codigo " + codigo + " en BD.");
                centinela = true;
            }

        } catch (Exception e) {
            System.out.println("Error al borrar ítem en BD: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
    }

}
