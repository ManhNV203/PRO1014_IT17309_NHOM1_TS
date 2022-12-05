/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.Implement.HoaDonCtServiceImplement;
import Service.Implement.HoaDonServiceImplement;
import Service.Interface.HoaDonCtServiceInterface;
import Service.Interface.HoaDonServiceInterface;
import ViewModel.HoaDonCTVmodel;
import ViewModel.HoaDonVModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLy_HoaDon extends javax.swing.JFrame {
    DefaultTableModel tbm1;
    HoaDonCtServiceInterface hdctsv = new HoaDonCtServiceImplement();
    
    DefaultTableModel tbm;
    HoaDonServiceInterface hdsv = new HoaDonServiceImplement();
    
    public QuanLy_HoaDon() {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(null);
        tbm = (DefaultTableModel) tblHoaDon.getModel();
        tbm1 = (DefaultTableModel) tblHDCT.getModel();
        filltableHD();
        
    }
    public void filltableHD(){
        tbm.setRowCount(0);
        for (HoaDonVModel x : hdsv.getList()) {
            tbm.addRow(new Object[]{x.getMa(),x.getTen_nv(),x.getNgayTao(),x.getTongTien(),x.getTenKh(),x.getMakm(),x.getTrangThai()});
        }
    }
    public void filltableHDCT(String Mahd){
        tbm1.setRowCount(0);
        for (HoaDonCTVmodel x :  hdctsv.gethdct(Mahd)) {
            tbm1.addRow(new Object[]{x.getMa_hd(),x.getTenSP(),x.getSL_Mua(),x.getDonGia()});
        }
    }
    public void comboboxTT(){
        for (int i = 0; i < hdsv.getList().size(); i++) {
            if (hdsv.getList().get(i).getTrangThai().equalsIgnoreCase(cbbLoc.getSelectedItem().toString())) {
                
            } else {
            }
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
        panelHoaDon = new javax.swing.JPanel();
        pnlHoaDon = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimMKH = new javax.swing.JButton();
        btnTimMHD = new javax.swing.JButton();
        cbbLoc = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        cbbDonGia = new javax.swing.JComboBox<>();

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
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Nv", "Ngày tạo", "Tổng tiền", "Tên kh", "Mã KM", "Trạng thái"
            }
        ));
        jScrollPane13.setViewportView(tblHoaDon);

        btnTimMKH.setBackground(new java.awt.Color(204, 204, 204));
        btnTimMKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimMKH.setText("Tìm mã khách hàng");
        btnTimMKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimMKHbtnTimMaKhachHangActionPerformed(evt);
            }
        });

        btnTimMHD.setBackground(new java.awt.Color(204, 204, 204));
        btnTimMHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimMHD.setText("Tìm mã hóa đơn");
        btnTimMHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimMHDbtnTimMaHoaDonActionPerformed(evt);
            }
        });

        cbbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Hủy", "Đã Thanh Toán" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnTimMKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimMHD)
                .addGap(223, 223, 223))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimMHD)
                    .addComponent(btnTimMKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tblHDCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Tên SP", "Số lượng", "Đơn Gía"
            }
        ));
        jScrollPane14.setViewportView(tblHDCT);

        cbbDonGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0<=50000 VND", "50000<=150000 VND", "150000<=500000 VND" }));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cbbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 982, Short.MAX_VALUE))
                .addGap(0, 88, Short.MAX_VALUE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHoaDonLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnltongLayout = new javax.swing.GroupLayout(pnltong);
        pnltong.setLayout(pnltongLayout);
        pnltongLayout.setHorizontalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnltongLayout.setVerticalGroup(
            pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltongLayout.createSequentialGroup()
                .addGroup(pnltongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(pnltong, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHang_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang_MenuActionPerformed
        // TODO add your handling code here:
        new QuanLy_BanHang().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBanHang_MenuActionPerformed

    private void btnHoaDonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMenuActionPerformed
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

    private void btnTimMKHbtnTimMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimMKHbtnTimMaKhachHangActionPerformed
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (int i = 0; i < hdsv.getList().size(); i++) {
            if (hdsv.getList().get(i).getMa().equalsIgnoreCase(txtTimKiem.getText())) {
                lst_hdvmd.add(hdsv.getList().get(i));
            }
        }
        tbm.setRowCount(0);
        for (HoaDonVModel x : lst_hdvmd) {
            tbm.addRow(new Object[]{x.getMa(),x.getTen_nv(),x.getNgayTao(),x.getTongTien(),x.getTenKh(),x.getMakm(),x.getTrangThai()});
        }
        filltableHD();
    }//GEN-LAST:event_btnTimMKHbtnTimMaKhachHangActionPerformed

    private void btnTimMHDbtnTimMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimMHDbtnTimMaHoaDonActionPerformed
        List<HoaDonVModel> lst_hdvmd = new ArrayList<>();
        for (int i = 0; i < hdsv.getList().size(); i++) {
            if (hdsv.getList().get(i).getMa().equalsIgnoreCase(txtTimKiem.getText())) {
                lst_hdvmd.add(hdsv.getList().get(i));
            }
        }
        tbm.setRowCount(0);
        for (HoaDonVModel x : lst_hdvmd) {
            tbm.addRow(new Object[]{x.getMa(),x.getTen_nv(),x.getNgayTao(),x.getTongTien(),x.getTenKh(),x.getMakm(),x.getTrangThai()});
        }
        filltableHD();
    }//GEN-LAST:event_btnTimMHDbtnTimMaHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLy_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy_HoaDon().setVisible(true);
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
    private javax.swing.JButton btnThongkeMenu;
    private javax.swing.JButton btnTimMHD;
    private javax.swing.JButton btnTimMKH;
    private javax.swing.JComboBox<String> cbbDonGia;
    private javax.swing.JComboBox<String> cbbLoc;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnltong;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
