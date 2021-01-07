package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import check_data.StandardCmpGiangVien;
import modify_object.GiangVien_modify;

import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class SapXepGiangVien extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox CheckBox_Khoa;
	private JCheckBox CheckBox_BoMon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepGiangVien frame = new SapXepGiangVien();
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
	public SapXepGiangVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 343);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 414, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 10, 394, 69);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
				CheckBox_BoMon = new JCheckBox("M\u00F4n H\u1ECDc \r\n");
				CheckBox_BoMon.setBounds(276, 24, 97, 23);
				panel_2.add(CheckBox_BoMon);
				CheckBox_BoMon.setInheritsPopupMenu(true);
				CheckBox_BoMon.setIgnoreRepaint(true);
				CheckBox_BoMon.setOpaque(false);
				CheckBox_BoMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
						CheckBox_Khoa = new JCheckBox("Khoa");
						CheckBox_Khoa.setBackground(new Color(255, 255, 255));
						CheckBox_Khoa.setBounds(28, 24, 97, 23);
						panel_2.add(CheckBox_Khoa);
						CheckBox_Khoa.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 204, 394, 73);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("S\u1EAFp X\u1EBFp");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(SapXepGiangVien.class.getResource("/buttonImages/sort.png")));
		btnNewButton.setBackground(new Color(65,49,102));
		btnNewButton.setBounds(24, 18, 151, 38);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortGV();
				// dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setForeground(new Color(255, 255, 255));
		btnThot.setIcon(new ImageIcon(SapXepGiangVien.class.getResource("/buttonImages/thoat.png")));
		btnThot.setBackground(new Color(65,49,102));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(229, 18, 144, 38);
		panel_3.add(btnThot);
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				panel.setBounds(10, 89, 394, 105);
				panel_1.add(panel);
				panel.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setLayout(null);
				
						JLabel lblNewLabel_1 = new JLabel("H\u1ECD & T\u00EAn Gi\u1EA3ng Vi\u00EAn");
						lblNewLabel_1.setBounds(30, 37, 183, 43);
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
						
								JRadioButton RadioButton_AZ = new JRadioButton("A->Z", true);
								RadioButton_AZ.setBackground(new Color(255, 255, 255));
								buttonGroup.add(RadioButton_AZ);
								RadioButton_AZ.setBounds(271, 22, 109, 23);
								panel.add(RadioButton_AZ);
								RadioButton_AZ.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
										JRadioButton rdbtnZA = new JRadioButton("Z->A");
										rdbtnZA.setBackground(new Color(255, 255, 255));
										buttonGroup.add(rdbtnZA);
										rdbtnZA.setBounds(271, 75, 109, 23);
										panel.add(rdbtnZA);
										rdbtnZA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}

	private int chooseJradio() {
		int x = 0;
		Enumeration<AbstractButton> abs = buttonGroup.getElements();
		while (abs.hasMoreElements()) {
			JRadioButton JR = (JRadioButton) abs.nextElement();
			if (JR.isSelected()) {
				if (JR.getText().equalsIgnoreCase("A->Z"))
					x = 1;

				else if (JR.getText().equalsIgnoreCase("Z->A"))
					x = -1;
			}
		}
		return x;
	}

	/// sap xep
	private void sortGV() {
		if (chooseJradio() == 1) {
			if (CheckBox_Khoa.isSelected() && CheckBox_BoMon.isSelected()) {

				System.out.println("h");

				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenAZ_Khoa_BoMon);

				QLGiangVien.showGiangVien(QLGiangVien.GVList);

			} else if (CheckBox_Khoa.isSelected()) {
				System.out.println("f");
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenAZ_Khoa);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			} else if (CheckBox_BoMon.isSelected()) {
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenAZ_BoMon);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			}

			else {
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenAZ);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			}

		}

		else {
			if (CheckBox_Khoa.isSelected() && CheckBox_BoMon.isSelected()) {

				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenZA_Khoa_BoMon);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			} else if (CheckBox_Khoa.isSelected()) {
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenZA_Khoa);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			} else if (CheckBox_BoMon.isSelected()) {
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenZA_BoMon);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			}

			else {
				Collections.sort(QLGiangVien.GVList, StandardCmpGiangVien.TenZA);
				QLGiangVien.showGiangVien(QLGiangVien.GVList);
			}

		}

	}

}
