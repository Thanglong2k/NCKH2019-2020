package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modify_object.AdminModify;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JScrollPane scrollPane;
	private JDesktopPane desktopPane;
	private JPanel QLXepLoai;
	private JPanel QLRLDoanVien;
	private JPanel QLHĐDoanVien;
	private JPanel QLHoatDong;
	private JPanel QLGiangVien;
	private JPanel QLKhenThuong;
	private JPanel QLKyLuat;
	private JPanel QLChiDoan;
	private JPanel QLLienChiDoan;
	private JPanel QLDoanVien;
	private JPanel Tiltle;
	private JMenu HeThong;

	public static int NhanBiet = 0;
	
	
	public TrangChu() throws IOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1118, 760);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(1536, 822);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		HeThong = new JMenu("Hệ Thống");
		menuBar.add(HeThong);

		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng Xuất");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				setVisible(false);
			}
		});
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				setVisible(false);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đổi Mật Khẩu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration().changePasswordForm();
			}
		});

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tài khoản");

		mntmNewMenuItem_3.setVisible(false);

		
		if (AdminModify.getPer(Login.userNameTxt.getText()).equalsIgnoreCase("admin")) {
			mntmNewMenuItem_3.setVisible(true);
		}

		HeThong.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame adminFrame;
				try {
					adminFrame = new AdminFrame();
					adminFrame.setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JSeparator separator_3 = new JSeparator();
		HeThong.add(separator_3);
		HeThong.add(mntmNewMenuItem_1);

		JSeparator separator = new JSeparator();
		HeThong.add(separator);
		HeThong.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thoát");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JSeparator separator_1 = new JSeparator();
		HeThong.add(separator_1);
		HeThong.add(mntmNewMenuItem_2);

		JMenu HienThi = new JMenu("Công Cụ");
		menuBar.add(HienThi);

		JMenuItem TimKiem = new JMenuItem("Tìm Kiếm");
		TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Tìm Kiếm chung cho toàn bộ các bảng mỗi bảng thì tương ứng với 1 case biến
				 * nhân biết nó chạy từ 1 đến 10 tương ứng với mỗi nút và theo vị trí trên trang
				 * 
				 */
				switch (NhanBiet) {
				case 1:
					TimKiemDoanVien tk = new TimKiemDoanVien();
					tk.setVisible(true);
					break;
				case 2:
					break;
				case 3:
					TimKiemChiDoan tk3 = new TimKiemChiDoan();
					tk3.setVisible(true);
					break;
				case 4:
					TimKiemKyLuat tk4 = new TimKiemKyLuat();
					tk4.setVisible(true);
					break;
				case 5:
					TimKiemKhenThuong tk5 = new TimKiemKhenThuong();
					tk5.setVisible(true);
					break;
				case 6:
					TimKiemGiangVien tk6 = new TimKiemGiangVien();
					tk6.setVisible(true);
					break;
				case 7:
					TimKiemHoatDong tkhd = new TimKiemHoatDong();
					tkhd.setVisible(true);
					break;
				case 8:
					TimKiemHDDV tkh = new TimKiemHDDV();
					tkh.setVisible(true);
					break;
				case 9:
					TimKiemRLSV tka = new TimKiemRLSV();
					tka.setVisible(true);
					break;
				case 10:
					TimKiemXLDV xldv = new TimKiemXLDV();
					xldv.setVisible(true);
					break;
				}

			}
		});
		TimKiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		HienThi.add(TimKiem);

		JMenuItem SapXep = new JMenuItem("Sắp Xếp");
		SapXep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		SapXep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (NhanBiet) {
				case 1:
					SapXepDoanVien sx = new SapXepDoanVien();
					sx.setVisible(true);
					break;
				case 3:
					SapXepChiDoan sx3 = new SapXepChiDoan();
					sx3.setVisible(true);
					break;
				case 4:
					SapXepKyLuat sxkl = new SapXepKyLuat();
					sxkl.setVisible(true);
					break;
				case 5:
					SapXepKhenThuong sxkt = new SapXepKhenThuong();
					sxkt.setVisible(true);
					break;
				case 6:
					SapXepGiangVien sk6 = new SapXepGiangVien();
					sk6.setVisible(true);
					break;
				case 7:
					SapXepHoatDong sxhd = new SapXepHoatDong();
					sxhd.setVisible(true);
					break;
				case 8:
					SapXepHDDV sddv = new SapXepHDDV();
					sddv.setVisible(true);
					break;
				case 9:
					SapXepRLSV rlsv = new SapXepRLSV();
					rlsv.setVisible(true);
					break;
				case 10:
					SapXepXLDV xldv = new SapXepXLDV();
					xldv.setVisible(true);
					break;
				}
			}
		});

		JSeparator separator_2 = new JSeparator();
		HienThi.add(separator_2);
		HienThi.add(SapXep);

		JLabel lblNewLabel = new JLabel("Tài khoản:   ");
		menuBar.add(lblNewLabel);

		JLabel account = new JLabel(Login.userNameTxt.getText());
		menuBar.add(account);

		JSeparator separator_4 = new JSeparator();
		menuBar.add(separator_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 34, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Menu = new JPanel();
		Menu.setForeground(Color.BLACK);
		Menu.setBackground(new Color(48, 34, 79));
		Menu.setBounds(0, 0, 356, 763);
		contentPane.add(Menu);
		Menu.setLayout(null);

		Tiltle = new JPanel();
		Tiltle.setBackground(new Color(65,49,102));
		Tiltle.setBounds(0, 0, 356, 99);
		Menu.add(Tiltle);
		Tiltle.setLayout(null);

		JLabel lblMenu = new JLabel("Quản Lý");
		lblMenu.setIcon(new ImageIcon("src\\imageIcon\\QL_24dp.png"));
		lblMenu.setBackground(Color.RED);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblMenu.setBounds(47, 22, 299, 44);
		Tiltle.add(lblMenu);
		
		JLabel lblNewLabel_1 = new JLabel("___________________________");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 76, 221, 13);
		Tiltle.add(lblNewLabel_1);

		QLDoanVien = new JPanel();
		QLDoanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 1;
				desktopPane.removeAll();
				setBackground(QLDoanVien);
				QLDoanVien QLDV = null;
				try {
					QLDV = new QLDoanVien();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLDV.getSize());
				desktopPane.add(QLDV);
				QLDV.setVisible(true);
				QLDV.setBorder(null);
			}
		});
		QLDoanVien.setBackground(new Color(48,34,79));
		QLDoanVien.setBounds(0, 109, 356, 47);
		Menu.add(QLDoanVien);
		QLDoanVien.setLayout(null);

		JLabel lblQLDoanVien = new JLabel("Đoàn Viên");
		lblQLDoanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLDoanVien.setIcon(new ImageIcon("src\\imageIcon\\GV_24dp.png"));
		lblQLDoanVien.setForeground(Color.WHITE);
		lblQLDoanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLDoanVien.setBackground(Color.RED);
		lblQLDoanVien.setBounds(56, 0, 300, 44);
		QLDoanVien.add(lblQLDoanVien);

		QLLienChiDoan = new JPanel();
		QLLienChiDoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 2;
				desktopPane.removeAll();
				setBackground(QLLienChiDoan);
				QLLienChiDoan QLLCD = null;
				try {
					QLLCD = new QLLienChiDoan();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLLCD.getSize());
				desktopPane.add(QLLCD);
				QLLCD.setVisible(true);
			}
		});
		QLLienChiDoan.setLayout(null);
		QLLienChiDoan.setBackground(new Color(48,34,79));
		QLLienChiDoan.setBounds(0, 178, 356, 47);
		Menu.add(QLLienChiDoan);

		JLabel lblQLLienChiDoan = new JLabel("Liên Chi Đoàn");
		lblQLLienChiDoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLLienChiDoan.setIcon(new ImageIcon("src\\imageIcon\\LCD_24dp.png"));
		lblQLLienChiDoan.setForeground(Color.WHITE);
		lblQLLienChiDoan.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLLienChiDoan.setBackground(Color.RED);
		lblQLLienChiDoan.setBounds(56, 0, 300, 44);
		QLLienChiDoan.add(lblQLLienChiDoan);

		QLChiDoan = new JPanel();
		QLChiDoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 3;
				desktopPane.removeAll();
				setBackground(QLChiDoan);
				QLChiDoan QLLCD = null;
				try {
					QLLCD = new QLChiDoan();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLLCD.getSize());
				desktopPane.add(QLLCD);
				QLLCD.setVisible(true);
			}
		});
		QLChiDoan.setLayout(null);
		QLChiDoan.setBackground(new Color(48,34,79));
		QLChiDoan.setBounds(0, 245, 356, 47);
		Menu.add(QLChiDoan);

		JLabel lblQLChiDoan = new JLabel("Chi Đoàn");
		lblQLChiDoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLChiDoan.setIcon(new ImageIcon("src\\imageIcon\\CD-24dp.png"));
		lblQLChiDoan.setForeground(Color.WHITE);
		lblQLChiDoan.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLChiDoan.setBackground(Color.RED);
		lblQLChiDoan.setBounds(56, 0, 300, 44);
		QLChiDoan.add(lblQLChiDoan);

		QLKyLuat = new JPanel();
		QLKyLuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 4;
				desktopPane.removeAll();
				setBackground(QLKyLuat);
				QLKyLuat QLLCD = null;
				try {
					QLLCD = new QLKyLuat();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLLCD.getSize());
				desktopPane.add(QLLCD);
				QLLCD.setVisible(true);
			}
		});
		QLKyLuat.setLayout(null);
		QLKyLuat.setBackground(new Color(48,34,79));
		QLKyLuat.setBounds(0, 314, 356, 47);
		Menu.add(QLKyLuat);

		JLabel lblQLKyLuat = new JLabel("Kỷ Luật");
		lblQLKyLuat.setHorizontalAlignment(SwingConstants.LEFT);

		lblQLKyLuat.setIcon(new ImageIcon("src\\imageIcon\\KL_KT_24dp.png"));
		lblQLKyLuat.setForeground(Color.WHITE);
		lblQLKyLuat.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLKyLuat.setBackground(Color.RED);
		lblQLKyLuat.setBounds(56, 0, 300, 44);
		QLKyLuat.add(lblQLKyLuat);

		QLKhenThuong = new JPanel();
		QLKhenThuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 5;
				desktopPane.removeAll();
				setBackground(QLKhenThuong);
				QLKhenThuong QLHD = null;
				try {
					QLHD = new QLKhenThuong();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLHD.getSize());
				desktopPane.add(QLHD);
				QLHD.setVisible(true);
			}
		});
		QLKhenThuong.setLayout(null);
		QLKhenThuong.setBackground(new Color(48,34,79));
		QLKhenThuong.setBounds(0, 381, 356, 47);
		Menu.add(QLKhenThuong);

		JLabel lblQLKhenThuong = new JLabel("Khen Thưởng");
		lblQLKhenThuong.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLKhenThuong.setIcon(new ImageIcon("src\\imageIcon\\KL_KT_24dp.png"));
		lblQLKhenThuong.setForeground(Color.WHITE);
		lblQLKhenThuong.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLKhenThuong.setBackground(Color.RED);
		lblQLKhenThuong.setBounds(56, 0, 300, 44);
		QLKhenThuong.add(lblQLKhenThuong);

		QLGiangVien = new JPanel();
		QLGiangVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 6;
				desktopPane.removeAll();
				setBackground(QLGiangVien);
				QLGiangVien QLHD = null;
				try {
					QLHD = new QLGiangVien();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLHD.getSize());
				desktopPane.add(QLHD);
				QLHD.setVisible(true);
			}
		});
		QLGiangVien.setLayout(null);
		QLGiangVien.setBackground(new Color(48,34,79));
		QLGiangVien.setBounds(0, 449, 356, 47);
		Menu.add(QLGiangVien);

		JLabel lblQLGiangVien = new JLabel("Giảng Viên");
		lblQLGiangVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLGiangVien.setIcon(new ImageIcon("src\\imageIcon\\GV_24dp.png"));
		lblQLGiangVien.setForeground(Color.WHITE);
		lblQLGiangVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLGiangVien.setBackground(Color.RED);
		lblQLGiangVien.setBounds(56, 0, 300, 44);
		QLGiangVien.add(lblQLGiangVien);

		QLHoatDong = new JPanel();
		QLHoatDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 7;
				desktopPane.removeAll();
				setBackground(QLHoatDong);
				QLHoatDong QLHD = null;
				try {
					QLHD = new QLHoatDong();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLHD.getSize());
				desktopPane.add(QLHD);
				QLHD.setVisible(true);
			}
		});
		QLHoatDong.setLayout(null);
		QLHoatDong.setBackground(new Color(48,34,79));
		QLHoatDong.setBounds(0, 514, 356, 47);
		Menu.add(QLHoatDong);

		JLabel lblQLHoatDong = new JLabel("Hoạt Động");
		lblQLHoatDong.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLHoatDong.setIcon(new ImageIcon("src\\imageIcon\\HD-24dp.png"));
		lblQLHoatDong.setForeground(Color.WHITE);
		lblQLHoatDong.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLHoatDong.setBackground(Color.RED);
		lblQLHoatDong.setBounds(56, 0, 300, 44);
		QLHoatDong.add(lblQLHoatDong);

		QLHĐDoanVien = new JPanel();
		QLHĐDoanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 8;
				desktopPane.removeAll();
				setBackground(QLHĐDoanVien);
				QLDoanVienHD QLHDDV = null;
				try {
					QLHDDV = new QLDoanVienHD();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(QLHDDV.getSize());
				desktopPane.add(QLHDDV);
				QLHDDV.setVisible(true);
			}
		});
		QLHĐDoanVien.setLayout(null);
		QLHĐDoanVien.setBackground(new Color(48,34,79));
		QLHĐDoanVien.setBounds(0, 580, 356, 47);
		Menu.add(QLHĐDoanVien);

		JLabel lblQLHĐDoanVien = new JLabel("HĐ Đoàn Viên");
		lblQLHĐDoanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLHĐDoanVien.setIcon(new ImageIcon("src\\imageIcon\\HD_RL_24dp.png"));
		lblQLHĐDoanVien.setForeground(Color.WHITE);
		lblQLHĐDoanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLHĐDoanVien.setBackground(Color.RED);
		lblQLHĐDoanVien.setBounds(56, 0, 300, 44);
		QLHĐDoanVien.add(lblQLHĐDoanVien);

		QLRLDoanVien = new JPanel();
		QLRLDoanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 9;
				desktopPane.removeAll();
				setBackground(QLRLDoanVien);
				QLDanhGiaRLSV rlsv = null;
				try {
					rlsv = new QLDanhGiaRLSV();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(rlsv.getSize());
				desktopPane.add(rlsv);
				rlsv.setVisible(true);
			}
		});
		QLRLDoanVien.setLayout(null);
		QLRLDoanVien.setBackground(new Color(48,34,79));
		QLRLDoanVien.setBounds(0, 643, 356, 47);
		Menu.add(QLRLDoanVien);

		JLabel lblQLRLDoanVien = new JLabel("RL Đoàn Viên");
		lblQLRLDoanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLRLDoanVien.setIcon(new ImageIcon("src\\imageIcon\\HD_RL_24dp.png"));
		lblQLRLDoanVien.setForeground(Color.WHITE);
		lblQLRLDoanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLRLDoanVien.setBackground(Color.RED);
		lblQLRLDoanVien.setBounds(56, 0, 300, 44);
		QLRLDoanVien.add(lblQLRLDoanVien);

		QLXepLoai = new JPanel();
		QLXepLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanBiet = 10;
				desktopPane.removeAll();
				setBackground(QLXepLoai);
				QLXepLoaiDoanVien xl = null;
				try {
					xl = new QLXepLoaiDoanVien();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.setPreferredSize(xl.getSize());
				desktopPane.add(xl);
				xl.setVisible(true);
			}
		});
		QLXepLoai.setLayout(null);
		QLXepLoai.setBackground(new Color(48,34,79));
		QLXepLoai.setBounds(0, 706, 356, 47);
		Menu.add(QLXepLoai);

		JLabel lblQLXepLoai = new JLabel("Xếp Loại\r\n");
		lblQLXepLoai.setHorizontalAlignment(SwingConstants.LEFT);
		lblQLXepLoai.setIcon(new ImageIcon("src\\imageIcon\\XL_24dp.png"));
		lblQLXepLoai.setForeground(Color.WHITE);
		lblQLXepLoai.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQLXepLoai.setBackground(Color.RED);
		lblQLXepLoai.setBounds(58, 0, 298, 44);
		QLXepLoai.add(lblQLXepLoai);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 0, 1168, 763);
		contentPane.add(scrollPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(desktopPane);
	}

	private void setBackground(JPanel QL) {
		QLDoanVien.setBackground(new Color(48,34,79));
		QLLienChiDoan.setBackground(new Color(48,34,79));
		QLChiDoan.setBackground(new Color(48,34,79));
		QLKyLuat.setBackground(new Color(48,34,79));
		QLKhenThuong.setBackground(new Color(48,34,79));
		QLGiangVien.setBackground(new Color(48,34,79));
		QLHĐDoanVien.setBackground(new Color(48,34,79));
		QLRLDoanVien.setBackground(new Color(48,34,79));
		QLXepLoai.setBackground(new Color(48,34,79));
		QLHoatDong.setBackground(new Color(48,34,79));

		QL.setBackground(new Color(86, 70, 119));
	}
	
	
}
