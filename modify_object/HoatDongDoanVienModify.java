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
import object_frame.HoatDongDoanVien;

public class HoatDongDoanVienModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();
	public static List<HoatDongDoanVien> findAll() {
		// lay tat ca danh sach hoat dong-doan vien
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();
		
		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from DoanVien_HoatDong";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				HoatDongDoanVien std = new HoatDongDoanVien
						(resultSet.getInt("ID"), 
						resultSet.getString("MSV"),
						resultSet.getInt("MaHoatDong"), 
						resultSet.getBytes("AnhMinhChung"),
						resultSet.getString("ThanhTich"));
				
				exists.put(std.getID(), true);
				HoatDongDoanVienList.add(std);
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
		return HoatDongDoanVienList;
	}

	public static void insert(HoatDongDoanVien hd) throws IOException, SQLException {
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();
		Map<String, String> config = ReadData.readDataFromFile();
		Connection connection = null;
		String sql = "insert into DoanVien_HoatDong"
				+ "(ID,MSV,MaHoatDong,AnhMinhChung,ThanhTich)"
				+ "values(?,?,?,?,?)";
		try ( Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
				config.get("DB_PASSWORD"));
				PreparedStatement statement = conn.prepareCall(sql);
				) {
			 
			// query
			statement.setInt(1, hd.getID());
			statement.setString(2, hd.getMaSV());
			statement.setInt(3, hd.getMaHoatDong());
			statement.setBytes(4, hd.getAnhMinhChung());
			statement.setString(5, hd.getThanhTich());
			statement.execute();
		} 
	}

	public static void update(HoatDongDoanVien hd) {
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "update DoanVien_HoatDong set" + 
			" MSV=?,MaHoatDong=?,AnhMinhChung=?,ThanhTich=? where ID=?";
			statement = connection.prepareCall(sql);

			statement.setString(1, hd.getMaSV());
			statement.setInt(2, hd.getMaHoatDong());
			statement.setBytes(3, hd.getAnhMinhChung());
			statement.setString(4, hd.getThanhTich());
			statement.setInt(5, hd.getID());
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
	
	
	public static void delete(int ID) {
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from DoanVien_HoatDong where ID=?";

			statement = connection.prepareCall(sql);

			statement.setInt(1, ID);
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
	public static void deleteMHD(int MHD) {
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from DoanVien_HoatDong where MaHoatDong=?";

			statement = connection.prepareCall(sql);

			statement.setInt(1, MHD);
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
	
	public static void deleteMSV(String msv) {
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from DoanVien_HoatDong where MSV like ?";

			statement = connection.prepareCall(sql);

			statement.setString(1,msv);
			statement.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println(e.getMessage());
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
	
	public static List<HoatDongDoanVien> search(String MaSV, String MaHoatDong) {
		// lay tat ca danh sach sinh vien
		List<HoatDongDoanVien> HoatDongDoanVienList = new ArrayList<HoatDongDoanVien>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if (!MaSV.equals("") && !MaHoatDong.equals("")) {
				String sql = "select * from DoanVien_HoatDong where MSV like ? and MaHoatDong=?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV + "%");
				statement.setInt(2, Integer.parseInt(MaHoatDong));
			} else if (MaSV.equals("") && !MaHoatDong.equals("")) {
				String sql = "select * from DoanVien_HoatDong where MaHoatDong=?";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaHoatDong));
			} else if (!MaSV.equals("") && MaHoatDong.equals("")) {
				String sql = "select * from DoanVien_HoatDong where MSV like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV + "%");
			}

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HoatDongDoanVien std = new HoatDongDoanVien(
						resultSet.getInt("ID"), 
						resultSet.getString("MSV"),
						resultSet.getInt("MaHoatDong"), 
						resultSet.getBytes("AnhMinhChung"),
						resultSet.getString("ThanhTich"));
				HoatDongDoanVienList.add(std);

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
		return HoatDongDoanVienList;
	}
}
