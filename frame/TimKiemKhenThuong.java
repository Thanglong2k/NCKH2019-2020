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

import modify_object.KhenThuongModify;
import object_frame.KhenThuong;
import javax.swing.ImageIcon;

public class TimKiemKhenThuong extends JFrame {

	private JPanel contentPane;
	
	public static Map<String, String> MaDV = new HashMap<String, String>();
	public List<KhenThuong> std = new ArrayList<KhenThuong>();


	private JTextField MaDoanVien;
	private JTextField NgayKhenThuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemDoanVien frame = new TimKiemDoanVien();
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
	public TimKiemKhenThuong() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			

		


		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemKhenThuong.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLKhenThuong.showKhenThuong(std);
			
			}
		});
		btnTimKiem.setBounds(35, 157, 139, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemKhenThuong.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(114, 230, 139, 47);
		contentPane.add(btnThoat);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemKhenThuong.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLKhenThuong.showKhenThuong(KhenThuongModify.fillAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(196, 157, 140, 47);
		contentPane.add(btnLamMoi);
		
		JLabel lblMaDoanVien = new JLabel("Mã Đoàn Viên");
		lblMaDoanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaDoanVien.setBounds(35, 37, 111, 26);
		contentPane.add(lblMaDoanVien);
		
		MaDoanVien = new JTextField();
		MaDoanVien.setBackground(new Color(245, 245, 245));
		MaDoanVien.setBounds(156, 35, 180, 26);
		contentPane.add(MaDoanVien);
		MaDoanVien.setColumns(10);
		
		JLabel lblNgayKhenThuong = new JLabel("Ngày Khen Thưởng");
		lblNgayKhenThuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayKhenThuong.setBounds(35, 95, 111, 26);
		contentPane.add(lblNgayKhenThuong);
		
		NgayKhenThuong = new JTextField();
		NgayKhenThuong.setBackground(new Color(245, 245, 245));
		NgayKhenThuong.setColumns(10);
		NgayKhenThuong.setBounds(156, 93, 180, 26);
		contentPane.add(NgayKhenThuong);
		
		
	}


	
	private void find()
	{
		
		if (!MaDoanVien.getText().equals("") && NgayKhenThuong.getText().equals("")) {
			std=KhenThuongModify.search(MaDoanVien.getText(), "");
			
		}
		else if (MaDoanVien.getText().equals("") && !NgayKhenThuong.getText().equals("")) {
			
			std=KhenThuongModify.search("", NgayKhenThuong.getText());
		}
		
		else if (!MaDoanVien.getText().equals("") && !NgayKhenThuong.getText().equals("")) {

			std=KhenThuongModify.search(MaDoanVien.getText(), NgayKhenThuong.getText());
		}
		else {
			std=KhenThuongModify.fillAll();
		}

	}
	
	private void reset() {
		MaDoanVien.setText("");
		NgayKhenThuong.setText("");
	}
}
