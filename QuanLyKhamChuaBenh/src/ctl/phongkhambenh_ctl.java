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
import model.phongkhambenh_md;
public class phongkhambenh_ctl {
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
     public List<phongkhambenh_md> loadphongkhambenh(){
        List<phongkhambenh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM phongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=phongkhambenh.machuyennganh");
            while(rs.next()){
                phongkhambenh_md a = new phongkhambenh_md();
             
                  chuyennganh_md c=new chuyennganh_md();
              a.setMaphongkhambenh(rs.getString("maphongkhambenh"));
              
               a.setDiachiphongkhambenh(rs.getString("diachiphong"));
                   a.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                   c.setTenchuyennganh(rs.getString("tenchuyennganh"));  
              a.setChuyennganh(c);
              listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public void click(JTable table, JTextField tkk, JTextField mk, JComboBox tke,JTextField gcc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                         String mpkb = table.getValueAt(row, 0).toString();
                       
                         String dcp = table.getValueAt(row,1).toString();
                          String mp = table.getValueAt(row, 3).toString();
                            String tpkb = table.getValueAt(row, 2).toString();
                        tkk.setText(mpkb);
                     
                        mk.setText(dcp);
                        tke.setSelectedItem(mp);
                       
                            gcc.setText(tpkb);
     
                     }
                 }
             }
         });
         
     }
      
      
      public List<phongkhambenh_md> addmaphongkhambenh(){
        List<phongkhambenh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM phongkhambenh");
            while(rs.next()){
              phongkhambenh_md khach = new phongkhambenh_md();
                khach.setMaphongkhambenh(rs.getString("maphongkhambenh"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<phongkhambenh_md> timkiemtenchuyennganh(String t){
        List<phongkhambenh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery("SELECT * FROM phongkhambenh  inner join chuyennganh on chuyennganh.machuyennganh=phongkhambenh.machuyennganh WHERE chuyennganh.tenchuyennganh like N'"+t+"'");
            while(rs.next()){
                phongkhambenh_md a = new phongkhambenh_md();
              
                  chuyennganh_md c=new chuyennganh_md();
              a.setMaphongkhambenh(rs.getString("maphongkhambenh"));
            
               a.setDiachiphongkhambenh(rs.getString("diachiphong"));
               
                   a.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
            c.setTenchuyennganh(rs.getString("tenchuyennganh"));
              a.setChuyennganh(c);
              listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
          public List<phongkhambenh_md> timkiemmaphongkhambenh(String ma){
        List<phongkhambenh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM phongkhambenh  inner join chuyennganh on chuyennganh.machuyennganh=phongkhambenh.machuyennganh WHERE phongkhambenh.maphongkhambenh ='"+ma+"'");
               while(rs.next()){
              phongkhambenh_md a = new phongkhambenh_md();
              
                  chuyennganh_md c=new chuyennganh_md();
              a.setMaphongkhambenh(rs.getString("maphongkhambenh"));
            
               a.setDiachiphongkhambenh(rs.getString("diachiphong"));
               
                   a.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
            c.setTenchuyennganh(rs.getString("tenchuyennganh"));
              a.setChuyennganh(c);
              listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      
                   public List<phongkhambenh_md> timkiemtenphongkhambenh(String ma){
        List<phongkhambenh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery("SELECT * FROM phongkhambenh  inner join chuyennganh on chuyennganh.machuyennganh=phongkhambenh.machuyennganh WHERE phongkhambenh.tenphongkhambenh like N'"+ma+"'");
               while(rs.next()){
                phongkhambenh_md a = new phongkhambenh_md();
              
                  chuyennganh_md c=new chuyennganh_md();
              a.setMaphongkhambenh(rs.getString("maphongkhambenh"));
            
               a.setDiachiphongkhambenh(rs.getString("diachiphong"));
            
                   a.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
               c.setTenchuyennganh(rs.getString("tenchuyennganh"));
              a.setChuyennganh(c);
              listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public boolean themphongkhambenh(phongkhambenh_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO phongkhambenh VALUES('"+khoa.getMaphongkhambenh()+"',N'"+khoa.getDiachiphongkhambenh()+"',N'"+khoa.getTenphongkhambenh()+"','"+khoa.getMachuyennganh()+"')";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suaphongkhambenh(phongkhambenh_md khach){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE phongkhambenh SET diachiphong=N'"+khach.getDiachiphongkhambenh()+"',tenphongkhambenh=N'"+khach.getTenphongkhambenh()+"',machuyennganh='"+khach.getMachuyennganh()+"' WHERE maphongkhambenh='"+khach.getMaphongkhambenh()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoaphongkhambenh(phongkhambenh_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
              String sql = "delete from phongkhambenh  WHERE maphongkhambenh='"+khoa.getMaphongkhambenh()+"'";
                     int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }     
}
