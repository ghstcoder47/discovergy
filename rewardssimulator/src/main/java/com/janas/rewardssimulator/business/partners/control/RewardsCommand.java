package com.janas.rewardssimulator.business.partners.control;

import java.util.List;
import java.util.StringTokenizer;

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
			
			salesRecords.addAll(subPartnerSalesRecords);
			
			for (SalesRecord sRecord : salesRecords) {
				System.out.println(sRecord.getContractType().getValue());
				System.out.println(sRecord.getSellDate());
			}
			
			
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
		}
	}

}
