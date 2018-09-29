package com.janas.rewardssimulator.business.commands.control;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.sales.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sales.entity.SalesRecord;

public class LoadCommand {

	public static void perform(StringTokenizer stringTokenizer) {

		String fileName = stringTokenizer.nextToken();
		List<SalesRecord> salesRecords = CSVDataSalesRecordManager.findAll(fileName);
		CSVDataSalesRecordManager.save(salesRecords);			
	}

}
