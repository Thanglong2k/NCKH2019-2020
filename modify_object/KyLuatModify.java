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
import object_frame.KyLuat;

public class KyLuatModify {
	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<KyLuat> fillAll(){
		
		List<KyLuat> kyLuatList=new ArrayList<KyLuat>();
		
		Connection connection = null;
		Statement  statement = null;	
				
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection= DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			
			String sql= "select * from KyLuat";
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				KyLuat kyluat = new KyLuat(resultSet.getInt("MaSoKyLuat"), resultSet.getString("MSV"), resultSet.getString("LyDo"),
						resultSet.getString("NoiDung"), resultSet.getString("NgayKiLuat"));
				kyLuatList.add(kyluat);
				exists.put(kyluat.getMaSo(), true);
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
		return kyLuatList;
	}

	public static void insert(KyLuat kyluat) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KyLuat> kyLuatList = new ArrayList<KyLuat>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "insert into KyLuat(MaSoKyLuat,MSV,LyDo,NoiDung,NgayKiLuat) values(?,?,?,?,?)";
			statement = connection.prepareCall(sql);
			
			statement.setInt(1,kyluat.getMaSo());
			statement.setString(2, kyluat.getMaDV());
			statement.setString(3, kyluat.getLyDo());
			statement.setString(4, kyluat.getNoiDung());
			statement.setString(5, kyluat.getNgayKyLuat());

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

	public static void update(KyLuat kyluat) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KyLuat> kyLuatList = new ArrayList<KyLuat>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "update KyLuat set MSV=?,LyDo=?,NoiDung=?,NgayKiLuat=? where MaSoKyLuat=?";
			statement = connection.prepareCall(sql);

			statement.setString(1, kyluat.getMaDV());
			statement.setString(2, kyluat.getLyDo());
			statement.setString(3, kyluat.getNoiDung());
			statement.setString(4, kyluat.getNgayKyLuat());
			statement.setInt(5, kyluat.getMaSo());

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

	public static void delete(KyLuat kyluat) throws IOException {
		Map<String, String> config = ReadData.readDataFromFile();
		List<KyLuat> kyLuatList = new ArrayList<KyLuat>();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));

			String sql = "delete from KyLuat where MaSoKyLuat=?";
			statement = connection.prepareCall(sql);

			statement.setInt(1, kyluat.getMaSo());

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

	public static List<KyLuat> search(String MSV, String NKL) {
		// lay tat ca danh sach sinh vien
		List<KyLuat> KyLuatList = new ArrayList<KyLuat>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if(!NKL.equals("") && MSV.equals("")) {
				String sql="select * from KyLuat where NgayKiLuat like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + NKL + "%");
			}
			
			else if(NKL.equals("") && !MSV.equals("")) {
				String sql="select * from KyLuat where MSV like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MSV + "%");
			}
						
			else if (!NKL.equals("") && !MSV.equals("")) {
				String sql = "select * from KyLuat where MSV like ? and NgayKiLuat like ?";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + MSV + "%");
				statement.setString(2, "%" + NKL + "%");
			}
 
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				KyLuat kyluat = new KyLuat(resultSet.getInt("MaSoKyLuat"), resultSet.getString("MSV"),
						resultSet.getString("LyDo"), resultSet.getString("NoiDung"), resultSet.getString("NgayKiLuat"));
				KyLuatList.add(kyluat);

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
		return KyLuatList;
	}
}
