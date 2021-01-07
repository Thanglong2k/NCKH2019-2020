package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChonChucVu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JCheckBox chckbxBTLCD;
	private JCheckBox chckbxPBTLCD;
	private JCheckBox chckbxUV_BCH_LCD;
	private JCheckBox chckbxBTCD;
	private JCheckBox chckbxPBTCD;
	private JCheckBox chckbxUV_BCH_CD;
	private JCheckBox chckbxLopTruong;
	private JCheckBox chckbxLopPho;
	private JCheckBox chckbxThanhVien;
	private JButton btnChon;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonChucVu frame = new ChonChucVu();
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
	public ChonChucVu() {
		setTitle("Chức Vụ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 10, 560, 182);
		contentPane.add(panel);
		panel.setLayout(null);
		
		chckbxBTLCD = new JCheckBox("Bí Thư Liên Chi Đoàn");
		chckbxBTLCD.setBackground(Color.WHITE);
		chckbxBTLCD.setBounds(4, 21, 167, 34);
		panel.add(chckbxBTLCD);
		chckbxBTLCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxPBTLCD = new JCheckBox("Phó Bí Thư Liên Chi Đoàn");
		chckbxPBTLCD.setBackground(Color.WHITE);
		chckbxPBTLCD.setBounds(4, 75, 193, 34);
		panel.add(chckbxPBTLCD);
		chckbxPBTLCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxUV_BCH_LCD = new JCheckBox("Ủy Viên BCH Liên Chi Đoàn");
		chckbxUV_BCH_LCD.setBackground(Color.WHITE);
		chckbxUV_BCH_LCD.setBounds(4, 125, 213, 34);
		panel.add(chckbxUV_BCH_LCD);
		chckbxUV_BCH_LCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxBTCD = new JCheckBox("Bí Thư Chi Đoàn");
		chckbxBTCD.setBackground(Color.WHITE);
		chckbxBTCD.setBounds(219, 21, 167, 34);
		panel.add(chckbxBTCD);
		chckbxBTCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxPBTCD = new JCheckBox("Phó Bí Thư Chi Đoàn");
		chckbxPBTCD.setBackground(Color.WHITE);
		chckbxPBTCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPBTCD.setBounds(219, 75, 167, 34);
		panel.add(chckbxPBTCD);
		
		chckbxUV_BCH_CD = new JCheckBox("Ủy Viên BCH Chi Đoàn");
		chckbxUV_BCH_CD.setBackground(Color.WHITE);
		chckbxUV_BCH_CD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxUV_BCH_CD.setBounds(219, 125, 187, 34);
		panel.add(chckbxUV_BCH_CD);
		
		chckbxLopTruong = new JCheckBox("Lớp Trưởng");
		chckbxLopTruong.setBackground(Color.WHITE);
		chckbxLopTruong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLopTruong.setBounds(437, 21, 117, 34);
		panel.add(chckbxLopTruong);
		
		chckbxLopPho = new JCheckBox("Lớp Phó");
		chckbxLopPho.setBackground(Color.WHITE);
		chckbxLopPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLopPho.setBounds(437, 75, 117, 34);
		panel.add(chckbxLopPho);
		
		chckbxThanhVien = new JCheckBox("Thành Viên");
		chckbxThanhVien.setBackground(Color.WHITE);
		chckbxThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxThanhVien.setBounds(437, 125, 117, 34);
		panel.add(chckbxThanhVien);
		
		btnChon = new JButton("Chọn");
		btnChon.setForeground(Color.WHITE);
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resuilt = "";
				for(Component component : panel.getComponents()) {
					JCheckBox jcheckbox = (JCheckBox) component;
					if(jcheckbox.isSelected()) {
						resuilt +=" , "+jcheckbox.getText();
					}
					
				}
				String Arr[]=resuilt.split(",", 2);
				QLDoanVien.setChucVu(Arr[1].trim());
				dispose();
				
				
			}
		});
		btnChon.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnChon.setBackground(new Color(65, 49, 102));
		btnChon.setBounds(346, 216, 107, 37);
		contentPane.add(btnChon);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(65, 49, 102));
		btnThoat.setBounds(461, 216, 107, 37);
		contentPane.add(btnThoat);
	}
}
