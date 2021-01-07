
package frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardOutput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.ChiDoan_modify;
import modify_object.GiangVien_modify;
import modify_object.LienChiDoan_modify;
import object_frame.ChiDoan;
import object_frame.GiangVien;
import object_frame.LienChi;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class QLChiDoan extends JInternalFrame {
	private static JTable table;
	private JTextField textField_MaChiDoan;
	private JTextField textField_TenChiDoan;
	private JTextField textField_SoLuongDV;
	private JComboBox<String> comboBox_TenGV;
	private JTextField textField_MaGV;
	private JTextField textField_Khoaz;
	private JPanel panel_ThongTin;
	private JLabel Label_TenChiDoan;
	private JLabel label_TenLienChiDoan;
	private JLabel label_MaChiDoan;
	private JLabel label_Khoaz;
	private JLabel label_SoLuongDV;
	private JLabel lblThngTinBan;
	private JLabel lblSLngon;
	private JLabel lblNewLabel_2;
	private JLabel lblTnGiangVin;
	private JLabel lblKhoa;
	private JLabel lblTnChion;
	private JLabel lblMChion;
	private JLabel lblTnLinChi;

	private static int index = -1;

	String filename = null;
	private static int kt = 0;

	private static DefaultTableModel model = new DefaultTableModel();
	public static List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();
	private JTextArea TTCanSuLop;
	private JComboBox comboBox_TenLC;
	Map<Integer, String> lienchiMap = new HashMap<Integer, String>();
	Map<Integer, String> giangvienMap = new HashMap<Integer, String>();
	private JButton buttom_Them;
	private JButton buttom_Sua;
	private JButton buttom_Xoa;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLChiDoan frame = new QLChiDoan();
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
	public QLChiDoan() throws IOException, SQLException {
		getContentPane().setBackground(new Color(255, 255, 255));
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
		
		setBounds(0, 0, 1174, 775);
		getContentPane().setLayout(null);

		panel_ThongTin = new JPanel();
		panel_ThongTin.setBackground(new Color(255, 255, 255));
		panel_ThongTin.setBorder(
				new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ThongTin.setBounds(10, 10, 970, 241);
		getContentPane().add(panel_ThongTin);
		panel_ThongTin.setLayout(null);

		lblMChion = new JLabel("Mã Chi Đoàn");
		lblMChion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMChion.setBounds(8, 87, 89, 32);
		panel_ThongTin.add(lblMChion);

		textField_MaChiDoan = new JTextField();
		textField_MaChiDoan.setBackground(new Color(245, 245, 245));
		textField_MaChiDoan.setFont(new Font("Calibri", Font.PLAIN, 13));
		textField_MaChiDoan.setBounds(107, 85, 161, 32);
		panel_ThongTin.add(textField_MaChiDoan);
		textField_MaChiDoan.setColumns(10);

		lblTnChion = new JLabel("Tên Chi Đoàn");
		lblTnChion.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnChion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnChion.setBounds(343, 31, 89, 32);
		panel_ThongTin.add(lblTnChion);

		lblKhoa = new JLabel("Khóa");
		lblKhoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKhoa.setBounds(343, 87, 70, 32);
		panel_ThongTin.add(lblKhoa);

		textField_TenChiDoan = new JTextField();
		textField_TenChiDoan.setBackground(new Color(245, 245, 245));
		textField_TenChiDoan.setFont(new Font("Calibri", Font.PLAIN, 13));
		textField_TenChiDoan.setColumns(10);
		textField_TenChiDoan.setBounds(442, 36, 161, 32);
		panel_ThongTin.add(textField_TenChiDoan);

		lblNewLabel_2 = new JLabel("Mã Giảng Viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(658, 88, 89, 32);
		panel_ThongTin.add(lblNewLabel_2);

		lblSLngon = new JLabel("Số Lượng");
		lblSLngon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLngon.setBounds(8, 129, 124, 32);
		panel_ThongTin.add(lblSLngon);

		textField_SoLuongDV = new JTextField();
		textField_SoLuongDV.setBackground(new Color(245, 245, 245));
		textField_SoLuongDV.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField_SoLuongDV.setColumns(10);
		textField_SoLuongDV.setBounds(107, 127, 161, 32);
		panel_ThongTin.add(textField_SoLuongDV);

		lblThngTinBan = new JLabel("Thông Tin Ban Cán Sự Lớp");
		lblThngTinBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinBan.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblThngTinBan.setBounds(439, 133, 164, 32);
		panel_ThongTin.add(lblThngTinBan);

		comboBox_TenLC = new JComboBox();
		comboBox_TenLC.setBackground(new Color(245, 245, 245));

		comboBox_TenLC.setBounds(107, 35, 161, 29);
		panel_ThongTin.add(comboBox_TenLC);

		lblTnLinChi = new JLabel("Tên Liên Chi");
		lblTnLinChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnLinChi.setBounds(8, 31, 79, 32);
		panel_ThongTin.add(lblTnLinChi);

		comboBox_TenGV = new JComboBox();
		comboBox_TenGV.setBackground(new Color(245, 245, 245));
		comboBox_TenGV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextGV();
			}
		});

		comboBox_TenGV.setBounds(785, 34, 161, 32);
		panel_ThongTin.add(comboBox_TenGV);

		lblTnGiangVin = new JLabel("Tên Giảng Viên");
		lblTnGiangVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnGiangVin.setBounds(658, 33, 89, 32);
		panel_ThongTin.add(lblTnGiangVin);

		textField_MaGV = new JTextField();
		textField_MaGV.setBackground(new Color(245, 245, 245));
		textField_MaGV.setEditable(false);
		textField_MaGV.setColumns(10);
		textField_MaGV.setBounds(785, 90, 161, 32);
		panel_ThongTin.add(textField_MaGV);

		textField_Khoaz = new JTextField();
		textField_Khoaz.setBackground(new Color(245, 245, 245));
		textField_Khoaz.setFont(new Font("Calibri", Font.PLAIN, 13));
		textField_Khoaz.setColumns(10);
		textField_Khoaz.setBounds(442, 87, 161, 32);
		panel_ThongTin.add(textField_Khoaz);

		label_MaChiDoan = new JLabel("X");
		label_MaChiDoan.setHorizontalAlignment(SwingConstants.CENTER);
		label_MaChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_MaChiDoan.setForeground(Color.RED);
		label_MaChiDoan.setBounds(269, 88, 22, 29);
		panel_ThongTin.add(label_MaChiDoan);

		Label_TenChiDoan = new JLabel("X");
		Label_TenChiDoan.setHorizontalAlignment(SwingConstants.CENTER);
		Label_TenChiDoan.setForeground(Color.RED);
		Label_TenChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_TenChiDoan.setBounds(602, 34, 22, 29);
		panel_ThongTin.add(Label_TenChiDoan);

		label_Khoaz = new JLabel("X");
		label_Khoaz.setHorizontalAlignment(SwingConstants.CENTER);
		label_Khoaz.setForeground(Color.RED);
		label_Khoaz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Khoaz.setBounds(602, 89, 22, 29);
		panel_ThongTin.add(label_Khoaz);

		label_SoLuongDV = new JLabel("X");
		label_SoLuongDV.setHorizontalAlignment(SwingConstants.CENTER);
		label_SoLuongDV.setForeground(Color.RED);
		label_SoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_SoLuongDV.setBounds(269, 131, 22, 29);
		panel_ThongTin.add(label_SoLuongDV);

		label_TenLienChiDoan = new JLabel("X");
		label_TenLienChiDoan.setHorizontalAlignment(SwingConstants.CENTER);
		label_TenLienChiDoan.setForeground(Color.RED);
		label_TenLienChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_TenLienChiDoan.setBounds(269, 33, 22, 29);
		panel_ThongTin.add(label_TenLienChiDoan);
		
				TTCanSuLop = new JTextArea();
				TTCanSuLop.setBackground(new Color(245, 245, 245));
				TTCanSuLop.setBounds(612, 135, 334, 92);
				panel_ThongTin.add(TTCanSuLop);

		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBackground(new Color(255, 255, 255));
		panel_DanhSach.setBorder(
				new TitledBorder(null, "Danh S\u00E1ch ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DanhSach.setBounds(10, 261, 970, 480);
		getContentPane().add(panel_DanhSach);
		panel_DanhSach.setLayout(null);

		JScrollPane scrollPane_Table = new JScrollPane();
		scrollPane_Table.setBounds(10, 19, 950, 451);
		panel_DanhSach.add(scrollPane_Table);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				showText(chidoanList.get(index));

			}
		});
		scrollPane_Table.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(990, 10, 163, 731);
		getContentPane().add(panel);
		panel.setLayout(null);
		buttom_Them = new JButton("Thêm");
		buttom_Them.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/insert.png")));
		buttom_Them.setForeground(new Color(255, 255, 255));
		buttom_Them.setBackground(new Color(65,49,102));
		buttom_Them.setBounds(10, 268, 142, 43);
		panel.add(buttom_Them);
		buttom_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLableVisible_false();

				if (standardInput() == true) {
					ChiDoan cd = setChiDoan();
					if (ChiDoan_modify.exists.get(cd.getMaChiDoan())!=null) {
						label_MaChiDoan.setVisible(true);
						JOptionPane.showMessageDialog(null, "Mã Chi Đoàn Đã Tồn Tại !");
					} else {
						if (ChiDoan_modify.insert(cd) == true) {
							chidoanList.add(cd);
							showChiDoan(chidoanList);
							reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công !");
						}else JOptionPane.showMessageDialog(null, "Thêm Không Thành công !");

					}

				}
			}
		});
		buttom_Them.setFont(new Font("Calibri", Font.PLAIN, 20));
		buttom_Sua = new JButton("Sửa");
		buttom_Sua.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/edit.png")));
		buttom_Sua.setForeground(new Color(255, 255, 255));
		buttom_Sua.setBackground(new Color(65,49,102));
		buttom_Sua.setBounds(10, 321, 142, 43);
		panel.add(buttom_Sua);
		buttom_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                setLableVisible_false();
				int index = table.getSelectedRow();
				if (chidoanList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối  !");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng !");
				} else {
					if (standardInput()) {
						setLableVisible_false();
						ChiDoan cd = setChiDoan();
						ChiDoan_modify.update(cd);
						showChiDoan(ChiDoan_modify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Sửa thành công !");

					}
				}
			}
		});
		buttom_Sua.setFont(new Font("Calibri", Font.PLAIN, 20));
		buttom_Xoa = new JButton("Xóa");
		buttom_Xoa.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/delete.png")));
		buttom_Xoa.setForeground(new Color(255, 255, 255));
		buttom_Xoa.setBackground(new Color(65,49,102));
		buttom_Xoa.setBounds(10, 374, 142, 43);
		panel.add(buttom_Xoa);
		buttom_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLableVisible_false();
				int index = table.getSelectedRow();
				if (chidoanList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng !");
				} else {
					ChiDoan cd = chidoanList.get(index);
					ChiDoan_modify.delete(cd.getMaChiDoan());
					ChiDoan_modify.exists.remove(cd.getMaChiDoan());
					chidoanList.remove(index);
					showChiDoan(chidoanList);
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công !");
				}
			}

		});
		buttom_Xoa.setFont(new Font("Calibri", Font.PLAIN, 20));

		JButton btnSutExcel = new JButton("File Excel");
		btnSutExcel.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/export.png")));
		btnSutExcel.setForeground(new Color(255, 255, 255));
		btnSutExcel.setBackground(new Color(65,49,102));
		btnSutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String linkfile = "";
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isDirectory()) {
						linkfile = (jfc.getSelectedFile() + "/" + "Danh_Sach_Chi_Doan.xlsx");

						try {
							writerExcel.ghiFileExcelCD(linkfile, chidoanList);

						} catch (IOException ex) {
							JOptionPane.showMessageDialog(null, ex);
						}
						JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
					}
				}

			}
		});
		btnSutExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSutExcel.setBounds(10, 625, 142, 43);
		panel.add(btnSutExcel);

		JButton btnTmKim = new JButton("Tìm Kiếm");
		btnTmKim.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/search.png")));
		btnTmKim.setForeground(new Color(255, 255, 255));
		btnTmKim.setBackground(new Color(65,49,102));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemChiDoan TKCD = new TimKiemChiDoan();
				TKCD.setVisible(true);

			}
		});
		btnTmKim.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnTmKim.setBounds(10, 10, 142, 43);
		panel.add(btnTmKim);

		JButton btnSpXp = new JButton("Sắp Xếp ");
		btnSpXp.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/sort.png")));
		btnSpXp.setForeground(new Color(255, 255, 255));
		btnSpXp.setBackground(new Color(65,49,102));
		btnSpXp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepChiDoan SXCD = new SapXepChiDoan();
				SXCD.setVisible(true);
			}
		});
		btnSpXp.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSpXp.setBounds(10, 63, 142, 43);
		panel.add(btnSpXp);

		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon(QLChiDoan.class.getResource("/buttonImages/refresh.png")));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(65,49,102));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showChiDoan(ChiDoan_modify.findAll());
				reset();
			}
		});
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.setBounds(10, 678, 142, 43);
		panel.add(btnReset);
		if (kt == 0) {
			setColumn();

		}

		setComboBoxTenLC();
		setComboBoTenGV();
		showChiDoan(ChiDoan_modify.findAll());
		setLableVisible_false();
		isPermission();
	}

	private void setColumn() {
		kt = 1;
		model.addColumn("MaChiDoan");
		model.addColumn("TenChiDoan");
		model.addColumn("khoa");
		model.addColumn("MaGV");
		model.addColumn("ThongtinBCH");
		model.addColumn("SoLuongDV");
		model.addColumn("MaLienChi");

	}

	public static void showChiDoan(List<ChiDoan> chidoan) {
		chidoanList = chidoan;
		model.setRowCount(0);
		for (ChiDoan cd : chidoanList) {
			model.addRow(new Object[] { cd.getMaChiDoan(), cd.getTenChiDoan(), cd.getKhoaz(), cd.getMaGV(),
					cd.getTTCanBoLop(), cd.getSoLuongDoanVien(), cd.getMaLienChiDoan() });
		}
		table.setModel(model);
	}

	private void reset() {
		comboBox_TenLC.setSelectedIndex(0);
		textField_MaChiDoan.setText("");

		textField_TenChiDoan.setText("");
		textField_Khoaz.setText("");
		comboBox_TenGV.setSelectedIndex(0);
		textField_MaGV.setText("");
		textField_SoLuongDV.setText("");
		TTCanSuLop.setText("");

	}

	private void showText(ChiDoan cd) {
		for (Integer key : lienchiMap.keySet()) {
			if (key == cd.getMaLienChiDoan())
				comboBox_TenLC.setSelectedItem(lienchiMap.get(key).toString());
		}
		textField_TenChiDoan.setText(cd.getTenChiDoan());
		textField_MaChiDoan.setText(String.valueOf(cd.getMaChiDoan()));
		textField_Khoaz.setText(cd.getKhoaz());
		textField_MaGV.setText(String.valueOf(cd.getMaGV()));
		textField_SoLuongDV.setText(String.valueOf(cd.getSoLuongDoanVien()));
		TTCanSuLop.setText(cd.getTTCanBoLop());

		for (int key : giangvienMap.keySet()) {
			if (cd.getMaGV() == key) {
				comboBox_TenGV.setSelectedItem(giangvienMap.get(key));
			}

		}

	}

	private ChiDoan setChiDoan() {
		ChiDoan cd = new ChiDoan();

		cd.setTenChiDoan(StandardOutput.formatString(textField_TenChiDoan.getText()));
		cd.setMaChiDoan(Integer.valueOf(textField_MaChiDoan.getText()));

		cd.setKhoaz(StandardOutput.formatString(textField_Khoaz.getText()));

		cd.setSoLuongDoanVien(Integer.valueOf(textField_SoLuongDV.getText()));

		cd.setTTCanBoLop(TTCanSuLop.getText());

		cd.setMaGV(Integer.valueOf(textField_MaGV.getText()));

		for (Integer key : lienchiMap.keySet()) {
			if (lienchiMap.get(key).equals(comboBox_TenLC.getSelectedItem()))
				cd.setMaLienChiDoan(key);

		}
		return cd;

	}

	// ____________________________________setsetComboBoxTenLC__________________________________\\
	private void setComboBoxTenLC() {

		comboBox_TenLC.addItem("                    ( - )");
		for (LienChi x : LienChiDoan_modify.findAll()) {
			lienchiMap.put(x.getMaLienChi(), x.getTenLienChi());
		}
		for (Integer key : lienchiMap.keySet()) {
			comboBox_TenLC.addItem(lienchiMap.get(key));
		}
	}

	// _______________________________________setComboBoxTenGV____________________________________________\\
	private void setComboBoTenGV() {

		comboBox_TenGV.addItem("                   ( - )");
		for (GiangVien x : GiangVien_modify.findAll()) {
			giangvienMap.put(x.getMaGV(), x.getHoTen());
		}
		for (int key : giangvienMap.keySet()) {
			comboBox_TenGV.addItem(giangvienMap.get(key));
		}
	}

	// ____________________________________setTextMaGV_____________________________________________________\\
	private void setTextGV() {
		if (comboBox_TenGV.getSelectedIndex() != 0) {
			String tenGV = comboBox_TenGV.getSelectedItem().toString();

			for (int key : giangvienMap.keySet()) {
				if (tenGV.equals(giangvienMap.get(key))) {
					textField_MaGV.setText(String.valueOf(key));
				}
			}

		} else
			textField_MaGV.setText("");
	}

	private boolean standardInput() {
			if(comboBox_TenLC.getSelectedIndex()!=0 && !textField_MaChiDoan.getText().equals("") && ! textField_TenChiDoan.equals("")
					&& !textField_Khoaz.getText().equals("") && !textField_SoLuongDV.getText().equals("") )
			{
				if(check_data.StandardInput.checkText(textField_TenChiDoan.getText())==true 
					&& check_data.StandardInput.isNumber(textField_MaChiDoan.getText())==true
					&& check_data.StandardInput.checkText(textField_Khoaz.getText())==true
					&& check_data.StandardInput.isNumber(textField_SoLuongDV.getText()) ==true
					
					)
				{

					return true ;
				}
				else {
					if(check_data.StandardInput.checkText(textField_TenChiDoan.getText())==false) 
						label_TenLienChiDoan.setVisible(true);
					if(check_data.StandardInput.isNumber(textField_MaChiDoan.getText())==false)
						label_MaChiDoan.setVisible(true);
					if( check_data.StandardInput.checkText(textField_Khoaz.getText())==false)
						label_Khoaz.setVisible(true);
					if( check_data.StandardInput.isNumber(textField_SoLuongDV.getText()) ==false)
						label_SoLuongDV.setVisible(true);
					JOptionPane.showMessageDialog(null, "Nhập Thông Tin Chưa Đúng  !");
					return false;
				}
				
			}
			else {
					if(comboBox_TenLC.getSelectedIndex()==0 )
					{
						label_TenLienChiDoan.setVisible(true);
					}
					
					if(textField_MaChiDoan.getText().equals(""))
					{
						label_MaChiDoan.setVisible(true);
					}
					else if(check_data.StandardInput.isNumber(textField_MaChiDoan.getText())==false)
					{
						label_MaChiDoan.setVisible(true);
					}
					
					if(textField_TenChiDoan.equals(""))
					{
						Label_TenChiDoan.setVisible(true);
					}
					else if(check_data.StandardInput.checkText(textField_TenChiDoan.getText())==false)
					{Label_TenChiDoan.setVisible(true);}
					
					if(textField_Khoaz.getText().equals(""))
					{
						label_Khoaz.setVisible(true);
					}
					else if(check_data.StandardInput.checkText(textField_Khoaz.getText())==false)
					{
						label_Khoaz.setVisible(true);
					}
					
					if(textField_SoLuongDV.getText().equals(""))
					{
						label_SoLuongDV.setVisible(true);
					}
					else {
						label_SoLuongDV.setVisible(true);
					}
					
					JOptionPane.showMessageDialog(null, "Nhập Thiếu Thông Tin !");
					
				return false ;
				
			}	
	}


	private void setLableVisible_false() {
		label_Khoaz.setVisible(false);
		label_SoLuongDV.setVisible(false);
		Label_TenChiDoan.setVisible(false);
		label_MaChiDoan.setVisible(false);
		label_TenLienChiDoan.setVisible(false);

	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			buttom_Them.setVisible(false);
			buttom_Sua.setVisible(false);
			buttom_Xoa.setVisible(false);
		}
	}
	

}