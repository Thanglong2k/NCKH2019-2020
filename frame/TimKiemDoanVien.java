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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modify_object.ChiDoan_modify;
import modify_object.StudentModify;
import object_frame.ChiDoan;
import object_frame.Student;
import javax.swing.ImageIcon;

public class TimKiemDoanVien extends JFrame {

	private JPanel contentPane;
	private JTextField MaDoanVien;
	private JTextField TenDoanVien;
	private JComboBox TenChiDoan;
	private JLabel lblNewLabel_1;
	private JLabel lblTnonVin;
	private JLabel lblNewLabel;

	Map<String, Integer> Mchidoan = new HashMap<String, Integer>();
	public List<Student> std = new ArrayList<Student>();
	private JButton btnLamMoi;

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
	public TimKiemDoanVien() {
		setTitle("Tìm Kiếm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 314);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaDoanVien = new JTextField();
		MaDoanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MaDoanVien.setBounds(165, 46, 175, 21);
		contentPane.add(MaDoanVien);
		MaDoanVien.setColumns(10);

		lblNewLabel = new JLabel("Mã Đoàn Viên");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel.setBounds(39, 41, 118, 31);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Tên Chi Đoàn");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(39, 123, 118, 31);
		contentPane.add(lblNewLabel_1);

		TenChiDoan = new JComboBox();
		TenChiDoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TenChiDoan.addItem("(Chọn Tên)");
		TenChiDoan.setBackground(Color.WHITE);
		TenChiDoan.setBounds(165, 127, 175, 21);
		contentPane.add(TenChiDoan);

		TenDoanVien = new JTextField();
		TenDoanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TenDoanVien.setBounds(165, 87, 175, 19);
		contentPane.add(TenDoanVien);
		TenDoanVien.setColumns(10);

		lblTnonVin = new JLabel("Tên Đoàn Viên");
		lblTnonVin.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblTnonVin.setBounds(39, 82, 118, 31);
		contentPane.add(lblTnonVin);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(TimKiemDoanVien.class.getResource("/buttonImages/search.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(65,49,102));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
				QLDoanVien.showStudent(std);
			
			}
		});
		btnTimKiem.setBounds(39, 164, 141, 37);
		contentPane.add(btnTimKiem);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(TimKiemDoanVien.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThoat.setBounds(123, 211, 124, 37);
		contentPane.add(btnThoat);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TimKiemDoanVien.class.getResource("/buttonImages/refresh.png")));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLDoanVien.showStudent(StudentModify.findAll());
				reset();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLamMoi.setBackground(new Color(65,49,102));
		btnLamMoi.setBounds(190, 164, 150, 37);
		contentPane.add(btnLamMoi);
		setcomboBox();
	}

	private void setcomboBox() {
		for (ChiDoan x : ChiDoan_modify.findAll()) {
			Mchidoan.put(x.getTenChiDoan(), x.getMaChiDoan());
		}
		for (String key : Mchidoan.keySet()) {
			TenChiDoan.addItem(key);
		}
		
	}
	
	private void find()
	{
		if (!MaDoanVien.getText().equals("") && TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() == 0) {
			std=StudentModify.search(MaDoanVien.getText(), "0", "");
			
		}
		else if (MaDoanVien.getText().equals("") && !TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() == 0) {
			
			std=StudentModify.search("", "0", TenDoanVien.getText());
		}
		else if (MaDoanVien.getText().equals("") && TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() != 0) {

			String tencd = TenChiDoan.getSelectedItem().toString();
			for (String key : Mchidoan.keySet()) {
				if (tencd.equalsIgnoreCase(key)) {
					int id = Mchidoan.get(key);
					
					std=StudentModify.search("", String.valueOf(id), "");
				}
			}
		}
		else if (!MaDoanVien.getText().equals("") && !TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() == 0) {
			std=StudentModify.search(MaDoanVien.getText(), "0", TenDoanVien.getText());
		}
		else if (!MaDoanVien.getText().equals("") && TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() != 0) {

			String tencd = TenChiDoan.getSelectedItem().toString();
			for (String key : Mchidoan.keySet()) {
				if (tencd.equalsIgnoreCase(key)) {
					int id = Mchidoan.get(key);
					std=StudentModify.search(MaDoanVien.getText(), String.valueOf(id), "");
				}
			}
		}
		
		else if (MaDoanVien.getText().equals("") && !TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() != 0) {

			String tencd = TenChiDoan.getSelectedItem().toString();
			for (String key : Mchidoan.keySet()) {
				if (tencd.equalsIgnoreCase(key)) {
					int id = Mchidoan.get(key);
					std=StudentModify.search("", String.valueOf(id), TenDoanVien.getText());
				}
			}
		}
		
		else if (!MaDoanVien.getText().equals("") && !TenDoanVien.getText().equals("") && TenChiDoan.getSelectedIndex() != 0) {

			String tencd = TenChiDoan.getSelectedItem().toString();
			for (String key : Mchidoan.keySet()) {
				if (tencd.equalsIgnoreCase(key)) {
					int id = Mchidoan.get(key);
					std=StudentModify.search(MaDoanVien.getText(), String.valueOf(id), TenDoanVien.getText());
				}
			}
		}
		else {
			std  = StudentModify.findAll();
		}

	}
	
	private void reset() {
		MaDoanVien.setText("");
		TenDoanVien.setText("");
		TenChiDoan.setSelectedIndex(0);
	}
}
