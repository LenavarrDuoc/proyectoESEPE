/*jdbc:thin:"+user+"/"+pass+"@localhost:1521:orcl
oracle.jdbc.OracleDriver
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leo_b
 */
public class Conexion {
    private static Connection conn;
    private String user = "DUOCESEPE";
    private String pass = "DUOCESEPE";
    private String url = "jdbc:oracle:thin:"+user+"/"+pass+"@localhost:1521:orcl";
    
    //Constr:
    public Conexion() {
        try {
//          Class.forName("oracle.jdbc.OracleDriver").newInstance(); //Solo si es anterior a Java 6 //Class.forName() carga drivers en tiempo de ejecución( en este caso, los de Oracle) para forzar su registra en memoria; pero Java 8 ya trae registrado los driver de Oracle y no es necesario forzaer la carga de los drivers con Class.forName()
            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error de conexión: "+e.getMessage());
        }
        
    }
    
    //Getter de conn (Objeto Connection que inicia la conexión):
    public static Connection getConn() {
        return conn;
    }
    
}
