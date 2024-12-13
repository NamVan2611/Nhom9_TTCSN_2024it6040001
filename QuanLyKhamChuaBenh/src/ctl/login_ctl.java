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
import model.login_md;
import view.hoadonkhambenh;
import view.hoadonkhambenh1;
import view.ketquakhambenh;
import view.ketquakhambenh1;
import view.quatrinhkhambenhtheoBHYT;
import view.trangchu;
import view.vekham;
import view.vekham1;

public class login_ctl {

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

    public boolean login(String mangdung, String matkhau) {
        try {
            Connection conn = getConnection();
            String sql = "SELECT * FROM ngdung WHERE maso='" + mangdung + "' AND matkhau='" + matkhau + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String chucdanh = rs.getString(3);

                if (chucdanh.equals("AD")) {
                    quatrinhkhambenhtheoBHYT f = new quatrinhkhambenhtheoBHYT();
                    f.show();
                    return true;
                }
                if (chucdanh.equals("QLPK")) {
                    trangchu f = new trangchu();
                    f.show();

                    return true;
                }
                if (chucdanh.equals("LT")) {
                    vekham1 f = new vekham1();
                    f.show();

                    return true;
                }
                if (chucdanh.equals("KT")) {
                    hoadonkhambenh1 f = new hoadonkhambenh1();
                    f.show();

                    return true;
                }
                if (chucdanh.equals("BS")) {
                    ketquakhambenh1 f = new ketquakhambenh1();
                    f.show();

                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean suamk(login_md khach) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE ngdung SET matkhau='" + khach.getMatkhau() + "' WHERE maso='" + khach.getMaso() + "'";
            int a = st.executeUpdate(sql);
            return a > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
