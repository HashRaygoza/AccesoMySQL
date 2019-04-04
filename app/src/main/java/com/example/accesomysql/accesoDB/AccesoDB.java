package com.example.accesomysql.accesoDB;

import android.database.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesoDB implements Runnable {
    private String version = "-1";
    private String error = "";

    @Override
    public void run() {
        try {
            String sql = "SELECT version()";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.100.240:3306/test", "usuarioPruebas", "qwerty");
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