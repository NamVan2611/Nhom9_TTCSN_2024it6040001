/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import ctl.bacsi_ctl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bacsi_md;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ketquakhambenh1 extends javax.swing.JFrame {

    private bacsi_ctl bacsi_ctl;

    public ketquakhambenh1() {
        initComponents();
        bacsi_ctl = new bacsi_ctl();
//        addmabacsi();
        loadketquakb();
          Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Hiển thị ngày tháng lên JTextField
        nkb.setDate(currentDate);
    }

//    private void addmabacsi() {
//        try {
//            List<bacsi_md> listkhoa = bacsi_ctl.addmabacsi();
//            DefaultTableModel tb = new DefaultTableModel();
//            for (bacsi_md a : listkhoa) {
//                mbs.addItem(a.getMabacsi());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

   public void loadketquakb() {
    String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs";
    String username = "vuthibac1106";
    String password = "111";
    Connection conn;
    try {
        conn = DriverManager.getConnection(dbURL, username, password);
        Statement st = conn.createStatement();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã Kết Quả");
        tableModel.addColumn("Mã Vé Khám");
        tableModel.addColumn("Họ Tên Bệnh Nhân");
        tableModel.addColumn("Giới Tính");
        tableModel.addColumn("Quê Quán");
        tableModel.addColumn("Ngày Sinh");
        tableModel.addColumn("Mã Bác Sĩ");
        tableModel.addColumn("Tên Bác Sĩ");
        tableModel.addColumn("Kết Quả Khám Bệnh");
        tableModel.addColumn("Ngày Khám Bệnh");

        String sql = "SELECT ketquakhambenh.*, vekham.mave, benhnhan.hoten AS tenbenhnhan, benhnhan.gioitinh, benhnhan.diachi, benhnhan.ngaysinh, bacsi.hoten AS tenbacsi FROM ketquakhambenh INNER JOIN vekham ON vekham.mave = ketquakhambenh.mave INNER JOIN benhnhan ON benhnhan.MDD = vekham.MDD INNER JOIN bacsi ON bacsi.mabacsi = ketquakhambenh.mabacsi";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Vector<String> row = new Vector<>();
            row.add(rs.getString("maketquakhambenh"));
            row.add(rs.getString("mave"));
            row.add(rs.getString("tenbenhnhan"));
            row.add(rs.getString("gioitinh"));
            row.add(rs.getString("diachi"));
            row.add(rs.getString("ngaysinh"));
            row.add(rs.getString("mabacsi"));
            row.add(rs.getString("tenbacsi"));
            row.add(rs.getString("ketquakhambenh"));
            row.add(rs.getString("ngaykham"));

            tableModel.addRow(row);
        }

        tbkqkb.setModel(tableModel);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mvk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkqkb = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        kqkb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mbs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/qlynv.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("QUẢN LÝ KẾT QUẢ KHÁM BỆNH CỦA BỆNH NHÂN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MaVeKham", "MaBacSi", "NgayKhamBenh" }));

        jToolBar4.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar4.setRollover(true);

        jButton23.setBackground(new java.awt.Color(255, 153, 204));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N
        jButton23.setText("Tìm Kiếm");
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton23);

        jButton24.setBackground(new java.awt.Color(102, 255, 51));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton24.setText("   Sửa   ");
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton24);

        jButton25.setBackground(new java.awt.Color(255, 51, 51));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        jButton25.setText("   Thêm   ");
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton25);

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-2019-25.png"))); // NOI18N
        jButton1.setText("Xuất Excel");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton1);

        jButton26.setBackground(new java.awt.Color(204, 255, 102));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        jButton26.setText("    Xóa    ");
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton26);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_test_account_25px.png"))); // NOI18N
        jButton4.setText("Đăng Xuất");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton4);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã Vé Khám");

        tbkqkb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbkqkb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkqkbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkqkb);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Kết Quả Khám Bệnh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã Bác Sĩ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Ngày Khám Bệnh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mvk, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(mbs))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(kqkb, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mvk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kqkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(mbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Kết Quả");
            tableModel.addColumn("Mã Vé Khám");
            tableModel.addColumn("Họ Tên Bệnh Nhân");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("Ngày Sinh");
            tableModel.addColumn("Mã Bác Sĩ");
            tableModel.addColumn("Tên Bác Sĩ");
            tableModel.addColumn("Kết Quả Khám Bệnh");
            tableModel.addColumn("Ngày Khám Bệnh");

            String dkien = cbtk.getSelectedItem().toString();
            String mv = tk.getText();
            String mbs = tk.getText();
            String kqkb = tk.getText();
            String nk = tk.getText();

            if (dkien.equals("ALL")) {
                loadketquakb();

            }
            if (dkien.equals("MaBacSi")) {
                String sql = "SELECT ketquakhambenh.*, vekham.mave, benhnhan.hoten AS tenbenhnhan, benhnhan.gioitinh, benhnhan.diachi, benhnhan.ngaysinh, bacsi.hoten AS tenbacsi FROM ketquakhambenh INNER JOIN vekham ON vekham.mave = ketquakhambenh.mave INNER JOIN benhnhan ON benhnhan.MDD = vekham.MDD INNER JOIN bacsi ON bacsi.mabacsi = ketquakhambenh.mabacsi where ketquakhambenh.mabacsi='" + mbs + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("maketquakhambenh"));
                    row.add(rs.getString("mave"));
                    row.add(rs.getString("tenbenhnhan"));
                    row.add(rs.getString("gioitinh"));
                    row.add(rs.getString("diachi"));
                    row.add(rs.getString("ngaysinh"));
                    row.add(rs.getString("mabacsi"));
                    row.add(rs.getString("tenbacsi"));
                    row.add(rs.getString("ketquakhambenh"));
                    row.add(rs.getString("ngaykham"));

                    tableModel.addRow(row);
                }

                tbkqkb.setModel(tableModel);

            }
            if (dkien.equals("MaVeKham")) {
                String sql = "SELECT ketquakhambenh.*, vekham.mave, benhnhan.hoten AS tenbenhnhan, benhnhan.gioitinh, benhnhan.diachi, benhnhan.ngaysinh, bacsi.hoten AS tenbacsi FROM ketquakhambenh INNER JOIN vekham ON vekham.mave = ketquakhambenh.mave INNER JOIN benhnhan ON benhnhan.MDD = vekham.MDD INNER JOIN bacsi ON bacsi.mabacsi = ketquakhambenh.mabacsi where ketquakhambenh.mave='" + mv + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("maketquakhambenh"));
                    row.add(rs.getString("mave"));
                    row.add(rs.getString("tenbenhnhan"));
                    row.add(rs.getString("gioitinh"));
                    row.add(rs.getString("diachi"));
                    row.add(rs.getString("ngaysinh"));
                    row.add(rs.getString("mabacsi"));
                    row.add(rs.getString("tenbacsi"));
                    row.add(rs.getString("ketquakhambenh"));
                    row.add(rs.getString("ngaykham"));

                    tableModel.addRow(row);
                }

                tbkqkb.setModel(tableModel);

            }
   
            if (dkien.equals("NgayKhamBenh")) {
                String sql = "SELECT ketquakhambenh.*, vekham.mave, benhnhan.hoten AS tenbenhnhan, benhnhan.gioitinh, benhnhan.diachi, benhnhan.ngaysinh, bacsi.hoten AS tenbacsi FROM ketquakhambenh INNER JOIN vekham ON vekham.mave = ketquakhambenh.mave INNER JOIN benhnhan ON benhnhan.MDD = vekham.MDD INNER JOIN bacsi ON bacsi.mabacsi = ketquakhambenh.mabacsi where ketquakhambenh.ngaykham like'" + nk + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(rs.getString("maketquakhambenh"));
                    row.add(rs.getString("mave"));
                    row.add(rs.getString("tenbenhnhan"));
                    row.add(rs.getString("gioitinh"));
                    row.add(rs.getString("diachi"));
                    row.add(rs.getString("ngaysinh"));
                    row.add(rs.getString("mabacsi"));
                    row.add(rs.getString("tenbacsi"));
                    row.add(rs.getString("ketquakhambenh"));
                    row.add(rs.getString("ngaykham"));

                    tableModel.addRow(row);
                }

                tbkqkb.setModel(tableModel);

            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs;user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement ps = conn.prepareStatement("UPDATE ketquakhambenh SET mabacsi=?, ketquakhambenh=?, ngaykham=? WHERE mave=? ");

            ps.setString(1, mbs.getText());
            ps.setString(2, kqkb.getText());

            java.util.Date date = nkb.getDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(3, sqlDate);
            ps.setString(4,mvk.getText());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Xử lý thành công
            } else {
                JOptionPane.showMessageDialog(this, "Không thể cập nhật dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

            loadketquakb();
                JOptionPane.showMessageDialog(this, "Sửa Thành Công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs;user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ketquakhambenh VALUES (?, ?, ?, ?)");

            ps.setString(1, mbs.getText());
            ps.setString(2, mvk.getText());
            ps.setString(3, kqkb.getText());

            java.util.Date date = nkb.getDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(4, sqlDate);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                //        JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không thể thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

            loadketquakb();
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu Thành Công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbkqkb.getModel();
        int columnCount = tableModel.getColumnCount();
        int rowCount = tableModel.getRowCount();

        // Tạo workbook mới
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Dữ liệu");

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < columnCount; col++) {
            String columnName = tableModel.getColumnName(col);
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(columnName);
        }

        // Sao chép dữ liệu từ bảng vào workbook
        for (int row = 0; row < rowCount; row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < columnCount; col++) {
                Object cellValue = tableModel.getValueAt(row, col);
                Cell cell = dataRow.createCell(col);
                if (cellValue != null) {
                    cell.setCellValue(cellValue.toString());
                }
            }
        }
        File directory = new File("FileExcelXuat");
        directory.mkdirs();
        // Lưu workbook vào tệp tin
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/ketquakhambenh.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs;user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ketquakhambenh WHERE mave=?");

            ps.setString(1, mvk.getText());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Xử lý thành công
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

            loadketquakb();
            JOptionPane.showMessageDialog(this, "Xóa dữ liệu Thành Công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login a = new login();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbkqkbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkqkbMouseClicked
        int row = tbkqkb.getSelectedRow();
        mbs.setText(tbkqkb.getValueAt(row, 6).toString());
        mvk.setText(tbkqkb.getValueAt(row, 1).toString());
        kqkb.setText(tbkqkb.getValueAt(row, 8).toString());

        String dateString = tbkqkb.getValueAt(row, 9).toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(dateString);
            nkb.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbkqkbMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ketquakhambenh1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ketquakhambenh1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ketquakhambenh1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ketquakhambenh1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ketquakhambenh1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField kqkb;
    private javax.swing.JTextField mbs;
    private javax.swing.JTextField mvk;
    private javax.swing.JTable tbkqkb;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
