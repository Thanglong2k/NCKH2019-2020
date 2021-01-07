package modify_object;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import data_config.ReadData;
import object_frame.KhenThuong;

public class KhenThuongModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<KhenThuong> fillAll(){
		
		List<KhenThuong> KhenThuongList=new ArrayList<KhenThuong>();
		
		Connection connection = null;
		Statement  statement = null;	
				
		try {Map<String, String> config = ReadData.readDataFromFile();
			connection= DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			
			String sql= "select * from KhenThuong";
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				KhenThuong KhenThuong = new KhenThuong(resultSet.getInt("MaSoKhenThuong"), resultSet.getString("MSV"), resultSet.getString("LyDo"),
						resultSet.getString("NoiDung"), resultSet.getString("NgayKhenThuong"));
				KhenThuongList.add(KhenThuong);
				exists.put(KhenThuong.getMaSo(), true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return KhenThuongList;
	}

	public static void insert(KhenThuong KhenThuong) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KhenThuong> KhenThuongList = new ArrayList<KhenThuong>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "insert into KhenThuong(MaSoKhenThuong,MSV,LyDo,NoiDung,NgayKhenThuong) values(?,?,?,?,?)";
			statement = connection.prepareCall(sql);
			
			statement.setInt(1,KhenThuong.getMaSo());
			statement.setString(2, KhenThuong.getMaDV());
			statement.setString(3, KhenThuong.getLyDo());
			statement.setString(4, KhenThuong.getNoiDung());
			statement.setString(5, KhenThuong.getNgayKhenThuong());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static void update(KhenThuong KhenThuong) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KhenThuong> KhenThuongList = new ArrayList<KhenThuong>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "update KhenThuong set MSV=?,LyDo=?,NoiDung=?,NgayKhenThuong=? where MaSoKhenThuong=?";
			statement = connection.prepareCall(sql);

			statement.setString(1, KhenThuong.getMaDV());
			statement.setString(2, KhenThuong.getLyDo());
			statement.setString(3, KhenThuong.getNoiDung());
			statement.setString(4, KhenThuong.getNgayKhenThuong());
			statement.setInt(5, KhenThuong.getMaSo());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static void delete(KhenThuong KhenThuong) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KhenThuong> KhenThuongList = new ArrayList<KhenThuong>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "delete from KhenThuong where MaSoKhenThuong=?";
			statement = connection.prepareCall(sql);

			statement.setInt(1, KhenThuong.getMaSo());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static List<KhenThuong> search(String MSV,String NKT) {
		// lay tat ca danh sach sinh vien
		List<KhenThuong> KhenThuongList = new ArrayList<KhenThuong>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if(!NKT.equals("") && MSV.equals("")) {
				String sql="select * from KhenThuong where NgayKhenThuong like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + NKT + "%");
			}
			
			else if(NKT.equals("") && !MSV.equals("")) {
				String sql="select * from KhenThuong where MSV like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MSV + "%");
			}
						
			else if (!NKT.equals("") && !MSV.equals("")) {
				String sql = "select * from KhenThuong where MSV like ? and NgayKhenThuong like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MSV + "%");
				statement.setString(2, "%" + NKT + "%");
			}
			
		
 
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				KhenThuong KhenThuong = new KhenThuong(resultSet.getInt("MaSoKhenThuong"), resultSet.getString("MSV"),
						resultSet.getString("LyDo"), resultSet.getString("NoiDung"), resultSet.getString("NgayKhenThuong"));
				KhenThuongList.add(KhenThuong);

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
		return KhenThuongList;
	}
}
