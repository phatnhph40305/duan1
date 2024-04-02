package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.QuanLyKhachHang;

/**
 *
 * @author Admin
 */
public class itf_KhachHang extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    private QuanLyKhachHang qlkh = new QuanLyKhachHang();

    public itf_KhachHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ul = (BasicInternalFrameUI) this.getUI();
        ul.setNorthPane(null);
        this.setSize(1300, 755);
        loadFormKhachHang(this.qlkh.getListKhachHang());
        clearForm();

    }

    private void loadFormKhachHang(List<KhachHang> list) {
        model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        for (KhachHang khachHang : list) {

            model.addRow(new Object[]{khachHang.getIdKhachHang(),
                khachHang.getMaKh(), khachHang.getTenKhachHang(), khachHang.getSdtKhachHang(), khachHang.trangThai(),
                khachHang.getNgayTao(), khachHang.getNgaySua()
            });
        }

    }

    private KhachHang readForm() {
        int trangThai;
        if (rdHoatDong.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new KhachHang(txtMaKhachHang.getText(), txtTenKhachHang.getText(), txtSoDienThoai.getText(), trangThai);
    }

    private void clearForm() {
        txtMaKhachHang.setText("");
        txtSoDienThoai.setText("");
        txtTenKhachHang.setText("");
        txtTimKiem.setText("");
        btnCapNhat.setEnabled(false);
        buttonGroup1.clearSelection();
    }

    private void loadFormTable(int index) {
        String idSP = tblKhachHang.getValueAt(index, 0).toString();
        String maKH = tblKhachHang.getValueAt(index, 1).toString();
        String tenKh = tblKhachHang.getValueAt(index, 2).toString();
        String sdtKh = tblKhachHang.getValueAt(index, 3).toString();
        String trangThai = tblKhachHang.getValueAt(index, 4).toString();
        if (trangThai.equalsIgnoreCase("Hoạt động")) {
            rdHoatDong.setSelected(true);
        } else {
            rdKhongHoatDong.setSelected(true);
        }

        txtMaKhachHang.setText(maKH);
        txtTenKhachHang.setText(tenKh);
        txtSoDienThoai.setText(sdtKh);
    }

    private void updateKhachHang() {
        int index = tblKhachHang.getSelectedRow();
        int idKhachHang = (int) tblKhachHang.getValueAt(index, 0);
//        JOptionPane.showMessageDialog(this,idKhachHang);
        this.qlkh.updateKH(readForm(), idKhachHang);
        loadFormKhachHang(this.qlkh.getListKhachHang());
    }

    private boolean validateKh() {
        if (txtMaKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã khách hàng.");
            return false;
        }
        if (!txtMaKhachHang.getText().startsWith("KH")) {
            JOptionPane.showMessageDialog(this, "Kí tự bắt đầu của mã khách hàng phải là: KH");
            return false;
        }
        for (KhachHang khachHang : this.qlkh.getListKhachHang()) {
            if (khachHang.getMaKh().equalsIgnoreCase(txtMaKhachHang.getText())) {
                JOptionPane.showMessageDialog(this, "mã khách hàng không được trùng nhau");
                return false;

            }
        }
        if (txtTenKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên khách hàng.");
            return false;
        }
        if (txtSoDienThoai.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống sdt khách hàng.");
            return false;
        }
        if (rdHoatDong.isSelected() == false && rdKhongHoatDong.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "vui lòng trọn trạng thái");
            return false;
        }
        return true;
    }

    private boolean validateKhUd() {
        if (txtMaKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã khách hàng.");
            return false;
        }
        if (!txtMaKhachHang.getText().startsWith("KH")) {
            JOptionPane.showMessageDialog(this, "Kí tự bắt đầu của mã khách hàng phải là: KH");
            return false;
        }
        if (txtTenKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên khách hàng.");
            return false;
        }
        if (txtSoDienThoai.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống sdt khách hàng.");
            return false;
        }
        if (rdHoatDong.isSelected() == false && rdKhongHoatDong.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "vui lòng trọn trạng thái");
            return false;
        }
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGioiTinh = new javax.swing.ButtonGroup();
        btngTrangThai = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThemTuExcel = new javax.swing.JButton();
        tbnXuatFile = new javax.swing.JButton();
        rdHoatDong = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        lblSoTrangKH = new javax.swing.JLabel();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(940, 657));
        setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập trông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setText("Mã khách hàng: ");

        jLabel2.setText("Tên khách hàng: ");

        jLabel4.setText("Số điện thoại: ");

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThemTuExcel.setText("Thêm từ Excel");

        tbnXuatFile.setText("Xuất file");

        buttonGroup1.add(rdHoatDong);
        rdHoatDong.setText("Hoạt động");

        buttonGroup1.add(rdKhongHoatDong);
        rdKhongHoatDong.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(rdHoatDong)
                                .addGap(40, 40, 40)
                                .addComponent(rdKhongHoatDong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemTuExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tbnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdHoatDong)
                            .addComponent(rdKhongHoatDong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemTuExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id khách hàng", "Mã khách hàng", "Tên khách hàng", "SĐT", "Trạng thái", "Ngày tạo", "Ngày sửa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(4).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(5).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        lblSoTrangKH.setText("Số trang");

        btnDau.setText("<<");
        btnDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauMouseClicked(evt);
            }
        });

        btnLui.setText("<");
        btnLui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuiMouseClicked(evt);
            }
        });

        btnTien.setText(">");
        btnTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTienMouseClicked(evt);
            }
        });

        btnCuoi.setText(">>");
        btnCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnDau)
                        .addGap(33, 33, 33)
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblSoTrangKH)
                        .addGap(44, 44, 44)
                        .addComponent(btnTien, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDau)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLui)
                        .addComponent(lblSoTrangKH))
                    .addComponent(btnTien)
                    .addComponent(btnCuoi))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int index = tblKhachHang.getSelectedRow();
        loadFormTable(index);
        btnCapNhat.setEnabled(true);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked

    }//GEN-LAST:event_btnCapNhatMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked

    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauMouseClicked

    }//GEN-LAST:event_btnDauMouseClicked

    private void btnCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiMouseClicked

    }//GEN-LAST:event_btnCuoiMouseClicked

    private void btnTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTienMouseClicked

    }//GEN-LAST:event_btnTienMouseClicked

    private void btnLuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuiMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnLuiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (validateKh()) {
            this.qlkh.insertKhachHang(readForm());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadFormKhachHang(this.qlkh.getListKhachHang());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (validateKhUd()) {
            updateKhachHang();
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
            clearForm();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        loadFormKhachHang(this.qlkh.searchByName(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTuExcel;
    private javax.swing.JButton btnTien;
    private javax.swing.ButtonGroup btngGioiTinh;
    private javax.swing.ButtonGroup btngTrangThai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoTrangKH;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdKhongHoatDong;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JButton tbnXuatFile;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
