package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modify_object.DanhGiaRLSVModify;
import modify_object.GiangVien_modify;
import object_frame.GiangVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TimKiemGiangVien extends JFrame {

	private static final String key = null;
	private JPanel contentPane;
	private static JTextField textField_HoTenGV;
	private static JTextField textField_Khoa;
	private static JTextField textField_BoMon;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemGiangVien frame = new TimKiemGiangVien();
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
	public TimKiemGiangVien() {
		setTitle("T\u00ECm Ki\u1EBFm Gi\u1EA3ng Vi\u00EAn ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 270);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ Tên Giảng Viên");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(40, 22, 121, 25);
		contentPane.add(lblNewLabel);
		
		textField_HoTenGV = new JTextField();
		textField_HoTenGV.setBackground(new Color(245, 245, 245));
		textField_HoTenGV.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField_HoTenGV.setBounds(171, 22, 212, 25);
		contentPane.add(textField_HoTenGV);
		textField_HoTenGV.setColumns(10);
		
		JLabel lblKhoa = new JLabel("Khoa");
		lblKhoa.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblKhoa.setBounds(40, 72, 32, 25);
		contentPane.add(lblKhoa);
		
		JLabel lblBMn = new JLabel("B\u1ED9 M\u00F4n");
		lblBMn.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblBMn.setBounds(40, 123, 54, 25);
		contentPane.add(lblBMn);
		
		JButton btnNewButton = new JButton("T\u00ECm Ki\u1EBFm");
		btnNewButton.setIcon(new ImageIcon(TimKiemGiangVien.class.getResource("/buttonImages/search.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65,49,102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GiangVien_modify.search(textField_HoTenGV.getText(), textField_Khoa.getText(),textField_BoMon.getText() ).size()==0)
				JOptionPane.showMessageDialog(null, "Không tìm thấy đối tượng !");
				else
				{
					QLGiangVien.GVList= GiangVien_modify.search(textField_HoTenGV.getText(), textField_Khoa.getText(),textField_BoMon.getText());
					QLGiangVien.showGiangVien(QLGiangVien.GVList);
					JOptionPane.showMessageDialog(null, "Tìm Kiếm Thành Công !");
				}
			
			}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 173, 129, 33);
		contentPane.add(btnNewButton);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setIcon(new ImageIcon(TimKiemGiangVien.class.getResource("/buttonImages/thoat.png")));
		btnThot.setForeground(new Color(255, 255, 255));
		btnThot.setBackground(new Color(65,49,102));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThot.setBounds(288, 173, 121, 33);
		contentPane.add(btnThot);
		
		JButton btnLmMi = new JButton("L\u00E0m M\u1EDBi");
		btnLmMi.setIcon(new ImageIcon(TimKiemGiangVien.class.getResource("/buttonImages/refresh.png")));
		btnLmMi.setForeground(new Color(255, 255, 255));
		btnLmMi.setBackground(new Color(65,49,102));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLmMi.setBounds(149, 173, 129, 33);
		contentPane.add(btnLmMi);
		
		textField_Khoa = new JTextField();
		textField_Khoa.setBackground(new Color(245, 245, 245));
		textField_Khoa.setBounds(171, 70, 212, 25);
		contentPane.add(textField_Khoa);
		textField_Khoa.setColumns(10);
		
		textField_BoMon = new JTextField();
		textField_BoMon.setBackground(new Color(245, 245, 245));
		textField_BoMon.setBounds(171, 121, 212, 25);
		contentPane.add(textField_BoMon);
		textField_BoMon.setColumns(10);
		
	}

	
	
	
	private static void reset()
	{
		textField_HoTenGV.setText("");
		textField_Khoa.setText("");
		textField_BoMon.setText("");		
		

	}
}
