package com.accenture.profiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DirectoryReport {

	private static List<FileProperties> filesProperties = new ArrayList<>();
	private static String dirName;

	public static void main(String[] args) throws IOException {
		String directory="C:\\Users\\neeraj.bd.kumar\\.m2";
		dirName=directory.substring(directory.lastIndexOf("\\")+1);
		try {
			loadFilesProperties(directory);
			System.out.println("File Properties Loaded SuccessFully!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		writeToCSV();
		writeToExcel();

	}

	private static void loadFilesProperties(String dir) throws IOException {
		File dirPath = new File(dir);
		if (dirPath.isDirectory()) {
			System.out.println("Inside Directory:: " + dirPath);
			File[] dirFiles = dirPath.listFiles();
			for (File dirFile : dirFiles) {
				loadFilesProperties(dirFile.getAbsolutePath());
			}
		} else {
			addFileProperties(dirPath);
		}
		
	}

	private static void addFileProperties(File fileProps) {
		FileProperties fileProperties = new FileProperties();
		fileProperties.setFileName(fileProps.getName());
		fileProperties.setParentDirectory(fileProps.getParent().substring(fileProps.getParent().lastIndexOf("\\") + 1));
		fileProperties.setAbsolutePath(fileProps.getAbsolutePath());
		fileProperties.setFileSize(fileProps.length() / 1000 + " KB");
		fileProperties.setLastModifiedTime(fileProps.lastModified());
		filesProperties.add(fileProperties);
		//System.out.println(fileProperties);

	}

	private static void writeToCSV() throws IOException {
		System.out.println("Generating CSV Report...");

		FileWriter outputFileWriter = new FileWriter("C:\\Users\\neeraj.bd.kumar\\Desktop\\workspace\\outputFiles\\DirectoryReport"+"_"+dirName+".csv");

		CSVPrinter csvRecordPrinter = new CSVPrinter(outputFileWriter,
				CSVFormat.DEFAULT.withHeader("FileName", "ParentDirectory", "AbsoloutePath", "Size", "LastModified"));

		filesProperties.parallelStream().forEach(thisFileProperties -> printThisRecord(thisFileProperties, csvRecordPrinter));

		csvRecordPrinter.close();
		System.out.println("CSV Report Generated SuccessFully!");


	}

	private static void printThisRecord(FileProperties thisFileProperties, CSVPrinter csvRecordPrinter) {
		try {
			csvRecordPrinter.printRecord(thisFileProperties.getFileName(), thisFileProperties.getParentDirectory(),
					thisFileProperties.getAbsolutePath(), thisFileProperties.getFileSize(), getDateTimeFromLong(thisFileProperties.getLastModifiedTime()));
		} catch (Exception ex) {
			System.out.println("Some Error Occured Processing this Record:: " + thisFileProperties);
		}
	}

	private static void writeToExcel() throws IOException {
		System.out.println("Generating EXCEL Report...");

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet spreadsheet = workbook.createSheet("Report");
			
			Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 12);
	        headerFont.setColor(IndexedColors.WHITE.index);
	       

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);
	        //headerCellStyle.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.index);
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			Row headerRow= spreadsheet.createRow(0);
			Cell firstCell=headerRow.createCell(0);
			firstCell.setCellValue("FileName");
			firstCell.setCellStyle(headerCellStyle);
			
			Cell secondCell=headerRow.createCell(1);
			secondCell.setCellValue("ParentDirectory");
			secondCell.setCellStyle(headerCellStyle);
			
			Cell thirdCell=headerRow.createCell(2);
			thirdCell.setCellValue("AbsolutePath");
			thirdCell.setCellStyle(headerCellStyle);
			
			Cell fourthCell=headerRow.createCell(3);
			fourthCell.setCellValue("Size");
			fourthCell.setCellStyle(headerCellStyle);
			
			Cell fifthCell=headerRow.createCell(4);
			fifthCell.setCellValue("LastModified");
			fifthCell.setCellStyle(headerCellStyle);
			
			
			
			int rownum = 1;
			for (FileProperties fileProperties : filesProperties) {
				Row row = spreadsheet.createRow(rownum++);
				createRowCells(fileProperties, row);
			}
			
//			AtomicInteger rowNumber= new AtomicInteger(1);
//			filesProperties.parallelStream().forEach(fileProps-> {
//				Row row = spreadsheet.createRow(rowNumber.incrementAndGet());
//				createRowCells(fileProps, row);
//			});
			
			
			autoSizeColumns(spreadsheet);
			
			spreadsheet.setZoom(90);
			 
			FileOutputStream outputStream = new FileOutputStream(
					new File("C:\\Users\\neeraj.bd.kumar\\Desktop\\workspace\\outputFiles\\DirectoryReport"+"_"+dirName+".xlsx")); // file name with path
			workbook.write(outputStream);
			outputStream.close();
			System.out.println("Excel Report Generated SuccessFully!");
		}
	}

	private static void autoSizeColumns(XSSFSheet spreadsheet) {
		Row row = spreadsheet.getRow(0);
		  Iterator<Cell> cellIterator = row.cellIterator();
		  while (cellIterator.hasNext()) {
		    Cell cell = cellIterator.next();
		    int columnIndex = cell.getColumnIndex();
		    spreadsheet.autoSizeColumn(columnIndex);
		  }
	}

	private static void createRowCells(FileProperties fileProperties, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(fileProperties.getFileName());

		cell = row.createCell(1);
		cell.setCellValue(fileProperties.getParentDirectory());

		cell = row.createCell(2);
		cell.setCellValue(fileProperties.getAbsolutePath());

		cell = row.createCell(3);
		cell.setCellValue(fileProperties.getFileSize());
		
		cell = row.createCell(4);
		cell.setCellValue(getDateTimeFromLong(fileProperties.getLastModifiedTime()));

	}
	
	private static String getDateTimeFromLong(long longDate) {
		
		    Date date = new Date(longDate);
		    Format format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    return format.format(date);
		
	}

}
