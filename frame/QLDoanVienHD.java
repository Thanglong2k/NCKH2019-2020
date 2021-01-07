package frame;

import java.awt.BorderLayout;
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
import modify_object.HoatDongDoanVienModify;
import modify_object.HoatDongModify;
import modify_object.StudentModify;
import object_frame.HoatDong;
import object_frame.HoatDongDoanVien;
import object_frame.Student;

public class QLDoanVienHD extends JInternalFrame {
	private JTextField txtID;
	private static JTable tblHDDV;
	private JTextArea txtThanhTich;
	private JComboBox TenHoatDong;
	private JLabel lblAnhMinhChung;
	/*
	 * 
	 */
	String filename = null;
	byte[] hddv_img = null;
	/*
	 * 
	 */
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	public static List<HoatDongDoanVien> HDDVList = new ArrayList<HoatDongDoanVien>();
	Map<String, Integer> Mhoatdong = new HashMap<String, Integer>();
	Map<String, Boolean> ex = new HashMap<String, Boolean>();
	private JTextField txtMSV;
	private JLabel lblxMSV;
	private JLabel lblxTenHD;
	private JLabel lblXID;
	private JLabel lblXThanhTich;
	private JLabel lblxAnh;
	private JButton btnNhap;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnChon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDoanVienHD frame = new QLDoanVienHD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public QLDoanVienHD() throws IOException, SQLException {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

		this.setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 1173, 775);

		JPanel pnHDDV = new JPanel();
		pnHDDV.setBackground(new Color(255, 255, 255));
		getContentPane().add(pnHDDV, BorderLayout.CENTER);
		pnHDDV.setLayout(null);

		JPanel pnHD = new JPanel();
		pnHD.setBackground(new Color(255, 255, 255));
		pnHD.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch Ho\u1EA1t \u0110\u1ED9ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnHD.setBounds(20, 381, 993, 361);
		pnHDDV.add(pnHD);
		pnHD.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollHDDV = new JScrollPane();
		pnHD.add(scrollHDDV, BorderLayout.CENTER);

		tblHDDV = new JTable();
		tblHDDV.setForeground(Color.BLACK);
		tblHDDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblHDDV.getSelectedRow();
				HoatDongDoanVien hd = HDDVList.get(index);
				setText(hd);
			}
		});

		scrollHDDV.setViewportView(tblHDDV);

		JButton btnT = new JButton("Tìm Kiếm");
		btnT.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/search.png")));
		btnT.setForeground(new Color(255, 255, 255));
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemHDDV hd = new TimKiemHDDV();
				hd.setVisible(true);
			}
		});
		btnT.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnT.setBackground(new Color(65, 49, 102));
		btnT.setBounds(1023, 16, 140, 43);
		pnHDDV.add(btnT);

		JButton btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepHDDV sv = new SapXepHDDV();
				sv.setVisible(true);
			}
		});
		btnSapXep.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSapXep.setBackground(new Color(65, 49, 102));
		btnSapXep.setBounds(1023, 69, 140, 43);
		pnHDDV.add(btnSapXep);

		btnNhap = new JButton("Nhập");
		btnNhap.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/insert.png")));
		btnNhap.setForeground(new Color(255, 255, 255));
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					HoatDongDoanVien hdd = checkData();
					if (HoatDongDoanVienModify.exists.get(hdd.getID()) != null) {
						lblXID.setVisible(true);
						JOptionPane.showMessageDialog(null, "Đã Tồn Tại ID!");
					} else {
						try {
							HoatDongDoanVienModify.insert(hdd);
						} catch (IOException | SQLException e1) {
							e1.printStackTrace();
						}
						showHDDV(HoatDongDoanVienModify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}
				}
			}
		});
		btnNhap.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNhap.setBackground(new Color(65, 49, 102));
		btnNhap.setBounds(1023, 394, 140, 43);
		pnHDDV.add(btnNhap);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/edit.png")));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblHDDV.getSelectedRow();
				if (HDDVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput()) {
						setVisibleFalse();
						HoatDongDoanVien hdd = checkData();
						HoatDongDoanVien std = HDDVList.get(index);
						if (Integer.parseInt(txtID.getText()) != std.getID()) {
							JOptionPane.showMessageDialog(null, "Không Thể Sửa ID");
						} else {
							HoatDongDoanVienModify.update(hdd);
							showHDDV(HoatDongDoanVienModify.findAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công" + "!");
						}
					}
				}
			}
		});
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSua.setBackground(new Color(65, 49, 102));
		btnSua.setBounds(1023, 447, 140, 43);
		pnHDDV.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/delete.png")));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblHDDV.getSelectedRow();
				if (HDDVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng!");
				} else {
					HoatDongDoanVien st = HDDVList.get(index);
					HoatDongDoanVienModify.delete(st.getID());
					showHDDV(HoatDongDoanVienModify.findAll());
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
				}
			}
		});
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(65, 49, 102));
		btnXoa.setBounds(1023, 500, 140, 43);
		pnHDDV.add(btnXoa);

		JButton btnXuatFileExcel = new JButton("File Excel");
		btnXuatFileExcel.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/export.png")));
		btnXuatFileExcel.setForeground(new Color(255, 255, 255));
		btnXuatFileExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXuatFileExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXuatFileExcel.setBackground(new Color(65, 49, 102));
		btnXuatFileExcel.setBounds(1023, 646, 140, 43);
		pnHDDV.add(btnXuatFileExcel);

		JButton btnThoat = new JButton("Làm Mới");
		btnThoat.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/refresh.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDoanVienHD.showHDDV(HoatDongDoanVienModify.findAll());
				reset();
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnThoat.setBackground(new Color(65, 49, 102));
		btnThoat.setBounds(1023, 699, 140, 43);
		pnHDDV.add(btnThoat);

		JPanel panel_anhMinhChung = new JPanel();
		panel_anhMinhChung.setBackground(new Color(255, 255, 255));
		panel_anhMinhChung.setBorder(
				new TitledBorder(null, "\u1EA2nh Minh Ch\u1EE9ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_anhMinhChung.setBounds(325, 10, 688, 361);
		pnHDDV.add(panel_anhMinhChung);
		panel_anhMinhChung.setLayout(null);

		lblAnhMinhChung = new JLabel("");
		lblAnhMinhChung.setBackground(new Color(255, 255, 255));
		lblAnhMinhChung.setBounds(10, 22, 668, 329);
		panel_anhMinhChung.add(lblAnhMinhChung);

		JPanel luaChon = new JPanel();
		luaChon.setBackground(new Color(255, 255, 255));
		luaChon.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADp Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		luaChon.setBounds(20, 10, 295, 361);
		pnHDDV.add(luaChon);
		luaChon.setLayout(null);

		JLabel lblTenSV = new JLabel("Mã Sinh Viên");
		lblTenSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenSV.setBounds(10, 22, 167, 32);
		luaChon.add(lblTenSV);

		JLabel lblTenHD = new JLabel("Tên Hoạt Động");
		lblTenHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenHD.setBounds(10, 94, 167, 32);
		luaChon.add(lblTenHD);

		TenHoatDong = new JComboBox();
		TenHoatDong.setBackground(new Color(245, 245, 245));
		TenHoatDong.setForeground(Color.BLACK);
		TenHoatDong.addItem("(Chọn Tên Hoạt Động)");
		TenHoatDong.setBounds(10, 131, 239, 32);
		luaChon.add(TenHoatDong);

		txtMSV = new JTextField();
		txtMSV.setBackground(new Color(245, 245, 245));
		txtMSV.setBounds(10, 54, 239, 31);
		luaChon.add(txtMSV);
		txtMSV.setColumns(10);

		lblxMSV = new JLabel("X");
		lblxMSV.setHorizontalAlignment(SwingConstants.CENTER);
		lblxMSV.setForeground(Color.RED);
		lblxMSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxMSV.setBounds(259, 56, 26, 23);
		luaChon.add(lblxMSV);

		lblxTenHD = new JLabel("X");
		lblxTenHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblxTenHD.setForeground(Color.RED);
		lblxTenHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxTenHD.setBounds(259, 127, 26, 32);
		luaChon.add(lblxTenHD);

		txtID = new JTextField();
		txtID.setBackground(new Color(245, 245, 245));
		txtID.setBounds(10, 195, 239, 31);
		luaChon.add(txtID);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setColumns(10);

		lblXID = new JLabel("X");
		lblXID.setHorizontalAlignment(SwingConstants.CENTER);
		lblXID.setBounds(259, 193, 26, 31);
		luaChon.add(lblXID);
		lblXID.setForeground(Color.RED);
		lblXID.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel ID = new JLabel("ID");
		ID.setBounds(10, 168, 65, 27);
		luaChon.add(ID);
		ID.setHorizontalAlignment(SwingConstants.LEFT);
		ID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel ThanhTich = new JLabel("Thành Tích");
		ThanhTich.setBounds(10, 236, 153, 31);
		luaChon.add(ThanhTich);
		ThanhTich.setHorizontalAlignment(SwingConstants.LEFT);
		ThanhTich.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane scrlThanhTich = new JScrollPane();
		scrlThanhTich.setBounds(10, 264, 239, 85);
		luaChon.add(scrlThanhTich);

		txtThanhTich = new JTextArea();
		txtThanhTich.setBackground(new Color(245, 245, 245));
		scrlThanhTich.setViewportView(txtThanhTich);
		txtThanhTich.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblXThanhTich = new JLabel("X");
		lblXThanhTich.setHorizontalAlignment(SwingConstants.CENTER);
		lblXThanhTich.setBounds(259, 263, 26, 29);
		luaChon.add(lblXThanhTich);
		lblXThanhTich.setForeground(Color.RED);
		lblXThanhTich.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnChon = new JButton("Chọn Ảnh");
		btnChon.setIcon(new ImageIcon(QLDoanVienHD.class.getResource("/buttonImages/searchimg.png")));
		btnChon.setForeground(new Color(255, 255, 255));
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFileImage();
			}
		});
		btnChon.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnChon.setBackground(new Color(65, 49, 102));
		btnChon.setBounds(1023, 241, 140, 43);
		pnHDDV.add(btnChon);

		lblxAnh = new JLabel("X");
		lblxAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblxAnh.setForeground(Color.RED);
		lblxAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxAnh.setBounds(1026, 199, 27, 32);
		pnHDDV.add(lblxAnh);
		if (ktCot == 0) {
			insertColumn();
		}
		
		setcomboBoxHoatDong();
		showHDDV(HoatDongDoanVienModify.findAll());
		setVisibleFalse();
		isPermission();
	}

	private void setcomboBoxHoatDong() {
		for (HoatDong x : HoatDongModify.findAll()) {
			Mhoatdong.put(x.getTenHoatDong(), x.getMaHoatDong());
		}
		for (String key : Mhoatdong.keySet()) {
			TenHoatDong.addItem(key);
		}
	}

	private void insertColumn() {
		ktCot = 1;
		model.addColumn("ID");
		model.addColumn("MSV");
		model.addColumn("MaHoatDong");
		model.addColumn("ThanhTich");
	}

	public static void showHDDV(List<HoatDongDoanVien> hddv) {
		HDDVList = hddv;
		model.setRowCount(0);
		for (HoatDongDoanVien hd : HDDVList) {
			model.addRow(new Object[] { hd.getID(), hd.getMaSV(), hd.getMaHoatDong(), hd.getThanhTich() });
			tblHDDV.setModel(model);
		}
	}

	private void reset() {
		txtID.setText("");
		txtThanhTich.setText("");
		TenHoatDong.setSelectedIndex(0);
		lblAnhMinhChung.setIcon(null);
	}

	private void setText(HoatDongDoanVien hddv) {
		txtID.setText(String.valueOf(hddv.getID()));
		txtThanhTich.setText(hddv.getThanhTich());
		txtMSV.setText(hddv.getMaSV());
		for (String keys : Mhoatdong.keySet()) {
			if (hddv.getMaHoatDong() == Mhoatdong.get(keys)) {
				TenHoatDong.setSelectedItem(keys);
			}
		}

		hddv_img = hddv.getAnhMinhChung();
		ImageIcon img = new ImageIcon(new ImageIcon(hddv_img).getImage().getScaledInstance(lblAnhMinhChung.getWidth(),
				lblAnhMinhChung.getHeight(), Image.SCALE_SMOOTH));
		lblAnhMinhChung.setIcon(img);
	}

	private HoatDongDoanVien checkData() {

		int id = Integer.parseInt(txtID.getText());
		String masv = txtMSV.getText();
		byte[] Avatar = hddv_img;
		String thanhtich = txtThanhTich.getText();
		int mahoatdong = Mhoatdong.get(TenHoatDong.getSelectedItem());

		HoatDongDoanVien hddv = new HoatDongDoanVien(id, masv, mahoatdong, Avatar,
				StandardOutput.formatString(thanhtich));
		return hddv;
	}

	private boolean standardInput() {
		List<Student> dv = StudentModify.findAll();
		for (Student a : dv) {
			ex.put(a.getMaSV(), true);
		}

		if (!txtID.getText().equals("") && !txtThanhTich.getText().equals("") && TenHoatDong.getSelectedIndex() != 0
				&& hddv_img != null && !txtMSV.getText().equals("")) {
			if (StandardInput.isNumber(txtID.getText(), 0, 10000) == true && txtThanhTich.getText().length() > 10
					&& ex.containsKey(txtMSV.getText()) == true && StandardInput.isName(txtMSV.getText()) == true) {
				return true;
			} else {
				if (StandardInput.isNumber(txtID.getText(), 0, 10000) == false) {
					JOptionPane.showMessageDialog(null, "Nhập ID Trong Khoảng (0,10000)!");
					lblXID.setVisible(true);
				}
				if (txtThanhTich.getText().length() < 10) {
					JOptionPane.showMessageDialog(null, "Thông Tin Thành Tích Nhập Nhiều Hơn 10 Kí Tự!");
					lblXThanhTich.setVisible(true);
				}
				if (ex.containsKey(txtMSV.getText()) != true) {
					JOptionPane.showMessageDialog(null, "Mã Sinh Viên Không Tồn Tại!");
					lblxMSV.setVisible(true);
				}

//				if(StandardInput.isName(txtMSV.getText()) == false) {
//					lblxMSV.setVisible(true);
//				}
				// JOptionPane.showMessageDialog(null, "Thông tin chưa đúng!");
				return false;
			}
		} else {
			if (txtID.getText().equals("")) {
				lblXID.setVisible(true);
			} else if (!txtID.getText().equals("") && StandardInput.isNumber(txtID.getText(), 0, 10000) == false) {
				JOptionPane.showMessageDialog(null, "Nhập ID Trong Khoảng (0,10000)!");
				lblXID.setVisible(true);
			} else if (!txtID.getText().equals("")
					&& HoatDongDoanVienModify.exists.get(Integer.parseInt(txtID.getText())) != null) {
				JOptionPane.showMessageDialog(null, "Đã Tồn Tại ID!");
				lblXID.setVisible(true);
			}

			if (hddv_img == null) {
				lblxAnh.setVisible(true);
			}

			if (txtMSV.getText().equals("")) {
				lblxMSV.setVisible(true);
			} else {
				if (ex.containsKey(txtMSV.getText()) != true) {
					JOptionPane.showMessageDialog(null, "Mã Sinh Viên Không Tồn Tại!");
					lblxMSV.setVisible(true);
				}
			}

			if (TenHoatDong.getSelectedIndex() == 0) {
				lblxTenHD.setVisible(true);
			}

			if (txtThanhTich.getText().equals("")) {
				lblXThanhTich.setVisible(true);
			} else {
				if (txtThanhTich.getText().length() < 10) {
					JOptionPane.showMessageDialog(null, "Thông Tin Thành Tích Nhập Nhiều Hơn 10 Kí Tự!");
					lblXThanhTich.setVisible(true);
				}
			}

			JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin");
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
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_sach_hoat_dong_doan_vien.xlsx");

				try {
					writerExcel.ghiFileExcelHDDV(linkfile, HDDVList);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			}
		}
	}

	private void chooseFileImage() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		if (f != null) {
			filename = f.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage()
					.getScaledInstance(lblAnhMinhChung.getWidth(), lblAnhMinhChung.getHeight(), Image.SCALE_SMOOTH));
			lblAnhMinhChung.setIcon(imageIcon);
		}

		try {
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			hddv_img = bos.toByteArray();
		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(null, e2);
		}
	}

	private void setVisibleFalse() {
		lblxAnh.setVisible(false);
		lblXID.setVisible(false);
		lblxMSV.setVisible(false);
		lblxTenHD.setVisible(false);
		lblXThanhTich.setVisible(false);
	}

	private void isPermission() throws IOException, SQLException {
		if (AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnNhap.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);
			btnChon.setVisible(false);
		}
	}
}
