package object_frame;

public class GiangVien {
	private  int MaGV;
	private String HoTen;
	private String BoMon;
	private String Khoa;
	private String SDT;
	private String Email;
	
	
	public GiangVien() {
		// TODO Auto-generated constructor stub
	}
	public GiangVien(int MaGV , String HoTen , String BoMon , String Khoa , String SDT , String Email)
	
	{
		this.MaGV = MaGV ; 
		this.HoTen =HoTen ;
		this.BoMon = BoMon;
		this.Khoa= Khoa;
		this.SDT= SDT;
		this.Email = Email;
	}
	public int getMaGV() {
		return MaGV;
	}
	public void setMaGV(int maGV) {
		MaGV = maGV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getBoMon() {
		return BoMon;
	}
	public void setBoMon(String boMon) {
		BoMon = boMon;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	

}
