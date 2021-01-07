package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import check_data.StandardCmpChiDoan;
import javax.swing.SwingConstants;

public class SapXepChiDoan extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Map<String, Integer> lienchiMap = new HashMap<String, Integer>();
	private JCheckBox CheckBoxMLC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepChiDoan frame = new SapXepChiDoan();
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
	public SapXepChiDoan() {
		setTitle("S\u1EAFp  X\u1EBFp Chi \u0110o\u00E0n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(65,49,102));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 482, 81);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("S\u1EAFp X\u1EBFp Chi \u0110o\u00E0n ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 10, 199, 59);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 103, 492, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("S\u1EAFp X\u1EBFp ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(65,49,102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortCD();
				dispose();
			}
		});
		btnNewButton.setBounds(10, 123, 140, 31);
		panel_1.add(btnNewButton);

		JButton btnThot = new JButton("Tho\u00E1t ");
		btnThot.setForeground(new Color(255, 255, 255));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBackground(new Color(65,49,102));
		btnThot.setBounds(342, 123, 140, 31);
		panel_1.add(btnThot);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 245));
		panel_2.setBounds(10, 10, 472, 102);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tăng Dần", true);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(347, 19, 109, 23);
		panel_2.add(rdbtnNewRadioButton);

		JRadioButton rdbtnTenZa = new JRadioButton("Giảm Dần");
		rdbtnTenZa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTenZa.setToolTipText("");
		buttonGroup.add(rdbtnTenZa);
		rdbtnTenZa.setBounds(347, 72, 109, 23);
		panel_2.add(rdbtnTenZa);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn Chi \u0110o\u00E0n ");
		lblNewLabel_1.setBounds(32, 67, 184, 31);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
				CheckBoxMLC = new JCheckBox("Mã Liên Chi Đoàn");
				CheckBoxMLC.setBounds(26, 10, 190, 39);
				panel_2.add(CheckBoxMLC);
				CheckBoxMLC.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}

	// __________________________________ set data cho comboBoxLC (lien
	// chi)___________________________\\

	private int chooseJradio() {
		int x = 0;
		Enumeration<AbstractButton> abs = buttonGroup.getElements();
		while (abs.hasMoreElements()) {
			JRadioButton JR = (JRadioButton) abs.nextElement();
			if (JR.isSelected()) {
				if (JR.getText().equalsIgnoreCase("Ten A->Z"))
					x = 1;

				else
					x = -1;
			}
		}
		return x;
	}

	private void sortCD() {
		if (chooseJradio() == 1) {
			if (!CheckBoxMLC.isSelected()) {

				Collections.sort(QLChiDoan.chidoanList, StandardCmpChiDoan.TenAZ);
				QLChiDoan.showChiDoan(QLChiDoan.chidoanList);
			} else {
				Collections.sort(QLChiDoan.chidoanList, StandardCmpChiDoan.TenAZ_LienChi);
				QLChiDoan.showChiDoan(QLChiDoan.chidoanList);
			}
		}

		else {

			if (!CheckBoxMLC.isSelected()) {

				Collections.sort(QLChiDoan.chidoanList, StandardCmpChiDoan.TenZA);
				QLChiDoan.showChiDoan(QLChiDoan.chidoanList);
			} else {
				Collections.sort(QLChiDoan.chidoanList, StandardCmpChiDoan.TenZA_LienChi);
				QLChiDoan.showChiDoan(QLChiDoan.chidoanList);
			}
		}

	}
}
