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

import check_data.StandardCmpHDDV;
import object_frame.HoatDongDoanVien;
import javax.swing.ImageIcon;

public class SapXepHDDV extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup SXgroupSortby = new ButtonGroup();
	private final ButtonGroup SXgroupThenby = new ButtonGroup();
	private JComboBox ThenBy;
	private JPanel panel_1;
	private JRadioButton rdbTangThenBy;
	private JRadioButton rdbGiamThenBy;

	List<HoatDongDoanVien> std = new ArrayList<HoatDongDoanVien>();
	private JButton btnSapXep;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SapXepHDDV frame = new SapXepHDDV();
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
	public SapXepHDDV() {
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
		SortBy.addItem("ID");
		SortBy.addItem("Mã Sinh Viên");
		SortBy.addItem("Mã Hoạt Động");

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
		ThenBy.addItem("ID");
		ThenBy.addItem("Mã Sinh Viên");
		ThenBy.addItem("Mã Hoạt Động");

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
		btnSapXep.setForeground(new Color(255, 255, 255));
		btnSapXep.setIcon(new ImageIcon(SapXepHDDV.class.getResource("/buttonImages/sort.png")));
		btnSapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SortBy.getSelectedIndex() == ThenBy.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Không chọn trường sắp xếp trùng nhau ");
				} else if (SortBy.getSelectedIndex() == 0 || ThenBy.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa chọn hết đối tượng ");
				} else {
					// cả 2 đều tăng id - msv - mhd
					if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == 1) {
						/*
						 * ID tăng MSV tăng
						 */
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.IDTang_MSVTang);
							QLDoanVienHD.showHDDV(std);
						}
						// ID tăng MHD tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.IDTang_MHDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV tăng ID tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std,  StandardCmpHDDV.MSVTang_IDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV tăng MHD tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.MSVTang_MHDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD tăng id tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MHDTang_IDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD tăng MSV tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.MHDTang_MSVTang);
							QLDoanVienHD.showHDDV(std);
						}

					}
					// sort by tăng then by giảm
					else if (sort(SXgroupSortby) == 1 && sort(SXgroupThenby) == -1) {
						// ID tăng MSV giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.IDTang_MSVGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// ID tăng MHD giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.IDTang_MHDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV tăng id giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MSVTang_IDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV tăng MHD giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.MSVTang_MHDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD tăng ID giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MHDTang_IDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD tăng MSV giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.MHDTang_MSVGiam);
							QLDoanVienHD.showHDDV(std);
						}

					}

					// sort by giảm then by tăng
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == 1) {
						// ID giảm MSV tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.IDGiam_MSVTang);
							QLDoanVienHD.showHDDV(std);
						}
						// ID giảm MHD tăng
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.IDGiam_MHDTang);
							QLDoanVienHD.showHDDV(std);
						}
						//	MSV giảm ID tăng
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MSVGiam_IDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV giảm MHD tăng 
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.MSVGiam_MHDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD giảm ID tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MHDGiam_IDTang);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD giảm MSV tăng
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.MHDGiam_MSVTang);
							QLDoanVienHD.showHDDV(std);
						}

					}

					// sort by giảm then by giảm
					else if (sort(SXgroupSortby) == -1 && sort(SXgroupThenby) == -1) {
						// ID giảm MSV giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.IDGiam_MSVGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// ID giảm MHD giảm
						if (SortBy.getSelectedIndex() == 1 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std,StandardCmpHDDV.IDGiam_MHDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV giảm ID giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MSVGiam_IDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MSV giảm MHD giảm
						if (SortBy.getSelectedIndex() == 2 && ThenBy.getSelectedIndex() == 3) {
							Collections.sort(std, StandardCmpHDDV.MSVGiam_MHDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD giảm ID giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 1) {
							Collections.sort(std, StandardCmpHDDV.MHDGiam_IDGiam);
							QLDoanVienHD.showHDDV(std);
						}
						// MHD giảm MSV giảm
						if (SortBy.getSelectedIndex() == 3 && ThenBy.getSelectedIndex() == 2) {
							Collections.sort(std, StandardCmpHDDV.MHDGiam_MSVGiam);
							QLDoanVienHD.showHDDV(std);
						}

					}
				}
				dispose();

			}
		});
		btnSapXep.setBackground(new Color(65,49,102));
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSapXep.setBounds(243, 287, 125, 32);
		contentPane.add(btnSapXep);

		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setIcon(new ImageIcon(SapXepHDDV.class.getResource("/buttonImages/thoat.png")));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(65,49,102));
		btnThoat.setBounds(373, 287, 112, 32);
		contentPane.add(btnThoat);
		std = QLDoanVienHD.HDDVList;
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
