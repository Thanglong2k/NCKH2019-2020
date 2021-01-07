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
import frame.*;
import modify_object.AdminModify;
import modify_object.KhenThuongModify;
import modify_object.KyLuatModify;
import modify_object.StudentModify;
import object_frame.KhenThuong;
import object_frame.KyLuat;
import object_frame.Student;
import javax.swing.ImageIcon;
public class QLKyLuat extends JInternalFrame {
	private JTextField txtMaDV;
	private JTextField txtNgayKL;
	private JTextField txtMSKL;
	private JTextArea txtLyDo;
	private JTextArea txtND;
	
	private JLabel lblLD;
	private JLabel lblMDV;
	private JLabel lblMKL;
	private JLabel lblND;
	private JLabel lblNKL;
	
	private static int ktCot=0;

	private static DefaultTableModel model = new DefaultTableModel();
	public static List<KyLuat> kyluatList = new ArrayList<>();
	static Map<String, String> MDV = new HashMap<String, String>();
	Map<String, Boolean> M = new HashMap<String, Boolean>();
	private static JTable tblKL;
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
					QLKyLuat frame = new QLKyLuat();
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
	public QLKyLuat() throws IOException, SQLException {
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setForeground(Color.WHITE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1165, 774);
		setTitle("Quản Lý Kỷ Luật");
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
		panel_1.setBounds(10, 10, 965, 170);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMSKhen = new JLabel("Mã Số Kỷ Luật");
		lblMSKhen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSKhen.setForeground(Color.BLACK);
		lblMSKhen.setBounds(10, 36, 116, 16);
		panel_1.add(lblMSKhen);

		JLabel lblNewLabel = new JLabel("Mã Đoàn Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 67, 97, 28);
		panel_1.add(lblNewLabel);

		JLabel lblNiDung = new JLabel("Nội Dung");
		lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNiDung.setBounds(627, 33, 84, 19);
		panel_1.add(lblNiDung);

		JLabel lblLDo = new JLabel("Lý Do");
		lblLDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLDo.setBounds(303, 36, 79, 19);
		panel_1.add(lblLDo);

		JLabel lblNgyKLut = new JLabel("Ngày Kỷ Luật");
		lblNgyKLut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyKLut.setBounds(10, 105, 116, 24);
		panel_1.add(lblNgyKLut);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(702, 33, 221, 108);
		panel_1.add(scrollPane);
		
				txtND = new JTextArea();
				scrollPane.setViewportView(txtND);
				txtND.setBackground(new Color(245, 245, 245));

		txtMaDV = new JTextField();
		txtMaDV.setBackground(new Color(245, 245, 245));
		txtMaDV.setBounds(117, 72, 141, 24);
		panel_1.add(txtMaDV);
		txtMaDV.setColumns(10);

		txtNgayKL = new JTextField();
		txtNgayKL.setBackground(new Color(245, 245, 245));
		txtNgayKL.setBounds(117, 108, 141, 24);
		panel_1.add(txtNgayKL);
		txtNgayKL.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 33, 221, 108);
		panel_1.add(scrollPane_1);
		
				txtLyDo = new JTextArea();
				scrollPane_1.setViewportView(txtLyDo);
				txtLyDo.setBackground(new Color(245, 245, 245));

		txtMSKL = new JTextField();
		txtMSKL.setBackground(new Color(245, 245, 245));
		txtMSKL.setColumns(10);
		txtMSKL.setBounds(117, 33, 141, 24);
		panel_1.add(txtMSKL);
		
		lblMKL = new JLabel("X");
		lblMKL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKL.setForeground(Color.RED);
		lblMKL.setBounds(262, 34, 16, 21);
		panel_1.add(lblMKL);
		
		lblMDV = new JLabel("X");
		lblMDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMDV.setForeground(Color.RED);
		lblMDV.setBounds(262, 73, 16, 21);
		panel_1.add(lblMDV);
		
		lblLD = new JLabel("X");
		lblLD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLD.setHorizontalAlignment(SwingConstants.CENTER);
		lblLD.setForeground(Color.RED);
		lblLD.setBounds(589, 35, 16, 19);
		panel_1.add(lblLD);
		
		lblND = new JLabel("X");
		lblND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblND.setHorizontalAlignment(SwingConstants.CENTER);
		lblND.setForeground(Color.RED);
		lblND.setBounds(933, 34, 16, 21);
		panel_1.add(lblND);
		
		lblNKL = new JLabel("X");
		lblNKL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNKL.setForeground(Color.RED);
		lblNKL.setBounds(262, 108, 16, 21);
		panel_1.add(lblNKL);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "Danh sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 190, 965, 549);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane(tblKL, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		tblKL = new JTable();
		tblKL.setBackground(new Color(255, 255, 255));
		tblKL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblKL.getSelectedRow();
				KyLuat ky = kyluatList.get(index);
				setText(ky);
			}
		});
		scrollPane_2.setViewportView(tblKL);
		setBackground(new Color(255, 255, 255));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(985, 12, 168, 727);
		panel.add(panel_3);
		panel_3.setLayout(null);

		btnAdd = new JButton("Nhập");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/insert.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				if (standardInput() == true) {
					KyLuat kyluat = checkData();
					if (KyLuatModify.exists.get(kyluat.getMaSo()) != null) {
						lblMKL.setVisible(true);
						JOptionPane.showMessageDialog(null, "Đã Tồn Tại Mã Kỷ Luật!");
					}
					else {
						try {
							KyLuatModify.insert(kyluat);
							showKyLuat(KyLuatModify.fillAll());
							reset();
							JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAdd.setBounds(10, 216, 148, 39);
		btnAdd.setBackground(new Color(65,49,102));
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/edit.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleFalse();
				int index = tblKL.getSelectedRow();
				if (kyluatList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng chưa có đối tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn một đối tượng trong bảng");
				} else {

					if (standardInput()) {
						setVisibleFalse();
						KyLuat KyLuat = checkData();
						KyLuat std = kyluatList.get(index);
						if (Integer.parseInt(txtMSKL.getText()) != std.getMaSo()) {
							JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Kỷ Luật!");
						} else {
							try {
								KyLuatModify.update(KyLuat);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							showKyLuat(KyLuatModify.fillAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}
					}
				}
			}
		});
		btnUpdate.setBounds(10, 265, 148, 39);
		btnUpdate.setBackground(new Color(65,49,102));
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnUpdate);

		btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tblKL.getSelectedRow();
				if (kyluatList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng chưa có đối tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn một đối tượng trong bảng");
				} else {
					KyLuat kyLuat = kyluatList.get(index);
					try {
						KyLuatModify.delete(kyLuat);
						showKyLuat(KyLuatModify.fillAll());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");

				}
			}
		});
		btnDelete.setBounds(10, 314, 148, 39);
		btnDelete.setBackground(new Color(65,49,102));
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnDelete);

		JButton btnCancel = new JButton("Làm Mới");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/refresh.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLKyLuat.showKyLuat(KyLuatModify.fillAll());
				reset();
			}
		});
		btnCancel.setBounds(10, 678, 148, 39);
		btnCancel.setBackground(new Color(65,49,102));
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel_3.add(btnCancel);

		JButton btnExcel = new JButton("File Excel");
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/export.png")));
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnExcel.setBackground(new Color(65,49,102));
		btnExcel.setBounds(10, 629, 148, 39);
		panel_3.add(btnExcel);

		JButton btnSort = new JButton("Sắp Xếp");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/sort.png")));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SapXepKyLuat sx = new SapXepKyLuat();
				sx.setVisible(true);
			}
		});
		btnSort.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSort.setBackground(new Color(65,49,102));
		btnSort.setBounds(10, 59, 148, 39);
		panel_3.add(btnSort);

		JButton btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setIcon(new ImageIcon(QLKyLuat.class.getResource("/buttonImages/search.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemKyLuat tk = new TimKiemKyLuat();
				tk.setVisible(true);

			}
		});
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSearch.setBackground(new Color(65,49,102));
		btnSearch.setBounds(10, 10, 148, 39);
		panel_3.add(btnSearch);
		if(ktCot==0) {
			insertColumn();
		}
		showKyLuat(KyLuatModify.fillAll());
		setVisibleFalse();
		isPermission();
	}

	static void showKyLuat(List<KyLuat> kyluat) {
		kyluatList = kyluat;
		SapXepKyLuat.getData();
		model.setRowCount(0);
		for (KyLuat kl : kyluatList) {
			model.addRow(
					new Object[] { kl.getMaSo(), kl.getMaDV(),SapXepKyLuat.M.get(kl.getMaDV()), kl.getLyDo(), kl.getNoiDung(), kl.getNgayKyLuat() });
		}
		tblKL.setModel(model);
	}

	private void reset() {
		txtMaDV.setText("");
		txtMSKL.setText("");
		txtLyDo.setText("");
		txtND.setText("");
		txtNgayKL.setText("");
	}

	private void setText(KyLuat kyluat) {
		txtMaDV.setText(kyluat.getMaDV());
		txtMSKL.setText(String.valueOf(kyluat.getMaSo()));
		txtLyDo.setText(kyluat.getLyDo());
		txtND.setText(kyluat.getNoiDung());
		txtNgayKL.setText(kyluat.getNgayKyLuat());
	}

	private KyLuat checkData() {
		String maDV = txtMaDV.getText();
		int maSo = Integer.parseInt(txtMSKL.getText());
		String lyDo = txtLyDo.getText();
		String noiDung = txtND.getText();
		String ngayKyLuat = txtNgayKL.getText();

		KyLuat kyluat = new KyLuat(maSo, maDV, lyDo, noiDung, ngayKyLuat);
		return kyluat;
	}

	private boolean standardInput() {
		List<Student> dv = StudentModify.findAll();
		for (Student a : dv) {
			M.put(a.getMaSV(), true);
		}
		// kiem tra thong tin trong nhung o text bat buoc phai co
		if (!txtMaDV.getText().equals("") && !txtMSKL.getText().equals("") && !txtLyDo.getText().equals("")
				&& !txtND.getText().equals("") && !txtNgayKL.getText().equals("")) {
			if(StandardInput.checkString(txtLyDo.getText())==true &&
					StandardInput.checkDate(txtNgayKL.getText())==true &&
							M.containsKey(txtMaDV.getText()) == true &&
					StandardInput.isNumber(txtMSKL.getText(),0,10000)==true &&
					StandardInput.checkString(txtND.getText())==true)
				return true;
			else {
				
				if (StandardInput.checkString(txtLyDo.getText()) == false) {
					lblLD.setVisible(true);
				}
				if (StandardInput.checkDate(txtNgayKL.getText()) == false) {
					lblNKL.setVisible(true);
				}
//				if (StandardInput.checkMa(txtMaDV.getText()) == false) {
//					lblMDV.setVisible(true);
//				}
				if (M.containsKey(txtMaDV.getText()) != true) {
					JOptionPane.showMessageDialog(null, "Không Tồn Tại Mã Đoàn Viên!");
					lblMDV.setVisible(true);
				}
				if (StandardInput.isNumber(txtMSKL.getText(),0,10000) == false) {
					lblMKL.setVisible(true);
				}
				if (!txtMSKL.getText().equals("")
						&& KyLuatModify.exists.get(Integer.parseInt(txtMSKL.getText())) != null) {
					int index = tblKL.getSelectedRow();
					KyLuat std = kyluatList.get(index);
					if (Integer.parseInt(txtMSKL.getText()) == std.getMaSo()) {
						lblMKL.setVisible(false);
						// JOptionPane.showMessageDialog(null, "Không Thể Sửa Mã Khen Thưởng!");
					} else {
						JOptionPane.showMessageDialog(null, "Mã Kỷ Luật Tồn Tại");
						lblMKL.setVisible(true);
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
			}
			else {
				if (StandardInput.checkMa(txtMaDV.getText()) == false) {
					lblMDV.setVisible(true);
				}
				
			}
			if (txtLyDo.getText().equals("")) {
				lblLD.setVisible(true);
			}
			else {
				if (StandardInput.checkString(txtLyDo.getText()) == false) {
					lblLD.setVisible(true);
				}
				
			}
			
			
			if (txtMSKL.getText().equals("")) {
				lblMKL.setVisible(true);
			} else if (!txtMSKL.getText().equals("") && StandardInput.isNumber(txtMSKL.getText(), 0, 10000) == false) {
				lblMKL.setVisible(true);
			} else if (!txtMSKL.getText().equals("")
					&& KyLuatModify.exists.get(Integer.parseInt(txtMSKL.getText())) != null) {
				lblMKL.setVisible(true);
			}

			
			
			if (txtND.getText().equals("")) {
				lblND.setVisible(true);
			}
			else {
				if (StandardInput.checkString(txtND.getText()) == false) {
					lblND.setVisible(true);
				}
				
			}
			if (txtNgayKL.getText().equals("")) {
				lblNKL.setVisible(true);
			}
			else {
				if (StandardInput.checkDate(txtNgayKL.getText()) == false) {
					lblNKL.setVisible(true);
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
				linkfile = (jfc.getSelectedFile() + "/" + "Danh_sach_ky_luat_doan_vien.xlsx");

				try {
					writerExcel2.ghiFileExcelKL(linkfile, kyluatList);

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
		lblMKL.setVisible(false);
		lblND.setVisible(false);
		lblNKL.setVisible(false);
	}
	
	private void insertColumn() {
		ktCot=1;
		model.addColumn("Mã số kỷ luật");
		model.addColumn("Mã đoàn viên");
		model.addColumn("Họ tên");
		model.addColumn("Lý do");
		model.addColumn("Nội dung");
		model.addColumn("Ngày Kỷ Luật");
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			btnAdd.setVisible(false);
			btnDelete.setVisible(false);
			btnUpdate.setVisible(false);
		}
	}
}
