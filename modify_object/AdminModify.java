package modify_object;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import data_config.ReadData;
import object_frame.Admin;
import object_frame.Student;

public class AdminModify {
	public static Map<String, Boolean> exist = new HashMap<String, Boolean>();
	
	public static String getPer(String username) throws IOException, SQLException {
		Map<String, String> config = ReadData.readDataFromFile();
		try(Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareCall("SELECT * FROM Dangnhap WHERE Username = ?")
					) {
				stmt.setString(1, username);
				ResultSet rSet = stmt.executeQuery();
				if (rSet.next()) {
					return rSet.getString("PhanQuyen");
				}
			}
		return null;
	}
	
	public static LinkedList<Admin> findAllAccount() throws SQLException, IOException  {
		Map<String, String> config = ReadData.readDataFromFile();
		
		
		LinkedList<Admin> listAccount = new LinkedList<Admin>();
		
		try(Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
			Statement stmt = conn.createStatement()	
				) {
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM Dangnhap");
			while (resultSet.next()) {
				Admin admin = 
						new Admin(resultSet.getString("Username"),
								resultSet.getString("password"), resultSet.getString("PhanQuyen"));
				listAccount.add(admin);
				exist.put(admin.getUsername(), true);
			}
			
		}
		return listAccount; 
	}
	
	public static void insert(String username, String password, String permission) throws IOException, SQLException {
		Map<String, String> config = ReadData.readDataFromFile();
		String query = "insert into DangNhap (username, password, phanquyen) values (?,?,?)";
		try(Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, permission);
			stmt.execute();
		}
	}
	
	public static void delete(String username) throws IOException, SQLException {
		Map<String, String> config = ReadData.readDataFromFile();
		String query = "delete from DangNhap where username = ?";
		try(Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.execute();
		}
	}
	
	public static void update(String username, String password, String permission, String oldName) throws IOException, SQLException {
		Map<String, String> config = ReadData.readDataFromFile();
		String query = "update DangNhap set Username = ?, password = ?, PhanQuyen = ? where Username = ?";
		try(Connection conn = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"), config.get("DB_PASSWORD"));
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, permission);
			stmt.setString(4, oldName);
			stmt.execute();
		}
	}
	
}
