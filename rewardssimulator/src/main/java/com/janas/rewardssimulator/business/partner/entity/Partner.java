package com.janas.rewardssimulator.business.partner.entity;

import java.io.Serializable;

import com.janas.rewardssimulator.partners.entity.PartnerLevel;

public class Partner implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	
	long partnerId;	
	long parentPartnerId;	
	PartnerLevel level;
	
	public Partner() {
		
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
