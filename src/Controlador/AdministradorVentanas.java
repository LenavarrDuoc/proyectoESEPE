/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Leo_b
 */
public class AdministradorVentanas {
    private static List<JFrame> forms = new ArrayList<>();
    
    public static void registrarForm(JFrame f){
        forms.add(f);
    }
    
    public static void cerrarForms(){
        for (JFrame f : forms) {
            f.dispose();
            
        }
      forms.clear();
    }
    
}
