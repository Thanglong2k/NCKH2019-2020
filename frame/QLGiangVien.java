package frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import check_data.StandardInput;
import check_data.StandardOutput;
import export_file.writerExcel;
import modify_object.AdminModify;
import modify_object.ChiDoan_modify;
import modify_object.DanhGiaRLSVModify;
import modify_object.GiangVien_modify;
import object_frame.DanhGiaRLSV;
import object_frame.GiangVien;
import object_frame.Student;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class QLGiangVien extends JInternalFrame {
	public static JTable table;
	private JTextField MaGV;
	private JTextField HoTen;
	private JTextField Khoa;
	private JTextField SDT;
	private JTextField Email;
	
	private static int kt =0;
	
	
	
	public  static DefaultTableModel model = new DefaultTableModel();
	public static List<GiangVien>GVList = GiangVien_modify.findAll();
	private JTextField BoMon;
	private JLabel label_MaGV;
	private JLabel label_HoTen;
	private JLabel label_Email;
	private JLabel label_SDT;
	private JLabel label_Khoa;
	private JLabel label_BoMon;
	private JButton buttom_Them;
	private JButton buttom_Sua;
	private JButton buttom_Xoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLGiangVien frame = new QLGiangVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public QLGiangVien() throws IOException, SQLException {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(0,0, 1174, 775);
		getContentPane().setLayout(null);
		this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
		
		JPanel panel_ThongTin = new JPanel();
		panel_ThongTin.setBackground(new Color(255, 255, 255));
		panel_ThongTin.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ThongTin.setBounds(10, 10, 952, 142);
		getContentPane().add(panel_ThongTin);
		panel_ThongTin.setLayout(null);
		
		JLabel lblMGingVin = new JLabel("Mã Giảng Viên");
		lblMGingVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMGingVin.setBounds(8, 27, 98, 38);
		panel_ThongTin.add(lblMGingVin);
		
		JLabel lblHTn = new JLabel("Họ & Tên");
		lblHTn.setHorizontalAlignment(SwingConstants.LEFT);
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn.setBounds(8, 75, 65, 31);
		panel_ThongTin.add(lblHTn);
		
		JLabel lblBMn = new JLabel("Bộ Môn");
		lblBMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBMn.setBounds(347, 75, 65, 38);
		panel_ThongTin.add(lblBMn);
		
		JLabel Label_TT_Khoa = new JLabel("Khoa");
		Label_TT_Khoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_TT_Khoa.setBounds(347, 31, 65, 31);
		panel_ThongTin.add(Label_TT_Khoa);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSt.setBounds(668, 27, 65, 31);
		panel_ThongTin.add(lblSt);
		
		JLabel Label_TT_Email = new JLabel("Email");
		Label_TT_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_TT_Email.setBounds(668, 75, 65, 31);
		panel_ThongTin.add(Label_TT_Email);
		
		MaGV = new JTextField();
		MaGV.setBackground(new Color(245, 245, 245));
		MaGV.setBounds(106, 29, 151, 31);
		panel_ThongTin.add(MaGV);
		MaGV.setColumns(10);
		
		HoTen = new JTextField();
		HoTen.setBackground(new Color(245, 245, 245));
		HoTen.setColumns(10);
		HoTen.setBounds(106, 75, 151, 31);
		panel_ThongTin.add(HoTen);
		
		BoMon = new JTextField();
		BoMon.setBackground(new Color(245, 245, 245));
		BoMon.setColumns(10);
		BoMon.setBounds(410, 75, 151, 31);
		panel_ThongTin.add(BoMon);
		
		Khoa = new JTextField();
		Khoa.setBackground(new Color(245, 245, 245));
		Khoa.setColumns(10);
		Khoa.setBounds(410, 29, 151, 31);
		panel_ThongTin.add(Khoa);
		
		SDT = new JTextField();
		SDT.setBackground(new Color(245, 245, 245));
		SDT.setColumns(10);
		SDT.setBounds(743, 29, 151, 31);
		panel_ThongTin.add(SDT);
		
		Email = new JTextField();
		Email.setBackground(new Color(245, 245, 245));
		Email.setColumns(10);
		Email.setBounds(743, 75, 151, 31);
		panel_ThongTin.add(Email);
		
		label_MaGV = new JLabel("X");
		label_MaGV.setHorizontalAlignment(SwingConstants.CENTER);
		label_MaGV.setForeground(Color.RED);
		label_MaGV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_MaGV.setBounds(258, 28, 20, 29);
		panel_ThongTin.add(label_MaGV);
		
		label_HoTen = new JLabel("X");
		label_HoTen.setHorizontalAlignment(SwingConstants.CENTER);
		label_HoTen.setForeground(Color.RED);
		label_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoTen.setBounds(258, 74, 20, 29);
		panel_ThongTin.add(label_HoTen);
		
		label_BoMon = new JLabel("X");
		label_BoMon.setHorizontalAlignment(SwingConstants.CENTER);
		label_BoMon.setForeground(Color.RED);
		label_BoMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_BoMon.setBounds(564, 75, 20, 29);
		panel_ThongTin.add(label_BoMon);
		
		label_Khoa = new JLabel("X");
		label_Khoa.setForeground(Color.RED);
		label_Khoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Khoa.setBounds(571, 28, 20, 29);
		panel_ThongTin.add(label_Khoa);
		
		label_SDT = new JLabel("X");
		label_SDT.setHorizontalAlignment(SwingConstants.CENTER);
		label_SDT.setForeground(Color.RED);
		label_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_SDT.setBounds(895, 28, 20, 29);
		panel_ThongTin.add(label_SDT);
		
		label_Email = new JLabel("X");
		label_Email.setHorizontalAlignment(SwingConstants.CENTER);
		label_Email.setForeground(Color.RED);
		label_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Email.setBounds(895, 75, 20, 29);
		panel_ThongTin.add(label_Email);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBackground(new Color(255, 255, 255));
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh S\u00E1ch ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DanhSach.setBounds(10, 162, 952, 576);
		getContentPane().add(panel_DanhSach);
		panel_DanhSach.setLayout(null);
		
		JScrollPane scrollPane_Table = new JScrollPane();
		scrollPane_Table.setBounds(10, 22, 932, 544);
		panel_DanhSach.add(scrollPane_Table);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				setText(GVList.get(index));
				
			}
		});
		table.setFont(new Font("Calibri", Font.PLAIN, 15));
		scrollPane_Table.setViewportView(table);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(972, 10, 192, 728);
		getContentPane().add(panel);
		panel.setLayout(null);
		JButton buttom_TimKiem = new JButton("Tìm Kiếm");
		buttom_TimKiem.setForeground(new Color(255, 255, 255));
		buttom_TimKiem.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/search.png")));
		buttom_TimKiem.setBackground(new Color(65,49,102));
		buttom_TimKiem.setBounds(10, 10, 172, 40);
		panel.add(buttom_TimKiem);
		buttom_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				TimKiemGiangVien TK = new TimKiemGiangVien();
				TK.setVisible(true);
				
			}
		});
		buttom_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnSpXp = new JButton("Sắp Xếp");
		btnSpXp.setForeground(new Color(255, 255, 255));
		btnSpXp.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/sort.png")));
		btnSpXp.setBackground(new Color(65,49,102));
		btnSpXp.setBounds(10, 60, 172, 40);
		panel.add(btnSpXp);
		btnSpXp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SapXepGiangVien SX = new SapXepGiangVien();
				SX.setVisible(true);
			}
		});
		btnSpXp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttom_Them = new JButton("Thêm");
		buttom_Them.setForeground(new Color(255, 255, 255));
		buttom_Them.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/insert.png")));
		buttom_Them.setBackground(new Color(65,49,102));
		buttom_Them.setBounds(10, 163, 172, 40);
		panel.add(buttom_Them);
		buttom_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible_false();
				if(standardInput()==true)
				{
					GiangVien gv = setGiangVien();
					if (GiangVien_modify.exists.get(gv.getMaGV())!=null) {						
						label_MaGV.setVisible(true);
						JOptionPane.showMessageDialog(null, "Mã Giảng Viên Đã Tồn Tại !");
					} else {
						if (GiangVien_modify.insert(gv)==true) {
						GVList.add(gv);
						showGiangVien(GVList);
						reset();
						JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
						}
						else JOptionPane.showMessageDialog(null, "Thêm Không Thành  Công!");
					}
				}
				
			}
		});
		buttom_Them.setFont(new Font("Calibri", Font.PLAIN, 20));
		buttom_Sua = new JButton("Sửa");
		buttom_Sua.setForeground(new Color(255, 255, 255));
		buttom_Sua.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/edit.png")));
		buttom_Sua.setBackground(new Color(65,49,102));
		buttom_Sua.setBounds(10, 214, 172, 40);
		panel.add(buttom_Sua);
		buttom_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible_false();
				int index = table.getSelectedRow();
				if (GVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng!");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng");
				} else {
					if (standardInput()) {
						GiangVien gv = setGiangVien();
						GVList.remove(index);
						if(Integer.parseInt(MaGV.getText()) != gv.getMaGV()) {
							JOptionPane.showMessageDialog(null, "Không thể sửa mã giảng viên");
						}else {
							GiangVien_modify.update(gv);
							GVList.add(index, gv);
							showGiangVien(GVList);
							reset();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công!");
						}			
					}
				}
			}
		});
		buttom_Sua.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		buttom_Xoa = new JButton("Xóa");
		buttom_Xoa.setForeground(new Color(255, 255, 255));
		buttom_Xoa.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/delete.png")));
		buttom_Xoa.setBackground(new Color(65,49,102));
		buttom_Xoa.setBounds(10, 265, 172, 40);
		panel.add(buttom_Xoa);
		buttom_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible_false();
				int index = table.getSelectedRow();
				if (GVList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Bảng Chưa Có Đối Tượng !");
				} else if (index == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Đối Tượng Trong Bảng !");
				} else {
					GiangVien gv = GVList.get(index);
					GiangVien_modify.delete(String.valueOf(gv.getMaGV()));
					GVList.remove(index);
					GiangVien_modify.exists.remove(gv.getMaGV());
					showGiangVien(GVList);
					
					reset();
					JOptionPane.showMessageDialog(null, "Xóa Thành Công !");

				}
			}
		});
		buttom_Xoa.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnXutExcel = new JButton("File Excel");
		btnXutExcel.setForeground(new Color(255, 255, 255));
		btnXutExcel.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/export.png")));
		btnXutExcel.setBackground(new Color(65,49,102));
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String linkfile = "";
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isDirectory()) {
						linkfile = (jfc.getSelectedFile() + "/" + "Danh_Sach_Giang_Vien.xlsx");

						try {
							writerExcel.ghiFileExcelGV(linkfile, GVList);

						} catch (IOException ex) {
							JOptionPane.showMessageDialog(null, ex);
						}
						JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
					}
				}

			}
		});
		btnXutExcel.setBounds(10, 628, 172, 40);
		panel.add(btnXutExcel);
		btnXutExcel.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton buttom_Thoat = new JButton("Làm Mới");
		buttom_Thoat.setForeground(new Color(255, 255, 255));
		buttom_Thoat.setIcon(new ImageIcon(QLGiangVien.class.getResource("/buttonImages/refresh.png")));
		buttom_Thoat.setBackground(new Color(65,49,102));
		buttom_Thoat.setBounds(10, 678, 172, 40);
		panel.add(buttom_Thoat);
		buttom_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GVList =GiangVien_modify.findAll();
				showGiangVien(GVList); 
			}
		});
		buttom_Thoat.setFont(new Font("Calibri", Font.PLAIN, 20));
		if(kt==0) insertColumn();
		
		showGiangVien(GVList);
		setVisible_false();
		isPermission();
	}
	
	
	private void  insertColumn()
	{
		
		kt=1;
		model.addColumn("MaGV");
		model.addColumn("Họ & Tên ");
		model.addColumn("Khoa");
		model.addColumn("Bộ Môn");
		model.addColumn("SDT");
		model.addColumn("Email");
		
		
	}
	public static void  showGiangVien(List<GiangVien> giangvienList) {
	
		model.setRowCount(0);
		for (GiangVien gv : giangvienList) {
			model.addRow(new Object[] {gv.getMaGV() ,gv.getHoTen() , gv.getKhoa() , gv.getBoMon() , 
					gv.getSDT() ,gv.getEmail() });
		}
		table.setModel(model);
		
	}
	

	private void reset() {
		
		MaGV.setText("");
		HoTen.setText("");
		BoMon.setText("");
		Khoa.setText("");
		SDT.setText("");
		Email.setText("");
	}
	private void setText(GiangVien gv)
	{
	   MaGV.setText(String.valueOf(gv.getMaGV()));
	    HoTen.setText(gv.getHoTen());
	    BoMon.setText(gv.getBoMon());
	    Khoa.setText(gv.getKhoa());
	    SDT.setText(gv.getSDT());
	    Email.setText(gv.getEmail());
	}
	
	private GiangVien setGiangVien()
	{ 
		GiangVien gv = new GiangVien();
		gv.setMaGV(Integer.valueOf(MaGV.getText()));
		gv.setHoTen(StandardOutput.formatString(HoTen.getText()));
		gv.setBoMon(StandardOutput.formatString(BoMon.getText()));
		gv.setKhoa(StandardOutput.formatString(Khoa.getText()));
		gv.setSDT(SDT.getText());
		gv.setEmail(Email.getText());
		return gv; 
	}

	private boolean standardInput() {

		if(! MaGV.getText().equals("") && !HoTen.getText().equals("")  && ! Khoa.getText().equals("")
		&& !BoMon.getText().equals("")&& !SDT.getText().equals("")&& !Email.getText().equals(""))
			
			if(check_data.StandardInput.isNumber(MaGV.getText())==true
			&& check_data.StandardInput.checkName(HoTen.getText()) ==true
			&& check_data.StandardInput.checkText(BoMon.getText())==true
			&& check_data.StandardInput.checkName(Khoa.getText())==true
			&& check_data.StandardInput.checkPhonenumber(SDT.getText())==true
			&& check_data.StandardInput.checkEmail(Email.getText())==true
			)
			{
				setVisible_false();
				return true;
			}
			else {
				
				if(check_data.StandardInput.isNumber(MaGV.getText())==false) label_MaGV.setVisible(true);
				if(check_data.StandardInput.checkName(HoTen.getText())==false) label_HoTen.setVisible(true);
				if(check_data.StandardInput.checkText(BoMon.getText())==false) label_BoMon.setVisible(true);
				if (check_data.StandardInput.checkName(Khoa.getText())==false) label_Khoa.setVisible(true);
				if(check_data.StandardInput.checkPhonenumber(SDT.getText())==false) label_SDT.setVisible(true);
				if(check_data.StandardInput.checkEmail(Email.getText())==false) label_Email.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Nhập Thông Tin Chưa Đúng  !");
				return false ;
			}
		
		else
		{
			if( MaGV.getText().equals(""))label_MaGV.setVisible(true);
			else if(check_data.StandardInput.isNumber(MaGV.getText())==false) label_MaGV.setVisible(true);
			if(!MaGV.getText().equals("") && GiangVien_modify.exists.get(Integer.parseInt(MaGV.getText()))!=null) {
				int index = table.getSelectedRow();
				GiangVien std = GVList.get(index);
				if(Integer.parseInt(MaGV.getText()) == std.getMaGV()) {
					label_MaGV.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Mã Giảng Viên Tồn Tại");
					label_MaGV.setVisible(true);
				}
			}
			if(HoTen.getText().equals("")) label_HoTen.setVisible(true);
			else if(check_data.StandardInput.checkName(HoTen.getText())==false) label_HoTen.setVisible(true);
			
			if(Khoa.getText().equals("")) label_Khoa.setVisible(true);
			else if (check_data.StandardInput.checkName(Khoa.getText())==false) label_Khoa.setVisible(true);
			
			if(BoMon.getText().equals("")) label_BoMon.setVisible(true);
			else if(check_data.StandardInput.checkText(BoMon.getText())==false) label_BoMon.setVisible(true);
			
			if(SDT.getText().equals("")) label_SDT.setVisible(true);
			if(check_data.StandardInput.checkPhonenumber(SDT.getText())==false) label_SDT.setVisible(true);
			
			if(Email.getText().equals("")) label_Email.setVisible(true);
				if(check_data.StandardInput.checkEmail(Email.getText())==false) label_Email.setVisible(true);
				
			JOptionPane.showMessageDialog(null, "Nhập Thiếu Thông Tin !");
			return false ;
		}
	}
	
	private void setVisible_false()
	{
		label_HoTen.setVisible(false);
		label_MaGV.setVisible(false);
		label_BoMon.setVisible(false);
		label_Khoa.setVisible(false);
		label_SDT.setVisible(false);
		label_Email.setVisible(false);
	}
	
	
	private void isPermission() throws IOException, SQLException {
		if(AdminModify.getPer(Login.userNameTxt.getText()).equals("nguoidung")) {
			buttom_Them.setVisible(false);
			buttom_Sua.setVisible(false);
			buttom_Xoa.setVisible(false);
		}
	}
	
}
