package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.MaGiamGia;
import service.MaGiamGiaService;

public class itf_KhuyenMai extends javax.swing.JInternalFrame {

    MaGiamGiaService MGG = new MaGiamGiaService();

    public itf_KhuyenMai() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        this.setSize(1300, 755);
        List<MaGiamGia> list = MGG.getListMGG();
        loadData(list);

    }

    void loadData(List<MaGiamGia> list) {
        DefaultTableModel model = (DefaultTableModel) tblKM.getModel();
        model.setRowCount(0);
        for (MaGiamGia MGGS : list) {
            model.addRow(new Object[]{
                MGGS.getIdMaGiamGia(),
                MGGS.getMaGiamGia(),
                MGGS.getSoLuong(),
                MGGS.getMenhGia(),
                MGGS.getNgayBatDau(),
                MGGS.getNgayKetThuc(),
                MGGS.getTrangThai(),
                MGGS.getNgayTao(),
                MGGS.getNgaySua()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgDieuKien = new javax.swing.ButtonGroup();
        btgTrangThai = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cboTrangThaiKM = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMucGiam1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        rdoDangKichHoat = new javax.swing.JRadioButton();
        rdoHetHieuLuc = new javax.swing.JRadioButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSuaEvent = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(940, 657));
        setPreferredSize(new java.awt.Dimension(940, 657));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khuyến Mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Mã Giảm Giá", "Tên Mã Giảm Giá", "Số Lượng", "Mệnh Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái", "Ngày Tạo", "Ngày Sửa"
            }
        ));
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKM);
        if (tblKM.getColumnModel().getColumnCount() > 0) {
            tblKM.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel11.setText("Tìm Kiếm ");

        cboTrangThaiKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt Động", "Không Hoạt Động" }));

        jLabel12.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboTrangThaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTrangThaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tạo mã khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setText("Tên Mã Giảm Giá");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Mệnh Giá");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsoluong)
                            .addComponent(txtMucGiam1))))
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMucGiam1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời gian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel6.setText("Ngày Bắt Đầu:");

        jLabel7.setText("Ngày Kết Thúc :");

        jLabel10.setText("Trạng Thái: ");

        btgTrangThai.add(rdoDangKichHoat);
        rdoDangKichHoat.setSelected(true);
        rdoDangKichHoat.setText("Hoạt Động");

        btgTrangThai.add(rdoHetHieuLuc);
        rdoHetHieuLuc.setText("Không Hoạt Động");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDangKichHoat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(31, 31, 31)
                        .addComponent(rdoHetHieuLuc))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(14, 14, 14)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDangKichHoat)
                    .addComponent(rdoHetHieuLuc))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnDelete.setText("Clear form");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSuaEvent.setText("Sửa");
        btnSuaEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaEventMouseClicked(evt);
            }
        });
        btnSuaEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnSuaEvent)))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSuaEvent)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Chương trình khuyến mại", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaEventActionPerformed

    }//GEN-LAST:event_btnSuaEventActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked

//        int row = tblKM.getSelectedRow();
//        int id = (int) tblKM.getValueAt(row, 1);
//        System.out.println(row);
//        MaGiamGia MGGS = MGG.details(id);
//        txtID.setColumns(MGGS.getIdMaGiamGia());
//        txtMaGiamGia.setText(MGGS.getMaGiamGia());
//        cboSoLuong.setSelectedItem(MGGS.getSoLuong());
//        txtMenhGia.setText(MGGS.getMenhGia());
//
//        
//        txtNgayBatDau.setDate(MGGS.getNgayBatDau());
//        txtNgayKetThuc.setDate(MGGS.getNgayKetThuc());
//        
//        if (MGGS.getTrangThai() == 1) {
//            rdoDangKichHoat.setSelected(true);
//        } else {
//            rdoHetHieuLuc.setSelected(true);
//
//        }
//         
//        txtNgayTao.setDate(MGGS.getNgayTao());
//        txtNgaySua.setDate(MGGS.getNgaySua());
    }//GEN-LAST:event_tblKMMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

        String MaGiamGia = txtMaGiamGia.getText();
        int soLuong = Integer.parseInt(txtsoluong.getText());
        String menhGia = txtMucGiam1.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        try {
            ngayBatDau = format.parse(txtNgayBatDau.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ngayKetThuc = null;
        try {
            ngayKetThuc = format.parse(txtNgayKetThuc.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        int trangThai;
        if (rdoDangKichHoat.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }

        Date ngayTao = null;
        try {
            ngayTao = format.parse(txtNgayTao.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ngaySua = null;
        try {
            ngaySua = format.parse(txtNgaySua.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
        MaGiamGia MGGS = new MaGiamGia(MaGiamGia, soLuong, menhGia, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
        String result = MGG.insertMaGG(MGGS);
        JOptionPane.showMessageDialog(this, result);
        loadData(MGG.getListMGG());
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:

        int row = tblKM.getSelectedRow();
        int id = (int) tblKM.getValueAt(row, 1);
        String ketQua = MGG.deleteMaGG(row);
        JOptionPane.showMessageDialog(this, ketQua);
        loadData(MGG.getListMGG());
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSuaEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaEventMouseClicked

        String MaGiamGia = txtMaGiamGia.getText();
        int soLuong = Integer.parseInt(txtsoluong.getText());
        String menhGia = txtMucGiam1.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        try {
            ngayBatDau = format.parse(txtNgayBatDau.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ngayKetThuc = null;
        try {
            ngayKetThuc = format.parse(txtNgayKetThuc.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        int trangThai;
        if (rdoDangKichHoat.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }

        Date ngayTao = null;//run đi xem nó chạy như nào bồ

        try {
            ngayTao = format.parse(txtNgayTao.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ngaySua = null;
        try {
            ngaySua = format.parse(txtNgaySua.getDateFormatString());
        } catch (ParseException ex) {
            Logger.getLogger(itf_KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
        MaGiamGia MGGS = new MaGiamGia(MaGiamGia, soLuong, menhGia, ngayBatDau, ngayKetThuc, trangThai, ngayTao, ngaySua);
        String result = MGG.insertMaGG(MGGS);
        JOptionPane.showMessageDialog(this, result);
        loadData(MGG.getListMGG());
    }//GEN-LAST:event_btnSuaEventMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgDieuKien;
    private javax.swing.ButtonGroup btgTrangThai;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSuaEvent;
    private javax.swing.JComboBox<String> cboTrangThaiKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoDangKichHoat;
    private javax.swing.JRadioButton rdoHetHieuLuc;
    private javax.swing.JTable tblKM;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtMucGiam1;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
// sinhVien = pggs = MGGS , sv = pgg = MGG
