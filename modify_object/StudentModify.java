package modify_object;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import data_config.ReadData;
import object_frame.Student;

public class StudentModify {
	public static Map<String, Boolean> exists = new HashMap<String, Boolean>();

	public static List<Student> findAll() {
		// lay tat ca danh sach sinh vien
		List<Student> studentList = new ArrayList<Student>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from SinhVien";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Student std = new Student(resultSet.getString("MSV"), resultSet.getString("Ho"),
						resultSet.getString("Ten"), resultSet.getString("CMND"), resultSet.getString("NgaySinh"),
						resultSet.getString("QueQuan"), resultSet.getString("GioiTinh"),
						resultSet.getString("NgayVaoDoan"), resultSet.getString("NgayVaoDang"),
						resultSet.getString("DienThoai"), resultSet.getString("Email"), resultSet.getInt("MaChiDoan"),
						resultSet.getString("ChucVu"), resultSet.getString("TonGia"), resultSet.getString("DanToc"),
						resultSet.getString("NoiSinh"), resultSet.getString("DiaChiHienTai"),
						resultSet.getString("NangKhieu"), resultSet.getString("HoanCanhGiaDinh"),
						resultSet.getString("GhiChu"), resultSet.getBytes("Avatar"), resultSet.getFloat("DiemTichLuy"));
				studentList.add(std);
				exists.put(std.getMaSV(), true);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Loi Config");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
				}
			}
		}
		// ket thuc
		return studentList;
	}

	public static void insert(Student std) {
		List<Student> studentList = new ArrayList<Student>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "insert into SinhVien"
					+ "(MSV,Ho,Ten,CMND ,NgaySinh,QueQuan,GioiTinh,NgayVaoDoan,NgayVaoDang,DienThoai,Email,MaChiDoan,ChucVu,TonGia,DanToc,NoiSinh,DiaChiHienTai,NangKhieu,HoanCanhGiaDinh,GhiChu,Avatar,DiemTichLuy)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareCall(sql);

			statement.setString(1, std.getMaSV());
			statement.setString(2, std.getHo());
			statement.setString(3, std.getTen());
			statement.setString(4, std.getCMND());
			statement.setString(5, std.getNgSinh());
			statement.setString(6, std.getQueQuan());
			statement.setString(7, std.getGioiTinh());
			statement.setString(8, std.getNgVaoDoan());
			statement.setString(9, std.getNgVaoDang());
			statement.setString(10, std.getDienThoai());
			statement.setString(11, std.getEmail());
			statement.setInt(12, std.getMaChiDoan());
			statement.setString(13, std.getChucVu());
			statement.setString(14, std.getTonGiao());
			statement.setString(15, std.getDanToc());
			statement.setString(16, std.getNoiSinh());
			statement.setString(17, std.getDiaChiHT());
			statement.setString(18, std.getNangKhieu());
			statement.setString(19, std.getHoanCanhGD());
			statement.setString(20, std.getGhiChu());
			statement.setBytes(21, std.getAvatar());
			statement.setFloat(22, std.getDiemTL());

			statement.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Loi Config");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
				}
			}
		}
		// ket thuc

	}

	public static void update(Student std) {
		List<Student> studentList = new ArrayList<Student>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "update SinhVien set"
					+ " Ho=?,Ten=?,CMND=? ,NgaySinh=?,QueQuan=?,GioiTinh=?,NgayVaoDoan=?,NgayVaoDang=?,DienThoai=?,Email=?,MaChiDoan=?,ChucVu=?,TonGia=?,DanToc=?,NoiSinh=?,DiaChiHienTai=?,NangKhieu=?,HoanCanhGiaDinh=?,GhiChu=?,Avatar=?,DiemTichLuy=? where MSV=?";
			statement = connection.prepareCall(sql);

			statement.setString(1, std.getHo());
			statement.setString(2, std.getTen());
			statement.setString(3, std.getCMND());
			statement.setString(4, std.getNgSinh());
			statement.setString(5, std.getQueQuan());
			statement.setString(6, std.getGioiTinh());
			statement.setString(7, std.getNgVaoDoan());
			statement.setString(8, std.getNgVaoDang());
			statement.setString(9, std.getDienThoai());
			statement.setString(10, std.getEmail());
			statement.setInt(11, std.getMaChiDoan());
			statement.setString(12, std.getChucVu());
			statement.setString(13, std.getTonGiao());
			statement.setString(14, std.getDanToc());
			statement.setString(15, std.getNoiSinh());
			statement.setString(16, std.getDiaChiHT());
			statement.setString(17, std.getNangKhieu());
			statement.setString(18, std.getHoanCanhGD());
			statement.setString(19, std.getGhiChu());
			statement.setBytes(20, std.getAvatar());
			statement.setFloat(21, std.getDiemTL());
			statement.setString(22, std.getMaSV());

			statement.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Loi Config");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
				}
			}

			if (connection != null) {
				try {

					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
				}
			}
		}
		// ket thuc

	}

	public static void delete(String MaSV) {
		List<Student> studentList = new ArrayList<Student>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from SinhVien where MSV=?";

			statement = connection.prepareCall(sql);

			statement.setString(1, MaSV);
			statement.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Loi Config");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
				}
			}
		}
		// ket thuc

	}

	public static List<Student> search(String MaSV, String ChiDoan,String TenSV) {
		// lay tat ca danh sach sinh vien
		List<Student> studentList = new ArrayList<Student>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if(!MaSV.equals("") && ChiDoan.equals("0")&& TenSV.equals("")) {
				String sql="select * from SinhVien where MSV like ?";
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + MaSV + "%");
			}
			
			else if(MaSV.equals("") && !ChiDoan.equals("0")&& TenSV.equals("")) {
				String sql="select * from SinhVien where MaChiDoan = ?";
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1,ChiDoan);
			}
			
			else if(MaSV.equals("") && ChiDoan.equals("0")&& !TenSV.equals("")) {
				String sql="select * from SinhVien where Ten like ?";
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + TenSV + "%");
			}
						
			else if (!MaSV.equals("") && !ChiDoan.equals("0")&&TenSV.equals("")) {
				String sql = "select * from SinhVien where MSV like ? and MaChiDoan=?";
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + MaSV + "%");
				statement.setInt(2, Integer.parseInt(ChiDoan));
			}
			else if (!MaSV.equals("") && ChiDoan.equals("0")&&!TenSV.equals("")) {
				String sql = "select * from SinhVien where MSV like ? and Ten like ?";
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + MaSV + "%");
				statement.setString(2, "%" + TenSV + "%");
			}
			else if (MaSV.equals("") && !ChiDoan.equals("0")&& !TenSV.equals("")) {
				String sql = "select * from SinhVien where Ten like ? and MaChiDoan=?" ;
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + TenSV+ "%");
				statement.setInt(2, Integer.parseInt(ChiDoan));
			}
			
			else if (!MaSV.equals("") && !ChiDoan.equals("0")&& !TenSV.equals("")) {
				String sql = "select * from SinhVien where Ten like ? and MaChiDoan=? and MSV like ?" ;
				statement = connection.prepareCall(sql);// lay du lieu tu database
				statement.setString(1, "%" + TenSV+ "%");
				statement.setInt(2, Integer.parseInt(ChiDoan));
				statement.setString(3, "%" + MaSV + "%");
			}
			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Student std = new Student(resultSet.getString("MSV"), resultSet.getString("Ho"),
						resultSet.getString("Ten"), resultSet.getString("CMND"), resultSet.getString("NgaySinh"),
						resultSet.getString("QueQuan"), resultSet.getString("GioiTinh"),
						resultSet.getString("NgayVaoDoan"), resultSet.getString("NgayVaoDang"),
						resultSet.getString("DienThoai"), resultSet.getString("Email"), resultSet.getInt("MaChiDoan"),
						resultSet.getString("ChucVu"), resultSet.getString("TonGia"), resultSet.getString("DanToc"),
						resultSet.getString("NoiSinh"), resultSet.getString("DiaChiHienTai"),
						resultSet.getString("NangKhieu"), resultSet.getString("HoanCanhGiaDinh"),
						resultSet.getString("GhiChu"), resultSet.getBytes("Avatar"), resultSet.getFloat("DiemTichLuy"));
				studentList.add(std);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Loi Config");
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
				}
			}
		}
		// ket thuc
		return studentList;
	}
	
	public static boolean checkExist(String username, String password) throws IOException, SQLException {
		Map<String,String> config = ReadData.readDataFromFile();
		String query = "select count(*) as res from DangNhap where Username=? and password=?";
		try (Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query);
						) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("res") > 0 ? true : false;
			}
		}
		return false;
	}
	
	public static void changePassword(String username, String password, String newPassword) throws IOException, SQLException {
		Map<String,String> config = ReadData.readDataFromFile();
		String query = "update DangNhap set password = ? where Username = ? and password = ?";
		try (Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query);
						) {
			stmt.setString(1, newPassword);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.execute();
		}
	}

}
