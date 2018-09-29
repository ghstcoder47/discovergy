package com.janas.rewardssimulator.business.sale.boundary;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.janas.rewardssimulator.business.sale.entity.SalesRecord;

public class CSVDataSalesRecordManager {
	
		
	public static void save(List<SalesRecord> salesRecords) {
		
		try (
				ICsvBeanWriter beanWriter =	new CsvBeanWriter(
						new FileWriter("salesReport.csv"),
						CsvPreference.STANDARD_PREFERENCE);
				) {
			
			String[] headers = SalesRecordProcessor.WRITE.getHeader();
			CellProcessor[] processors = SalesRecordProcessor.WRITE.getProcessors();
			
			beanWriter.writeHeader(headers);
			
			for (SalesRecord salesRecord : salesRecords) {
	            beanWriter.write(salesRecord, headers, processors );
	        }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<SalesRecord> findAll() {
		
		return findAll("salesReport.csv");
		
	}
	
	public static List<SalesRecord> findAll(String fileName) {
		
		List<SalesRecord> result = new ArrayList<>();
		
		try (
				ICsvBeanReader beanReader = new CsvBeanReader(
						new FileReader(fileName), 
						CsvPreference.STANDARD_PREFERENCE);
				) {
			
			final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = SalesRecordProcessor.READ.getProcessors();
            
            SalesRecord salesRecord;
            
            while( null != ( salesRecord = beanReader.read(SalesRecord.class, header, processors) ) ) {
            	
            	result.add(salesRecord);
            }
            
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return result;
	}

}
