package View;

import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;
import Service.Implement.DanhMucServiceImplement;
import Service.Implement.SanPhamServiceImplement;
import Service.Implement.SizeServiceImplement;
import Service.Implement.ViServiceImplement;
import Service.Interface.DanhMucServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.SizeServiceInterface;
import Service.Interface.ViServiceInterface;
import ViewModel.SanPhamViewModel;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLy_DoAnUongFrame extends javax.swing.JFrame {

    private SanPhamServiceInterface sanPhamServiceInterface;
    private ViServiceInterface viServiceInterface;
    private DanhMucServiceInterface danhMucServiceInterface;
    private SizeServiceInterface sizeServiceInterface;

    /**
     * Creates new form QuanLy_BanHang
     */
    public QuanLy_DoAnUongFrame() {
        initComponents();
        sanPhamServiceInterface = new SanPhamServiceImplement();
        viServiceInterface = new ViServiceImplement();
        danhMucServiceInterface = new DanhMucServiceImplement();
        sizeServiceInterface = new SizeServiceImplement();
        loadTableDSSP();
        loadCBBFrame();
    }

    public void loadTableDSSP() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouong.getModel();
        tblModel.setRowCount(0);
        List<SanPhamViewModel> list = sanPhamServiceInterface.getAllSP();
        for (SanPhamViewModel sanPhamViewModel : list) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMa(),
                sanPhamViewModel.getTen(),
                sanPhamViewModel.getDonGia(),
                sanPhamViewModel.getTenVi(),
                sanPhamViewModel.getTenDM(),
                sanPhamViewModel.getTenSize(),
                sanPhamViewModel.getTrangThai()
            });
        }
    }

    public void loadCBBFrame() {
        //combobox thong tin san pham
        DefaultComboBoxModel tblComboBoxModelDMSP = (DefaultComboBoxModel) cbbDanhmucSp.getModel();
        List<DanhMuc> listDm = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listDm) {
            tblComboBoxModelDMSP.addElement(danhMuc.getTenDM());
        }
        // combobox loc san pham
        DefaultComboBoxModel tblComboBoxModelDMKho = (DefaultComboBoxModel) cbbDanhMucKho.getModel();
        List<DanhMuc> listDmKho = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listDm) {
            tblComboBoxModelDMKho.addElement(danhMuc.getTenDM());
        }

        // combobox size san pham
        DefaultComboBoxModel tblComboBoxModelSize = (DefaultComboBoxModel) cbbSize.getModel();
        List<Size> listSize = sizeServiceInterface.getAllSize();
        for (Size size : listSize) {
            tblComboBoxModelSize.addElement(size.getMa());
        }
        //combobox Vi San Pham
        DefaultComboBoxModel tblComboBoxModelVI = (DefaultComboBoxModel) cbbVi.getModel();
        List<Vi> listVi = viServiceInterface.getAllVi();
        for (Vi vi : listVi) {
            tblComboBoxModelVI.addElement(vi.getTen());
        }
    }

    public void displaySanPhamFrom() {
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {
            txtmaDoUong.setText((String) tblSanPhamDouong.getValueAt(row, 0));
            txtTenDoUong.setText((String) tblSanPhamDouong.getValueAt(row, 1));
            txtGia.setText((String) tblSanPhamDouong.getValueAt(row, 2));
            cbbVi.setSelectedItem(tblSanPhamDouong.getValueAt(row, 3));
            cbbDanhmucSp.setSelectedItem(tblSanPhamDouong.getValueAt(row, 4));
            cbbSize.setSelectedItem(tblSanPhamDouong.getValueAt(row, 5));
            txtTrangThai.setText((String) tblSanPhamDouong.getValueAt(row, 6));
            txtmaDoUong.setEditable(false);
        }
    }

    public void clearfromSanPham() {
        txtmaDoUong.setText("");
        txtTenDoUong.setText("");
        txtGia.setText("");
        cbbVi.setSelectedIndex(0);
        cbbDanhmucSp.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTrangThai.setText("");
        txtTimKiemKho.setText("");
        txtmaDoUong.setEditable(true);
    }

    boolean validatFromSP() {
        if (txtmaDoUong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã Không được để trống");
            return false;
        }
        List<SanPhamViewModel> list = sanPhamServiceInterface.getAllSP();
        String maTrung = txtmaDoUong.getText();
        for (SanPhamViewModel sanPhamViewModel : list) {
            if (sanPhamViewModel.getMa().equals(maTrung)) {
                JOptionPane.showMessageDialog(this, "Mã Sản Phẩm đã Tồn Tại");
                return false;
            }
        }
        if (txtTenDoUong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên Không được để trống");
            return false;
        }
        Pattern p = Pattern.compile("^[0-9]+$");
        String txt = txtGia.getText();
        if (!p.matcher(txt).find()) {
            JOptionPane.showMessageDialog(this, "Đơn Giá Phải Là số");
            return false;
        }
        if (txtTrangThai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Trạng Thái không được để trống");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnltong = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnBanHang_Menu = new javax.swing.JButton();
        btnHoaDonMenu = new javax.swing.JButton();
        btnDoanUongMenu = new javax.swing.JButton();
        btnNhanVienMenu = new javax.swing.JButton();
        btnKhachHangmenu = new javax.swing.JButton();
        btnKhuyenMaiMenu = new javax.swing.JButton();
        btnThongkeMenu = new javax.swing.JButton();
        btnDangXuatMenu = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblMaDoUong = new javax.swing.JLabel();
        lblTenSp = new javax.swing.JLabel();
        lblVi = new javax.swing.JLabel();
        lbldanhmucSP = new javax.swing.JLabel();
        lblSizeSanPham = new javax.swing.JLabel();
        lblTrangthai = new javax.swing.JLabel();
        txtmaDoUong = new javax.swing.JTextField();
        txtTenDoUong = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        cbbDanhmucSp = new javax.swing.JComboBox<>();
        lblGia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cbbSize = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbbVi = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbbDanhMucKho = new javax.swing.JComboBox<>();
        lblLocDMkho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamDouong = new javax.swing.JTable();
        lblTimKiemTenSPKho = new javax.swing.JLabel();
        txtTimKiemKho = new javax.swing.JTextField();
        btnTimKiemKho = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnThemdoUong = new javax.swing.JButton();
        btnSuaDoUong = new javax.swing.JButton();
        btnXoaDoUong = new javax.swing.JButton();
        btnclearFromThongtinSP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbbDanhMucKho1 = new javax.swing.JComboBox<>();
        lblLocDMkho1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamDouongComBO = new javax.swing.JTable();
        lblTimKiemTenSPKho1 = new javax.swing.JLabel();
        txtTimKiemKho1 = new javax.swing.JTextField();
        btnTimKiemKho1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(204, 255, 255));
        pnlMenu.setPreferredSize(new java.awt.Dimension(190, 721));

        btnBanHang_Menu.setBackground(new java.awt.Color(204, 255, 255));
        btnBanHang_Menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBanHang_Menu.setText("Bán Hàng");
        btnBanHang_Menu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnBanHang_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang_MenuActionPerformed(evt);
            }
        });

        btnHoaDonMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnHoaDonMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoaDonMenu.setText("Hóa Đơn");
        btnHoaDonMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnHoaDonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMenuActionPerformed(evt);
            }
        });

        btnDoanUongMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDoanUongMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoanUongMenu.setText("Đồ Ăn, Uống");
        btnDoanUongMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnDoanUongMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanUongMenuActionPerformed(evt);
            }
        });

        btnNhanVienMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnNhanVienMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVienMenu.setText("Nhân Viên");
        btnNhanVienMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnNhanVienMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienMenuActionPerformed(evt);
            }
        });

        btnKhachHangmenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhachHangmenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHangmenu.setText("Khách Hàng");
        btnKhachHangmenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhachHangmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangmenuActionPerformed(evt);
            }
        });

        btnKhuyenMaiMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhuyenMaiMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhuyenMaiMenu.setText("Khuyến Mại");
        btnKhuyenMaiMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhuyenMaiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiMenuActionPerformed(evt);
            }
        });

        btnThongkeMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnThongkeMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongkeMenu.setText("Thông kê");
        btnThongkeMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnThongkeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeMenuActionPerformed(evt);
            }
        });

        btnDangXuatMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDangXuatMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuatMenu.setText("Đăng Xuất");
        btnDangXuatMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnDangXuatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBanHang_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnHoaDonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoanUongMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhanVienMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhachHangmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuyenMaiMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongkeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuatMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanUongMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVienMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHangmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMaiMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongkeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuatMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Đồ Ăn, Uống"));

        lblMaDoUong.setText("Mã ");

        lblTenSp.setText("Tên");

        lblVi.setText("Vị");

        lbldanhmucSP.setText("Danh Mục");

        lblSizeSanPham.setText("Size");

        lblTrangthai.setText("Trạng Thái");

        lblGia.setText("Đơn Giá");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("+");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("+");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("+");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVi))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenDoUong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txtmaDoUong, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGia)
                    .addComponent(cbbVi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSizeSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldanhmucSP)
                            .addComponent(lblTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTrangThai)
                            .addComponent(cbbDanhmucSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(9, 9, 9))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaDoUong)
                            .addComponent(txtmaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenSp)
                            .addComponent(txtTenDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGia)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldanhmucSP)
                            .addComponent(cbbDanhmucSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSizeSanPham)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTrangthai))))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVi)
                    .addComponent(jButton1)
                    .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Đồ Ăn, Uống"));

        cbbDanhMucKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucKhoActionPerformed(evt);
            }
        });

        lblLocDMkho.setText("Danh Mục");

        tblSanPhamDouong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Đơn Giá", "Vị", "Danh Mục", "Size", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamDouong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamDouongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamDouong);

        lblTimKiemTenSPKho.setText("Tên Sản Phẩm");

        btnTimKiemKho.setText("Tìm Kiếm");
        btnTimKiemKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTimKiemTenSPKho)
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                        .addComponent(lblLocDMkho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDanhMucKho, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLocDMkho)
                        .addComponent(lblTimKiemTenSPKho)
                        .addComponent(txtTimKiemKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemKho))
                    .addComponent(cbbDanhMucKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        btnThemdoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemdoUong.setText("Thêm");
        btnThemdoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemdoUongActionPerformed(evt);
            }
        });

        btnSuaDoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSuaDoUong.setText("Sửa");
        btnSuaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDoUongActionPerformed(evt);
            }
        });

        btnXoaDoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDoUong.setText("Xóa");
        btnXoaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoUongActionPerformed(evt);
            }
        });

        btnclearFromThongtinSP.setText("Clear");
        btnclearFromThongtinSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearFromThongtinSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnclearFromThongtinSP, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnXoaDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnSuaDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnThemdoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnThemdoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclearFromThongtinSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        jTabbedPane1.addTab("Đồ Ăn Uống", jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Đồ Ăn, Uống"));

        cbbDanhMucKho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucKho1ActionPerformed(evt);
            }
        });

        lblLocDMkho1.setText("Danh Mục");

        tblSanPhamDouongComBO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Đơn Giá", "Vị", "Danh Mục", "Size", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamDouongComBO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamDouongComBOMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPhamDouongComBO);

        lblTimKiemTenSPKho1.setText("Tên Sản Phẩm");

        btnTimKiemKho1.setText("Tìm Kiếm");
        btnTimKiemKho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKho1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setText("Thêm Vào ComBO");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimKiemTenSPKho1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimKiemKho1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemKho1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocDMkho1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbbDanhMucKho1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(379, 379, 379))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocDMkho1)
                    .addComponent(lblTimKiemTenSPKho1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiemKho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbDanhMucKho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemKho1))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ComBo Đồ Uuống", jPanel5);

        javax.swing.GroupLayout pnltongLayout = new javax.swing.GroupLayout(pnltong);
        pnltong.setLayout(pnltongLayout);
        pnltongLayout.setHorizontalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        pnltongLayout.setVerticalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addGroup(pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(pnltong, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHang_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang_MenuActionPerformed
        // TODO add your handling code here:
        new QuanLy_BanHang().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBanHang_MenuActionPerformed

    private void btnHoaDonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMenuActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnHoaDonMenuActionPerformed

    private void btnDoanUongMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanUongMenuActionPerformed
        // TODO add your handling code here:
        new QuanLy_DoAnUongFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoanUongMenuActionPerformed

    private void btnNhanVienMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnNhanVienMenuActionPerformed

    private void btnKhachHangmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangmenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnKhachHangmenuActionPerformed

    private void btnKhuyenMaiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnKhuyenMaiMenuActionPerformed

    private void btnThongkeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnThongkeMenuActionPerformed

    private void btnDangXuatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnDangXuatMenuActionPerformed

    private void cbbDanhMucKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucKhoActionPerformed
        // TODO add your handling code here:
        //        LocCBBDM();
    }//GEN-LAST:event_cbbDanhMucKhoActionPerformed

    private void tblSanPhamDouongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamDouongMouseClicked
        // TODO add your handling code here:
        displaySanPhamFrom();
    }//GEN-LAST:event_tblSanPhamDouongMouseClicked

    private void btnTimKiemKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhoActionPerformed

//        String tenSp= txtTimKiemKho.getText();
//        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouong.getModel();
//        tblModel.setRowCount(0);
//        List<SanPhamVModel> list = sanPhamServiceInterface.getAllSP();
//        for (SanPhamVModel sanPhamVModel : list) {
//            if(sanPhamVModel.getTen().equalsIgnoreCase(tenSp)){
//                tblModel.addRow(new Object[]{
//                    sanPhamVModel.getMa(),
//                    sanPhamVModel.getTen(),
//                    sanPhamVModel.getDonGia(),
//                    sanPhamVModel.getVi(),
//                    sanPhamVModel.getDanhmuc(),
//                    sanPhamVModel.getSize(),
//                    sanPhamVModel.getTrangThai()
//                });
//            }
//        }
    }//GEN-LAST:event_btnTimKiemKhoActionPerformed

    private void btnThemdoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemdoUongActionPerformed
        // TODO add your handling code here:
        if (validatFromSP() == true) {
            SanPham sanPham = new SanPham();
            sanPham.setMa(txtmaDoUong.getText());
            sanPham.setTen(txtTenDoUong.getText());
            sanPham.setDonGia(txtGia.getText());
            String nameVi = (String) cbbVi.getSelectedItem();
            List<Vi> listVi = viServiceInterface.getAllVi();
            for (Vi vi : listVi) {
                if (vi.getTen().equals(nameVi)) {
                    sanPham.setId_Vi(vi.getId());
                }
            }
            String nameDM = (String) cbbDanhmucSp.getSelectedItem();
            List<DanhMuc> listdm = danhMucServiceInterface.getallDM();
            for (DanhMuc danhMuc : listdm) {
                if (danhMuc.getTenDM().equals(nameDM)) {
                    sanPham.setId_DanhMuc(danhMuc.getId());
                }
            }
            String maSize = (String) cbbSize.getSelectedItem();
            List<Size> listSize = sizeServiceInterface.getAllSize();
            for (Size size : listSize) {
                if (size.getMa().equals(maSize)) {
                    sanPham.setId_size(size.getId());
                }
            }
            String trangThai = txtTrangThai.getText();
            if (trangThai.equalsIgnoreCase("Còn Hàng")) {
                sanPham.setTrangThai(1);
            }
            if (trangThai.equalsIgnoreCase("Hết Hàng")) {
                sanPham.setTrangThai(0);
            }
            System.out.println(sanPham);
            try {
                sanPhamServiceInterface.addSanPham(sanPham);
                loadTableDSSP();
                clearfromSanPham();
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemdoUongActionPerformed

    private void btnSuaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDoUongActionPerformed
        // TODO add your handling code here:
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {
            SanPham sanPham = new SanPham();
            sanPham.setMa(txtmaDoUong.getText());
            sanPham.setTen(txtTenDoUong.getText());
            sanPham.setDonGia(txtGia.getText());
            String nameVi = (String) cbbVi.getSelectedItem();
            List<Vi> listVi = viServiceInterface.getAllVi();
            for (Vi vi : listVi) {
                if (vi.getTen().equals(nameVi)) {
                    sanPham.setId_Vi(vi.getId());
                }
            }
            String nameDM = (String) cbbDanhmucSp.getSelectedItem();
            List<DanhMuc> listdm = danhMucServiceInterface.getallDM();
            for (DanhMuc danhMuc : listdm) {
                if (danhMuc.getTenDM().equals(nameDM)) {
                    sanPham.setId_DanhMuc(danhMuc.getId());
                }
            }
            String maSize = (String) cbbSize.getSelectedItem();
            List<Size> listSize = sizeServiceInterface.getAllSize();
            for (Size size : listSize) {
                if (size.getMa().equals(maSize)) {
                    sanPham.setId_size(size.getId());
                }
            }
            String trangThai = txtTrangThai.getText();
            if (trangThai.equalsIgnoreCase("Còn Hàng")) {
                sanPham.setTrangThai(1);
            }
            if (trangThai.equalsIgnoreCase("Hết Hàng")) {
                sanPham.setTrangThai(0);
            }
            System.out.println(sanPham);
            try {
                sanPhamServiceInterface.updateSanPham(sanPham);
                loadTableDSSP();
                clearfromSanPham();
                JOptionPane.showMessageDialog(this, "Sửa Thành Công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn Mục Cần Sửa");
            return;
        }
    }//GEN-LAST:event_btnSuaDoUongActionPerformed

    private void btnXoaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoUongActionPerformed
        int row = tblSanPhamDouong.getSelectedRow();
        if(row>=0){
        SanPham sanPham = new SanPham();
        sanPham.setMa(txtmaDoUong.getText());
        try {
            sanPhamServiceInterface.deleteSanPham(sanPham);
            loadTableDSSP();
            clearfromSanPham();
            JOptionPane.showMessageDialog(this, "Xóa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn Mục Cần Xóa");
        }
    }//GEN-LAST:event_btnXoaDoUongActionPerformed

    private void btnclearFromThongtinSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearFromThongtinSPActionPerformed
        // TODO add your handling code here:
//        clearfromSanPham();
//        LoadTableDoUong();
    }//GEN-LAST:event_btnclearFromThongtinSPActionPerformed

    private void cbbDanhMucKho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucKho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDanhMucKho1ActionPerformed

    private void tblSanPhamDouongComBOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamDouongComBOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamDouongComBOMouseClicked

    private void btnTimKiemKho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemKho1ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLy_DoAnUongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy_DoAnUongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy_DoAnUongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy_DoAnUongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy_DoAnUongFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang_Menu;
    private javax.swing.JButton btnDangXuatMenu;
    private javax.swing.JButton btnDoanUongMenu;
    private javax.swing.JButton btnHoaDonMenu;
    private javax.swing.JButton btnKhachHangmenu;
    private javax.swing.JButton btnKhuyenMaiMenu;
    private javax.swing.JButton btnNhanVienMenu;
    private javax.swing.JButton btnSuaDoUong;
    private javax.swing.JButton btnThemdoUong;
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnTimKiemKho;
    private javax.swing.JButton btnTimKiemKho1;
    private javax.swing.JButton btnXoaDoUong;
    private javax.swing.JButton btnclearFromThongtinSP;
    private javax.swing.JComboBox<String> cbbDanhMucKho;
    private javax.swing.JComboBox<String> cbbDanhMucKho1;
    private javax.swing.JComboBox<String> cbbDanhmucSp;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbVi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblLocDMkho;
    private javax.swing.JLabel lblLocDMkho1;
    private javax.swing.JLabel lblMaDoUong;
    private javax.swing.JLabel lblSizeSanPham;
    private javax.swing.JLabel lblTenSp;
    private javax.swing.JLabel lblTimKiemTenSPKho;
    private javax.swing.JLabel lblTimKiemTenSPKho1;
    private javax.swing.JLabel lblTrangthai;
    private javax.swing.JLabel lblVi;
    private javax.swing.JLabel lbldanhmucSP;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnltong;
    private javax.swing.JTable tblSanPhamDouong;
    private javax.swing.JTable tblSanPhamDouongComBO;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenDoUong;
    private javax.swing.JTextField txtTimKiemKho;
    private javax.swing.JTextField txtTimKiemKho1;
    private javax.swing.JTextField txtTrangThai;
    private javax.swing.JTextField txtmaDoUong;
    // End of variables declaration//GEN-END:variables
}
