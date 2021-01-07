package object_frame;

public class HoatDongDoanVien {
	private int ID;
	private String MaSV;
	private int MaHoatDong;
	private byte[] AnhMinhChung;
	private String ThanhTich;

	public HoatDongDoanVien(int iD, String maSV, int maHoatDong, byte[] anhMinhChung, String thanhTich) {
		super();
		ID = iD;
		MaSV = maSV;
		MaHoatDong = maHoatDong;
		AnhMinhChung = anhMinhChung;
		ThanhTich = thanhTich;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public int getMaHoatDong() {
		return MaHoatDong;
	}

	public void setMaHoatDong(int maHoatDong) {
		MaHoatDong = maHoatDong;
	}

	public byte[] getAnhMinhChung() {
		return AnhMinhChung;
	}

	public void setAnhMinhChung(byte[] anhMinhChung) {
		AnhMinhChung = anhMinhChung;
	}

	public String getThanhTich() {
		return ThanhTich;
	}

	public void setThanhTich(String thanhTich) {
		ThanhTich = thanhTich;
	}

}
