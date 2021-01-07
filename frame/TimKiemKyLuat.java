package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import frame.QLKyLuat;
import modify_object.KyLuatModify;
import object_frame.*;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class TimKiemKyLuat extends JFrame {

	private JPanel contentPane;
	
	public static Map<String, String> MaDV = new HashMap<String, String>();
	public List<KyLuat> std = new ArrayList<KyLuat>();


	private JTextField MaDoanVien;
	private JTextField NgayKyLuat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemDoanVien frame = new TimKiemDoanVien();
					frame.setVisible(true);
					frame.setUndecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimKiemKyLuat() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			

		


		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemKyLuat.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLKyLuat.showKyLuat(std);
			
			}
		});
		btnTimKiem.setBounds(35, 165, 139, 47);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemKyLuat.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(114, 238, 139, 47);
		contentPane.add(btnThoat);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemKyLuat.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLKyLuat.showKyLuat(KyLuatModify.fillAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(196, 165, 140, 47);
		contentPane.add(btnLamMoi);
		
		JLabel lblMaDoanVien = new JLabel("Mã Đoàn Viên");
		lblMaDoanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaDoanVien.setBounds(35, 35, 111, 26);
		contentPane.add(lblMaDoanVien);
		
		MaDoanVien = new JTextField();
		MaDoanVien.setBackground(new Color(245, 245, 245));
		MaDoanVien.setBounds(156, 33, 180, 26);
		contentPane.add(MaDoanVien);
		MaDoanVien.setColumns(10);
		
		JLabel lblNgayKyLuat = new JLabel("Ngày Kỷ Luật");
		lblNgayKyLuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayKyLuat.setBounds(35, 93, 111, 26);
		contentPane.add(lblNgayKyLuat);
		
		NgayKyLuat = new JTextField();
		NgayKyLuat.setBackground(new Color(245, 245, 245));
		NgayKyLuat.setColumns(10);
		NgayKyLuat.setBounds(156, 91, 180, 26);
		contentPane.add(NgayKyLuat);
		
		
	}


	
	private void find()
	{
		
		if (!MaDoanVien.getText().equals("") && NgayKyLuat.getText().equals("")) {
			std=KyLuatModify.search(MaDoanVien.getText(), "");
			
		}
		else if (MaDoanVien.getText().equals("") && !NgayKyLuat.getText().equals("")) {
			
			std=KyLuatModify.search("", NgayKyLuat.getText());
		}
		
		else if (!MaDoanVien.getText().equals("") && !NgayKyLuat.getText().equals("")) {

			std=KyLuatModify.search(MaDoanVien.getText(), NgayKyLuat.getText());
		}
		else {
			std=KyLuatModify.fillAll();
		}

	}
	
	private void reset() {
		MaDoanVien.setText("");
		NgayKyLuat.setText("");
	}
}
