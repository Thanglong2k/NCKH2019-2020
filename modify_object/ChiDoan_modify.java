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
import object_frame.ChiDoan;
import object_frame.GiangVien;

public class ChiDoan_modify {

	public static Map<Integer, Boolean> exists = new HashMap<Integer, Boolean>();

	public static List<ChiDoan> findAll() {
		// lay tat ca danh sach hoat dong
		List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();

		Connection connection = null;
		Statement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "select * from ChiDoan";
			statement = connection.createStatement();// lay du lieu tu database

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				ChiDoan cd = new ChiDoan(resultSet.getInt("MaChiDoan"), resultSet.getString("TenChiDoan"),
						resultSet.getString("Khoa"), resultSet.getInt("MaGV"), resultSet.getString("TTCanBoLop"),
						resultSet.getInt("SoLuongDoanVien"), resultSet.getInt("MaLienChi"));
				chidoanList.add(cd);
				
				exists.put(cd.getMaChiDoan(), true);
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
		return chidoanList;
	}

	//__________________________________________________Them moi 1 chi doan __________________________________________\\
	
	public static boolean insert(ChiDoan cd) {
		List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "insert into ChiDoan "
					+ "(MaChiDoan,TenChiDoan ,Khoa,MaGV,TTCanBoLop,SoLuongDoanVien,MaLienChi)"
					+ " values(?,?,?,?,?,?,?)";
			statement = connection.prepareCall(sql);

			statement.setInt(1, cd.getMaChiDoan());
			statement.setString(2, cd.getTenChiDoan());
			statement.setString(3, cd.getKhoaz());
			statement.setInt(4, cd.getMaGV());
			statement.setString(5, cd.getTTCanBoLop());
			statement.setInt(6, cd.getSoLuongDoanVien());
			statement.setInt(7, cd.getMaLienChiDoan());

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
		
		return true;

	}
		//___________________________________ Sua thong tin chi doan ________________________________________________//


	public static boolean update(ChiDoan cd) {
		List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();

		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {

			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "update  ChiDoan  set "
					+ "TenChiDoan=? ,Khoa=?,MaGV=?,TTCanBoLop=?,SoLuongDoanVien=?,MaLienChi=? where MaChiDoan =?";
			
			statement = connection.prepareCall(sql);
			statement.setString(1,cd.getTenChiDoan());
			statement.setString(2,cd.getKhoaz());
			statement.setInt(3, cd.getMaGV());
			statement.setString(4,cd.getTTCanBoLop());
			statement.setInt(5,cd.getSoLuongDoanVien());
			statement.setInt(6, cd.getMaLienChiDoan());
			statement.setInt(7, cd.getMaChiDoan());
			
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


       //________________________________________ Xoa thong tin  chi doan_________________________________//
	
	public static void delete(int MaChiDoan) {
		List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			String sql = "delete from ChiDoan where MaChiDoan=?";

			statement = connection.prepareCall(sql);

			statement.setInt(1, MaChiDoan);
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
	
	
	public static List<ChiDoan> search(String MaChiDoan, String TenChiDoan , String MaLienChi) {
		List<ChiDoan> chidoanList = new ArrayList<ChiDoan>();

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Map<String, String> config = ReadData.readDataFromFile();
			connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
					config.get("DB_PASSWORD"));
			// query
			if (!MaChiDoan.equals("") && TenChiDoan.equals("") && MaLienChi.equals("0")) {
				String sql = "select * from ChiDoan  where MaChiDoan = ? ";
				statement = connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(MaChiDoan));
			}
			else if(MaChiDoan.equals("") && !TenChiDoan.equals("") && MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan where TenChiDoan like ? ";
				statement = connection.prepareCall(sql);
				statement.setString(1, "%" + TenChiDoan + "%");
			}
			else if(MaChiDoan.equals("") && TenChiDoan.equals("") &&! MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan  where MaLienChi = ? ";
				statement = connection.prepareCall(sql);
				statement.setInt(1,Integer.parseInt(MaLienChi) );
			}
			//CẶP
			else if(!MaChiDoan.equals("") && !TenChiDoan.equals("") && MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan  where MaChiDoan = ? and TenChiDoan like ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1,Integer.parseInt(MaChiDoan) );
				statement.setString(2,"%"+TenChiDoan+"%" );
				
			}
			else if(!MaChiDoan.equals("") && TenChiDoan.equals("") && !MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan  where MaChiDoan = ? and TenChiDoan like ?";
				statement = connection.prepareCall(sql);
				statement.setInt(1,Integer.parseInt(MaChiDoan) );
				statement.setString(2,"%"+TenChiDoan+"%" );
				
			}
			else if(MaChiDoan.equals("") && !TenChiDoan.equals("") && !MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan  where TenChiDoan like ? and MaLienChi = ?";
				statement = connection.prepareCall(sql);
				statement.setString(1,"%"+TenChiDoan+"%" );
				statement.setInt(2,Integer.parseInt(MaLienChi)  );
				
			}
			else if(!MaChiDoan.equals("") && !TenChiDoan.equals("") && !MaLienChi.equals("0"))
			{
				String sql = "select * from ChiDoan  where TenChiDoan like ? and MaLienChi = ? and MaChiDoan = ?";
				statement = connection.prepareCall(sql);
				statement.setString(1,"%"+TenChiDoan+"%" );
				statement.setInt(2,Integer.parseInt(MaLienChi)  );
				statement.setInt(3,Integer.parseInt(MaChiDoan)  );
				
			}
			
			
			
			
	
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				ChiDoan cd = new ChiDoan(
					
						resultSet.getInt("MaChiDoan"),
						resultSet.getString("TenChiDoan"),
						resultSet.getString("Khoa"),
						resultSet.getInt("MaGV"),
						resultSet.getString("TTCanBoLop"),
						resultSet.getInt("SoLuongDoanVien"),
						resultSet.getInt("MaLienChi")
						);
						
				chidoanList.add(cd);
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
		return chidoanList;
	}

	

}
