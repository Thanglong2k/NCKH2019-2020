package object_frame;

public class ChiDoan {
	private int MaChiDoan;
	private String TenChiDoan;
	private String Khoaz;
	private int MaGV;
	private String TTCanBoLop ;
	private int SoLuongDoanVien;
	private int MaLienChiDoan;
	
	public ChiDoan() {
		// TODO Auto-generated constructor stub
	}
	
	public ChiDoan(int MaChiDoan , String TenChiDoan , String Khoaz , int MaGV , String TTCanBoLop ,int SoLuongDoanVien  , int MaLienChiDoan)
	{
		this.MaChiDoan = MaChiDoan;
		this.TenChiDoan = TenChiDoan;
		this.Khoaz =Khoaz;
		this.MaGV = MaGV;
		this.TTCanBoLop = TTCanBoLop;
		this.SoLuongDoanVien= SoLuongDoanVien;
		this.MaLienChiDoan = MaLienChiDoan;
	}

	public int getMaChiDoan() {
		return MaChiDoan;
	}

	public void setMaChiDoan(int maCHiDoan) {
		MaChiDoan = maCHiDoan;
	}

	public String getTenChiDoan() {
		return TenChiDoan;
	}

	public void setTenChiDoan(String tenChiDoan) {
		TenChiDoan = tenChiDoan;
	}

	public String getKhoaz() {
		return Khoaz;
	}

	public void setKhoaz(String khoaz) {
		Khoaz = khoaz;
	}

	public int getMaGV() {
		return MaGV;
	}

	public void setMaGV(int maGV) {
		MaGV = maGV;
	}

	public String getTTCanBoLop() {
		return TTCanBoLop;
	}

	public void setTTCanBoLop(String tTCanBoLop) {
		TTCanBoLop = tTCanBoLop;
	}

	public int getSoLuongDoanVien() {
		return SoLuongDoanVien;
	}

	public void setSoLuongDoanVien(int soLuongDoanVien) {
		SoLuongDoanVien = soLuongDoanVien;
	}

	public int getMaLienChiDoan() {
		return MaLienChiDoan;
	}

	public void setMaLienChiDoan(int maLienChiDoan) {
		MaLienChiDoan = maLienChiDoan;
	}
	

}
