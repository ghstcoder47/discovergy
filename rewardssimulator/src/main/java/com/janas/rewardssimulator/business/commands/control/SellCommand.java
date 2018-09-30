package com.janas.rewardssimulator.business.commands.control;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sales.boundary.ContractAction;
import com.janas.rewardssimulator.business.sales.boundary.ContractType;
import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

public class SellCommand {

	public static void perform(StringTokenizer command) {
				
		if (command.countTokens() == 3) {
			long pid = Long.parseLong(command.nextToken());
			long cid = Long.parseLong(command.nextToken());
			String contractType = command.nextToken().toUpperCase();
			
			SalesRecord salesRecord = new SalesRecord();
			salesRecord.setPartnerId(pid);
			salesRecord.setContractId(cid);
			salesRecord.setContractType(ContractType.valueOf(contractType));
			
			Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
			salesRecord.setSellDate(Date.from(instant));
			
			salesRecord.setAction(ContractAction.BEGIN);
			
			List<SalesRecord> salesRecords = CSVDataSalesRecordManager.findAll();
			salesRecords.add(salesRecord);
			
			CSVDataSalesRecordManager.save(salesRecords);
			
		} else {
			System.out.println("SELL command war nicht korrekt: " + command.toString());
		}
	}

}