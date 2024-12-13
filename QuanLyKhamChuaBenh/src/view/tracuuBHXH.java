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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class tracuuBHXH extends javax.swing.JFrame {

    /**
     * Creates new form tracuuBHXH
     */
    public tracuuBHXH() {
        initComponents();
        loadbenhnhan();
    }

    public void loadbenhnhan() {
        String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Định Danh");
            tableModel.addColumn("CCCD");
            tableModel.addColumn("Số BHYT");
            tableModel.addColumn("ngày Có Hiệu Lực");
            tableModel.addColumn("Ngày Hết Hiệu Lực");
            tableModel.addColumn("Đơn vị Cấp");
            tableModel.addColumn("Họ Tên");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("DD/MM/YYYY");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("SĐT");

            String sql = "Select * from benhnhan inner join BHYT on BHYT.MDD=benhnhan.MDD order by benhnhan.MDD ASC";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("CCCD"));
                vt.add(rs.getString("SOBHYT"));
                vt.add(rs.getString("ngaycohieuluc"));
                vt.add(rs.getString("ngayhethieuluc"));
                vt.add(rs.getString("dvcap"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("gioitinh"));
                vt.add(rs.getString("ngaysinh"));
                vt.add(rs.getString("diachi"));
                vt.add(rs.getString("sdt"));

                tableModel.addRow(vt);
            }
            tbbn.setModel(tableModel);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbtk = new javax.swing.JComboBox();
        tk = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jButton23 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbn = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MDD", "MasoBHYT", "HoTen", "QueQuan", "CCCD" }));

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

        tbbn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbn);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("TRA CỨU BHXH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(464, 464, 464)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/BHYT.png"))); // NOI18N

        jMenu1.setText("Quản Lí BHXH");

        jMenuItem2.setText("Quản Lí BHYT");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Quản Lí Mã Định Danh");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        benhnhan a = new benhnhan();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbbn.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/bhyt.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login a = new login();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbbnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbnMouseClicked

    }//GEN-LAST:event_tbbnMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Định Danh");
            tableModel.addColumn("CCCD");
            tableModel.addColumn("Số BHYT");
            tableModel.addColumn("ngày Có Hiệu Lực");
            tableModel.addColumn("Ngày Hết Hiệu Lực");
            tableModel.addColumn("Đơn ị Cấp");
            tableModel.addColumn("Họ Tên");
            tableModel.addColumn("Giới Tính");
            tableModel.addColumn("DD/MM/YYYY");
            tableModel.addColumn("Quê Quán");
            tableModel.addColumn("SĐT");

            String dkien = cbtk.getSelectedItem().toString();
            String mdd = tk.getText();
            String cccd = tk.getText();
            String bhyt = tk.getText();
            String ten = tk.getText();
            String queq = tk.getText();

            if (dkien.equals("ALL")) {
                loadbenhnhan();

            }
            if (dkien.equals("MDD")) {
                String sql = "Select * from benhnhan inner join BHYT on BHYT.MDD=benhnhan.MDD where benhnhan.MDD='" + mdd + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("MDD"));
                    vt.add(rs.getString("CCCD"));
                    vt.add(rs.getString("SOBHYT"));
                    vt.add(rs.getString("ngaycohieuluc"));
                    vt.add(rs.getString("ngayhethieuluc"));
                    vt.add(rs.getString("dvcap"));
                    vt.add(rs.getString("hoten"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("ngaysinh"));
                    vt.add(rs.getString("diachi"));
                    vt.add(rs.getString("sdt"));

                    tableModel.addRow(vt);
                }
                tbbn.setModel(tableModel);
            }

            if (dkien.equals("HoTen")) {
                String sql = "Select * from benhnhan inner join BHYT on BHYT.MDD=benhnhan.MDD where benhnhan.hoten=N'" + ten + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("MDD"));
                    vt.add(rs.getString("CCCD"));
                    vt.add(rs.getString("SOBHYT"));
                    vt.add(rs.getString("ngaycohieuluc"));
                    vt.add(rs.getString("ngayhethieuluc"));
                    vt.add(rs.getString("dvcap"));
                    vt.add(rs.getString("hoten"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("ngaysinh"));
                    vt.add(rs.getString("diachi"));
                    vt.add(rs.getString("sdt"));

                    tableModel.addRow(vt);
                }
                tbbn.setModel(tableModel);
            }
            if (dkien.equals("CCCD")) {
                String sql = "Select * from benhnhan inner join BHYT on BHYT.MDD=benhnhan.MDD where benhnhan.CCCD='" + cccd + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("MDD"));
                    vt.add(rs.getString("CCCD"));
                    vt.add(rs.getString("SOBHYT"));
                    vt.add(rs.getString("ngaycohieuluc"));
                    vt.add(rs.getString("ngayhethieuluc"));
                    vt.add(rs.getString("dvcap"));
                    vt.add(rs.getString("hoten"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("ngaysinh"));
                    vt.add(rs.getString("diachi"));
                    vt.add(rs.getString("sdt"));

                    tableModel.addRow(vt);
                }
                tbbn.setModel(tableModel);

            }
            if (dkien.equals("MasoBHYT")) {
                String sql = "Select * from benhnhan inner join BHYT on BHYT.MDD=benhnhan.MDD where BHYT.SOBHYT='" + bhyt + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("MDD"));
                    vt.add(rs.getString("CCCD"));
                    vt.add(rs.getString("SOBHYT"));
                    vt.add(rs.getString("ngaycohieuluc"));
                    vt.add(rs.getString("ngayhethieuluc"));
                    vt.add(rs.getString("dvcap"));
                    vt.add(rs.getString("hoten"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("ngaysinh"));
                    vt.add(rs.getString("diachi"));
                    vt.add(rs.getString("sdt"));

                    tableModel.addRow(vt);
                }
                tbbn.setModel(tableModel);

            }
            if (dkien.equals("QueQuan")) {
                String sql = "Select * from benhnhan  inner join BHYT on BHYT.MDD=benhnhan.MDD where benhnhan.diachi=N'" + queq + "' ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(rs.getString("MDD"));
                    vt.add(rs.getString("CCCD"));
                    vt.add(rs.getString("SOBHYT"));
                    vt.add(rs.getString("ngaycohieuluc"));
                    vt.add(rs.getString("ngayhethieuluc"));
                    vt.add(rs.getString("dvcap"));
                    vt.add(rs.getString("hoten"));
                    vt.add(rs.getString("gioitinh"));
                    vt.add(rs.getString("ngaysinh"));
                    vt.add(rs.getString("diachi"));
                    vt.add(rs.getString("sdt"));

                    tableModel.addRow(vt);
                }
                tbbn.setModel(tableModel);

            }

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       BHYT a=new BHYT();
       a.show();
       this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(tracuuBHXH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tracuuBHXH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tracuuBHXH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tracuuBHXH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tracuuBHXH().setVisible(true);
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTable tbbn;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
