package com.janas.rewardssimulator;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.janas.rewardssimulator.business.sale.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sale.entity.SalesRecord;

public class Main {

	public static void main(String[] args) {
		
		
		List<SalesRecord> salesRecords = new ArrayList<>();
				
		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
				
		salesRecords.add(new SalesRecord(1,1,"RABBIT",Date.from(instant) , "BEGIN"));
		salesRecords.add(new SalesRecord(1,2,"RABBIT",Date.from(instant) , "BEGIN"));
		salesRecords.add(new SalesRecord(1,3,"TORTOISE",Date.from(instant) , "BEGIN"));
				
		CSVDataSalesRecordManager.save(salesRecords);
		
		/////////////////////////////////////////////////////
		
		 
		
		CSVDataSalesRecordManager.findAll()
			.stream()
			.map(salesRecord -> salesRecord.getSellDate())
			.forEach(System.out::println);
		
                    		
           

	}

}
