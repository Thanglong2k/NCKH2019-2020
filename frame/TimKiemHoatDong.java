package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modify_object.HoatDongModify;
import object_frame.HoatDong;
import javax.swing.ImageIcon;

public class TimKiemHoatDong extends JFrame {

	private JPanel contentPane;
	private JTextField MaHoatDong;
	private JTextField TenHoatDong;
	private JLabel lblTenHoatDong;
	private JLabel lblMaHoatDong;

	public List<HoatDong> std = new ArrayList<HoatDong>();
	private JButton btnLamMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemHoatDong frame = new TimKiemHoatDong();
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
	public TimKiemHoatDong() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaHoatDong = new JTextField();
		MaHoatDong.setBackground(new Color(245, 245, 245));
		MaHoatDong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MaHoatDong.setBounds(163, 41, 175, 26);
		contentPane.add(MaHoatDong);
		MaHoatDong.setColumns(10);

		lblMaHoatDong = new JLabel("Mã Hoạt Động");
		lblMaHoatDong.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblMaHoatDong.setBounds(35, 41, 118, 31);
		contentPane.add(lblMaHoatDong);

		TenHoatDong = new JTextField();
		TenHoatDong.setBackground(new Color(245, 245, 245));
		TenHoatDong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TenHoatDong.setBounds(163, 101, 175, 26);
		contentPane.add(TenHoatDong);
		TenHoatDong.setColumns(10);

		lblTenHoatDong = new JLabel("Tên Hoạt Động");
		lblTenHoatDong.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTenHoatDong.setBounds(35, 101, 118, 31);
		contentPane.add(lblTenHoatDong);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemHoatDong.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLHoatDong.showHoatDong(std);
			}
		});
		btnTimKiem.setBounds(35, 163, 146, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemHoatDong.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnThoat.setBounds(111, 234, 139, 47);
		contentPane.add(btnThoat);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemHoatDong.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLHoatDong.showHoatDong(HoatDongModify.findAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(199, 163, 139, 47);
		contentPane.add(btnLamMoi);

	}

	private void find() {
		if (!MaHoatDong.getText().equals("") && TenHoatDong.getText().equals("")) {
			std = HoatDongModify.search(MaHoatDong.getText(), "");
		} else if (MaHoatDong.getText().equals("") && !TenHoatDong.getText().equals("")) {
			std = HoatDongModify.search("", TenHoatDong.getText());
		} else if (!MaHoatDong.getText().equals("") && !TenHoatDong.getText().equals("")) {
			std = HoatDongModify.search(MaHoatDong.getText(), TenHoatDong.getText());
		} else {
			std = HoatDongModify.findAll();
		}
	}

	private void reset() {
		MaHoatDong.setText("");
		TenHoatDong.setText("");
	}
}
