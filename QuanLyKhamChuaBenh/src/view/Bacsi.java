/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.chuyennganh_md;
import model.phongkhambenh_md;
import model.bacsi_md;
import ctl.bacsi_ctl;
import ctl.capbac_ctl;
import ctl.chuyennganh_ctl;
import ctl.phongkhambenh_ctl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import model.capbac_md;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Bacsi extends javax.swing.JFrame {

    private bacsi_ctl bacsi_ctl;
    private chuyennganh_ctl chuyennganh_ctl;
    private phongkhambenh_ctl phongkhambenh_ctl;
private capbac_ctl capbac_ctl;
    public Bacsi() {
        initComponents();
        bacsi_ctl = new bacsi_ctl();
        chuyennganh_ctl = new chuyennganh_ctl();
        phongkhambenh_ctl = new phongkhambenh_ctl();
        capbac_ctl=new capbac_ctl();
        addmaphongkhambenh();
        addmacapbac();
        addmachuyennganh();
        loadbacsi();
    }
public void loadbacsi() {
        try {
            List<bacsi_md> listkhoa = bacsi_ctl.loadbacsi();
            DefaultTableModel tb = new DefaultTableModel();

            tb.addColumn("Mã Bác sĩ");

            tb.addColumn("Tên Phòng Khám Bệnh");
            tb.addColumn("Tên Chuyên Ngành");
             tb.addColumn("Tên cấp bậc");
            tb.addColumn("Họ Tên Bác Sĩ");
            tb.addColumn("SĐT");

            tb.addColumn("Địa Chỉ");
          
            for (bacsi_md hd : listkhoa) {
                phongkhambenh_md a = hd.getPhongkhambenh();
                chuyennganh_md b = hd.getChuyennganh();
                capbac_md c=hd.getCapbac();
                tb.addRow(new Object[]{
                    hd.getMabacsi(),
                    (a != null) ? a.getTenphongkhambenh() : "",
                    (b != null) ? b.getTenchuyennganh() : "",
                       (c!= null) ? c.getTencapbac() : "",
                    hd.getHoten(),
                    hd.getSdt(),
                    hd.getDiachi(),
                  

                });
            }
            tbbs.setModel(tb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  

    private void addmaphongkhambenh() {
        try {
            List<phongkhambenh_md> listkhoa = phongkhambenh_ctl.addmaphongkhambenh();
            DefaultTableModel tb = new DefaultTableModel();
            for (phongkhambenh_md a : listkhoa) {
                mpkb.addItem(a.getMaphongkhambenh());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  private void addmacapbac() {
        try {
            List<capbac_md> listkhoa = capbac_ctl.addmacapbac();
            DefaultTableModel tb = new DefaultTableModel();
            for (capbac_md a : listkhoa) {
                mcb.addItem(a.getMacapbac());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void addmachuyennganh() {
        try {
            List<chuyennganh_md> listkhoa = chuyennganh_ctl.addmachuyennganh();
            DefaultTableModel tb = new DefaultTableModel();
            for (chuyennganh_md a : listkhoa) {
                mcn.addItem(a.getMachuyennganh());
            }
        } catch (Exception ex) {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mbs = new javax.swing.JTextField();
        mpkb = new javax.swing.JComboBox();
        mcn = new javax.swing.JComboBox();
        ht = new javax.swing.JTextField();
        sdt = new javax.swing.JTextField();
        dc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbs = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        mcb = new javax.swing.JComboBox();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/qlynv.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 0, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("QUẢN LÝ BÁC SĨ TRONG PHÒNG KHÁM BỆNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(377, 377, 377)
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

        cbtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "MaPhongKhamBenh", "MaBacSi", "MaChuyenNganh", "HoTen" }));

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
        jLabel3.setText("Mã Bác Sĩ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã Phòng Khám Bệnh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã Chuyên Ngành");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Họ Và Tên");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Số Điện Thoại");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Địa Chỉ");

        tbbs.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbs);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Mã Cấp Bậc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mcn, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mpkb, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mbs, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(65, 65, 65))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(41, 41, 41)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc)
                    .addComponent(sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(ht))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(mbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mpkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(mcn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(mcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        try {
            String dkien = cbtk.getSelectedItem().toString();
            String mbs = tk.getText();
            String tbs = tk.getText();
            String tcn = tk.getText();
            String tpkb = tk.getText();
            String tentg = tk.getText();

            if (dkien.equals("ALL")) {
                List<bacsi_md> listkhoa = bacsi_ctl.loadbacsi();
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Bác sĩ");

                tb.addColumn("Tên Phòng Khám Bệnh");
                tb.addColumn("Tên Chuyên Ngành");
                tb.addColumn("Họ Tên Bác Sĩ");
                tb.addColumn("SĐT");

                tb.addColumn("Địa Chỉ");
            
                for (bacsi_md hd : listkhoa) {
                    phongkhambenh_md a = hd.getPhongkhambenh();
                    chuyennganh_md b = hd.getChuyennganh();
                    tb.addRow(new Object[]{
                        hd.getMabacsi(),
                        (a != null) ? a.getTenphongkhambenh() : "",
                        (b != null) ? b.getTenchuyennganh() : "",
                        hd.getHoten(),
                        hd.getSdt(),
                        hd.getDiachi()
                     

                    });
                }
                tbbs.setModel(tb);
            }
            if (dkien.equals("MaBacSi")) {
                List<bacsi_md> listkhoa = bacsi_ctl.timkiemmabacsi(mbs);

                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Bác sĩ");

                tb.addColumn("Tên Phòng Khám Bệnh");
                tb.addColumn("Tên Chuyên Ngành");
                tb.addColumn("Họ Tên Bác Sĩ");
                tb.addColumn("SĐT");

                tb.addColumn("Địa Chỉ");
              
                for (bacsi_md hd : listkhoa) {
                    phongkhambenh_md a = hd.getPhongkhambenh();
                    chuyennganh_md b = hd.getChuyennganh();
                    tb.addRow(new Object[]{
                        hd.getMabacsi(),
                        (a != null) ? a.getTenphongkhambenh() : "",
                        (b != null) ? b.getTenchuyennganh() : "",
                        hd.getHoten(),
                        hd.getSdt(),
                        hd.getDiachi()
                    
                    });
                }
                tbbs.setModel(tb);
            }
            if (dkien.equals("TenBacSi")) {
                List<bacsi_md> listkhoa = bacsi_ctl.timkiemtenbacsi(tbs);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Bác sĩ");

                tb.addColumn("Tên Phòng Khám Bệnh");
                tb.addColumn("Tên Chuyên Ngành");
                tb.addColumn("Họ Tên Bác Sĩ");
                tb.addColumn("SĐT");

                tb.addColumn("Địa Chỉ");
             
                for (bacsi_md hd : listkhoa) {
                    phongkhambenh_md a = hd.getPhongkhambenh();
                    chuyennganh_md b = hd.getChuyennganh();
                    tb.addRow(new Object[]{
                        hd.getMabacsi(),
                        (a != null) ? a.getTenphongkhambenh() : "",
                        (b != null) ? b.getTenchuyennganh() : "",
                        hd.getHoten(),
                        hd.getSdt(),
                        hd.getDiachi()
                      

                    });
                }
                tbbs.setModel(tb);
            }
            if (dkien.equals("TenChuyenNganh")) {
                List<bacsi_md> listkhoa = bacsi_ctl.timkiemtenchuyennganh(tcn);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Bác sĩ");

                tb.addColumn("Tên Phòng Khám Bệnh");
                tb.addColumn("Tên Chuyên Ngành");
                tb.addColumn("Họ Tên Bác Sĩ");
                tb.addColumn("SĐT");

                tb.addColumn("Địa Chỉ");
              
                for (bacsi_md hd : listkhoa) {
                    phongkhambenh_md a = hd.getPhongkhambenh();
                    chuyennganh_md b = hd.getChuyennganh();
                    tb.addRow(new Object[]{
                        hd.getMabacsi(),
                        (a != null) ? a.getTenphongkhambenh() : "",
                        (b != null) ? b.getTenchuyennganh() : "",
                        hd.getHoten(),
                        hd.getSdt(),
                        hd.getDiachi()
                     

                    });
                }
                tbbs.setModel(tb);
            }
            if (dkien.equals("TenPhongKhamBenh")) {
                List<bacsi_md> listkhoa = bacsi_ctl.timkiemtenphongkhambenh(tpkb);
                DefaultTableModel tb = new DefaultTableModel();

                tb.addColumn("Mã Bác sĩ");

                tb.addColumn("Tên Phòng Khám Bệnh");
                tb.addColumn("Tên Chuyên Ngành");
                tb.addColumn("Họ Tên Bác Sĩ");
                tb.addColumn("SĐT");

                tb.addColumn("Địa Chỉ");
            
                for (bacsi_md hd : listkhoa) {
                    phongkhambenh_md a = hd.getPhongkhambenh();
                    chuyennganh_md b = hd.getChuyennganh();
                    tb.addRow(new Object[]{
                        hd.getMabacsi(),
                        (a != null) ? a.getTenphongkhambenh() : "",
                        (b != null) ? b.getTenchuyennganh() : "",
                        hd.getHoten(),
                        hd.getSdt(),
                        hd.getDiachi()
                     

                    });
                }
                tbbs.setModel(tb);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String mas = mbs.getText();
        String matl = mpkb.getSelectedItem().toString();
        String manxb = mcn.getSelectedItem().toString();
        String hot = ht.getText();
        String sodt = sdt.getText();
        String diac = dc.getText();
       
  String macb= mcb.getSelectedItem().toString();
        bacsi_md hd = new bacsi_md(mas, matl, manxb, hot, sodt, diac,macb);
        if (bacsi_ctl.suabacsi(hd)) {
            loadbacsi();
    JOptionPane.showMessageDialog(this, "Sửa Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi sửa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String mas = mbs.getText();
        String matl = mpkb.getSelectedItem().toString();
        String manxb = mcn.getSelectedItem().toString();
        String hot = ht.getText();
        String sodt = sdt.getText();
        String diac = dc.getText();
       
String macb= mcb.getSelectedItem().toString();
        bacsi_md hd = new bacsi_md(mas, matl, manxb, hot, sodt, diac,macb);
        if (bacsi_ctl.thembacsi(hd)) {
            loadbacsi();
JOptionPane.showMessageDialog(this, "Thêm dữ liệu Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String mas = mbs.getText();
        String matl = mpkb.getSelectedItem().toString();
        String manxb = mcn.getSelectedItem().toString();
        String hot = ht.getText();
        String sodt = sdt.getText();
        String diac = dc.getText();
       
String macb= mcb.getSelectedItem().toString();
        bacsi_md hd = new bacsi_md(mas, matl, manxb, hot, sodt, diac,macb);
        if (bacsi_ctl.xoabacsi(hd)) {
            loadbacsi();
JOptionPane.showMessageDialog(this, "Xóa dữ liệu Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login a = new login();
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbbsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbsMouseClicked
        bacsi_ctl.click(tbbs, mbs, mpkb,mcb, mcn, ht, sdt, dc);
    }//GEN-LAST:event_tbbsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbbs.getModel();
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
        try (FileOutputStream fos = new FileOutputStream("FileExcelXuat/bacsi.xlsx")) {
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
            java.util.logging.Logger.getLogger(Bacsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bacsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bacsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bacsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bacsi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbtk;
    private javax.swing.JTextField dc;
    private javax.swing.JTextField ht;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField mbs;
    private javax.swing.JComboBox mcb;
    private javax.swing.JComboBox mcn;
    private javax.swing.JComboBox mpkb;
    private javax.swing.JTextField sdt;
    private javax.swing.JTable tbbs;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
