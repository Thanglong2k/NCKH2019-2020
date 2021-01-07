package object_frame;

import java.util.Date;

public class KhenThuong {
	private int MaSo;
	private String MaDV;
	private String LyDo;
	private String NoiDung;
	private String NgayKhenThuong;
	
	
	
	public KhenThuong() {
		super();
	}

	public KhenThuong(int maSo, String maDV, String lyDo, String noiDung, String ngayKhenThuong) {
		super();
		MaSo = maSo;
		MaDV = maDV;
		LyDo = lyDo;
		NoiDung = noiDung;
		NgayKhenThuong = ngayKhenThuong;
	}

	public int getMaSo() {
		return MaSo;
	}

	public void setMaSo(int maSo) {
		MaSo = maSo;
	}

	public String getMaDV() {
		return MaDV;
	}

	public void setMaDV(String maDV) {
		MaDV = maDV;
	}

	public String getLyDo() {
		return LyDo;
	}

	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public String getNgayKhenThuong() {
		return NgayKhenThuong;
	}

	public void setNgayKhenThuong(String ngayKhenThuong) {
		NgayKhenThuong = ngayKhenThuong;
	}

}
