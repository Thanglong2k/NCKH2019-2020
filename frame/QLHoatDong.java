package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import check_data.StandardOutput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.HoatDongModify;
import object_frame.HoatDong;

public class QLHoatDong extends JInternalFrame {
	private JTextField txtMaHD;
	private JTextField txtThoiGian;
	private static JTable tblHD;
	private JTextField txtLoaiHD;
	private JTextField txtDonViToChuc;
	private JTextArea txtTenHD;
	private JTextArea txtThongTinChiTiet;
	/*
	 * 
	 */
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	public static List<HoatDong> hoatdongList = new ArrayList<HoatDong>();
	private JLabel lblxMHD;
	private JLabel lblxTenHD;
	private JLabel lblxLoaiHD;
	private JLabel lblxThoiGian;
	private JLabel lblxDonVi;
	private JLabel lblxThongTin;
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
					QLHoatDong frame = new QLHoatDong();
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
	public QLHoatDong() throws IOException, SQLException {
		setClosable(true);
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/*
		 * 
		 */
		this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
		/*
		 * 
		 */
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setForeground(Color.WHITE);
		setResizable(true);
		setBounds(100, 100, 1190, 775);

		JPanel pnHDong = new JPanel();
		pnHDong.setBackground(Color.WHITE);
		getContentPane().add(pnHDong, BorderLayout.CENTER);
		pnHDong.setLayout(null);

		JPanel pnNhap = new JPanel();
		pnNhap.setBackground(Color.WHITE);
		pnNhap.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADp Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnNhap.setBounds(11, 16, 1003, 179);
		pnHDong.add(pnNhap);
		pnNhap.setLayout(null);

		JLabel maHD = new JLabel("Mã Hoạt Động");
		maHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maHD.setBounds(10, 27, 101, 27);
		pnNhap.add(maHD);

		JLabel thongTinChiTiet = new JLabel("Thông Tin Chi Tiết");
		thongTinChiTiet.setHorizontalAlignment(SwingConstants.LEFT);
		thongTinChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		thongTinChiTiet.setBounds(657, 83, 128, 31);
		pnNhap.add(thongTinChiTiet);

		JLabel tenHD = new JLabel("Tên Hoạt Động");
		tenHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tenHD.setBounds(10, 85, 101, 27);
		pnNhap.add(tenHD);

		JLabel thoiGian = new JLabel("Thời Gian");
		thoiGian.setHorizontalAlignment(SwingConstants.LEFT);
		thoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		thoiGian.setBounds(328, 85, 76, 27);
		pnNhap.add(thoiGian);

		txtMaHD = new JTextField();
		txtMaHD.setBackground(new Color(245, 245, 245));
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaHD.setBounds(121, 25, 171, 31);
		pnNhap.add(txtMaHD);
		txtMaHD.setColumns(10);

		txtThoiGian = new JTextField();
		txtThoiGian.setText("yyyy-dd-mm");
		txtThoiGian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtThoiGian.setText("");
			}
		});
		txtThoiGian.setBackground(new Color(245, 245, 245));
		txtThoiGian.setBounds(439, 85, 171, 27);
		pnNhap.add(txtThoiGian);
		txtThoiGian.setColumns(10);

		JScrollPane scrlTenHD = new JScrollPane();
		scrlTenHD.setBounds(121, 83, 171, 53);
		pnNhap.add(scrlTenHD);
		
				txtTenHD = new JTextArea();
				scrlTenHD.setViewportView(txtTenHD);
				txtTenHD.setBackground(new Color(245, 245, 245));
				txtTenHD.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel loaiHD = new JLabel("Loại Hoạt Động");
		loaiHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loaiHD.setBounds(328, 27, 101, 27);
		pnNhap.add(loaiHD);

		txtLoaiHD = new JTextField();
		txtLoaiHD.setBackground(new Color(245, 245, 245));
		txtLoaiHD.setColumns(10);
		txtLoaiHD.setBounds(439, 27, 171, 31);
		pnNhap.add(txtLoaiHD);

		JLabel donViToChuc = new JLabel("Đơn Vị Tổ Chức");
		donViToChuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		donViToChuc.setBounds(657, 25, 110, 31);
		pnNhap.add(donViToChuc);

		txtDonViToChuc = new JTextField();
		txtDonViToChuc.setBackground(new Color(245, 245, 245));
		txtDonViToChuc.setColumns(10);
		txtDonViToChuc.setBounds(793, 27, 171, 31);
		pnNhap.add(txtDonViToChuc);

		JScrollPane scrlThongTinChiTiet = new JScrollPane();
		scrlThongTinChiTiet.setBounds(795, 83, 171, 66);
		pnNhap.add(scrlThongTinChiTiet);
		
				txtThongTinChiTiet = new JTextArea();
				scrlThongTinChiTiet.setViewportView(txtThongTinChiTiet);
				txtThongTinChiTiet.setBackground(new Color(245, 245, 245));
				txtThongTinChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblxMHD = new JLabel("X");
		lblxMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxMHD.setForeground(Color.RED);
		lblxMHD.setBounds(302, 25, 29, 27);
		pnNhap.add(lblxMHD);

		lblxTenHD = new JLabel("X");
		lblxTenHD.setForeground(Color.RED);
		lblxTenHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxTenHD.setBounds(302, 83, 29, 27);
		pnNhap.add(lblxTenHD);

		lblxLoaiHD = new JLabel("X");
		lblxLoaiHD.setForeground(Color.RED);
		lblxLoaiHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxLoaiHD.setBounds(618, 25, 29, 27);
		pnNhap.add(lblxLoaiHD);

		lblxThoiGian = new JLabel("X");
		lblxThoiGian.setForeground(Color.RED);
		lblxThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxThoiGian.setBounds(620, 83, 29, 27);
		pnNhap.add(lblxThoiGian);

		lblxDonVi = new JLabel("X");
		lblxDonVi.setForeground(Color.RED);
		lblxDonVi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxDonVi.setBounds(974, 27, 29, 27);
		pnNhap.add(lblxDonVi);

		lblxThongTin = new JLabel("X");
		lblxThongTin.setForeground(Color.RED);
		lblxThongTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxThongTin.setBounds(974, 85, 29, 27);
		pnNhap.add(lblxThongTin);

		JPanel pnHD = new JPanel();
		pnHD.setBackground(Color.WHITE);
		pnHD.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch Ho\u1EA1t \u0110\u1ED9ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnHD.setBounds(10, 199, 1003, 541);
		pnHDong.add(pnHD);
		pnHD.setLayout(new BorderLayout(0, 0));
		
				JScrollPane scrollPane_2 = new JScrollPane();
				pnHD.add(scrollPane_2, BorderLayout.CENTER);
				scrollPane_2.setBackground(Color.WHITE);
				
						tblHD = new JTable();
						tblHD.setRowHeight(30);
						tblHD.setBackground(Color.WHITE);
						tblHD.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int index = tblHD.getSelectedRow();
								HoatDong hoatDong = hoatdongList.get(index);
								setText(hoatDong);
							}
						});
						scrollPane_2.setViewportView(tblHD);
						//tblHD.getColumnModel().getColumn(3).setPreferredWidth(0);

		JButton btnT = new JButton("Tìm Kiếm");
		btnT.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/search.png")));
		btnT.setForeground(Color.WHITE);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemHoatDong tk = new TimKiemHoatDong();
				tk.setVisible(true);
			}
		});
		btnT.setFont(new Font("Calibri", Font.PLAIN, 19));
		btnT.setBackground(new Color(65, 49, 102));
		btnT.setBounds(1024, 26, 137, 43);
		pnHDong.add(btnT);

		JButton btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(Color.WHITE);
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepHoatDong sx = new SapXepHoatDong();
				sx.setVisible(true);
			}
		});
		btnSapXep.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSapXep.setBackground(new Color(65, 49, 102));
		btnSapXep.setBounds(1024, 80, 137, 43);
		pnHDong.add(btnSapXep);

		btnNhap = new JButton("Nhập");
		btnNhap.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/insert.png")));
		btnNhap.setForeground(Color.WHITE);
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					setVisibleFalse();
					HoatDong hoatdong = checkData();
					if (HoatDongModify.exists.get(hoatdong.getMaHoatDong()) != null) {
						lblxMHD.setVisible(true);
						JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Hoạt Động!");
					} else {
						HoatDongModify.insert(hoatdong);
						showHoatDong(HoatDongModify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}
				}
			}
		});
		btnNhap.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNhap.setBackground(new Color(65, 49, 102));
		btnNhap.setBounds(1023, 205, 138, 43);
		pnHDong.add(btnNhap);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/edit.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblHD.getSelectedRow();
				if (hoatdongList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput() == true) {
						setVisibleFalse();
						HoatDong hoatDong = checkData();
						HoatDong hd = hoatdongList.get(index);
						if (!String.valueOf(hoatDong.getMaHoatDong())
								.equalsIgnoreCase(String.valueOf(hd.getMaHoatDong()))) {
							JOptionPane.showMessageDialog(null, "Không thể sửa mã hoạt động");
						} else {
							HoatDongModify.update(hoatDong);
							showHoatDong(HoatDongModify.findAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}
					}
				}
			}
		});
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSua.setBackground(new Color(65, 49, 102));
		btnSua.setBounds(1023, 258, 138, 43);
		pnHDong.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/delete.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblHD.getSelectedRow();
				if (hoatdongList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng!");
				} else {
					HoatDong hoatDong = hoatdongList.get(index);
					HoatDongModify.delete(hoatDong.getMaHoatDong());
					showHoatDong(HoatDongModify.findAll());
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
				}
			}
		});
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(65, 49, 102));
		btnXoa.setBounds(1023, 311, 138, 43);
		pnHDong.add(btnXoa);

		JButton btnXuatFileExcel = new JButton("File Excel");
		btnXuatFileExcel.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/export.png")));
		btnXuatFileExcel.setForeground(Color.WHITE);
		btnXuatFileExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXuatFileExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXuatFileExcel.setBackground(new Color(65, 49, 102));
		btnXuatFileExcel.setBounds(1023, 632, 138, 43);
		pnHDong.add(btnXuatFileExcel);

		JButton btnThoat = new JButton("Làm Mới");
		btnThoat.setIcon(new ImageIcon(QLHoatDong.class.getResource("/buttonImages/refresh.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLHoatDong.showHoatDong(HoatDongModify.findAll());
				reset();
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnThoat.setBackground(new Color(65, 49, 102));
		btnThoat.setBounds(1023, 685, 138, 43);
		pnHDong.add(btnThoat);
		if (ktCot == 0) {
			insertColumn();
		}
		showHoatDong(HoatDongModify.findAll());
		setVisibleFalse();
		isPermission();
	}

	private void insertColumn() {
		ktCot = 1;
		model.addColumn("MaHoatDong");
		model.addColumn("TenHoatDong");
		model.addColumn("LoaiHoatDong");
		model.addColumn("ThoiGian");
		model.addColumn("ThongTinChiTiet");
		model.addColumn("DonViToChuc");
	}

	public static void showHoatDong(List<HoatDong> hoatdong) {
		hoatdongList = hoatdong;
		model.setRowCount(0);
		for (HoatDong hd : hoatdongList) {
			model.addRow(new Object[] { hd.getMaHoatDong(), hd.getTenHoatDong(), hd.getLoaiHoatDong(), hd.getThoiGian(),
					hd.getThongTinChiTiet(), hd.getDonViToChuc() });
		}
		tblHD.setModel(model);
	}

	private void reset() {
		txtMaHD.setText("");
		txtTenHD.setText("");
		txtLoaiHD.setText("");
		txtThoiGian.setText("");
		txtThongTinChiTiet.setText("");
		txtDonViToChuc.setText("");
	}

	private void setText(HoatDong hoatDong) {
		txtMaHD.setText(String.valueOf(hoatDong.getMaHoatDong()));
		txtTenHD.setText(hoatDong.getTenHoatDong());
		txtLoaiHD.setText(hoatDong.getLoaiHoatDong());
		txtThoiGian.setText(hoatDong.getThoiGian());
		txtThongTinChiTiet.setText(hoatDong.getThongTinChiTiet());
		txtDonViToChuc.setText(hoatDong.getDonViToChuc());
	}

	private HoatDong checkData() {
		int maHD = Integer.parseInt(txtMaHD.getText());
		String tenHD = txtTenHD.getText();
		String loaiHD = txtLoaiHD.getText();
		String tgianHD = txtThoiGian.getText();
		String thongtinchitiet = txtThongTinChiTiet.getText();
		String donvitochuc = txtDonViToChuc.getText();

		HoatDong hoatDong = new HoatDong(maHD, StandardOutput.formatString(tenHD), StandardOutput.formatString(loaiHD),
				tgianHD, thongtinchitiet, donvitochuc);
		return hoatDong;
	}

	private boolean standardInput() {
		// Những thông tin bắt buộc
		if (!txtMaHD.getText().equals("") && !txtTenHD.getText().equals("") && !txtLoaiHD.getText().equals("")
				&& !txtThoiGian.getText().equals("") && !txtDonViToChuc.getText().equals("")
				&& !txtThongTinChiTiet.getText().equals("")) {
			if (StandardInput.checkDate(txtThoiGian.getText()) == true
					&& StandardInput.isNumber(txtMaHD.getText(), 0, 10000) == true
					&& txtThongTinChiTiet.getText().length() > 10) {
				return true;
			} else {
				if (StandardInput.checkDate(txtThoiGian.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Thời Gian Chưa Đúng Định Dạng yyyy/mm/dd!");
					lblxThoiGian.setVisible(true);
				}
				if (StandardInput.isNumber(txtMaHD.getText(), 0, 10000) == false) {
					JOptionPane.showMessageDialog(null, "Mã Hoạt Động Trong Khoảng (0,10000)!");
					lblxMHD.setVisible(true);

				}
				if (txtThongTinChiTiet.getText().length() < 10) {
					JOptionPane.showMessageDialog(null, "Thông Tin Chi Tiết Nhập Nhiều Hơn 10 Kí Tự!");
					lblxThongTin.setVisible(true);

				}
				return false;
			}
		} else {
			if (txtMaHD.getText().equals("")) {
				lblxMHD.setVisible(true);
			} else {
				if (StandardInput.isNumber(txtMaHD.getText(), 0, 10000) == false) {
					JOptionPane.showMessageDialog(null, "Mã Hoạt Động Trong Khoảng (0,10000)!");
					lblxMHD.setVisible(true);
				}
			}

			if (txtTenHD.getText().equals("")) {
				lblxTenHD.setVisible(true);
			}

			if (txtLoaiHD.getText().equals("")) {
				lblxLoaiHD.setVisible(true);
			}

			if (txtThoiGian.getText().equals("")) {
				lblxThoiGian.setVisible(true);
			} else {
				if (StandardInput.checkDate(txtThoiGian.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Thời Gian Chưa Đúng!");
					lblxThoiGian.setVisible(true);
				}
			}

			if (txtDonViToChuc.getText().equals("")) {
				lblxDonVi.setVisible(true);
			}

			if (txtThongTinChiTiet.getText().equals("")) {
				lblxThongTin.setVisible(true);
			} else {
				if (txtThongTinChiTiet.getText().length() < 10) {
					JOptionPane.showMessageDialog(null, "Thông Tin Chi Tiết Nhập Nhiều Hơn 10 Kí Tự!");
					lblxThongTin.setVisible(true);
				}
			}

			JOptionPane.showMessageDialog(null, "Chưa Điền Đủ Thông Tin Cần Thiết");
			return false;
		}
	}

	private void exportExcel() {
		String linkfile = "";
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose a directory to save your file: ");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_sach_hoat_dong.xlsx");

				try {
					writerExcel.ghiFileExcelHoatDong(linkfile, hoatdongList);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			}
		}
	}

	private void setVisibleFalse() {
		lblxDonVi.setVisible(false);
		lblxLoaiHD.setVisible(false);
		lblxMHD.setVisible(false);
		lblxTenHD.setVisible(false);
		lblxThoiGian.setVisible(false);
		lblxThongTin.setVisible(false);
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnNhap.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);
		}
	}
}
