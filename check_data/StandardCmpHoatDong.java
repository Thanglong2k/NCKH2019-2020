package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLHoatDong;
import object_frame.HoatDong;

public class StandardCmpHoatDong {
	public static List<HoatDong> hoatdongList = QLHoatDong.hoatdongList;

	public static Comparator<HoatDong> TenCmp = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int diff = o1.getTenHoatDong().compareToIgnoreCase(o2.getTenHoatDong());
			return diff;
		}
	};

	public static Comparator<HoatDong> LoaiCmp = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int diff = o1.getLoaiHoatDong().compareToIgnoreCase(o2.getLoaiHoatDong());
			return diff;
		}
	};

	public static Comparator<HoatDong> ThoiGianCmp = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			String date1 = o1.getThoiGian().trim();
			String[] thoigian1 = date1.split("-");
			String date2 = o2.getThoiGian().trim();
			String[] thoigian2 = date2.split("-");

			if (thoigian1[0].compareTo(thoigian1[0]) != 0) {
				return thoigian1[0].compareTo(thoigian2[0]);
			} else {
				if (thoigian1[1].compareTo(thoigian2[1]) != 0) {
					return thoigian1[1].compareTo(thoigian2[1]);
				} else {
					return thoigian1[2].compareTo(thoigian2[2]);
				}
			}

		}
	};
	// sắp xếp theo tên A-Z và loại A-Z
	public static Comparator<HoatDong> TenAZ_LoaiAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và loại Z-A
	public static Comparator<HoatDong> TenAZ_LoaiZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và loai A-Z
	public static Comparator<HoatDong> TenZA_LoaiAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và điểm giảm
	public static Comparator<HoatDong> TenZA_LoaiZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và Thời Gian Tăng
	public static Comparator<HoatDong> TenAZ_ThoiGianTang = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và Thời Gian Giảm
	public static Comparator<HoatDong> TenAZ_ThoiGianGiam = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và Thời Gian Tăng
	public static Comparator<HoatDong> TenZA_ThoiGianTang = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và Thời Gian Giảm
	public static Comparator<HoatDong> TenZA_ThoiGianGiam = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian tăng và tên A-Z
	public static Comparator<HoatDong> ThoiGianTang_TenAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// Thời Gian tăng và tên từ Z-A
	public static Comparator<HoatDong> ThoiGianTang_TenZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian Giảm và tên từ A-Z
	public static Comparator<HoatDong> ThoiGianGiam_TenAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian Giảm và tên từ Z-A
	public static Comparator<HoatDong> ThoiGianGiam_TenZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian tăng và Loại A-Z
	public static Comparator<HoatDong> ThoiGianTang_LoaiAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian tăng và Loại Z-A
	public static Comparator<HoatDong> ThoiGianTang_LoaiZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian Giảm và Loại A-Z
	public static Comparator<HoatDong> ThoiGianGiam_LoaiAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Thời Gian Giảm và Loại Z-A
	public static Comparator<HoatDong> ThoiGianGiam_LoaiZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = ThoiGianCmp.compare(o1, o2);
			if (value == 0) {
				if (LoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Loại A-Z , tgian tăng
	public static Comparator<HoatDong> LoaiAZ_ThoiGianTang = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Loại A-Z , tgian giảm
	public static Comparator<HoatDong> LoaiAZ_ThoiGianGiam = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Loại Z-A , tgian tăng
	public static Comparator<HoatDong> LoaiZA_ThoiGianTang = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Loại Z-A , tgian giảm
	public static Comparator<HoatDong> LoaiZA_ThoiGianGiam = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (ThoiGianCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Loại A-Z , tên A-Z
	public static Comparator<HoatDong> LoaiAZ_TenAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Loại A-Z , tên Z-A
	public static Comparator<HoatDong> LoaiAZ_TenZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Loại Z-A , tên A-Z
	public static Comparator<HoatDong> LoaiZA_TenAZ = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {
			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// Loại Z-A , tên Z-A
	public static Comparator<HoatDong> LoaiZA_TenZA = new Comparator<HoatDong>() {
		@Override
		public int compare(HoatDong o1, HoatDong o2) {

			int value = LoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;

		}
	};

}
