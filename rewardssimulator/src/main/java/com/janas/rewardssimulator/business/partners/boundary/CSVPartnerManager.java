package com.janas.rewardssimulator.business.partners.boundary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.janas.rewardssimulator.business.partners.entity.Partner;

public class CSVPartnerManager {
	
	

	public static void save(List<Partner> partners) {
		
		try (
				ICsvBeanWriter beanWriter =	new CsvBeanWriter(
						new FileWriter("partner.csv"),
						CsvPreference.STANDARD_PREFERENCE);
				) {
			
			String[] headers = PartnerProcessor.READ_WRITE.getHeader();
			CellProcessor[] processors = PartnerProcessor.READ_WRITE.getProcessors();
			
			beanWriter.writeHeader(headers);
			
			for (Partner partner : partners) {
	            beanWriter.write(partner, headers, processors );
	        }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Partner> findAll() {
		
		List<Partner> result = new ArrayList<>();
		
		try (
				ICsvBeanReader beanReader = new CsvBeanReader(
						new FileReader("partner.csv"), 
						CsvPreference.STANDARD_PREFERENCE);
				) {
			
			final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = PartnerProcessor.READ_WRITE.getProcessors();
            
            Partner partner;
            
            while( null != ( partner = beanReader.read(Partner.class, header, processors) ) ) {
            	
            	result.add(partner);
            }	
		} catch (FileNotFoundException e) {
			System.out.println("salesReport.csv wurde nicht gefunden und wird neu angelegt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static List<Partner> findSubPartners(long parentPartnerId) {
		
		return findAll()
				.stream()
				.filter(p -> p.getParentPartnerId() == parentPartnerId)
				.collect(Collectors.toList());
	}
}
