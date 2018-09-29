package com.janas.rewardssimulator;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.sale.boundary.CSVDataSalesRecordManager;
import com.janas.rewardssimulator.business.sale.entity.SalesRecord;

public class LoadCommand {

	public static void perform(StringTokenizer stringTokenizer) {

		String fileName = stringTokenizer.nextToken();
		List<SalesRecord> salesRecords = CSVDataSalesRecordManager.findAll(fileName);
		CSVDataSalesRecordManager.save(salesRecords);
	}

}
