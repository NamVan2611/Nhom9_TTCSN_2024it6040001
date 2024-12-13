/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.chuyennganh_md;
import model.phongkham_md;
public class phongkham_ctl {
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
     public List<phongkham_md> loadphongkham(){
        List<phongkham_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh inner join phongkham on phongkham.machuyennganh=chuyennganh.machuyennganh");
            while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
                phongkham_md b=new phongkham_md();
               b.setMaphong(rs.getString("maphong"));
                b.setMachuyennganh(rs.getString("machuyennganh"));
               a.setTenchuyennganh(rs.getString("tenchuyennganh"));
                b.setDiachiphongkham(rs.getString("diadiemphongkham"));
                   b.setTenphongkham(rs.getString("tenphongkham"));
                b.setChuyennganh(a);
                listkhoa.add(b);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public void click(JTable table, JTextField mk,JComboBox tk,JTextField gc,JTextField gcc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                         String ma = table.getValueAt(row, 0).toString();
                         String ten = table.getValueAt(row, 1).toString();
                         String mt = table.getValueAt(row, 3).toString();
                          String mtt = table.getValueAt(row, 4).toString();
                         mk.setText(ma);
                         tk.setSelectedItem(ten);
                         gc.setText(mt);
                             gcc.setText(mtt);
     
                     }
                 }
             }
         });
         
     }
      
      
      public List<phongkham_md> addmaphong(){
        List<phongkham_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phongkham");
            while(rs.next()){
              phongkham_md khach = new phongkham_md();
                khach.setMaphong(rs.getString("maphong"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<phongkham_md> timkiemtenchuyennganh(String t){
        List<phongkham_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh inner join phongkham on phongkham.machuyennganh=chuyennganh.machuyennganh WHERE chuyennganh.tenchuyennganh like N'"+t+"'");
            while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
                phongkham_md b=new phongkham_md();
               b.setMaphong(rs.getString("maphong"));
                 b.setMachuyennganh(rs.getString("machuyennganh"));
               a.setTenchuyennganh(rs.getString("tenchuyennganh"));
                b.setDiachiphongkham(rs.getString("diadiemphongkham"));
                 b.setTenphongkham(rs.getString("tenphongkham"));
                b.setChuyennganh(a);
                listkhoa.add(b);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
          public List<phongkham_md> timkiemmaphong(String ma){
        List<phongkham_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh inner join phongkham on phongkham.machuyennganh=chuyennganh.machuyennganh WHERE phongkham.maphong ='"+ma+"'");
               while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
                phongkham_md b=new phongkham_md();
               b.setMaphong(rs.getString("maphong"));
                 b.setMachuyennganh(rs.getString("machuyennganh"));
               a.setTenchuyennganh(rs.getString("tenchuyennganh"));
                b.setDiachiphongkham(rs.getString("diadiemphongkham"));
                 b.setTenphongkham(rs.getString("tenphongkham"));
                b.setChuyennganh(a);
                listkhoa.add(b);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public boolean themphongkham(phongkham_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO phongkham VALUES(N'"+khoa.getMaphong()+"','"+khoa.getMachuyennganh()+"',N'"+khoa.getDiachiphongkham()+"',N'"+khoa.getTenphongkham()+"')";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suaphongkham(phongkham_md khach){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE phongkham SET machuyennganh='"+khach.getMachuyennganh()+"',diadiemphongkham=N'"+khach.getDiachiphongkham()+"',tenphongkham=N'"+khach.getTenphongkham()+"' WHERE maphong='"+khach.getMaphong()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoaphongkham(phongkham_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  phongkham WHERE maphong='"+khoa.getMaphong()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }     
}
