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
import object_frame.DanhGiaRLSV;

public class DanhGiaRLSVModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<DanhGiaRLSV> findAll() {
		// lay tat ca danh sach hoat dong
		List<DanhGiaRLSV> DanhGiaRLSVList = new ArrayList<DanhGiaRLSV>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from DanhGiaRLSV";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				DanhGiaRLSV std = new DanhGiaRLSV(resultSet.getInt("MaDG"), resultSet.getString("NamHoc"),
						resultSet.getInt("HocKy"));
				
				exists.put(std.getMaDG(), true);
				DanhGiaRLSVList.add(std);
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
		return DanhGiaRLSVList;
	}

	public static void insert(DanhGiaRLSV hd) {
		List<DanhGiaRLSV> DanhGiaRLSVList = new ArrayList<DanhGiaRLSV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "insert into DanhGiaRLSV" + "(MaDG,NamHoc,HocKy)" + "values(?,?,?)";
			statement = connection.prepareCall(sql);

			statement.setInt(1, hd.getMaDG());
			statement.setString(2, hd.getNamHoc());
			statement.setInt(3, hd.getHocKy());

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

	public static void update(DanhGiaRLSV hd) {
		List<DanhGiaRLSV> DanhGiaRLSVList = new ArrayList<DanhGiaRLSV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "update DanhGiaRLSV set NamHoc=?,Hocky=? where MaDG = ?";
			statement = connection.prepareCall(sql);

			
			statement.setString(1, hd.getNamHoc());
			statement.setInt(2, hd.getHocKy());
			statement.setInt(3, hd.getMaDG());
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

	public static void delete(int MaDG) {
		List<DanhGiaRLSV> DanhGiaRLSVList = new ArrayList<DanhGiaRLSV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from DanhGiaRLSV where MaDG=?";

			statement = connection.prepareCall(sql);

			statement.setInt(1, MaDG);
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
	}

	public static List<DanhGiaRLSV> search(String MaDG, String NamHoc) {
		List<DanhGiaRLSV> RLSVList = new ArrayList<DanhGiaRLSV>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if (!MaDG.equals("") && !NamHoc.equals("")) {
				String sql = "select * from DanhGiaRLSV where MaDG like ? and NamHoc like ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaDG));
				statement.setString(2, "%" + NamHoc + "%");
			} else if (MaDG.equals("") && !NamHoc.equals("")) {
				String sql = "select * from DanhGiaRLSV where NamHoc like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + NamHoc + "%");
			} else if (!MaDG.equals("") && NamHoc.equals("")) {
				String sql = "select * from DanhGiaRLSV where MaDG like ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaDG));
			}

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				DanhGiaRLSV std = new DanhGiaRLSV(
						resultSet.getInt("MaDG"), 
						resultSet.getString("NamHoc"),
						resultSet.getInt("HocKy"));
				RLSVList.add(std);
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
		return RLSVList;
	}
}
