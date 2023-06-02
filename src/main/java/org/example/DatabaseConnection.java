package org.example;

import java.sql.*;

public class DatabaseConnection {

    static String url = "jdbc:mysql://localhost:3306/shoestore";
    static String username = "root";
    static String password = "17510067300";
    static Connection connection = null;

    static boolean connection(){
        try {
            connection = DriverManager.getConnection(url,username,password);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }


    static ResultSet listed(String sql){
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    static void insert(String sql){
        Statement st;

        try {
            System.out.println("*************************************************************************");
            st = connection.createStatement();
            st.executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
            st.executeUpdate(sql);
            System.out.println("added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
