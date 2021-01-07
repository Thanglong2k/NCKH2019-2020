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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import export_file.writerExcel2;
import modify_object.AdminModify;
import modify_object.KhenThuongModify;
import modify_object.StudentModify;
import object_frame.KhenThuong;
import object_frame.Student;
import javax.swing.ImageIcon;

public class QLKhenThuong extends JInternalFrame {
	protected static final KhenThuong KhenThuong = null;
	private JTextField txtMaDV;
	private JTextField txtNgayKT;
	private JTextField txtMSKT;
	private JTextArea txtLyDo;
	private JTextArea txtND;

	private JLabel lblLD;
	private JLabel lblMDV;
	private JLabel lblMKT;
	private JLabel lblND;
	private JLabel lblNKT;

	private static int ktCot = 0;

	private static DefaultTableModel model = new DefaultTableModel();
	public static List<KhenThuong> KhenThuongList = new ArrayList<>();
	public static List<Student> studentList = new ArrayList<>();
	static Map<String, String> MDV = new HashMap<String, String>();
	Map<String, Boolean> M = new HashMap<String, Boolean>();
	private static JTable tblKT;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLKhenThuong frame = new QLKhenThuong();
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
	public QLKhenThuong() throws IOException, SQLException {
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setForeground(Color.WHITE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1173, 776);
		setTitle("Quản Lý Khen Thưởng");
		try {
			setMaximum(true);
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Nhập thông tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 973, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMSKhen = new JLabel("Mã Số Khen Thưởng");
		lblMSKhen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSKhen.setBounds(10, 34, 141, 21);
		panel_1.add(lblMSKhen);

		JLabel lblNewLabel = new JLabel("Mã Đoàn Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 65, 116, 22);
		panel_1.add(lblNewLabel);

		JLabel lblNiDung = new JLabel("Nội Dung");
		lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNiDung.setBounds(655, 32, 79, 25);
		panel_1.add(lblNiDung);

		JLabel lblLDo = new JLabel("Lý Do");
		lblLDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLDo.setBounds(359, 35, 79, 19);
		panel_1.add(lblLDo);

		JLabel lblNgyKTut = new JLabel("Ngày Khen Thưởng");
		lblNgyKTut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyKTut.setBounds(10, 97, 141, 24);
		panel_1.add(lblNgyKTut);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(744, 34, 182, 87);
		panel_1.add(scrollPane);
		
				txtND = new JTextArea();
				txtND.setBackground(new Color(245, 245, 245));
				scrollPane.setViewportView(txtND);

		txtMaDV = new JTextField();
		txtMaDV.setBackground(new Color(245, 245, 245));
		txtMaDV.setBounds(157, 69, 160, 24);
		panel_1.add(txtMaDV);
		txtMaDV.setColumns(10);

		txtNgayKT = new JTextField();
		txtNgayKT.setBackground(new Color(245, 245, 245));
		txtNgayKT.setBounds(157, 103, 160, 24);
		panel_1.add(txtNgayKT);
		txtNgayKT.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(415, 34, 193, 87);
		panel_1.add(scrollPane_1);
		
				txtLyDo = new JTextArea();
				txtLyDo.setBackground(new Color(245, 245, 245));
				scrollPane_1.setViewportView(txtLyDo);

		txtMSKT = new JTextField();
		txtMSKT.setBackground(new Color(245, 245, 245));
		txtMSKT.setColumns(10);
		txtMSKT.setBounds(157, 35, 160, 24);
		panel_1.add(txtMSKT);

		lblMKT = new JLabel("X");
		lblMKT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKT.setForeground(Color.RED);
		lblMKT.setBounds(322, 34, 16, 21);
		panel_1.add(lblMKT);

		lblMDV = new JLabel("X");
		lblMDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMDV.setForeground(Color.RED);
		lblMDV.setBounds(322, 70, 16, 21);
		panel_1.add(lblMDV);

		lblLD = new JLabel("X");
		lblLD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLD.setForeground(Color.RED);
		lblLD.setBounds(618, 35, 16, 21);
		panel_1.add(lblLD);

		lblND = new JLabel("X");
		lblND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblND.setForeground(Color.RED);
		lblND.setBounds(936, 34, 16, 21);
		panel_1.add(lblND);

		lblNKT = new JLabel("X");
		lblNKT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNKT.setForeground(Color.RED);
		lblNKT.setBounds(322, 104, 16, 21);
		panel_1.add(lblNKT);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "Danh sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 175, 973, 566);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane(tblKT, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		tblKT = new JTable();
		tblKT.setBackground(new Color(255, 255, 255));
		tblKT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblKT.getSelectedRow();
				KhenThuong ky = KhenThuongList.get(index);
				setText(ky);
			}
		});
		scrollPane_2.setViewportView(tblKT);
		setBackground(new Color(255, 255, 255));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(993, 10, 158, 731);
		panel.add(panel_3);
		panel_3.setLayout(null);

		btnAdd = new JButton("Nhập");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/insert.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					KhenThuong KhenThuong = checkData();
					if (KhenThuongModify.exists.get(KhenThuong.getMaSo()) != null) {
						lblMKT.setVisible(true);
						JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Khen Thưởng!");
					} else {
						try {
							KhenThuongModify.insert(KhenThuong);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						showKhenThuong(KhenThuongModify.fillAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}
				}
			}
		});
		btnAdd.setBounds(10, 178, 138, 39);
		btnAdd.setBackground(new Color(65,49,102));
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/edit.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblKT.getSelectedRow();
				if (KhenThuongList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng chưa có đối tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn một đối tượng trong bảng");
				} else {
					if (standardInput()) {
						setVisibleFalse();
						KhenThuong KhenThuong = checkData();
						KhenThuong std = KhenThuongList.get(index);
						if (Integer.parseInt(txtMSKT.getText()) != std.getMaSo()) {
							JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Khen Thưởng!");
						} else {
							try {
								KhenThuongModify.update(KhenThuong);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							showKhenThuong(KhenThuongModify.fillAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}
					}
				}
			}
		});
		btnUpdate.setBounds(10, 227, 138, 39);
		btnUpdate.setBackground(new Color(65,49,102));
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnUpdate);

		btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblKT.getSelectedRow();
				if (KhenThuongList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng chưa có đối tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn một đối tượng trong bảng");
				} else {
					KhenThuong KhenThuong = KhenThuongList.get(index);
					try {
						KhenThuongModify.delete(KhenThuong);
						showKhenThuong(KhenThuongModify.fillAll());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");

				}
			}
		});
		btnDelete.setBounds(10, 276, 138, 39);
		btnDelete.setBackground(new Color(65,49,102));
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnDelete);

		JButton btnCancel = new JButton("Làm Mới");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/refresh.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLKhenThuong.showKhenThuong(KhenThuongModify.fillAll());
				reset();
			}
		});
		btnCancel.setBounds(10, 682, 138, 39);
		btnCancel.setBackground(new Color(65,49,102));
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnCancel);

		JButton btnExcel = new JButton("File Excel");
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/export.png")));
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnExcel.setBackground(new Color(65,49,102));
		btnExcel.setBounds(10, 633, 138, 39);
		panel_3.add(btnExcel);

		JButton btnSort = new JButton("Sắp Xếp");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/sort.png")));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepKhenThuong sx = new SapXepKhenThuong();
				sx.setVisible(true);
			}
		});
		btnSort.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSort.setBackground(new Color(65,49,102));
		btnSort.setBounds(10, 59, 138, 39);
		panel_3.add(btnSort);

		JButton btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setIcon(new ImageIcon(QLKhenThuong.class.getResource("/buttonImages/search.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemKhenThuong tk = new TimKiemKhenThuong();
				tk.setVisible(true);

			}
		});
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSearch.setBackground(new Color(65,49,102));
		btnSearch.setBounds(10, 10, 138, 39);
		panel_3.add(btnSearch);
		if (ktCot == 0) {
			insertColumn();
		}
		showKhenThuong(KhenThuongModify.fillAll());
		setVisibleFalse();
		isPermission();
	}

	static void showKhenThuong(List<KhenThuong> KhenThuong) {
		KhenThuongList = KhenThuong;
		SapXepKhenThuong.getData();
		model.setRowCount(0);
		for (KhenThuong KT : KhenThuongList) {
			model.addRow(new Object[] { KT.getMaSo(), KT.getMaDV(), SapXepKhenThuong.M.get(KT.getMaDV()), KT.getLyDo(),
					KT.getNoiDung(), KT.getNgayKhenThuong() });
		}
		tblKT.setModel(model);
	}

	private void reset() {
		txtMaDV.setText("");
		txtMSKT.setText("");
		txtLyDo.setText("");
		txtND.setText("");
		txtNgayKT.setText("");
	}

	private void setText(KhenThuong KhenThuong) {
		txtMaDV.setText(KhenThuong.getMaDV());
		txtMSKT.setText(String.valueOf(KhenThuong.getMaSo()));
		txtLyDo.setText(KhenThuong.getLyDo());
		txtND.setText(KhenThuong.getNoiDung());
		txtNgayKT.setText(KhenThuong.getNgayKhenThuong());
	}

	private KhenThuong checkData() {
		String maDV = txtMaDV.getText();
		int maSo = Integer.parseInt(txtMSKT.getText());
		String lyDo = txtLyDo.getText();
		String noiDung = txtND.getText();
		String ngayKhenThuong = txtNgayKT.getText();

		KhenThuong KhenThuong = new KhenThuong(maSo, maDV, lyDo, noiDung, ngayKhenThuong);
		return KhenThuong;
	}

	private boolean standardInput() {
		List<Student> dv = StudentModify.findAll();
		for (Student a : dv) {
			M.put(a.getMaSV(), true);
		}

		if (!txtMaDV.getText().equals("") && !txtMSKT.getText().equals("") && !txtLyDo.getText().equals("")
				&& !txtND.getText().equals("") && !txtNgayKT.getText().equals("")) {
			if (StandardInput.checkString(txtLyDo.getText()) == true
					&& StandardInput.checkDate(txtNgayKT.getText()) == true 
					&& M.containsKey(txtMaDV.getText()) == true
					&& StandardInput.isNumber(txtMSKT.getText(), 0, 10000) == true
					&& StandardInput.checkString(txtND.getText()) == true)
				return true;
			else {

				if (StandardInput.checkString(txtLyDo.getText()) == false) {
					lblLD.setVisible(true);
				}
				if (StandardInput.checkDate(txtNgayKT.getText()) == false) {
					lblNKT.setVisible(true);
				}
//				if (StandardInput.checkMa(txtMaDV.getText()) == false) {
//					lblMDV.setVisible(true);
//				}
				if (M.containsKey(txtMaDV.getText()) != true) {
					JOptionPane.showMessageDialog(null, "Khong ton tai MDV!");
					lblMDV.setVisible(true);
				}
				if (StandardInput.isNumber(txtMSKT.getText(), 0, 10000) == false) {
					lblMKT.setVisible(true);
				}
				if (!txtMSKT.getText().equals("")
						&& KhenThuongModify.exists.get(Integer.parseInt(txtMSKT.getText())) != null) {
					int index = tblKT.getSelectedRow();
					KhenThuong std = KhenThuongList.get(index);
					if (Integer.parseInt(txtMSKT.getText()) == std.getMaSo()) {
						lblMKT.setVisible(false);
						// JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Khen Thưởng!");
					} else {
						JOptionPane.showMessageDialog(null, "Mã Khen Thưởng Tồn Tại");
						lblMKT.setVisible(true);
					}

				}
				if (StandardInput.checkString(txtND.getText()) == false) {
					lblND.setVisible(true);
				}
				JOptionPane.showMessageDialog(null, "Nhập chưa đúng");
				return false;
			}
		} else {

			if (txtMaDV.getText().equals("")) {
				lblMDV.setVisible(true);
			} else {
				if (M.containsKey(txtMaDV.getText()) != true) {
					JOptionPane.showMessageDialog(null, "Khong ton tai MDV!");
					lblMDV.setVisible(true);
				}
			}

			if (txtLyDo.getText().equals("")) {
				lblLD.setVisible(true);
			} else {
				if (StandardInput.checkString(txtLyDo.getText()) == false) {
					lblLD.setVisible(true);
				}

			}

			if (txtMSKT.getText().equals("")) {
				lblMKT.setVisible(true);
			} else if (!txtMSKT.getText().equals("") && StandardInput.isNumber(txtMSKT.getText(), 0, 10000) == false) {
				lblMKT.setVisible(true);
			} else if (!txtMSKT.getText().equals("")
					&& KhenThuongModify.exists.get(Integer.parseInt(txtMSKT.getText())) != null) {
				lblMKT.setVisible(true);
			}

			if (txtND.getText().equals("")) {
				lblND.setVisible(true);
			} else {
				if (StandardInput.checkString(txtND.getText()) == false) {
					lblND.setVisible(true);
				}
			}

			if (txtNgayKT.getText().equals("")) {
				lblNKT.setVisible(true);
			} else {
				if (StandardInput.checkDate(txtNgayKT.getText()) == false) {
					lblNKT.setVisible(true);
				}

			}

			JOptionPane.showMessageDialog(null, "Chưa Điền Đầy Đủ Thông Tin");
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
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_sach_khen_thuong_doan_vien.xlsx");
				try {
					writerExcel2.ghiFileExcelKT(linkfile, KhenThuongList);

				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công!");
			}
		}
	}

	private void setVisibleFalse() {
		lblLD.setVisible(false);
		lblMDV.setVisible(false);
		lblMKT.setVisible(false);
		lblND.setVisible(false);
		lblNKT.setVisible(false);
	}

	private void insertColumn() {
		ktCot = 1;
		model.addColumn("Mã số khen thưởng");
		model.addColumn("Mã đoàn viên");
		model.addColumn("Họ tên");
		model.addColumn("Lý do");
		model.addColumn("Nội dung");
		model.addColumn("Ngày khen thưởng");
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnAdd.setVisible(false);
			btnDelete.setVisible(false);
			btnUpdate.setVisible(false);
		}
	}
}
