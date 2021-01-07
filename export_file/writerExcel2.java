package export_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import object_frame.KyLuat;
import modify_object.StudentModify;
import object_frame.Student;
import object_frame.KhenThuong;

public class writerExcel2 {
	
	public static Map<String , String> M=new HashMap<String, String>();
	
	public static void getData() {
		List<Student> lstd = StudentModify.findAll();
		for(Student a : lstd) {
			M.put(a.getMaSV(), a.getHo() + ' ' + a.getTen());
		}
	}
	
	public static void ghiFileExcelKT(String linkfile, List<KhenThuong> khenthuongList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Khen Thưởng");
		List<KhenThuong> list = khenthuongList;
		
		getData();
		
		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã số Khen Thưởng ");
//	        cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã đoàn viên ");
//	        cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên đoàn viên ");
//	        cell.setCellStyle(style);		
		
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Lý do ");
//	        cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Nội dung ");
//	        cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Ngày Khen Thưởng ");
//	        cell.setCellStyle(style);

		

		for (int i = 0; i <= 5; i++) {
			sheet.autoSizeColumn(i);
		}

		// ---------data-----------------------------
		// dÆ° liÃªu trong cÆ¡ sÆ¡ lieu Ä‘Æ°Æ¡c Ä‘Æ°a voÃ 
		for (KhenThuong s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaSo()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getMaDV());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(String.valueOf(M.get(s.getMaDV())));
			
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getLyDo());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getNoiDung());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(s.getNgayKhenThuong());

			

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
	
	public static void ghiFileExcelKL(String linkfile, List<KyLuat> kyluatList)
			throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Kỷ Luật");
		List<KyLuat> list = kyluatList;
		getData();
		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã số Kỷ Luật ");
//	        cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã đoàn viên ");
//	        cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên đoàn viên ");
//	        cell.setCellStyle(style);		
		
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Lý do ");
//	        cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Nội dung ");
//	        cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Ngày Kỷ Luật ");
//	        cell.setCellStyle(style);

		

		for (int i = 0; i <= 5; i++) {
			sheet.autoSizeColumn(i);
		}

		// ---------data-----------------------------
		// dÆ° liÃªu trong cÆ¡ sÆ¡ lieu Ä‘Æ°Æ¡c Ä‘Æ°a voÃ 
		for (KyLuat s : list) {
			rownum++;
			row = sheet.createRow(rownum);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(String.valueOf(s.getMaSo()));

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(s.getMaDV());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(String.valueOf(M.get(s.getMaDV())));
			
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(s.getLyDo());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(s.getNoiDung());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(s.getNgayKyLuat());

			

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
	
}
