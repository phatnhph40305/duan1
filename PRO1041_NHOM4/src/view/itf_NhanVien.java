package view;

import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import model.NguoiDung;
import service.NguoiDungServices;

/**
 *
 * @author Admin
 */
public class itf_NhanVien extends javax.swing.JInternalFrame {

    NguoiDungServices ndsv = new NguoiDungServices();
    private DefaultTableModel tblModel = new DefaultTableModel();

    public itf_NhanVien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        this.setSize(1300, 755);
        NguoiDungServices ndsv = new NguoiDungServices();
        loadTableNv1(ndsv.getListnv());
        loadTableNv2(this.ndsv.getListnv0());
    }

    public void loadTableNv1(List<NguoiDung> list) {
        tblModel = (DefaultTableModel) tblNV1.getModel();
        tblModel.setRowCount(0);
        for (NguoiDung nguoiDung : list) {
            tblModel.addRow(new Object[]{
                nguoiDung.getMaNV(),
                nguoiDung.getTenDN(),
                nguoiDung.getMatKhau(),
                nguoiDung.getTen(),
                nguoiDung.getChucVu(),
                nguoiDung.trangThai(),
                nguoiDung.getNgayTao(),
                nguoiDung.getNgaySua()
            });
        }
    }

     public void loadTableNv2(List<NguoiDung> list) {
        tblModel = (DefaultTableModel) tblNV1.getModel();
        tblModel.setRowCount(0);
        for (NguoiDung nguoiDung : list) {
            tblModel.addRow(new Object[]{
                nguoiDung.getMaNV(),
                nguoiDung.getTenDN(),
                nguoiDung.getMatKhau(),
                nguoiDung.getTen(),
                nguoiDung.getChucVu(),
                nguoiDung.trangThai(),
                nguoiDung.getNgayTao(),
                nguoiDung.getNgaySua()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGioiTinhNV = new javax.swing.ButtonGroup();
        btnTrangThaiNV = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlChiTietNhanVien = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNV1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNV0 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtTimNV = new javax.swing.JTextField();
        btnRSTimNV = new javax.swing.JButton();
        cboTimKiemNV = new javax.swing.JComboBox<>();
        jPanel61 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txttenDn = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        rdoDangLamViec = new javax.swing.JRadioButton();
        rdoNghiViec = new javax.swing.JRadioButton();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnMoiNV = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdQuanLy = new javax.swing.JRadioButton();
        rdNhanVien = new javax.swing.JRadioButton();

        tblNV1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật khẩu", "Họ tên", "chức vụ", "Trạng thái", "Ngày vào làm", "Ngày sửa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNV1);
        if (tblNV1.getColumnModel().getColumnCount() > 0) {
            tblNV1.getColumnModel().getColumn(0).setResizable(false);
            tblNV1.getColumnModel().getColumn(1).setResizable(false);
            tblNV1.getColumnModel().getColumn(2).setResizable(false);
            tblNV1.getColumnModel().getColumn(3).setResizable(false);
            tblNV1.getColumnModel().getColumn(4).setResizable(false);
            tblNV1.getColumnModel().getColumn(5).setResizable(false);
            tblNV1.getColumnModel().getColumn(6).setResizable(false);
            tblNV1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Đang làm việc", jPanel11);

        tblNV0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Họ tên", "Mật Khẩu", "Địa chỉ", "SĐT", "CCCD", "Ngày vào làm", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV0MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNV0);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Nghỉ việc", jPanel14);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        btnRSTimNV.setText("Reset");
        btnRSTimNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRSTimNVActionPerformed(evt);
            }
        });

        cboTimKiemNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Họ tên", "SĐT", "CCCD" }));
        cboTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimNV, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRSTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRSTimNV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlChiTietNhanVienLayout = new javax.swing.GroupLayout(pnlChiTietNhanVien);
        pnlChiTietNhanVien.setLayout(pnlChiTietNhanVienLayout);
        pnlChiTietNhanVienLayout.setHorizontalGroup(
            pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlChiTietNhanVienLayout.setVerticalGroup(
            pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết lập thông tin"));

        jLabel27.setText("Mã NV");

        jLabel28.setText("Tên Đăng Nhập");

        jLabel29.setText("Họ tên");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel35.setText("Trạng thái");

        btnTrangThaiNV.add(rdoDangLamViec);
        rdoDangLamViec.setText("Đang làm việc");
        rdoDangLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDangLamViecActionPerformed(evt);
            }
        });

        btnTrangThaiNV.add(rdoNghiViec);
        rdoNghiViec.setText("Nghỉ việc");
        rdoNghiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNghiViecActionPerformed(evt);
            }
        });

        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnMoiNV.setText("Mới");
        btnMoiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiNVActionPerformed(evt);
            }
        });

        jButton1.setText("Nhập từ excel");

        jLabel30.setText("Mật khẩu");

        jLabel1.setText("Chức vụ");

        buttonGroup1.add(rdQuanLy);
        rdQuanLy.setText("Quản lý");

        buttonGroup1.add(rdNhanVien);
        rdNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel35)
                                .addGap(47, 47, 47)
                                .addComponent(rdoDangLamViec)
                                .addGap(53, 53, 53)
                                .addComponent(rdoNghiViec))
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttenDn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(rdQuanLy)
                                .addGap(39, 39, 39)
                                .addComponent(rdNhanVien))))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btnThemNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoiNV)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txttenDn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(rdoDangLamViec)
                    .addComponent(rdoNghiViec)
                    .addComponent(jLabel1)
                    .addComponent(rdQuanLy)
                    .addComponent(rdNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNV)
                    .addComponent(btnSuaNV)
                    .addComponent(btnMoiNV)
                    .addComponent(jButton1))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChiTietNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChiTietNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRSTimNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRSTimNVActionPerformed

    }//GEN-LAST:event_btnRSTimNVActionPerformed

    private void cboTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiemNVActionPerformed

    }//GEN-LAST:event_cboTimKiemNVActionPerformed

    private void tblNV0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV0MouseClicked

    }//GEN-LAST:event_tblNV0MouseClicked

    private void tblNV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV1MouseClicked

    }//GEN-LAST:event_tblNV1MouseClicked

    private void btnMoiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNVActionPerformed

    }//GEN-LAST:event_btnMoiNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed

    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        this.ndsv.insertNhanVien(nguoiDung);
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void rdoDangLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDangLamViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDangLamViecActionPerformed

    private void rdoNghiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNghiViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNghiViecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGioiTinhNV;
    private javax.swing.JButton btnMoiNV;
    private javax.swing.JButton btnRSTimNV;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.ButtonGroup btnTrangThaiNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTimKiemNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JPanel pnlChiTietNhanVien;
    private javax.swing.JRadioButton rdNhanVien;
    private javax.swing.JRadioButton rdQuanLy;
    private javax.swing.JRadioButton rdoDangLamViec;
    private javax.swing.JRadioButton rdoNghiViec;
    private javax.swing.JTable tblNV0;
    private javax.swing.JTable tblNV1;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTimNV;
    private javax.swing.JTextField txttenDn;
    // End of variables declaration//GEN-END:variables
}
