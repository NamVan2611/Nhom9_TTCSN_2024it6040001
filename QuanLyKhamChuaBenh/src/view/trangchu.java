/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class trangchu extends javax.swing.JFrame {


    public trangchu() {
        initComponents();
        loadhoadonkhambenh();
    }

  private void loadhoadonkhambenh() {

        String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("Mã Hóa Đơn");
            tb.addColumn("Mã Vé Khám");
            tb.addColumn("Mã Định Danh ");
            tb.addColumn("Tên Bệnh Nhân");
            tb.addColumn("vấn đề BHYT");
            tb.addColumn("Mã Dịch Vũ");
            tb.addColumn("Tên Dịch Vụ");
            tb.addColumn("Tên Phòng Khám Bệnh");
            tb.addColumn("Đơn Giá/1 Dv");
            tb.addColumn("Số Lượng DV");
            tb.addColumn("Ngày Khám");
            tb.addColumn("Mã NV Lập HD");
            tb.addColumn("Tên NV");
            tb.addColumn("Tổng tiền DV");
            tb.addColumn("Phí hỗ trợ BHYT");
            tb.addColumn("Tổng tiền Thanh Toán");
            String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh order by hoadonkhambenh.mahoadon ASC ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            }
            tbhdkb.setModel(tb);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhdkb = new javax.swing.JTable();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbtk = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        tbhdkb.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbhdkb);

        jToolBar4.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar4.setFloatable(false);
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

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MaHoaDon", "MDD", "TenPhongKhamBenh", "MaNhanVien", "MaDichVu", "NgayKham", "MaVe" }));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel2.setText("TRANG CHỦ HỆ THỐNG KHÁM BỆNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(588, 588, 588)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/trangbia.png"))); // NOI18N

        jMenu3.setText("QUản Lí Thông Tin Thành Viên");

        jMenuItem3.setText("Quản Lí bác Sĩ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Quản Lí Nhân Viên");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Quản Lí Cấp Bậc");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Quản Lí Chuyên Ngành");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Quản Lí Thông Tin Phòng Ban");

        jMenuItem5.setText("Quản Lí Phòng Khám Bệnh");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem8.setText("Quản Lí Dịch Vụ Khám");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Quản Lí Khám Bệnh");

        jMenuItem12.setText("Trang Chủ");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem1.setText("Quản Lí Vé Khám Bệnh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Quản Lí Kết Quả Khám Bệnh");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem9.setText("Quản Lí Hóa Đơn Khám Bệnh");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Quản Lí Chi Tiết Hóa Đơn Khám Bệnh");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Thống Kê");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
 String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tb = new DefaultTableModel();
             tb.addColumn("Mã Hóa Đơn");
            tb.addColumn("Mã Vé Khám");
            tb.addColumn("Mã Định Danh ");
            tb.addColumn("Tên Bệnh Nhân");
            tb.addColumn("vấn đề BHYT");
            tb.addColumn("Mã Dịch Vũ");
            tb.addColumn("Tên Dịch Vụ");
            tb.addColumn("Tên Phòng Khám Bệnh");
            tb.addColumn("Đơn Giá/1 Dv");
            tb.addColumn("Số Lượng DV");
            tb.addColumn("Ngày Khám");
            tb.addColumn("Mã NV Lập HD");
            tb.addColumn("Tên NV");
            tb.addColumn("Tổng tiền DV");
            tb.addColumn("Phí hỗ trợ BHYT");
            tb.addColumn("Tổng tiền Thanh Toán");

            String dkien = cbtk.getSelectedItem().toString();
            String mhd = tk.getText();
            String mv = tk.getText();
            String mdd = tk.getText();
            String nk = tk.getText();
            String mnv = tk.getText();
            String tpkb = tk.getText();
                String mdv1 = tk.getText();
            if (dkien.equals("ALL")) {
                loadhoadonkhambenh();

            }
            if (dkien.equals("MaHoaDon")) {
                String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where hoadonkhambenh.mahoadon='" + mhd + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                }
                tbhdkb.setModel(tb);

            }
            if (dkien.equals("MDD")) {
               String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where benhnhan.MDD='" + mdd + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
            if (dkien.equals("NgayKham")) {
            String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where ketquakhambenh.ngaykham='" + nk+ "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
            if (dkien.equals("MaNhanVien")) {
              String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where nhanvien.manv='" + mnv + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
            if (dkien.equals("MaDichVu")) {
              String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where dichvukham.madv='" + mdv1 + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
            if (dkien.equals("TenPhongKhamBenh")) {
                 String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where phongkhambenh.tenphongkhambenh like N'" + mdv1 + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
            if (dkien.equals("MaVe")) {
                 String sql = "SELECT hoadonkhambenh.mahoadon,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh where vekham.mave='" + mv + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                     Vector vt = new Vector();
                float dongia = rs.getFloat("dongia");
                int soluongdv = rs.getInt("soluongdv");
                float tongtienDV = dongia * soluongdv;
                float phiBHYT = 0.0f;

                String vandeBHYT = rs.getString("vandeBHYT");
                if (vandeBHYT.equals("Còn Hạn")) {
                    phiBHYT = 0.8f * tongtienDV;
                }
                float tongtienThanhToan = tongtienDV - phiBHYT;
                vt.add(rs.getString("mahoadon"));
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("madv"));
                vt.add(rs.getString("tendv"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getFloat("dongia"));
                vt.add(rs.getInt("soluongdv"));
                vt.add(rs.getString("ngaykham"));
                vt.add(rs.getString("manv"));
                vt.add(rs.getString("tennv"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tbhdkb.setModel(tb);
            }
        } catch (SQLException ex) {

        }
        
               
               
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login a=new login();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbhdkb.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/hoadonkhambenh.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Bacsi a=new Bacsi();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        nhanvienphongkham a=new nhanvienphongkham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        capbac a=new capbac();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        chuyennganh a=new chuyennganh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        phongkhambenh a=new phongkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        dichvukham a=new dichvukham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        trangchu a=new trangchu();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        vekham a=new vekham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ketquakhambenh a=new ketquakhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        hoadonkhambenh a=new hoadonkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        chitiethoadonkhambenh a=new chitiethoadonkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ThongKe a=new ThongKe();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trangchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTable tbhdkb;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
