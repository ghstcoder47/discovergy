package com.janas.rewardssimulator.business.partners.boundary;

import java.util.stream.Stream;

import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.janas.rewardssimulator.business.partners.boundary.csvutils.ParsePartnerLevel;

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
					new ParsePartnerLevel(), // levelType;
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
