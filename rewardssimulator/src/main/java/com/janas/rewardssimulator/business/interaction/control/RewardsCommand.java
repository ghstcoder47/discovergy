package com.janas.rewardssimulator.business.interaction.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.entity.Partner;
import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

public class RewardsCommand {

	public static void perform(StringTokenizer command) {
		
		if (command.countTokens() == 1) {
			/**
			 * pid
			 */
			long pid = Long.parseLong(command.nextToken());
			
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(pid);
			
			List<SalesRecord> subPartnerSalesRecords = null;
			
			//sub partners salesRecords
			for (Partner partner : subPartners) {
				subPartnerSalesRecords = CSVDataSalesRecordManager
						.findSalesForPartner(partner.getPartnerId());
			}
			
			//own salesRecords
			List<SalesRecord> salesRecords = CSVDataSalesRecordManager
					.findSalesForPartner(pid);
			
			//alle salesRecords
			salesRecords.addAll(subPartnerSalesRecords);
			
			
			/**
			 * Calendar calendar = new GregorianCalendar();
				calendar.setTime(sale.getSellDate());
				return calendar.get(Calendar.YEAR) <= year
			 */
			
			do {
				
				
				
			} while(true);
			
			
			
			//year quarter rewards
			//year quarter rewards
			
			
			//get all subParners
			
			// count rewards by subPartners
			
			// count my rewards
			//sum all
		}
		
		if (command.countTokens() == 3) {
			/**
			 * pid year quarter
			 */
			
			long pid = Long.parseLong(command.nextToken());
			int year = Integer.parseInt(command.nextToken());
			int quarter = Integer.parseInt(command.nextToken());
			
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(pid);
			List<SalesRecord> subPartnerSalesRecords = new ArrayList<>();
			
			Calendar calendar = new GregorianCalendar();
			subPartners.stream()
				.forEach( sp -> {
					subPartnerSalesRecords.addAll(CSVDataSalesRecordManager
							.findSalesForPartner(sp.getPartnerId())
								.stream()
								.filter( record -> {
									
									
									calendar.setTime(record.getSellDate());
									return calendar.get(Calendar.YEAR) <= year
											&& computeQuarter(calendar) <= quarter;
								})
								.collect(Collectors.toList())
							);
				});
			
			
			//subPartnerSalesRecords
			
			
		}
	}
	
	private static int computeQuarter(Calendar calendar) {
		return ((calendar.get(Calendar.MONTH)) / 3) + 1;
	}

}
