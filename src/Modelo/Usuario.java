/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Leo_b
 */
public class Usuario {
    private int id;
    private String nombre;
    private String pass;
    private String rol;
    private String fec_reg;

    
    //Constr;
        //SP:

    public Usuario() {
    }
    
        //CPVerificación:
    public Usuario(int id, String nombre, String rol, String fec_reg) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.fec_reg = fec_reg;
    }
    
        //CpRegistro:
    public Usuario(String nombre, String pass, String rol) {
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
    }
    
        //CpModificacion:
    public Usuario(String nombre, String pass, String rol, int id) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
    }
    
        //CPAll:
    public Usuario(int id, String nombre, String pass, String rol, String fec_reg) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.rol = rol;
        this.fec_reg =  fec_reg;
    }
    
    //G&S:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFec_reg() {
        return fec_reg;
    }

    public void setFec_reg(String fec_reg) {
        this.fec_reg = fec_reg;
    }
    
    
    //ToStr:

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", rol=" + rol + '}';
    }
    
    
}
