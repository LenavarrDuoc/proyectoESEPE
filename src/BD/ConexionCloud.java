/*jdbc:thin:"+user+"/"+pass+"@localhost:1521:orcl
oracle.jdbc.OracleDriver
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Leo_b
 */
public class ConexionCloud {

    private static Connection conn;
    private String user = "ESEPECLOUD";
    private String pass = "Duocpuentealto25.";
    private String service = "esepecloud_high";

    //Constr:
    public ConexionCloud() {
        try {
            String rutaWallet = (System.getProperty("user.dir") + "/Wallet").replace("\\", "/");
            String url = "jdbc:oracle:thin:@"+ service;
            Properties prop = new Properties();
            prop.setProperty("user", user);
            prop.setProperty("password", pass);
            prop.setProperty("oracle.net.tns_admin", rutaWallet);
            System.out.println("Ruta wallet: " + rutaWallet);

//          Class.forName("oracle.jdbc.OracleDriver").newInstance(); //Solo si es anterior a Java 6 //Class.forName() carga drivers en tiempo de ejecución( en este caso, los de Oracle) para forzar su registra en memoria; pero Java 8 ya trae registrado los driver de Oracle y no es necesario forzaer la carga de los drivers con Class.forName()
            this.conn = DriverManager.getConnection(url, prop);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

    }

    //Getter de conn (Objeto Connection que inicia la conexión):
    public static Connection getConn() {
        return conn;
    }

}
