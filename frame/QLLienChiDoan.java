package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import check_data.StandardOutput;
import modify_object.AdminModify;
import modify_object.LienChiDoan_modify;
import object_frame.LienChi;
import object_frame.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class QLLienChiDoan extends JInternalFrame {
	private static JTable table;
	private JTextField MaLienChiDoan;
	private JTextField TenLienChiDoan;
	private JTextArea ThongTinBCH;
	private JLabel lblMaLienChi;
	private JLabel lblTenLienChi;
	private JPanel panel_ThongTin;
	private JLabel lblThongTinBCH;
	private static int ktCot = 0;
	private static DefaultTableModel model = new DefaultTableModel();
	static List<LienChi> lienchiList = new ArrayList<LienChi>();
	private JButton buttom_Them;
	private JButton buttom_Sua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLLienChiDoan frame = new QLLienChiDoan();
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
	public QLLienChiDoan() throws IOException, SQLException {
		getContentPane().setBackground(Color.WHITE);
		setBounds(0, 0, 1191, 775);
		getContentPane().setLayout(null);
		setMaximizable(true);
		setResizable(true);

		this.setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		panel_ThongTin = new JPanel();
		panel_ThongTin.setBackground(Color.WHITE);
		panel_ThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u1EADp Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_ThongTin.setBounds(10, 10, 993, 143);
		getContentPane().add(panel_ThongTin);
		panel_ThongTin.setLayout(null);

		JLabel Label_TT_MaLienChiDoan = new JLabel("Mã Liên Chi Đoàn");
		Label_TT_MaLienChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_TT_MaLienChiDoan.setBounds(8, 29, 124, 45);
		panel_ThongTin.add(Label_TT_MaLienChiDoan);

		JLabel Label_TT_TenLienChiDoan = new JLabel("Tên Liên Chi Đoàn");
		Label_TT_TenLienChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_TT_TenLienChiDoan.setBounds(8, 84, 124, 45);
		panel_ThongTin.add(Label_TT_TenLienChiDoan);

		JLabel Label_TT_ThongTinBCH = new JLabel("Thông Tin Ban Chấp Hành");
		Label_TT_ThongTinBCH.setHorizontalAlignment(SwingConstants.CENTER);
		Label_TT_ThongTinBCH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label_TT_ThongTinBCH.setBounds(336, 29, 212, 45);
		panel_ThongTin.add(Label_TT_ThongTinBCH);

		MaLienChiDoan = new JTextField();
		MaLienChiDoan.setBackground(new Color(245, 245, 245));
		MaLienChiDoan.setBounds(142, 37, 157, 32);
		panel_ThongTin.add(MaLienChiDoan);
		MaLienChiDoan.setColumns(10);

		TenLienChiDoan = new JTextField();
		TenLienChiDoan.setBackground(new Color(245, 245, 245));
		TenLienChiDoan.setColumns(10);
		TenLienChiDoan.setBounds(142, 90, 157, 32);
		panel_ThongTin.add(TenLienChiDoan);

		ThongTinBCH = new JTextArea();
		ThongTinBCH.setBackground(new Color(245, 245, 245));
		ThongTinBCH.setBounds(555, 37, 395, 75);
		panel_ThongTin.add(ThongTinBCH);

		lblMaLienChi = new JLabel("x");
		lblMaLienChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaLienChi.setForeground(Color.RED);
		lblMaLienChi.setBounds(309, 35, 17, 24);
		panel_ThongTin.add(lblMaLienChi);

		lblTenLienChi = new JLabel("x");
		lblTenLienChi.setForeground(Color.RED);
		lblTenLienChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenLienChi.setBounds(309, 90, 17, 24);
		panel_ThongTin.add(lblTenLienChi);

		lblThongTinBCH = new JLabel("x");
		lblThongTinBCH.setForeground(Color.RED);
		lblThongTinBCH.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblThongTinBCH.setBounds(960, 38, 17, 24);
		panel_ThongTin.add(lblThongTinBCH);

		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBackground(Color.WHITE);
		panel_DanhSach.setBorder(
				new TitledBorder(null, "Danh S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DanhSach.setBounds(10, 163, 1149, 573);
		getContentPane().add(panel_DanhSach);
		panel_DanhSach.setLayout(null);

		JScrollPane scrollPane_Table = new JScrollPane();
		scrollPane_Table.setBounds(8, 22, 1131, 541);
		panel_DanhSach.add(scrollPane_Table);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				LienChi lc = lienchiList.get(index);
				showText(lc);
			}
		});
		scrollPane_Table.setViewportView(table);

		buttom_Them = new JButton("Thêm\r\n");
		buttom_Them.setForeground(new Color(255, 255, 255));
		buttom_Them.setIcon(new ImageIcon(QLLienChiDoan.class.getResource("/buttonImages/insert.png")));
		buttom_Them.setBounds(1013, 17, 146, 43);
		getContentPane().add(buttom_Them);
		buttom_Them.setBackground(new Color(65, 49, 102));
		buttom_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelVisible_false();

				if (standardInput() == true) {
					LienChi lienchi = setLienChi();
					if (LienChiDoan_modify.exists.containsKey(lienchi.getMaLienChi())) {
						JOptionPane.showMessageDialog(null, "Liên Chi Đã Tồn Tại !");
					} else {
						LienChiDoan_modify.insert(lienchi);
						showLienChi(LienChiDoan_modify.findAll());
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
					}

				}
			}
		});
		buttom_Them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttom_Sua = new JButton("Sửa");
		buttom_Sua.setForeground(new Color(255, 255, 255));
		buttom_Sua.setIcon(new ImageIcon(QLLienChiDoan.class.getResource("/buttonImages/edit.png")));
		buttom_Sua.setBounds(1013, 102, 146, 48);
		getContentPane().add(buttom_Sua);
		buttom_Sua.setBackground(new Color(65, 49, 102));
		buttom_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelVisible_false();
				int index = table.getSelectedRow();
				if (lienchiList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput()) {
						LienChi lienchi = setLienChi();
						LienChi lc = lienchiList.get(index);
						if (!String.valueOf(lienchi.getMaLienChi())
								.equalsIgnoreCase(String.valueOf(lc.getMaLienChi()))) {
							JOptionPane.showMessageDialog(null, "Không thể sửa mã liên chi đoàn");
						} else {
							LienChiDoan_modify.update(lienchi);
							showLienChi(LienChiDoan_modify.findAll());
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}
					}

				}

			}
		});
		buttom_Sua.setFont(new Font("Tahoma", Font.PLAIN, 20));

		/*
		 * 
		 * ___________________________________________-Them
		 * _________________________________________________-
		 */
		/*
		 * 
		 * _______________________________________________________Sua______________________________________________________/
		 */

		if (ktCot == 0) {
			addColumn();
		}
		showLienChi(LienChiDoan_modify.findAll());
		setLabelVisible_false();
		isPermission();

	}

	private void addColumn() {
		ktCot = 1;
		model.addColumn("Ma Lien Chi");
		model.addColumn("Ten Lien Chi");
		model.addColumn("Thong Tin BCH");
	}

	private static void showLienChi(List<LienChi> lienChiL) {
		lienchiList = lienChiL;
		model.setRowCount(0);
		for (LienChi lc : lienchiList) {
			model.addRow(new Object[] { lc.getMaLienChi(), lc.getTenLienChi(), lc.getThongTinBCH() });
		}
		table.setModel(model);
	}

	///////////////////////////////////////////////////////////
	private void reset() {
		MaLienChiDoan.setText("");
		TenLienChiDoan.setText("");
		ThongTinBCH.setText("");
	}

	private void showText(LienChi lienchi) {
		MaLienChiDoan.setText(String.valueOf(lienchi.getMaLienChi()));
		TenLienChiDoan.setText(lienchi.getTenLienChi());
		ThongTinBCH.setText(lienchi.getThongTinBCH());
	}

	private LienChi setLienChi() {
		LienChi lienchi = new LienChi();
		lienchi.setMaLienChi(Integer.valueOf(MaLienChiDoan.getText()));
		lienchi.setTenLienChi(TenLienChiDoan.getText().toUpperCase());
		lienchi.setThongTinBCH(ThongTinBCH.getText());
		return lienchi;
	}

	private boolean standardInput() {

		if (!TenLienChiDoan.getText().equals("") && !MaLienChiDoan.getText().equals("")
				&& !ThongTinBCH.getText().equals("")) {
			if (StandardInput.isNumber(MaLienChiDoan.getText()) == true) {
				return true;
			} else {
				lblMaLienChi.setVisible(true);
				JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đúng!");
				return false;
			}
		} else {
			if (TenLienChiDoan.getText().equals("")) {
				lblTenLienChi.setVisible(true);
			}

			if (MaLienChiDoan.getText().equals("")) {
				lblMaLienChi.setVisible(true);
			} else {
				if (StandardInput.isNumber(MaLienChiDoan.getText()) == false) {
					lblMaLienChi.setVisible(true);
				}
			}

			if (ThongTinBCH.getText().equals("")) {
				lblThongTinBCH.setVisible(true);
			}
			JOptionPane.showMessageDialog(null, "Thông Tin Chưa Đủ!");
			return false;
		}
	}

	private void setLabelVisible_false() {
		lblTenLienChi.setVisible(false);
		lblMaLienChi.setVisible(false);
		lblThongTinBCH.setVisible(false);
	}
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			buttom_Them.setVisible(false);
			buttom_Sua.setVisible(false);
		}
	}
	
}
