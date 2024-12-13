/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctl;

import ctl.chuyennganh_ctl;
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
import model.capbac_md;
import model.chuyennganh_md;

public class capbac_ctl {

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

    public List<capbac_md> loadcapbac() {
        List<capbac_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM capbac");
            while (rs.next()) {
                capbac_md a = new capbac_md();

                a.setMacapbac(rs.getString("macapbac"));
                a.setTencapbac(rs.getString("tencapbac"));
                a.setHedaotao(rs.getString("hedaotao"));
                a.setGhichu(rs.getString("ghichu"));

                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public void click(JTable table, JTextField mcb, JTextField tcb, JComboBox mcn, JTextField hsl) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        String macb = table.getValueAt(row, 0).toString();
                        String tencb = table.getValueAt(row, 1).toString();
                        String cnmt = table.getValueAt(row, 2).toString();
                        String hesl = table.getValueAt(row, 3).toString();

                        mcb.setText(macb);
                        tcb.setText(tencb);

                        mcn.setSelectedItem(cnmt);
                        hsl.setText(hesl);

                    }
                }
            }
        });

    }

    public List<capbac_md> addmacapbac() {
        List<capbac_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM capbac");
            while (rs.next()) {
                capbac_md khach = new capbac_md();
                khach.setMacapbac(rs.getString("macapbac"));
                listkhoa.add(khach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<capbac_md> timkiemmacapbac(String ma) {
        List<capbac_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM capbac WHERE capbac.macapbac ='" + ma + "'");
            while (rs.next()) {
                capbac_md a = new capbac_md();

                a.setMacapbac(rs.getString("macapbac"));
                a.setTencapbac(rs.getString("tencapbac"));
                a.setHedaotao(rs.getString("hedaotao"));
                a.setGhichu(rs.getString("ghichu"));

                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<capbac_md> timkiemtencapbac(String ma) {
        List<capbac_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM capbac WHERE capbac.tencapbac ='" + ma + "'");
            while (rs.next()) {
                capbac_md a = new capbac_md();

                a.setMacapbac(rs.getString("macapbac"));
                a.setTencapbac(rs.getString("tencapbac"));
                a.setHedaotao(rs.getString("hedaotao"));
                a.setGhichu(rs.getString("ghichu"));

                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public List<capbac_md> timkiemhedaotao(String ma) {
        List<capbac_md> listkhoa = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM capbac WHERE capbac.hedaotao ='" + ma + "'");
            while (rs.next()) {
                capbac_md a = new capbac_md();

                a.setMacapbac(rs.getString("macapbac"));
                a.setTencapbac(rs.getString("tencapbac"));
                a.setHedaotao(rs.getString("hedaotao"));
                a.setGhichu(rs.getString("ghichu"));

                listkhoa.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listkhoa;
    }

    public boolean themcapbac(capbac_md khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO capbac VALUES('" + khoa.getMacapbac() + "',N'" + khoa.getTencapbac() + "',N'" + khoa.getHedaotao() + "',N'" + khoa.getGhichu() + "')";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suacapbac(capbac_md khach) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE capbac SET tencapbac=N'" + khach.getTencapbac() + "',hedaotao=N'" + khach.getHedaotao() + "'N'" + khach.getGhichu() + "' WHERE macapbac='" + khach.getMacapbac() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoacapbac(capbac_md khoa) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM  capbac WHERE macapbac='" + khoa.getMacapbac() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
