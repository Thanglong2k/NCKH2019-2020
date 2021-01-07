package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import check_data.StandardInput;
import modify_object.ChiDoan_modify;
import modify_object.LienChiDoan_modify;
import object_frame.ChiDoan;
import object_frame.LienChi;

public class TimKiemChiDoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_TenChiDoan;
	private JTextField textField_MaChiDoan;
	private JComboBox comboBox_LC;
	Map<String, Integer> Mlienchi = new HashMap<String, Integer>();
	List<ChiDoan> chidoan = new ArrayList<ChiDoan>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemChiDoan frame = new TimKiemChiDoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimKiemChiDoan() {
		setTitle("T\u00ECm Ki\u1EBFm Th\u00F4ng Tin Chi \u0110aon");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 96, 408, 291);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn Chi \u0110o\u00E0n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 98, 38);
		panel.add(lblNewLabel_1);

		textField_TenChiDoan = new JTextField();
		textField_TenChiDoan.setBackground(new Color(245, 245, 245));
		textField_TenChiDoan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_TenChiDoan.setBounds(107, 11, 268, 32);
		panel.add(textField_TenChiDoan);
		textField_TenChiDoan.setColumns(10);

		JLabel lblMChion = new JLabel("M\u00E3 Chi \u0110o\u00E0n");
		lblMChion.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblMChion.setBounds(10, 68, 98, 38);
		panel.add(lblMChion);

		JLabel lblKhoa = new JLabel("Liên Chi");
		lblKhoa.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblKhoa.setBounds(10, 132, 87, 38);
		panel.add(lblKhoa);

		textField_MaChiDoan = new JTextField();
		textField_MaChiDoan.setBackground(new Color(245, 245, 245));
		textField_MaChiDoan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_MaChiDoan.setColumns(10);
		textField_MaChiDoan.setBounds(107, 72, 268, 32);
		panel.add(textField_MaChiDoan);

		comboBox_LC = new JComboBox();
		comboBox_LC.addItem("(_- )");
		comboBox_LC.setBackground(new Color(245, 245, 245));
		comboBox_LC.setBounds(107, 132, 268, 32);
		panel.add(comboBox_LC);

		JButton btnNewButton = new JButton("T\u00ECm Ki\u1EBFm");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65,49,102));
		btnNewButton.addActionListener(e -> {
			find();
			QLChiDoan.showChiDoan(chidoan);
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 217, 110, 38);
		panel.add(btnNewButton);

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setForeground(new Color(255, 255, 255));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBackground(new Color(65,49,102));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThot.setBounds(290, 217, 110, 38);
		panel.add(btnThot);

		JButton btnReset = new JButton("Làm Mới");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(65,49,102));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLChiDoan.showChiDoan(ChiDoan_modify.findAll());
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(153, 217, 110, 38);
		panel.add(btnReset);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65,49,102));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 408, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm Kiếm Thông Tin Chi Đoàn");
		lblNewLabel.setBounds(44, 24, 331, 25);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		setcomboBox();
	}

	private void reset() {
		comboBox_LC.setSelectedIndex(0);
		textField_MaChiDoan.setText("");
		textField_TenChiDoan.setText("");

	}

	private void setcomboBox() {
		for (LienChi x : LienChiDoan_modify.findAll()) {
			Mlienchi.put(x.getTenLienChi(), x.getMaLienChi());
		}
		for (String key : Mlienchi.keySet()) {
			comboBox_LC.addItem(key);
		}

	}

	private void find() {
		if (!textField_MaChiDoan.getText().equals("") && StandardInput.isNumber(textField_MaChiDoan.getText())==false) {
			chidoan = null;
			return;
		}

		if (!textField_MaChiDoan.getText().equals("") && textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() == 0) {
			chidoan = ChiDoan_modify.search(textField_MaChiDoan.getText(), "", "0");

		} else if (textField_MaChiDoan.getText().equals("") && !textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() == 0) {

			chidoan = ChiDoan_modify.search("", textField_TenChiDoan.getText(), "0");
		} else if (textField_MaChiDoan.getText().equals("") && textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() != 0) {

			String tenlcd = comboBox_LC.getSelectedItem().toString();
			for (String key : Mlienchi.keySet()) {
				if (tenlcd.equalsIgnoreCase(key)) {
					int id = Mlienchi.get(key);

					chidoan = ChiDoan_modify.search("", "", String.valueOf(id));
				}
			}
		} else if (!textField_MaChiDoan.getText().equals("") && !textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() == 0) {
			chidoan = ChiDoan_modify.search(textField_MaChiDoan.getText(), textField_TenChiDoan.getText(), "0");
		} else if (!textField_MaChiDoan.getText().equals("") && textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() != 0) {

			String tenlcd = comboBox_LC.getSelectedItem().toString();
			for (String key : Mlienchi.keySet()) {
				if (tenlcd.equalsIgnoreCase(key)) {
					int id = Mlienchi.get(key);
					chidoan = ChiDoan_modify.search(textField_MaChiDoan.getText(), "", String.valueOf(id));
				}
			}
		}

		else if (textField_MaChiDoan.getText().equals("") && !textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() != 0) {

			String tenlcd = comboBox_LC.getSelectedItem().toString();
			for (String key : Mlienchi.keySet()) {
				if (tenlcd.equalsIgnoreCase(key)) {
					int id = Mlienchi.get(key);
					chidoan = ChiDoan_modify.search("", textField_TenChiDoan.getText(), String.valueOf(id));
				}
			}
		}

		else if (!textField_MaChiDoan.getText().equals("") && !textField_TenChiDoan.getText().equals("")
				&& comboBox_LC.getSelectedIndex() != 0) {

			String tenlcd = comboBox_LC.getSelectedItem().toString();
			for (String key : Mlienchi.keySet()) {
				if (tenlcd.equalsIgnoreCase(key)) {
					int id = Mlienchi.get(key);
			chidoan = ChiDoan_modify.search(textField_MaChiDoan.getText(), textField_TenChiDoan.getText(),
							String.valueOf(id));
				}
			}
		} else {
			chidoan = ChiDoan_modify.findAll();
		}

	}

}
