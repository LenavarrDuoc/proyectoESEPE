package Controlador;
import java.util.ArrayList;
import Modelo.Tarjeta_grafica;
public class Lista_Tarjetas_graficas {
    private ArrayList<Tarjeta_grafica> lista = new ArrayList<>();
    
    public Lista_Tarjetas_graficas(){
        
    }
    
    public boolean agregarTarjetaGrafica(Tarjeta_grafica t){
        for (Tarjeta_grafica tarjetas_graficas : lista) {
            if(tarjetas_graficas.getCodigo()==t.getCodigo()){
                return false;
            }
        }
        lista.add(t);
        return true;
    }
    //Listar
    public ArrayList<Tarjeta_grafica> getLista() {
        return lista;
    }

    public boolean eliminarTarjeta(int cod){
        return lista.removeIf(t -> t.getCodigo()==cod);
    }
        

}
