package com.example.accesomysql.accesoDB;

import android.database.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesoDB implements Runnable {
    private String version = "-1";
    private String error = "";

    private String url;
    private String usuario;
    private String password;

    public AccesoDB() {
        url = "192.168.100.240";
        usuario = "usuarioPruebas";
        password = "qwerty";
    }

    public AccesoDB(String urlBaseDatos, String usuarioBAseDatos, String passwordBaseDatos) {
        url = urlBaseDatos;
        usuario = usuarioBAseDatos;
        password = passwordBaseDatos;
    }

    @Override
    public void run() {
        try {
            String sql = "SELECT version()";
            Class.forName("com.mysql.jdbc.Driver");

            String cadenaConexion = "jdbc:mysql://" + url + ":3306";

            Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            Statement consulta = conexion.createStatement();
            ResultSet data = consulta.executeQuery(sql);
            data.next();

            setVersion(data.getString(1));

            data.close();
            consulta.close();
            conexion.close();

        } catch (SQLException | java.sql.SQLException se) {
            this.setError("SQLEXCEPTION");
        } catch (ClassNotFoundException e) {
            this.setError("CLASSNOTFOUND");
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}