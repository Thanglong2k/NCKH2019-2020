package export_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import object_frame.ChiDoan;
import object_frame.DanhGiaRLSV;
import object_frame.GiangVien;
import object_frame.HoatDong;
import object_frame.HoatDongDoanVien;
import object_frame.Student;
import object_frame.XepLoaiDV;

public class writerExcel {

	public static void ghifileexcel(String linkfile, List<Student> studentList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Ä�oÃ n ViÃªn");
		List<Student> list = studentList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("MSV ");
//	        cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ ");
//	        cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên ");
//	        cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("CMND ");
//	        cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Ngày Sinh ");
//	        cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Quê Quán ");
//	        cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Giới Tính ");
//	        cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Ngày Vào Đoàn ");
//	        cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Ngày Vào Đảng ");
//	        cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Điện Thoại ");
//	        cell.setCellStyle(style);

		cell = row.createCell(10, CellType.STRING);
		cell.setCellValue("Email ");
//	        cell.setCellStyle(style);

		cell = row.createCell(11, CellType.STRING);
		cell.setCellValue("Mã Chi Đoàn ");
//	        cell.setCellStyle(style);

		cell = row.createCell(12, CellType.STRING);
		cell.setCellValue("Chức Vụ ");
//	        cell.setCellStyle(style);

		cell = row.createCell(13, CellType.STRING);
		cell.setCellValue("Tôn Giáo ");
//	        cell.setCellStyle(style);

		cell = row.createCell(14, CellType.STRING);
		cell.setCellValue("Dân Tộc ");
//	        cell.setCellStyle(style);

		cell = row.createCell(15, CellType.STRING);
		cell.setCellValue("Nơi Sinh ");
//	        cell.setCellStyle(style);

		cell = row.createCell(16, CellType.STRING);
		cell.setCellValue("Địa Chỉ Hiện Tại ");
//	        cell.setCellStyle(style);

		cell = row.createCell(17, CellType.STRING);
		cell.setCellValue("Năng Khiếu ");
//	        cell.setCellStyle(style);

		cell = row.createCell(18, CellType.STRING);
		cell.setCellValue("Hoàn Cảnh GĐ ");
//	        cell.setCellStyle(style);

		cell = row.createCell(19, CellType.STRING);
		cell.setCellValue("Ghi Chú ");
//	        cell.setCellStyle(style);

		cell = row.createCell(20, CellType.STRING);
		cell.setCellValue("Điểm Tích Lũy ");
//	        cell.setCellStyle(style);

		for (int i = 0; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// ---------data-----------------------------
		// dÆ° liÃªu trong cÆ¡ sÆ¡ lieu Ä‘Æ°Æ¡c Ä‘Æ°a voÃ 
		for (Student s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(s.getMaSV());

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getHo());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(s.getTen());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getCMND());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getNgSinh());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(s.getQueQuan());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(s.getGioiTinh());

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue(s.getNgVaoDoan());

			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue(s.getNgVaoDang());

			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue(s.getDienThoai());

			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue(s.getEmail());

			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaChiDoan()));

			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue(s.getChucVu());

			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue(s.getTonGiao());

			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue(s.getDanToc());

			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue(s.getNoiSinh());

			cell = row.createCell(16, CellType.STRING);
			cell.setCellValue(s.getDiaChiHT());

			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue(s.getNangKhieu());

			cell = row.createCell(18, CellType.STRING);
			cell.setCellValue(s.getHoanCanhGD());

			cell = row.createCell(19, CellType.STRING);
			cell.setCellValue(s.getGhiChu());

			cell = row.createCell(20, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getDiemTL()));

			for (int i = 0; i <= 20; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();

	}

	public static void ghiFileExcelHoatDong(String linkfile, List<HoatDong> hoatdongList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Hoạt Động");
		List<HoatDong> list = hoatdongList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã Hoạt Động ");

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Tên Hoạt Động ");

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Loại Hoạt Động ");

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Thời Gian");

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Đơn Vị Tổ Chức");

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Thông Tin Chi Tiết ");

		for (int i = 0; i <= 5; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (HoatDong s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaHoatDong()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getTenHoatDong());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(s.getLoaiHoatDong());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getThoiGian());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getDonViToChuc());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(s.getThongTinChiTiet());

			for (int i = 0; i <= 5; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	public static void ghiFileExcelHDDV(String linkfile, List<HoatDongDoanVien> hddvList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Hoạt Động Đoàn Viên");
		List<HoatDongDoanVien> list = hddvList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("ID ");

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã Sinh Viên ");

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Mã Hoạt Động ");

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Thành Tích");


		for (int i = 0; i <= 3; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (HoatDongDoanVien s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getID()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getMaSV());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaHoatDong()));

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getThanhTich());

			for (int i = 0; i <= 3; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	
	public static void ghiFileExcelRLSV(String linkfile, List<DanhGiaRLSV> rlsvList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Đánh Giá Rèn Luyện Đoàn Viên");
		List<DanhGiaRLSV> list = rlsvList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã Đánh Giá ");

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Năm Học ");

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Học Kỳ ");



		for (int i = 0; i <= 2; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (DanhGiaRLSV s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaDG()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getNamHoc());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getHocKy()));


			for (int i = 0; i <= 2; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	
	public static void ghiFileExcelXLDV(String linkfile, List<XepLoaiDV> xldvList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Xếp Loại Đoàn Viên");
		List<XepLoaiDV> list = xldvList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã Đánh Giá ");

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã Sinh Viên ");

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Xếp Loại ");

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Ghi Chú ");

		for (int i = 0; i <= 3; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (XepLoaiDV s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaDG()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaSV()));

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(s.getXepLoai());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getGhiChu());

			for (int i = 0; i <= 3; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	
	public static void ghiFileExcelGV(String linkfile, List<GiangVien> gvList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Giảng Viên");
		List<GiangVien> list=gvList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã Giảng Viên");

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ Tên ");

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Bộ Môn ");

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Khoa ");
		
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Số Điện Thoại ");
		
		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Email");

		for (int i = 0; i <= 5; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (GiangVien s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaGV()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getHoTen()));

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(s.getBoMon());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getKhoa());
			
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getSDT());
			
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(s.getEmail());

			for (int i = 0; i <= 5; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	
	
	public static void ghiFileExcelCD(String linkfile, List<ChiDoan> gvList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Chi Đoàn");
		List<ChiDoan> list=gvList;

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã Chi Đoàn");
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Tên Chi Đoàn ");
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Khóa");

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Mã Giảng Viên");

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Thông Tin Cán Bộ Lớp ");
		
		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Số Lượng Đoàn Viên ");
		
		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Mã Liên Chi");

		for (int i = 0; i <= 6; i++) {
			sheet.autoSizeColumn(i);
		}
		/*
		 * Đẩy Dữ Liệu Ra Excel
		 */
		for (ChiDoan s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaChiDoan()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getTenChiDoan());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(s.getKhoaz());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaGV()));
			
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getTTCanBoLop());
			
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getSoLuongDoanVien()));
			
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaLienChiDoan()));

			for (int i = 0; i <= 6; i++) {
				sheet.autoSizeColumn(i);
			}

		}

		File file = new File(linkfile);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		outFile.close();
	}
	
}