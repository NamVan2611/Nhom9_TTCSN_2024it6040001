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
public class quatrinhkhambenhtheoBHYT extends javax.swing.JFrame {

    /**
     * Creates new form quatrinhkhambenhtheoBHYT
     */
    public quatrinhkhambenhtheoBHYT() {
        initComponents();
        loadlskhambenh();
    }

    private void loadlskhambenh() {

        String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tb = new DefaultTableModel();
           
            tb.addColumn("Mã Định Danh ");
            tb.addColumn("Số BHYT");
            tb.addColumn("Họ tên");
            tb.addColumn("Giới Tính");
            tb.addColumn("Địa Chỉ");
            tb.addColumn("Ngày Khám");
            tb.addColumn("Tổng tiền DV");
            tb.addColumn("Phí hỗ trợ BHYT");
            tb.addColumn("Tổng tiền Thanh Toán");
             tb.addColumn("Tên Trụ sở");
         String sql = "SELECT hoadonkhambenh.mahoadon,benhnhan.diachi,truso.tentruso,BHYT.SOBHYT,benhnhan.gioitinh,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh inner join truso on truso.matruso=vekham.matruso inner join BHYT on BHYT.MDD=benhnhan.MDD where vekham.vandeBHYT like N'Còn Hạn'";
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
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("SOBHYT"));
         
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("ngaykham"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                   vt.add(rs.getString("tentruso"));
                tb.addRow(vt);
            }
            tblskb.setModel(tb);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblskb = new javax.swing.JTable();
        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/BHYT.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        tblskb.setModel(new javax.swing.table.DefaultTableModel(
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
        tblskb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblskbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblskb);

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MDD", "BHYT", "HoTen", "QueQuan" }));

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

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("QUẢN LÍ THÔNG TIN KHÁM BỆNH SỬ DỤNG BHYT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(284, 284, 284))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu3.setText("Quản Lí BHXH");

        jMenuItem5.setText("Quản Lí BHYT");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Quản Lí Mã Định Danh");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Quản Lí Chung");

        jMenuItem1.setText("Thông Tin Khám Bệnh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Tra Cứu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblskbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblskbMouseClicked
       
    }//GEN-LAST:event_tblskbMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
 String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tb = new DefaultTableModel();
        
            tb.addColumn("Mã Định Danh ");
            tb.addColumn("Số BHYT");
            tb.addColumn("Họ tên");
            tb.addColumn("Giới Tính");
            tb.addColumn("Địa Chỉ");
            tb.addColumn("Ngày Khám");
            tb.addColumn("Tổng tiền DV");
            tb.addColumn("Phí hỗ trợ BHYT");
            tb.addColumn("Tổng tiền Thanh Toán");

            String dkien = cbtk.getSelectedItem().toString();
            String mdd = tk.getText();
            String bhyt= tk.getText();
            String ht = tk.getText();
            String qq= tk.getText();
           
            if (dkien.equals("ALL")) {
                loadlskhambenh();

            }
            
            if (dkien.equals("MDD")) {
                   String sql = "SELECT hoadonkhambenh.mahoadon,benhnhan.diachi,BHYT.SOBHYT,benhnhan.gioitinh,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh inner join BHYT on BHYT.MDD=benhnhan.MDD where vekham.vandeBHYT like N'Còn Hạn' and benhnhan.MDD='"+mdd+"'";

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
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("SOBHYT"));
         
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("ngaykham"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tblskb.setModel(tb);
            }
             if (dkien.equals("BHYT")) {
                 String sql = "SELECT hoadonkhambenh.mahoadon,benhnhan.diachi,BHYT.SOBHYT,benhnhan.gioitinh,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh inner join BHYT on BHYT.MDD=benhnhan.MDD where  vekham.vandeBHYT like N'Còn Hạn' and benhnhan.SOBHYT='"+bhyt+"'";

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
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("SOBHYT"));
         
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("ngaykham"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tblskb.setModel(tb);
             }
             if (dkien.equals("HoTen")) {
                 String sql = "SELECT hoadonkhambenh.mahoadon,benhnhan.diachi,BHYT.SOBHYT,benhnhan.gioitinh,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh inner join BHYT on BHYT.MDD=benhnhan.MDD where vekham.vandeBHYT like N'Còn Hạn' and benhnhan.hoten like N'"+ht+"'";

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
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("SOBHYT"));
         
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("ngaykham"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tblskb.setModel(tb);
             }
             if (dkien.equals("QueQuan")) {
                 String sql = "SELECT hoadonkhambenh.mahoadon,benhnhan.diachi,BHYT.SOBHYT,benhnhan.gioitinh,vekham.mave,dichvukham.dongia,phongkhambenh.tenphongkhambenh,ketquakhambenh.ngaykham,dichvukham.madv,dichvukham.tendv,hoadonkhambenh.soluongdv,benhnhan.hoten,nhanvien.manv,nhanvien.tennv,vekham.vandeBHYT,benhnhan.MDD from hoadonkhambenh inner join vekham on vekham.mave=hoadonkhambenh.mave inner join ketquakhambenh on vekham.mave=ketquakhambenh.mave inner join dichvukham on dichvukham.madv=hoadonkhambenh.madichvu inner join benhnhan on vekham.MDD=benhnhan.MDD inner join nhanvien on nhanvien.manv=hoadonkhambenh.manhanvien inner join phongkhambenh on phongkhambenh.maphongkhambenh=dichvukham.maphongkhambenh inner join BHYT on BHYT.MDD=benhnhan.MDD where vekham.vandeBHYT like N'Còn Hạn' and benhnhan.diachi like N'"+qq+"'";

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
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("SOBHYT"));
         
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("ngaykham"));
                vt.add(tongtienDV);
                vt.add(phiBHYT);
                vt.add(tongtienThanhToan);
                tb.addRow(vt);
            
                   }
                tblskb.setModel(tb);
             }
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login1 a = new login1();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tblskb.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/lichsukhambenhtheoBHYT.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         benhnhan a=new benhnhan();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       BHYT a=new BHYT();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       quatrinhkhambenhtheoBHYT a=new quatrinhkhambenhtheoBHYT();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      tracuuBHXH a=new tracuuBHXH();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(quatrinhkhambenhtheoBHYT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quatrinhkhambenhtheoBHYT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quatrinhkhambenhtheoBHYT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quatrinhkhambenhtheoBHYT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quatrinhkhambenhtheoBHYT().setVisible(true);
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTable tblskb;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
