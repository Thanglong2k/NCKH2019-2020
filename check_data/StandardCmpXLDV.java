package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLXepLoaiDoanVien;
import frame.SapXepXLDV;
import object_frame.XepLoaiDV;

public class StandardCmpXLDV {
	public static List<XepLoaiDV> xldvList = QLXepLoaiDoanVien.xldvList;
	
	public static Comparator<XepLoaiDV> MaDGCmp = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int diff = Integer.compare(o1.getMaDG(), o2.getMaDG());
			return diff;
		}
	};

	public static Comparator<XepLoaiDV> MaSVCmp = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int diff = o1.getMaSV().compareToIgnoreCase(o2.getMaSV());
			return diff;
		}
	};

	public static Comparator<XepLoaiDV> XepLoaiCmp = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int diff = o1.getXepLoai().compareToIgnoreCase(o2.getXepLoai());
			return diff;
		}
	};
	
	// 1MaDG tăng msv tăng
	public static Comparator<XepLoaiDV> MaDGTang_TenTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//2 MaDG tăng msv giảm
	public static Comparator<XepLoaiDV> MaDGTang_MSVGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 3MaDG giảm msv tăng
	public static Comparator<XepLoaiDV> MaDGGiam_MSVTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//  4MaDG giảm msv giảm
	public static Comparator<XepLoaiDV> MaDGGiam_MSVGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//5 MaDG tăng xếp loại tăng
	public static Comparator<XepLoaiDV> MaDGTang_XepLoaiTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 6 MaDG tăng xếp loại giảm
	public static Comparator<XepLoaiDV> MaDGTang_XepLoaiGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 7  MaDG giảm xếp loại tăng
	public static Comparator<XepLoaiDV> MaDGGiam_XepLoaiTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 8 MaDG giảm xếp loại giảm
	public static Comparator<XepLoaiDV> MaDGGiam_XepLoaiGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = MaDGCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 9 Msv tăng maDG tăng
	public static Comparator<XepLoaiDV> MSVTang_MaDGTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// 10 Msv tăng maDG giảm
	public static Comparator<XepLoaiDV> MSVTang_MaDGGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 11 Msv Giảm MaDG tăng
	public static Comparator<XepLoaiDV> MSVGiam_MaDGTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 12 Msv Giảm MaDG giảm
	public static Comparator<XepLoaiDV> MSVGiam_MaDGGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 13.  Msv tăng xếp loại tăng
	public static Comparator<XepLoaiDV> MSVTang_XepLoaiTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 14 Msv tăng xếp loại giảm
	public static Comparator<XepLoaiDV> MSVTang_XepLoaiGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//15 Msv giảm xếp loại tăng
	public static Comparator<XepLoaiDV> MSVGiam_XepLoaiTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 16 Msv giảm xếp loại giảm
	public static Comparator<XepLoaiDV> MSVGiam_XepLoaiGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (XepLoaiCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 17 xếp loại tăng -- maDG tăng
	public static Comparator<XepLoaiDV> XepLoaiTang_MaDGTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//18 xếp loại tăng maDG giảm
	public static Comparator<XepLoaiDV> XepLoaiTang_MaDGGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 19 xếp loại giảm maDG tăng
	public static Comparator<XepLoaiDV> XepLoaiGiam_MaDGTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 20 xếp loại giảm maDG giảm
	public static Comparator<XepLoaiDV> XepLoaiGiam_MaDGGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (MaDGCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// 21 xếp loại tăng - msv tăng
	public static Comparator<XepLoaiDV> XepLoaiTang_MSVTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 22 xếp loại tăng - msv giảm
	public static Comparator<XepLoaiDV> XepLoaiTang_MSVGiam = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 23 xếp loại giảm msv tăng
	public static Comparator<XepLoaiDV> XepLoaiGiam_MSVTang = new Comparator<XepLoaiDV>() {
		@Override
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	//  24 xếp loại giảm msv giảm
	public static Comparator<XepLoaiDV> XepLoaiGiam_MSVGiam = new Comparator<XepLoaiDV>() {
		@Override 
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {

			int value = XepLoaiCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;

		}
	};
	
	// sắp xếp theo ten.
	public static Comparator<XepLoaiDV> TenCmp = new Comparator<XepLoaiDV>() {
		@Override 
		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
				String name1 = SapXepXLDV.M.get(o1.getMaSV());
				String name2 = SapXepXLDV.M.get(o2.getMaSV());
				return name1.compareTo(name2);
		}
	};
	

	
//	public static Comparator<XepLoaiDV>  = new Comparator<XepLoaiDV>() {
//		@Override 
//		public int compare(XepLoaiDV o1, XepLoaiDV o2) {
//
//			int value = XepLoaiCmp.compare(o1, o2);
//			if (value == 0) {
//				if (TenCmp.compare(o1, o2) < 0) {
//					return 1;
//				}
//			} else if (value < 0)
//				return 1;
//			return -1;
//
//		}
//	};
}
