package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

import check_data.StandardOutput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.DanhGiaRLSVModify;
import modify_object.StudentModify;
import modify_object.XepLoaiDoanVienModify;
import object_frame.DanhGiaRLSV;
import object_frame.Student;
import object_frame.XepLoaiDV;
import javax.swing.ImageIcon;

public class QLXepLoaiDoanVien extends JInternalFrame {
	private static JTable tblXLDV;
	private JTextArea txtGhiChu;
	private JComboBox comboBox;
	/*
	 * 
	 */
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	public static List<XepLoaiDV> xldvList = new ArrayList<XepLoaiDV>();
	public static Map<Integer, HashSet<String>> M = new HashMap<Integer, HashSet<String>>();
	/*
	 * 
	 */
	private JTextField txtMDG;
	private JTextField txtMSV;
	private JLabel lblxMaDG;
	private JLabel lblxMSV;
	private JLabel lblxXepLoai;
	private JLabel lblxGhiChu;
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
					QLXepLoaiDoanVien frame = new QLXepLoaiDoanVien();
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
	public QLXepLoaiDoanVien() throws IOException, SQLException {
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
		setBounds(100, 100, 1174, 775);

		JPanel pnXepLoai = new JPanel();
		pnXepLoai.setBackground(new Color(255, 255, 255));
		getContentPane().add(pnXepLoai, BorderLayout.CENTER);
		pnXepLoai.setLayout(null);

		JPanel pnHD = new JPanel();
		pnHD.setBackground(new Color(255, 255, 255));
		pnHD.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch Ho\u1EA1t \u0110\u1ED9ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnHD.setBounds(10, 246, 1002, 496);
		pnXepLoai.add(pnHD);
		pnHD.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollHDDV = new JScrollPane();
		pnHD.add(scrollHDDV, BorderLayout.CENTER);

		tblXLDV = new JTable();
		tblXLDV.setBackground(new Color(255, 255, 255));
		tblXLDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblXLDV.getSelectedRow();
				XepLoaiDV hd = xldvList.get(index);
				setText(hd);
			}
		});

		scrollHDDV.setViewportView(tblXLDV);

		JButton btnT = new JButton("Tìm Kiếm");
		btnT.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/search.png")));
		btnT.setForeground(new Color(255, 255, 255));
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemXLDV hd = new TimKiemXLDV();
				hd.setVisible(true);
			}
		});
		btnT.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnT.setBackground(new Color(65,49,102));
		btnT.setBounds(1022, 15, 142, 43);
		pnXepLoai.add(btnT);

		JButton btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepXLDV xd = new SapXepXLDV();
				xd.setVisible(true);
			}
		});
		btnSapXep.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setBounds(1022, 68, 142, 43);
		pnXepLoai.add(btnSapXep);

		btnNhap = new JButton("Nhập");
		btnNhap.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/insert.png")));
		btnNhap.setForeground(new Color(255, 255, 255));
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					XepLoaiDV xl = checkData();
					if (xl != null) {
						XepLoaiDoanVienModify.insert(xl);
						showXLDV(XepLoaiDoanVienModify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}
				}
			}
		});
		btnNhap.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNhap.setBackground(new Color(65,49,102));
		btnNhap.setBounds(1022, 254, 142, 43);
		pnXepLoai.add(btnNhap);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/edit.png")));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblXLDV.getSelectedRow();
				if (xldvList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput()) {
						setVisibleFalse();
						XepLoaiDV xl = checkData();
						XepLoaiDoanVienModify.update(xl);
						showXLDV(XepLoaiDoanVienModify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Sửa Thành Công" + "!");
					}
				}
			}
		});
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSua.setBackground(new Color(65,49,102));
		btnSua.setBounds(1022, 307, 142, 43);
		pnXepLoai.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/delete.png")));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblXLDV.getSelectedRow();
				if (xldvList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng!");
				} else {
					XepLoaiDV st = xldvList.get(index);
					XepLoaiDoanVienModify.delete(st.getMaDG(), st.getMaSV());
					showXLDV(XepLoaiDoanVienModify.findAll());
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");

				}
			}
		});
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(65,49,102));
		btnXoa.setBounds(1022, 360, 142, 43);
		pnXepLoai.add(btnXoa);

		JButton btnXuatFileExcel = new JButton("File Excel");
		btnXuatFileExcel.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/export.png")));
		btnXuatFileExcel.setForeground(new Color(255, 255, 255));
		btnXuatFileExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXuatFileExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXuatFileExcel.setBackground(new Color(65,49,102));
		btnXuatFileExcel.setBounds(1022, 646, 142, 43);
		pnXepLoai.add(btnXuatFileExcel);

		JButton btnThoat = new JButton("Làm Mới");
		btnThoat.setIcon(new ImageIcon(QLXepLoaiDoanVien.class.getResource("/buttonImages/refresh.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLXepLoaiDoanVien.showXLDV(XepLoaiDoanVienModify.findAll());
				reset();
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(1022, 699, 142, 43);
		pnXepLoai.add(btnThoat);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADp S\u1EB5n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 1002, 226);
		pnXepLoai.add(panel);
		panel.setLayout(null);

		txtMDG = new JTextField();
		txtMDG.setBackground(new Color(245, 245, 245));
		txtMDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMDG.setColumns(10);
		txtMDG.setBounds(160, 27, 210, 31);
		panel.add(txtMDG);

		txtMSV = new JTextField();
		txtMSV.setBackground(new Color(245, 245, 245));
		txtMSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMSV.setColumns(10);
		txtMSV.setBounds(160, 84, 210, 31);
		panel.add(txtMSV);

		JLabel ID_1 = new JLabel("Mã Đánh Giá");
		ID_1.setHorizontalAlignment(SwingConstants.LEFT);
		ID_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ID_1.setBounds(42, 27, 121, 27);
		panel.add(ID_1);
		JLabel ID_2 = new JLabel("Mã Sinh Viên");
		ID_2.setHorizontalAlignment(SwingConstants.LEFT);
		ID_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ID_2.setBounds(42, 84, 121, 27);
		panel.add(ID_2);

		lblxMaDG = new JLabel("X");
		lblxMaDG.setHorizontalAlignment(SwingConstants.CENTER);
		lblxMaDG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxMaDG.setForeground(Color.RED);
		lblxMaDG.setBounds(369, 28, 29, 24);
		panel.add(lblxMaDG);

		lblxMSV = new JLabel("X");
		lblxMSV.setHorizontalAlignment(SwingConstants.CENTER);
		lblxMSV.setForeground(Color.RED);
		lblxMSV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxMSV.setBounds(369, 85, 29, 24);
		panel.add(lblxMSV);
		
				JLabel ID = new JLabel("Xếp Loại");
				ID.setBounds(533, 27, 65, 27);
				panel.add(ID);
				ID.setHorizontalAlignment(SwingConstants.CENTER);
				ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
						comboBox = new JComboBox();
						comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
						comboBox.setBounds(634, 27, 269, 31);
						panel.add(comboBox);
						comboBox.setBackground(new Color(245, 245, 245));
						comboBox.addItem("Chọn");
						comboBox.addItem("Xuất Sắc");
						comboBox.addItem("Giỏi");
						comboBox.addItem("Khá");
						comboBox.addItem("Trung Bình");
						comboBox.addItem("Yếu");
						comboBox.addItem("Kém");
						
								JLabel GhiChu = new JLabel("Ghi Chú");
								GhiChu.setBounds(533, 84, 88, 31);
								panel.add(GhiChu);
								GhiChu.setHorizontalAlignment(SwingConstants.LEFT);
								GhiChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
								
										JScrollPane sclGhiChu = new JScrollPane();
										sclGhiChu.setBounds(634, 84, 269, 89);
										panel.add(sclGhiChu);
										
												txtGhiChu = new JTextArea();
												txtGhiChu.setBackground(new Color(245, 245, 245));
												sclGhiChu.setViewportView(txtGhiChu);
												txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 13));
										
												lblxXepLoai = new JLabel("X");
												lblxXepLoai.setBounds(913, 28, 29, 24);
												panel.add(lblxXepLoai);
												lblxXepLoai.setHorizontalAlignment(SwingConstants.CENTER);
												lblxXepLoai.setForeground(Color.RED);
												lblxXepLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
												
														lblxGhiChu = new JLabel("X");
														lblxGhiChu.setBounds(913, 85, 29, 24);
														panel.add(lblxGhiChu);
														lblxGhiChu.setHorizontalAlignment(SwingConstants.CENTER);
														lblxGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
														lblxGhiChu.setForeground(Color.RED);
		if (ktCot == 0) {
			insertColumn();
		}
		showXLDV(XepLoaiDoanVienModify.findAll());
		setVisibleFalse();
		isPermission();
	}

	private void insertColumn() {
		ktCot = 1;
		model.addColumn("MaDG");
		model.addColumn("MaSV");
		model.addColumn("HoTen");
		model.addColumn("XepLoai");
		model.addColumn("GhiChu");
	}

	public static void showXLDV(List<XepLoaiDV> xl) {
		SapXepXLDV.getData();
		xldvList = xl;
		model.setRowCount(0);
		for (XepLoaiDV hd : xldvList) {
			model.addRow(new Object[] { hd.getMaDG(), hd.getMaSV(),
					StandardOutput.formatString(SapXepXLDV.M.get(hd.getMaSV())), hd.getXepLoai(), hd.getGhiChu() });
			tblXLDV.setModel(model);
		}
	}

	private void reset() {
		txtMSV.setText("");
		txtMDG.setText("");
		comboBox.setSelectedIndex(0);
		txtGhiChu.setText("");
	}

	private void setText(XepLoaiDV xlsv) {
		txtMSV.setText(xlsv.getMaSV());
		txtMDG.setText(String.valueOf(xlsv.getMaDG()));
		comboBox.setSelectedItem(xlsv.getXepLoai());
		txtGhiChu.setText(xlsv.getGhiChu());
	}

	private XepLoaiDV checkData() {
		Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();
		for (DanhGiaRLSV a : DanhGiaRLSVModify.findAll()) {
			exists.put(a.getMaDG(), true);
		}

		List<XepLoaiDV> l = XepLoaiDoanVienModify.findAll();
		for (XepLoaiDV a : l) {
			if (!M.containsKey(a.getMaDG())) {
				M.put(a.getMaDG(), new HashSet<String>());
			}
			M.get(a.getMaDG()).add(a.getMaSV());
			M.put(a.getMaDG(), M.get(a.getMaDG()));
		}

		Map<String, Boolean> existsStd = new HashMap<String, Boolean>();
		for (Student a : StudentModify.findAll()) {
			existsStd.put(a.getMaSV(), true);
		}

		int madg = Integer.parseInt(txtMDG.getText());
		String masv = txtMSV.getText();

		if (exists.containsKey(madg) != true) {
			JOptionPane.showMessageDialog(getComponent(0), "Mã đánh giá không tồn tại!");
			lblxMaDG.setVisible(true);
			return null;
		}

		if (M.containsKey(madg)) {
			if (M.get(madg).contains(masv)) {
				JOptionPane.showMessageDialog(getComponent(0), "Mã đoàn viên đã tồn tại!");
				lblxMSV.setVisible(true);
				return null;
			}
			if (existsStd.containsKey(masv) != true) {
				JOptionPane.showMessageDialog(getComponent(0), "Mã đoàn viên không tồn tại!");
				lblxMSV.setVisible(true);
				return null;
			}
		}
		String xeploai = comboBox.getSelectedItem().toString();
		String ghichu = txtGhiChu.getText();
		return new XepLoaiDV(madg, masv, xeploai, ghichu);
	}

	private boolean standardInput() {
		if (!txtMSV.getText().equals("") && 
				!txtMDG.getText().equals("") && 
				comboBox.getSelectedIndex() != 0 && 
				!txtGhiChu.getText().equals("")) 
		{

			if (txtGhiChu.getText().length() > 10)
				return true;
			else 
			{
				lblxGhiChu.setVisible(true);
				JOptionPane.showMessageDialog(null, "Chú thích nhập từ 10 kí tự trở lên!");
				return false;
			}
		} 
		else 
		{	if(txtMSV.getText().equals("")) {
				lblxMSV.setVisible(true);
			}
			if(txtMDG.getText().equals("")) {
				lblxMaDG.setVisible(true);
			}
			if(comboBox.getSelectedIndex() == 0) {
				lblxXepLoai.setVisible(true);
			}
			if (txtGhiChu.getText().equals("")) {
				lblxGhiChu.setVisible(true);
			} 
			else 
			{
				if (txtGhiChu.getText().length() < 10) 
				{
					JOptionPane.showMessageDialog(null, "Thông Tin Ghi Chú Nhiều Hơn 10 Kí Tự!");
					lblxGhiChu.setVisible(true);
				}
			}
			JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đủ");
			return false;
		}
	}//kthuc

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
					writerExcel.ghiFileExcelXLDV(linkfile, xldvList);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			}
		}
	}

	private void setVisibleFalse() {
		lblxGhiChu.setVisible(false);
		lblxMaDG.setVisible(false);
		lblxMSV.setVisible(false);
		lblxXepLoai.setVisible(false);
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnNhap.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);
		}
	}
}
