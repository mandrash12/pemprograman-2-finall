package com.rental.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/rental_mobil?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Jakarta";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
}
