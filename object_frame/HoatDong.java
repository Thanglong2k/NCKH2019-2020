package object_frame;

public class HoatDong {
	private int MaHoatDong;
	private String TenHoatDong;
	private String LoaiHoatDong;
	private String ThoiGian;
	private String ThongTinChiTiet;
	private String DonViToChuc;

	public HoatDong(int maHoatDong, String tenHoatDong, String loaiHoatDong, String thoiGian, String thongTinChiTiet,
			String donViToChuc) {
		super();
		MaHoatDong = maHoatDong;
		TenHoatDong = tenHoatDong;
		LoaiHoatDong = loaiHoatDong;
		ThoiGian = thoiGian;
		ThongTinChiTiet = thongTinChiTiet;
		DonViToChuc = donViToChuc;
	}

	public int getMaHoatDong() {
		return MaHoatDong;
	}

	public void setMaHoatDong(int maHoatDong) {
		MaHoatDong = maHoatDong;
	}

	public String getTenHoatDong() {
		return TenHoatDong;
	}

	public void setTenHoatDong(String tenHoatDong) {
		TenHoatDong = tenHoatDong;
	}

	public String getLoaiHoatDong() {
		return LoaiHoatDong;
	}

	public void setLoaiHoatDong(String loaiHoatDong) {
		LoaiHoatDong = loaiHoatDong;
	}

	public String getThoiGian() {
		return ThoiGian;
	}

	public void setThoiGian(String thoiGian) {
		ThoiGian = thoiGian;
	}

	public String getThongTinChiTiet() {
		return ThongTinChiTiet;
	}

	public void setThongTinChiTiet(String thongTinChiTiet) {
		ThongTinChiTiet = thongTinChiTiet;
	}

	public String getDonViToChuc() {
		return DonViToChuc;
	}

	public void setDonViToChuc(String donViToChuc) {
		DonViToChuc = donViToChuc;
	}

}
