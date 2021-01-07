package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLGiangVien;
import object_frame.GiangVien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StandardCmpGiangVien {

	// sap xep the ten
	public static Comparator<GiangVien> TenCmp = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int diff = o1.getHoTen().compareToIgnoreCase(o2.getHoTen());

			return diff;
		}

	};

	// sap xep theo khoa
	public static Comparator<GiangVien> KhoaCmp = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int diff = o1.getKhoa().compareToIgnoreCase(o2.getKhoa());

			return diff;
		}

	};

	// sap xep theo BoMon
	public static Comparator<GiangVien> BoMonCmp = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int diff = o1.getBoMon().compareToIgnoreCase(o2.getBoMon());

			return diff;
		}

	};

	/*
	 * //sap xep Ten A-> Z //
	 * ____________________________________________________________________________________
	 * //
	 * 
	 * ----------------------- // <-_-> //---------------------------
	 * 
	 * ---------------------------------------------
	 */

	public static Comparator<GiangVien> TenAZ = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Ten = TenCmp.compare(o1, o2);
			if ( Ten> 0) {
				return 1;
			}

			return -1;
		}
	};

	public static Comparator<GiangVien> TenAZ_Khoa = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Khoa = KhoaCmp.compare(o1, o2);
			int Ten = TenCmp.compare(o1, o2);
			if (Khoa== 0) {
				if (Ten > 0) {
					return 1;
				}
			} else if (Khoa> 0)
				return 1;

			return -1;
		}
	};

	public static Comparator<GiangVien> TenAZ_Khoa_BoMon = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {

			int Khoa = KhoaCmp.compare(o1, o2);
			int BoMon= BoMonCmp.compare(o1, o2);
			int Ten = TenCmp.compare(o1, o2);
			if (Khoa == 0) {
				
				if (BoMon == 0)

				{
					if (Ten > 0) return 1;
				}

				else if (BoMon> 0) return 1;
			} else if (Khoa > 0)
				return 1;
			return -1;
		}
	};

	public static Comparator<GiangVien> TenAZ_BoMon = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Ten = TenCmp.compare(o1, o2);
			int BoMon= BoMonCmp.compare(o1, o2);
			if (BoMon== 0)

			{
				if (Ten > 0) {
					return 1;
				}
			} else if (BoMon> 0)
				return 1;

			return -1;
		}
	};

	/*
	 * //sap xep Ten Z-> Á //
	 * ____________________________________________________________________________________
	 * //
	 * 
	 * ----------------------- // (*_*) //---------------------------
	 * 
	 * \---------------------------------------------/
	 */

	public static Comparator<GiangVien> TenZA = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Ten=TenCmp.compare(o1, o2) ;
			if (Ten< 0) {
				return 1;
			}

			return -1;
		}
	};

	public static Comparator<GiangVien> TenZA_Khoa = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Khoa = KhoaCmp.compare(o1, o2);
			int Ten = TenCmp.compare(o1, o2);
			if (Khoa == 0) {

				if (Ten < 0) {
					return 1;
				}
			} else if (Khoa > 0)
				
				return 1;

			return -1;
		}
	};

	public static Comparator<GiangVien> TenZA_Khoa_BoMon = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Khoa = KhoaCmp.compare(o1, o2);
			int BoMon= BoMonCmp.compare(o1, o2);
			int Ten = TenCmp.compare(o1, o2);

			if (Khoa== 0)  {
				if (BoMon == 0)

				{
					if (Ten < 0) {
						return 1;
					}
				} else if (BoMon > 0)
					return 1;

			} else if (Khoa> 0)
				return 1;

			return -1;
		}
	};

	public static Comparator<GiangVien> TenZA_BoMon = new Comparator<GiangVien>() {
		@Override
		public int compare(GiangVien o1, GiangVien o2) {
			int Ten = TenCmp.compare(o1, o2);
			int BoMon = BoMonCmp.compare(o1, o2);

			if (BoMon==0)

			{
				if (Ten < 0)
					return 1;

			} else if (BoMon > 0)
				return 1;

			return -1;
		}
	};

}
