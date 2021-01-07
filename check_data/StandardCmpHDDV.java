package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLDoanVienHD;
import object_frame.HoatDongDoanVien;

public class StandardCmpHDDV {
	public static List<HoatDongDoanVien> hddvList = QLDoanVienHD.HDDVList;

	public static Comparator<HoatDongDoanVien> IDCmp = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int diff = Integer.compare(o1.getID(), o2.getID());
			return diff;
		}
	};

	public static Comparator<HoatDongDoanVien> MSVCmp = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int diff = o1.getMaSV().compareToIgnoreCase(o2.getMaSV());
			return diff;
		}
	};

	public static Comparator<HoatDongDoanVien> MHDCmp = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int diff = Integer.compare(o1.getMaHoatDong(), o2.getMaHoatDong());
			return diff;
		}
	};
	// id tăng msv tăng
	public static Comparator<HoatDongDoanVien> IDTang_MSVTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// id tăng msv giảm
	public static Comparator<HoatDongDoanVien> IDTang_MSVGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// id giảm msv tăng
	public static Comparator<HoatDongDoanVien> IDGiam_MSVTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// id giảm msv giảm
	public static Comparator<HoatDongDoanVien> IDGiam_MSVGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// id tăng mã hdong tăng
	public static Comparator<HoatDongDoanVien> IDTang_MHDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//  id tăng mã hdong giảm
	public static Comparator<HoatDongDoanVien> IDTang_MHDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// id giảm mã hdong tăng
	public static Comparator<HoatDongDoanVien> IDGiam_MHDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// id giảm mã hdong giảm  
	public static Comparator<HoatDongDoanVien> IDGiam_MHDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = IDCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MSV tăng id tăng
	public static Comparator<HoatDongDoanVien> MSVTang_IDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	//  MSV tăng id giảm
	public static Comparator<HoatDongDoanVien> MSVTang_IDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// MSV giảm id tăng
	public static Comparator<HoatDongDoanVien> MSVGiam_IDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MSV giảm id giảm
	public static Comparator<HoatDongDoanVien> MSVGiam_IDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MSV tăng MHD tăng
	public static Comparator<HoatDongDoanVien> MSVTang_MHDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// MSV tăng MHD giảm
	public static Comparator<HoatDongDoanVien> MSVTang_MHDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// MSV giảm MHD tăng
	public static Comparator<HoatDongDoanVien> MSVGiam_MHDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MSV giảm MHD giảm
	public static Comparator<HoatDongDoanVien> MSVGiam_MHDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MSVCmp.compare(o1, o2);
			if (value == 0) {
				if (MHDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MHD tăng id tăng
	public static Comparator<HoatDongDoanVien> MHDTang_IDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//  MHD tăng id giảm
	public static Comparator<HoatDongDoanVien> MHDTang_IDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// MHD giảm id tăng
	public static Comparator<HoatDongDoanVien> MHDGiam_IDTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MHD giảm id giảm
	public static Comparator<HoatDongDoanVien> MHDGiam_IDGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (IDCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// MHD tăng msv tăng
	public static Comparator<HoatDongDoanVien> MHDTang_MSVTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	//MHD tăng msv giảm
	public static Comparator<HoatDongDoanVien> MHDTang_MSVGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// MHD giảm msv tăng
	public static Comparator<HoatDongDoanVien> MHDGiam_MSVTang = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {
			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// MHD giảm msv giảm
	public static Comparator<HoatDongDoanVien> MHDGiam_MSVGiam = new Comparator<HoatDongDoanVien>() {
		@Override
		public int compare(HoatDongDoanVien o1, HoatDongDoanVien o2) {

			int value = MHDCmp.compare(o1, o2);
			if (value == 0) {
				if (MSVCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;

		}
	};

}
