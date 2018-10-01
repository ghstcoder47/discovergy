package com.janas.rewardssimulator.business.interaction.control;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.partners.entity.Partner;
import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;

public class LevelCommand {
	
	private static final int EXPECTED_COMAND_COUNT = 3;

	public static void perform(StringTokenizer stringTokenizer) {	
				
		if (stringTokenizer.countTokens() == EXPECTED_COMAND_COUNT) {
			
			long partnerId = Long.parseLong(stringTokenizer.nextToken());
			int year = Integer.parseInt(stringTokenizer.nextToken());
			int quartal = Integer.parseInt(stringTokenizer.nextToken());
			
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(partnerId);
								
			long salesAmount = 0;
			
			for (Partner partner : subPartners) {
				salesAmount += CSVDataSalesRecordManager
						.findSalesForPartner(partner.getPartnerId(), year, quartal).size();
			}
			
			salesAmount += CSVDataSalesRecordManager
					.findSalesForPartner(partnerId, year, quartal).size();
			
			System.out.println(PartnerLevel.computeLevel(salesAmount));
			
		} else {
			System.out.println("LEVEL command nicht korrekt: " + stringTokenizer.toString());
		}
				
		
	}

}
