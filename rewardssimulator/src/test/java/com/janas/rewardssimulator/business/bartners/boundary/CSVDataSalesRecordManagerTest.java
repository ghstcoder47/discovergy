package com.janas.rewardssimulator.business.bartners.boundary;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sales.boundary.ContractAction;
import com.janas.rewardssimulator.business.sales.boundary.ContractType;
import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

public class CSVDataSalesRecordManagerTest {
	
	List<SalesRecord> salesRecords;
	Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
	
	@Before
	public void init() {
		
//		Path fileToBeDeleted = Paths.get("salesReport.csv");
//		if (fileToBeDeleted.toFile().exists()) {			
//			try {
//				Files.delete(fileToBeDeleted);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		salesRecords = new ArrayList<>();
		
		salesRecords.add(new SalesRecord(1, 1,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 2,ContractType.TORTOISE, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 3,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 4,ContractType.TORTOISE, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 5,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 6,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 7,ContractType.TORTOISE, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(2, 5,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(2, 6,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(2, 7,ContractType.TORTOISE, Date.from(instant), ContractAction.BEGIN));
		
		
	}
	
	@Test
	public void testSave() {
		CSVDataSalesRecordManager.save(salesRecords);
		int count = CSVDataSalesRecordManager.findAll().size();
		assertThat(count, equalTo(10));	
		
		long parentSales = CSVDataSalesRecordManager.countSalesForPartner(1, 2018, 3);
		assertThat(parentSales, equalTo(7L));	
		assertThat(PartnerLevel.computeLevel(parentSales), equalTo(PartnerLevel.ANT));
	}

	
	@Test
	public void testCountSalesForPartnerAndIncrementLevel() {
		
		
		salesRecords.add(new SalesRecord(1, 1,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 1,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		salesRecords.add(new SalesRecord(1, 1,ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
		CSVDataSalesRecordManager.save(salesRecords);
		
		long count = CSVDataSalesRecordManager.countSalesForPartner(1, 2018, 3);
		assertThat(count, equalTo(10L));	
		assertThat(PartnerLevel.computeLevel(count), equalTo(PartnerLevel.BEE));
	}
	
	
}
