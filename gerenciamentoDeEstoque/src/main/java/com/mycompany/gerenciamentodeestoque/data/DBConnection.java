/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentodeestoque.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Glória
 */
public class DBConnection {
    
    private static Connection con;
    
    public void getDBConn(){
        synchronized (""){
            try {
                if (this.getCon() == null || this.getCon().isClosed()){
                    try {
                        String url = "jdbc:mysql://localhost/estoque?characterEncoding=UTF-8";
                        Class.forName("com.mysql.jdbc.Driver");
                        setCon(DriverManager.getConnection(url, "root", "mysql"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}

public static Connection getCon(){
    return con;
}

public static void setCon(Connection aCon){
    con = aCon;
}

public static void closeConnection(){
    try {
        con.close();
    } catch (Exception e){
        e.printStackTrace();
    }
}
}