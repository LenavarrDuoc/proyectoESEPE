/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.ConexionCloud;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo_b
 */
public class DaoRegistroUsuarios {

    private Connection conexion;
    private Usuario usuarioLogIn = new Usuario();

    //Constr:
    public DaoRegistroUsuarios() {
    }
    
    //C.R.U.D.:
        //C.:
    public boolean agregarUsuario(Usuario u) throws SQLException{
        boolean centinela = true;
        
        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "INSERT INTO usuario (user_name, pass, rol) VALUES (?, ?, ?)";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            
            csmnt.setString(1, u.getNombre());
            csmnt.setString(2, u.getPass());
            csmnt.setString(3, u.getRol());
            
            if (csmnt.executeUpdate() > 0){
                centinela = true;
                System.out.println("DAO Ingreso exitoso de usuario: " + u.getNombre() + " a BD DUOCESEPE.");
            }
            
        } catch (Exception e){
            String errorMessage = "Error al agregar usuario en BD DUOCESEPE:\n" + e.getMessage();
            System.out.println("DAO:" + errorMessage);
            
        }
        finally {
            this.conexion.close();
        }
        
        return centinela;
    }

        //R.:
    public boolean verificarCredenciales(String user, String pass) throws SQLException {
        boolean centinela = false;
        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "SELECT id_user AS ID, user_name AS NOMBRE, rol AS ROL FROM usuario WHERE user_name = ? AND pass = ?";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            csmnt.setString(1, user.toLowerCase());
            csmnt.setString(2, pass);

            ResultSet rs = csmnt.executeQuery();

            if (rs.next()) {
                
                usuarioLogIn.setId(rs.getInt("ID"));
                usuarioLogIn.setNombre(rs.getString("NOMBRE"));
                usuarioLogIn.setRol(rs.getString("ROL"));
                centinela = true;

            }

        } catch (Exception e) {
            System.out.println("Error en verificación en BD de credenciales de LogIn: " + e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
    }
    
   

    
    //G usuarioLogIn:

    public Usuario getUsuarioLogIn() {
        return usuarioLogIn;
    }
    

}
