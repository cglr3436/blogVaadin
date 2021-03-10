package com.uniyaz.data;

import com.uniyaz.domain.Katagori;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KatagoriDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;


    public static List<Katagori> tumKatagoriGetir() {
        List<Katagori> katogariList = new ArrayList<>();
        String sql = "SELECT * FROM KATAGORI where 1=1";

        try (
                Connection con= DbOperations.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("KATAGORI_ADI");
                Katagori katogari = new Katagori(id, name);
                katogariList.add(katogari);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return katogariList;
    }



    public static void katagoriEkle(String katagori_adi) {
        String sql = "INSERT INTO KATAGORI (KATAGORI_ADI)"+" VALUES('%s');";
        sql=String.format(sql,katagori_adi);
        DbOperations.connectAndExecute(sql);
    }
    public static void katagoriSil(int id){
        String sql = "DELETE FROM KATAGORI WHERE KATAGORI_ID=%d";
        sql=String.format(sql,id);
        DbOperations.connectAndExecute(sql);
    }

    public static void katagoriGuncelle(int id,String katagori_adi){
        String sql = "UPDATE KATAGORI SET KATAGORI_ADI='%s' WHERE KATAGORI_ID=%d";
        sql=String.format(sql,katagori_adi,id);
        DbOperations.connectAndExecute(sql);
    }
    public static Katagori katagoriGetir(int katagoriId) {
        String sql = "SELECT * FROM KATAGORI WHERE KATAGORI_ID = " + katagoriId;

        try (
                Connection con= DbOperations.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("KATAGORI_ADI");
                Katagori katagori = new Katagori(id, name);
                return katagori;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
