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

import modify_object.DanhGiaRLSVModify;
import object_frame.DanhGiaRLSV;
import javax.swing.ImageIcon;

public class TimKiemRLSV extends JFrame {

	private JPanel contentPane;
	private JTextField MaDanhGia;
	private JTextField NamHoc;
	private JLabel lblTnonVin;
	private JLabel lblNewLabel;

	public List<DanhGiaRLSV> std = new ArrayList<DanhGiaRLSV>();
	private JButton btnLamMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemRLSV frame = new TimKiemRLSV();
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
	public TimKiemRLSV() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 314);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaDanhGia = new JTextField();
		MaDanhGia.setBackground(new Color(245, 245, 245));
		MaDanhGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MaDanhGia.setBounds(161, 47, 175, 28);
		contentPane.add(MaDanhGia);
		MaDanhGia.setColumns(10);

		lblNewLabel = new JLabel("Mã Đánh Giá");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 45, 118, 31);
		contentPane.add(lblNewLabel);

		NamHoc = new JTextField();
		NamHoc.setBackground(new Color(245, 245, 245));
		NamHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NamHoc.setBounds(161, 89, 175, 28);
		contentPane.add(NamHoc);
		NamHoc.setColumns(10);

		lblTnonVin = new JLabel("Năm Học");
		lblTnonVin.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTnonVin.setBounds(35, 86, 118, 31);
		contentPane.add(lblTnonVin);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemRLSV.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLDanhGiaRLSV.showRLSV(std);
			}
		});
		btnTimKiem.setBounds(35, 150, 140, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemRLSV.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(119, 207, 139, 47);
		contentPane.add(btnThoat);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemRLSV.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDanhGiaRLSV.showRLSV(DanhGiaRLSVModify.findAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(196, 150, 140, 47);
		contentPane.add(btnLamMoi);
	}

	private void find() {
		if (!MaDanhGia.getText().equals("") && NamHoc.getText().equals("")) {
			std = DanhGiaRLSVModify.search(MaDanhGia.getText(), "");
		} else if (MaDanhGia.getText().equals("") && !NamHoc.getText().equals("")) {
			std = DanhGiaRLSVModify.search("", NamHoc.getText());
		} else if (!MaDanhGia.getText().equals("") && !NamHoc.getText().equals("")) {
			std = DanhGiaRLSVModify.search(MaDanhGia.getText(), NamHoc.getText());
		} else {
			std = DanhGiaRLSVModify.findAll();
		}
	}

	private void reset() {
		MaDanhGia.setText("");
		NamHoc.setText("");
	}
}
