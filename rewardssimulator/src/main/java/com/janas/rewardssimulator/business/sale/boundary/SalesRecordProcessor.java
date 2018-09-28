package com.janas.rewardssimulator.business.sale.boundary;

import java.util.stream.Stream;

import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * 
 * @author janasd
 *
 * CSVCellProcessor bietet CellProcessor Singletons
 * zum verarbeiten von CSV Daten 
 * für lesen und schreiben mit dem super CSV Framework
 */

public enum SalesRecordProcessor {
		
	WRITE(
			Stream
			.of("PartnerId", "ContractId", "ContractType", "SellDate", "Action")
			.toArray(String[]::new)) {
		
		@Override
		public CellProcessor[] getProcessors() {
			return new CellProcessor[] {
					new ParseLong(), // partnerId;
					new ParseLong(), // contractId;
					new NotNull(), // contractType;
					new FmtDate(DEFAULT_DATEFORMAT), // sellDate;
					new NotNull() // action;	
			};
		}
	}, 
	READ(
			Stream
			.of("PartnerId", "ContractId", "ContractType", "SellDate", "Action")
			.toArray(String[]::new)) {
		
		@Override
		public CellProcessor[] getProcessors() {
			return new CellProcessor[] {
					new ParseLong(), // partnerId;
					new ParseLong(), // contractId;
					new NotNull(), // contractType;
					new ParseDate(DEFAULT_DATEFORMAT), // sellDate;
					new NotNull() // action;	
			};
		}
	}; 
	
	public final String DEFAULT_DATEFORMAT = "dd.MM.yyyy";
	
	String[] header;
				
	SalesRecordProcessor(String[] haeder){
		this.header = haeder;
	}
	
	public String[] getHeader() {
		return header;
	}
	
	public abstract CellProcessor[] getProcessors();

}
