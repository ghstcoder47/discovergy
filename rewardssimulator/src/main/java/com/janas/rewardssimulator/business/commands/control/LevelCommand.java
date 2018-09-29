package com.janas.rewardssimulator.business.commands.control;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.partners.entity.Partner;
import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;

public class LevelCommand {

	public static void perform(StringTokenizer stringTokenizer) {		
		
		if (stringTokenizer.countTokens() == 3) {
			
			long partnerId = Long.parseLong(stringTokenizer.nextToken());
			int year = Integer.parseInt(stringTokenizer.nextToken());
			int quartal = Integer.parseInt(stringTokenizer.nextToken());
			
			//liste aller subPartner
			List<Partner> subPartners = CSVPartnerManager.findSubPartners(partnerId);
		
			long salesAmount = 0;
			
			// alle verkäufer der subPartner
			for (Partner partner : subPartners) {
				salesAmount += CSVDataSalesRecordManager
						.countSalesForPartner(partner.getPartnerId(), year, quartal);
			}
			
			// ergänzt um partner sales
			salesAmount += CSVDataSalesRecordManager
					.countSalesForPartner(partnerId, year, quartal);
			
			
			System.out.println(PartnerLevel.computeLevel(salesAmount));
			
		} else {
			System.out.println("LEVEL command nicht korrekt: " + stringTokenizer.toString());
		}
		
		
	}

}
