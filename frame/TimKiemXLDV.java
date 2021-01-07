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

import modify_object.XepLoaiDoanVienModify;
import object_frame.XepLoaiDV;
import javax.swing.ImageIcon;

public class TimKiemXLDV extends JFrame {

	private JPanel contentPane;
	private JTextField MaDanhGia;
	private JTextField MaSinhVien;
	private JLabel lblTnonVin;
	private JLabel lblNewLabel;

	public List<XepLoaiDV> std = new ArrayList<XepLoaiDV>();
	private JButton btnLamMoi;
	private JTextField XepLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemXLDV frame = new TimKiemXLDV();
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
	public TimKiemXLDV() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaDanhGia = new JTextField();
		MaDanhGia.setBackground(new Color(245, 245, 245));
		MaDanhGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MaDanhGia.setBounds(163, 36, 175, 21);
		contentPane.add(MaDanhGia);
		MaDanhGia.setColumns(10);

		lblNewLabel = new JLabel("Mã Đánh Giá");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 34, 118, 31);
		contentPane.add(lblNewLabel);

		MaSinhVien = new JTextField();
		MaSinhVien.setBackground(new Color(245, 245, 245));
		MaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MaSinhVien.setBounds(163, 93, 175, 19);
		contentPane.add(MaSinhVien);
		MaSinhVien.setColumns(10);

		lblTnonVin = new JLabel("Mã Sinh Viên");
		lblTnonVin.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTnonVin.setBounds(35, 90, 118, 31);
		contentPane.add(lblTnonVin);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemXLDV.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLXepLoaiDoanVien.showXLDV(std);
			}
		});
		btnTimKiem.setBounds(34, 205, 140, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemXLDV.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(121, 262, 139, 47);
		contentPane.add(btnThoat);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemXLDV.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLXepLoaiDoanVien.showXLDV(XepLoaiDoanVienModify.findAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(196, 205, 140, 47);
		contentPane.add(btnLamMoi);

		JLabel lblXpLoi = new JLabel("Xếp Loại");
		lblXpLoi.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblXpLoi.setBounds(35, 143, 118, 31);
		contentPane.add(lblXpLoi);

		XepLoai = new JTextField();
		XepLoai.setBackground(new Color(245, 245, 245));
		XepLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		XepLoai.setColumns(10);
		XepLoai.setBounds(161, 148, 175, 19);
		contentPane.add(XepLoai);
	}

	private void find() {
		if (!MaDanhGia.getText().equals("") && MaSinhVien.getText().equals("") && XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search(MaDanhGia.getText(), "", "");
		} else if (MaDanhGia.getText().equals("") && !MaSinhVien.getText().equals("") && XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search("", MaSinhVien.getText(), "");
		} else if (MaDanhGia.getText().equals("") && MaSinhVien.getText().equals("") && !XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search("", "", XepLoai.getText());
		} else if (!MaDanhGia.getText().equals("") && !MaSinhVien.getText().equals("")
				&& XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search(MaDanhGia.getText(), MaSinhVien.getText(), "");
		} else if (!MaDanhGia.getText().equals("") && MaSinhVien.getText().equals("")
				&& !XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search(MaDanhGia.getText(), "", XepLoai.getText());
		} else if (MaDanhGia.getText().equals("") && !MaSinhVien.getText().equals("")
				&& !XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search("", MaSinhVien.getText(), XepLoai.getText());
		} else if (!MaDanhGia.getText().equals("") && !MaSinhVien.getText().equals("")
				&& !XepLoai.getText().equals("")) {
			std = XepLoaiDoanVienModify.search(MaDanhGia.getText(), MaSinhVien.getText(), XepLoai.getText());
		} else {
			std = XepLoaiDoanVienModify.findAll();
		}
	}

	private void reset() {
		MaDanhGia.setText("");
		MaSinhVien.setText("");
		XepLoai.setText("");
	}
}
