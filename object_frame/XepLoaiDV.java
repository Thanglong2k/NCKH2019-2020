package object_frame;

public class XepLoaiDV {
	private int MaDG;
	private String MaSV;
	private String XepLoai;
	private String GhiChu;

	public XepLoaiDV(int maDG, String maSV, String xepLoai, String ghiChu) {
		super();
		MaDG = maDG;
		MaSV = maSV;
		XepLoai = xepLoai;
		GhiChu = ghiChu;
	}

	public int getMaDG() {
		return MaDG;
	}

	public void setMaDG(int maDG) {
		MaDG = maDG;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getXepLoai() {
		return XepLoai;
	}

	public void setXepLoai(String xepLoai) {
		XepLoai = xepLoai;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

}
