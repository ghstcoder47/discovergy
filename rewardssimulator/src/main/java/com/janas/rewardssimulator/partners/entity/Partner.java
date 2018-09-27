package com.janas.rewardssimulator.partners.entity;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import com.janas.rewardssimulator.partners.boundary.PartnerLevel;

@CsvRecord(name = "partners",  separator = "\\,")
public class Partner implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@DataField(pos = 1, required = true)
	long partnerId;
	
	@DataField(pos = 2 )
	long parentPartnerId;
	
	@DataField(pos = 3, required = true)
	PartnerLevel level;
	
	public Partner(long id, long pid, PartnerLevel l) {
		this.partnerId = id;
		this.parentPartnerId = pid;
		this .level = l;
	}
	
	public long getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	
	public long getParentPartnerId() {
		return this.parentPartnerId;
	}
	
	public PartnerLevel getLevel() {
		return level;
	}
	
	public void setLevel(PartnerLevel level) {
		this.level = level;
	}

}
