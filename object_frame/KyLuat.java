package object_frame;

import java.util.Date;

public class KyLuat {
	private int MaSo;
	private String MaDV;
	private String LyDo;
	private String NoiDung;
	private String NgayKyLuat;
	public KyLuat() {
		
	}

	

	public KyLuat(int maSo, String maDV, String lyDo, String noiDung, String ngayKyLuat) {
		super();
		MaSo = maSo;
		MaDV = maDV;
		LyDo = lyDo;
		NoiDung = noiDung;
		NgayKyLuat = ngayKyLuat;
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

	public String getNgayKyLuat() {
		return NgayKyLuat;
	}

	public void setNgayKyLuat(String ngayKyLuat) {
		NgayKyLuat = ngayKyLuat;
	}
	
}
