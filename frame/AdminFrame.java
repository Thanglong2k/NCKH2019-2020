package frame;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import modify_object.AdminModify;
import object_frame.Admin;
import java.awt.Color;
import javax.swing.ImageIcon;
public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JComboBox<?> permission;
	private static DefaultTableModel tableModel;
	private JPasswordField password;
	private JTable table;


	
	private void reset() {
		username.setText("");
		password.setText("");
	}
	
	private void updateAccount() throws IOException, SQLException {
		
		
		int selectRow = table.getSelectedRow();
		
		if(selectRow >= 0) {
			String oldName = table.getValueAt(selectRow, 1).toString();
			
			int option = JOptionPane.showConfirmDialog(this, "Sửa tài khoản này?");
			if(option == 0) {
				String uname = username.getText();
				String pword = password.getText();
				int per = permission.getSelectedIndex();
				String permis = (per == 0) ? "admin" : "nguoidung";
				
				if(oldName.equalsIgnoreCase("admin")) {
					if(per == 1) {
						JOptionPane.showMessageDialog(getComponent(0), "Tài khoản mặc định của hệ thống! Không thể sửa quyền!");
						return ;
					}
				}
				
				if(!oldName.equals(uname) && AdminModify.exist.containsKey(uname) == true) {
					JOptionPane.showMessageDialog(getComponent(0), "Tên người dùng đã tồn tại!");
					return;
				}
				
				if(uname.trim().length() == 0) {
					JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập tên người dùng!");
					return;
				}
				
				if(pword.trim().length() == 0) {
					JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập mật khẩu!");
					return;
				}
				
				if(!StandardInput.checkUserName(uname)) {
					JOptionPane.showMessageDialog(getComponent(0), "Tài khoản từ 3 kí tự trở lên và không chứa kí tự đặc biệt!");
					return;
				}
				
				if(!StandardInput.checkPassWord(pword)) {
					JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu từ 6 kí tự trở lên!");
					return;
				}
				
				AdminModify.update(uname, pword, permis, oldName);
				JOptionPane.showMessageDialog(getComponent(0), "Cập nhật thành công!");
				showAccount(AdminModify.findAllAccount());
				reset();
			}
			
		}
		
		
		
	}
	
	private void insertAccount() throws IOException, SQLException {
		String uname = username.getText();
		String pword = password.getText();
		int per = permission.getSelectedIndex();
		String permis = (per == 0) ? "admin" : "nguoidung";
		
		if(uname.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập tên người dùng!");
			return;
		}
		
		if(pword.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập mật khẩu!");
			return;
		}
		
		if(!StandardInput.checkUserName(uname)) {
			JOptionPane.showMessageDialog(getComponent(0), "Tài khoản từ 3 kí tự trở lên và không chứa kí tự đặc biệt!");
			return;
		}
		
		if(AdminModify.exist.containsKey(uname) == true) {
			JOptionPane.showMessageDialog(getComponent(0), "Tên người dùng đã tồn tại!");
			return;
		}
		if(!StandardInput.checkPassWord(pword)) {
			JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu từ 6 kí tự trở lên!");
			return;
		}
		
		AdminModify.insert(uname, pword, permis);
		JOptionPane.showMessageDialog(getComponent(0), "Thêm tài khoản thành công!");
		reset();
		showAccount(AdminModify.findAllAccount());
	}
	
	private void deleteAccount() throws IOException, SQLException {
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0) {
			String uname = table.getValueAt(table.getSelectedRow(), 1).toString();
			int option = JOptionPane.showConfirmDialog(this, "Xóa tài khoản này?");
			if(option == 0) {
				if(uname.equalsIgnoreCase("admin")) {
					JOptionPane.showMessageDialog(getComponent(0), "Tài khoản mặc định của hệ thống! Không thể xóa!");
					return ;
				}
				AdminModify.delete(uname);
				showAccount(AdminModify.findAllAccount());
				JOptionPane.showMessageDialog(getComponent(0), "Xóa thành công!");
				reset();
			}	
		}
	}
	
	private static void showAccount(LinkedList<Admin> a) {
		int no = 0;
		tableModel.setRowCount(0);
		for(Admin z : a) {
			tableModel.addRow (
					new Object[] {
							no++,
							z.getUsername(),
							z.getPassword(),
							z.getPermission()
						}
					);
		}
	}

	public AdminFrame() throws SQLException, IOException {
		setTitle("Quản lí tài khoản");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44,62,80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 786, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lí tài khoản");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(234, 10, 290, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 75, 766, 171);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(124, 252, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, SystemColor.activeCaption));
		scrollPane.setBounds(10, 24, 746, 137);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				password.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				int se = table.getValueAt(table.getSelectedRow(), 3).toString().equals("admin") ? 0 : 1;
				permission.setSelectedIndex(se);
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableModel = (DefaultTableModel) table.getModel();
		tableModel = new DefaultTableModel(
				new String[] {
						"No.", "Tài khoản", "Mật khẩu", "Phân quyền"
					},
					0
				);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(10, 270, 766, 233);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(124, 252, 0)));
		contentPane.add(panel_2);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản:");
		lblNewLabel_1.setForeground(new Color(124, 252, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(86, 51, 99, 26);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setForeground(new Color(124, 252, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(86, 112, 99, 26);
		panel_2.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBackground(new Color(245, 245, 245));
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(208, 51, 152, 26);
		panel_2.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phân quyền:");
		lblNewLabel_1_1_1.setForeground(new Color(124, 252, 0));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(86, 171, 113, 26);
		panel_2.add(lblNewLabel_1_1_1);
		
		permission = new JComboBox();
		permission.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Người dùng"}));
		permission.setFont(new Font("Tahoma", Font.PLAIN, 14));
		permission.setBounds(208, 173, 152, 21);
		
		panel_2.add(permission);
		
		JButton btnNewButton = new JButton("Thêm mới");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(AdminFrame.class.getResource("/buttonImages/insert.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					insertAccount();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(485, 51, 138, 26);
		panel_2.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setHorizontalAlignment(SwingConstants.LEFT);
		btnSa.setIcon(new ImageIcon(AdminFrame.class.getResource("/buttonImages/edit.png")));
		btnSa.setForeground(new Color(255, 255, 255));
		btnSa.setBackground(new Color(255, 153, 0));
		btnSa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					updateAccount();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(485, 87, 138, 26);
		panel_2.add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXa.setIcon(new ImageIcon(AdminFrame.class.getResource("/buttonImages/delete.png")));
		btnXa.setForeground(new Color(255, 255, 255));
		btnXa.setBackground(new Color(255,153,0));
		btnXa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					deleteAccount();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXa.setBounds(485, 135, 138, 26);
		panel_2.add(btnXa);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setHorizontalAlignment(SwingConstants.LEFT);
		btnThot.setIcon(new ImageIcon(AdminFrame.class.getResource("/buttonImages/thoat.png")));
		btnThot.setForeground(new Color(255, 255, 255));
		btnThot.setBackground(new Color(255,153,0));
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(485, 171, 138, 26);
		panel_2.add(btnThot);
		
		password = new JPasswordField();
		password.setBackground(new Color(245, 245, 245));
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(208, 112, 152, 25);
		panel_2.add(password);
		showAccount(AdminModify.findAllAccount());
	}
}
