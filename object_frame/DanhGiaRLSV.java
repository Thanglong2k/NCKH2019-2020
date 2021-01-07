package object_frame;

public class DanhGiaRLSV {
	private int MaDG;
	private String NamHoc;
	private int HocKy;

	public DanhGiaRLSV(int maDG, String namHoc, int hocKy) {
		super();
		MaDG = maDG;
		NamHoc = namHoc;
		HocKy = hocKy;
	}

	public int getMaDG() {
		return MaDG;
	}

	public void setMaDG(int maDG) {
		MaDG = maDG;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String namHoc) {
		NamHoc = namHoc;
	}

	public int getHocKy() {
		return HocKy;
	}

	public void setHocKy(int hocKy) {
		HocKy = hocKy;
	}

}
