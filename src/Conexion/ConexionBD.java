package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    /** Parametros de conexion */
    static String bd = "mercadolibrebd";
    static String login = "Dreal";
    static String password = "12345678910Real";
    static String url = "jdbc:mysql://localhost/" + bd;

    Connection connection = null;

    /** Constructor */
    public ConexionBD() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println("Conexion Fallida");
        } catch (ClassNotFoundException e) {
            System.out.println("Conexion Fallida");
        } catch (Exception e) {
            System.out.println("Conexion Fallida");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }
}