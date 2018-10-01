package com.janas.rewardssimulator.business.interaction.control;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.partners.entity.Partner;
import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

public class RewardsCommand {

	public static void perform(StringTokenizer command) {
		
		if (command.countTokens() == 1) {
			
			long pid = Long.parseLong(command.nextToken());
			
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(pid);
			
			List<SalesRecord> salesRecords = CSVDataSalesRecordManager.findSalesForPartner(pid);			
			subPartners.stream()
				.forEach(p -> {
					salesRecords.addAll(CSVDataSalesRecordManager.findSalesForPartner(p.getPartnerId()));
				});
			
			
			Calendar calendar = new GregorianCalendar();
			SalesRecord firstRecord = salesRecords.get(0);	
			
			int initialYear = getInitialYear(calendar, firstRecord);
			
			int currentYear = getYearIntervallEnd(calendar);
			
			initialYear = printPartnersRewards(pid, subPartners, initialYear, currentYear);
			
		}
		
		if (command.countTokens() == 3) {
						
			long pid = Long.parseLong(command.nextToken());
			int year = Integer.parseInt(command.nextToken());
			int quarter = Integer.parseInt(command.nextToken());
			
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(pid);
			List<SalesRecord> salesRecords = CSVDataSalesRecordManager.findSalesForPartner(pid, year, quarter);
			
			printRewardsForParicularTime(year, quarter, subPartners, salesRecords);
			
		}
	}

	private static void printRewardsForParicularTime(int year, int quarter, List<Partner> subPartners,
			List<SalesRecord> salesRecords) {
		subPartners.stream()
			.forEach(p -> {
				salesRecords.addAll(CSVDataSalesRecordManager.findSalesForPartner(p.getPartnerId(), year, quarter));
			});
		
		long rewards = PartnerLevel.computeLevel(salesRecords.size()).getReward() * salesRecords.size();
		
		System.out.println(rewards);
	}

	private static int printPartnersRewards(long pid, List<Partner> subPartners, int initialYear, int currentYear) {
		for(;initialYear<= currentYear; initialYear++) {
							
			for (int quarter = 1; quarter < 5; quarter ++) {
				List<SalesRecord> tmpSalesRecords = CSVDataSalesRecordManager.findSalesForPartner(pid, initialYear, quarter);
				
				for(Partner partner : subPartners) {
					tmpSalesRecords.addAll(CSVDataSalesRecordManager.findSalesForPartner(partner.getPartnerId(), initialYear, quarter));
				}
				
				
				long rewards = PartnerLevel.computeLevel(tmpSalesRecords.size()).getReward() * tmpSalesRecords.size();
				
				System.out.println(initialYear + " " + quarter + " " + rewards);
			}
		}
		return initialYear;
	}

	private static int getInitialYear(Calendar calendar, SalesRecord firstRecord) {
		calendar.setTime(firstRecord.getSellDate());			
		int initialYear = calendar.get(Calendar.YEAR);
		return initialYear;
	}

	private static int getYearIntervallEnd(Calendar calendar) {
		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
		calendar.setTime(Date.from(instant));			
		int currentYear = calendar.get(Calendar.YEAR);
		return currentYear;
	}

}
