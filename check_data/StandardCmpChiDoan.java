package check_data;

import java.util.Comparator;
import java.util.List;

import frame.QLDoanVien;
import frame.QLChiDoan;
import frame.QLGiangVien;
import object_frame.ChiDoan;
import object_frame.GiangVien;
import object_frame.LienChi;
import object_frame.Student;

public class StandardCmpChiDoan {
	
	public static Comparator<ChiDoan> TenCmp = new Comparator<ChiDoan>() {
		@Override
		public int compare(ChiDoan o1, ChiDoan o2) {
			int diff = o1.getTenChiDoan().compareToIgnoreCase(o2.getTenChiDoan());
			return diff;
		}

	};
	

	public static Comparator<ChiDoan> MaLienChi = new Comparator<ChiDoan>() {
		@Override
		public int compare(ChiDoan o1, ChiDoan o2) {
			if( o1.getMaLienChiDoan()>o2.getMaLienChiDoan()) return 1;
			else if (o1.getMaLienChiDoan()<o2.getMaLienChiDoan()) {
	return -1;
			}
			else return 0;
		}

	};
	
	
	public static Comparator<ChiDoan> TenAZ = new Comparator<ChiDoan>()  {
		@Override
		public int compare(ChiDoan o1, ChiDoan o2) {
			
				if (TenCmp.compare(o1, o2) > 0) {
					return 1;
				}
			
			return -1;
		}
	};
	// sap xep theo ten chi doan tu Z-> A
		public static Comparator<ChiDoan> TenZA = new Comparator<ChiDoan>()  {
			@Override
			public int compare(ChiDoan o1, ChiDoan o2) {
				
					if (TenCmp.compare(o1, o2) < 0) {
						return 1;
					}
				
				return -1;
			}
		};
	
	
		public static Comparator<ChiDoan> TenAZ_LienChi = new Comparator<ChiDoan>() {
			@Override
			public int compare(ChiDoan o1, ChiDoan o2) {
				if (MaLienChi.compare(o1, o2) == 0) {
					if (TenCmp.compare(o1, o2) > 0) {
						return 1;
					}
					
				} else if (MaLienChi.compare(o1, o2) < 0)
					return 1;
				
				return -1;
			}
		};
		public static Comparator<ChiDoan> TenZA_LienChi = new Comparator<ChiDoan>() {
		public int compare(ChiDoan o1, ChiDoan o2) {
			if (MaLienChi.compare(o1, o2) == 0) {
				if (TenCmp.compare(o1, o2) < 0) {
					return 1;
				}
				
			} else if (MaLienChi.compare(o1, o2) < 0)
				return 1;
			
			return -1;
		}
	};
	


}
