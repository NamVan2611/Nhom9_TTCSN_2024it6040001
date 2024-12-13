/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.phongkhambenh_md;
import model.nhanvien_md;
import model.truso_md;
import ctl.nhanvien_ctl;
import ctl.phongkham_ctl;
import ctl.phongkhambenh_ctl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.phongkham_md;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ctl.truso_ctl;

public class vekham extends javax.swing.JFrame {

    private nhanvien_ctl nhanvien_ctl;
    private phongkhambenh_ctl phongkhambenh_ctl;
    private truso_ctl truso_ctl;

    public vekham() {
        initComponents();
        nhanvien_ctl = new nhanvien_ctl();
        phongkhambenh_ctl = new phongkhambenh_ctl();
        truso_ctl = new truso_ctl();
        addmaphongkhambenh();
        addmanhanvien();
        addmatruso();
        loadvekham();

    }

    private void addmanhanvien() {
        try {
            List<nhanvien_md> listkhoa = nhanvien_ctl.addmanhanvien();
            DefaultTableModel tb = new DefaultTableModel();
            for (nhanvien_md a : listkhoa) {
                mnv.addItem(a.getManv());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addmatruso() {
        try {
            List<truso_md> listkhoa = truso_ctl.addmatruso();
            DefaultTableModel tb = new DefaultTableModel();
            for (truso_md a : listkhoa) {
                mts.addItem(a.getMatruso());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addmaphongkhambenh() {
        try {
            List<phongkhambenh_md> listkhoa = phongkhambenh_ctl.addmaphongkhambenh();
            DefaultTableModel tb = new DefaultTableModel();
            for (phongkhambenh_md a : listkhoa) {
                mpk.addItem(a.getMaphongkhambenh());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadvekham() {
        String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dbURL);

            Statement st = conn.createStatement();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Vé");
            tableModel.addColumn("Mã Định Danh");
            tableModel.addColumn("Tên Bệnh Nhân");
            tableModel.addColumn("Tên Phòng Khám Bệnh");
            tableModel.addColumn("Số Thứ Tự Xếp Hàng");
            tableModel.addColumn("Mã Nhân Viên ");
            tableModel.addColumn("Vấn Đề Sức Khỏe");
            tableModel.addColumn("Vấn Đề BHYT");
            tableModel.addColumn("Tên Trụ Sở");
            String sql = "Select * from vekham inner join phongkhambenh on phongkhambenh.maphongkhambenh=vekham.maphong inner join nhanvien on nhanvien.manv=vekham.manhanvien inner join benhnhan on benhnhan.MDD=vekham.MDD inner join truso on truso.matruso=vekham.matruso";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getString("sothutuxephang"));
                vt.add(rs.getString("manhanvien"));
                vt.add(rs.getString("vandesuckhoe"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("tentruso"));
                tableModel.addRow(vt);
            }
            tbvk.setModel(tableModel);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbvk = new javax.swing.JTable();
        mdd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mtsk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mnv = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        sttxh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mpk = new javax.swing.JComboBox();
        bhyt = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        mts = new javax.swing.JComboBox();
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

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("QUẢN LÝ VÉ KHÁM CỦA BỆNH NHÂN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(394, 394, 394))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MaVe", "MDD", "MaPhongKham", "TenPhongKham" }));

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
        jLabel3.setText("Mã Vé");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã định danh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Vấn Đề BHYT");

        tbvk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbvk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbvkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbvk);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mô Tả Sức Khỏe");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã Nhân Viên");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("STT Xếp Hàng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Mã Phòng Khám");

        bhyt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Còn Hạn", "Hết Hạn", "Không Mang Theo" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Mã trụ sở");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addComponent(mv, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mdd, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mnv, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(mtsk, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sttxh, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpk, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhyt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mts, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bhyt))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sttxh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpk)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mts)
                    .addComponent(jLabel10)
                    .addComponent(mtsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/qlynv.png"))); // NOI18N

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
            .addGroup(layout.createSequentialGroup()
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
            
            DefaultTableModel tableModel = new DefaultTableModel();
              tableModel.addColumn("Mã Vé");
            tableModel.addColumn("Mã Định Danh");
            tableModel.addColumn("Tên Bệnh Nhân");
            tableModel.addColumn("Tên Phòng Khám Bệnh");
            tableModel.addColumn("Số Thứ Tự Xếp Hàng");
            tableModel.addColumn("Mã Nhân Viên ");
            tableModel.addColumn("Vấn Đề Sức Khỏe");
            tableModel.addColumn("Vấn Đề BHYT");
            tableModel.addColumn("Tên Trụ Sở");
            
            String dkien = cbtk.getSelectedItem().toString();
            String mv = tk.getText();
            String mdd = tk.getText();
            String mpkb = tk.getText();
           

            if (dkien.equals("ALL")) {
                loadvekham();

            }
 if (dkien.equals("MaVe")) {
            String sql = "Select * from vekham inner join phongkhambenh on phongkhambenh.maphongkhambenh=vekham.maphong inner join nhanvien on nhanvien.manv=vekham.manhanvien inner join benhnhan on benhnhan.MDD=vekham.MDD inner join truso on truso.matruso=vekham.matruso where vekham.mave='"+mv+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getString("sothutuxephang"));
                vt.add(rs.getString("manhanvien"));
                vt.add(rs.getString("vandesuckhoe"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("tentruso"));
                tableModel.addRow(vt);
            }
            tbvk.setModel(tableModel);
        }
  if (dkien.equals("MDD")) {
            String sql = "Select * from vekham inner join phongkhambenh on phongkhambenh.maphongkhambenh=vekham.maphong inner join nhanvien on nhanvien.manv=vekham.manhanvien inner join benhnhan on benhnhan.MDD=vekham.MDD inner join truso on truso.matruso=vekham.matruso where vekham.MDD='"+mdd+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getString("sothutuxephang"));
                vt.add(rs.getString("manhanvien"));
                vt.add(rs.getString("vandesuckhoe"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("tentruso"));
                tableModel.addRow(vt);
            }
            tbvk.setModel(tableModel);
        }
   if (dkien.equals("MaPhongKham")) {
            String sql = "Select * from vekham inner join phongkhambenh on phongkhambenh.maphongkhambenh=vekham.maphong inner join nhanvien on nhanvien.manv=vekham.manhanvien inner join benhnhan on benhnhan.MDD=vekham.MDD inner join truso on truso.matruso=vekham.matruso where vekham.maphong like'"+mpkb+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getString("sothutuxephang"));
                vt.add(rs.getString("manhanvien"));
                vt.add(rs.getString("vandesuckhoe"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("tentruso"));
                tableModel.addRow(vt);
            }
            tbvk.setModel(tableModel);
        }
   if (dkien.equals("TenPhongKham")) {
            String sql = "Select * from vekham inner join phongkhambenh on phongkhambenh.maphongkhambenh=vekham.maphong inner join nhanvien on nhanvien.manv=vekham.manhanvien inner join benhnhan on benhnhan.MDD=vekham.MDD inner join truso on truso.matruso=vekham.matruso where phongkhambenh.tenphongkhambenh like N'"+mv+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector vt = new Vector();
                vt.add(rs.getString("mave"));
                vt.add(rs.getString("MDD"));
                vt.add(rs.getString("hoten"));
                vt.add(rs.getString("tenphongkhambenh"));
                vt.add(rs.getString("sothutuxephang"));
                vt.add(rs.getString("manhanvien"));
                vt.add(rs.getString("vandesuckhoe"));
                vt.add(rs.getString("vandeBHYT"));
                vt.add(rs.getString("tentruso"));
                tableModel.addRow(vt);
            }
            tbvk.setModel(tableModel);
        }
        }
        catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "update vekham set MDD='" + mdd.getText() + "',maphong='" + mpk.getSelectedItem().toString() + "',sothutuxephang='" + sttxh.getText() + "',manhanvien='" + mnv.getSelectedItem().toString() + "',vandesuckhoe=N'" + mtsk.getText() + "',vandeBHYT=N'" + bhyt.getSelectedItem().toString() + "',matruso='" + mts.getSelectedItem().toString() + "' where mave='" + mv.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadvekham();
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "insert into vekham values('" + mv.getText() + "','" + mdd.getText() + "','" + mpk.getSelectedItem().toString() + "','" + sttxh.getText() + "','" + mnv.getSelectedItem().toString() + "',N'" + mtsk.getText() + "',N'" + bhyt.getSelectedItem().toString() + "','" + mts.getSelectedItem().toString() + "')";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadvekham();
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu Thành Công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
            String dbURL = "jdbc:sqlserver://127.0.0.1;databaseName=khambenhcs; user=vuthibac1106;password=111";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement st = conn.createStatement();

            String sql = "delete from vekham where mave='" + mv.getText() + "'";
// TODO add your handling code here:
            int a = st.executeUpdate(sql);
            loadvekham();
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

    private void tbvkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbvkMouseClicked
        int row = tbvk.getSelectedRow();
        mv.setText(tbvk.getValueAt(row, 0).toString());
        mdd.setText(tbvk.getValueAt(row, 1).toString());
        mpk.setSelectedItem(tbvk.getValueAt(row, 3).toString());
        sttxh.setText(tbvk.getValueAt(row, 4).toString());

        mnv.setSelectedItem(tbvk.getValueAt(row, 5).toString());
        mtsk.setText(tbvk.getValueAt(row, 6).toString());
        bhyt.setSelectedItem(tbvk.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tbvkMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbvk.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/vekham.xlsx")) {
            workbook.write(fos);
            System.out.println("Xuất dữ liệu thành công!");
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Bacsi a = new Bacsi();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        nhanvienphongkham a = new nhanvienphongkham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        capbac a = new capbac();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        chuyennganh a = new chuyennganh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        phongkhambenh a = new phongkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        dichvukham a = new dichvukham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        trangchu a = new trangchu();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ketquakhambenh a = new ketquakhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        hoadonkhambenh a = new hoadonkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        chitiethoadonkhambenh a = new chitiethoadonkhambenh();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ThongKe a = new ThongKe();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        vekham a = new vekham();
        a.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(vekham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vekham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vekham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vekham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vekham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bhyt;
    private javax.swing.JComboBox cbtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField mdd;
    private javax.swing.JComboBox mnv;
    private javax.swing.JComboBox mpk;
    private javax.swing.JComboBox mts;
    private javax.swing.JTextField mtsk;
    private javax.swing.JTextField mv;
    private javax.swing.JTextField sttxh;
    private javax.swing.JTable tbvk;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
