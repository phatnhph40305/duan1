package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

import model.NguoiDung;
import service.NguoiDungServices;

/**
 *
 * @author Admin
 */
public class itf_NhanVien extends javax.swing.JInternalFrame {
    
    int id = -1;
    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModel1 = new DefaultTableModel();
    
    private NguoiDungServices ndsv = new NguoiDungServices();
    
    public itf_NhanVien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        this.setSize(1300, 755);
        NguoiDungServices ndsv = new NguoiDungServices();
        loadTableNv(ndsv.getListnv());
        loadTableNv2(ndsv.getListnvByTrangThai(1));
        loadTableNv3(ndsv.getListnvByTrangThai(0));
        clearForm();
        
    }
    
    public void loadTableNv(List<NguoiDung> list) {
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
        tblModel1 = (DefaultTableModel) tblNV4.getModel();
        tblModel1.setRowCount(0);
        for (NguoiDung nguoiDung : list) {
            tblModel1.addRow(new Object[]{
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
    
    public void loadTableNv3(List<NguoiDung> list) {
        tblModel1 = (DefaultTableModel) tblNV3.getModel();
        tblModel1.setRowCount(0);
        for (NguoiDung nguoiDung : list) {
            tblModel1.addRow(new Object[]{
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
    
    public void detaiTable(int index, List<NguoiDung> list) {
        NguoiDung nd = list.get(index);
        txtMaNV.setText(nd.getMaNV());
        txtHoTen.setText(nd.getTen());
        txttenDn.setText(nd.getTenDN());
        txtMatKhau.setText(nd.getMatKhau());
        if (nd.getTrangThai() == 1) {
            rdoDangLamViec.setSelected(true);
        } else {
            rdoNghiViec.setSelected(true);
        }
        if (nd.getChucVu().equalsIgnoreCase("Nhân viên")) {
            rdNhanVien.setSelected(true);
        } else {
            rdQuanLy.setSelected(true);
        }
    }
    
    private NguoiDung readForm() {
        String chucVu = "";
        if (rdNhanVien.isSelected()) {
            chucVu = "Nhân viên";
        } else {
            chucVu = "Quản lý";
        }
        int trangThai = 0;
        if (rdoDangLamViec.isSelected()) {
            trangThai = 1;
            
        } else {
            trangThai = 0;
        }
        return new NguoiDung(txtHoTen.getText(), txtMaNV.getText(), txttenDn.getText(), txtMatKhau.getText(), chucVu, trangThai);
    }
    
    private void clearForm() {
        txtMaNV.setText("");
        txtHoTen.setText("");
        txttenDn.setText("");
        txtMatKhau.setText("");
        btnTrangThaiNV.clearSelection();
        buttonGroup1.clearSelection();
        btnSuaNV.setEnabled(false);
        loadTableNv(this.ndsv.getListnv());
        loadTableNv2(this.ndsv.getListnvByTrangThai(1));
        loadTableNv3(this.ndsv.getListnvByTrangThai(0));
        
    }
    
    private boolean validateAddNV() {
        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã nhân viên");
            return false;
        }
        if (!txtMaNV.getText().startsWith("NV")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải bắt đầu bằng: 'NV ' ");
            return false;
        }
        for (NguoiDung nguoiDung : this.ndsv.getListnv()) {
            if (nguoiDung.getMaNV().equals(txtMaNV.getText())) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không được giống nhau");
                return false;
            }
        }
        if (txttenDn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên đăng nhập");
            return false;
        }
        for (NguoiDung nguoiDung : this.ndsv.getListnv()) {
            if (nguoiDung.getTenDN().equals(txtMaNV.getText())) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập không được giống nhau");
                return false;
            }
        }
        if (txtHoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên người dùng");
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mật khẩu");
            return false;
        }
        if (rdNhanVien.isSelected() == false && rdQuanLy.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
            return false;
            
        }
        if (rdoDangLamViec.isSelected() == false && rdoNghiViec.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái");
            return false;
            
        }
        return true;
    }
    
    private boolean validateUpdateNV() {
        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã nhân viên");
            return false;
        }
        if (!txtMaNV.getText().startsWith("NV")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải bắt đầu bằng: 'NV ' ");
            return false;
        }
        
        if (txttenDn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên đăng nhập");
            return false;
        }
        for (NguoiDung nguoiDung : this.ndsv.getListnv()) {
            if (nguoiDung.getTenDN().equals(txtMaNV.getText())) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập không được giống nhau");
                return false;
            }
        }
        if (txtHoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên người dùng");
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mật khẩu");
            return false;
        }
        if (rdNhanVien.isSelected() == false && rdQuanLy.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
            return false;
            
        }
        if (rdoDangLamViec.isSelected() == false && rdoNghiViec.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái");
            return false;
            
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGioiTinhNV = new javax.swing.ButtonGroup();
        btnTrangThaiNV = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNV2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNV0 = new javax.swing.JTable();
        pnlChiTietNhanVien = new javax.swing.JPanel();
        jtbNhanVien = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNV1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblNV4 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNV3 = new javax.swing.JTable();
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

        tblNV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật Khẩu", "Họ tên", "Chức vụ", "Trạng thái", "Ngày vào làm", "Ngày nghỉ việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblNV2);
        if (tblNV2.getColumnModel().getColumnCount() > 0) {
            tblNV2.getColumnModel().getColumn(1).setResizable(false);
            tblNV2.getColumnModel().getColumn(2).setResizable(false);
            tblNV2.getColumnModel().getColumn(3).setResizable(false);
            tblNV2.getColumnModel().getColumn(4).setResizable(false);
            tblNV2.getColumnModel().getColumn(5).setResizable(false);
            tblNV2.getColumnModel().getColumn(7).setResizable(false);
        }

        tblNV0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật Khẩu", "Họ tên", "Chức vụ", "Trạng thái", "Ngày vào làm", "Ngày nghỉ việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false
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
        if (tblNV0.getColumnModel().getColumnCount() > 0) {
            tblNV0.getColumnModel().getColumn(1).setResizable(false);
            tblNV0.getColumnModel().getColumn(2).setResizable(false);
            tblNV0.getColumnModel().getColumn(3).setResizable(false);
            tblNV0.getColumnModel().getColumn(4).setResizable(false);
            tblNV0.getColumnModel().getColumn(5).setResizable(false);
            tblNV0.getColumnModel().getColumn(7).setResizable(false);
        }

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtbNhanVien.addTab("Tất cả", jPanel11);

        tblNV4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật Khẩu", "Họ tên", "Chức vụ", "Trạng thái", "Ngày vào làm", "Ngày sửa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV4MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblNV4);
        if (tblNV4.getColumnModel().getColumnCount() > 0) {
            tblNV4.getColumnModel().getColumn(0).setResizable(false);
            tblNV4.getColumnModel().getColumn(1).setResizable(false);
            tblNV4.getColumnModel().getColumn(2).setResizable(false);
            tblNV4.getColumnModel().getColumn(3).setResizable(false);
            tblNV4.getColumnModel().getColumn(4).setResizable(false);
            tblNV4.getColumnModel().getColumn(5).setResizable(false);
            tblNV4.getColumnModel().getColumn(6).setResizable(false);
            tblNV4.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jtbNhanVien.addTab("Đang làm việc", jPanel14);

        tblNV3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật Khẩu", "Họ tên", "Chức vụ", "Trạng thái", "Ngày vào làm", "Ngày nghỉ việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblNV3);
        if (tblNV3.getColumnModel().getColumnCount() > 0) {
            tblNV3.getColumnModel().getColumn(0).setResizable(false);
            tblNV3.getColumnModel().getColumn(1).setResizable(false);
            tblNV3.getColumnModel().getColumn(2).setResizable(false);
            tblNV3.getColumnModel().getColumn(3).setResizable(false);
            tblNV3.getColumnModel().getColumn(4).setResizable(false);
            tblNV3.getColumnModel().getColumn(5).setResizable(false);
            tblNV3.getColumnModel().getColumn(6).setResizable(false);
            tblNV3.getColumnModel().getColumn(7).setResizable(false);
        }

        jtbNhanVien.addTab("Đã nghỉ việc", jScrollPane7);

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
                    .addComponent(jtbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jtbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jButton1.setText("Xuất file excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        int index = tblNV1.getSelectedRow();
        id = ndsv.getListnv().get(index).getIdNguoiDung();
//        JOptionPane.showMessageDialog(this, id);

        detaiTable(index, this.ndsv.getListnv());
        btnSuaNV.setEnabled(true);
    }//GEN-LAST:event_tblNV1MouseClicked

    private void btnMoiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNVActionPerformed
        clearForm();
    }//GEN-LAST:event_btnMoiNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        if (validateUpdateNV()) {
            ndsv.updateNhanVien(readForm(), id);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            clearForm();
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        if (validateAddNV()) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            this.ndsv.insertNhanVien(readForm());
            loadTableNv(ndsv.getListnv());
        }

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

    private void tblNV2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNV2MouseClicked

    private void tblNV3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV3MouseClicked
        int index = tblNV3.getSelectedRow();
        id = ndsv.getListnvByTrangThai(0).get(index).getIdNguoiDung();
//        JOptionPane.showMessageDialog(this, id);
        detaiTable(index, this.ndsv.getListnvByTrangThai(0));
        btnSuaNV.setEnabled(true);

    }//GEN-LAST:event_tblNV3MouseClicked

    private void tblNV4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV4MouseClicked
        int index = tblNV4.getSelectedRow();
        id = ndsv.getListnvByTrangThai(1).get(index).getIdNguoiDung();
//        JOptionPane.showMessageDialog(this, id);

        detaiTable(index, this.ndsv.getListnvByTrangThai(1));
        btnSuaNV.setEnabled(true);

    }//GEN-LAST:event_tblNV4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ndsv.exportExcelKhachHang(ndsv.getListnv());
    }//GEN-LAST:event_jButton1ActionPerformed


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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jtbNhanVien;
    private javax.swing.JPanel pnlChiTietNhanVien;
    private javax.swing.JRadioButton rdNhanVien;
    private javax.swing.JRadioButton rdQuanLy;
    private javax.swing.JRadioButton rdoDangLamViec;
    private javax.swing.JRadioButton rdoNghiViec;
    private javax.swing.JTable tblNV0;
    private javax.swing.JTable tblNV1;
    private javax.swing.JTable tblNV2;
    private javax.swing.JTable tblNV3;
    private javax.swing.JTable tblNV4;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTimNV;
    private javax.swing.JTextField txttenDn;
    // End of variables declaration//GEN-END:variables
}
