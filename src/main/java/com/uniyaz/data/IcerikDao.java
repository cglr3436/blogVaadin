
package com.uniyaz.data;
import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Katagori;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 public class IcerikDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;


    public static List<Icerik> tumIcerikiGetir() {
        List<Icerik> icerikList = new ArrayList<>();
        String sql = "SELECT * FROM ICERIK WHERE 1=1";

        try (
                Connection con= DbOperations.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int katagori_id = resultSet.getInt(2);
                String icerik_baslik = resultSet.getString("ICERIK_BASLIK");
                String icerik_detay = resultSet.getString("ICERIK_DETAY");
                 Blob resım = resultSet.getBlob("RESIM");
                Icerik icerik = new Icerik(id,katagori_id,icerik_baslik,icerik_detay,resım);
                icerikList.add(icerik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return icerikList;
    }

     public static List<Icerik> tumIcerikiGetir(int katagori_id) {
         List<Icerik> icerikList = new ArrayList<>();
         String sql = "SELECT * FROM ICERIK WHERE KATAGORI_ID="+katagori_id;

         try (
                 Connection con= DbOperations.getConnection();
                 PreparedStatement preparedStatement = con.prepareStatement(sql);
         ) {
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 int id = resultSet.getInt(1);
                  katagori_id = resultSet.getInt(2);
                 String icerik_baslik = resultSet.getString("ICERIK_BASLIK");
                 String icerik_detay = resultSet.getString("ICERIK_DETAY");
                 Blob resım = resultSet.getBlob("RESIM");
                 Icerik icerik = new Icerik(id,katagori_id,icerik_baslik,icerik_detay,resım);
                 icerikList.add(icerik);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return icerikList;
     }

     public static void icerikEkle(int KATAGORI_ID,String ICERIK_BASLIK,String ICERIK_DETAY) {

        String sql = "INSERT INTO ICERIK (KATAGORI_ID,ICERIK_BASLIK,ICERIK_DETAY)"+" VALUES('%d','%s','%s');";
        sql=String.format(sql,KATAGORI_ID,ICERIK_BASLIK,ICERIK_DETAY);
        DbOperations.connectAndExecute(sql);
    }
    public static void icerikSil(int id){
        String sql = "DELETE FROM ICERIK WHERE ICERIK_ID=%d";
        sql=String.format(sql,id);
        DbOperations.connectAndExecute(sql);
    }

    public static void icerikGuncelle(int id,int katagori_id,String icerik_baslik,String icerik_detay,Blob resım,InputStream inputStream){

        try {

        String sql ="UPDATE ICERIK SET KATAGORI_ID=?,ICERIK_BASLIK=?,ICERIK_DETAY=? ,RESIM =? WHERE ICERIK_ID=?";

        //String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
        PreparedStatement statement = DbOperations.getConnection().prepareStatement(sql);

            statement.setInt(1, katagori_id);
            statement.setString(2, icerik_baslik);
            statement.setString(3, icerik_detay);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(4, inputStream);
            }
            statement.setInt(5, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Icerik IcerikGetir(int icerikId) {
        String sql = "SELECT * FROM ICERIK WHERE ICERIK_ID = " + icerikId;

        try (
                Connection con= DbOperations.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int katagori_id = resultSet.getInt(2);
                String icerik_baslik = resultSet.getString("ICERIK_BASLIK");
                String icerik_detay = resultSet.getString("ICERIK_DETAY");
                Blob resım = resultSet.getBlob("RESIM");
                Icerik icerik = new Icerik(id,katagori_id,icerik_baslik,icerik_detay,resım);
                return icerik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

     private static FileInputStream readFile(String fileName) {
         FileInputStream temp=null;
         try (FileInputStream fis = new FileInputStream(new File(fileName))) {
             temp=fis;

         } catch (IOException e) {
             e.printStackTrace();
         }
            return temp;
     }
 }