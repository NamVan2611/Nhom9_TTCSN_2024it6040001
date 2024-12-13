/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;

import java.awt.TextField;
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
import model.bacsi_md;
import model.capbac_md;
import model.chuyennganh_md;
import model.phongkhambenh_md;

public class bacsi_ctl {

    public static String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs;user=vuthibac1106;password=111";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public List<bacsi_md> loadbacsi() {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bacsi inner join phongkhambenh on phongkhambenh.maphongkhambenh=bacsi.maphongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=bacsi.machuyennganh inner join capbac on bacsi.macapbac=capbac.macapbac");
            while (rs.next()) {
                bacsi_md a = new bacsi_md();
                phongkhambenh_md b = new phongkhambenh_md();
                chuyennganh_md c = new chuyennganh_md();
                 capbac_md d = new capbac_md();
                a.setMabacsi(rs.getString("mabacsi"));
                b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                c.setTenchuyennganh(rs.getString("tenchuyennganh"));
                 d.setTencapbac(rs.getString("tencapbac"));
                a.setHoten(rs.getString("hoten"));
                a.setSdt(rs.getString("sdt"));
                a.setDiachi(rs.getString("diachi"));
                
                a.setPhongkhambenh(b);
                a.setChuyennganh(c);
                a.setCapbac(d);
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public void click(JTable table, JTextField mbs, JComboBox mpkb, JComboBox mcn,JComboBox mcb, JTextField ht, JTextField sdt, JTextField dc) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        String mabs = table.getValueAt(row, 0).toString();
                        String mapkb = table.getValueAt(row, 1).toString();
                        String macn = table.getValueAt(row, 2).toString();
                        String macb1= table.getValueAt(row, 3).toString();
                        String hot = table.getValueAt(row, 4).toString();
                        String sodt = table.getValueAt(row, 5).toString();
                        String diac = table.getValueAt(row, 6).toString();
                       
                        mbs.setText(mabs);
                        mpkb.setSelectedItem(mapkb);
                        mcn.setSelectedItem(macn);
                          mcb.setSelectedItem(macb1);
                        ht.setText(hot);
                        sdt.setText(sodt);
                        dc.setText(diac);
                       
                    }
                }
            }
        });

    }

    public List<bacsi_md> addmabacsi() {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bacsi");
            while (rs.next()) {
                bacsi_md khach = new bacsi_md();
                khach.setMabacsi(rs.getString("mabacsi"));
                listkhoa.add(khach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<bacsi_md> timkiemtenchuyennganh(String t) {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM bacsi inner join phongkhambenh on phongkhambenh.maphongkhambenh=bacsi.maphongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=bacsi.machuyennganh inner join capbac on bacsi.macapbac=capbac.macapbac WHERE chuyennganh.tenchuyennganh like N'" + t + "'");
            while (rs.next()) {
                 bacsi_md a = new bacsi_md();
                phongkhambenh_md b = new phongkhambenh_md();
                chuyennganh_md c = new chuyennganh_md();
                 capbac_md d = new capbac_md();
                a.setMabacsi(rs.getString("mabacsi"));
                b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                c.setTenchuyennganh(rs.getString("tenchuyennganh"));
                 d.setTencapbac(rs.getString("tencapbac"));
                a.setHoten(rs.getString("hoten"));
                a.setSdt(rs.getString("sdt"));
                a.setDiachi(rs.getString("diachi"));
             
                a.setPhongkhambenh(b);
                a.setChuyennganh(c);
                      a.setCapbac(d);
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<bacsi_md> timkiemtenphongkhambenh(String ma) {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM bacsi inner join phongkhambenh on phongkhambenh.maphongkhambenh=bacsi.maphongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=bacsi.machuyennganh inner join capbac on bacsi.macapbac=capbac.macapbac WHERE phongkhambenh.tenphongkhambenh like N'" + ma + "'");
            while (rs.next()) {
                bacsi_md a = new bacsi_md();
                phongkhambenh_md b = new phongkhambenh_md();
                chuyennganh_md c = new chuyennganh_md();
                 capbac_md d = new capbac_md();
                a.setMabacsi(rs.getString("mabacsi"));
                b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                c.setTenchuyennganh(rs.getString("tenchuyennganh"));
                 d.setTencapbac(rs.getString("tencapbac"));
                a.setHoten(rs.getString("hoten"));
                a.setSdt(rs.getString("sdt"));
                a.setDiachi(rs.getString("diachi"));
             
                a.setPhongkhambenh(b);
                      a.setCapbac(d);
                a.setChuyennganh(c);
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<bacsi_md> timkiemtenbacsi(String ma) {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM bacsi inner join phongkhambenh on phongkhambenh.maphongkhambenh=bacsi.maphongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=bacsi.machuyennganh inner join capbac on bacsi.macapbac=capbac.macapbac WHERE bacsi.tenbacsi like N'" + ma + "'");
            while (rs.next()) {
               bacsi_md a = new bacsi_md();
                phongkhambenh_md b = new phongkhambenh_md();
                chuyennganh_md c = new chuyennganh_md();
                 capbac_md d = new capbac_md();
                a.setMabacsi(rs.getString("mabacsi"));
                b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                c.setTenchuyennganh(rs.getString("tenchuyennganh"));
                 d.setTencapbac(rs.getString("tencapbac"));
                a.setHoten(rs.getString("hoten"));
                a.setSdt(rs.getString("sdt"));
                a.setDiachi(rs.getString("diachi"));
               
                a.setPhongkhambenh(b);
                a.setChuyennganh(c);
                      a.setCapbac(d);
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<bacsi_md> timkiemmabacsi(String ma) {
        List<bacsi_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM bacsi inner join phongkhambenh on phongkhambenh.maphongkhambenh=bacsi.maphongkhambenh inner join chuyennganh on chuyennganh.machuyennganh=bacsi.machuyennganh inner join capbac on bacsi.macapbac=capbac.macapbac WHERE bacsi.mabacsi= '" + ma + "'");
            while (rs.next()) {
                bacsi_md a = new bacsi_md();
                phongkhambenh_md b = new phongkhambenh_md();
                chuyennganh_md c = new chuyennganh_md();
                 capbac_md d = new capbac_md();
                a.setMabacsi(rs.getString("mabacsi"));
                b.setTenphongkhambenh(rs.getString("tenphongkhambenh"));
                c.setTenchuyennganh(rs.getString("tenchuyennganh"));
                 d.setTencapbac(rs.getString("tencapbac"));
                a.setHoten(rs.getString("hoten"));
                a.setSdt(rs.getString("sdt"));
                a.setDiachi(rs.getString("diachi"));
               
                a.setPhongkhambenh(b);
                a.setChuyennganh(c);
                      a.setCapbac(d);
                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public boolean thembacsi(bacsi_md khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO bacsi VALUES('" + khoa.getMabacsi() + "','" + khoa.getMaphongkhambenh() + "','" + khoa.getMachuyennganh() + "',N'" + khoa.getHoten() + "','" + khoa.getSdt() + "',N'" + khoa.getDiachi() + "','" + khoa.getMacapbac() + "')";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

public boolean suabacsi(bacsi_md khach) {
    try {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String sql = "UPDATE bacsi SET maphongkhambenh='" + khach.getMaphongkhambenh() + "', machuyennganh='" + khach.getMachuyennganh() + "', hoten=N'" + khach.getHoten() + "', sdt='" + khach.getSdt() + "', diachi=N'" + khach.getDiachi() + "', macapbac='" + khach.getMacapbac() + "' WHERE mabacsi='" + khach.getMabacsi() + "'";
        int a = st.executeUpdate(sql);
        return a > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
    public boolean xoabacsi(bacsi_md khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "delete from bacsi  WHERE mabacsi='" + khoa.getMabacsi() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
