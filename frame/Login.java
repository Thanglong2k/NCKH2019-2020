package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modify_object.StudentModify;
import java.awt.event.KeyAdapter;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField userNameTxt;
	private JPasswordField passWordTxt;


	private void controlLogin() throws IOException, SQLException {
		String userName = userNameTxt.getText();
		String passWord = passWordTxt.getText();
		
		if(userName.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập tên người dùng.");
			return;
		}
		
		if(passWord.trim().length() == 0) {
			JOptionPane.showMessageDialog(getComponent(0), "Bạn chưa nhập mật khẩu.");
			return;
		}
		
		if(StudentModify.checkExist(userName, passWord) == true) {
			new TrangChu().setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(getComponent(0), "Tài khoản hoặc mật khẩu không đúng!");
		}
		
	}

	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Quản lí đoàn viên Trường Đại Học Giao Thông Vận Tải");
		//Font
		Font f = new Font("Serif", Font.BOLD, 30);
		
		//header 
		JPanel 	heading = new JPanel();
		heading.setBackground(new Color(0, 0, 0, 120));
		heading.setBounds(0, 0, 1080, 100);
		heading.setLayout(null);
		
		JLabel title = new JLabel("QUẢN LÝ ĐOÀN VIÊN ĐẠI HỌC GIAO THÔNG VẬN TẢI");
		title.setBackground(Color.WHITE);
		title.setBounds(155, 27, 818, 37);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setForeground(new Color(255, 255, 255));
		heading.add(title);
		
		//button
		JButton signup = new JButton("Đăng Nhập");
		signup.setForeground(Color.WHITE);
		signup.setBackground(new Color(255, 133, 0));
		signup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlLogin();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				signup.requestFocus();
			}
		});
		signup.setBounds(196, 270, 109, 30);
		signup.setMnemonic(KeyEvent.VK_ENTER);
		
		//login panel
		JPanel login = new JPanel();
		login.setSize(400, 350);
		login.setBackground(new Color(44, 62, 80));
		login.setBounds(300, 150, 480, 350);
	 	login.setLayout(null);
	 	
	 	login.add(signup);
	 	
	 	
//	 	
		//frame
		setSize(1080, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon background_image = new ImageIcon("src/images/ban8.jpg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1080, 600, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setForeground(new Color(255, 255, 255));
		background.setFont(new Font("Tahoma", Font.PLAIN, 16));
		background.setBounds(0, 0, 1080, 600);
		getContentPane().add(background);
		setLocationRelativeTo(null);
		background.add(login);
		
		
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameTxt.setBounds(134, 115, 228, 30);
		login.add(userNameTxt);
		
		
		passWordTxt = new JPasswordField();
		passWordTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						controlLogin();
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					signup.requestFocus();
				}
			}
		});
		passWordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passWordTxt.setBounds(134, 180, 228, 30);
		login.add(passWordTxt);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Registration().changePasswordForm();
			}
		});
		lblNewLabel.setForeground(new Color(153, 255, 51));
		lblNewLabel.setBounds(265, 220, 97, 26);
		login.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 133, 0));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 480, 81);
		login.add(panel);
		panel.setLayout(null);
		
		JLabel lblngNhp = new JLabel("Đăng Nhập");
		lblngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhp.setForeground(Color.WHITE);
		lblngNhp.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblngNhp.setBounds(123, 10, 243, 61);
		panel.add(lblngNhp);
		
		JLabel lblngK = new JLabel("Đăng Ký");
		lblngK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Registration();
			}
		});
		lblngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblngK.setForeground(new Color(153, 255, 51));
		lblngK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblngK.setBounds(134, 220, 97, 26);
		login.add(lblngK);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(134, 89, 97, 26);
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(134, 155, 97, 26);
		login.add(lblNewLabel_1_1);

		background.add(heading);
		
		JLabel UTClogo = new JLabel();
		UTClogo.setBounds(65, 10, 80, 80);
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("src/images/UTC.png").getImage()
				.getScaledInstance(UTClogo.getWidth(), UTClogo.getHeight(), Image.SCALE_SMOOTH));
		UTClogo.setIcon(imageIcon1);

		
		heading.add(UTClogo);
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
