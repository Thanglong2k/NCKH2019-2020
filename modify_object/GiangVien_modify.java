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
import javax.swing.text.Segment;


import data_config.ReadData;
import object_frame.DanhGiaRLSV;
import object_frame.GiangVien;
import object_frame.Student;

public class GiangVien_modify {
		
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<GiangVien >findAll() {
		// lay tat ca danh sach hoat dong
		List<GiangVien> giangvienList = new ArrayList<GiangVien>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from GiangVien";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				GiangVien gv = new GiangVien(
						resultSet.getInt("MaGV"),
						resultSet.getString("HoTen"),
						resultSet.getString("BoMon"),
						resultSet.getString("Khoa"),
						
						resultSet.getString("SDT"),
						resultSet.getString("Email"));
				giangvienList.add(gv);
				
				exists.put(gv.getMaGV(), true);
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
					JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Statement");
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Connection");
				}
			}
		}
		// ket thuc
		return giangvienList;
	}
		//-------------------------------------------------------------------------------------------------------------------------//
		public static boolean insert(GiangVien gv) {
			List<GiangVien> giangvienList = new ArrayList<GiangVien>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "insert into GiangVien"
						+ "(MaGv , HoTen, BoMon , Khoa , SDT , Email )"
						+ "values(?,?,?,?,?,?)";
				statement = connection.prepareCall(sql);

				statement.setLong(1, gv.getMaGV());
				statement.setString(2, gv.getHoTen());
				statement.setString(3, gv.getBoMon());
				statement.setNString(4, gv.getKhoa());
				statement.setString(5, gv.getSDT());
				statement.setNString(6, gv.getEmail());
				
			
				statement.execute();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				return false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Loi Config");
				e.printStackTrace();
				return false;
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Statement");
						return false;
					}
				}

				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						
						JOptionPane.showMessageDialog(null, "Khong The Dong Ket Noi Conection");
						return false;
					}
				}
			}
			// ket thuc
			return true ;

		}


		public static boolean update(GiangVien gv) {
			List<GiangVien> giangvienList = new ArrayList<GiangVien>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {

				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "update GiangVien set HoTen =? ,BoMon=? ,Khoa=?,SDT=?,Email=? where MaGV = ?";
				statement = connection.prepareCall(sql);

				
				statement.setString(1, gv.getHoTen());
				statement.setString(2, gv.getBoMon());
				statement.setString(3, gv.getKhoa());
				statement.setString(4, gv.getSDT());
				statement.setString(5, gv.getEmail());
				statement.setInt(6, gv.getMaGV());
				

				statement.execute();
				



			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				return false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Loi Config");
				return false;
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Statement");
						return false;
					}
				}
				if (connection != null) {
					try {

						connection.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Connection");
						return false;
					}
				}
			}
			// ket thuc
			return true ;

		}



		public static void delete(String MaGV) {
			List<GiangVien> chidoanList = new ArrayList<GiangVien>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "delete from GiangVien where MaGV=?";

				statement = connection.prepareCall(sql);

				statement.setInt(1, Integer.parseInt(MaGV));
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

		
	

		public static List<GiangVien> search(String HoTen, String Khoa,String BoMon) {
			List<GiangVien> giangvienList = new ArrayList<GiangVien>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				if(HoTen.equals("") && Khoa.equals("") && BoMon.equals(""))
				{
					findAll();
				}
				else if(!HoTen.equals("") && !Khoa.equals("") && !BoMon.equals(""))
				{
					String sql = "select * from GiangVien where HoTen like ? and Khoa like? and  BoMon like ? ";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + HoTen + "%");
					statement.setString(2, "%" + Khoa + "%");
					statement.setString(3, "%" + BoMon + "%");
				}
				else if(!HoTen.equals("") &&! Khoa.equals("") && BoMon.equals(""))
				{
					String sql = "select * from GiangVien where HoTen like ? and Khoa like ?";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + HoTen + "%");
					statement.setString(2, "%" + Khoa + "%");
					
				}
				else if(!HoTen.equals("") && Khoa.equals("") && !BoMon.equals(""))
				{
					String sql = "select * from GiangVien where HoTen like ? and BoMon like ? ";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + HoTen + "%");
					statement.setString(2, "%" + BoMon + "%");
				}
				
				
				else if(!HoTen.equals("") && Khoa.equals("") && BoMon.equals(""))
				{
					String sql = "select * from GiangVien where HoTen like ? ";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + HoTen + "%");
				}
				
				else if(HoTen.equals("") && !Khoa.equals("") && !BoMon.equals(""))
				{
					String sql = "select * from GiangVien where Khoa like ? and  BoMon like ? ";
					statement = connection.prepareCall(sql);
					
					statement.setString(1, "%" + Khoa + "%");
					statement.setString(2, "%" + BoMon + "%");
				}
				
				else if(HoTen.equals("") && Khoa.equals("") &&! BoMon.equals(""))
				{
					String sql = "select * from GiangVien where BoMon like ? ";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + BoMon + "%") ;
				}
				else if(HoTen.equals("") && !Khoa.equals("") && BoMon.equals(""))
				{
					String sql = "select * from GiangVien where Khoa like ? ";
					statement = connection.prepareCall(sql);
					statement.setString(1, "%" + Khoa + "%");
				}
				
				
			
		
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					GiangVien gv = new GiangVien(
							resultSet.getInt("MaGV"),
							resultSet.getString("HoTen"),
							resultSet.getString("BoMon"),
							resultSet.getString("Khoa"),
							
							resultSet.getString("SDT"),
							resultSet.getString("Email"));
					giangvienList.add(gv);
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
						JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Statement");
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Không Thể Đóng Kết Nối Connection");
					}
				}
			}
			return giangvienList;
		}
		
}

