package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLDanhGiaRLSV;
import object_frame.DanhGiaRLSV;

public class StandardCmpRLSV {
	public static List<DanhGiaRLSV> rlsvList = QLDanhGiaRLSV.RLSVList;

	public static Comparator<DanhGiaRLSV> MaCmp = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int diff = Integer.compare(o1.getMaDG(), o2.getMaDG());
			return diff;
		}
	};

	public static Comparator<DanhGiaRLSV> NamHocCmp = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int diff = o1.getNamHoc().compareToIgnoreCase(o2.getNamHoc());
			return diff;
		}
	};

	public static Comparator<DanhGiaRLSV> HocKyCmp = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int diff = o1.getNamHoc().compareToIgnoreCase(o2.getNamHoc());
			return diff;
		}
	};
	
	// mã tăng và năm tăng
	public static Comparator<DanhGiaRLSV> MaTang_NamTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// mã tăng và năm giảm
	public static Comparator<DanhGiaRLSV> MaTang_NamGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// mã giảm và năm tăng
	public static Comparator<DanhGiaRLSV> MaGiam_NamTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//  mã giảm và năm giảm
	public static Comparator<DanhGiaRLSV> MaGiam_NamGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// mã tăng và học kỳ tăng
	public static Comparator<DanhGiaRLSV> MaTang_HocKyTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// mã tăng và học kỳ giảm
	public static Comparator<DanhGiaRLSV> MaTang_HocKyGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// mẫ giảm học kỳ tăng
	public static Comparator<DanhGiaRLSV> MaGiam_HocKyTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// mẫ giảm học kỳ giảm
	public static Comparator<DanhGiaRLSV> MaGiam_HocKyGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = MaCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Năm tăng và mã tăng
	public static Comparator<DanhGiaRLSV> NamTang_MaTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// Năm tăng và mã giảm
	public static Comparator<DanhGiaRLSV> NamTang_MaGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Năm giảm và mã tăng
	public static Comparator<DanhGiaRLSV> NamGiam_MaTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Năm giảm và mã giảm
	public static Comparator<DanhGiaRLSV> NamGiam_MaGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Năm tăng học kỳ tăng
	public static Comparator<DanhGiaRLSV> NamTang_HocKyTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Năm tăng học kỳ giảm
	public static Comparator<DanhGiaRLSV> NamTang_HocKyGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// năm giảm học kỳ tăng
	public static Comparator<DanhGiaRLSV> NamGiam_HocKyTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// năm giảm học kỳ giảm
	public static Comparator<DanhGiaRLSV> NamGiam_HocKyGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = NamHocCmp.compare(o1, o2);
			if (value == 0) {
				if (HocKyCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// học kỳ tăng - mã tăng
	public static Comparator<DanhGiaRLSV> HocKyTang_MaTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// học kỳ tăng - mã giảm
	public static Comparator<DanhGiaRLSV> HocKyTang_MaGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// học kỳ giảm - mã tăng
	public static Comparator<DanhGiaRLSV> HocKyGiam_MaTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// học kỳ giảm - mã giảm
	public static Comparator<DanhGiaRLSV> HocKyGiam_MaGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (MaCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// học kỳ tăng - năm tăng
	public static Comparator<DanhGiaRLSV> HocKyTang_NamTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// học kỳ tăng - năm giảm
	public static Comparator<DanhGiaRLSV> HocKyTang_NamGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// học kỳ giảm - năm tăng
	public static Comparator<DanhGiaRLSV> HocKyGiam_NamTang = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {
			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	//  học kỳ giảm - năm giảm
	public static Comparator<DanhGiaRLSV> HocKyGiam_NamGiam = new Comparator<DanhGiaRLSV>() {
		@Override
		public int compare(DanhGiaRLSV o1, DanhGiaRLSV o2) {

			int value = HocKyCmp.compare(o1, o2);
			if (value == 0) {
				if (NamHocCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;

		}
	};

}
