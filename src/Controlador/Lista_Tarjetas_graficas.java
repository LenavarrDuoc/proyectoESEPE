package Controlador;
import java.util.ArrayList;
import Modelo.Tarjetas_graficas;
public class Lista_Tarjetas_graficas {
    private ArrayList<Tarjetas_graficas> lista = new ArrayList<>();
    
    public Lista_Tarjetas_graficas(){
        
    }
    
    public boolean agregarTarjetaGrafica(Tarjetas_graficas t){
        for (Tarjetas_graficas tarjetas_graficas : lista) {
            if(tarjetas_graficas.getCodigo()==t.getCodigo()){
                return false;
            }
        }
        lista.add(t);
        return true;
    }
    //Listar
    public ArrayList<Tarjetas_graficas> getLista() {
        return lista;
    }

    public boolean eliminarTarjeta(int cod){
        return lista.removeIf(t -> t.getCodigo()==cod);
    }
        

}
