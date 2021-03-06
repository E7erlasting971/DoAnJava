/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ChiTietHoaDonDAO;
import controller.HoaDonDAO;
import controller.LoaiSanPhamDAO;
import controller.NhaCungCapDAO;
import controller.KhachHangDAO;
import controller.NhanVienDAO;
import controller.QuanLyThongKeController;
import controller.SanPhamDAO;
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonDTO;
import model.GioHangDTO;
import model.HoaDonDTO;
import model.LoaiSanPhamDTO;
import model.NhaCungCapDTO;
import model.KhachHangDTO;
import model.NhanVienDTO;
import model.SanPhamDTO;

/**
 *
 * @author Thinh Ly
 */
public class manHinhChinh extends javax.swing.JFrame {

    LoaiSanPhamDAO lspDAO = new LoaiSanPhamDAO();
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    NhanVienDAO nvDAO = new NhanVienDAO();
    KhachHangDAO khDAO = new KhachHangDAO();
    SanPhamDAO spDAO = new SanPhamDAO();
    HoaDonDAO hdDAO = new HoaDonDAO();
    ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

    private ArrayList<LoaiSanPhamDTO> list;
    private ArrayList<NhaCungCapDTO> list1;
    private ArrayList<KhachHangDTO> list_KH;
    private ArrayList<NhanVienDTO> list_NV;
    private ArrayList<SanPhamDTO> list_SP;
    private ArrayList<HoaDonDTO> list_HD;
    private ArrayList<ChiTietHoaDonDTO> list_CTHD;
    private ArrayList<GioHangDTO> list_GioHang;

    DefaultTableModel model;
    DefaultTableModel model1;
    DefaultTableModel model_KH;
    DefaultTableModel model_NV;
    DefaultTableModel model_SP;
    DefaultTableModel model_HD;
    DefaultTableModel model_CTHD;
    DefaultTableModel model_SP_FrmBanHang;
    DefaultTableModel model_GioHang_frmBanHang;
    /**
     * Creates new form manHinhChinh
     */
    CardLayout cardLayout;

    public manHinhChinh() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Component[] components = this.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        cardLayout = (CardLayout) (pnlCards.getLayout());

        //jpnlLoaiSanPham
        this.setLocationRelativeTo(null);
        list = new LoaiSanPhamDAO().getListLoaiSanPhamDTOs();
        model = (DefaultTableModel) jtblLoaiSanPham.getModel();

        showTableLoaiSanPham();// hien thi thong tin trong danh sach

        //jpnlNhaCungCap
        this.setLocationRelativeTo(null);
        list1 = new NhaCungCapDAO().getListNhaCungCapDTOs();
        model1 = (DefaultTableModel) jtblNhaCungCap.getModel();

        showTableNhaCungCap();// hien thi thong tin trong danh sach

        //jpnlKhachHang
        this.setLocationRelativeTo(null);
        list_KH = new KhachHangDAO().getListKhachHangDTOs();
        model_KH = (DefaultTableModel) jtblKhachHang.getModel();

        showTableKhachHang();// hien thi thong tin trong danh sach

        //jpnlNhanVien
        this.setLocationRelativeTo(null);
        list_NV = new NhanVienDAO().getListNhanVienDTOs();
        model_NV = (DefaultTableModel) jtblNhanVien.getModel();

        showTableNhanVien();// hien thi thong tin trong danh sach

        //jpnlSanPham
        this.setLocationRelativeTo(null);
        list_SP = new SanPhamDAO().getListSanPhamDTOs();
        model_SP = (DefaultTableModel) jtblSanPham.getModel();

        showTableSanPham();// hien thi thong tin trong danh sach

        this.setLocationRelativeTo(null);
        list_HD = new HoaDonDAO().getListHoaDonDTOs();
        model_HD = (DefaultTableModel) jtblHoaDon.getModel();

        showTableHoaDon();

        this.setLocationRelativeTo(null);
        list_CTHD = new ChiTietHoaDonDAO().getListChiTietHoaDonDTOs();
        model_CTHD = (DefaultTableModel) jtblChiTietHoaDon.getModel();

        this.setLocationRelativeTo(null);
        list_SP = new SanPhamDAO().getListSanPhamDTOs();
        model_SP_FrmBanHang = (DefaultTableModel) jtblSanPham_FrmThongTinBanHang.getModel();
        showTableSanPham_FrmThongTinBanHang();

        this.setLocationRelativeTo(null);
        model_GioHang_frmBanHang = (DefaultTableModel) jtblGioHang_frmBanHang.getModel();

        showComboboxNhaCungCapFrmSanPham();
        showComboboxLoaiSanPhamFrmSanPham();
        showComboboxNhanVienFrmThanhToan();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnManHinhChinh = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnNhaCungCap = new javax.swing.JButton();
        btnLoaiSanPham = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        jbtnThanhToan = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        pnlCards = new javax.swing.JPanel();
        jpnlManHinhChinh = new javax.swing.JPanel();
        button2 = new java.awt.Button();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jpnlNhanVien = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblNhanVien = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtxtTenNhanVien = new javax.swing.JTextField();
        jtxtGioiTinh = new javax.swing.JTextField();
        jtxtDiaChi_NV = new javax.swing.JTextField();
        jtxtSDT_NV = new javax.swing.JTextField();
        jbtnThem_NV = new javax.swing.JButton();
        jbtnSua_NhanVien = new javax.swing.JButton();
        jbtnXoa_NhanVien = new javax.swing.JButton();
        jtxtCCCD = new javax.swing.JTextField();
        jtxtChucVu = new javax.swing.JTextField();
        jtxtMaNhanVien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jpnlSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSanPham = new javax.swing.JTable();
        jTxtTimKiemTheoTenSanPham = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jtxtTenSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtGiaSanPham = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtSLHienCo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtNgayNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbxLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtxtLoaiSanPham = new javax.swing.JTextField();
        jcbxNhaCungCap = new javax.swing.JComboBox<>();
        jtxtTenNCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbtnThem_SanPham = new javax.swing.JButton();
        jbtnXoa_SanPham = new javax.swing.JButton();
        jbtnSua_SanPham = new javax.swing.JButton();
        jtxtMaSanPham = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jpnlHoaDon = new javax.swing.JPanel();
        jtxtMaHoaDon_FrmHoaDon = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblHoaDon = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblChiTietHoaDon = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jpnlNhaCungCap = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblNhaCungCap = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jtxtTenNhaCungCap = new javax.swing.JTextField();
        jtxtKhuVuc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnThem_NCC = new javax.swing.JButton();
        jbtnSua_NhaCungCap = new javax.swing.JButton();
        jbtnXoa_NhaCungCap = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jtxtMaNhaCungCap = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jpnlLoaiSanPham = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblLoaiSanPham = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jtxtMaLoaiSanPham = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtxtTenLoaiSanPham = new javax.swing.JTextField();
        jbtnXoa_LSP = new javax.swing.JButton();
        jbtnSua_LSP = new javax.swing.JButton();
        jThem_LSP = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jpnlKhachHang = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtblKhachHang = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jtxtTenKhachHang = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtxtDiaChi_KH = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtxtSDT_KH = new javax.swing.JTextField();
        jbtnThem_KH = new javax.swing.JButton();
        jbtnSua_KhachHang = new javax.swing.JButton();
        jbtnXoa_KhachHang = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jtxtTimKiemKhachHangTrongFrmKhachHang = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtxtMaKhachHang = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jbtnXacNhanKhachHang = new javax.swing.JButton();
        jpnlThongTinBanHang = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtblSanPham_FrmThongTinBanHang = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtblGioHang_frmBanHang = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jtxtMaSP_FrmBanHang = new javax.swing.JTextField();
        jtxtTenSP_frmBanHang = new javax.swing.JTextField();
        jtxtSoLuong_FrmBanHang = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jtxtGiaSP_FrmBanHang = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jbtnXoaGioHang = new javax.swing.JButton();
        jbtnThemGioHang = new javax.swing.JButton();
        jbtnSuaGioHang = new javax.swing.JButton();
        jtxtThanhTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jcbxTenNhanVien_frmThanhToan = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jtxtKhachHang_frmThanhToan = new javax.swing.JTextField();
        jbtnTimKiemKhachHang_frmThanhToan = new javax.swing.JButton();
        jtxtMaHoaDon = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jbtnThanhToan_fromThanhToan = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jtxtThanhTien_FrmHoaDon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpnlThongKe = new javax.swing.JPanel();
        jpnlChartNgay = new javax.swing.JPanel();
        jbntNgay = new javax.swing.JButton();
        jbnThang = new javax.swing.JButton();
        jbnNam = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));

        btnManHinhChinh.setBackground(new java.awt.Color(153, 204, 255));
        btnManHinhChinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnManHinhChinh.setForeground(new java.awt.Color(255, 255, 255));
        btnManHinhChinh.setText("WIBU");
        btnManHinhChinh.setBorderPainted(false);
        btnManHinhChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManHinhChinhActionPerformed(evt);
            }
        });

        btnNhanVien.setText("Nh??n vi??n");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSanPham.setText("S???n Ph???m");
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseClicked(evt);
            }
        });
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnHoaDon.setText("H??a ????n");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnNhaCungCap.setText("Nh?? Cung C???p");
        btnNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCapActionPerformed(evt);
            }
        });

        btnLoaiSanPham.setText("Lo???i S???n Ph???m");
        btnLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiSanPhamActionPerformed(evt);
            }
        });

        btnKhachHang.setText("Kh??ch H??ng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        jbtnThanhToan.setText("Thanh To??n");
        jbtnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThanhToanActionPerformed(evt);
            }
        });

        btnThongKe.setText("Th???ng K??");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnManHinhChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnManHinhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(632, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        pnlCards.setLayout(new java.awt.CardLayout());

        jpnlManHinhChinh.setBackground(new java.awt.Color(21, 25, 28));
        jpnlManHinhChinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnlManHinhChinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button2.setBackground(new java.awt.Color(255, 51, 0));
        button2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("????ng Xu???t");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jpnlManHinhChinh.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 720, 125, 40));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("QU???N L?? THI???T B??? ??I???N T???");
        jpnlManHinhChinh.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 710, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Dark-Technology-Wallpapers.png"))); // NOI18N
        jpnlManHinhChinh.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 910));

        pnlCards.add(jpnlManHinhChinh, "pnlManHinhChinh");

        jpnlNhanVien.setBackground(new java.awt.Color(34, 40, 44));

        jtblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? Nh??n Vi??n", "T??n Nh??n Vi??n", "??i??a Chi??", "CCCD", "SDT", "Ch????c Vu??", "Gi????i Ti??nh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblNhanVien.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblNhanVien);

        jLabel27.setText("ID");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jtxtTenNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jtxtTenNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtTenNhanVienFocusLost(evt);
            }
        });

        jtxtGioiTinh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jtxtDiaChi_NV.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jtxtSDT_NV.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jbtnThem_NV.setBackground(new java.awt.Color(114, 37, 255));
        jbtnThem_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnThem_NV.setForeground(new java.awt.Color(255, 255, 255));
        jbtnThem_NV.setText("Th??m");
        jbtnThem_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThem_NVActionPerformed(evt);
            }
        });

        jbtnSua_NhanVien.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSua_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnSua_NhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSua_NhanVien.setText("S???a");
        jbtnSua_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSua_NhanVienActionPerformed(evt);
            }
        });

        jbtnXoa_NhanVien.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoa_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnXoa_NhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoa_NhanVien.setText("X??a");
        jbtnXoa_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoa_NhanVienActionPerformed(evt);
            }
        });

        jtxtCCCD.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jtxtChucVu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jtxtChucVu.setCaretColor(new java.awt.Color(153, 153, 153));

        jtxtMaNhanVien.setEditable(false);
        jtxtMaNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        jtxtMaNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setText("H??? t??n nh??n vi??n");

        jLabel8.setText("Gi???i t??nh");

        jLabel9.setText("SDT");

        jLabel10.setText("?????a ch???");

        jLabel12.setText("Ch???c v???");

        jLabel11.setText("CCCD");

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setText("                                                                                             Nh???p Th??ng Tin");
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtxtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtDiaChi_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtSDT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jbtnThem_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jbtnSua_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jbtnXoa_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jtxtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnXoa_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSua_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnThem_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtxtDiaChi_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtSDT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))))
        );

        jButton3.setBackground(new java.awt.Color(7, 200, 105));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setText("Danh S??ch Nh??n Vi??n");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nh??n Vi??n");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jpnlNhanVienLayout = new javax.swing.GroupLayout(jpnlNhanVien);
        jpnlNhanVien.setLayout(jpnlNhanVienLayout);
        jpnlNhanVienLayout.setHorizontalGroup(
            jpnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNhanVienLayout.createSequentialGroup()
                .addGroup(jpnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlNhanVienLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlNhanVienLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jpnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnlNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3105, Short.MAX_VALUE))
        );
        jpnlNhanVienLayout.setVerticalGroup(
            jpnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlNhanVien, "pnlNhanVien");
        jpnlNhanVien.getAccessibleContext().setAccessibleName("pnlNhanVien");

        jpnlSanPham.setBackground(new java.awt.Color(34, 40, 44));

        jtblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? Sa??n Ph????m", "T??n Sa??n Ph????m", "Gia?? Sa??n Ph????m", "S???? L??????ng Hi????n Co??", "Nga??y Nh????p", "Ma?? Loa??i Sa??n Ph????m", "Ma?? Nha?? Cung C????p"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSanPham.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblSanPham);

        jTxtTimKiemTheoTenSanPham.setText("T??n S???n Ph???m");
        jTxtTimKiemTheoTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTimKiemTheoTenSanPhamActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jtxtTenSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));
        jtxtTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTenSanPhamActionPerformed(evt);
            }
        });

        jLabel2.setText("T??n s???n ph???m");

        jtxtGiaSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel3.setText("Gi?? s???n ph???m");

        jtxtSLHienCo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel4.setText("SL hi???n c??");

        jtxtNgayNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel5.setText("Ng??y nh???p");

        jcbxLoaiSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));
        jcbxLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxLoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel7.setText("Lo???i s???n ph???m");

        jtxtLoaiSanPham.setEditable(false);
        jtxtLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jtxtLoaiSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jcbxNhaCungCap.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));
        jcbxNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxNhaCungCapActionPerformed(evt);
            }
        });

        jtxtTenNCC.setEditable(false);
        jtxtTenNCC.setBackground(new java.awt.Color(255, 255, 255));
        jtxtTenNCC.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel6.setText("Nh?? cung c???p");

        jbtnThem_SanPham.setBackground(new java.awt.Color(245, 193, 32));
        jbtnThem_SanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtnThem_SanPham.setText("Th??m");
        jbtnThem_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThem_SanPhamActionPerformed(evt);
            }
        });

        jbtnXoa_SanPham.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoa_SanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtnXoa_SanPham.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoa_SanPham.setText("X??a");
        jbtnXoa_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoa_SanPhamActionPerformed(evt);
            }
        });

        jbtnSua_SanPham.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSua_SanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtnSua_SanPham.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSua_SanPham.setText("S???a");
        jbtnSua_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSua_SanPhamActionPerformed(evt);
            }
        });

        jtxtMaSanPham.setEditable(false);

        jLabel30.setText("ID");

        jLabel32.setBackground(new java.awt.Color(49, 47, 5));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 153, 153));
        jLabel32.setText("                                              Nh???p Th??ng Tin");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnThem_SanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(168, 168, 168))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtxtSLHienCo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(167, 167, 167))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jtxtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtxtLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtGiaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13)))))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcbxLoaiSanPham, 0, 197, Short.MAX_VALUE)
                                .addComponent(jcbxNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(418, 418, 418)))
                .addGap(28, 28, 28))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel30)
                .addGap(24, 24, 24)
                .addComponent(jtxtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 463, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnXoa_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSua_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(177, 177, 177))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtGiaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jtxtSLHienCo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jbtnSua_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jbtnXoa_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jbtnThem_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton5.setBackground(new java.awt.Color(7, 200, 105));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setText("Danh S??ch S???n Ph???m");

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("S???n Ph???m");
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jpnlSanPhamLayout = new javax.swing.GroupLayout(jpnlSanPham);
        jpnlSanPham.setLayout(jpnlSanPhamLayout);
        jpnlSanPhamLayout.setHorizontalGroup(
            jpnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlSanPhamLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtTimKiemTheoTenSanPham))
                .addContainerGap(2928, Short.MAX_VALUE))
        );
        jpnlSanPhamLayout.setVerticalGroup(
            jpnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSanPhamLayout.createSequentialGroup()
                .addGroup(jpnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnlSanPhamLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jpnlSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTxtTimKiemTheoTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(513, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlSanPham, "card4");

        jpnlHoaDon.setBackground(new java.awt.Color(34, 40, 44));

        jtxtMaHoaDon_FrmHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtMaHoaDon_FrmHoaDon.setText("M?? h??a ????n");
        jtxtMaHoaDon_FrmHoaDon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtMaHoaDon_FrmHoaDonFocusGained(evt);
            }
        });
        jtxtMaHoaDon_FrmHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMaHoaDon_FrmHoaDonActionPerformed(evt);
            }
        });

        jtblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? h??a ????n", "M?? kh??ch h??ng", "Ng??y mua", "T???ng ti???n", "M?? nh??n vi??n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblHoaDon.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtblHoaDon);

        jtblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? s???n ph???m", "T??n s???n ph???m", "S??? l?????ng", "????n gi??"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblChiTietHoaDon.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jScrollPane5.setViewportView(jtblChiTietHoaDon);

        jButton16.setBackground(new java.awt.Color(7, 200, 105));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton16.setText("Chi ti???t h??a ????n");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("H??a ????n");
        jLabel44.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton4.setBackground(new java.awt.Color(7, 200, 105));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setText("Danh S??ch H??a ????n");

        javax.swing.GroupLayout jpnlHoaDonLayout = new javax.swing.GroupLayout(jpnlHoaDon);
        jpnlHoaDon.setLayout(jpnlHoaDonLayout);
        jpnlHoaDonLayout.setHorizontalGroup(
            jpnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHoaDonLayout.createSequentialGroup()
                .addGroup(jpnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlHoaDonLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jpnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtMaHoaDon_FrmHoaDon)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpnlHoaDonLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3470, Short.MAX_VALUE))
        );
        jpnlHoaDonLayout.setVerticalGroup(
            jpnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtMaHoaDon_FrmHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(511, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlHoaDon, "card5");

        jpnlNhaCungCap.setBackground(new java.awt.Color(34, 40, 44));

        jtblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? Nha?? Cung C????p", "T??n Nha?? Cung C????p", "Khu V????c"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblNhaCungCap.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtblNhaCungCap);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jtxtTenNhaCungCap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jtxtKhuVuc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel18.setText("T??n nh?? cung c???p");

        jLabel19.setText("Khu v???c");

        btnThem_NCC.setBackground(new java.awt.Color(114, 37, 255));
        btnThem_NCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem_NCC.setForeground(new java.awt.Color(255, 255, 255));
        btnThem_NCC.setText("Th??m");
        btnThem_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_NCCActionPerformed(evt);
            }
        });

        jbtnSua_NhaCungCap.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSua_NhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnSua_NhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSua_NhaCungCap.setText("S???a");
        jbtnSua_NhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSua_NhaCungCapActionPerformed(evt);
            }
        });

        jbtnXoa_NhaCungCap.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoa_NhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnXoa_NhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoa_NhaCungCap.setText("X??a");
        jbtnXoa_NhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoa_NhaCungCapActionPerformed(evt);
            }
        });

        jLabel25.setText("ID");

        jtxtMaNhaCungCap.setEditable(false);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 153, 153));
        jLabel45.setText("                                     Nh???p Th??ng Tin");
        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtxtKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                        .addComponent(jtxtTenNhaCungCap))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnSua_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnXoa_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtMaNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jtxtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jtxtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbtnXoa_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbtnSua_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnThem_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nh?? Cung C???p");
        jLabel46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton6.setBackground(new java.awt.Color(7, 200, 105));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton6.setText("Danh S??ch Nh?? Cung C???p");

        javax.swing.GroupLayout jpnlNhaCungCapLayout = new javax.swing.GroupLayout(jpnlNhaCungCap);
        jpnlNhaCungCap.setLayout(jpnlNhaCungCapLayout);
        jpnlNhaCungCapLayout.setHorizontalGroup(
            jpnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNhaCungCapLayout.createSequentialGroup()
                .addGroup(jpnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)))
                    .addGroup(jpnlNhaCungCapLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3054, Short.MAX_VALUE))
        );
        jpnlNhaCungCapLayout.setVerticalGroup(
            jpnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 626, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlNhaCungCap, "card6");

        jpnlLoaiSanPham.setBackground(new java.awt.Color(34, 40, 44));

        jtblLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? Loa??i Sa??n Ph????m", "T??n Loa??i Sa??n Ph????m"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblLoaiSanPham.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLoaiSanPhamMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtblLoaiSanPham);

        jLabel24.setText("M?? lo???i s???n ph???m");

        jtxtMaLoaiSanPham.setEditable(false);

        jLabel20.setText("T??n lo???i s???n ph???m");

        jbtnXoa_LSP.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoa_LSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnXoa_LSP.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoa_LSP.setText("X??a");
        jbtnXoa_LSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoa_LSPActionPerformed(evt);
            }
        });

        jbtnSua_LSP.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSua_LSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnSua_LSP.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSua_LSP.setText("S???a");
        jbtnSua_LSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSua_LSPActionPerformed(evt);
            }
        });

        jThem_LSP.setBackground(new java.awt.Color(114, 37, 255));
        jThem_LSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jThem_LSP.setForeground(new java.awt.Color(255, 255, 255));
        jThem_LSP.setText("Th??m");
        jThem_LSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 153, 153));
        jLabel47.setText("                                 Nh???p Th??ng Tin");
        jLabel47.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jbtnXoa_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jbtnSua_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jThem_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtTenLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jtxtMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel47)
                .addGap(46, 46, 46)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jtxtTenLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSua_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jThem_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnXoa_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        jtxtTenLoaiSanPham.getAccessibleContext().setAccessibleName("txtTenLoaiSanPham");
        jtxtTenLoaiSanPham.getAccessibleContext().setAccessibleDescription("");
        jThem_LSP.getAccessibleContext().setAccessibleName("btnThem");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Lo???i S???n Ph???m");
        jLabel48.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton7.setBackground(new java.awt.Color(7, 200, 105));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Danh S??ch Lo???i S???n Ph???m");

        javax.swing.GroupLayout jpnlLoaiSanPhamLayout = new javax.swing.GroupLayout(jpnlLoaiSanPham);
        jpnlLoaiSanPham.setLayout(jpnlLoaiSanPhamLayout);
        jpnlLoaiSanPhamLayout.setHorizontalGroup(
            jpnlLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoaiSanPhamLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpnlLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                .addContainerGap(3269, Short.MAX_VALUE))
        );
        jpnlLoaiSanPhamLayout.setVerticalGroup(
            jpnlLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLoaiSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 592, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlLoaiSanPham, "card7");

        jpnlKhachHang.setBackground(new java.awt.Color(34, 40, 44));

        jtblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? Kha??ch Ha??ng", "T??n Kha??ch Ha??ng", "??i??a Chi??", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblKhachHang.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jtblKhachHang);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jtxtTenKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel21.setText("H??? t??n kh??ch h??ng");

        jtxtDiaChi_KH.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel22.setText("?????a ch???");

        jtxtSDT_KH.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jbtnThem_KH.setBackground(new java.awt.Color(114, 37, 255));
        jbtnThem_KH.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnThem_KH.setForeground(new java.awt.Color(255, 255, 255));
        jbtnThem_KH.setText("Th??m");
        jbtnThem_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThem_KHActionPerformed(evt);
            }
        });

        jbtnSua_KhachHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSua_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnSua_KhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSua_KhachHang.setText("S???a");
        jbtnSua_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSua_KhachHangActionPerformed(evt);
            }
        });

        jbtnXoa_KhachHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoa_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnXoa_KhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoa_KhachHang.setText("X??a");
        jbtnXoa_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoa_KhachHangActionPerformed(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("ID");

        jtxtTimKiemKhachHangTrongFrmKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtxtTimKiemKhachHangTrongFrmKhachHang.setText("S??? ??i???n tho???i");
        jtxtTimKiemKhachHangTrongFrmKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));
        jtxtTimKiemKhachHangTrongFrmKhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtTimKiemKhachHangTrongFrmKhachHangFocusGained(evt);
            }
        });
        jtxtTimKiemKhachHangTrongFrmKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTimKiemKhachHangTrongFrmKhachHangActionPerformed(evt);
            }
        });

        jLabel23.setText("S??? ??i???n tho???i");

        jtxtMaKhachHang.setEditable(false);
        jtxtMaKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        jtxtMaKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jtxtMaKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));
        jtxtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMaKhachHangActionPerformed(evt);
            }
        });

        jLabel49.setBackground(new java.awt.Color(49, 47, 5));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(153, 153, 153));
        jLabel49.setText("                                     Nh???p Th??ng Tin");
        jLabel49.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDiaChi_KH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSDT_KH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 297, Short.MAX_VALUE)))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnThem_KH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnXoa_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSua_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtTimKiemKhachHangTrongFrmKhachHang))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(jtxtTimKiemKhachHangTrongFrmKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jtxtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jtxtDiaChi_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jtxtSDT_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jbtnThem_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnXoa_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnSua_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jLabel50.setBackground(new java.awt.Color(34, 40, 44));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Kh??ch H??ng");
        jLabel50.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jButton8.setBackground(new java.awt.Color(7, 200, 105));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton8.setText("Danh S??ch Kh??ch H??ng");

        jbtnXacNhanKhachHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXacNhanKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtnXacNhanKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXacNhanKhachHang.setText("X??c Nh???n");
        jbtnXacNhanKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXacNhanKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlKhachHangLayout = new javax.swing.GroupLayout(jpnlKhachHang);
        jpnlKhachHang.setLayout(jpnlKhachHangLayout);
        jpnlKhachHangLayout.setHorizontalGroup(
            jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                .addGroup(jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnXacNhanKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                        .addGroup(jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3018, 3018, 3018))
        );
        jpnlKhachHangLayout.setVerticalGroup(
            jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                .addGroup(jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlKhachHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jbtnXacNhanKhachHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(579, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlKhachHang, "card8");

        jpnlThongTinBanHang.setBackground(new java.awt.Color(34, 40, 44));

        jtblSanPham_FrmThongTinBanHang.setBackground(new java.awt.Color(245, 245, 245));
        jtblSanPham_FrmThongTinBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma San Pham", "Ten San Pham", "Gia Tien", "SL Hien Co", "Ma NCC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSanPham_FrmThongTinBanHang.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblSanPham_FrmThongTinBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblSanPham_FrmThongTinBanHangMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtblSanPham_FrmThongTinBanHang);

        jtblGioHang_frmBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma San Pham", "Ten San Pham", "So Luong", "Don Gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblGioHang_frmBanHang.setSelectionBackground(new java.awt.Color(143, 87, 247));
        jtblGioHang_frmBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblGioHang_frmBanHangMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtblGioHang_frmBanHang);

        jLabel42.setText("(VN??)");

        jLabel43.setBackground(new java.awt.Color(245, 245, 245));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Thanh To??n");
        jLabel43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setText("T??n S???n Ph???m");

        jtxtMaSP_FrmBanHang.setEditable(false);
        jtxtMaSP_FrmBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jtxtMaSP_FrmBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jtxtTenSP_frmBanHang.setEditable(false);
        jtxtTenSP_frmBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jtxtTenSP_frmBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jtxtSoLuong_FrmBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel35.setText("S??? L?????ng");

        jtxtGiaSP_FrmBanHang.setEditable(false);
        jtxtGiaSP_FrmBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jtxtGiaSP_FrmBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel36.setText("Gi?? S???n Ph???m");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("VN??");

        jbtnXoaGioHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnXoaGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnXoaGioHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnXoaGioHang.setText("X??a Gi??? H??ng ");
        jbtnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaGioHangActionPerformed(evt);
            }
        });

        jbtnThemGioHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnThemGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnThemGioHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnThemGioHang.setText("Th??m Gi??? H??ng ");
        jbtnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemGioHangActionPerformed(evt);
            }
        });

        jbtnSuaGioHang.setBackground(new java.awt.Color(114, 37, 255));
        jbtnSuaGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnSuaGioHang.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSuaGioHang.setText("S???a Gi??? H??ng ");
        jbtnSuaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaGioHangActionPerformed(evt);
            }
        });

        jtxtThanhTien.setEditable(false);
        jtxtThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        jtxtThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtxtThanhTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Th??nh ti???n");

        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(172, 170, 170)));

        jLabel38.setText("Nh??n Vi??n");

        jcbxTenNhanVien_frmThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel39.setText("Kh??ch H??ng");

        jtxtKhachHang_frmThanhToan.setEditable(false);
        jtxtKhachHang_frmThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        jtxtKhachHang_frmThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jbtnTimKiemKhachHang_frmThanhToan.setText("...");
        jbtnTimKiemKhachHang_frmThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTimKiemKhachHang_frmThanhToanActionPerformed(evt);
            }
        });

        jtxtMaHoaDon.setEditable(false);
        jtxtMaHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setText("M?? H??a ????n");

        jbtnThanhToan_fromThanhToan.setBackground(new java.awt.Color(102, 255, 255));
        jbtnThanhToan_fromThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnThanhToan_fromThanhToan.setText("Thanh To??n");
        jbtnThanhToan_fromThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThanhToan_fromThanhToanActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel41.setText("T???ng Ti???n");

        jtxtThanhTien_FrmHoaDon.setEditable(false);
        jtxtThanhTien_FrmHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        jtxtThanhTien_FrmHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 187, 187)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Nh???p Th??ng Tin");

        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtxtMaSP_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(247, 247, 247)
                                    .addComponent(jtxtGiaSP_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(381, 381, 381))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtThanhTien_FrmHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jbtnThanhToan_fromThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jtxtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtxtKhachHang_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnTimKiemKhachHang_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbxTenNhanVien_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtSoLuong_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtTenSP_frmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSuaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jtxtMaSP_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtTenSP_frmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel35)
                        .addGap(12, 12, 12)
                        .addComponent(jtxtSoLuong_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtGiaSP_FrmBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addComponent(jLabel36))
                .addGap(32, 32, 32)
                .addComponent(jbtnThemGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbtnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jbtnSuaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtxtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jtxtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jcbxTenNhanVien_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtKhachHang_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnTimKiemKhachHang_frmThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtThanhTien_FrmHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jbtnThanhToan_fromThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jButton1.setBackground(new java.awt.Color(7, 200, 105));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Gi??? H??ng");

        jButton2.setBackground(new java.awt.Color(7, 200, 105));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setText("Th??ng Tin B??n H??ng");

        javax.swing.GroupLayout jpnlThongTinBanHangLayout = new javax.swing.GroupLayout(jpnlThongTinBanHang);
        jpnlThongTinBanHang.setLayout(jpnlThongTinBanHangLayout);
        jpnlThongTinBanHangLayout.setHorizontalGroup(
            jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                        .addGap(2520, 2520, 2520)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                        .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                                .addComponent(jScrollPane10)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1744, Short.MAX_VALUE))
            .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3673, Short.MAX_VALUE)))
        );
        jpnlThongTinBanHangLayout.setVerticalGroup(
            jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(462, 462, 462)
                .addComponent(jLabel42)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jpnlThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnlThongTinBanHangLayout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1144, Short.MAX_VALUE)))
        );

        pnlCards.add(jpnlThongTinBanHang, "card9");

        jpnlThongKe.setBackground(new java.awt.Color(34, 40, 44));

        jpnlChartNgay.setBackground(new java.awt.Color(34, 40, 44));

        javax.swing.GroupLayout jpnlChartNgayLayout = new javax.swing.GroupLayout(jpnlChartNgay);
        jpnlChartNgay.setLayout(jpnlChartNgayLayout);
        jpnlChartNgayLayout.setHorizontalGroup(
            jpnlChartNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jpnlChartNgayLayout.setVerticalGroup(
            jpnlChartNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        jbntNgay.setBackground(new java.awt.Color(34, 40, 44));
        jbntNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbntNgay.setForeground(new java.awt.Color(255, 255, 255));
        jbntNgay.setText("Th???ng k?? theo ng??y");
        jbntNgay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jbntNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntNgayActionPerformed(evt);
            }
        });

        jbnThang.setBackground(new java.awt.Color(34, 40, 44));
        jbnThang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbnThang.setForeground(new java.awt.Color(255, 255, 255));
        jbnThang.setText("Th???ng k?? theo th??ng");
        jbnThang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jbnThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnThangActionPerformed(evt);
            }
        });

        jbnNam.setBackground(new java.awt.Color(34, 40, 44));
        jbnNam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbnNam.setForeground(new java.awt.Color(255, 255, 255));
        jbnNam.setText("Th???ng k?? theo n??m");
        jbnNam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jbnNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlThongKeLayout = new javax.swing.GroupLayout(jpnlThongKe);
        jpnlThongKe.setLayout(jpnlThongKeLayout);
        jpnlThongKeLayout.setHorizontalGroup(
            jpnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlThongKeLayout.createSequentialGroup()
                .addGroup(jpnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlThongKeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnlChartNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlThongKeLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jbntNgay)
                        .addGap(152, 152, 152)
                        .addComponent(jbnThang)
                        .addGap(160, 160, 160)
                        .addComponent(jbnNam)))
                .addContainerGap(3187, Short.MAX_VALUE))
        );
        jpnlThongKeLayout.setVerticalGroup(
            jpnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlChartNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jpnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbntNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbnThang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(630, Short.MAX_VALUE))
        );

        pnlCards.add(jpnlThongKe, "card10");

        jSplitPane1.setRightComponent(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManHinhChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManHinhChinhActionPerformed
        // TODO add your handling code here:
        // cardLayout.show(pnlCards, "pnlManHinhChinh");
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(true);
        jpnlKhachHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
        jpnlThongTinBanHang.setVisible(false);
    }//GEN-LAST:event_btnManHinhChinhActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        //cardLayout.show(pnlCards, "pnlNhanVien");
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(true);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
//        cardLayout.show(pnlCards,"pnlSanPham");
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseClicked
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(true);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_btnSanPhamMouseClicked

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(true);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCapActionPerformed

        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(true);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_btnNhaCungCapActionPerformed

    private void btnLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        jpnlLoaiSanPham.setVisible(true);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jpnlThongKe.setVisible(false);
    }//GEN-LAST:event_btnLoaiSanPhamActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        jpnlKhachHang.setVisible(true);
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jbtnXacNhanKhachHang.setVisible(false);
        jpnlThongKe.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);

    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void jtxtTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTenSanPhamActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        DangNhap temp_form = new DangNhap();
        temp_form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_button2ActionPerformed

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        if (jtxtTenLoaiSanPham.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
            return;
        }
        boolean t=kiemTraTonTaiLSP(jtxtTenLoaiSanPham.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t???i t??n lo???i s???n ph???m n??y");
            return;
        }
        LoaiSanPhamDTO l = new LoaiSanPhamDTO();
        l.setTenLoaiSanPham(jtxtTenLoaiSanPham.getText());
        
        if (new LoaiSanPhamDAO().addLoaiSanPham(l)) {
            showComboboxLoaiSanPhamFrmSanPham();
            list.add(l); // them vao loai san pham
            JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin!");
        }
        xuatThongTinLoaiSanPham();
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void btnThem_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_NCCActionPerformed
        if (jtxtTenNhaCungCap.getText().isEmpty() || jtxtKhuVuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
            return;
        }
        boolean t=kiemTraTonTaiNCC(jtxtTenNhaCungCap.getText(), jtxtKhuVuc.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t???i nh?? cung c???p ??? khu v???c n??y");
            return;
        }
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setTenNhaCungCap(jtxtTenNhaCungCap.getText());
        ncc.setKhuVuc(jtxtKhuVuc.getText());
        
        if (new NhaCungCapDAO().AddNhaCungCap(ncc)) {
            showComboboxNhaCungCapFrmSanPham();
            JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");
            list1.add(ncc); // them danh sach nha cung cap
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin");
        }

        xuatThongTinNhaCungCap();

    }//GEN-LAST:event_btnThem_NCCActionPerformed

    private void jbtnThem_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThem_KHActionPerformed

        if (jtxtTenKhachHang.getText().isEmpty() || jtxtDiaChi_KH.getText().isEmpty() || jtxtSDT_KH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui long nhap thong tin day du");
            return;
        }
        Boolean bl = isString(jtxtSDT_KH.getText());
        Boolean b2 = isSo(jtxtSDT_KH.getText());
        if (b2 == false) {
            JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ch???a k?? t??? A-Z");
            return;

        }
        if (bl == false) {
            JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ???????c qu?? 10-11 s???, ho???c ??t h??n 10 s???");
            return;
        }
        
        boolean t=kiemTraTonTaiKH(jtxtTenKhachHang.getText(), jtxtSDT_KH.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t???i kh??ch h??ng n??y");
            return;
        }
        KhachHangDTO kh = new KhachHangDTO();
        kh.setHoTen(jtxtTenKhachHang.getText());
        kh.setDiaChi(jtxtDiaChi_KH.getText());
        kh.setSDT(jtxtSDT_KH.getText());
        if (new KhachHangDAO().AddKhachHang(kh)) {
            //showComboboxKhachHangFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");
            list_KH.add(kh); // them danh sach nha cung cap
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin");
        }
        xuatThongTinKhachHang();
    }//GEN-LAST:event_jbtnThem_KHActionPerformed

    private void jbtnThem_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThem_NVActionPerformed

        if (jtxtTenNhanVien.getText().isEmpty() || jtxtDiaChi_NV.getText().isEmpty()
                || jtxtDiaChi_NV.getText().isEmpty() || jtxtCCCD.getText().isEmpty()
                || jtxtGioiTinh.getText().isEmpty() || jtxtSDT_NV.getText().isEmpty() || jtxtChucVu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
            return;
        }
        String CCCD = jtxtCCCD.getText();
        boolean t = kiemTraTonTaiNhanVien(CCCD);
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t???i nh??n vi??n v???i s??? cccd n??y");
            return;
        }
        
//        Boolean b0 = isSo(jtxtCCCD.getText());
//        if (b0 == false) {
//            JOptionPane.showMessageDialog(rootPane, "CCCD kh??ng ch???a k?? t??? A-Z");
//            return;
//        }
        
        Boolean bl = isString(jtxtSDT_NV.getText());
        if (bl == false) {
            JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ???????c qu?? 10-11 s???, ho???c ??t h??n 10 s???");
            return;
        }
        Boolean b2 = isSo(jtxtSDT_NV.getText());
        if (b2 == false) {
            JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ch???a k?? t??? A-Z");
            return;
        }
        NhanVienDTO nv = new NhanVienDTO();
        nv.setHoTen(jtxtTenNhanVien.getText());
        nv.setDiaChi_NV(jtxtDiaChi_NV.getText());
        nv.setCCCD(jtxtCCCD.getText());
        nv.setSDT_NV(jtxtSDT_NV.getText());
        nv.setChucVu(jtxtChucVu.getText());

        if ("nam".equals(jtxtGioiTinh.getText()) ||
             "Nam".equals(jtxtGioiTinh.getText()) ||  
              "NAM".equals(jtxtGioiTinh.getText())       
                ) {
            nv.setGioiTinh(true);
        } else 
        if ("n???".equals(jtxtGioiTinh.getText()) ||
             "N???".equals(jtxtGioiTinh.getText()) ||  
              "N???".equals(jtxtGioiTinh.getText()) ) {
            nv.setGioiTinh(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p Nam ho???c N???");
            return;
        }
        
        if (new NhanVienDAO().AddNhanVien(nv)) {
            //showComboboxNhanVienFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");
            list_NV.add(nv); // them danh sach nha cung cap
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin");
        }
        xuatThongTinNhanVien();
    }//GEN-LAST:event_jbtnThem_NVActionPerformed

    private void jbtnSua_LSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSua_LSPActionPerformed
        if (jtxtTenLoaiSanPham.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
            return;
        }
        boolean t=kiemTraTonTaiLSP(jtxtTenLoaiSanPham.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t??i t??n lo???i s???n ph???m n??y");
            return;
        }
        try {
            LoaiSanPhamDTO lspDTO = new LoaiSanPhamDTO();
            lspDTO.setMaLoaiSanPham(jtxtMaLoaiSanPham.getText());
            lspDTO.setTenLoaiSanPham(jtxtTenLoaiSanPham.getText());
            lspDAO.updateLoaiSanPham(lspDTO);
            JOptionPane.showMessageDialog(rootPane, "???? c???p nh???t th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "C???p nh???t b??? l???i!");
        }
        xuatThongTinLoaiSanPham();

    }//GEN-LAST:event_jbtnSua_LSPActionPerformed

    private void jbtnXoa_LSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoa_LSPActionPerformed
        try {
            LoaiSanPhamDAO lspDAO = new LoaiSanPhamDAO();
            lspDAO.delLoaiSanPham(jtxtTenLoaiSanPham.getText());
            showComboboxLoaiSanPhamFrmSanPham();
            showComboboxLoaiSanPhamFrmSanPham();
            JOptionPane.showMessageDialog(rootPane, "???? x??a th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? x??a th??ng tin!");
        }
        xuatThongTinLoaiSanPham();
    }//GEN-LAST:event_jbtnXoa_LSPActionPerformed

    private void jtblLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLoaiSanPhamMouseClicked

        int selectedRow = jtblLoaiSanPham.getSelectedRow();
        jtxtMaLoaiSanPham.setText((String) (model.getValueAt(selectedRow, 0)));
        jtxtTenLoaiSanPham.setText((String) (model.getValueAt(selectedRow, 1)));
    }//GEN-LAST:event_jtblLoaiSanPhamMouseClicked

    private void jtblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblNhaCungCapMouseClicked

        int selectedRow = jtblNhaCungCap.getSelectedRow();
        jtxtMaNhaCungCap.setText((String) (model1.getValueAt(selectedRow, 0)));
        jtxtTenNhaCungCap.setText((String) (model1.getValueAt(selectedRow, 1)));
        jtxtKhuVuc.setText((String) (model1.getValueAt(selectedRow, 2)));

    }//GEN-LAST:event_jtblNhaCungCapMouseClicked

    private void jbtnXoa_NhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoa_NhaCungCapActionPerformed
        try {
            NhaCungCapDAO nccDAO = new NhaCungCapDAO();
            nccDAO.delNhaCungCap(jtxtTenNhaCungCap.getText());
            showComboboxNhaCungCapFrmSanPham();
            JOptionPane.showMessageDialog(rootPane, "???? x??a th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? x??a th??ng tin!");
        }
        xuatThongTinNhaCungCap();
    }//GEN-LAST:event_jbtnXoa_NhaCungCapActionPerformed

    private void jbtnSua_NhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSua_NhaCungCapActionPerformed
        if (jtxtTenNhaCungCap.getText().isEmpty() || jtxtKhuVuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
            return;
        }
        boolean t=kiemTraTonTaiNCC(jtxtTenNhaCungCap.getText(), jtxtKhuVuc.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t??i nh?? cung c???p ??? khu v???c n??y");
            return;
        }
        try {
            NhaCungCapDTO nccDTO = new NhaCungCapDTO();
            nccDTO.setMaNhaCungCap(jtxtMaNhaCungCap.getText());
            nccDTO.setTenNhaCungCap(jtxtTenNhaCungCap.getText());
            nccDTO.setKhuVuc(jtxtKhuVuc.getText());
            nccDAO.updateNhaCungCap(nccDTO);
            showComboboxNhaCungCapFrmSanPham();
            JOptionPane.showMessageDialog(rootPane, "???? c???p nh???t th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin!");
        }
        xuatThongTinNhaCungCap();
    }//GEN-LAST:event_jbtnSua_NhaCungCapActionPerformed

    private void jbtnXoa_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoa_KhachHangActionPerformed

        try {
            KhachHangDAO khDAO = new KhachHangDAO();
            khDAO.delKhachHang(jtxtTenKhachHang.getText());
            //showComboboxKhachHangFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? x??a th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? x??a th??ng tin!");
        }
        xuatThongTinKhachHang();
    }//GEN-LAST:event_jbtnXoa_KhachHangActionPerformed

    private void jbtnSua_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSua_KhachHangActionPerformed
        try {
            if (jtxtTenKhachHang.getText().isEmpty() || jtxtDiaChi_KH.getText().isEmpty() || jtxtSDT_KH.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Vui long nhap thong tin day du");
                return;
            }
            Boolean bl = isString(jtxtSDT_KH.getText());
            Boolean b2 = isSo(jtxtSDT_KH.getText());
            if (b2 == false) {
                JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ch???a k?? t??? A-Z");
                return;

            }
            if (bl == false) {
                JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ???????c qu?? 10-11 s???, ho???c ??t h??n 10 s???");
                return;
            }

            boolean t = kiemTraTonTaiKH(jtxtTenKhachHang.getText(), jtxtSDT_KH.getText());
            if (t == false) {
                JOptionPane.showMessageDialog(rootPane, "???? t???n t???i kh??ch h??ng n??y");
                return;
            }
            KhachHangDTO khDTO = new KhachHangDTO();
            khDTO.setMaKhachHang(jtxtMaKhachHang.getText());
            khDTO.setHoTen(jtxtTenKhachHang.getText());
            khDTO.setDiaChi(jtxtDiaChi_KH.getText());
            khDTO.setSDT(jtxtSDT_KH.getText());
            khDAO.updateKhachHang(khDTO);
            //showComboboxKhachHangFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? c???p nh???t th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "C???p nh???t b??? l???i!");
        }
        xuatThongTinKhachHang();
    }//GEN-LAST:event_jbtnSua_KhachHangActionPerformed

    private void jtblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblKhachHangMouseClicked
        int selectedRow = jtblKhachHang.getSelectedRow();
        jtxtMaKhachHang.setText((String) (model_KH.getValueAt(selectedRow, 0)));
        jtxtTenKhachHang.setText((String) (model_KH.getValueAt(selectedRow, 1)));
        jtxtDiaChi_KH.setText((String) (model_KH.getValueAt(selectedRow, 2)));
        jtxtSDT_KH.setText((String) (model_KH.getValueAt(selectedRow, 3)));

    }//GEN-LAST:event_jtblKhachHangMouseClicked

    private void jtblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblNhanVienMouseClicked
        int selectedRow = jtblNhanVien.getSelectedRow();
        jtxtMaNhanVien.setText((String) (model_NV.getValueAt(selectedRow, 0)));
        jtxtTenNhanVien.setText((String) (model_NV.getValueAt(selectedRow, 1)));
        jtxtDiaChi_NV.setText((String) (model_NV.getValueAt(selectedRow, 2)));
        jtxtCCCD.setText((String) (model_NV.getValueAt(selectedRow, 3)));
        jtxtSDT_NV.setText((String) (model_NV.getValueAt(selectedRow, 4)));
        jtxtChucVu.setText((String) (model_NV.getValueAt(selectedRow, 5)));
        jtxtGioiTinh.setText((String) (model_NV.getValueAt(selectedRow, 6)));
        // jtxtGioiTinh.setText((boolean) (model_NV.getValueAt(selectedRow, 6)));
    }//GEN-LAST:event_jtblNhanVienMouseClicked

    private void jbtnXoa_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoa_NhanVienActionPerformed

        try {
            NhanVienDAO nvDAO = new NhanVienDAO();
            nvDAO.delNhanVien(jtxtTenNhanVien.getText());
            //showComboboxNhanVienFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? x??a th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? x??a th??ng tin!");
        }
        xuatThongTinNhanVien();
    }//GEN-LAST:event_jbtnXoa_NhanVienActionPerformed

    private void jbtnSua_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSua_NhanVienActionPerformed

        try {
            if (jtxtTenNhanVien.getText().isEmpty() || jtxtDiaChi_NV.getText().isEmpty()
                    || jtxtDiaChi_NV.getText().isEmpty() || jtxtCCCD.getText().isEmpty()
                    || jtxtGioiTinh.getText().isEmpty() || jtxtSDT_NV.getText().isEmpty() || jtxtChucVu.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
                return;
            }
            Boolean bl = isString(jtxtSDT_NV.getText());
            if (bl == false) {
                JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ???????c qu?? 10-11 s???, ho???c ??t h??n 10 s???");
                return;
            }
            Boolean b2 = isSo(jtxtSDT_NV.getText());
            if (b2 == false) {
                JOptionPane.showMessageDialog(rootPane, "SDT kh??ng ch???a k?? t??? A-Z");
                return;

            }
            
            NhanVienDTO nvDTO = new NhanVienDTO();
            nvDTO.setMaNhanVien(jtxtMaNhanVien.getText());
            nvDTO.setHoTen(jtxtTenNhanVien.getText());
            nvDTO.setDiaChi_NV(jtxtDiaChi_NV.getText());
            nvDTO.setCCCD(jtxtCCCD.getText());
            nvDTO.setSDT_NV(jtxtSDT_NV.getText());
            nvDTO.setChucVu(jtxtChucVu.getText());
            //nvDTO.setGioiTinh(jtxtGioiTinh.getText());
            
            

            if ("nam".equals(jtxtGioiTinh.getText()) ||
             "Nam".equals(jtxtGioiTinh.getText()) ||  
              "NAM".equals(jtxtGioiTinh.getText())       
                ) {
                nvDTO.setGioiTinh(true);
            } else {
                nvDTO.setGioiTinh(false);
            }
            nvDAO.updateNhanVien(nvDTO);
            //showComboboxNhanVienFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? c???p nh???t th??ng tin th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "C???p nh???t b??? l???i!");
        }
        xuatThongTinNhanVien();


    }//GEN-LAST:event_jbtnSua_NhanVienActionPerformed

    private void jtblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblSanPhamMouseClicked
        //"M?? S???n Ph???m" , "T??n S???n Ph???m " , "Gi?? S???n Ph???m" , "SL Hi???n C??" , "Ng??y Nh???p" , 
        //  "m?? Lo???i S???n Ph???m ", "M?? Nh?? Cung C???p"
        int selectedRow = jtblSanPham.getSelectedRow();
        jtxtMaSanPham.setText((String) (jtblSanPham.getValueAt(selectedRow, 0)));
        jtxtTenSanPham.setText((String) (jtblSanPham.getValueAt(selectedRow, 1)));
        jtxtGiaSanPham.setText(String.valueOf(jtblSanPham.getValueAt(selectedRow, 2)));
        jtxtSLHienCo.setText(String.valueOf(jtblSanPham.getValueAt(selectedRow, 3)));
        String date = String.valueOf(jtblSanPham.getValueAt(selectedRow, 4));
        jtxtNgayNhap.setText(date);
        jcbxLoaiSanPham.setSelectedItem(String.valueOf(jtblSanPham.getValueAt(selectedRow, 5)));
        jcbxNhaCungCap.setSelectedItem(String.valueOf(jtblSanPham.getValueAt(selectedRow, 6)));
    }//GEN-LAST:event_jtblSanPhamMouseClicked

    private void jbtnThem_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThem_SanPhamActionPerformed
        SanPhamDTO sp = new SanPhamDTO();
        try {
            sp.setNgayNhap(new SimpleDateFormat("dd-MM-yyyy").parse(jtxtNgayNhap.getText()));
            sp.setTenSanPham(jtxtTenSanPham.getText());

            sp.setGiaSanPham(Integer.valueOf(jtxtGiaSanPham.getText()));

            sp.setSLHienCo(jtxtSLHienCo.getText());
            String ncc_temp = (String) jcbxNhaCungCap.getSelectedItem();
            String LSP_temp = (String) jcbxLoaiSanPham.getSelectedItem();
            sp.setMaLoaiSanPham(LSP_temp);
            sp.setMaNhaCungCap(ncc_temp);
            if (jtxtTenSanPham.getText().isEmpty() || jtxtGiaSanPham.getText().isEmpty()
                    || jtxtSLHienCo.getText().isEmpty() || jtxtNgayNhap.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
                return;
            }
            if (Integer.parseInt(jtxtSLHienCo.getText()) < 0) {
                JOptionPane.showMessageDialog(rootPane, "So luong khong hop le!");
                return;
            }
            if (spDAO.AddSanPham(sp)) {
                // them danh sach sp
                list_SP.add(sp);
                //showComboboxSanPhamFrmHoaDon();
                JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");

            } else {
                JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin");
            }
            xuatThongTinSanPham();
            showTableSanPham_FrmThongTinBanHang();
            jpnlThongTinBanHang.setVisible(false);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jbtnThem_SanPhamActionPerformed

    private void jbtnXoa_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoa_SanPhamActionPerformed
        try {
            SanPhamDAO spDAO = new SanPhamDAO();
            spDAO.delSanPham(jtxtTenSanPham.getText());
            //showComboboxSanPhamFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? x??a th??ng tin th??nh c??ng!");
            xuatThongTinSanPham();
            showTableSanPham_FrmThongTinBanHang();
            jpnlThongTinBanHang.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? x??a th??ng tin!");
        }

    }//GEN-LAST:event_jbtnXoa_SanPhamActionPerformed

    private void jbtnSua_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSua_SanPhamActionPerformed
        try {
            if (jtxtTenSanPham.getText().isEmpty() || jtxtGiaSanPham.getText().isEmpty()
                    || jtxtSLHienCo.getText().isEmpty() || jtxtNgayNhap.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh??p th??ng tin ?????y ?????");
                return;
            }
            if (Integer.parseInt(jtxtSLHienCo.getText()) < 0) {
                JOptionPane.showMessageDialog(rootPane, "So luong khong hop le!");
                return;
            }
            
            SanPhamDTO spDTO = new SanPhamDTO();
            spDTO.setMaSanPham(jtxtMaSanPham.getText());
            spDTO.setTenSanPham(jtxtTenSanPham.getText());
            spDTO.setGiaSanPham(Integer.parseInt((String) jtxtGiaSanPham.getText()));
            spDTO.setSLHienCo(jtxtSLHienCo.getText());
            //spDTO.getNgayNhap(jtxtNgayNhap.get());
            spDTO.setNgayNhap(new SimpleDateFormat("dd-MM-yyyy").parse(jtxtNgayNhap.getText()));

            spDTO.setMaLoaiSanPham(jcbxLoaiSanPham.getSelectedItem().toString());
            spDTO.setMaNhaCungCap(jcbxNhaCungCap.getSelectedItem().toString());

            spDAO.updateSanPham(spDTO);
            //showComboboxSanPhamFrmHoaDon();
            JOptionPane.showMessageDialog(rootPane, "???? c???p nh???t th??ng tin th??nh c??ng!");
            xuatThongTinSanPham();
            showTableSanPham_FrmThongTinBanHang();
            jpnlThongTinBanHang.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "C???p nh???t b??? l???i!");
            e.printStackTrace();
        }

    }//GEN-LAST:event_jbtnSua_SanPhamActionPerformed

    private void jtxtTimKiemKhachHangTrongFrmKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTimKiemKhachHangTrongFrmKhachHangActionPerformed
        try {
            model_KH.setRowCount(0);
            // TODO add your handling code here:
            KhachHangDAO dao = new KhachHangDAO();

            ArrayList<KhachHangDTO> khachHang
                    = dao.findByID(jtxtTimKiemKhachHangTrongFrmKhachHang.getText());

            if (khachHang != null) {

                for (KhachHangDTO l : khachHang) {

                    model_KH.addRow(new Object[]{
                        l.getMaKhachHang(), l.getHoTen(), l.getDiaChi(), l.getSDT()
                    });
                }
            } else {
                xuatThongTinKhachHang();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Find failed!");
        }
    }//GEN-LAST:event_jtxtTimKiemKhachHangTrongFrmKhachHangActionPerformed

    private void jbtnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThanhToanActionPerformed
        jpnlLoaiSanPham.setVisible(false);
        jpnlThongTinBanHang.setVisible(true);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlKhachHang.setVisible(false);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_jbtnThanhToanActionPerformed

    private void jtxtMaHoaDon_FrmHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMaHoaDon_FrmHoaDonActionPerformed
        // TODO add your handling code here:
        try {
            model_HD.setRowCount(0);
            // TODO add your handling code here:
            HoaDonDAO dao = new HoaDonDAO();

            ArrayList<HoaDonDTO> hoaDon
                    = dao.findByID(jtxtMaHoaDon_FrmHoaDon.getText());

            if (hoaDon != null) {

                for (HoaDonDTO hd : hoaDon) {
                    //"M?? H??a ????n",  "Ng??y Mua ", "T???ng Ti???n",  "M?? Kh??ch H??ng", "M?? Nh??n Vi??n"
                    model_HD.addRow(new Object[]{
                        hd.getMaHoaDon(), hd.getNgayMua(), hd.getTongTien(), hd.getMaKhachHang(),
                        hd.getMaNhanVien()
                    });
                }
            } else {
                xuatThongTinHoaDon();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Kh??ng th??? t??m ki???m!");
        }
    }//GEN-LAST:event_jtxtMaHoaDon_FrmHoaDonActionPerformed

    private void jtblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblHoaDonMouseClicked
        // TODO add your handling code here:
        // xu???t chi ti???t h??a ????n

        showTableChiTietHoaDon();
    }//GEN-LAST:event_jtblHoaDonMouseClicked

    private void jtblSanPham_FrmThongTinBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblSanPham_FrmThongTinBanHangMouseClicked
        // TODO add your handling code here:
        int selectedRow = jtblSanPham_FrmThongTinBanHang.getSelectedRow();
        jtxtMaSP_FrmBanHang.setText((String) (model_SP_FrmBanHang.getValueAt(selectedRow, 0)));
        jtxtTenSP_frmBanHang.setText((String) (model_SP_FrmBanHang.getValueAt(selectedRow, 1)));
        jtxtGiaSP_FrmBanHang.setText(String.valueOf(model_SP_FrmBanHang.getValueAt(selectedRow, 2)));
    }//GEN-LAST:event_jtblSanPham_FrmThongTinBanHangMouseClicked
    public int RowTable = 0;
    private void jbtnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemGioHangActionPerformed
        // TODO add your handling code here:
        if(jtxtTenSP_frmBanHang.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "M???i ch???n s???n ph???m");
            return; 
        }
        if (jtxtSoLuong_FrmBanHang.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "M???i nh???p s??? l?????ng");
            return;
        }
        Boolean b2 = isSo(jtxtSoLuong_FrmBanHang.getText());
        if (b2==false){
            JOptionPane.showMessageDialog(rootPane, "S???n ph???m t???n t???i trong gi??? h??ng");
            return;
        }
        int selectedRow = jtblSanPham_FrmThongTinBanHang.getSelectedRow();
        if (Integer.parseInt(jtxtSoLuong_FrmBanHang.getText())
                > (Integer.parseInt((String) model_SP_FrmBanHang.getValueAt(selectedRow, 3)))) {
            JOptionPane.showMessageDialog(rootPane, "So luong khong du!");
            return;
        }
        
        if (Integer.parseInt(jtxtSoLuong_FrmBanHang.getText())
                <= 0) {
            JOptionPane.showMessageDialog(rootPane, "So luong khong hop le!");
            return;
        }
        
        boolean t=kiemTraTonTaiSP_GioHang_FrmHoaDon(jtxtMaSP_FrmBanHang.getText());
        if (t==false){
            JOptionPane.showMessageDialog(rootPane, "???? t???n t???i s???n ph???m n??y trong gi??? h??ng");
            return;
        }
        String maSP_temp = String.valueOf(jtxtMaSP_FrmBanHang.getText());
        String tenSP_temp = String.valueOf(jtxtTenSP_frmBanHang.getText());
        String soLuong_temp = String.valueOf(jtxtSoLuong_FrmBanHang.getText());
        String donGia_temp = String.valueOf(jtxtGiaSP_FrmBanHang.getText());
        //list_GioHang.add(maSP_temp,tenSP_temp, soLuong_temp, donGia_temp);
        model_GioHang_frmBanHang.addRow(new Object[]{
            maSP_temp, tenSP_temp, soLuong_temp, donGia_temp
        });
        RowTable++;
        showThanhTien();
        jtxtMaSP_FrmBanHang.setText("");
        jtxtTenSP_frmBanHang.setText("");
        jtxtSoLuong_FrmBanHang.setText("");
        jtxtGiaSP_FrmBanHang.setText("");
        jtxtTenSP_frmBanHang.setText("");
        jtxtSoLuong_FrmBanHang.setText("");
        jtxtGiaSP_FrmBanHang.setText("");
    }//GEN-LAST:event_jbtnThemGioHangActionPerformed

    private void jbtnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaGioHangActionPerformed
        // TODO add your handling code here:
        int selectedRow = jtblGioHang_frmBanHang.getSelectedRow();
        model_GioHang_frmBanHang.removeRow(selectedRow);
        RowTable--;
        showThanhTien();
    }//GEN-LAST:event_jbtnXoaGioHangActionPerformed

    private void jbtnSuaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaGioHangActionPerformed
        // TODO add your handling code here:
        if(jtxtTenSP_frmBanHang.getText().isEmpty()){
           JOptionPane.showMessageDialog(rootPane, "M???i ch???n s???n ph???m");
            return; 
        }
        if (jtxtSoLuong_FrmBanHang.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "M???i nh???p s??? l?????ng");
            return;
        }
        Boolean b2 = isSo(jtxtSoLuong_FrmBanHang.getText());
        if (b2==false){
            JOptionPane.showMessageDialog(rootPane, "S???n ph???m t???n t???i trong gi??? h??ng");
            return;
        }
        
        int selectedRow = jtblSanPham_FrmThongTinBanHang.getSelectedRow();
        if (Integer.parseInt(jtxtSoLuong_FrmBanHang.getText())
                > (Integer.parseInt((String) model_SP_FrmBanHang.getValueAt(selectedRow, 3)))) {
            JOptionPane.showMessageDialog(rootPane, "So luong khong du!");
            return;
        }
        String maSP = String.valueOf(jtxtMaSP_FrmBanHang.getText());
        String soLuong = String.valueOf(jtxtSoLuong_FrmBanHang.getText());
        if (String.valueOf(jtblGioHang_frmBanHang.getValueAt(selectedRow, 0)).
                equals(maSP)) {
            jtblGioHang_frmBanHang.setValueAt(soLuong, selectedRow, 2);
        }
        else{
            for (int i=0; i<RowTable; i++){
                if(String.valueOf(jtblGioHang_frmBanHang.getValueAt(i, 0)).
                equals(maSP))
                    jtblGioHang_frmBanHang.setValueAt(soLuong, selectedRow, 2);
            }
        }
         
        
        showThanhTien();
    }//GEN-LAST:event_jbtnSuaGioHangActionPerformed

    private void jbtnThanhToan_fromThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThanhToan_fromThanhToanActionPerformed
        HoaDonDTO hd = new HoaDonDTO();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        hd.setNgayMua(date);
        jtxtThanhTien_FrmHoaDon.setText(jtxtThanhTien.getText());
        hd.setTongTien(Integer.parseInt(jtxtThanhTien.getText()));
        //hd.setMaKhachHang(jcbxTenKhachHang_frmThanhToan.getSelectedItem().toString());
        hd.setMaKhachHang(jtxtKhachHang_frmThanhToan.getText());
        hd.setMaNhanVien(jcbxTenNhanVien_frmThanhToan.getSelectedItem().toString());
        if (jtxtKhachHang_frmThanhToan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p kh??ch h??ng");
            return;
        }

        else if (hdDAO.addHoaDon(hd)) {
            showTableHoaDon(); // g???n v??o form h??a ????n
            ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();// kh???i t???o cthd
            SanPhamDTO spdto = new SanPhamDTO();// khoi tao san ph???m
            int row_temp = model_HD.getRowCount() - 1; // l???y d??ng cu???i c??ng trong tbl h??a ????n
            cthd.setMaHoaDon((String) jtblHoaDon.getValueAt(row_temp, 0));
            for (int i = 0; i < RowTable; i++) {
                cthd.setMaSanPham((String) model_GioHang_frmBanHang.getValueAt(i, 0));
                cthd.setTenSanPham((String) model_GioHang_frmBanHang.getValueAt(i, 1));
                cthd.setSoLuong((String) model_GioHang_frmBanHang.getValueAt(i, 2));
                cthd.setDonGia((String) model_GioHang_frmBanHang.getValueAt(i, 3));

                cthdDAO.addChiTietHoaDon(cthd);

                for (SanPhamDTO sp : list_SP) {
                    if (sp.getMaSanPham().equals(cthd.getMaSanPham())) {
                        int slhc = Integer.parseInt(sp.getSLHienCo());
                        int slthanhToan = Integer.parseInt(cthd.getSoLuong());
                        int slupdate = slhc - slthanhToan;
//                        sp.setMaSanPham(cthd.getMaSanPham());
//                        sp.setTenSanPham(cthd.getTenSanPham());
//                        sp.setGiaSanPham(Integer.parseInt(cthd.getDonGia()));
                        sp.setSLHienCo(String.valueOf(slupdate));
                        try {
                            spDAO.updateSanPham(sp);
                            showTableSanPham_FrmThongTinBanHang();
                            showTableSanPham();
                        } catch (Exception ex) {
                            Logger.getLogger(manHinhChinh.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            jtxtMaHoaDon.setText((String) jtblHoaDon.getValueAt(row_temp, 0));

            model_GioHang_frmBanHang.setRowCount(0);
            RowTable = 0;
            JOptionPane.showMessageDialog(rootPane, "???? th??m th??ng tin th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???i kh??ng th??? th??m th??ng tin!");
            return;
        }
        jtxtMaHoaDon.setText("");
        jtxtThanhTien.setText("");
        jtxtKhachHang_frmThanhToan.setText("");
        jtxtThanhTien_FrmHoaDon.setText("");
    }//GEN-LAST:event_jbtnThanhToan_fromThanhToanActionPerformed

    private void jtxtTenNhanVienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTenNhanVienFocusLost
        String TenNhanVien = jtxtTenNhanVien.getText();
        if (TenNhanVien.length() > 0) {

        } else {
            JOptionPane.showMessageDialog(rootPane, "T??n nh??n vi??n kh??ng ???????c ????? tr???ng");
        }
    }//GEN-LAST:event_jtxtTenNhanVienFocusLost

    private void jTxtTimKiemTheoTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTimKiemTheoTenSanPhamActionPerformed
        try {
            model_SP.setRowCount(0);
            // TODO add your handling code here:
            SanPhamDAO dao = new SanPhamDAO();

            ArrayList<SanPhamDTO> sanPham
                    = dao.findByProductName(jTxtTimKiemTheoTenSanPham.getText());

            if (sanPham != null) {

                for (SanPhamDTO l : sanPham) {

                    model_SP.addRow(new Object[]{
                        l.getMaSanPham(), l.getTenSanPham(), l.getGiaSanPham(), l.getSLHienCo(),
                        l.getNgayNhap(), l.getMaLoaiSanPham(), l.getMaNhaCungCap()
                    });
                }
            } else {
                xuatThongTinSanPham();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Kh??ng th??? t??m ki???m !");
        }
    }//GEN-LAST:event_jTxtTimKiemTheoTenSanPhamActionPerformed

    private void jcbxNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxNhaCungCapActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String t1 = convertIDToName(jcbxNhaCungCap.getSelectedItem().toString(), jtblNhaCungCap);
            jtxtTenNCC.setText(t1);
        } catch (Exception ex) {
            Logger.getLogger(manHinhChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbxNhaCungCapActionPerformed

    private void jcbxLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String t1 = convertIDToName(jcbxLoaiSanPham.getSelectedItem().toString(), jtblLoaiSanPham);
            jtxtLoaiSanPham.setText(t1);
        } catch (Exception ex) {
            Logger.getLogger(manHinhChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbxLoaiSanPhamActionPerformed

    private void jbtnTimKiemKhachHang_frmThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTimKiemKhachHang_frmThanhToanActionPerformed
        // TODO add your handling code here:
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(false);
        jbtnXacNhanKhachHang.setVisible(true); // XAC NHAN KHACH HANG
        jpnlKhachHang.setVisible(true);
        jpnlThongTinBanHang.setVisible(false);
    }//GEN-LAST:event_jbtnTimKiemKhachHang_frmThanhToanActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        jpnlKhachHang.setVisible(false);
        jpnlLoaiSanPham.setVisible(false);
        jpnlNhaCungCap.setVisible(false);
        jpnlHoaDon.setVisible(false);
        jpnlSanPham.setVisible(false);
        jpnlNhanVien.setVisible(false);
        jpnlManHinhChinh.setVisible(false);
        jpnlThongTinBanHang.setVisible(false);
        jbtnXacNhanKhachHang.setVisible(false); // XAC NHAN KHACH HANG
        jpnlThongKe.setVisible(true);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jbntNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntNgayActionPerformed
        // TODO add your handling code here:
        QuanLyThongKeController controller = new QuanLyThongKeController();
        controller.setDataToChartDoanhThuTheoNgay(jpnlChartNgay);
    }//GEN-LAST:event_jbntNgayActionPerformed

    private void jbnThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnThangActionPerformed
        // TODO add your handling code here:
        QuanLyThongKeController controller = new QuanLyThongKeController();
        controller.setDataToChartDoanhThuTheoThang(jpnlChartNgay);
    }//GEN-LAST:event_jbnThangActionPerformed

    private void jbnNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnNamActionPerformed
        // TODO add your handling code here:
        QuanLyThongKeController controller = new QuanLyThongKeController();
        controller.setDataToChartDoanhThuTheoNam(jpnlChartNgay);
    }//GEN-LAST:event_jbnNamActionPerformed

    private void jtxtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMaKhachHangActionPerformed

    private void jbtnXacNhanKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXacNhanKhachHangActionPerformed
        // TODO add your handling code here:
        int selectedRow = jtblKhachHang.getSelectedRow();
        jtxtKhachHang_frmThanhToan.setText(String.valueOf(jtblKhachHang.getValueAt(selectedRow, 0)));
        jpnlKhachHang.setVisible(false);
        jpnlThongTinBanHang.setVisible(true);
        jbtnTimKiemKhachHang_frmThanhToan.setVisible(true);
    }//GEN-LAST:event_jbtnXacNhanKhachHangActionPerformed

    private void jtblGioHang_frmBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblGioHang_frmBanHangMouseClicked
        // TODO add your handling code here:
        int selectedRow = jtblGioHang_frmBanHang.getSelectedRow();
        jtxtMaSP_FrmBanHang.setText(String.valueOf(jtblGioHang_frmBanHang.getValueAt(selectedRow, 0)));
        jtxtTenSP_frmBanHang.setText(String.valueOf(jtblGioHang_frmBanHang.getValueAt(selectedRow, 1)));
        jtxtSoLuong_FrmBanHang.setText(String.valueOf(jtblGioHang_frmBanHang.getValueAt(selectedRow, 2)));
        jtxtGiaSP_FrmBanHang.setText(String.valueOf(jtblGioHang_frmBanHang.getValueAt(selectedRow, 3)));

    }//GEN-LAST:event_jtblGioHang_frmBanHangMouseClicked

    private void jtxtTimKiemKhachHangTrongFrmKhachHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTimKiemKhachHangTrongFrmKhachHangFocusGained
        // TODO add your handling code here:
        jtxtTimKiemKhachHangTrongFrmKhachHang.setText("");
    }//GEN-LAST:event_jtxtTimKiemKhachHangTrongFrmKhachHangFocusGained

    private void jtxtMaHoaDon_FrmHoaDonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMaHoaDon_FrmHoaDonFocusGained
        // TODO add your handling code here:
        jtxtMaHoaDon_FrmHoaDon.setText("");
    }//GEN-LAST:event_jtxtMaHoaDon_FrmHoaDonFocusGained
    
    public Boolean isString(String t) {
        if (t.length() < 10 || t.length() > 12) {
            return false;
        }
        return true;
    }

    public Boolean isSo(String t) {
        try {
            Integer.parseInt(t);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean kiemTraTonTaiNhanVien(String CCCD) {
        //int selectedRow = jtblNhanVien.getSelectedRow();
        for (NhanVienDTO temp : list_NV){
            if (temp.getCCCD().equals(CCCD)){
                return false;
            }
        }
        return true;
    }
    private boolean kiemTraTonTaiNCC(String NCC, String KhuVuc) {
        //int selectedRow = jtblSanPham.getSelectedRow();
        for (NhaCungCapDTO temp : list1){ // list1 l?? list nha cung cap
            if (temp.getTenNhaCungCap().toLowerCase().equals(NCC.toLowerCase())
                    && temp.getKhuVuc().toLowerCase().equals(KhuVuc.toLowerCase()) ){
                return false;
            }
        }
        return true;
    }
    private boolean kiemTraTonTaiKH(String TenKH, String SDT) {
        //int selectedRow = jtblSanPham.getSelectedRow();
        for (KhachHangDTO temp : list_KH){ // list1 l?? list nha cung cap
            if (temp.getHoTen().toLowerCase().equals(TenKH.toLowerCase())
                    && temp.getSDT().equals(SDT) ){
                return false;
            }
        }
        return true;
    }
    private boolean kiemTraTonTaiSP_GioHang_FrmHoaDon(String TSP) {
        //int selectedRow = jtblLoaiSanPham.getSelectedRow();
        for (int i=0; i<RowTable; i++) { // list1 l?? list nha cung cap
            String temp =String.valueOf(jtblGioHang_frmBanHang.getValueAt(i, 0));
            if (temp.equals(TSP)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean kiemTraTonTaiLSP(String LSP) {
        //int selectedRow = jtblLoaiSanPham.getSelectedRow();
        list_SP = new SanPhamDAO().getListSanPhamDTOs();
        for (LoaiSanPhamDTO temp : list_SP) { // list1 l?? list nha cung cap
            if (String.valueOf(temp.getTenLoaiSanPham()).toLowerCase().equals(LSP.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
        /* Set the Nimbus look and feel */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
//                new manHinhChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnLoaiSanPham;
    private javax.swing.JButton btnManHinhChinh;
    private javax.swing.JButton btnNhaCungCap;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThem_NCC;
    private javax.swing.JButton btnThongKe;
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jThem_LSP;
    private javax.swing.JTextField jTxtTimKiemTheoTenSanPham;
    private javax.swing.JButton jbnNam;
    private javax.swing.JButton jbnThang;
    private javax.swing.JButton jbntNgay;
    private javax.swing.JButton jbtnSuaGioHang;
    private javax.swing.JButton jbtnSua_KhachHang;
    private javax.swing.JButton jbtnSua_LSP;
    private javax.swing.JButton jbtnSua_NhaCungCap;
    private javax.swing.JButton jbtnSua_NhanVien;
    private javax.swing.JButton jbtnSua_SanPham;
    private javax.swing.JButton jbtnThanhToan;
    private javax.swing.JButton jbtnThanhToan_fromThanhToan;
    private javax.swing.JButton jbtnThemGioHang;
    private javax.swing.JButton jbtnThem_KH;
    private javax.swing.JButton jbtnThem_NV;
    private javax.swing.JButton jbtnThem_SanPham;
    private javax.swing.JButton jbtnTimKiemKhachHang_frmThanhToan;
    private javax.swing.JButton jbtnXacNhanKhachHang;
    private javax.swing.JButton jbtnXoaGioHang;
    private javax.swing.JButton jbtnXoa_KhachHang;
    private javax.swing.JButton jbtnXoa_LSP;
    private javax.swing.JButton jbtnXoa_NhaCungCap;
    private javax.swing.JButton jbtnXoa_NhanVien;
    private javax.swing.JButton jbtnXoa_SanPham;
    private javax.swing.JComboBox<String> jcbxLoaiSanPham;
    private javax.swing.JComboBox<String> jcbxNhaCungCap;
    private javax.swing.JComboBox<String> jcbxTenNhanVien_frmThanhToan;
    private javax.swing.JPanel jpnlChartNgay;
    private javax.swing.JPanel jpnlHoaDon;
    private javax.swing.JPanel jpnlKhachHang;
    private javax.swing.JPanel jpnlLoaiSanPham;
    private javax.swing.JPanel jpnlManHinhChinh;
    private javax.swing.JPanel jpnlNhaCungCap;
    private javax.swing.JPanel jpnlNhanVien;
    private javax.swing.JPanel jpnlSanPham;
    private javax.swing.JPanel jpnlThongKe;
    private javax.swing.JPanel jpnlThongTinBanHang;
    private javax.swing.JTable jtblChiTietHoaDon;
    private javax.swing.JTable jtblGioHang_frmBanHang;
    private javax.swing.JTable jtblHoaDon;
    private javax.swing.JTable jtblKhachHang;
    private javax.swing.JTable jtblLoaiSanPham;
    private javax.swing.JTable jtblNhaCungCap;
    private javax.swing.JTable jtblNhanVien;
    private javax.swing.JTable jtblSanPham;
    private javax.swing.JTable jtblSanPham_FrmThongTinBanHang;
    private javax.swing.JTextField jtxtCCCD;
    private javax.swing.JTextField jtxtChucVu;
    private javax.swing.JTextField jtxtDiaChi_KH;
    private javax.swing.JTextField jtxtDiaChi_NV;
    private javax.swing.JTextField jtxtGiaSP_FrmBanHang;
    private javax.swing.JTextField jtxtGiaSanPham;
    private javax.swing.JTextField jtxtGioiTinh;
    private javax.swing.JTextField jtxtKhachHang_frmThanhToan;
    private javax.swing.JTextField jtxtKhuVuc;
    private javax.swing.JTextField jtxtLoaiSanPham;
    private javax.swing.JTextField jtxtMaHoaDon;
    private javax.swing.JTextField jtxtMaHoaDon_FrmHoaDon;
    private javax.swing.JTextField jtxtMaKhachHang;
    private javax.swing.JTextField jtxtMaLoaiSanPham;
    private javax.swing.JTextField jtxtMaNhaCungCap;
    private javax.swing.JTextField jtxtMaNhanVien;
    private javax.swing.JTextField jtxtMaSP_FrmBanHang;
    private javax.swing.JTextField jtxtMaSanPham;
    private javax.swing.JTextField jtxtNgayNhap;
    private javax.swing.JTextField jtxtSDT_KH;
    private javax.swing.JTextField jtxtSDT_NV;
    private javax.swing.JTextField jtxtSLHienCo;
    private javax.swing.JTextField jtxtSoLuong_FrmBanHang;
    private javax.swing.JTextField jtxtTenKhachHang;
    private javax.swing.JTextField jtxtTenLoaiSanPham;
    private javax.swing.JTextField jtxtTenNCC;
    private javax.swing.JTextField jtxtTenNhaCungCap;
    private javax.swing.JTextField jtxtTenNhanVien;
    private javax.swing.JTextField jtxtTenSP_frmBanHang;
    private javax.swing.JTextField jtxtTenSanPham;
    private javax.swing.JTextField jtxtThanhTien;
    private javax.swing.JTextField jtxtThanhTien_FrmHoaDon;
    private javax.swing.JTextField jtxtTimKiemKhachHangTrongFrmKhachHang;
    private javax.swing.JPanel pnlCards;
    // End of variables declaration//GEN-END:variables

    Connection conn;

    private void showComboboxNhaCungCapFrmSanPham() {
        try {
            updatecbxNhaCungCap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updatecbxNhaCungCap() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
                + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
        String sql = "select MaNhaCungCap from NhaCungCap ";
        PreparedStatement pss = conn.prepareStatement(sql);
        ResultSet rs = pss.executeQuery();
        jcbxNhaCungCap.removeAllItems();
        while (rs.next()) {
            jcbxNhaCungCap.addItem(rs.getString("MaNhaCungCap"));
        }
        return pss.executeUpdate() > 0;
    }
    // h??m show combobox NhaCungCap trong frm San Pham

    //=====================================================================
    // h??m show combobox khach hang trong frm hoa don
    private void showComboboxLoaiSanPhamFrmSanPham() {
        try {
            updatecbxLoaiSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updatecbxLoaiSanPham() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
                + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
        String sql = "select MaLoaiSanPham from LoaiSanPham ";
        PreparedStatement pss = conn.prepareStatement(sql);
        ResultSet rs = pss.executeQuery();
        jcbxLoaiSanPham.removeAllItems();
        while (rs.next()) {
            jcbxLoaiSanPham.addItem(rs.getString("MaLoaiSanPham"));
        }
        return pss.executeUpdate() > 0;
    }

    private void showComboboxNhanVienFrmThanhToan() {
        try {
            updatecbxNhanVien();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updatecbxNhanVien() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLTBDT;"
                + "username=sa;password=123;encrypt=true;trustServerCertificate=true");
        String sql = "select MaNhanVien, TenNhanVien from NhanVien ";
        PreparedStatement pss = conn.prepareStatement(sql);
        ResultSet rs = pss.executeQuery();
        jcbxTenNhanVien_frmThanhToan.removeAllItems();
        while (rs.next()) {
            jcbxTenNhanVien_frmThanhToan.addItem(rs.getString("MaNhanVien"));
        }
        return pss.executeUpdate() > 0;
    }

    // h??m show combobox Nhan Vien trong frm hoa don
    private void showTableHoaDon() {
        list_HD = new HoaDonDAO().getListHoaDonDTOs();
        model_HD.setRowCount(0);
        for (HoaDonDTO hd : list_HD) {
            model_HD.addRow(new Object[]{
                hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getNgayMua(), hd.getTongTien(),
                hd.getMaNhanVien()
            });
        }
    }

    private void showTableChiTietHoaDon() {
        list_CTHD = new ChiTietHoaDonDAO().getListChiTietHoaDonDTOs();
        model_CTHD.setRowCount(0);
        int selectedRow = jtblHoaDon.getSelectedRow();
        for (ChiTietHoaDonDTO cthd : list_CTHD) {
            if (cthd.getMaHoaDon().equals(jtblHoaDon.getValueAt(selectedRow, 0))) {
                model_CTHD.addRow(new Object[]{
                    cthd.getMaSanPham(), cthd.getTenSanPham(), cthd.getSoLuong(),
                    cthd.getDonGia()
                });
            }
        }
    }

    private void showTableSanPham_FrmThongTinBanHang() {
        list_SP = new SanPhamDAO().getListSanPhamDTOs();
        model_SP_FrmBanHang.setRowCount(0);
        for (SanPhamDTO sp : list_SP) {
            model_SP_FrmBanHang.addRow(new Object[]{
                sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaSanPham(),
                sp.getSLHienCo(), sp.getMaNhaCungCap()
            });
        }
    }

    private void xuatThongTinLoaiSanPham() {
        DefaultTableModel model = (DefaultTableModel) jtblLoaiSanPham.getModel();
        model.setRowCount(0);
        jtxtMaLoaiSanPham.setText("");
        jtxtTenLoaiSanPham.setText("");
        showTableLoaiSanPham();
    }

    private void xuatThongTinNhaCungCap() {
        DefaultTableModel model = (DefaultTableModel) jtblNhaCungCap.getModel();
        model.setRowCount(0);
        jtxtMaNhaCungCap.setText("");
        jtxtTenNhaCungCap.setText("");
        jtxtKhuVuc.setText("");
        showTableNhaCungCap();
    }

    private void xuatThongTinKhachHang() {
        DefaultTableModel model = (DefaultTableModel) jtblKhachHang.getModel();
        model.setRowCount(0);
        jtxtTenKhachHang.setText("");
        jtxtDiaChi_KH.setText("");
        jtxtSDT_KH.setText("");
        showTableKhachHang();
    }

    private void xuatThongTinNhanVien() {
        DefaultTableModel model = (DefaultTableModel) jtblNhanVien.getModel();
        model.setRowCount(0);
        jtxtTenNhanVien.setText("");
        jtxtDiaChi_NV.setText("");
        jtxtCCCD.setText("");
        jtxtSDT_NV.setText("");
        jtxtChucVu.setText("");
        jtxtGioiTinh.setText("");

        showTableNhanVien();
    }

    private void xuatThongTinSanPham() {
        DefaultTableModel model = (DefaultTableModel) jtblSanPham.getModel();
        model.setRowCount(0);
        jtxtTenSanPham.setText("");
        jtxtGiaSanPham.setText("");
        jtxtSLHienCo.setText("");
        jtxtNgayNhap.setText("");
        showTableSanPham();
    }

    private void xuatThongTinHoaDon() {
        DefaultTableModel model = (DefaultTableModel) jtblHoaDon.getModel();
        model.setRowCount(0);
        showTableHoaDon();
    }

    private void showTableLoaiSanPham() {
        list = new LoaiSanPhamDAO().getListLoaiSanPhamDTOs();
        for (LoaiSanPhamDTO l : list) {
            model.addRow(new Object[]{
                l.getMaLoaiSanPham(), l.getTenLoaiSanPham()
            });
        }
    }

    private void showTableNhaCungCap() {
        list1 = new NhaCungCapDAO().getListNhaCungCapDTOs();
        for (NhaCungCapDTO l : list1) {
            model1.addRow(new Object[]{
                l.getMaNhaCungCap(), l.getTenNhaCungCap(), l.getKhuVuc()
            });
        }
    }

    private void showTableKhachHang() {
        list_KH = new KhachHangDAO().getListKhachHangDTOs();
        for (KhachHangDTO l : list_KH) {
            model_KH.addRow(new Object[]{
                l.getMaKhachHang(), l.getHoTen(), l.getDiaChi(), l.getSDT()
            });
        }
    }

    private void showTableNhanVien() {
        list_NV = new NhanVienDAO().getListNhanVienDTOs();

        for (NhanVienDTO l : list_NV) {
            String gt_temp = (l.getGioiTinh() == true) ? "Nam" : "N???";
            model_NV.addRow(new Object[]{
                l.getMaNhanVien(), l.getHoTen(), l.getDiaChi_NV(), l.getCCCD(),
                l.getSDT_NV(), l.getChucVu(),
                gt_temp

            });

        }
    }

    private void showTableSanPham() {
        list_SP = new SanPhamDAO().getListSanPhamDTOs();
        model_SP.setRowCount(0);
        for (SanPhamDTO l : list_SP) {
            model_SP.addRow(new Object[]{
                l.getMaSanPham(), l.getTenSanPham(), l.getGiaSanPham(), l.getSLHienCo(),
                l.getNgayNhap(), l.getMaLoaiSanPham(),
                l.getMaNhaCungCap()
            });
        }
    }

    private void showThanhTien() {
        int tong = 0;
        for (int i = 0; i < RowTable; i++) {
            tong
                    += (Integer.parseInt((String) jtblGioHang_frmBanHang.getValueAt(i, 3))
                    * Integer.parseInt((String) jtblGioHang_frmBanHang.getValueAt(i, 2)));
        }
        String temp_tong = String.valueOf(tong);
        jtxtThanhTien.setText((temp_tong));
    }

    private String convertIDToName(String maNCC, JTable temp) throws Exception {
        //updatecbxNhaCungCap();
        for (int i = 0; i < temp.getRowCount(); i++) {
            if (maNCC.equals(String.valueOf(temp.getValueAt(i, 0)))) {

                return (String.valueOf(temp.getValueAt(i, 1)));
            }
        }
        return null;
    }

   
    
}
