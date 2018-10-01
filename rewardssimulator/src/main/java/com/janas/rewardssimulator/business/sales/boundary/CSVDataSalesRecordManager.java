package com.janas.rewardssimulator.business.sales.boundary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

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
	
	public static List<SalesRecord> findSalesForPartner(long partnerId, int year, int quartal) {
		
		return findSalesForPartner(partnerId)
				.stream()
				.filter(sale -> {
					Calendar calendar = new GregorianCalendar();
					calendar.setTime(sale.getSellDate());
					return calendar.get(Calendar.YEAR) <= year 
							&& computeQuartal(calendar) <= quartal;
					})
				.collect(Collectors.toList());

	}
	
	public static List<SalesRecord> findSalesForPartner(long partnerId) {
		
		return findAll().stream()
				.filter(sale -> sale.getPartnerId() == partnerId)
				.filter(sale -> sale.getAction().equals(ContractAction.BEGIN))
				.collect(Collectors.toList());
	}

	private static int computeQuartal(Calendar calendar) {
		return ((calendar.get(Calendar.MONTH)) / 3) + 1;
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
            
		} catch (FileNotFoundException e) {
			System.out.println("partner.csv wurde nicht gefunden und wird neu angelegt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void updateSalesRecordActionStatus() {
		

		Date eightYearsAgo = eightYearsAgo();		
		
		List<SalesRecord> allSalesRecords = findAll();
				
		allSalesRecords.stream()
		.filter( record -> {			
			return record.getSellDate().before(eightYearsAgo);
		})
		.forEach(record -> record.setAction(ContractAction.END));
		
		CSVDataSalesRecordManager.save(allSalesRecords);
	}

	private static Date eightYearsAgo() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -8);
		Date eightYearsAgo = cal.getTime();
		return eightYearsAgo;
	}

}
