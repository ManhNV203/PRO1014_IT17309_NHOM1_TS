package View;

import DomainModel.ComBo;
import DomainModel.ComBoChiTiet;
import DomainModel.DanhMuc;
import DomainModel.SanPham;
import DomainModel.Size;
import DomainModel.Vi;
import Service.Implement.ComBoChiTietServiceImplement;
import Service.Implement.ComBoServiceImplement;
import Service.Implement.DanhMucServiceImplement;
import Service.Implement.SanPhamServiceImplement;
import Service.Implement.SizeServiceImplement;
import Service.Implement.ViServiceImplement;
import Service.Interface.ComBoChiTietServiceInterface;
import Service.Interface.ComBoServiceInterface;
import Service.Interface.DanhMucServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.SizeServiceInterface;
import Service.Interface.ViServiceInterface;
import ViewModel.ComBoChiTietViewModel;
import ViewModel.SanPhamViewModel;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLy_DoAnUongFrame extends javax.swing.JFrame {

    private SanPhamServiceInterface sanPhamServiceInterface;
    private ViServiceInterface viServiceInterface;
    private DanhMucServiceInterface danhMucServiceInterface;
    private SizeServiceInterface sizeServiceInterface;
    private ComBoServiceInterface comBoServiceInterface;
    private ComBoChiTietServiceInterface comBoChiTietServiceInterface;

    /**
     * Creates new form QuanLy_BanHang
     */
    public QuanLy_DoAnUongFrame() {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        sanPhamServiceInterface = new SanPhamServiceImplement();
        viServiceInterface = new ViServiceImplement();
        danhMucServiceInterface = new DanhMucServiceImplement();
        sizeServiceInterface = new SizeServiceImplement();
        comBoServiceInterface = new ComBoServiceImplement();
        comBoChiTietServiceInterface = new ComBoChiTietServiceImplement();
        loadTableDSSP();
        loadCBBFrame();
        loadTableSanPhamComBO();
        loadTableComBo();
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
        //combobox timkiem SP ComBO
        DefaultComboBoxModel tblComboBoxModelLocSPCombo = (DefaultComboBoxModel) cbbDanhMucKhoComBO.getModel();
        List<DanhMuc> listDmComBo = danhMucServiceInterface.getallDM();
        for (DanhMuc danhMuc : listDm) {
            tblComboBoxModelLocSPCombo.addElement(danhMuc.getTenDM());
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
            JOptionPane.showMessageDialog(this, "M?? Kh??ng ???????c ????? tr???ng");
            return false;
        }
        List<SanPhamViewModel> list = sanPhamServiceInterface.getAllSP();
        String maTrung = txtmaDoUong.getText();
        for (SanPhamViewModel sanPhamViewModel : list) {
            if (sanPhamViewModel.getMa().equals(maTrung)) {
                JOptionPane.showMessageDialog(this, "M?? S???n Ph???m ???? T???n T???i");
                return false;
            }
        }
        if (txtTenDoUong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "T??n Kh??ng ???????c ????? tr???ng");
            return false;
        }
        Pattern p = Pattern.compile("^[0-9]+$");
        String txt = txtGia.getText();
        if (!p.matcher(txt).find()) {
            JOptionPane.showMessageDialog(this, "????n Gi?? Ph???i L?? s???");
            return false;
        }
        if (txtTrangThai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tr???ng Th??i kh??ng ???????c ????? tr???ng");
            return false;
        }
        return true;
    }

    public void loadTableSanPhamComBO() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSanPhamDouongComBO.getModel();
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

    void loadTableComBo() {
        DefaultTableModel tblModel = (DefaultTableModel) TblComBo.getModel();
        tblModel.setRowCount(0);
        List<ComBo> listCB = comBoServiceInterface.getallCombo();
        for (ComBo comBo : listCB) {
            tblModel.addRow(new Object[]{
                comBo.getMa(),
                comBo.getTen(),
                comBo.getDonGia(),
                comBo.getTrangThai() == 1 ? "??ang ??p d???ng" : "Kh??ng c??n ??p d???ng"
            });
        }
    }

    public void loadTableComBoChiTiet() {
        DefaultTableModel TblmoModel = (DefaultTableModel) tblComBoChiTiet.getModel();
        TblmoModel.setRowCount(0);
        List<ComBoChiTietViewModel> listCBCT = comBoChiTietServiceInterface.getAllComBo();
        for (ComBoChiTietViewModel comBoChiTietViewModel : listCBCT) {
            TblmoModel.addRow(new Object[]{
                comBoChiTietViewModel.getMa_SP(),
                comBoChiTietViewModel.getTen_SP(),
                comBoChiTietViewModel.getDonGia()
            });
        }
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
        btnThemNhanhVi = new javax.swing.JButton();
        btnThemNhanhDM = new javax.swing.JButton();
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
        btnXoaDoUong = new javax.swing.JButton();
        btnclearFromThongtinSP = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbbDanhMucKhoComBO = new javax.swing.JComboBox<>();
        lblLocDMkho1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamDouongComBO = new javax.swing.JTable();
        lblTimKiemTenSPKho1 = new javax.swing.JLabel();
        txtTimKiemKho1 = new javax.swing.JTextField();
        btnTimKiemKho1 = new javax.swing.JButton();
        btnThemSpVaoComBo = new javax.swing.JButton();
        btnTaoComBo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblComBoChiTiet = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmaComBo = new javax.swing.JTextField();
        txtTenComBo = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblComBo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnTimKiemCombo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMenu.setBackground(new java.awt.Color(204, 255, 255));
        pnlMenu.setPreferredSize(new java.awt.Dimension(190, 721));

        btnBanHang_Menu.setBackground(new java.awt.Color(204, 255, 255));
        btnBanHang_Menu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBanHang_Menu.setText("B??n H??ng");
        btnBanHang_Menu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnBanHang_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang_MenuActionPerformed(evt);
            }
        });

        btnHoaDonMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnHoaDonMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoaDonMenu.setText("H??a ????n");
        btnHoaDonMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnHoaDonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMenuActionPerformed(evt);
            }
        });

        btnDoanUongMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDoanUongMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoanUongMenu.setText("????? ??n, U???ng");
        btnDoanUongMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnDoanUongMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanUongMenuActionPerformed(evt);
            }
        });

        btnNhanVienMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnNhanVienMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVienMenu.setText("Nh??n Vi??n");
        btnNhanVienMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnNhanVienMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienMenuActionPerformed(evt);
            }
        });

        btnKhachHangmenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhachHangmenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHangmenu.setText("Kh??ch H??ng");
        btnKhachHangmenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhachHangmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangmenuActionPerformed(evt);
            }
        });

        btnKhuyenMaiMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnKhuyenMaiMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhuyenMaiMenu.setText("Khuy???n M???i");
        btnKhuyenMaiMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnKhuyenMaiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiMenuActionPerformed(evt);
            }
        });

        btnThongkeMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnThongkeMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongkeMenu.setText("Th??ng k??");
        btnThongkeMenu.setPreferredSize(new java.awt.Dimension(117, 48));
        btnThongkeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeMenuActionPerformed(evt);
            }
        });

        btnDangXuatMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnDangXuatMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuatMenu.setText("????ng Xu???t");
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

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1081, 722));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin ????? ??n, U???ng"));

        lblMaDoUong.setText("M?? ");

        lblTenSp.setText("T??n");

        lblVi.setText("V???");

        lbldanhmucSP.setText("Danh M???c");

        lblSizeSanPham.setText("Size");

        lblTrangthai.setText("Tr???ng Th??i");

        lblGia.setText("????n Gi??");

        btnThemNhanhVi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhanhVi.setText("+");
        btnThemNhanhVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhViActionPerformed(evt);
            }
        });

        btnThemNhanhDM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhanhDM.setText("+");
        btnThemNhanhDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhDMActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                        .addComponent(btnThemNhanhVi)
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
                            .addComponent(btnThemNhanhDM)
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
                            .addComponent(btnThemNhanhDM))
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
                    .addComponent(btnThemNhanhVi)
                    .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh S??ch ????? ??n, U???ng"));

        cbbDanhMucKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucKhoActionPerformed(evt);
            }
        });

        lblLocDMkho.setText("Danh M???c");

        tblSanPhamDouong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M??", "T??n", "????n Gi??", "V???", "Danh M???c", "Size", "Tr???ng Th??i"
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

        lblTimKiemTenSPKho.setText("T??n S???n Ph???m");

        btnTimKiemKho.setText("T??m Ki???m");
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
        btnThemdoUong.setText("Th??m");
        btnThemdoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemdoUongActionPerformed(evt);
            }
        });

        btnXoaDoUong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaDoUong.setText("X??a");
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

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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
                    .addComponent(btnThemdoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnThemdoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclearFromThongtinSP, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("????? ??n U???ng", jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh S??ch ????? ??n, U???ng"));

        cbbDanhMucKhoComBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucKhoComBOActionPerformed(evt);
            }
        });

        lblLocDMkho1.setText("Danh M???c");

        tblSanPhamDouongComBO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M??", "T??n", "????n Gi??", "V???", "Danh M???c", "Size", "Tr???ng Th??i"
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

        lblTimKiemTenSPKho1.setText("T??n S???n Ph???m");

        btnTimKiemKho1.setText("T??m Ki???m");
        btnTimKiemKho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKho1ActionPerformed(evt);
            }
        });

        btnThemSpVaoComBo.setBackground(new java.awt.Color(204, 255, 204));
        btnThemSpVaoComBo.setText("Th??m V??o ComBO");
        btnThemSpVaoComBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpVaoComBoActionPerformed(evt);
            }
        });

        btnTaoComBo.setBackground(new java.awt.Color(204, 255, 204));
        btnTaoComBo.setText("T???o ComBO");
        btnTaoComBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoComBoActionPerformed(evt);
            }
        });

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
                        .addComponent(cbbDanhMucKhoComBO, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnTaoComBo)
                        .addGap(35, 35, 35)
                        .addComponent(btnThemSpVaoComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(266, 266, 266))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocDMkho1)
                    .addComponent(lblTimKiemTenSPKho1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemKho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDanhMucKhoComBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKho1)
                    .addComponent(btnThemSpVaoComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Ti???t Combo"));

        tblComBoChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "M?? S???n Ph???m", "T??n S???n Ph???m", "Gi??", "S??? L?????ng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblComBoChiTiet);

        jButton5.setText("C???p Nh???t");

        jButton6.setText("X??a Kh???i ComBO");

        jButton7.setText("L??m M???i ComBo");

        jLabel1.setText("M?? ComBO");

        jLabel3.setText("T??n ComBO");

        txtmaComBo.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtmaComBo)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenComBo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmaComBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenComBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(41, 41, 41))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh S??ch Combo"));

        TblComBo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M??", "T??n", "Gi?? ComBo", "Tr???ng Th??i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblComBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblComBoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblComBo);

        jLabel2.setText("T??n COmBO");

        btnTimKiemCombo.setText("T??m Ki???m");

        jButton2.setText("X??a ComBO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTimKiemCombo))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemCombo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ComBo ????? Uu???ng", jPanel5);

        javax.swing.GroupLayout pnltongLayout = new javax.swing.GroupLayout(pnltong);
        pnltong.setLayout(pnltongLayout);
        pnltongLayout.setHorizontalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnltongLayout.setVerticalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        new QuanLy_HoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHoaDonMenuActionPerformed

    private void btnDoanUongMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanUongMenuActionPerformed
        // TODO add your handling code here:
        new QuanLy_DoAnUongFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoanUongMenuActionPerformed

    private void btnNhanVienMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienMenuActionPerformed
        // TODO add your handling code here:
        new QuanLyNhanVienFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVienMenuActionPerformed

    private void btnKhachHangmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangmenuActionPerformed
        // TODO add your handling code here:
        new Quanly_Khachhang().setVisible(true);
        this.dispose();
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

    }//GEN-LAST:event_btnTimKiemKhoActionPerformed

    private void btnThemdoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemdoUongActionPerformed
        if (validatFromSP() == true) {
            SanPham sanPham = new SanPham();

            sanPham.setMa(txtmaDoUong.getText());
            sanPham.setTen(txtTenDoUong.getText());
            sanPham.setDonGia(txtGia.getText());
            Vi vi = (Vi) cbbVi.getSelectedItem();

            sanPham.setId_Vi(vi);
            DanhMuc nameDM = (DanhMuc) cbbDanhmucSp.getSelectedItem();
            sanPham.setId_DanhMuc(nameDM);
            Size maSize = (Size) cbbSize.getSelectedItem();
            sanPham.setId_size(maSize);

            String trangThai = txtTrangThai.getText();
            if (trangThai.equalsIgnoreCase("C??n H??ng")) {
                sanPham.setTrangThai(1);
            }
            if (trangThai.equalsIgnoreCase("H???t H??ng")) {
                sanPham.setTrangThai(0);
            }
            System.out.println(sanPham);
            try {
                sanPhamServiceInterface.addSanPham(sanPham);
                loadTableDSSP();
                clearfromSanPham();
                JOptionPane.showMessageDialog(this, "Th??m Th??nh C??ng");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Th??m kh??ng Th??nh C??ng");

                e.printStackTrace();
            }
        }
    }

    private void btnSuaDoUongActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {

            SanPham sanPham = new SanPham();

            sanPham.setMa(txtmaDoUong.getText());
            sanPham.setTen(txtTenDoUong.getText());
            sanPham.setDonGia(txtGia.getText());
            Vi vi = (Vi) cbbVi.getSelectedItem();

            sanPham.setId_Vi(vi);
            DanhMuc nameDM = (DanhMuc) cbbDanhmucSp.getSelectedItem();
            sanPham.setId_DanhMuc(nameDM);
            Size maSize = (Size) cbbSize.getSelectedItem();
            sanPham.setId_size(maSize);

            String trangThai = txtTrangThai.getText();
            if (trangThai.equalsIgnoreCase("C??n H??ng")) {
                sanPham.setTrangThai(1);
            }
            if (trangThai.equalsIgnoreCase("H???t H??ng")) {
                sanPham.setTrangThai(0);
            }
            
            System.out.println(sanPham);
            try {
                sanPhamServiceInterface.updateSanPham(sanPham);
                loadTableDSSP();
                clearfromSanPham();
                JOptionPane.showMessageDialog(this, "S???a Th??nh C??ng");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "S???a kh??ng Th??nh C??ng");

                e.printStackTrace();
            }

        }
        else {
            JOptionPane.showMessageDialog(this, "Ch???n M???c C???n S???a");
            return;
        }
        

    }//GEN-LAST:event_btnThemdoUongActionPerformed

    private void btnXoaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoUongActionPerformed
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {
            SanPham sanPham = new SanPham();
            sanPham.setMa(txtmaDoUong.getText());
            try {
                sanPhamServiceInterface.deleteSanPham(sanPham);
                loadTableDSSP();
                clearfromSanPham();
                JOptionPane.showMessageDialog(this, "X??a Th??nh C??ng");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ch???n M???c C???n X??a");
        }
    }//GEN-LAST:event_btnXoaDoUongActionPerformed


    private void btnclearFromThongtinSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearFromThongtinSPActionPerformed
        // TODO add your handling code here:
        clearfromSanPham();
//        LoadTableDoUong();
    }//GEN-LAST:event_btnclearFromThongtinSPActionPerformed

    private void cbbDanhMucKhoComBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucKhoComBOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDanhMucKhoComBOActionPerformed

    private void tblSanPhamDouongComBOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamDouongComBOMouseClicked
        // TODO add your handling code here:
        int row = tblSanPhamDouongComBO.getSelectedRow();
        if (row >= 0) {
            SanPham sp = new SanPham();
            String maSP = (String) tblSanPhamDouongComBO.getValueAt(row, 0);
            List<SanPhamViewModel> list = sanPhamServiceInterface.getAllSP();
            for (SanPhamViewModel sanPhamViewModel : list) {
                if (sanPhamViewModel.getMa().equals(maSP)) {
                    sp.setId(sanPhamViewModel.getId());
                }
            }

        }
    }//GEN-LAST:event_tblSanPhamDouongComBOMouseClicked

    private void btnTimKiemKho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemKho1ActionPerformed

    private void btnThemNhanhViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhViActionPerformed
        new QuanLyViFrame().setVisible(true);
    }//GEN-LAST:event_btnThemNhanhViActionPerformed

    private void btnThemNhanhDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhDMActionPerformed
        // TODO add your handling code here:
        new QuanLyDanhMucFrame().setVisible(true);
        loadCBBFrame();
    }//GEN-LAST:event_btnThemNhanhDMActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new QuanLySizeFrame().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTaoComBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoComBoActionPerformed
        // TODO add your handling code here:
        ComBo comBo = new ComBo();
        List<ComBo> listCb = comBoServiceInterface.getallCombo();
        int listsize = listCb.size();
        String ma;
        ma = "CB" + listsize++;
        comBo.setMa(ma);
        comBo.setTrangThai(1);
        try {
            comBoServiceInterface.addComBo(comBo);
            loadTableComBo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTaoComBoActionPerformed

    private void TblComBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblComBoMouseClicked
        // TODO add your handling code here:
        int row = TblComBo.getSelectedRow();
        DefaultTableModel tblModel = (DefaultTableModel) tblComBoChiTiet.getModel();
        tblModel.setRowCount(0);
        if (row >= 0) {
            txtmaComBo.setText((String) TblComBo.getValueAt(row, 0));
            txtTenComBo.setText((String) TblComBo.getValueAt(row, 1));
            String maCB = (String) TblComBo.getValueAt(row, 0);
            List<ComBoChiTietViewModel> list = comBoChiTietServiceInterface.getAllComBo();
            for (ComBoChiTietViewModel comBoChiTietViewModel : list) {
                if (comBoChiTietViewModel.getMa_CB().equals(maCB)) {
                    tblModel.addRow(new Object[]{
                        comBoChiTietViewModel.getMa_SP(),
                        comBoChiTietViewModel.getTen_SP(),
                        comBoChiTietViewModel.getDonGia(),
                        1
                    });
                }
            }
        }
    }//GEN-LAST:event_TblComBoMouseClicked

    private void btnThemSpVaoComBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpVaoComBoActionPerformed
        // TODO add your handling code here:
        int row = tblSanPhamDouongComBO.getSelectedRow();
        if (row >= 0) {
            ComBoChiTiet comBoChiTiet = new ComBoChiTiet();
            String maComBO = txtmaComBo.getText();
            List<ComBo> listCB = comBoServiceInterface.getallCombo();
            for (ComBo comBo : listCB) {
                if (comBo.getMa().equals(maComBO)) {
                    comBoChiTiet.setId_CB(comBo.getId());
                }
            }
            String maSP = (String) tblSanPhamDouongComBO.getValueAt(row, 0);
            List<SanPhamViewModel> list = sanPhamServiceInterface.getAllSP();
            for (SanPhamViewModel sanPhamViewModel : list) {
                if (sanPhamViewModel.getMa().equals(maSP)) {
                    comBoChiTiet.setId_SP(sanPhamViewModel.getId());
                }
            }
            System.out.println(comBoChiTiet);
            try {
                comBoChiTietServiceInterface.addComBo(comBoChiTiet);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemSpVaoComBoActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblSanPhamDouong.getSelectedRow();
        if (row >= 0) {
            
                SanPham sanPham = new SanPham();

                sanPham.setMa(txtmaDoUong.getText());
                sanPham.setTen(txtTenDoUong.getText());
                sanPham.setDonGia(txtGia.getText());
                Vi vi = (Vi) cbbVi.getSelectedItem();

                sanPham.setId_Vi(vi);
                DanhMuc nameDM = (DanhMuc) cbbDanhmucSp.getSelectedItem();
                sanPham.setId_DanhMuc(nameDM);
                Size maSize = (Size) cbbSize.getSelectedItem();
                sanPham.setId_size(maSize);

                String trangThai = txtTrangThai.getText();
                if (trangThai.equalsIgnoreCase("C??n H??ng")) {
                    sanPham.setTrangThai(1);
                }
                if (trangThai.equalsIgnoreCase("H???t H??ng")) {
                    sanPham.setTrangThai(0);
                }
                System.out.println(sanPham);
                try {
                    sanPhamServiceInterface.updateSanPham(sanPham);
                    loadTableDSSP();
                    clearfromSanPham();
                    JOptionPane.showMessageDialog(this, "S???a Th??nh C??ng");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "S???a kh??ng Th??nh C??ng");

                    e.printStackTrace();
                }
            
        } else {
            JOptionPane.showMessageDialog(this, "Ch???n M???c C???n S???a");
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

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
    private javax.swing.JTable TblComBo;
    private javax.swing.JButton btnBanHang_Menu;
    private javax.swing.JButton btnDangXuatMenu;
    private javax.swing.JButton btnDoanUongMenu;
    private javax.swing.JButton btnHoaDonMenu;
    private javax.swing.JButton btnKhachHangmenu;
    private javax.swing.JButton btnKhuyenMaiMenu;
    private javax.swing.JButton btnNhanVienMenu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoComBo;
    private javax.swing.JButton btnThemNhanhDM;
    private javax.swing.JButton btnThemNhanhVi;
    private javax.swing.JButton btnThemSpVaoComBo;
    private javax.swing.JButton btnThemdoUong;
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnTimKiemCombo;
    private javax.swing.JButton btnTimKiemKho;
    private javax.swing.JButton btnTimKiemKho1;
    private javax.swing.JButton btnXoaDoUong;
    private javax.swing.JButton btnclearFromThongtinSP;
    private javax.swing.JComboBox<String> cbbDanhMucKho;
    private javax.swing.JComboBox<String> cbbDanhMucKhoComBO;
    private javax.swing.JComboBox<String> cbbDanhmucSp;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbVi;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
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
    private javax.swing.JTable tblComBoChiTiet;
    private javax.swing.JTable tblSanPhamDouong;
    private javax.swing.JTable tblSanPhamDouongComBO;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenComBo;
    private javax.swing.JTextField txtTenDoUong;
    private javax.swing.JTextField txtTimKiemKho;
    private javax.swing.JTextField txtTimKiemKho1;
    private javax.swing.JTextField txtTrangThai;
    private javax.swing.JTextField txtmaComBo;
    private javax.swing.JTextField txtmaDoUong;
    // End of variables declaration//GEN-END:variables
}
