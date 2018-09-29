package com.janas.rewardssimulator.business.partners.entity;

import java.io.Serializable;

import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;

public class Partner implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	
	long partnerId;	
	long parentPartnerId;
	PartnerLevel level;
	
	public Partner() {
		
	}	
	
	public Partner(long partnerId) {
		super();
		this.partnerId = partnerId;
		this.level = PartnerLevel.ANT;
	}
		
	public Partner(long partnerId, long parentPartnerId) {
		super();
		this.partnerId = partnerId;
		this.parentPartnerId = parentPartnerId;
		this.level = PartnerLevel.ANT;
	}

	public long getParentPartnerId() {
		return parentPartnerId;
	}

	public void setParentPartnerId(long parentPartnerId) {
		this.parentPartnerId = parentPartnerId;
	}

	public long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}

	public PartnerLevel getLevel() {
		return level;
	}

	public void setLevel(PartnerLevel level) {
		this.level = level;
	}

	

}
