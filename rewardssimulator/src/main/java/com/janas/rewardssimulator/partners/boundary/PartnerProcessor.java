package com.janas.rewardssimulator.partners.boundary;

import java.util.stream.Stream;

import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public enum PartnerProcessor {
	
	READ_WRITE(
			Stream
			.of("PartnerId", "ParentPartnerId", "Level")
			.toArray(String[]::new)) {
		
		@Override
		public CellProcessor[] getProcessors() {
			return new CellProcessor[] {
					new ParseLong(), // partnerId;
					new ParseLong(), // parentPartnerId;
					new NotNull(), // levelType;
			};
		}
	};
	
	String[] header;
	
	PartnerProcessor(String[] haeder){
		this.header = haeder;
	}
	
	public String[] getHeader() {
		return header;
	}

	public abstract CellProcessor[] getProcessors();
}
