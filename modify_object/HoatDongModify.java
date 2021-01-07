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
import object_frame.HoatDong;


public class HoatDongModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<HoatDong> findAll() {
		// lay tat ca danh sach hoat dong
		List<HoatDong> hoatDongList = new ArrayList<HoatDong>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "SELECT * FROM HoatDong";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				HoatDong std = new HoatDong
				(
					resultSet.getInt("MaHoatDong"), 
					resultSet.getString("TenHoatDong"),
					resultSet.getString("LoaiHoatDong"),
					resultSet.getString("ThoiGian"),
					resultSet.getString("ThongTinChiTiet"),
					resultSet.getString("DonViToChuc")
				);
				
				exists.put(std.getMaHoatDong(), true);
				hoatDongList.add(std);
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
		return hoatDongList;
	}

	public static void insert(HoatDong hd) {
		List<HoatDong> hoatDongList = new ArrayList<HoatDong>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "insert into HoatDong"
					+ "(MaHoatDong,TenHoatDong,LoaiHoatDong,ThoiGian,ThongTinChiTiet,DonViToChuc)"
					+ "values(?,?,?,?,?,?)";
			statement = connection.prepareCall(sql);

			statement.setInt(1, hd.getMaHoatDong());
			statement.setString(2, hd.getTenHoatDong());
			statement.setString(3, hd.getLoaiHoatDong());
			statement.setString(4, hd.getThoiGian());
			statement.setString(5, hd.getThongTinChiTiet());
			statement.setString(6, hd.getDonViToChuc());

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

	}

	public static void update(HoatDong hd) {
		List<HoatDong> hoatDongList = new ArrayList<HoatDong>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			String sql = "UPDATE HoatDong SET TenHoatDong=?,LoaiHoatDong=?,ThoiGian=?,ThongTinChiTiet=?,DonViToChuc=? where MaHoatDong=?";
			statement = connection.prepareCall(sql);
			
			
			statement.setString(1, hd.getTenHoatDong());
			statement.setString(2, hd.getLoaiHoatDong());
			statement.setString(3, hd.getThoiGian());
			statement.setString(4, hd.getThongTinChiTiet());
			statement.setString(5, hd.getDonViToChuc());
			statement.setInt(6, hd.getMaHoatDong());
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

	}
	
	public static void delete(int MaHoatDong) {
		List<HoatDong> hoatDongList = new ArrayList<HoatDong>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from HoatDong where MaHoatDong=?";

			statement = connection.prepareCall(sql);

			statement.setInt(1, MaHoatDong);
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

	}
	
	public static List<HoatDong> search(String MaHoatDong, String TenHoatDong) {
	/*
	 * lấy danh sách hoạt động
	 */
	List<HoatDong> hoatDongList = new ArrayList<HoatDong>();

	Connection connection = null;
	PreparedStatement statement = null;
	try {
		Map<String, String> config = ReadData.readDataFromFile();
		connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
				config.get("DB_PASSWORD"));
		// query
		if (!MaHoatDong.equals("") && TenHoatDong.equals("")) {
			String sql = "select * from HoatDong where MaHoatDong = ?";
			statement = connection.prepareCall(sql);// lay du lieu tu database
			statement.setInt(1, Integer.parseInt(MaHoatDong));
		} else if (MaHoatDong.equals("") && !TenHoatDong.equals("")) {
			String sql = "select * from HoatDong where TenHoatDong like ?";
			statement = connection.prepareCall(sql);// lay du lieu tu database
			statement.setString(1, "%" + TenHoatDong + "%");
		} else if (!MaHoatDong.equals("") && !TenHoatDong.equals("")) {
			String sql = "select * from HoatDong where MaHoatDong = ? and TenHoatDong like ?";
			statement = connection.prepareCall(sql);// lay du lieu tu database
			statement.setInt(1, Integer.parseInt(MaHoatDong));
			statement.setString(2, "%" + TenHoatDong + "%");
		}

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			HoatDong std = new HoatDong
					(resultSet.getInt("MaHoatDong"), 
					resultSet.getString("TenHoatDong"),
					resultSet.getString("LoaiHoatDong"),
					resultSet.getString("ThoiGian"),
					resultSet.getString("ThongTinChiTiet"),
					resultSet.getString("DonViToChuc"));
			hoatDongList.add(std);

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
	return hoatDongList;
}
}
