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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.chuyennganh_md;
import model.dichvu_md;
import model.phongkhambenh_md;
public class dichvu_ctl {
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
     public List<dichvu_md> loaddichvu(){
        List<dichvu_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM dichvukham inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh");
            while(rs.next()){
                dichvu_md a=new dichvu_md();
                phongkhambenh_md b = new phongkhambenh_md();
              a.setMadv(rs.getString("madv"));
               a.setTendv(rs.getString("tendv"));
               b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                a.setDongia(rs.getFloat("dongia"));
                 b.setMaphongkhambenh(rs.getString("maphongkhambenh"));
                a.setPhongkhambenh(b);
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public void click(JTable table, JTextField mk,JTextField gc,JComboBox tk,JTextField gcc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                         String ma = table.getValueAt(row, 0).toString();
                         String mt = table.getValueAt(row,1).toString();
                         String ten = table.getValueAt(row, 4).toString();
                        
                          String mtt = table.getValueAt(row,3).toString();
                         mk.setText(ma);
                         gc.setText(mt);
                         tk.setSelectedItem(ten);
                         
                             gcc.setText(mtt);
     
                     }
                 }
             }
         });
         
     }
      
      
      public List<dichvu_md> addmadichvu(){
        List<dichvu_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dichvukham");
            while(rs.next()){
              dichvu_md khach = new dichvu_md();
                khach.setMadv(rs.getString("madv"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<dichvu_md> timkiemtendv(String t){
        List<dichvu_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM dichvukham inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh WHERE dichvukham.tendv like N'"+t+"'");
            while(rs.next()){
                dichvu_md a=new dichvu_md();
                phongkhambenh_md b = new phongkhambenh_md();
              a.setMadv(rs.getString("madv"));
               a.setTendv(rs.getString("tendv"));
               b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                a.setDongia(rs.getFloat("dongia"));
                
                a.setPhongkhambenh(b);
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
              public List<dichvu_md> timkiemtenphongkhambenh(String t){
        List<dichvu_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM dichvukham inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh WHERE phongkhambenh.tenphongkhambenh like N'"+t+"'");
            while(rs.next()){
                dichvu_md a=new dichvu_md();
                phongkhambenh_md b = new phongkhambenh_md();
              a.setMadv(rs.getString("madv"));
               a.setTendv(rs.getString("tendv"));
               b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                a.setDongia(rs.getFloat("dongia"));
                
                a.setPhongkhambenh(b);
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
          public List<dichvu_md> timkiemmadv(String ma){
        List<dichvu_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM dichvukham inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh WHERE dichvukham.madv='"+ma+"'");
               while(rs.next()){
                dichvu_md a=new dichvu_md();
                phongkhambenh_md b = new phongkhambenh_md();
              a.setMadv(rs.getString("madv"));
               a.setTendv(rs.getString("tendv"));
               b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                a.setDongia(rs.getFloat("dongia"));
                
                a.setPhongkhambenh(b);
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public boolean themdichvukham(dichvu_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO dichvukham VALUES('"+khoa.getMadv()+"',N'"+khoa.getTendv()+"','"+khoa.getMaphongkhambenh()+"','"+khoa.getDongia()+"')";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suadichvukham(dichvu_md khach){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE dichvukham SET tendv=N'"+khach.getTendv()+"',maphongkhambenh='"+khach.getMaphongkhambenh()+"',dongia='"+khach.getDongia()+"' WHERE madv='"+khach.getMadv()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoadichvukham(dichvu_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  dichvukham WHERE madv='"+khoa.getMadv()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }     
}
