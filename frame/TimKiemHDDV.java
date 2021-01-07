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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modify_object.HoatDongDoanVienModify;
import object_frame.HoatDongDoanVien;
import javax.swing.ImageIcon;

public class TimKiemHDDV extends JFrame {

	private JPanel contentPane;
	private JLabel lblMaHD;
	private JLabel lblMSV;
	private JButton btnLamMoi;
	/*
	 * 
	 */
	public List<HoatDongDoanVien> std = new ArrayList<HoatDongDoanVien>();
	private JTextField txtMaSV;
	private JTextField txtHoatDong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemHDDV frame = new TimKiemHDDV();
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
	public TimKiemHDDV() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMSV = new JLabel("Mã Sinh Viên");
		lblMSV.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblMSV.setBounds(35, 44, 118, 31);
		contentPane.add(lblMSV);

		lblMaHD = new JLabel("Mã Hoạt Động");
		lblMaHD.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblMaHD.setBounds(35, 101, 118, 31);
		contentPane.add(lblMaHD);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemHDDV.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLDoanVienHD.showHDDV(std);
			}
		});
		btnTimKiem.setBounds(35, 163, 145, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemHDDV.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThoat.setBounds(111, 234, 139, 47);
		contentPane.add(btnThoat);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemHDDV.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDoanVienHD.showHDDV(HoatDongDoanVienModify.findAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(190, 163, 148, 47);
		contentPane.add(btnLamMoi);

		txtMaSV = new JTextField();
		txtMaSV.setBackground(new Color(245, 245, 245));
		txtMaSV.setBounds(163, 46, 175, 26);
		contentPane.add(txtMaSV);
		txtMaSV.setColumns(10);

		txtHoatDong = new JTextField();
		txtHoatDong.setBackground(new Color(245, 245, 245));
		txtHoatDong.setColumns(10);
		txtHoatDong.setBounds(163, 106, 175, 26);
		contentPane.add(txtHoatDong);
	}

	private void find() {
		if (!txtMaSV.getText().equals("") && txtHoatDong.getText().equals("")) {
			std = HoatDongDoanVienModify.search(txtMaSV.getText(), "");
		} else if (txtMaSV.getText().equals("") && !txtHoatDong.getText().equals("")) {
			std = HoatDongDoanVienModify.search("", txtHoatDong.getText());
		} else if (!txtMaSV.getText().equals("") && !txtHoatDong.getText().equals("")) {
			std = HoatDongDoanVienModify.search(txtMaSV.getText(), txtHoatDong.getText());
		}else {
			std = HoatDongDoanVienModify.findAll();
		}
	}

	private void reset() {
		txtMaSV.setText("");
		txtHoatDong.setText("");
	}
}
