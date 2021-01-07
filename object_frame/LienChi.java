package object_frame;

public class LienChi {

	private int  MaLienChi;
	private String TenLienChi;
	private String  ThongTinBCH;
	
	public LienChi() {
		// TODO Auto-generated constructor stub
	}
	public LienChi(int MaLienChi , String TenLienChi , String ThongTinBCH)
	{
		this.MaLienChi = MaLienChi ;
		this.TenLienChi = TenLienChi ;
		this.ThongTinBCH = ThongTinBCH;
	}
	public int getMaLienChi() {
		return MaLienChi;
	}
	public void setMaLienChi(int maLienChi) {
		MaLienChi = maLienChi;
	}
	public String getTenLienChi() {
		return TenLienChi;
	}
	public void setTenLienChi(String tenLienChi) {
		TenLienChi = tenLienChi;
	}
	public String getThongTinBCH() {
		return ThongTinBCH;
	}
	public void setThongTinBCH(String thongTinBCH) {
		ThongTinBCH = thongTinBCH;
	}
	

}
