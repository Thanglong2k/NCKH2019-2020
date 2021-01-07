package check_data;

import java.util.Comparator;
import java.util.List;

import object_frame.*;
import frame.QLKhenThuong;
import frame.SapXepKhenThuong;

public class StandardCmpKhenThuong {
	public static List<KhenThuong> KhenThuongList = QLKhenThuong.KhenThuongList;
	
	public static Comparator<KhenThuong> MaKTCmp = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int diff = Integer.compare(o1.getMaSo(), o2.getMaSo());
			return diff;
		}
	};
	
	public static Comparator<KhenThuong> TenCmp = new Comparator<KhenThuong>() {
		@Override 
		public int compare(KhenThuong o1, KhenThuong o2) {
				String name1 = SapXepKhenThuong.M.get(o1.getMaDV());
				String name2 = SapXepKhenThuong.M.get(o2.getMaDV());
				return name1.compareTo(name2);
		}
	};

	public static Comparator<KhenThuong> NgayKTCmp = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int diff = o1.getNgayKhenThuong().compareToIgnoreCase(o2.getNgayKhenThuong());
			return diff;
		}
	};
	
	// 1 MaKT tăng TenDV tăng
	public static Comparator<KhenThuong> MaKTTang_TenTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//2 MaKT tăng TenDV giảm
	public static Comparator<KhenThuong> MaKTTang_TenGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 3 MaKT giảm TenDV tăng
	public static Comparator<KhenThuong> MaKTGiam_TenTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//  4 MaKT giảm TenDV giảm
	public static Comparator<KhenThuong> MaKTGiam_TenGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//5 MaKT tăng Ngày Kỷ Luât tăng
	public static Comparator<KhenThuong> MaKTTang_NgayKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 6 MaKT tăng NgayKT giảm
	public static Comparator<KhenThuong> MaKTTang_NgayKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 7  MaKT giảm NgayKT tăng
	public static Comparator<KhenThuong> MaKTGiam_NgayKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 8 MaKT giảm NgayKT giảm
	public static Comparator<KhenThuong> MaKTGiam_NgayKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = MaKTCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 9 Ten tăng MaKT tăng
	public static Comparator<KhenThuong> TenTang_MaKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// 10 Ten tăng MaKT giảm
	public static Comparator<KhenThuong> TenTang_MaKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 11 Ten Giảm MaKT tăng
	public static Comparator<KhenThuong> TenGiam_MaKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 12 Ten Giảm MaKT giảm
	public static Comparator<KhenThuong> TenGiam_MaKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 13.  Ten tăng NgayKT tăng
	public static Comparator<KhenThuong> TenTang_NgayKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 14 Ten tăng NgayKT giảm
	public static Comparator<KhenThuong> TenTang_NgayKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//15 Ten giảm NgayKT tăng
	public static Comparator<KhenThuong> TenGiam_NgayKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 16 Ten giảm NgayKT giảm
	public static Comparator<KhenThuong> TenGiam_NgayKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 17 NgayKT tăng -- MaKT tăng
	public static Comparator<KhenThuong> NgayKTTang_MaKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//18 NgayKT tăng MaKT giảm
	public static Comparator<KhenThuong> NgayKTTang_MaKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 19 NgayKT giảm MaKT tăng
	public static Comparator<KhenThuong> NgayKTGiam_MaKTTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 20 NgayKT giảm MaKT giảm
	public static Comparator<KhenThuong> NgayKTGiam_MaKTGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKTCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// 21 NgayKT tăng - Ten tăng
	public static Comparator<KhenThuong> NgayKTTang_TenTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 22 NgayKT tăng - Ten giảm
	public static Comparator<KhenThuong> NgayKTTang_TenGiam = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 23 NgayKT giảm Ten tăng
	public static Comparator<KhenThuong> NgayKTGiam_TenTang = new Comparator<KhenThuong>() {
		@Override
		public int compare(KhenThuong o1, KhenThuong o2) {
			int value = NgayKTCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	//  24 NgayKT giảm Ten giảm
	public static Comparator<KhenThuong> NgayKTGiam_TenGiam = new Comparator<KhenThuong>() {
		@Override 
		public int compare(KhenThuong o1, KhenThuong o2) {

			int value = NgayKTCmp.compare(o1, o2);
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
	
	

	
//	public static Comparator<KhenThuong>  = new Comparator<KhenThuong>() {
//		@Override 
//		public int compare(KhenThuong o1, KhenThuong o2) {
//
//			int value = NgayKTCmp.compare(o1, o2);
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
