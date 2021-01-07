package check_data;

import java.util.Comparator;
import java.util.List;

import object_frame.KyLuat;
import frame.QLKyLuat;
import frame.SapXepKyLuat;

public class StandardCmpKyLuat {
	public static List<KyLuat> kyluatList = QLKyLuat.kyluatList;
	
	public static Comparator<KyLuat> MaKLCmp = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int diff = Integer.compare(o1.getMaSo(), o2.getMaSo());
			return diff;
		}
	};
	
	public static Comparator<KyLuat> TenCmp = new Comparator<KyLuat>() {
		@Override 
		public int compare(KyLuat o1, KyLuat o2) {
				String name1 = SapXepKyLuat.M.get(o1.getMaDV());
				String name2 = SapXepKyLuat.M.get(o2.getMaDV());
				return name1.compareTo(name2);
		}
	};

	public static Comparator<KyLuat> NgayKLCmp = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int diff = o1.getNgayKyLuat().compareToIgnoreCase(o2.getNgayKyLuat());
			return diff;
		}
	};
	
	// 1 MaKL tăng TenDV tăng
	public static Comparator<KyLuat> MaKLTang_TenTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//2 MaKL tăng TenDV giảm
	public static Comparator<KyLuat> MaKLTang_TenGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 3 MaKL giảm TenDV tăng
	public static Comparator<KyLuat> MaKLGiam_TenTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//  4 MaKL giảm TenDV giảm
	public static Comparator<KyLuat> MaKLGiam_TenGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	//5 MaKL tăng Ngày Kỷ Luât tăng
	public static Comparator<KyLuat> MaKLTang_NgayKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 6 MaKL tăng NgayKL giảm
	public static Comparator<KyLuat> MaKLTang_NgayKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 7  MaKL giảm NgayKL tăng
	public static Comparator<KyLuat> MaKLGiam_NgayKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 8 MaKL giảm NgayKL giảm
	public static Comparator<KyLuat> MaKLGiam_NgayKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = MaKLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 9 Ten tăng MaKL tăng
	public static Comparator<KyLuat> TenTang_MaKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// 10 Ten tăng MaKL giảm
	public static Comparator<KyLuat> TenTang_MaKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 11 Ten Giảm MaKL tăng
	public static Comparator<KyLuat> TenGiam_MaKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 12 Ten Giảm MaKL giảm
	public static Comparator<KyLuat> TenGiam_MaKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 13.  Ten tăng NgayKL tăng
	public static Comparator<KyLuat> TenTang_NgayKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 14 Ten tăng NgayKL giảm
	public static Comparator<KyLuat> TenTang_NgayKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//15 Ten giảm NgayKL tăng
	public static Comparator<KyLuat> TenGiam_NgayKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 16 Ten giảm NgayKL giảm
	public static Comparator<KyLuat> TenGiam_NgayKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgayKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 17 NgayKL tăng -- MaKL tăng
	public static Comparator<KyLuat> NgayKLTang_MaKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//18 NgayKL tăng MaKL giảm
	public static Comparator<KyLuat> NgayKLTang_MaKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 19 NgayKL giảm MaKL tăng
	public static Comparator<KyLuat> NgayKLGiam_MaKLTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// 20 NgayKL giảm MaKL giảm
	public static Comparator<KyLuat> NgayKLGiam_MaKLGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (MaKLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// 21 NgayKL tăng - Ten tăng
	public static Comparator<KyLuat> NgayKLTang_TenTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 22 NgayKL tăng - Ten giảm
	public static Comparator<KyLuat> NgayKLTang_TenGiam = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// 23 NgayKL giảm Ten tăng
	public static Comparator<KyLuat> NgayKLGiam_TenTang = new Comparator<KyLuat>() {
		@Override
		public int compare(KyLuat o1, KyLuat o2) {
			int value = NgayKLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	//  24 NgayKL giảm Ten giảm
	public static Comparator<KyLuat> NgayKLGiam_TenGiam = new Comparator<KyLuat>() {
		@Override 
		public int compare(KyLuat o1, KyLuat o2) {

			int value = NgayKLCmp.compare(o1, o2);
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
	
	

	
//	public static Comparator<KyLuat>  = new Comparator<KyLuat>() {
//		@Override 
//		public int compare(KyLuat o1, KyLuat o2) {
//
//			int value = NgayKLCmp.compare(o1, o2);
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
