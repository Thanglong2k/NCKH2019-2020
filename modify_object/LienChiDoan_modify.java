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
import object_frame.LienChi;

public class LienChiDoan_modify {
		
		///-----------------------------------------------------------------------------//
		public static Map<Integer , Boolean > exists = new HashMap<Integer, Boolean>();
		
		public static List<LienChi> findAll()
		{
			List<LienChi>  lienchiList = new ArrayList<LienChi>();
			
			Connection connection = null;
			Statement statement = null;
			try {
				
				Map<String , String > config  = new ReadData().readDataFromFile();
				
				connection = DriverManager.getConnection(config.get("DB_URL") , config.get("DB_USERNAME"),config.get("DB_PASSWORD") );
				String sql = "select * from LienChi";
				statement = connection.createStatement(); 
				
				ResultSet resultSet = statement.executeQuery(sql);
				
				while (resultSet.next()) {
					LienChi lc =new LienChi(
							resultSet.getInt("MaLienChi"),
							resultSet.getString("TenLienChi"),
							resultSet.getString("ThongTinBCH")
							
							);
					lienchiList.add(lc);
					exists.clear();
					exists.put(lc.getMaLienChi(), true);

				}
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

			return lienchiList; 
		}
	}
		//-------------------------------------------------------------------------------------------------------------------------//
		public static void insert(LienChi lc) {
			List<LienChi> lienChiList = new ArrayList<LienChi>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "insert into LienChi"
						+ "(MaLienChi , TenLienChi ,ThongTinBCH)"
						+ "values(?,?,?)";
				statement = connection.prepareCall(sql);

				statement.setLong(1, lc.getMaLienChi());
				statement.setString(2,lc.getTenLienChi());
				statement.setString(3, lc.getThongTinBCH());
				
				
			
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

		public static void update(LienChi lc) {
			List<LienChi>lienchiList = new ArrayList<LienChi>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {

				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "update LienChi set"
						+ " TenLienChi =? , ThongTinBCH= ? where MaLienChi =? ";
				statement = connection.prepareCall(sql);

				statement.setString(1, lc.getTenLienChi());
				statement.setString(2, lc.getThongTinBCH());
				statement.setLong(3,lc.getMaLienChi());
				
			
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

		public static void delete(String MaLienChi) {
			List<LienChi> LienChiList = new ArrayList<LienChi>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				String sql = "delete from LIenChi where MaLienChi=?";

				statement = connection.prepareCall(sql);

				statement.setString(1, MaLienChi);
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

		public static List<LienChi> search(String MaLienChi, String TenLienChi) {
			// lay tat ca danh sach sinh vien
			List<LienChi> LienChiList = new ArrayList<LienChi>();

			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Map<String, String> config = ReadData.readDataFromFile();
				connection = DriverManager.getConnection(config.get("DB_URL"), config.get("DB_USERNAME"),
						config.get("DB_PASSWORD"));
				// query
				if (!TenLienChi.equals("") && !MaLienChi.equals("")) {
					String sql = "select * from LienChi where TenLienChi like ? and MaLienChi=?";
					statement = connection.prepareCall(sql);// lay du lieu tu database
					statement.setString(1, "%" +TenLienChi+ "%");
					statement.setInt(2, Integer.parseInt(MaLienChi));
				}
				else if (TenLienChi.equals("") && !MaLienChi.equals("")) {
					String sql = "select * from GiangVien where MaGV=?";
					statement = connection.prepareCall(sql);// lay du lieu tu database
					statement.setInt(1, Integer.parseInt(MaLienChi));
				}
				else if (!TenLienChi.equals("") && MaLienChi.equals("")) {
					String sql = "select * from LienChi where TenLienChi like ?" ;
					statement = connection.prepareCall(sql);// lay du lieu tu database
					statement.setString(1, "%" + TenLienChi + "%");
				}

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					LienChi lc= new LienChi (resultSet.getInt("MaLienChi"),
							resultSet.getString("TenLienChi"),
							resultSet.getString("ThongTinBCH")
							
							
							);
					LienChiList.add(lc);

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
			return LienChiList;
		}

		
}

