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

import check_data.StandardCmpHoatDong;
import object_frame.HoatDong;
import javax.swing.ImageIcon;

public class SapXepHoatDong extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup SXgroupSortby = new ButtonGroup();
	private final ButtonGroup SXgroupThenby = new ButtonGroup();
	private JComboBox ThenBy;
	private JPanel panel_1;
	private JRadioButton rdbTangThenBy;
	private JRadioButton rdbGiamThenBy;

	List<HoatDong> std = new ArrayList<HoatDong>();
	private JButton btnSapXep;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepHoatDong frame = new SapXepHoatDong();
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
	public SapXepHoatDong() {
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
		SortBy.addItem("Tên Hoạt Động");
		SortBy.addItem("Thời Gian");
		SortBy.addItem("Loại Hoạt Động");

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
		ThenBy.addItem("Tên Hoạt Động");
		ThenBy.addItem("Thời Gian");
		ThenBy.addItem("Loại Hoạt Động");

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
		btnSapXep.setIcon(new ImageIcon(SapXepHoatDong.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SortBy.getSelectedIndex() == ThenBy.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Không chọn trường sắp xếp trùng nhau ");
				} else if (SortBy.getSelectedIndex() == 0 || ThenBy.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hết đối tượng ");
				} else {
					// cả 2 đều tăng
					if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == 1) {
						/*
						 * tên A_Z thời gian tăng
						 */
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.TenAZ_ThoiGianTang);
							QLHoatDong.showHoatDong(std);
						}
						// tên A-Z Loại A-Z
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.TenAZ_LoaiAZ);
							QLHoatDong.showHoatDong(std);
						}
						// tgian tăng tên A-Z
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianTang_TenAZ);
							QLHoatDong.showHoatDong(std);
						}
						// tgian tăng Loại A-Z
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianTang_LoaiAZ);
							QLHoatDong.showHoatDong(std);
						}
						// Loại A-Z Tên A-Z
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.LoaiAZ_TenAZ);
							QLHoatDong.showHoatDong(std);
						}
						// Loại A-Z Tgian Tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.LoaiAZ_ThoiGianTang);
							QLHoatDong.showHoatDong(std);
						}

					}
					// sort by tăng then by giảm
					else if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == -1) {
						// tên A-Z tgian giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.TenAZ_ThoiGianGiam);
							QLHoatDong.showHoatDong(std);
						}
						// tên A-Z Loại Z-A
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.TenAZ_LoaiZA);
							QLHoatDong.showHoatDong(std);
						}
						// tgian tăng tên Z-A
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianTang_TenZA);
							QLHoatDong.showHoatDong(std);
						}
						// Tgian tăng loại Z-A
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianTang_LoaiZA);
							QLHoatDong.showHoatDong(std);
						}
						// loại A-Z tên Z-A
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.LoaiAZ_TenZA);
							QLHoatDong.showHoatDong(std);
						}
						// Loại A-Z tgian giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.LoaiAZ_ThoiGianGiam);
							QLHoatDong.showHoatDong(std);
						}

					}

					// sort by giảm then by tăng
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == 1) {
						// tên Z-A tgian tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.TenZA_ThoiGianTang);
							QLHoatDong.showHoatDong(std);
						}
						// tên Z-A Loại A-Z
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.TenZA_LoaiAZ);
							QLHoatDong.showHoatDong(std);
						}
						// tgian giảm tên A-Z
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianGiam_TenAZ);
							QLHoatDong.showHoatDong(std);
						}
						// Tgian giảm loại A-Z
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianGiam_LoaiAZ);
							QLHoatDong.showHoatDong(std);
						}
						// loại Z-A tên A-Z
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.LoaiZA_TenAZ);
							QLHoatDong.showHoatDong(std);
						}
						// loại Z-A tgian tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.LoaiZA_ThoiGianTang);
							QLHoatDong.showHoatDong(std);
						}

					}

					// sort by giảm then by giảm
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == -1) {
						// tên Z-A tgian giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.TenZA_ThoiGianGiam);
							QLHoatDong.showHoatDong(std);
						}
						// tên Z-A loại Z-A
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std,StandardCmpHoatDong.TenZA_LoaiZA);
							QLHoatDong.showHoatDong(std);
						}
						// tgian giảm tên Z-A
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianGiam_TenZA);
							QLHoatDong.showHoatDong(std);
						}
						// tgian giảm loại Z-A
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHoatDong.ThoiGianGiam_LoaiZA);
							QLHoatDong.showHoatDong(std);
						}
						// loại Z-A Tên Z-A
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHoatDong.LoaiZA_TenZA);
							QLHoatDong.showHoatDong(std);
						}
						// loại Z-A tgian giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHoatDong.LoaiZA_ThoiGianGiam);
							QLHoatDong.showHoatDong(std);
						}

					}
				}
				dispose();

			}
		});
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSapXep.setBounds(236, 287, 124, 32);
		contentPane.add(btnSapXep);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(SapXepHoatDong.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(370, 287, 115, 32);
		contentPane.add(btnThoat);
		std = QLHoatDong.hoatdongList;
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
}
