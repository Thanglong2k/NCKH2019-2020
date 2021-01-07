package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import check_data.StandardOutput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.ChiDoan_modify;
import modify_object.StudentModify;
import object_frame.ChiDoan;
import object_frame.Student;

public class QLDoanVien extends JInternalFrame {
	private JTextField Masv;
	private JTextField CMND;
	private JTextField DT;
	private JTextField TonGiao;
	private JTextField DCHienTai;
	private JTextField Ho;
	private JTextField Ten;
	private JTextField Que;
	private JTextField NgaySinh;
	private JTextField Email;
	private JTextField DanToc;
	private JTextField NoiSinh;
	private JTextField HCGiaDinh;
	private JTextField NangKhieu;
	private JTextField DiemTLuy;
	private static JTable tableDoanVien;
	private JTextField NgayVaoDoan;
	private JTextField NgayVaoDang;
	private static JTextField ChucVu;
	private JTextArea GhiChu;
	private JPanel TTCT;
	private JScrollPane scrollPane;
	private JComboBox TenChiDoan;
	private JComboBox GioiTinh;
	private JButton btnChon;
	private JPanel panel_image;
	private JLabel lblImage;
	private JButton btnXuatFileExcel;
	private JButton btnSapXep;
	private JLabel blbMa;
	private JLabel blbCMND;
	private JLabel blbNgVDoan;
	private JLabel blbDT;
	private JLabel blbDanToc;
	private JLabel blbDCHienTai;
	private JLabel blbHo;
	private JLabel blbQueQuan;
	private JLabel blbChucVu;
	private JLabel blbNoiSinh;
	private JLabel blbTen;
	private JLabel blbNgSinh;
	private JLabel blbNgVaoDang;
	private JLabel blbTonGiao;
	private JLabel blbNangKhieu;
	private JLabel blbHCGiaDinh;
	private JLabel blbDiemTLuy;
	private JLabel blbTenChiDoan;
	private JLabel blbEmail;

	String filename = null;
	byte[] sv_img = null;
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	public static List<Student> studentList = new ArrayList<Student>();
	Map<String, Integer> Mchidoan = new HashMap<String, Integer>();
	private JLabel lblNewLabel_1;
	private JButton btnNhap;
	private JButton btnSua;
	private JButton btnXoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDoanVien frame = new QLDoanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public QLDoanVien() throws IOException, SQLException {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(new Color(214, 221, 228));
		setMaximizable(true);
		setResizable(true);
		setTitle("Quản Lý Đoàn Viên");
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		setClosable(true);
		setBounds(100, 100, 1178, 775);
		getContentPane().setLayout(null);

		TTCT = new JPanel();
		TTCT.setBackground(Color.WHITE);
		TTCT.setBounds(10, 10, 953, 337);
		getContentPane().add(TTCT);
		TTCT.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Mã SV");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(8, 28, 84, 25);
		TTCT.add(lblNewLabel_3);

		Masv = new JTextField();
		Masv.setBackground(UIManager.getColor("Button.background"));
		Masv.setFont(new Font("Calibri", Font.PLAIN, 10));
		Masv.setBounds(106, 29, 164, 19);
		TTCT.add(Masv);
		Masv.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CMND");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(8, 59, 84, 25);
		TTCT.add(lblNewLabel_4);

		CMND = new JTextField();
		CMND.setBackground(UIManager.getColor("Button.background"));
		CMND.setBounds(106, 61, 164, 19);
		TTCT.add(CMND);
		CMND.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Điện Thoại");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(8, 118, 84, 25);
		TTCT.add(lblNewLabel_6);

		DT = new JTextField();
		DT.setBackground(UIManager.getColor("Button.background"));
		DT.setBounds(106, 119, 164, 19);
		TTCT.add(DT);
		DT.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tôn Giáo");
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(622, 90, 59, 25);
		TTCT.add(lblNewLabel_7);

		TonGiao = new JTextField();
		TonGiao.setBackground(UIManager.getColor("Button.background"));
		TonGiao.setBounds(759, 90, 163, 19);
		TTCT.add(TonGiao);
		TonGiao.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Địa Chỉ Hiện Tại");
		lblNewLabel_8.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(8, 176, 97, 25);
		TTCT.add(lblNewLabel_8);

		DCHienTai = new JTextField();
		DCHienTai.setBackground(UIManager.getColor("Button.background"));
		DCHienTai.setBounds(106, 177, 164, 19);
		TTCT.add(DCHienTai);
		DCHienTai.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Họ");
		lblNewLabel_10.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(309, 28, 42, 25);
		TTCT.add(lblNewLabel_10);

		Ho = new JTextField();
		Ho.setBackground(UIManager.getColor("Button.background"));
		Ho.setBounds(402, 29, 186, 19);
		TTCT.add(Ho);
		Ho.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Tên");
		lblNewLabel_11.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(309, 61, 42, 21);
		TTCT.add(lblNewLabel_11);

		Ten = new JTextField();
		Ten.setBackground(UIManager.getColor("Button.background"));
		Ten.setBounds(402, 60, 186, 19);
		TTCT.add(Ten);
		Ten.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Quê Quán");
		lblNewLabel_12.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(309, 93, 84, 19);
		TTCT.add(lblNewLabel_12);

		Que = new JTextField();
		Que.setBackground(UIManager.getColor("Button.background"));
		Que.setBounds(403, 91, 185, 19);
		TTCT.add(Que);
		Que.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Ngày Sinh");
		lblNewLabel_13.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(622, 28, 74, 25);
		TTCT.add(lblNewLabel_13);

		NgaySinh = new JTextField();
		NgaySinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NgaySinh.setText("");
			}
		});
		
		NgaySinh.setText("yyyy-mm-dd");
		
		NgaySinh.setBackground(UIManager.getColor("Button.background"));
		NgaySinh.setBounds(759, 29, 163, 19);
		TTCT.add(NgaySinh);
		NgaySinh.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Email");
		lblNewLabel_14.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(309, 118, 42, 25);
		TTCT.add(lblNewLabel_14);

		Email = new JTextField();
		Email.setBackground(UIManager.getColor("Button.background"));
		Email.setBounds(403, 119, 185, 19);
		TTCT.add(Email);
		Email.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Dân Tộc");
		lblNewLabel_16.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(8, 147, 74, 25);
		TTCT.add(lblNewLabel_16);

		DanToc = new JTextField();
		DanToc.setBackground(UIManager.getColor("Button.background"));
		DanToc.setBounds(106, 148, 164, 19);
		TTCT.add(DanToc);
		DanToc.setColumns(10);

		NoiSinh = new JTextField();
		NoiSinh.setBackground(UIManager.getColor("Button.background"));
		NoiSinh.setBounds(402, 148, 186, 19);
		TTCT.add(NoiSinh);
		NoiSinh.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Nơi Sinh");
		lblNewLabel_17.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(309, 147, 74, 25);
		TTCT.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Hoàn Cảnh Gia Đình");
		lblNewLabel_18.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_18.setBounds(622, 147, 127, 25);
		TTCT.add(lblNewLabel_18);

		HCGiaDinh = new JTextField();
		HCGiaDinh.setBackground(UIManager.getColor("Button.background"));
		HCGiaDinh.setBounds(759, 148, 163, 19);
		TTCT.add(HCGiaDinh);
		HCGiaDinh.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("Năng Khiếu");
		lblNewLabel_19.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_19.setBounds(622, 120, 74, 21);
		TTCT.add(lblNewLabel_19);

		NangKhieu = new JTextField();
		NangKhieu.setBackground(UIManager.getColor("Button.background"));
		NangKhieu.setBounds(759, 119, 163, 19);
		TTCT.add(NangKhieu);
		NangKhieu.setColumns(10);

		DiemTLuy = new JTextField();
		DiemTLuy.setBackground(UIManager.getColor("Button.background"));
		DiemTLuy.setBounds(402, 177, 186, 19);
		TTCT.add(DiemTLuy);
		DiemTLuy.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Điểm Tích Lũy");
		lblNewLabel_20.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(309, 178, 84, 21);
		TTCT.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("Ngày Vào Đoàn");
		lblNewLabel_21.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(8, 90, 97, 25);
		TTCT.add(lblNewLabel_21);

		NgayVaoDoan = new JTextField();
		NgayVaoDoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NgayVaoDoan.setText("");
			}
		});
		NgayVaoDoan.setText("yyyy-mm-dd");
		NgayVaoDoan.setBackground(UIManager.getColor("Button.background"));
		NgayVaoDoan.setBounds(106, 90, 164, 19);
		TTCT.add(NgayVaoDoan);
		NgayVaoDoan.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Ngày Vào Đảng");
		lblNewLabel_22.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(622, 59, 99, 25);
		TTCT.add(lblNewLabel_22);

		NgayVaoDang = new JTextField();
		NgayVaoDang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NgayVaoDang.setText("");
			}
		});
		NgayVaoDang.setText("yyyy-mm-dd");
		NgayVaoDang.setBackground(UIManager.getColor("Button.background"));
		NgayVaoDang.setBounds(759, 58, 163, 19);
		TTCT.add(NgayVaoDang);
		NgayVaoDang.setColumns(10);

		blbMa = new JLabel("x");
		blbMa.setForeground(Color.RED);
		blbMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbMa.setBounds(272, 24, 14, 25);
		TTCT.add(blbMa);

		blbCMND = new JLabel("x");
		blbCMND.setForeground(Color.RED);
		blbCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbCMND.setBounds(272, 56, 14, 25);
		TTCT.add(blbCMND);

		blbNgVDoan = new JLabel("x");
		blbNgVDoan.setForeground(Color.RED);
		blbNgVDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbNgVDoan.setBounds(272, 86, 14, 25);
		TTCT.add(blbNgVDoan);

		blbDT = new JLabel("x");
		blbDT.setForeground(Color.RED);
		blbDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbDT.setBounds(272, 114, 14, 25);
		TTCT.add(blbDT);

		blbDanToc = new JLabel("x");
		blbDanToc.setForeground(Color.RED);
		blbDanToc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbDanToc.setBounds(272, 143, 14, 25);
		TTCT.add(blbDanToc);

		blbDCHienTai = new JLabel("x");
		blbDCHienTai.setForeground(Color.RED);
		blbDCHienTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbDCHienTai.setBounds(272, 172, 14, 25);
		TTCT.add(blbDCHienTai);

		blbHo = new JLabel("x");
		blbHo.setForeground(Color.RED);
		blbHo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbHo.setBounds(590, 28, 14, 25);
		TTCT.add(blbHo);

		blbQueQuan = new JLabel("x");
		blbQueQuan.setForeground(Color.RED);
		blbQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbQueQuan.setBounds(590, 86, 14, 25);
		TTCT.add(blbQueQuan);

		blbEmail = new JLabel("x");
		blbEmail.setForeground(Color.RED);
		blbEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbEmail.setBounds(590, 114, 14, 25);
		TTCT.add(blbEmail);

		blbNoiSinh = new JLabel("x");
		blbNoiSinh.setForeground(Color.RED);
		blbNoiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbNoiSinh.setBounds(590, 148, 14, 25);
		TTCT.add(blbNoiSinh);

		blbTen = new JLabel("x");
		blbTen.setForeground(Color.RED);
		blbTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbTen.setBounds(590, 55, 14, 25);
		TTCT.add(blbTen);

		blbNgSinh = new JLabel("x");
		blbNgSinh.setForeground(Color.RED);
		blbNgSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbNgSinh.setBounds(929, 24, 14, 25);
		TTCT.add(blbNgSinh);

		blbNgVaoDang = new JLabel("x");
		blbNgVaoDang.setForeground(Color.RED);
		blbNgVaoDang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbNgVaoDang.setBounds(929, 55, 14, 25);
		TTCT.add(blbNgVaoDang);

		blbTonGiao = new JLabel("x");
		blbTonGiao.setForeground(Color.RED);
		blbTonGiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbTonGiao.setBounds(929, 86, 14, 25);
		TTCT.add(blbTonGiao);

		blbNangKhieu = new JLabel("x");
		blbNangKhieu.setForeground(Color.RED);
		blbNangKhieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbNangKhieu.setBounds(929, 114, 14, 25);
		TTCT.add(blbNangKhieu);

		blbHCGiaDinh = new JLabel("x");
		blbHCGiaDinh.setForeground(Color.RED);
		blbHCGiaDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbHCGiaDinh.setBounds(929, 143, 21, 25);
		TTCT.add(blbHCGiaDinh);

		blbDiemTLuy = new JLabel("x");
		blbDiemTLuy.setForeground(Color.RED);
		blbDiemTLuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		blbDiemTLuy.setBounds(590, 172, 14, 25);
		TTCT.add(blbDiemTLuy);

		JLabel lblNewLabel = new JLabel(
				"_____Nhập Thông Tin____________________________________________________________________________________________________________________________");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 0, 943, 13);
		TTCT.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Tên Chi Đoàn");
		lblNewLabel_2.setBounds(8, 206, 97, 26);
		TTCT.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));

		TenChiDoan = new JComboBox();
		TenChiDoan.setBounds(106, 206, 164, 21);
		TTCT.add(TenChiDoan);
		TenChiDoan.addItem("(Chọn Tên Chi Đoàn)");
		TenChiDoan.setBackground(UIManager.getColor("Button.background"));

		JLabel lblNewLabel_5 = new JLabel("Giới Tính");
		lblNewLabel_5.setBounds(622, 176, 84, 25);
		TTCT.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 14));

		GioiTinh = new JComboBox();
		GioiTinh.setBounds(759, 176, 163, 21);
		TTCT.add(GioiTinh);
		GioiTinh.setBackground(UIManager.getColor("Button.background"));
		GioiTinh.addItem("Nam");
		GioiTinh.addItem("Nu");

		blbTenChiDoan = new JLabel("x");
		blbTenChiDoan.setBounds(272, 202, 14, 25);
		TTCT.add(blbTenChiDoan);
		blbTenChiDoan.setForeground(Color.RED);
		blbTenChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_15 = new JLabel("Chức vụ");
		lblNewLabel_15.setBounds(8, 235, 74, 25);
		TTCT.add(lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("Calibri", Font.PLAIN, 14));

		ChucVu = new JTextField();
		ChucVu.setBounds(106, 237, 164, 19);
		TTCT.add(ChucVu);
		ChucVu.setBackground(UIManager.getColor("Button.background"));
		ChucVu.setEditable(false);
		ChucVu.setColumns(10);

		blbChucVu = new JLabel("x");
		blbChucVu.setBounds(272, 230, 14, 25);
		TTCT.add(blbChucVu);
		blbChucVu.setForeground(Color.RED);
		blbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnLuaChon = new JButton("Lựa Chọn");
		btnLuaChon.setForeground(Color.WHITE);
		btnLuaChon.setBounds(106, 266, 106, 21);
		TTCT.add(btnLuaChon);
		btnLuaChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonChucVu CV = new ChonChucVu();
				CV.setVisible(true);
			}
		});
		btnLuaChon.setBackground(new Color(65,49,102));
		btnLuaChon.setFont(new Font("Calibri", Font.PLAIN, 11));

		GhiChu = new JTextArea();
		GhiChu.setBounds(402, 229, 520, 97);
		TTCT.add(GhiChu);
		GhiChu.setBackground(UIManager.getColor("Button.background"));

		lblNewLabel_1 = new JLabel("Ghi Chú");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(309, 235, 74, 25);
		TTCT.add(lblNewLabel_1);

		scrollPane = new JScrollPane(tableDoanVien, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 417, 1145, 323);
		getContentPane().add(scrollPane);

		tableDoanVien = new JTable();
		tableDoanVien.setBackground(Color.WHITE);
		tableDoanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableDoanVien.getSelectedRow();
				Student student = studentList.get(index);
				setText(student);
			}
		});
		tableDoanVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tableDoanVien);
		setBackground(Color.WHITE);

		panel_image = new JPanel();
		panel_image.setBackground(Color.WHITE);
		panel_image.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Avatar", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_image.setBounds(986, 10, 169, 220);
		getContentPane().add(panel_image);
		panel_image.setLayout(null);

		lblImage = new JLabel("");
		lblImage.setBounds(10, 20, 149, 190);
		panel_image.add(lblImage);
		lblImage.setBackground(Color.WHITE);

		btnChon = new JButton("Chọn Ảnh");
		btnChon.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/searchimg.png")));
		btnChon.setForeground(Color.WHITE);
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFileImage();
			}
		});
		btnChon.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnChon.setBackground(new Color(65,49,102));
		btnChon.setBounds(986, 240, 169, 43);
		getContentPane().add(btnChon);

		JButton btnT = new JButton("Tìm Kiếm");
		btnT.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/search.png")));
		btnT.setForeground(Color.WHITE);
		btnT.setBounds(986, 293, 168, 43);
		getContentPane().add(btnT);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemDoanVien tk = new TimKiemDoanVien();
				tk.setVisible(true);

			}
		});
		btnT.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnT.setBackground(new Color(65,49,102));

		btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(Color.WHITE);
		btnSapXep.setBounds(986, 364, 168, 43);
		getContentPane().add(btnSapXep);
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepDoanVien sx = new SapXepDoanVien();
				sx.setVisible(true);
			}
		});
		btnSapXep.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSapXep.setBackground(new Color(65,49,102));

		btnXuatFileExcel = new JButton("Excel");
		btnXuatFileExcel.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/export.png")));
		btnXuatFileExcel.setForeground(Color.WHITE);
		btnXuatFileExcel.setBounds(10, 357, 119, 43);
		getContentPane().add(btnXuatFileExcel);
		btnXuatFileExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();

			}
		});
		btnXuatFileExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXuatFileExcel.setBackground(new Color(65,49,102));

		btnNhap = new JButton("Nhập");
		btnNhap.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/insert.png")));
		btnNhap.setForeground(Color.WHITE);
		btnNhap.setBounds(541, 364, 130, 43);
		getContentPane().add(btnNhap);
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnNhap.setBackground(new Color(65,49,102));
		btnNhap.setFont(new Font("Calibri", Font.PLAIN, 20));

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/edit.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBounds(681, 364, 120, 43);
		getContentPane().add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				update();
			}
		});
		btnSua.setBackground(new Color(65,49,102));
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 20));

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/delete.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBounds(811, 364, 120, 43);
		getContentPane().add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				delete();
			}
		});
		btnXoa.setBackground(new Color(65,49,102));
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 20));

		JButton btnThoat = new JButton("Làm Mới");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setIcon(new ImageIcon(QLDoanVien.class.getResource("/buttonImages/refresh.png")));
		btnThoat.setBounds(139, 357, 145, 43);
		getContentPane().add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDoanVien.showStudent(StudentModify.findAll());
				reset();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));

		if (ktCot == 0) {
			insertColumn();
		}
		showStudent(StudentModify.findAll());
		setcomboBox();
		setVisibleFalse();
		isPermission();

	}

	private void setcomboBox() {
		// ánh xạ từ mã chi đoàn ra tên chi đoàn qua map
		for (ChiDoan x : ChiDoan_modify.findAll()) {
			Mchidoan.put(x.getTenChiDoan(), x.getMaChiDoan());
		}
		for (String key : Mchidoan.keySet()) {
			TenChiDoan.addItem(key);
		}
	}

	private void insertColumn() {
		// tạo cột cho bảng
		ktCot = 1;
		model.addColumn("MaSV");
		model.addColumn("Ho");
		model.addColumn("Ten");
		model.addColumn("CMND");
		model.addColumn("NgaySinh");
		model.addColumn("QueQuan");
		model.addColumn("GioiTinh");
		model.addColumn("NgayVaoDoan");
		model.addColumn("NgayVaoDang");
		model.addColumn("DienThoai");
		model.addColumn("Email");
		model.addColumn("MaChiDoan");
		model.addColumn("ChucVu");
		model.addColumn("TonGiao");
		model.addColumn("DanToc");
		model.addColumn("NoiSinh");
		model.addColumn("DiaChiHienTai");
		model.addColumn("NangKhieu");
		model.addColumn("HoanCanhGiaDinh");
		model.addColumn("GhiChu");
		model.addColumn("DiemTichLuy");
	}

	public static void showStudent(List<Student> student) {
		// xuất thông tin từ list ra bảng đồng thời lưu thông tin đó và list
		studentList = student;
		model.setRowCount(0);
		for (Student st : studentList) {
			model.addRow(new Object[] { st.getMaSV(), st.getHo(), st.getTen(), st.getCMND(), st.getNgSinh(),
					st.getQueQuan(), st.getGioiTinh(), st.getNgVaoDoan(), st.getNgVaoDang(), st.getDienThoai(),
					st.getEmail(), st.getMaChiDoan(), st.getChucVu(), st.getTonGiao(), st.getDanToc(), st.getNoiSinh(),
					st.getDiaChiHT(), st.getNangKhieu(), st.getHoanCanhGD(), st.getGhiChu(), st.getDiemTL() });
		}
		tableDoanVien.setModel(model);
	}

	private void reset() {
		// đưa tất cả mọi ô thông tin về trạng thái rỗng
		GhiChu.setText("");
		Email.setText("");
		TenChiDoan.setSelectedIndex(0);
		Masv.setText("");
		CMND.setText("");
		GioiTinh.setSelectedIndex(0);
		DT.setText("");
		TonGiao.setText("");
		DCHienTai.setText("");
		Ho.setText("");
		Ten.setText("");
		Que.setText("");
		NgaySinh.setText("");
		ChucVu.setText("");
		DanToc.setText("");
		NoiSinh.setText("");
		HCGiaDinh.setText("");
		NangKhieu.setText("");
		DiemTLuy.setText("");
		NgayVaoDoan.setText("");
		NgayVaoDang.setText("");
		lblImage.setIcon(null);
	}

	private void setText(Student student) {
		// lấy thông tin từ đối tượng cho vào các ô tương ứng trên form
		GhiChu.setText(student.getGhiChu());
		Email.setText(student.getEmail());
		Masv.setText(student.getMaSV());
		CMND.setText(student.getCMND());
		GioiTinh.setSelectedItem(student.getGioiTinh());
		DT.setText(student.getDienThoai());
		TonGiao.setText(student.getTonGiao());
		DCHienTai.setText(student.getDiaChiHT());
		Ho.setText(student.getHo());
		Ten.setText(student.getTen());
		Que.setText(student.getQueQuan());
		NgaySinh.setText(student.getNgSinh());
		ChucVu.setText(student.getChucVu());
		DanToc.setText(student.getDanToc());
		NoiSinh.setText(student.getNoiSinh());
		HCGiaDinh.setText(student.getHoanCanhGD());
		NangKhieu.setText(student.getNangKhieu());
		DiemTLuy.setText(String.valueOf(student.getDiemTL()));
		NgayVaoDoan.setText(student.getNgVaoDoan());
		NgayVaoDang.setText(student.getNgVaoDang());

		// chuyển dữ liệu trong sql từ mã chi đoàn ra tên chi đoàn
		for (String key : Mchidoan.keySet()) {
			if (student.getMaChiDoan() == Mchidoan.get(key)) {
				TenChiDoan.setSelectedItem(key);
			}
		}

		sv_img = (student.getAvatar());
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(sv_img).getImage().getScaledInstance(lblImage.getWidth(),
				lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(imageIcon);
	}

	private Student checkData() {
		// lấy sữ liệu từ các ô thông tin đặt vào hàm tạo student
		String ghichu = GhiChu.getText();
		String email = Email.getText();
		String masv = Masv.getText();
		String cmnd = CMND.getText();
		String gioitinh = GioiTinh.getSelectedItem().toString();
		String dienthoai = DT.getText();
		String tongiao = TonGiao.getText();
		String DChientai = StandardOutput.formatString(DCHienTai.getText());
		byte[] Avatar = sv_img;
		String ho = StandardOutput.formatString(Ho.getText());
		String ten = StandardOutput.formatString(Ten.getText());
		String quequan = StandardOutput.formatString(Que.getText());
		String ngaysinh = NgaySinh.getText();
		String chucvu = ChucVu.getText();
		String dantoc = StandardOutput.formatString(DanToc.getText());
		String noisinh = StandardOutput.formatString(NoiSinh.getText());
		String hcgiadinh = HCGiaDinh.getText();
		String nangkhieu = NangKhieu.getText();
		float diemtichluy = Float.parseFloat(DiemTLuy.getText());
		String ngayvaodoan = NgayVaoDoan.getText();
		String ngayvaodang = NgayVaoDang.getText();

		// chuyển từ tên chi đoàn ra mã chi đoàn
		int machidoan = Mchidoan.get(TenChiDoan.getSelectedItem());

		Student student = new Student(masv, ho, ten, cmnd, ngaysinh, quequan, gioitinh, ngayvaodoan, ngayvaodang,
				dienthoai, email, machidoan, chucvu, tongiao, dantoc, noisinh, DChientai, nangkhieu, hcgiadinh, ghichu,
				Avatar, diemtichluy);
		return student;

	}

	private boolean standardInput() {
		// kiểm tra thông tin trong những ô bắt buộc phải có.nếu thỏa mãn trả về true
		// không thì trả về false

		if (!Masv.getText().equals("") && !Ho.getText().equals("") && !Ten.getText().equals("")
				&& !CMND.getText().equals("") && !NgaySinh.getText().equals("") && !Que.getText().equals("")
				&& !NgayVaoDoan.getText().equals("") && !DT.getText().equals("") && !TonGiao.getText().equals("")
				&& !DanToc.getText().equals("") && !NoiSinh.getText().equals("") && !DCHienTai.getText().equals("")
				&& !HCGiaDinh.getText().equals("") && !DiemTLuy.getText().equals("") && !ChucVu.getText().equals("")
				&& TenChiDoan.getSelectedIndex() != 0 && sv_img != null) {

			// kiem tra trong tin con lai khi cac o text bat buoc duoc thoa man

			// co ca ngay vao dang va email

			if (!NgayVaoDang.getText().equals("") && !Email.getText().equals("")) {
				if (StandardInput.checkDate(NgaySinh.getText()) == true && StandardInput.isName(Masv.getText()) == true
						&& StandardInput.checkCMND(CMND.getText()) == true
//						&& StandardInput.checkPhonenumber(DT.getText()) == true
						&& StandardInput.checkDate(NgayVaoDoan.getText()) == true
						&& StandardInput.checkDate(NgayVaoDang.getText()) == true
						&& StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == true
						&& StandardInput.checkEmail(Email.getText()) == true) {
					return true;
				} else {
					if (StandardInput.isName(Masv.getText()) == false) {
						blbMa.setVisible(true);
					}
					if (StandardInput.checkDate(NgayVaoDang.getText()) == false) {
						blbNgVaoDang.setVisible(true);
					}
					if (StandardInput.checkDate(NgayVaoDoan.getText()) == false) {
						blbNgVDoan.setVisible(true);
					}
					if (StandardInput.checkCMND(CMND.getText()) == false) {
						blbCMND.setVisible(true);
					}
					if (StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == false) {
						blbDiemTLuy.setVisible(true);
					}
					if (StandardInput.checkEmail(Email.getText()) == false) {
						blbEmail.setVisible(true);
					}
					if (StandardInput.checkDate(NgaySinh.getText()) == false) {
						blbNgSinh.setVisible(true);
					}

					JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
					return false;
				}
			}
			// co ngay vao dang nhung khong co email

			else if (!NgayVaoDang.getText().equals("") && Email.getText().equals("")) {
				if (StandardInput.checkDate(NgaySinh.getText()) == true && StandardInput.isName(Masv.getText()) == true
						&& StandardInput.checkCMND(CMND.getText()) == true
//						&& StandardInput.checkPhonenumber(DT.getText()) == true
						&& StandardInput.checkDate(NgayVaoDoan.getText()) == true
						&& StandardInput.checkDate(NgayVaoDang.getText()) == true
						&& StandardInput.isNumber(DiemTLuy.getText(), 0L, 10L) == true) {
					return true;
				} else {
					if (StandardInput.isName(Masv.getText()) == false) {
						blbMa.setVisible(true);
					}

					if (StandardInput.checkDate(NgayVaoDang.getText()) == false) {
						blbNgVaoDang.setVisible(true);
					}
					if (StandardInput.checkDate(NgayVaoDoan.getText()) == false) {
						blbNgVDoan.setVisible(true);
					}
					if (StandardInput.checkCMND(CMND.getText()) == false) {
						blbCMND.setVisible(true);
					}
					if (StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == false) {
						blbDiemTLuy.setVisible(true);
					}
					if (StandardInput.checkDate(NgaySinh.getText()) == false) {
						blbNgSinh.setVisible(true);
					}

					JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
					return false;
				}
			}
			// co email nhung khong co ngay vao dang

			else if (NgayVaoDang.getText().equals("") && !Email.getText().equals("")) {
				if (StandardInput.checkDate(NgaySinh.getText()) == true && StandardInput.isName(Masv.getText()) == true
						&& StandardInput.checkCMND(CMND.getText()) == true
//						&& StandardInput.checkPhonenumber(DT.getText()) == true
						&& StandardInput.checkDate(NgayVaoDoan.getText()) == true
						&& StandardInput.isNumber(DiemTLuy.getText(), 0L, 10L) == true
						&& StandardInput.checkEmail(Email.getText())) {
					return true;
				} else {
					if (StandardInput.isName(Masv.getText()) == false) {
						blbMa.setVisible(true);
					}

					if (StandardInput.checkDate(NgayVaoDoan.getText()) == false) {
						blbNgVDoan.setVisible(true);
					}
					if (StandardInput.checkCMND(CMND.getText()) == false) {
						blbCMND.setVisible(true);
					}
					if (StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == false) {
						blbDiemTLuy.setVisible(true);
					}
					if (StandardInput.checkEmail(Email.getText()) == false) {
						blbEmail.setVisible(true);
					}
					if (StandardInput.checkDate(NgaySinh.getText()) == false) {
						blbNgSinh.setVisible(true);
					}

					JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
					return false;
				}
			}
			// khong co ca 2

			else {
				if (StandardInput.checkDate(NgaySinh.getText()) == true && StandardInput.isName(Masv.getText()) == true
						&& StandardInput.checkCMND(CMND.getText()) == true
//						&& StandardInput.checkPhonenumber(DT.getText()) == true
						&& StandardInput.checkDate(NgayVaoDoan.getText()) == true
						&& StandardInput.isNumber(DiemTLuy.getText(), 0L, 10L) == true) {
					return true;
				} else {
					if (StandardInput.isName(Masv.getText()) == false) {
						blbMa.setVisible(true);
					}

					if (StandardInput.checkDate(NgayVaoDoan.getText()) == false) {
						blbNgVDoan.setVisible(true);
					}
					if (StandardInput.checkCMND(CMND.getText()) == false) {
						blbCMND.setVisible(true);
					}
					if (StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == false) {
						blbDiemTLuy.setVisible(true);
					}

					if (StandardInput.checkDate(NgaySinh.getText()) == false) {
						blbNgSinh.setVisible(true);
					}

					JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
					return false;
				}
			}
		} else {

			if (Masv.getText().equals("")) {
				blbMa.setVisible(true);
			} else {
				if (StandardInput.isName(Masv.getText()) == false) {
					blbMa.setVisible(true);
				}
			}
			if (StudentModify.exists.get(Masv.getText()) != null) {
				blbMa.setVisible(true);
				// JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Sinh Viên!");
			}

			if (Ho.getText().equals("")) {
				blbHo.setVisible(true);
			}

			if (Ten.getText().equals("")) {
				blbTen.setVisible(true);
			}

			if (CMND.getText().equals("")) {
				blbCMND.setVisible(true);
			} else {
				if (StandardInput.checkCMND(CMND.getText()) == false) {
					blbCMND.setVisible(true);
				}
			}

			if (NgaySinh.getText().equals("")) {
				blbNgSinh.setVisible(true);
			} else {
				if (StandardInput.checkDate(NgaySinh.getText()) == false) {
					blbCMND.setVisible(true);
				}
			}

			if (Que.getText().equals("")) {
				blbQueQuan.setVisible(true);
			}

			if (NgayVaoDoan.getText().equals("")) {
				blbNgVDoan.setVisible(true);
			} else {
				if (StandardInput.checkDate(NgayVaoDoan.getText()) == false) {
					blbNgVDoan.setVisible(true);
				}
			}

			if (DT.getText().equals("")) {
				blbDT.setVisible(true);
			} else {
				if (StandardInput.isNumber(DT.getText()) == false) {
					blbDT.setVisible(true);
				}
			}

			if (!Email.getText().equals("")) {
				if (StandardInput.checkEmail(Email.getText()) == false) {
					blbEmail.setVisible(true);
				}
			}

			if (!NgayVaoDang.getText().equals("")) {
				if (StandardInput.checkDate(NgayVaoDang.getText()) == false) {
					blbNgVaoDang.setVisible(true);
				}
			}

			if (TonGiao.getText().equals("")) {
				blbTonGiao.setVisible(true);
			}

			if (DanToc.getText().equals("")) {
				blbDanToc.setVisible(true);
			}

			if (NoiSinh.getText().equals("")) {
				blbNoiSinh.setVisible(true);
			}

			if (DCHienTai.getText().equals("")) {
				blbDCHienTai.setVisible(true);
			}

			if (HCGiaDinh.getText().equals("")) {
				blbHCGiaDinh.setVisible(true);
			}

			if (DiemTLuy.getText().equals("")) {
				blbDiemTLuy.setVisible(true);
			} else {
				if (StandardInput.isNumber(DiemTLuy.getText(), 0L, 4L) == false) {
					blbDiemTLuy.setVisible(true);
				}
			}

			if (TenChiDoan.getSelectedIndex() == 0) {
				blbTenChiDoan.setVisible(true);
			}

			if (ChucVu.getText().equals("")) {
				blbChucVu.setVisible(true);
			}

			if (TenChiDoan.getSelectedIndex() == 0) {
				TenChiDoan.setVisible(true);
			}

			JOptionPane.showMessageDialog(null, "Chưa Điền Đủ Thông Tin Cần Thiết !");
			return false;
		}
	}

	private void update() {
		setVisibleFalse();
		int index = tableDoanVien.getSelectedRow();
		if (studentList.size() == 0) {
			JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng");
		} else if (index == -1) {
			JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng !");
		} else {
			if (standardInput()) {
				setVisibleFalse();
				Student student = checkData();
				Student std = studentList.get(index);
				if (!student.getMaSV().equalsIgnoreCase(std.getMaSV())) {
					blbMa.setVisible(true);
					JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Đoàn Viên!");
				} else {
					update_edit_DoanVienChiDoan();
					StudentModify.update(student);
					showStudent(StudentModify.findAll());
					reset();
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
				}
			}

		}

	}

	private void insert() {
		setVisibleFalse();
		if (standardInput() == true) {
			setVisibleFalse();
			Student student = checkData();
			if (StudentModify.exists.get(student.getMaSV()) != null) {
				blbMa.setVisible(true);
				JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Sinh Viên!");
			} else {
				update_insert_DoanVienChiDoan();
				StudentModify.insert(student);
				showStudent(StudentModify.findAll());
				reset();
				JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
			}
		}
	}

	private void delete() {
		setVisibleFalse();
		int index = tableDoanVien.getSelectedRow();
		if (studentList.size() == 0) {
			JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng !");
		} else if (index == -1) {
			JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng !");
		} else {
			Student st = studentList.get(index);
			update_delete_DoanVienChiDoan();
			StudentModify.delete(st.getMaSV());
			showStudent(StudentModify.findAll());
			StudentModify.exists.remove(st.getMaSV());
			reset();
			JOptionPane.showMessageDialog(null, "Xóa Thành Công!");

		}
	}

	private void exportExcel() {
		// chọn vị trí xuất file excel và xuất thông tin trong bảng

		String linkfile = "";
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose a directory to save your file: ");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_sach_doan_vien.xlsx");

				try {
					writerExcel.ghifileexcel(linkfile, studentList);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			}
		}
	}

	private void chooseFileImage() {
		// hàm chọn file ảnh và đưa vào biến dưới dạng byte

		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		if(f != null) {
			filename = f.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(),
					lblImage.getHeight(), Image.SCALE_SMOOTH));
			lblImage.setIcon(imageIcon);
		}
		
		try {
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			sv_img = bos.toByteArray();
		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(null, e2);
		}
	}

	// SỐ LƯỢNG ĐOÀN VIÊN ĐƯỢC CẬP NHẬT SAU KHI NHẬP THÊM ĐOÀN VIÊN
	private void update_insert_DoanVienChiDoan() {
		Student std = checkData();
		for (ChiDoan cd : ChiDoan_modify.findAll()) {
			if (std.getMaChiDoan() == cd.getMaChiDoan()) {
				int soluong = cd.getSoLuongDoanVien() + 1;
				System.out.println(soluong);
				cd.setSoLuongDoanVien(soluong);
				ChiDoan_modify.update(cd);
			}
		}

	}

	// SỐ LƯỢNG ĐOÀN VIÊN ĐƯỢC CẬP NHẬT SAU KHI XÓA ĐOÀN VIÊN
	private void update_delete_DoanVienChiDoan() {
		int index = tableDoanVien.getSelectedRow();
		Student std = studentList.get(index);

		for (ChiDoan cd : ChiDoan_modify.findAll()) {
			if (std.getMaChiDoan() == cd.getMaChiDoan()) {
				int soluong = cd.getSoLuongDoanVien() - 1;
				cd.setSoLuongDoanVien(soluong);
				ChiDoan_modify.update(cd);
			}
		}

	}

	// SỐ LƯỢNG ĐOÀN VIÊN ĐƯỢC CẬP NHẬT SAU KHI SỬA THÔNG TIN ĐOÀN VIÊN
	private void update_edit_DoanVienChiDoan() {
		int index = tableDoanVien.getSelectedRow();

		// thông tin đoàn viên trước khi sửa
		Student student = studentList.get(index);

		// thông tin đoàn viên sau khi sửa
		Student std = checkData();

		/*
		 * nếu mã đoàn viên sau khi sửa khác mã đoàn viên ban đầu giảm số lượng đoàn
		 * viên của chi đoàn cũ đi 1 tăng số lượng đoàn viên của chi đoàn mới lên 1
		 */
		if (student.getMaChiDoan() != std.getMaChiDoan()) {
			for (ChiDoan cd : ChiDoan_modify.findAll()) {
				if (std.getMaChiDoan() == cd.getMaChiDoan()) {
					int soluong = cd.getSoLuongDoanVien() + 1;
					System.out.println(soluong);
					cd.setSoLuongDoanVien(soluong);
					ChiDoan_modify.update(cd);
				} else if (student.getMaChiDoan() == cd.getMaChiDoan()) {
					int soluong = cd.getSoLuongDoanVien() - 1;
					System.out.println(soluong);
					cd.setSoLuongDoanVien(soluong);
					ChiDoan_modify.update(cd);
				}
			}
		}
	}

	private void setVisibleFalse() {
		blbMa.setVisible(false);
		blbCMND.setVisible(false);
		blbNgVDoan.setVisible(false);
		blbDT.setVisible(false);
		blbDanToc.setVisible(false);
		blbDCHienTai.setVisible(false);
		blbHo.setVisible(false);
		blbQueQuan.setVisible(false);
		blbChucVu.setVisible(false);
		blbNoiSinh.setVisible(false);
		blbTen.setVisible(false);
		blbNgSinh.setVisible(false);
		blbNgVaoDang.setVisible(false);
		blbTonGiao.setVisible(false);
		blbNangKhieu.setVisible(false);
		blbHCGiaDinh.setVisible(false);
		blbDiemTLuy.setVisible(false);
		blbTenChiDoan.setVisible(false);
		blbEmail.setVisible(false);
	}

	public static void setChucVu(String chucvu) {
		ChucVu.setText(chucvu);
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnNhap.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);
			btnChon.setVisible(false);
		}
	}
}
