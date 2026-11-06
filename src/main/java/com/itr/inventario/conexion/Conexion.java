package com.itr.inventario.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // URL LOCAL (localhost en lugar de db)
    private static final String URL = "jdbc:mysql://localhost:3306/itr?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Cristi1929"; // Pon tu contraseña de MySQL aquí

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // AGREGA ESTA LÍNEA:
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos ITR!");
        } catch (Exception e) { // Cambia SQLException por Exception por si falla el Class.forName
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}