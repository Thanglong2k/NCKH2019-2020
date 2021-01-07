package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import check_data.StandardInput;
import data_config.ReadData;
import modify_object.StudentModify;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	private JPasswordField rePassWordTxt;
	private JLabel usernameLb;
	private JLabel passwordLb;
	private static JLabel rePasswordLb;
	private static JLabel lblNewLabel;
	private JPanel panel;
	private JButton btnThot;
	private static JLabel rePasswordLb_1;
	private static JPasswordField passwordField;
	private static JButton btnRegister;
	private static JButton btnRegister_1;

	public Registration() {
		setSize(500, 400);
		setTitle("Đăng ký tài khoản");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(44, 62, 80));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		//bacground
		
		
		
		ImageIcon background_image = new ImageIcon("images/UTC.png");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		
		
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setFont(new Font("Tahoma", Font.PLAIN, 16));
		background.setBounds(0, 0, 500, 363);
		contentPane.setLayout(null);
//		getContentPane().add(background);
		
		//text field
		userNameTxt = new JTextField();
		userNameTxt.setBounds(215, 98, 200, 30);
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		passWordTxt = new JPasswordField();
		passWordTxt.setBounds(215, 152, 200, 30);
		passWordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(passWordTxt);
		
		rePassWordTxt = new JPasswordField();
		rePassWordTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						controlRegister();
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			}
		});
		rePassWordTxt.setBounds(215, 206, 200, 30);
		rePassWordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(rePassWordTxt);
		
		usernameLb = new JLabel("Tài khoản:");
		usernameLb.setBounds(52, 98, 153, 30);
		usernameLb.setBackground(SystemColor.textHighlightText);
		usernameLb.setForeground(new Color(236, 240, 241));
		usernameLb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(usernameLb);
		
		passwordLb = new JLabel("Mật khẩu:");
		passwordLb.setBounds(52, 152, 153, 30);
		passwordLb.setBackground(SystemColor.textHighlightText);
		passwordLb.setForeground(new Color(236, 240, 241));
		passwordLb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(passwordLb);
		
		rePasswordLb = new JLabel("Nhập lại mật khẩu:");
		rePasswordLb.setBounds(52, 206, 153, 30);
		rePasswordLb.setBackground(SystemColor.textHighlightText);
		rePasswordLb.setForeground(new Color(236, 240, 241));
		rePasswordLb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(rePasswordLb);
		
		btnRegister = new JButton("Đăng ký");
		btnRegister.setBounds(88, 311, 109, 30);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlRegister();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.setBackground(new Color(255, 153, 0));
		btnRegister.setForeground(new Color(236, 240, 241));
		contentPane.add(btnRegister);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 500, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Đăng Ký");
		lblNewLabel.setBounds(159, 23, 190, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(236, 240 ,241));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setForeground(new Color(236, 240, 241));
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThot.setBackground(new Color(255, 153, 0));
		btnThot.setBounds(297, 311, 109, 30);
		contentPane.add(btnThot);
		
		rePasswordLb_1 = new JLabel("Nhập lại mật khẩu:");
		rePasswordLb_1.setForeground(new Color(236, 240, 241));
		rePasswordLb_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		rePasswordLb_1.setBackground(Color.WHITE);
		rePasswordLb_1.setBounds(52, 256, 153, 30);
		contentPane.add(rePasswordLb_1);
		rePasswordLb_1.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						controlRegister();
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(215, 256, 200, 30);
		contentPane.add(passwordField);
		
		btnRegister_1 = new JButton("Đổi");
		btnRegister_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					changePassword();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister_1.setForeground(new Color(236, 240, 241));
		btnRegister_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister_1.setBackground(new Color(255, 153, 0));
		btnRegister_1.setBounds(88, 311, 109, 30);
		btnRegister_1.setVisible(false);
		contentPane.add(btnRegister_1);
		passwordField.setVisible(false);
		
		//background
		JPanel backGround = new JPanel();
//		backGround.setBackground(new Color(0, 0, 0, 50));
		backGround.setBounds(0, 0, 500, 100);
		backGround.setLayout(null);
		background.add(backGround);
		setVisible(true);
	}
	
	private void controlRegister() throws IOException, SQLException {
		
		String userName = userNameTxt.getText();
		String passWord = passWordTxt.getText();
		String rePassWord = rePassWordTxt.getText();
		
		if(userName.trim().length() == 0 || passWord.trim().length() == 0 || rePassWord.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Vui lòng điền đầy đủ thông tin.");
			return;
		}
		
		int z = StandardInput.validateRegistrationData(userName, passWord, rePassWord);
		
		if(z == 1) {
			JOptionPane.showMessageDialog(getComponent(0), "Tên phải từ 3 kí tự trở lên và không chứa kí tự đặc biệt!");
			return;
		}
		if(z == 2) {
			JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu phải từ 6 kí tự trở lên!");
			return;
		} 
		if(z == 3) {
			JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu phải giống nhau!");
			return;
		} 
		
		Map<String, String> config = ReadData.readDataFromFile();
		
		String sqlCheck = "select * from DangNhap where Username=N'" 
				+ userName + "'";
//		String sqlInsert = ""
		try (Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				Statement stmt = conn.createStatement()
						) {
			ResultSet rs = stmt.executeQuery(sqlCheck);
			if(rs.next()) {
				JOptionPane.showMessageDialog(getComponent(0), "Tên người dùng đã tồn tại.");
			} else {
				insertToSql(userName, passWord);
				JOptionPane.showMessageDialog(getComponent(0), "Đăng ký thành công.");
				setVisible(false);
			}
		}
		
	}
	
	private void insertToSql(String username, String password) throws IOException, SQLException {
		Map<String, String> config = ReadData.readDataFromFile();
		
		String query = "insert into DangNhap (Username,password,PhanQuyen) values (?,?,?)";
		
		try (Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query);
						) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, "nguoidung");
			stmt.execute();
		}
	}
	
	public static void changePasswordForm() {
		rePasswordLb.setText("Mật khẩu mới:");
		rePasswordLb_1.setText("Nhập lại mật khẩu mới:");
		lblNewLabel.setText("Đổi Mật Khẩu");
		btnRegister.setVisible(false);
		btnRegister_1.setVisible(true);
		rePasswordLb_1.setVisible(true);
		passwordField.setVisible(true);
	}
	
	private void changePassword() throws IOException, SQLException {
		String userName = userNameTxt.getText();
		String passWord = passWordTxt.getText();
		String rePassWord = rePassWordTxt.getText();
		String repassWord1 = passwordField.getText();
		
		if(userName.trim().length() == 0 || passWord.trim().length() == 0 || rePassWord.trim().length() == 0 || repassWord1.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Vui lòng điền đầy đủ thông tin.");
			return;
		}
		
		if(StudentModify.checkExist(userName, passWord) == true) {
			if(!StandardInput.checkPassWord(rePassWord)) {
				JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu mới phải từ 6 kí tự trở lên!");
				return;
			}
			if(!rePassWord.equals(repassWord1)) {
				JOptionPane.showMessageDialog(getComponent(0), "Mật khẩu mới phải giống nhau!");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(getComponent(0), "Vui lòng nhập đúng tài khoản và mật khẩu cũ!");
			return;
		}
		
		StudentModify.changePassword(userName, passWord, rePassWord);
		JOptionPane.showMessageDialog(getComponent(0), "Đổi mật khẩu thành công!");
		dispose();
	}
	
}
