package check_data;

import java.util.Comparator;

import object_frame.Student;

public class StandardCmpDoanVien {
//	public static List<Student> studentList = QLDoanVien.studentList;

	public static Comparator<Student> TenCmp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int diff = o1.getTen().compareToIgnoreCase(o2.getTen());

			return diff;
		}
	};

	public static Comparator<Student> DiemTLCmp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int diff = Float.compare(o1.getDiemTL(), o2.getDiemTL());

			return diff;
		}
	};

	public static Comparator<Student> NgVDoanCmp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			String date1 = o1.getNgVaoDoan().trim();
			String[] ngvdoan1 = date1.split("-");
			String date2 = o2.getNgVaoDoan().trim();
			String[] ngvdoan2 = date2.split("-");

			if (ngvdoan1[0].compareTo(ngvdoan2[0]) != 0) {
				return ngvdoan1[0].compareTo(ngvdoan2[0]);
			} else {
				if (ngvdoan1[1].compareTo(ngvdoan2[1]) != 0) {
					return ngvdoan1[1].compareTo(ngvdoan2[1]);
				} else {
					return ngvdoan1[2].compareTo(ngvdoan2[2]);
				}
			}

		}
	};
	// sắp xếp theo tên A-Z và điểm tăng dần
	public static Comparator<Student> TenAZ_DiemTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và điểm Giảm
	public static Comparator<Student> TenAZ_DiemGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và điểm tăng
	public static Comparator<Student> TenZA_DiemTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và điểm giảm
	public static Comparator<Student> TenZA_DiemGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và ngày tăng
	public static Comparator<Student> TenAZ_NgayTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên A-Z và ngày giảm
	public static Comparator<Student> TenAZ_NgayGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và ngày tăng
	public static Comparator<Student> TenZA_NgayTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Z-A và ngày giảm
	public static Comparator<Student> TenZA_NgayGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = TenCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Ngày tăng và tên từ A-Z
	public static Comparator<Student> NgayTang_TenAZ = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};
	// Ngày tăng và tên từ Z-A
	public static Comparator<Student> NgayTang_TenZA = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// Ngày Giảm và tên từ A-Z
	public static Comparator<Student> NgayGiam_TenAZ = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// Ngày Giảm và tên từ Z-A
	public static Comparator<Student> NgayGiam_TenZA = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo ngày tăng và điểm tăng
	public static Comparator<Student> NgayTang_DiemTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo ngày tăng và điểm Giảm
	public static Comparator<Student> NgayTang_DiemGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo ngày Giảm và điểm Tăng
	public static Comparator<Student> NgayGiam_DiemTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo ngày Giảm và điểm giảm
	public static Comparator<Student> NgayGiam_DiemGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = NgVDoanCmp.compare(o1, o2);
			if (value == 0) {
				if (DiemTLCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo điểm tăng và ngày tăng
	public static Comparator<Student> DiemTang_NgayTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo điểm tăng và ngày giảm
	public static Comparator<Student> DiemTang_NgayGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo điểm Giảm và ngày tăng
	public static Comparator<Student> DiemGiam_NgayTang = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo điểm Giảm và ngày giảm
	public static Comparator<Student> DiemGiam_NgayGiam = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (NgVDoanCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Điểm tăng và tên A-Z
	public static Comparator<Student> DiemTang_TenAZ = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Điểm tăng và tên Z-A
	public static Comparator<Student> DiemTang_TenZA = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
			} else if (value > 0)
				return 1;
			return -1;
		}
	};

	// sắp xếp theo tên Điểm giảm và tên A-Z
	public static Comparator<Student> DiemGiam_TenAZ = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int value = DiemTLCmp.compare(o1, o2);
			if (value == 0) {
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			} else if (value < 0)
				return 1;
			return -1;
		}
	};
	// sắp xép theo diểm giảm và tên Z-A
	public static Comparator<Student> DiemGiam_TenZA = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {

			int value = DiemTLCmp.compare(o1, o2);
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
