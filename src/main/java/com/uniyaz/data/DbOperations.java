package com.uniyaz.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.uniyaz.domain.Katagori;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 4.3.2021.
 */
public class DbOperations {

 //   static String conUrl="jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false";
 //   static String conUser="deneme";
 //   static String conPass="1Qaz2wsx!!";
static String driverName="com.mysql.jdbc.Driver";
    static String conUrl="jdbc:mysql://127.0.0.1:3306/caglar";
    static String conUser="root";
    static String conPass="Caglar";
   static Connection con=null;

    public static Connection getConnection()  {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con= DriverManager.getConnection(conUrl,conUser,conPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }



    public static void connectAndExecute(String sql){
        try (Connection con= DriverManager.getConnection(
                conUrl,conUser,conPass);
             PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}