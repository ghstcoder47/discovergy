package com.janas.rewardssimulator;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.janas.rewardssimulator.business.partner.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partner.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.partner.entity.Partner;
import com.janas.rewardssimulator.business.sale.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sale.boundary.ContractType;
import com.janas.rewardssimulator.business.sale.entity.SalesRecord;

public class Main {

	public static void main(String[] args) {
		
		
		List<SalesRecord> salesRecords = new ArrayList<>();
				
		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
				
		salesRecords.add(new SalesRecord(1,1,ContractType.RABBIT,Date.from(instant) , "BEGIN"));
		salesRecords.add(new SalesRecord(2,2,ContractType.TORTOISE,Date.from(instant) , "BEGIN"));
		salesRecords.add(new SalesRecord(1,3,ContractType.TORTOISE,Date.from(instant) , "BEGIN"));
		
		
		
		List<Partner> partners = new ArrayList<>();
		partners.add(new Partner(1, PartnerLevel.ANT));
		partners.add(new Partner(2, PartnerLevel.BEE));
		partners.add(new Partner(3, 2, PartnerLevel.ANT));
		
		CSVPartnerManager.save(partners);
		
		CSVPartnerManager.findAll()
			.stream()
			.map(partner -> partner.getLevel())
			.forEach(System.out::println);
		
		
		CSVDataSalesRecordManager.save(salesRecords);
		
			
		CSVDataSalesRecordManager.findAll()
			.stream()
			.map(salesRecord -> salesRecord.getSellDate())
			.forEach(System.out::println);
		
                    		
           

	}

}
