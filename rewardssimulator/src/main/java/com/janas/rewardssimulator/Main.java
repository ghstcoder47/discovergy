package com.janas.rewardssimulator;

import java.util.Scanner;

import com.janas.rewardssimulator.business.commands.control.CommandIdentifier;

public class Main {

	public static void main(String[] args) {

		String inputString;

		try(Scanner scanIn = new Scanner(System.in);) {
			
			while(true) {
				inputString = scanIn.nextLine();
				
				if (inputString.equals("quit")) {
					break;
				}
				
				if (inputString.length() > 0) {					
					CommandIdentifier.identify(inputString);
				}
			}
		}

//		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
//
//		List<SalesRecord> salesRecords = new ArrayList<>();		
//		salesRecords.add(new SalesRecord(1, 1, ContractType.RABBIT, Date.from(instant), ContractAction.BEGIN));
//		salesRecords.add(new SalesRecord(2, 2, ContractType.TORTOISE, Date.from(instant),ContractAction.BEGIN));
//		salesRecords.add(new SalesRecord(1, 3, ContractType.TORTOISE, Date.from(instant), ContractAction.BEGIN));
//
//		List<Partner> partners = new ArrayList<>();
//		partners.add(new Partner(1, PartnerLevel.ANT));
//		partners.add(new Partner(2, PartnerLevel.BEE));
//		partners.add(new Partner(3, 2, PartnerLevel.ANT));
//
//		CSVPartnerManager.save(partners);
//
//		CSVPartnerManager.findAll().stream().map(partner -> partner.getLevel()).forEach(System.out::println);
//
//		CSVDataSalesRecordManager.save(salesRecords);
//
//		CSVDataSalesRecordManager.findAll().stream().map(salesRecord -> salesRecord.getSellDate())
//				.forEach(System.out::println);

	}

}
