package Modelo;

public class Tarjeta_grafica {
    private int codigo;
    private String nombre;
    private int cantidad;
    private char estado;
    private String marca;

    public Tarjeta_grafica() {
    }
    public Tarjeta_grafica(String mar, int cantidad){
    }
            
    public Tarjeta_grafica(int codigo, String nombre, int cantidad, char estado, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Tarjetas_graficas{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", estado=" + estado + ", marca=" + marca + '}';
    }
    
    
}
