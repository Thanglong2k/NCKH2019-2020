package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import check_data.StandardCmpDoanVien;
import object_frame.Student;

public class SapXepDoanVien extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup SXgroupSortby = new ButtonGroup();
	private final ButtonGroup SXgroupThenby = new ButtonGroup();
	private JComboBox ThenBy;
	private JPanel panel_1;
	private JRadioButton rdbTangThenBy;
	private JRadioButton rdbGiamThenBy;
	
	List<Student> std = new ArrayList<Student>();
	private JButton btnSapXep;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepDoanVien frame = new SapXepDoanVien();
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
	public SapXepDoanVien() {
		setTitle("Sắp Xếp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.WHITE);
		panel.setBounds(8, 10, 479, 109);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sort by", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox SortBy = new JComboBox();
		SortBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SortBy.addItem("(Chọn Trường)");
		SortBy.addItem("Tên");
		SortBy.addItem("Ngày Vào Đoàn");
		SortBy.addItem("Điểm Tích Lũy");
		SortBy.setBackground(new Color(255, 255, 255));
		SortBy.setBounds(8, 37, 215, 32);
		panel.add(SortBy);
		
		JRadioButton rdbTangSortBy = new JRadioButton("Tăng Dần",true);
		rdbTangSortBy.setBackground(Color.WHITE);
		rdbTangSortBy.setForeground(Color.BLACK);
		SXgroupSortby.add(rdbTangSortBy);
		rdbTangSortBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbTangSortBy.setBounds(269, 23, 149, 32);
		panel.add(rdbTangSortBy);
		
		JRadioButton rdbGiamSortBy = new JRadioButton("Giảm Dần");
		rdbGiamSortBy.setBackground(Color.WHITE);
		rdbGiamSortBy.setForeground(Color.BLACK);
		SXgroupSortby.add(rdbGiamSortBy);
		rdbGiamSortBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbGiamSortBy.setBounds(269, 57, 149, 32);
		panel.add(rdbGiamSortBy);
		
		panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Then by", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(8, 129, 479, 109);
		contentPane.add(panel_1);
		
		ThenBy = new JComboBox();
		ThenBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ThenBy.addItem("(Chọn Trường)");
		ThenBy.addItem("Tên");
		ThenBy.addItem("Ngày Vào Đoàn");
		ThenBy.addItem("Điểm Tích Lũy");
		ThenBy.setBackground(new Color(255, 255, 255));
		ThenBy.setBounds(8, 37, 215, 32);
		panel_1.add(ThenBy);
		
		rdbTangThenBy = new JRadioButton("Tăng Dần",true);
		rdbTangThenBy.setBackground(Color.WHITE);
		rdbTangThenBy.setForeground(Color.BLACK);
		SXgroupThenby.add(rdbTangThenBy);
		rdbTangThenBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbTangThenBy.setBounds(268, 18, 149, 32);
		panel_1.add(rdbTangThenBy);

		
		rdbGiamThenBy = new JRadioButton("Giảm Dần");
		rdbGiamThenBy.setBackground(Color.WHITE);
		rdbGiamThenBy.setForeground(Color.BLACK);
		SXgroupThenby.add(rdbGiamThenBy);
		rdbGiamThenBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbGiamThenBy.setBounds(268, 60, 149, 32);
		panel_1.add(rdbGiamThenBy);
		
		btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * lẻ 3x2=6 cách Loại
				 * cặp :1-2,3 x4 =8 cách
				 * cặp :2-1,3 x4 =8 cách
				 * cặp :3-1,2 x4 =8 cách
				 * Tổng 24 cách
				 */
				if(SortBy.getSelectedIndex()==ThenBy.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Không chọn trường sắp xếp trùng nhau ");
				}
				else if(SortBy.getSelectedIndex()==0 || ThenBy.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hết đối tượng ");
				}
				else {
					//cả 2 đều tăng
					if(sort(SXgroupSortby)==1 && sort(SXgroupThenby)==1) {
						/*
						 * tên A_Z ngày tăng
						 */
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.TenAZ_NgayTang);
							QLDoanVien.showStudent(std);
						}
						//tên A-Z Diểm tăng
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.TenAZ_DiemTang);
							QLDoanVien.showStudent(std);
						}
						//ngày tăng tên A-Z
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.NgayTang_TenAZ);
							QLDoanVien.showStudent(std);
						}
						//ngày tăng Điểm tăng
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.NgayTang_DiemTang);
							QLDoanVien.showStudent(std);
						}
						//diểm tăng Tên A-Z
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.DiemTang_TenAZ);
							QLDoanVien.showStudent(std);
						}
						//ĐIểm tăng ngày tăng
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.DiemTang_NgayTang);
							QLDoanVien.showStudent(std);
						}
						
					}
					//sort by tăng then by giảm
					else if(sort(SXgroupSortby)==1 && sort(SXgroupThenby)==-1) {
						//tên A-Z ngày giảm
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.TenAZ_NgayGiam);
							QLDoanVien.showStudent(std);
						}
						//tên A-Z Diểm Giảm
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.TenAZ_DiemGiam);
							QLDoanVien.showStudent(std);
						}
						//ngày tăng tên Z-A
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.NgayTang_TenZA);
							QLDoanVien.showStudent(std);
						}
						//ngày tăng Điểm giảm
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.NgayTang_DiemGiam);
							QLDoanVien.showStudent(std);
						}
						//diểm tăng Tên Z-A
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.DiemTang_TenZA);
							QLDoanVien.showStudent(std);
						}
						//ĐIểm tăng ngày Giam
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.DiemTang_NgayGiam);
							QLDoanVien.showStudent(std);
						}
						
					}
					
					//sort by giảm then by tăng
					else if(sort(SXgroupSortby)==-1 && sort(SXgroupThenby)==1) {
						//tên Z-A ngày tăng
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.TenZA_NgayTang);
							QLDoanVien.showStudent(std);
						}
						//tên Z-A Diểm tăng
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.TenZA_DiemTang);
							QLDoanVien.showStudent(std);
						}
						//ngày giảm tên A-Z
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.NgayGiam_TenAZ);
							QLDoanVien.showStudent(std);
						}
						//ngày giảm Điểm tăng
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.NgayGiam_DiemTang);
							QLDoanVien.showStudent(std);
						}
						//diểm giảm Tên A-Z
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.DiemGiam_TenAZ);
							QLDoanVien.showStudent(std);
						}
						//ĐIểm Giảm ngày Tăng
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.DiemGiam_NgayTang);
							QLDoanVien.showStudent(std);
						}
						
					}
					
					//sort by giảm then by giảm
					else if(sort(SXgroupSortby)==-1 && sort(SXgroupThenby)==-1) {
						//tên Z-A ngày giảm
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.TenZA_NgayGiam);
							QLDoanVien.showStudent(std);
						}
						//tên Z-A Diểm Giảm
						if(SortBy.getSelectedIndex()==1 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.TenZA_DiemGiam);
							QLDoanVien.showStudent(std);
						}
						//ngày giảm tên Z-A
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.NgayGiam_TenZA);
							QLDoanVien.showStudent(std);
						}
						//ngày giảm Điểm giảm
						if(SortBy.getSelectedIndex()==2 && ThenBy.getSelectedIndex()==3) {
							Collections.sort(std, StandardCmpDoanVien.NgayGiam_DiemGiam);
							QLDoanVien.showStudent(std);
						}
						//diểm giảm Tên Z-A
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==1) {
							Collections.sort(std, StandardCmpDoanVien.DiemGiam_TenZA);
							QLDoanVien.showStudent(std);
						}
						//ĐIểm giảm ngày Giảm
						if(SortBy.getSelectedIndex()==3 && ThenBy.getSelectedIndex()==2) {
							Collections.sort(std, StandardCmpDoanVien.DiemGiam_NgayGiam);
							QLDoanVien.showStudent(std);
						}
						
					}
				}
				
			}
		});
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSapXep.setBounds(285, 287, 96, 32);
		contentPane.add(btnSapXep);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(389, 287, 96, 32);
		contentPane.add(btnThoat);
		
		
		std=QLDoanVien.studentList;
		
	}
	
	private int sort(ButtonGroup a) { 
		int x=0;
		Enumeration<AbstractButton> abs = a.getElements();
		while (abs.hasMoreElements()) {
			JRadioButton JR = (JRadioButton) abs.nextElement();
			if (JR.isSelected()) {
				if (JR.getText().equalsIgnoreCase("Tăng Dần")) {
					x = 1;
				} else if (JR.getText().equalsIgnoreCase("Giảm Dần")) {
					x = -1;
				}
			}
		}
		return x;	
	}
}
