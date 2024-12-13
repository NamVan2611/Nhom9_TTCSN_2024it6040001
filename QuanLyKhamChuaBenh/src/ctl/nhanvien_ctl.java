/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;

import static ctl.phongkham_ctl.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.nhanvien_md;


public class nhanvien_ctl {
     public static String dbURL ="jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs;user=vuthibac1106;password=111";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbURL);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
         public List<nhanvien_md> addmanhanvien(){
        List<nhanvien_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhanvien where tenbophantructhuoc like N'Bộ Phận Tiếp Tân'");
            while(rs.next()){
              nhanvien_md khach = new nhanvien_md();
                khach.setManv(rs.getString("manv"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
               public List<nhanvien_md> addmanhanvienketoan(){
        List<nhanvien_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhanvien where tenbophantructhuoc like N'Bộ Phận Kế Toán'");
            while(rs.next()){
              nhanvien_md khach = new nhanvien_md();
                khach.setManv(rs.getString("manv"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
}
