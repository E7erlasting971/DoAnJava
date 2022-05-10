/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Thinh Ly
 */
public class KetNoiCSDL {
    public Connection conn;
    public KetNoiCSDL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection
            ("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
            + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
