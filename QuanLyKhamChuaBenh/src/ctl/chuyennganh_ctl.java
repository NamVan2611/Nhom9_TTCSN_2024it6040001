/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.chuyennganh_md;
public class chuyennganh_ctl {
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
     public List<chuyennganh_md> loadchuyennganh(){
        List<chuyennganh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh");
            while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
                a.setMachuyennganh(rs.getString("machuyennganh"));
                a.setTenchuyennganh(rs.getString("tenchuyennganh"));
                a.setMota(rs.getString("mota"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
      public void click(JTable table, JTextField mk,JTextField tk,JTextArea gc){
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
             public void valueChanged(ListSelectionEvent e){
                 if(!e.getValueIsAdjusting()){
                     int row = table.getSelectedRow();
                     if( row != -1){
                         String ma = table.getValueAt(row, 0).toString();
                         String ten = table.getValueAt(row, 1).toString();
                         String mt = table.getValueAt(row, 2).toString();
                         mk.setText(ma);
                         tk.setText(ten);
                         gc.setText(mt);
                        
     
                     }
                 }
             }
         });
         
     }
      
      
      public List<chuyennganh_md> addmachuyennganh(){
        List<chuyennganh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh");
            while(rs.next()){
                chuyennganh_md khach = new chuyennganh_md();
                khach.setMachuyennganh(rs.getString("machuyennganh"));
                listkhoa.add(khach);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public List<chuyennganh_md> timkiemmachuyennganh(String ma){
        List<chuyennganh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh WHERE machuyennganh='"+ma+"'");
            while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
                a.setMachuyennganh(rs.getString("machuyennganh"));
                a.setTenchuyennganh(rs.getString("tenchuyennganh"));
           
                a.setMota(rs.getString("mota"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
          public List<chuyennganh_md> timkiemten(String ten){
        List<chuyennganh_md> listkhoa = new ArrayList<>();
        try{
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM chuyennganh WHERE tenchuyennganh like N'"+ten+"'");
            while(rs.next()){
                chuyennganh_md a = new chuyennganh_md();
              a.setMachuyennganh(rs.getString("machuyennganh"));
                a.setTenchuyennganh(rs.getString("tenchuyennganh"));
                a.setMota(rs.getString("mota"));
                listkhoa.add(a);
            } 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listkhoa;
    }
        public boolean themchuyennganh(chuyennganh_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "INSERT INTO chuyennganh VALUES(N'"+khoa.getMachuyennganh()+"',N'"+khoa.getTenchuyennganh()+"',N'"+khoa.getMota()+"')";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                public boolean suachuyennganh(chuyennganh_md khach){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "UPDATE chuyennganh SET tenchuyennganh=N'"+khach.getTenchuyennganh()+"',mota=N'"+khach.getMota()+"' WHERE machuyennganh='"+khach.getMachuyennganh()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }
                        public boolean xoachuyennganh(chuyennganh_md khoa){
            try{
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                String sql = "DELETE FROM  chuyennganh WHERE machuyennganh=N'"+khoa.getMachuyennganh()+"'";
                int a = st.executeUpdate(sql);
                return a> 0;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
        }  
}
