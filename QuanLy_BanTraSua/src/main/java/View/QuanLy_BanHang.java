package View;

import DomainModel.ComBo;
import DomainModel.DanhMuc;
import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.KhuyenMai;
import DomainModel.NhanVien;
import DomainModel.Vi;
import Service.Implement.ComBoServiceImplement;
import Service.Implement.DanhMucServiceImplement;
import Service.Implement.HoaDonCtServiceImplement;
import Service.Implement.HoaDonServiceImplement;
import Service.Implement.KhachhangServiceImplement;
import Service.Implement.KhuyenmaiServiceImplement;
import Service.Implement.SanPhamServiceImplement;
import Service.Implement.ViServiceImplement;
import Service.Interface.ComBoServiceInterface;
import Service.Interface.DanhMucServiceInterface;
import Service.Interface.HoaDonCtServiceInterface;
import Service.Interface.HoaDonServiceInterface;
import Service.Interface.KhachhangServiceInterface;
import Service.Interface.KhuyenmaiServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.ViServiceInterface;
import Utility.Validate;
import ViewModel.HoaDonCTVmodel;
import ViewModel.HoaDonVModel;
import ViewModel.KhachhangViewmodel;
import ViewModel.KhuyenmaiViewModel;
import ViewModel.SanPhamViewModel;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLy_BanHang extends javax.swing.JFrame {

    DefaultTableModel tbm;
    HoaDonServiceInterface hdsvbhitf = new HoaDonServiceImplement();
    DefaultTableModel tblModelComBo;
    DefaultTableModel tbmHDCT;
    HoaDonCtServiceInterface hdctitf = new HoaDonCtServiceImplement();
    ComBoServiceInterface comBoServiceInterface = new ComBoServiceImplement();
    SanPhamServiceInterface sp_itf = new SanPhamServiceImplement();
    DanhMucServiceInterface dm_itf = new DanhMucServiceImplement();
    ViServiceInterface vi_itf = new ViServiceImplement();
    KhachhangServiceInterface KHITF = new KhachhangServiceImplement();
    KhuyenmaiServiceInterface KMSV = new KhuyenmaiServiceImplement();
    //QuanLy_BanHang Thread = new QuanLy_BanHang();
    /**
     * Creates new form QuanLy_BanHang
     */
    public QuanLy_BanHang() {
        initComponents();
        
        tbm = (DefaultTableModel) tblDSHoaDonBH.getModel();
        tbmHDCT = (DefaultTableModel) tblSanPhamOrder.getModel();
        tblModelComBo = (DefaultTableModel) tblComBoSanPham.getModel();
        
        filltableHDBH();
        filltotablehdct();
        loadTableComBo();
        fillSanphamBanhang();
        loadCBBFrame();
    }

    void loadTableComBo() {
        tblModelComBo.setRowCount(0);
        List<ComBo> listCB = comBoServiceInterface.getallCombo();
        for (ComBo comBo : listCB) {
            tblModelComBo.addRow(new Object[]{
                comBo.getMa(),
                comBo.getTen(),
                comBo.getDonGia(),
                comBo.getTrangThai()
            });
        }

    }

    public void filltableHDBH() {
        tbm.setRowCount(0);
        for (HoaDonVModel x : hdsvbhitf.getListhdbh()) {
            tbm.addRow(new Object[]{x.getMa(), x.getMa_nv(), x.getNgayTao(), x.getTrangThai()});
        }

    }

    public void filltotablehdct() {
        tbmHDCT.setRowCount(0);
        for (HoaDonCTVmodel x : hdctitf.gethdct()) {
            tbmHDCT.addRow(new Object[]{x.getMa_SP(), x.getTenSP(), x.getDonGia(), x.getSL_Mua(), x.getID_VI(), x.getID_SIZE(), x.getID_dM()});
        }
    }

    public void loadCBBFrame() {
        DefaultComboBoxModel tblComboBoxModelDMKho = (DefaultComboBoxModel) cbbLocSanPham.getModel();
        List<DanhMuc> listDmKho = dm_itf.getallDM();
        for (DanhMuc danhMuc : listDmKho) {
            tblComboBoxModelDMKho.addElement(danhMuc.getTenDM());
        }

        DefaultComboBoxModel tblComboBoxModelVI = (DefaultComboBoxModel) cbbVi.getModel();
        List<Vi> listVi = vi_itf.getAllVi();
        for (Vi vi : listVi) {
            tblComboBoxModelVI.addElement(vi.getTen());
        }
    }

    public void fillSanphamBanhang() {

        DefaultTableModel tblModel = (DefaultTableModel) tblDSSanPham.getModel();
        tblModel.setRowCount(0);
        List<SanPhamViewModel> list = sp_itf.getAllSP();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupmenu = new javax.swing.JPopupMenu();
        MNTThemSoLuong = new javax.swing.JMenuItem();
        MNTGiamSoLuong = new javax.swing.JMenuItem();
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
        pnlGiaoDien = new javax.swing.JPanel();
        pnlDSHoaDonBH = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSHoaDonBH = new javax.swing.JTable();
        btnXoaSPOrderBH1 = new javax.swing.JButton();
        pnlSanPhamOrderBH = new javax.swing.JPanel();
        btnXoaSPOrderBH = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSanPhamOrder = new javax.swing.JTable();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblMaHoaDonBH = new javax.swing.JLabel();
        btnTaoHoaDonBH = new javax.swing.JButton();
        lblMaNhanVienBH = new javax.swing.JLabel();
        lblNgayTaoHDBH = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenKhachHangBH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTienKhacDuaBH = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblTongTienBH = new javax.swing.JLabel();
        lblCanThanhToanBH = new javax.swing.JLabel();
        btnThanhToanBH = new javax.swing.JButton();
        lblTienTraLaiBH = new javax.swing.JLabel();
        btnHuyThanhToan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JTextField();
        btnaddsdt = new javax.swing.JButton();
        cboMaKM = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSSanPham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTimkiemSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btTimkiemSP = new javax.swing.JButton();
        cbbLocSanPham = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbVi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThemSPBH = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblComBoSanPham = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pnlAnhComBo = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnChonComBo = new javax.swing.JButton();

        MNTThemSoLuong.setText("Thêm Số Lượng");
        popupmenu.add(MNTThemSoLuong);

        MNTGiamSoLuong.setText("Giam Số Lượng");
        popupmenu.add(MNTGiamSoLuong);

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
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pnlDSHoaDonBH.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chờ"));

        tblDSHoaDonBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Mã Nhân Viên", "Ngày Tạo", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSHoaDonBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHoaDonBHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSHoaDonBH);

        btnXoaSPOrderBH1.setBackground(new java.awt.Color(255, 153, 153));
        btnXoaSPOrderBH1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaSPOrderBH1.setText("Hủy Hóa Đơn");
        btnXoaSPOrderBH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPOrderBH1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDSHoaDonBHLayout = new javax.swing.GroupLayout(pnlDSHoaDonBH);
        pnlDSHoaDonBH.setLayout(pnlDSHoaDonBHLayout);
        pnlDSHoaDonBHLayout.setHorizontalGroup(
            pnlDSHoaDonBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDSHoaDonBHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDSHoaDonBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDSHoaDonBHLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaSPOrderBH1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDSHoaDonBHLayout.setVerticalGroup(
            pnlDSHoaDonBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSHoaDonBHLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSPOrderBH1)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pnlSanPhamOrderBH.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm order"));

        btnXoaSPOrderBH.setBackground(new java.awt.Color(255, 153, 153));
        btnXoaSPOrderBH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaSPOrderBH.setText("Xóa sản phẩm");
        btnXoaSPOrderBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPOrderBHActionPerformed(evt);
            }
        });

        tblSanPhamOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá", "Số Lượng", "Vị", "Size", "Danh Mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSanPhamOrderMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblSanPhamOrder);

        javax.swing.GroupLayout pnlSanPhamOrderBHLayout = new javax.swing.GroupLayout(pnlSanPhamOrderBH);
        pnlSanPhamOrderBH.setLayout(pnlSanPhamOrderBHLayout);
        pnlSanPhamOrderBHLayout.setHorizontalGroup(
            pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoaSPOrderBH, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlSanPhamOrderBHLayout.setVerticalGroup(
            pnlSanPhamOrderBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamOrderBHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSPOrderBH)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pnlThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));

        jLabel1.setText("Mã hóa đơn");

        jLabel17.setText("Mã nhân viên");

        jLabel18.setText("Ngày Tạo");

        lblMaHoaDonBH.setText("HD1");

        btnTaoHoaDonBH.setBackground(new java.awt.Color(204, 255, 153));
        btnTaoHoaDonBH.setText("Chờ Thanh Toán");
        btnTaoHoaDonBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonBHActionPerformed(evt);
            }
        });

        lblMaNhanVienBH.setText("NV1");

        lblNgayTaoHDBH.setText("dd/mm/yyy");

        jLabel19.setText("Tên khách hàng");

        txtTenKhachHangBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangBHActionPerformed(evt);
            }
        });

        jLabel20.setText("Mã hhuyến mại");

        jLabel21.setText("Tổng tiền");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("VND");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("VND");

        jLabel25.setText("Cần thanh toán");

        jLabel27.setText("Trả lại");

        txtTienKhacDuaBH.setText("0");
        txtTienKhacDuaBH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhacDuaBHCaretUpdate(evt);
            }
        });
        txtTienKhacDuaBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhacDuaBHActionPerformed(evt);
            }
        });
        txtTienKhacDuaBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienKhacDuaBHKeyTyped(evt);
            }
        });

        jLabel28.setText("Tiền khách đưa");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("VND");

        lblTongTienBH.setText("0");

        lblCanThanhToanBH.setText("0");

        btnThanhToanBH.setBackground(new java.awt.Color(153, 255, 153));
        btnThanhToanBH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToanBH.setText("Thanh Toán");
        btnThanhToanBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanBHActionPerformed(evt);
            }
        });

        lblTienTraLaiBH.setText("0");

        btnHuyThanhToan.setBackground(new java.awt.Color(153, 153, 255));
        btnHuyThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyThanhToan.setText("Hủy Thanh Toán");
        btnHuyThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyThanhToanActionPerformed(evt);
            }
        });

        jLabel9.setText("Số ĐT");

        btnaddsdt.setText("+");
        btnaddsdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddsdtActionPerformed(evt);
            }
        });

        cboMaKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ma Khuyen Mai" }));
        cboMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinHoaDonLayout = new javax.swing.GroupLayout(pnlThongTinHoaDon);
        pnlThongTinHoaDon.setLayout(pnlThongTinHoaDonLayout);
        pnlThongTinHoaDonLayout.setHorizontalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNgayTaoHDBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(lblMaNhanVienBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMaHoaDonBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaoHoaDonBH))
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addComponent(txtSDTKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnaddsdt)
                                .addGap(3, 3, 3))))
                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addComponent(btnHuyThanhToan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(74, 74, 74)
                                .addComponent(lblTienTraLaiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTongTienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCanThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKhacDuaBH, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(cboMaKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnlThongTinHoaDonLayout.setVerticalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblMaHoaDonBH)
                    .addComponent(btnTaoHoaDonBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblMaNhanVienBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayTaoHDBH)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddsdt))
                .addGap(9, 9, 9)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cboMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21))
                                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(lblTongTienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel19))
                .addGap(14, 14, 14)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel22)
                    .addComponent(lblCanThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTienKhacDuaBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(lblTienTraLaiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThanhToanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyThanhToan))
                .addGap(20, 20, 20))
        );

        tblDSSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Vị", "Đơn Giá", "Danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDSSanPham);

        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setText("Danh Mục");

        btTimkiemSP.setText("Tìm Kiếm");
        btTimkiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimkiemSPActionPerformed(evt);
            }
        });

        cbbLocSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh mục" }));
        cbbLocSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocSanPhamActionPerformed(evt);
            }
        });

        jLabel4.setText("Vị");

        cbbVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vị", " " }));
        cbbVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbViActionPerformed(evt);
            }
        });

        jLabel5.setText("Ảnh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        btnThemSPBH.setBackground(new java.awt.Color(153, 255, 153));
        btnThemSPBH.setText("Thêm Sản Phẩm Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(153, 153, 153)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimkiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btTimkiemSP)
                                .addGap(18, 18, 18)
                                .addComponent(cbbLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(btnThemSPBH))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimkiemSP)
                    .addComponent(cbbLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnThemSPBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Danh Sách Đồ Ă Uống", jPanel1);

        tblComBoSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã ComBo", "Tên ComBo", "Giá", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblComBoSanPham);

        jLabel6.setText("Tên ComBO");

        jButton2.setText("Tìm Kiếm");

        jLabel7.setText("Ảnh");

        javax.swing.GroupLayout pnlAnhComBoLayout = new javax.swing.GroupLayout(pnlAnhComBo);
        pnlAnhComBo.setLayout(pnlAnhComBoLayout);
        pnlAnhComBoLayout.setHorizontalGroup(
            pnlAnhComBoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        pnlAnhComBoLayout.setVerticalGroup(
            pnlAnhComBoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        );

        btnChonComBo.setBackground(new java.awt.Color(153, 255, 0));
        btnChonComBo.setText("Chọn ComBO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(174, 174, 174)
                        .addComponent(btnChonComBo))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAnhComBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel7)
                    .addComponent(btnChonComBo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAnhComBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Danh Sách ComBO", jPanel2);

        javax.swing.GroupLayout pnlGiaoDienLayout = new javax.swing.GroupLayout(pnlGiaoDien);
        pnlGiaoDien.setLayout(pnlGiaoDienLayout);
        pnlGiaoDienLayout.setHorizontalGroup(
            pnlGiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGiaoDienLayout.createSequentialGroup()
                .addGroup(pnlGiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSanPhamOrderBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDSHoaDonBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlGiaoDienLayout.setVerticalGroup(
            pnlGiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiaoDienLayout.createSequentialGroup()
                .addGroup(pnlGiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlGiaoDienLayout.createSequentialGroup()
                        .addComponent(pnlDSHoaDonBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSanPhamOrderBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlGiaoDienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnltongLayout = new javax.swing.GroupLayout(pnltong);
        pnltong.setLayout(pnltongLayout);
        pnltongLayout.setHorizontalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGiaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnltongLayout.setVerticalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnltongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGiaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnHuyThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (hdctitf.HuyThanhToan(lblMaHoaDonBH.getText()) == false) {
                if (hdsvbhitf.HuyThanhToan(lblMaHoaDonBH.getText()) == true) {
                    JOptionPane.showMessageDialog(pnlAnhComBo, "Huy Thanh Toan Thanh Cong");
                    hdsvbhitf.getListhdbh();
                    filltableHDBH();
                    filltotablehdct();
                    return;
                } else {
                    JOptionPane.showMessageDialog(pnlAnhComBo, "Ban chua chon hoa don can huy");
                    filltableHDBH();
                    filltotablehdct();
                    return;
                }
            }
            if (hdctitf.HuyThanhToan(lblMaHoaDonBH.getText()) == true) {
                if (hdsvbhitf.HuyThanhToan(lblMaHoaDonBH.getText()) == true) {
                    JOptionPane.showMessageDialog(pnlAnhComBo, "Huy Thanh Toan Thanh Cong");
                    hdsvbhitf.getListhdbh();
                    filltableHDBH();
                    filltotablehdct();
                    return;
                } else {
                    JOptionPane.showMessageDialog(pnlAnhComBo, "Huy Thanh Toan That Bai");
                    filltableHDBH();
                    filltotablehdct();
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(pnlAnhComBo, "Huy Thanh Toan That Bai");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    private void txtTenKhachHangBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangBHActionPerformed

    private void txtMaKhuyenMaiBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhuyenMaiBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhuyenMaiBHActionPerformed

    private void tblDSHoaDonBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHoaDonBHMouseClicked
        int index = tblDSHoaDonBH.getSelectedRow();
        lblMaHoaDonBH.setText(tblDSHoaDonBH.getValueAt(index, 0).toString());
        lblMaNhanVienBH.setText(tblDSHoaDonBH.getValueAt(index, 1).toString());
        lblNgayTaoHDBH.setText(tblDSHoaDonBH.getValueAt(index, 2).toString());

    }//GEN-LAST:event_tblDSHoaDonBHMouseClicked

    private void btnXoaSPOrderBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPOrderBHActionPerformed

        try {

            HoaDonChiTiet hdct = new HoaDonChiTiet();
            for (int i = 0; i < hdctitf.gethdct().size(); i++) {
                if (hdctitf.gethdct().get(i).getMa_SP().equals(tblSanPhamOrder.getValueAt(tblSanPhamOrder.getSelectedRow(), 0))) {
                    hdct.setId(hdctitf.gethdct().get(i).getId());
                }
            }
            if (hdctitf.deleteHDCT(hdct)) {
                filltotablehdct();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnXoaSPOrderBHActionPerformed

    private void btnTaoHoaDonBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonBHActionPerformed
        try {
            NhanVien nv = new NhanVien();
            nv.setID(1);
            HoaDon hd = new HoaDon();
            hd.setMa("HD0" + Math.round(Math.random() * 1000));
            hd.setId_NV(nv);
            hd.setNgayTao(new Date());
            hd.setTrangThai(0);
            System.out.println(hd);
            hdsvbhitf.addHoaDon(hd);
            filltableHDBH();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTaoHoaDonBHActionPerformed

    private void btnXoaSPOrderBH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPOrderBH1ActionPerformed
        try {
            HoaDon hd = new HoaDon();
            hdsvbhitf.Delete(hd);
            filltableHDBH();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaSPOrderBH1ActionPerformed

    private void tblSanPhamOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamOrderMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && tblSanPhamOrder.getSelectedRowCount() != 0) {
                popupmenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }

    }//GEN-LAST:event_tblSanPhamOrderMouseReleased
    private void btnThanhToanBHActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            if (hdsvbhitf.ThanhToan(lblMaHoaDonBH.getText()) == true) {
                JOptionPane.showMessageDialog(pnlAnhComBo, "Thanh Cong");

                filltableHDBH();
                filltotablehdct();
            } else {
                JOptionPane.showMessageDialog(pnlAnhComBo, "Ban chua chon hoa don can thanh toan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void btnaddsdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddsdtActionPerformed
        // TODO add your handling code here:
        KhachhangViewmodel KHVMD = new KhachhangViewmodel();
        KHVMD = KHITF.getBySDT(txtSDTKH.getText());
        Validate vl = new Validate();
        if (!vl.checkSDT(txtSDTKH.getText())) {
            JOptionPane.showMessageDialog(rootPane, "So dien thoai khach hang khong hop le");
            return;
        }
        try {
            if (Objects.isNull(KHVMD)) {
            
            if ("".equals(txtTenKhachHangBH.getText().trim())) {
                JOptionPane.showMessageDialog(rootPane, "Khach hang moi vui long nhap ten khach hang");
                return;
            } else {
                
                KHITF.addSDTKhachHang(txtSDTKH.getText(), txtTenKhachHangBH.getText());
                JOptionPane.showMessageDialog(rootPane, "Khach hang moi da duoc them");

                return;
            }

        } else {
            txtTenKhachHangBH.setText(KHVMD.getHoTen());
            List<KhuyenmaiViewModel> ListKM = new ArrayList<>();
            ListKM = KMSV.getMaKM();
            for (KhuyenmaiViewModel km : ListKM) {
                cboMaKM.addItem(km.getMa());
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnaddsdtActionPerformed

    private void btTimkiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimkiemSPActionPerformed
        List<SanPhamViewModel> lst_spvmd = new ArrayList<>();
        for (int i = 0; i < sp_itf.getAllSP().size(); i++) {
            if (sp_itf.getAllSP().get(i).getTen().equalsIgnoreCase(txtTimkiemSP.getText())) {
                lst_spvmd.add(sp_itf.getAllSP().get(i));
                JOptionPane.showMessageDialog(this, "Tìm thành công!");
                DefaultTableModel tblModel = (DefaultTableModel) tblDSSanPham.getModel();

                tblModel.setRowCount(0);
                for (SanPhamViewModel sanPhamViewModel : lst_spvmd) {
                    tblModel.addRow(new Object[]{
                        sanPhamViewModel.getMa(),
                        sanPhamViewModel.getTen(),
                        sanPhamViewModel.getTenVi(),
                        sanPhamViewModel.getDonGia(),
                        sanPhamViewModel.getTenDM()

                    });
                }

                break;
            } else {
                JOptionPane.showMessageDialog(this, "Nhập sai tên sản phẩm");
                txtTimkiemSP.setText(null);
                break;
            }
        }


    }//GEN-LAST:event_btTimkiemSPActionPerformed

    private void cbbLocSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocSanPhamActionPerformed
        // TODO add your handling code here:
        // DAnh mục  
        String nameDM = (String) cbbLocSanPham.getSelectedItem();
        List<DanhMuc> listdm = dm_itf.getallDM();
        List<SanPhamViewModel> lstsp_vmd = new ArrayList<>();

        if (nameDM.equalsIgnoreCase("Danh mục")) {
            lstsp_vmd = sp_itf.getAllSP();
        } else {
            for (DanhMuc danhMuc : listdm) {
                if (danhMuc.getTenDM().equalsIgnoreCase(nameDM)) {
                    lstsp_vmd = sp_itf.locDanhmuc(danhMuc.getId());
                }
            }
        }

        DefaultTableModel tblModel = (DefaultTableModel) tblDSSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModel sanPhamViewModel : lstsp_vmd) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMa(),
                sanPhamViewModel.getTen(),
                sanPhamViewModel.getTenVi(),
                sanPhamViewModel.getDonGia(),
                sanPhamViewModel.getTenDM()

            });
        }

    }//GEN-LAST:event_cbbLocSanPhamActionPerformed

    private void cbbViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbViActionPerformed
        // TODO add your handling code here:

        String nameVi = (String) cbbVi.getSelectedItem();
        List<Vi> lisVi = vi_itf.getAllVi();
        List<SanPhamViewModel> lstsp_vmd = new ArrayList<>();

        if (nameVi.equalsIgnoreCase("Vị")) {
            lstsp_vmd = sp_itf.getAllSP();
        } else {
            for (Vi vi : lisVi) {
                if (vi.getTen().equalsIgnoreCase(nameVi)) {
                    lstsp_vmd = sp_itf.locDanhmuc(vi.getId());
                }
            }
        }

        DefaultTableModel tblModel = (DefaultTableModel) tblDSSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModel sanPhamViewModel : lstsp_vmd) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMa(),
                sanPhamViewModel.getTen(),
                sanPhamViewModel.getTenVi(),
                sanPhamViewModel.getDonGia(),
                sanPhamViewModel.getTenDM()

            });
        }


    }//GEN-LAST:event_cbbViActionPerformed

    private void cboMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKMActionPerformed
        // TODO add your handling code here:
        List<KhuyenmaiViewModel> ListKM = new ArrayList<>();
            ListKM = KMSV.getMaKM();
            for (KhuyenmaiViewModel km : ListKM) {
                if(km.getMa().equals(cboMaKM.getSelectedItem())){
                    double CanThanhToan = Double.valueOf(lblTongTienBH.getText()) - km.getSoTienGiam();
                    lblCanThanhToanBH.setText(String.valueOf(CanThanhToan));
                }else{
                    lblCanThanhToanBH.setText(lblTongTienBH.getText());
                }
            }
    }//GEN-LAST:event_cboMaKMActionPerformed

    private void txtTienKhacDuaBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhacDuaBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhacDuaBHActionPerformed

    private void txtTienKhacDuaBHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhacDuaBHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhacDuaBHKeyTyped

    private void txtTienKhacDuaBHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhacDuaBHCaretUpdate
        // TODO add your handling code here:
        
        double TienTraLai = Double.parseDouble(txtTienKhacDuaBH.getText()) - Double.parseDouble(lblCanThanhToanBH.getText());
        lblTienTraLaiBH.setText(String.valueOf(TienTraLai));
    }//GEN-LAST:event_txtTienKhacDuaBHCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
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
            java.util.logging.Logger.getLogger(QuanLy_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy_BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy_BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MNTGiamSoLuong;
    private javax.swing.JMenuItem MNTThemSoLuong;
    private javax.swing.JButton btTimkiemSP;
    private javax.swing.JButton btnBanHang_Menu;
    private javax.swing.JButton btnChonComBo;
    private javax.swing.JButton btnDangXuatMenu;
    private javax.swing.JButton btnDoanUongMenu;
    private javax.swing.JButton btnHoaDonMenu;
    private javax.swing.JButton btnHuyThanhToan;
    private javax.swing.JButton btnKhachHangmenu;
    private javax.swing.JButton btnKhuyenMaiMenu;
    private javax.swing.JButton btnNhanVienMenu;
    private javax.swing.JButton btnTaoHoaDonBH;
    private javax.swing.JButton btnThanhToanBH;
    private javax.swing.JButton btnThemSPBH;
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnXoaSPOrderBH;
    private javax.swing.JButton btnXoaSPOrderBH1;
    private javax.swing.JButton btnaddsdt;
    private javax.swing.JComboBox<String> cbbLocSanPham;
    private javax.swing.JComboBox<String> cbbVi;
    private javax.swing.JComboBox<String> cboMaKM;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCanThanhToanBH;
    private javax.swing.JLabel lblMaHoaDonBH;
    private javax.swing.JLabel lblMaNhanVienBH;
    private javax.swing.JLabel lblNgayTaoHDBH;
    private javax.swing.JLabel lblTienTraLaiBH;
    private javax.swing.JLabel lblTongTienBH;
    private javax.swing.JPanel pnlAnhComBo;
    private javax.swing.JPanel pnlDSHoaDonBH;
    private javax.swing.JPanel pnlGiaoDien;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSanPhamOrderBH;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private javax.swing.JPanel pnltong;
    private javax.swing.JPopupMenu popupmenu;
    private javax.swing.JTable tblComBoSanPham;
    private javax.swing.JTable tblDSHoaDonBH;
    private javax.swing.JTable tblDSSanPham;
    private javax.swing.JTable tblSanPhamOrder;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtTenKhachHangBH;
    private javax.swing.JTextField txtTienKhacDuaBH;
    private javax.swing.JTextField txtTimkiemSP;
    // End of variables declaration//GEN-END:variables

//    public void run() {
//        while (true) {   
//            double TraLai = Double.valueOf(txtTienKhacDuaBH.getText()) - Double.valueOf(lblCanThanhToanBH.getText());
//            lblTienTraLaiBH.setText(String.valueOf(TraLai));
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(QuanLy_BanHang.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
