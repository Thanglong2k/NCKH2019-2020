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
import object_frame.XepLoaiDV;

public class XepLoaiDoanVienModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<XepLoaiDV> findAll() {
		// lay tat ca danh sach hoat dong
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from XepLoaiDoanVien";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				XepLoaiDV std = new XepLoaiDV(resultSet.getInt("MaDG"), resultSet.getString("MSV"),
						resultSet.getString("XepLoai"), resultSet.getString("GhiChu"));
				XepLoaiDoanVienList.add(std);
				exists.put(std.getMaDG(), true);
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
		return XepLoaiDoanVienList;
	}

	public static void insert(XepLoaiDV hd) {
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			//String sql = "insert into XepLoaiDoanVien" + "(MaDG,MSV,XepLoai,GhiChu)" + "values(?,?,?,?)";
			String sql = "INSERT INTO XepLoaiDoanVien (MaDG,MSV,XepLoai,GhiChu) VALUES (?,?,?,?)";
			statement = connection.prepareCall(sql);

			statement.setInt(1, hd.getMaDG());
			statement.setString(2, hd.getMaSV());
			statement.setString(3, hd.getXepLoai());
			statement.setString(4, hd.getGhiChu());

			statement.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println(e.getMessage());
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

	public static void update(XepLoaiDV hd) {
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "update XepLoaiDoanVien set" + " MSV=?,XepLoai=?,GhiChu=? where MaDG=?";
			statement = connection.prepareCall(sql);

			
			statement.setString(1, hd.getMaSV());
			statement.setString(2, hd.getXepLoai());
			statement.setString(3, hd.getGhiChu());
			statement.setInt(4, hd.getMaDG());
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

	public static void delete(int MaDG,String msv) {
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "DELETE from XepLoaiDoanVien where MaDG=? and MSV like ?";

			statement = connection.prepareCall(sql);
			statement.setInt(1, MaDG);
			statement.setString(2,msv);
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
	
	public static void deleteMSV(String msv) {
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "DELETE from XepLoaiDoanVien where MSV like ?";

			statement = connection.prepareCall(sql);

			statement.setString(1, msv);
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
	public static List<XepLoaiDV> search(String MaDG, String MaSV,String XepLoai) {
		// lay tat ca danh sach sinh vien
		List<XepLoaiDV> XepLoaiDoanVienList = new ArrayList<XepLoaiDV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if(!MaDG.equals("") && MaSV.equals("") && XepLoai.equals("")) {
				String sql="select * from XepLoaiDoanVien where MaDG = ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaDG));
			}
			
			else if(MaDG.equals("") && !MaSV.equals("")&& XepLoai.equals("")) {
				String sql="select * from XepLoaiDoanVien where MSV like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV + "%");
			}
			
			else if(MaDG.equals("") && MaSV.equals("")&& !XepLoai.equals("")) {
				String sql="select * from XepLoaiDoanVien where XepLoai like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + XepLoai + "%");
			}
						
			else if (!MaDG.equals("") && !MaSV.equals("") && XepLoai.equals("")) {
				String sql = "select * from XepLoaiDoanVien where MSV like ? and MaDG=?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV + "%");
				statement.setInt(2, Integer.parseInt(MaDG));
			}
			else if (!MaDG.equals("") && MaSV.equals("") && !XepLoai.equals("")) {
				String sql = "select * from XepLoaiDoanVien where MaDG = ? and XepLoai like ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaDG));
				statement.setString(2, "%" + XepLoai + "%");
			}
			else if (MaDG.equals("") && !MaSV.equals("") && !XepLoai.equals("")) {
				String sql = "select * from XepLoaiDoanVien where MSV like ? and XepLoai like ?" ;
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV+ "%");
				statement.setString(2, "%" + XepLoai+ "%");
			}
			else if (!MaDG.equals("") && !MaSV.equals("")&& !XepLoai.equals("")) {
				String sql = "select * from XepLoaiDoanVien where MSV like ? and MaDG=? and XepLoai like ?" ;
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MaSV+ "%");
				statement.setInt(2, Integer.parseInt(MaDG));
				statement.setString(3, "%" + XepLoai + "%");
			}

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				XepLoaiDV std = new XepLoaiDV(resultSet.getInt("MaDG"), resultSet.getString("MSV"),
						resultSet.getString("XepLoai"), resultSet.getString("GhiChu"));
				XepLoaiDoanVienList.add(std);

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
		return XepLoaiDoanVienList;
	}
}
