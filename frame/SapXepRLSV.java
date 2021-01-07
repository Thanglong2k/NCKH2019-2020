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

import check_data.StandardCmpRLSV;
import object_frame.DanhGiaRLSV;
import javax.swing.ImageIcon;

public class SapXepRLSV extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup SXgroupSortby = new ButtonGroup();
	private final ButtonGroup SXgroupThenby = new ButtonGroup();
	private JComboBox ThenBy;
	private JPanel panel_1;
	private JRadioButton rdbTangThenBy;
	private JRadioButton rdbGiamThenBy;

	List<DanhGiaRLSV> std = new ArrayList<DanhGiaRLSV>();
	private JButton btnSapXep;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepRLSV frame = new SapXepRLSV();
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
	public SapXepRLSV() {
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
		SortBy.addItem("Mã Đánh Giá");
		SortBy.addItem("Năm Học");
		SortBy.addItem("Học Kỳ");

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
		ThenBy.addItem("Mã Đánh Giá");
		ThenBy.addItem("Năm Học");
		ThenBy.addItem("Học Kỳ");

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
		btnSapXep.setIcon(new ImageIcon(SapXepRLSV.class.getResource("/buttonImages/sort.png")));
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
							Collections.sort(std, StandardCmpRLSV.MaTang_NamTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// mã tăng học kỳ tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.MaTang_HocKyTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm tăng mã tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.NamTang_MaTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm tăng học kỳ tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.NamTang_HocKyTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// Học Kỳ tăng mã tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.HocKyTang_MaTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// Học Kỳ tăng năm tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.HocKyTang_NamTang);
							QLDanhGiaRLSV.showRLSV(std);
						}

					}
					// sort by tăng then by giảm
					else if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == -1) {
						// Mã tăng năm giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.MaTang_NamGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// Mã Tăng học kỳ giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.MaTang_HocKyGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm tăng mã giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.NamTang_MaGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm tăng học kỳ giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.NamTang_HocKyGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ tăng mã giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.HocKyTang_MaGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ tăng năm giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.HocKyTang_NamGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}

					}

					// sort by giảm then by tăng
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == 1) {
						// Mã giảm năm tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.MaGiam_NamTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// Mã giảm học kỳ tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.MaGiam_HocKyTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm giảm mã tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.NamGiam_MaTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm giảm học kỳ tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.NamGiam_HocKyTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ giảm mã tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.HocKyGiam_MaTang);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ giảm năm tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.HocKyGiam_NamTang);
							QLDanhGiaRLSV.showRLSV(std);
						}

					}

					// sort by giảm then by giảm
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == -1) {
						// mã giảm năm giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.MaGiam_NamGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// mã giảm học kỳ giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std,StandardCmpRLSV.MaGiam_HocKyGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm giảm mã giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.NamGiam_MaGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// năm giảm học kỳ giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpRLSV.NamGiam_HocKyGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ giảm mã giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpRLSV.HocKyGiam_MaGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}
						// học kỳ giảm năm giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpRLSV.HocKyGiam_NamGiam);
							QLDanhGiaRLSV.showRLSV(std);
						}

					}
				}
				dispose();

			}
		});
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSapXep.setBounds(239, 287, 125, 32);
		contentPane.add(btnSapXep);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(SapXepRLSV.class.getResource("/buttonImages/thoat.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(374, 287, 111, 32);
		contentPane.add(btnThoat);
		std = QLDanhGiaRLSV.RLSVList;
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
