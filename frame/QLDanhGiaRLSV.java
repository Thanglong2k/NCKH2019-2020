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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.DanhGiaRLSVModify;
import modify_object.XepLoaiDoanVienModify;
import object_frame.DanhGiaRLSV;
import object_frame.XepLoaiDV;
import javax.swing.ImageIcon;

public class QLDanhGiaRLSV extends JInternalFrame {
	private JTextField txtMaDG;
	private static JTable tblRLSV;
	private JTextField txtNamHoc;
	private JTextField txtHocKy;
	/*
	 * 
	 */
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	public static List<DanhGiaRLSV> RLSVList = new ArrayList<DanhGiaRLSV>();
	private JLabel lblxMaDG;
	private JLabel lblXNamHoc;
	private JLabel lblxHocKy;
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
					QLDanhGiaRLSV frame = new QLDanhGiaRLSV();
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
	public QLDanhGiaRLSV() throws IOException, SQLException {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 1174, 775);

		JPanel pnRLSV = new JPanel();
		pnRLSV.setBackground(new Color(255, 255, 255));
		getContentPane().add(pnRLSV, BorderLayout.CENTER);
		pnRLSV.setLayout(null);

		JPanel pnNhap = new JPanel();
		pnNhap.setBackground(new Color(255, 255, 255));
		pnNhap.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADp Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnNhap.setBounds(10, 10, 996, 105);
		pnRLSV.add(pnNhap);
		pnNhap.setLayout(null);

		JLabel maDG = new JLabel("Mã Đánh Giá");
		maDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maDG.setBounds(25, 41, 104, 25);
		pnNhap.add(maDG);

		JLabel lblHocKy = new JLabel("Học Kỳ");
		lblHocKy.setHorizontalAlignment(SwingConstants.LEFT);
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKy.setBounds(705, 41, 63, 27);
		pnNhap.add(lblHocKy);

		txtMaDG = new JTextField();
		txtMaDG.setBackground(new Color(245, 245, 245));
		txtMaDG.setBounds(123, 41, 165, 28);
		pnNhap.add(txtMaDG);
		txtMaDG.setColumns(10);

		JLabel lblNamHoc = new JLabel("Năm Học");
		lblNamHoc.setHorizontalAlignment(SwingConstants.LEFT);
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(361, 41, 89, 25);
		pnNhap.add(lblNamHoc);

		txtNamHoc = new JTextField();
		txtNamHoc.setBackground(new Color(245, 245, 245));
		txtNamHoc.setColumns(10);
		txtNamHoc.setBounds(460, 41, 164, 25);
		pnNhap.add(txtNamHoc);

		txtHocKy = new JTextField();
		txtHocKy.setBackground(new Color(245, 245, 245));
		txtHocKy.setColumns(10);
		txtHocKy.setBounds(769, 41, 165, 24);
		pnNhap.add(txtHocKy);

		lblxMaDG = new JLabel("X");
		lblxMaDG.setForeground(Color.RED);
		lblxMaDG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxMaDG.setBounds(298, 41, 32, 25);
		pnNhap.add(lblxMaDG);

		lblXNamHoc = new JLabel("X");
		lblXNamHoc.setForeground(Color.RED);
		lblXNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXNamHoc.setBounds(634, 41, 32, 25);
		pnNhap.add(lblXNamHoc);

		lblxHocKy = new JLabel("X");
		lblxHocKy.setHorizontalAlignment(SwingConstants.CENTER);
		lblxHocKy.setForeground(Color.RED);
		lblxHocKy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblxHocKy.setBounds(936, 41, 32, 25);
		pnNhap.add(lblxHocKy);

		JPanel pnHD = new JPanel();
		pnHD.setBackground(new Color(255, 255, 255));
		pnHD.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch \u0110\u00E1nh Gi\u00E1 R\u00E8n Luy\u1EC7n Sinh Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnHD.setBounds(10, 125, 996, 617);
		pnRLSV.add(pnHD);
		pnHD.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		pnHD.add(scrollPane_2, BorderLayout.CENTER);

		tblRLSV = new JTable();
		tblRLSV.setBackground(new Color(255, 255, 255));
		tblRLSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblRLSV.getSelectedRow();
				DanhGiaRLSV rlsv = RLSVList.get(index);
				setText(rlsv);
			}
		});

		scrollPane_2.setViewportView(tblRLSV);

		JButton btnT = new JButton("Tìm Kiếm");
		btnT.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/search.png")));
		btnT.setForeground(new Color(255, 255, 255));
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemRLSV tk = new TimKiemRLSV();
				tk.setVisible(true);
			}
		});
		btnT.setFont(new Font("Calibri", Font.PLAIN, 19));
		btnT.setBackground(new Color(65,49,102));
		btnT.setBounds(1016, 14, 137, 43);
		pnRLSV.add(btnT);

		JButton btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepRLSV sx = new SapXepRLSV();
				sx.setVisible(true);
			}
		});
		btnSapXep.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setBounds(1016, 66, 137, 43);
		pnRLSV.add(btnSapXep);

		btnNhap = new JButton("Nhập");
		btnNhap.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/insert.png")));
		btnNhap.setForeground(new Color(255, 255, 255));
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					DanhGiaRLSV dgsv = checkData();
					if (DanhGiaRLSVModify.exists.get(dgsv.getMaDG()) != null) {
						lblxMaDG.setVisible(true);
						JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Đánh Giá!");
					} else {
						DanhGiaRLSVModify.insert(dgsv);
						showRLSV(DanhGiaRLSVModify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}
				}
			}
		});
		btnNhap.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNhap.setBackground(new Color(65,49,102));
		btnNhap.setBounds(1016, 195, 137, 43);
		pnRLSV.add(btnNhap);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/edit.png")));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblRLSV.getSelectedRow();
				if (RLSVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput()) {
						setVisibleFalse();
						DanhGiaRLSV rlsv = checkData();
						DanhGiaRLSV std = RLSVList.get(index);
						if (Integer.parseInt(txtMaDG.getText()) != std.getMaDG()) {
							JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Đánh Giá");
						} else {
							DanhGiaRLSVModify.update(rlsv);
							showRLSV(DanhGiaRLSVModify.findAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}
					}
				}
			}
		});
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSua.setBackground(new Color(65,49,102));
		btnSua.setBounds(1016, 248, 137, 43);
		pnRLSV.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/delete.png")));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblRLSV.getSelectedRow();
				if (RLSVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng!");
				} else {
					DanhGiaRLSV rl = RLSVList.get(index);
					DanhGiaRLSVModify.delete(rl.getMaDG());
					showRLSV(DanhGiaRLSVModify.findAll());
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
				}
			}
		});
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(65,49,102));
		btnXoa.setBounds(1016, 301, 137, 43);
		pnRLSV.add(btnXoa);

		JButton btnXuatFileExcel = new JButton("File Excel");
		btnXuatFileExcel.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/export.png")));
		btnXuatFileExcel.setForeground(new Color(255, 255, 255));
		btnXuatFileExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXuatFileExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnXuatFileExcel.setBackground(new Color(65,49,102));
		btnXuatFileExcel.setBounds(1016, 646, 137, 43);
		pnRLSV.add(btnXuatFileExcel);

		JButton btnThoat = new JButton("Làm Mới");
		btnThoat.setIcon(new ImageIcon(QLDanhGiaRLSV.class.getResource("/buttonImages/refresh.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDanhGiaRLSV.showRLSV(DanhGiaRLSVModify.findAll());
				reset();
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(1016, 699, 137, 43);
		pnRLSV.add(btnThoat);
		if (ktCot == 0) {
			insertColumn();
		}
		showRLSV(DanhGiaRLSVModify.findAll());
		setVisibleFalse();
		isPermission();
	}

	private void insertColumn() {
		ktCot = 1;
		model.addColumn("MaDG");
		model.addColumn("NamHoc");
		model.addColumn("HocKy");
	}

	public static void showRLSV(List<DanhGiaRLSV> danhgia) {
		RLSVList = danhgia;
		model.setRowCount(0);
		for (DanhGiaRLSV hd : RLSVList) {
			model.addRow(new Object[] { hd.getMaDG(), hd.getNamHoc(), hd.getHocKy() });
		}
		tblRLSV.setModel(model);
	}

	private void reset() {
		txtMaDG.setText("");
		txtNamHoc.setText("");
		txtHocKy.setText("");
	}

	private void setText(DanhGiaRLSV rlsv) {
		txtMaDG.setText(String.valueOf(rlsv.getMaDG()));
		txtNamHoc.setText(rlsv.getNamHoc());
		txtHocKy.setText(String.valueOf(rlsv.getHocKy()));
	}

	private DanhGiaRLSV checkData() {
		int maDG = Integer.parseInt(txtMaDG.getText());
		String namHoc = txtNamHoc.getText();
		int hocKy = Integer.parseInt(txtHocKy.getText());
		DanhGiaRLSV hd = new DanhGiaRLSV(maDG, namHoc, hocKy);
		return hd;
	}

	private boolean standardInput() {
		if (!txtMaDG.equals("") && !txtNamHoc.equals("") && !txtHocKy.equals("")) {
			if (StandardInput.isNumber(txtMaDG.getText(), 0, 10000) == true
					&& StandardInput.isNumber(txtHocKy.getText(), 0, 2) == true
					&& StandardInput.isNumber(txtNamHoc.getText(), 1975, 2021) == true) {
				return true;
			} else {
				if (StandardInput.isNumber(txtMaDG.getText(), 0, 10000) == false) {
					JOptionPane.showMessageDialog(null, "Mã Đánh Giá Trong Khoảng (0,10000)");
					lblxMaDG.setVisible(true);
				}
				if (StandardInput.isNumber(txtHocKy.getText(), 1, 2) == false) {
					JOptionPane.showMessageDialog(null, "Học Kỳ Trong Khoảng (1,2)");
					lblxHocKy.setVisible(true);
				}
				if (StandardInput.isNumber(txtNamHoc.getText(), 1975, 2022) == false) {
					JOptionPane.showMessageDialog(null, "Năm Học lớn hơn 1975 và nhỏ hơn 2022");
					lblXNamHoc.setVisible(true);
				}
				// JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
				return false;
			}
		} else {
			if (txtMaDG.getText().equals("")) {
				lblxMaDG.setVisible(true);
			} else if (!txtMaDG.getText().equals("") && StandardInput.isNumber(txtMaDG.getText(), 0, 10000) == false) {
				JOptionPane.showMessageDialog(null, "Mã Đánh Giá Trong Khoảng (0,10000)!");
				lblxMaDG.setVisible(true);
			} else if (!txtMaDG.getText().equals("")
					&& DanhGiaRLSVModify.exists.get(Integer.parseInt(txtMaDG.getText())) != null) {
				lblxMaDG.setVisible(true);
				JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Đánh Giá!");
			}

			if (txtHocKy.getText().equals("")) {
				lblxHocKy.setVisible(true);
			} else {
				if (StandardInput.isNumber(txtHocKy.getText(), 0, 2) == false) {
					JOptionPane.showMessageDialog(null, "Học Kỳ Trong Khoảng (1,2)!");
					lblxHocKy.setVisible(true);
				}
			}

			if (txtNamHoc.getText().equals("")) {
				lblXNamHoc.setVisible(true);
			} else {
				if (StandardInput.isNumber(txtNamHoc.getText(), 1975, 2021) == false) {
					JOptionPane.showMessageDialog(null, "Năm Học lớn hơn 1975 và nhỏ hơn 2022!");
					lblXNamHoc.setVisible(true);
				}
			}

			JOptionPane.showMessageDialog(null, "Chưa Điền Đủ Thông Tin");
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
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_Sach_Danh_Gia_RLSV.xlsx");
				try {
					writerExcel.ghiFileExcelRLSV(linkfile, RLSVList);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			}
		}
	}

	private void setVisibleFalse() {
		lblxHocKy.setVisible(false);
		lblxMaDG.setVisible(false);
		lblXNamHoc.setVisible(false);
	}
	

	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnNhap.setVisible(false);
			btnSua.setVisible(false);
			btnXoa.setVisible(false);
		}
	}
}
