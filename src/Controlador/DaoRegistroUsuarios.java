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
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
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
    public boolean agregarUsuario(Usuario u) throws SQLException {
        boolean centinela = true;

        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "INSERT INTO usuario (user_name, pass, rol) VALUES (?, ?, ?)";
            CallableStatement csmnt = this.conexion.prepareCall(query);

            csmnt.setString(1, u.getNombre());
            csmnt.setString(2, u.getPass());
            csmnt.setString(3, u.getRol());

            if (csmnt.executeUpdate() > 0) {
                centinela = true;
                System.out.println("DaoRegistroUsuarios - Ingreso exitoso de usuario: " + u.getNombre() + " a BD DUOCESEPE.");
            }

        } catch (Exception e) {
            String errorMessage = "Error al agregar usuario en BD DUOCESEPE:\n" + e.getMessage();
            System.out.println("DaoRegistroUsuarios:" + errorMessage);

        } finally {
            this.conexion.close();
        }

        return centinela;
    }

    //R.:
    public boolean verificarCredenciales(String userCap, String pass) throws SQLException {
        boolean centinela = false;
        userCap = userCap.replaceAll("\\p{M}", "").trim();
        userCap = Normalizer.normalize(userCap, Normalizer.Form.NFD);
        String user = userCap.substring(0,1).toUpperCase() + userCap.substring(1);
        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "SELECT id_user AS ID, user_name AS NOMBRE, rol AS ROL, fec_reg AS FECHA_REGISTRO FROM usuario WHERE user_name = ? AND pass = ?";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            csmnt.setString(1, user);
            csmnt.setString(2, pass);

            ResultSet rs = csmnt.executeQuery();

            if (rs.next()) {

                usuarioLogIn.setId(rs.getInt("ID"));
                usuarioLogIn.setNombre(rs.getString("NOMBRE"));
                usuarioLogIn.setRol(rs.getString("ROL"));
                usuarioLogIn.setFec_reg(rs.getString("FECHA_REGISTRO"));
                centinela = true;

            }

        } catch (Exception e) {
            String errorMessage = "Error en verificación en BD de credenciales de LogIn: " + e.getMessage();
            System.out.println("DaoRegistroUsuarios - " + errorMessage);
        } finally {
            this.conexion.close();
        }
        return centinela;
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> listado = new ArrayList<>();

        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "SELECT id_user AS ID, user_name AS USUARIO, rol AS ROL, fec_reg AS FECHA_REGISTRO FROM usuario WHERE rol != 'admin' AND id_user != 1 ORDER BY id_user";

            CallableStatement csmnt = this.conexion.prepareCall(query);

            ResultSet rs = csmnt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID"));
                u.setNombre(rs.getString("USUARIO"));
                u.setRol(rs.getString("ROL"));
                u.setFec_reg(rs.getString("FECHA_REGISTRO"));
                listado.add(u);
            }
            

        } catch (Exception e) {
            String errorMessage = "Error al listar usuarios en BD: " + e.getMessage();
            System.out.println("DaoRegistroUsuarios - " + errorMessage);
        } finally {
            this.conexion.close();
        }
        return listado;
    }
    
    public int retornarultimoID()throws SQLException{
        int currID = 0;
        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "SELECT max(id_user) AS LAST_ID FROM usuario";
            CallableStatement csmnt = this.conexion.prepareCall(query);
            
            ResultSet rs = csmnt.executeQuery();
            
            if (rs.next()){
                currID = rs.getInt("LAST_ID");
            }
            
        } catch (Exception e) {
            String errorMessage = "Error al intentar retornar último valor de id_user en BD: " + e.getMessage();
            System.out.println("DaoRegistroUsuarios - " + errorMessage);
        } finally {
            this.conexion.close();
        }
        
        return currID;
    }

    //U.:
    public boolean modificarUsuario(Usuario um) throws SQLException {
        boolean centinela = true;

        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "UPDATE usuario SET user_name = ?, rol = ?, pass = ? WHERE id_user = ?";
            CallableStatement csmnt = this.conexion.prepareCall(query);

            csmnt.setString(1, um.getNombre());
            csmnt.setString(2, um.getRol());
            csmnt.setString(3, um.getPass());
            csmnt.setInt(4, um.getId());

            if (csmnt.executeUpdate() > 0) {
                centinela = true;
                System.out.println("DaoRegistroUsuarios - modificación exitosa de usuario: " + um.getNombre() + " en BD.");
            }

        } catch (Exception e) {
            String errorMessage = "Error al modificar usuario en BD:\n" + e.getMessage();
            System.out.println("DaoRegistroUsuarios:" + errorMessage);

        } finally {
            this.conexion.close();
        }

        return centinela;
    }
    
    //D.:
    public boolean eliminarUsuario(int id) throws SQLException{
        boolean centinela = false;

        try {
            this.conexion = new ConexionCloud().getConn();
            String query = "DELETE FROM USUARIO WHERE id_user = " + id;
            CallableStatement csmnt = this.conexion.prepareCall(query);

            if (csmnt.executeUpdate() > 0) {
                centinela = true;
                System.out.println("DaoRegistroUsuarios - eliminación exitosa de usuario ID: " + id + " a BD DUOCESEPE.");
            }
        } catch (Exception e) {
            String errorMessage = "Error al intentar eliminar usuario en BD: " + e.getMessage();
            System.out.println("DaoRegistroUsuarios - " + errorMessage);
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
