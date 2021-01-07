package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import check_data.StandardCmpKyLuat;
import modify_object.StudentModify;
import object_frame.Student;
import object_frame.KyLuat;
import javax.swing.ImageIcon;;

public class SapXepKyLuat extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup SXgroupSortby = new ButtonGroup();
	private final ButtonGroup SXgroupThenby = new ButtonGroup();
	private JComboBox ThenBy;
	private JPanel panel_1;
	private JRadioButton rdbTangThenBy;
	private JRadioButton rdbGiamThenBy;

	public static Map<String,String> M = new HashMap<String, String>();
	List<KyLuat> std = new ArrayList<KyLuat>();
	private JButton btnSapXep;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepKyLuat frame = new SapXepKyLuat();
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
	public SapXepKyLuat() {
		setTitle("Sắp Xếp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(8, 10, 479, 109);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sort by", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox SortBy = new JComboBox();
		SortBy.addItem("(Chọn Trường)");
		SortBy.addItem("Mã Kỷ Luật");
		SortBy.addItem("Tên Đoàn Viên");
		SortBy.addItem("Ngày Kỷ Luật");

		SortBy.setBackground(Color.WHITE);
		SortBy.setBounds(8, 37, 215, 32);
		panel.add(SortBy);

		JRadioButton rdbTangSortBy = new JRadioButton("Tăng Dần", true);
		rdbTangSortBy.setBackground(new Color(255, 255, 255));
		SXgroupSortby.add(rdbTangSortBy);
		rdbTangSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbTangSortBy.setBounds(269, 23, 149, 32);
		panel.add(rdbTangSortBy);

		JRadioButton rdbGiamSortBy = new JRadioButton("Giảm Dần");
		rdbGiamSortBy.setBackground(new Color(255, 255, 255));
		SXgroupSortby.add(rdbGiamSortBy);
		rdbGiamSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbGiamSortBy.setBounds(269, 57, 149, 32);
		panel.add(rdbGiamSortBy);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Then by", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(8, 129, 479, 109);
		contentPane.add(panel_1);

		ThenBy = new JComboBox();
		ThenBy.addItem("(Chọn Trường)");
		ThenBy.addItem("Mã Kỷ Luật");
		ThenBy.addItem("Tên Đoàn Viên");
		ThenBy.addItem("Ngày Kỷ Luật");

		ThenBy.setBackground(Color.WHITE);
		ThenBy.setBounds(8, 37, 215, 32);
		panel_1.add(ThenBy);

		rdbTangThenBy = new JRadioButton("Tăng Dần", true);
		rdbTangThenBy.setBackground(new Color(255, 255, 255));
		SXgroupThenby.add(rdbTangThenBy);
		rdbTangThenBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbTangThenBy.setBounds(268, 18, 149, 32);
		panel_1.add(rdbTangThenBy);

		rdbGiamThenBy = new JRadioButton("Giảm Dần");
		rdbGiamThenBy.setBackground(new Color(255, 255, 255));
		SXgroupThenby.add(rdbGiamThenBy);
		rdbGiamThenBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbGiamThenBy.setBounds(268, 60, 149, 32);
		panel_1.add(rdbGiamThenBy);

		btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setIcon(new ImageIcon(SapXepKyLuat.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getData();
				if (SortBy.getSelectedIndex() == ThenBy.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Không chọn trường sắp xếp trùng nhau ");
				} else if (SortBy.getSelectedIndex() == 0 || ThenBy.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hết đối tượng ");
				} else {
					// mã - năm - học kỳ 
					// cả 2 đều tăng
					if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == 1) {
						/*
						 * mã tăng năm tăng
						 */
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.MaKLTang_TenTang);
							QLKyLuat.showKyLuat(std);
						}
						// mã tăng học kỳ tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.MaKLTang_NgayKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// năm tăng tên tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.TenTang_MaKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// năm tăng học kỳ tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.TenTang_NgayKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// Học Kỳ tăng mã tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLTang_MaKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// Học Kỳ tăng năm tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLTang_TenTang);
							QLKyLuat.showKyLuat(std);
						}

					}
					// sort by tăng then by giảm
					else if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == -1) {
						// Mã tăng năm giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.MaKLTang_TenGiam);
							QLKyLuat.showKyLuat(std);
						}
						// Mã Tăng học kỳ giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.MaKLTang_NgayKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// năm tăng mã giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.TenTang_MaKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// năm tăng học kỳ giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.TenTang_NgayKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ tăng mã giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLTang_MaKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ tăng năm giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLTang_TenGiam);
							QLKyLuat.showKyLuat(std);
						}

					}

					// sort by giảm then by tăng
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == 1) {
						// Mã giảm năm tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.MaKLGiam_TenTang);
							QLKyLuat.showKyLuat(std);
						}
						// Mã giảm học kỳ tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.MaKLGiam_NgayKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// năm giảm mã tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.TenGiam_MaKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// năm giảm học kỳ tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.TenGiam_NgayKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ giảm mã tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLGiam_MaKLTang);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ giảm năm tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLGiam_TenTang);
							QLKyLuat.showKyLuat(std);
						}

					}

					// sort by giảm then by giảm
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == -1) {
						// mã giảm năm giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.MaKLGiam_TenGiam);
							QLKyLuat.showKyLuat(std);
						}
						// mã giảm học kỳ giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std,StandardCmpKyLuat.MaKLGiam_NgayKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// năm giảm mã giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.TenGiam_MaKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// năm giảm học kỳ giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpKyLuat.TenGiam_NgayKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ giảm mã giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLGiam_MaKLGiam);
							QLKyLuat.showKyLuat(std);
						}
						// học kỳ giảm năm giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpKyLuat.NgayKLGiam_TenGiam);
							QLKyLuat.showKyLuat(std);
						}

					}
				}
			}
		});
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSapXep.setBounds(236, 287, 123, 32);
		contentPane.add(btnSapXep);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(SapXepKyLuat.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(369, 287, 116, 32);
		contentPane.add(btnThoat);
		std = QLKyLuat.kyluatList;
	}

	private int sort(ButtonGroup a) {
		int x = 0;
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
	
	public static void getData() {
		List<Student> lstd = StudentModify.findAll();
		for(Student a : lstd) {
			M.put(a.getMaSV(), a.getHo() + ' ' + a.getTen());
		}
	}
}
