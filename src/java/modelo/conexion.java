/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexion class to handle database connection.
 */
public class conexion {
    /* Connection to the database
    puerto = 3306
    urlconexion = jdbc:mysql://127.0.0.1:3306/db_empresa
    usuario: root
    contraseña = DANIGERO
    DRIVER DE CONEXION: com.mysql.cj.jdbc.Driver
    */
    
    private final String puerto = "3306";
    private final String db = "db_emp";
    private final String urlconexion = String.format("jdbc:mysql://localhost:3306/db_emp");
    private final String user = "root";
    private final String password = "danigero";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    public Connection conectar_db;

    public void abrir_conexion() {
        try {
            Class.forName(jdbc);
            conectar_db = DriverManager.getConnection(urlconexion, user, password);
            System.out.println("Conexion exitosa...");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al conectar base de datos: " + ex.getMessage());
        }
    }

    public void cerrar_conexion() {
        try {
                conectar_db.close();
                System.out.println("Conexion cerrada...");
        } catch (SQLException ex) {
            System.out.println("Error al cerrar base de datos: " + ex.getMessage());
        }
    }
}
